package com.companypowernode.service.impl;
import com.rabbitmq.client.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
    public class PredictionServiceImpl {
        private String predictionResult;


        public void consumePredictionResult(String tsCode,String start_date,String end_date) throws Exception {
            String url="D:\\Javaproj\\company\\src\\main\\resources\\py\\predict5.0(mq).py";
            PythonExecuterServiceImpl pythonExecuter=new PythonExecuterServiceImpl();

            pythonExecuter.executePythonScript(url,tsCode,start_date,end_date);

            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("my_queue", false, false, false, null);

            Consumer consumer = new DefaultConsumer(channel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    String prediction = new String(body, "UTF-8");
                    predictionResult = prediction;
                    System.out.println(predictionResult);
                }
            };

            channel.basicConsume("my_queue", true, consumer);
        }

        public String getPredictionResult(String tsCode,String start_date,String end_date) throws Exception {
            this.consumePredictionResult(tsCode,start_date,end_date);
            return predictionResult;
        }
    }


