package com.example.CompConf.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@Configuration
@EnableAspectJAutoProxy
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Creating bean: {}", bean);
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("After creating: {}", bean);
        return bean;
    }

}
