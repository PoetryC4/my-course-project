package com.companypowernode.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.companypowernode.common.utils.Tushare;

import com.companypowernode.dao.mapper.TotalRevenueMapper;
import com.companypowernode.service.TotalRevenueService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.TreeMap;
@Slf4j
@Service
public class TotalRevenueServiceImpl extends ServiceImpl<TotalRevenueMapper, TreeMap<Integer,Double>>  implements  TotalRevenueService{
    //获取的数据分为四种，近五年的一季度数据，近五年的中报数据，近五年的三季度数据，近五年的年报数据
    public TreeMap<Integer, Double> getRevenues(String tsCode, String endType) {
        TreeMap<Integer, Double> revenues = new TreeMap<>();
        //先判断类型：end_type:1代表一季度，2代表中报，3代表三季度，4代表年报。对应时间为0331，0630，0930，1231
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        for(int i=1;i<=5;i++){
            int year = currentYear - i;
            Double revenue = null;
            try {
                revenue = getRevenue(year,tsCode,endType);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            revenues.put(year,revenue);
            //System.out.println(revenue);
        }
        return revenues;
    }

    private Double getRevenue(int year,String tsCode, String endType) throws JsonProcessingException {
        //利用tushareApi获取数据先
        String period = null;
        if (endType.equals("1")) period = Integer.toString(year) + "0331";
        if (endType.equals("2")) period = Integer.toString(year) + "0630";
        if (endType.equals("3")) period = Integer.toString(year) + "0930";
        if (endType.equals("4")) period = Integer.toString(year) + "1231";
        //System.out.println(endDate);
        String revenueData = Tushare.tushareApi("income", "ts_code=" + tsCode, "period=" + period);
        //System.out.println(revenueData);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(revenueData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        JsonNode itemsNode = jsonNode.get("data").get("items");
        //System.out.println(itemsNode);

        Object[][] data = mapper.readValue(itemsNode.toString(), Object[][].class);
        Object value = data[0][9];
        Double revenue = Double.parseDouble(value.toString());
        //System.out.println("Numeric Value: " + revenue);
        return revenue;
    }
}
