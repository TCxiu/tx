package com.douyoudian.tm.listener;

import com.douyoudian.tm.Constants;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * create by lorne on 2017/8/7
 */
@Component
public class ApplicationStartListener implements ApplicationListener<ServletWebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(ServletWebServerInitializedEvent event) {
        int serverPort = event.getWebServer().getPort();
        String ip = getIp();
        Constants.address = ip+":"+serverPort;
    }

    private String getIp(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host;
    }


}
