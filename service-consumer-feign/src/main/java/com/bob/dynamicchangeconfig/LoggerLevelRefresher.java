package com.bob.dynamicchangeconfig;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener;
import org.springframework.beans.BeansException;
import org.springframework.cloud.context.environment.EnvironmentChangeEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

@Service
public class LoggerLevelRefresher implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @ApolloConfig
    private Config config;

    @PostConstruct
    private void initialize() {
        refreshLoggingLevels(config.getPropertyNames());
    }

    @ApolloConfigChangeListener
    private void onChange(ConfigChangeEvent changeEvent) {
        refreshLoggingLevels(changeEvent.changedKeys());
    }

    private void refreshLoggingLevels(Set<String> changedKeys) {
        boolean loggingLevelChanged = false;
        for (String changedKey : changedKeys) {
            if (changedKey.startsWith("logging.level.")) {
                loggingLevelChanged = true;
                break;
            }
        }

        if (loggingLevelChanged) {
            //System.out.println("Refreshing logging levels");

            /**
             * refresh logging levles
             * @see org.springframework.cloud.logging.LoggingRebinder#onApplicationEvent
             */
            this.applicationContext.publishEvent(new EnvironmentChangeEvent(changedKeys));

            //System.out.println("Logging levels refreshed");
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
