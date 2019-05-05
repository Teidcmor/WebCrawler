package common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

public class SpringContextUtils implements ApplicationContextAware {

    private static ApplicationContext appContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.appContext = applicationContext;
    }

    public static ApplicationContext getAppContext() {
        return appContext;
    }
}
