package com.companypowernode.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;
@Service
public class PythonExecuterServiceImpl {
    private static String exePath = "C:\\Users\\34835\\AppData\\Local\\Programs\\Python\\Python38\\python.exe";

    public PythonExecuterServiceImpl() {
    }

    public static String executePythonScript(String scriptPath,String tsCode,String start_date,String end_date) throws IOException, InterruptedException {
        // 构建执行命令
        String[] command = {exePath, scriptPath,tsCode,start_date,end_date};

        // 执行命令
        Process process = Runtime.getRuntime().exec(command);

        // 创建输入流读取 Python 脚本的输出
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // 阻塞等待 Python 脚本执行完成并获取结果
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line);
        }

        // 等待 Python 脚本执行完成
        if (process.waitFor(100, TimeUnit.SECONDS)) {
            // 脚本执行成功，返回结果
            return output.toString();

        } else {
            // 脚本执行超时或出错，抛出异常或返回错误信息
            throw new RuntimeException("Python script execution timeout or error.");
        }
    }
}
