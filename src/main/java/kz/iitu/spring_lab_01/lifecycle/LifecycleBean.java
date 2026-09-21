package kz.iitu.spring_lab_01.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class LifecycleBean implements BeanNameAware, InitializingBean, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(LifecycleBean.class);

    public LifecycleBean() {
        log.info("LIFECYCLE >> 1. Constructor called");
    }

    @Override
    public void setBeanName(String name) {
        log.info("LIFECYCLE >> 2. BeanNameAware.setBeanName('{}')", name);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("LIFECYCLE >> 3. @PostConstruct method called");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("LIFECYCLE >> 4. InitializingBean.afterPropertiesSet() called");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("LIFECYCLE >> 5. @PreDestroy method called");
    }

    @Override
    public void destroy() {
        log.info("LIFECYCLE >> 6. DisposableBean.destroy() called");
    }
}