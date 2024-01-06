package com.companypowernode.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.companypowernode.dao.vo.baseVO.Result;
import com.companypowernode.dao.entity.PridictRe;
import com.companypowernode.service.IPridictReService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 待完善：预测不同股票，code为参数传入python；根据时间给出合适的预测数据
 */
@RestController
@RequestMapping("/sys/python")
public class PythonController {

    @Autowired
    private IPridictReService iPridictReService;

    private static String pyPath1 = "D:\\Javaproj\\company\\src\\main\\resources\\py\\test.py";
    private static String pyPath2 = "D:\\Javaproj\\company\\src\\main\\resources\\py\\predict5.0.py";
    private static String pyPath3 = "D:\\Javaproj\\company\\src\\main\\resources\\py\\test2.py";
    private static String exePath = "C:\\Users\\34835\\AppData\\Local\\Programs\\Python\\Python38\\python.exe";

    /**
     * 返回预测七天结果
     * @param id
     * @return
     */
    @GetMapping("/pridict")
    public Result<Object> pridict(String id){
        LambdaQueryWrapper<PridictRe> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(PridictRe::getTsCode,id);
        List<PridictRe> record = iPridictReService.list(queryWrapper);
        return Result.success(record);
    }

    /**
     * 获得预测数据
     * @throws IOException
     * @throws InterruptedException
     */
    @GetMapping("/getpridata")
    public void getpridata() throws IOException, InterruptedException {
        String[] args1 =new String[]{exePath,pyPath2};
        Process proc = Runtime.getRuntime().exec(args1);
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String re = null;
        int count = 2;//跳过前两行
        int end = 0;//不读最后一行
        int N = 5;

        while ((re=in.readLine()) != null){
            end++;
            System.out.println(end);
            if (count!=0){
                count--;
                continue;
            }
            if (end==10){
                return;
            }
            PridictRe pridictRe = new PridictRe();//新建保存的对象
//            String[] strs =re.split("\n");
//            System.out.println(strs);

            String[] strsnode = re.split("  ");//分割
            //System.out.println(strsnode.length);
            Float[] f = new Float[N];
                for (int j = 1; j < N; j++){
//                  f[j] = Float.valueOf(strs[j]).floatValue();
                    f[j] = Float.parseFloat(strsnode[j]);//String转化Float
                    System.out.println(strsnode[j]);
                }
                //赋值
                pridictRe.setReDate(strsnode[0]);
                pridictRe.setReOpen(f[1]);
                pridictRe.setReClose(f[2]);
                pridictRe.setReHigh(f[3]);
                pridictRe.setReLow(f[4]);
                pridictRe.setTsCode(strsnode[5]);
                System.out.println(pridictRe);

                //保存
                iPridictReService.save(pridictRe);



            System.out.println(re);
        }
        in.close();
        proc.waitFor();
    }


}
