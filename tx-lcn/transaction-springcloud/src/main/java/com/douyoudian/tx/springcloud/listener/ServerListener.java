package com.douyoudian.tx.springcloud.listener;

import com.douyoudian.tx.service.InitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class ServerListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    private Logger logger = LoggerFactory.getLogger(ServerListener.class);

    private int serverPort;

    @Autowired
    private InitService initService;


    public int getPort() {
        return this.serverPort;
    }
    
    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {

        logger.info("onApplicationEvent -> onApplicationEvent. "+event.getWebServer());

        this.serverPort = event.getWebServer().getPort();
        initService.start();
    }
}
