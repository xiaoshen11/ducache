package com.bruce.ducache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @date 2024/6/12
 */
@Component
public class DuApplicationListener implements ApplicationListener<ApplicationEvent> {

    @Autowired
    List<DuPlugin> plugins;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationReadyEvent are) {
            for (DuPlugin plugin : plugins) {
                plugin.init();
                plugin.startup();
            }

        } else if (event instanceof ContextClosedEvent cce) {
            for (DuPlugin plugin : plugins) {
                plugin.shutdown();
            }
        }
    }
}
