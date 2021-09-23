package com.zuson.demo.strawVideo.controller;

import com.zuson.demo.strawVideo.service.SVService;
import com.zuson.demo.strawVideo.service.impl.ExceptionUtils;
import com.zuson.demo.strawVideo.service.impl.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
public class task implements SchedulingConfigurer {

    @Autowired
    SVService svService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(() ->{
            LogUtils.info("执行定时任务【START】 == applyToken ====");
            try {
                svService.applyToken();
            } catch (Exception e) {
                LogUtils.error("applyToken 异常："+ ExceptionUtils.getStackTraceAsString(e));
            }
            LogUtils.info("执行定时任务【END】 == applyToken ====");
        }, TriggerContext->{
            return new CronTrigger("30/0 * * * * ?").nextExecutionTime(TriggerContext);
        });
    }
}
