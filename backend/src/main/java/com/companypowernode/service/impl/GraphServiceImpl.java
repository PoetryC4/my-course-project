package com.companypowernode.service.impl;

import com.companypowernode.common.utils.Tushare;
import com.companypowernode.dao.vo.reqVO.GraphReqVO;
import com.companypowernode.dao.vo.respVO.GraphRespVO;
import com.companypowernode.dao.vo.respVO.ListRespVO;
import com.companypowernode.service.GraphService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author liyue
 * @since 2023-12-18
 */
@Service
public class GraphServiceImpl implements GraphService {
    @Override
    public Set<GraphRespVO> getNincome(GraphReqVO reqVO) throws Exception{
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        Set<GraphRespVO> resp = new LinkedHashSet<>();

        for (int i = 0;i<5;i++){
            int year = currentYear - i;
            List<String> fields = new ArrayList<>();
            fields.add("end_date");
            fields.add(reqVO.getField());
            Map<String,String> params = new HashMap<>();
            //股票代码
            params.put("ts_code",reqVO.getTsCode());
            //查询时间范围
//        if (!reqVO.getEndDate().isEmpty()){
//            params.put("start_date",reqVO.getStartDate());
//        }
//        if (!reqVO.getStartDate().isEmpty()){
//            params.put("end_date",reqVO.getEndDate());
//        }


            String period = null;
            if (reqVO.getEndType().equals("1")) period = year + "0331";
            if (reqVO.getEndType().equals("2")) period = year + "0630";
            if (reqVO.getEndType().equals("3")) period = year + "0930";
            if (reqVO.getEndType().equals("4")) period = year + "1231";
            params.put("period",period);

            String data = Tushare.tushareApi(reqVO.getGraphType(),params,fields);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode;

            try {
                jsonNode = mapper.readTree(data);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            JsonNode itemsNode = jsonNode.get("data").get("items");

            Iterator<JsonNode> elements = itemsNode.elements();
            while (elements.hasNext()){
                GraphRespVO n = new GraphRespVO();
                JsonNode jsonNode1 = elements.next();
                BigDecimal str = new BigDecimal(jsonNode1.get(1).doubleValue());

                n.setData(str.setScale(2,BigDecimal.ROUND_HALF_UP).toString());

                //yyyyMMdd转换
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
                Date date = format.parse(jsonNode1.get(0).toString().replaceAll("\"",""));
                n.setEndDate(format2.format(date));
                resp.add(n);
            }
        }

        return resp;
    }

}
