package com.companypowernode.common.config;

import com.companypowernode.component.QJob;
import org.quartz.DateBuilder;
import org.quartz.JobDataMap;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

import java.util.Date;

/**
 * @author liyue
 * @since 2023-12-09
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean(){
        JobDetailFactoryBean bean = new JobDetailFactoryBean();
        //关联job
        bean.setJobClass(QJob.class);;
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("date","2023-12-09");
        bean.setJobDataMap(jobDataMap);
        return bean;
    }
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(){
//        SimpleTriggerFactoryBean bean = new SimpleTriggerFactoryBean();
//        //时间配置
//        Date startTime = DateBuilder.dateOf(9,0,0);
//        Date endTime = DateBuilder.dateOf()
//        bean.setRepeatInterval(2000);
//        //关联jobdetail
//        bean.setJobDetail(jobDetailFactoryBean().getObject());
//        return bean;
//    }
    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setCronExpression("*/5 * 9,10,11,12,13,14,15 ? * 1,2,3,4,5 *");
        //bean.setCronExpression("0/2 * * * * ?");
        bean.setJobDetail(jobDetailFactoryBean().getObject());
        return bean;
    }
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerFactoryBean().getObject());
        return bean;
    }
}
