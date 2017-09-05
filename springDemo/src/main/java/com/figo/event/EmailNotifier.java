package com.figo.event;


import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

/**
 * Title: email之监听类
 * 容器事件的监听器类必须实现ApplicationListener接口，实现该接口就必须实现
 * Description: dataPlatfrom
 *
 * @author: xg.chen
 * @date:2016年8月24日
 */
public class EmailNotifier implements ApplicationListener<ApplicationEvent> {

    @Async
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof EmailEvent) {
            EmailEvent emailEvent = (EmailEvent) event;
            System.out.println("email's address:" + emailEvent.getAddress());
            System.out.println("email's text:" + emailEvent.getText());
        } else {
            System.out.println("the Spring's event:" + event);
        }
    }

}