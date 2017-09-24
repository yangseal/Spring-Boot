package com.conf.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by Administrator on 2017/5/10 0010.
 */
@ConfigurationProperties(prefix = "email")
public class EmailProp {
    private String host;
    private  String  port;
    private  String   from;
    private  String   smtPauth;
    private  String  fromPassword;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String  getPort() {
        return port;
    }

    public void setPort(String  port) {
        this.port = port;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSmtPauth() {
        return smtPauth;
    }

    public void setSmtPauth(String smtPauth) {
        this.smtPauth = smtPauth;
    }

    public String getFromPassword() {
        return fromPassword;
    }

    public void setFromPassword(String fromPassword) {
        this.fromPassword = fromPassword;
    }

    @Override
    public String toString() {
        return "Enviroment{" +
                "host='" + host + '\'' +
                ", port=" + port +
                ", from='" + from + '\'' +
                ", smtPauth='" + smtPauth + '\'' +
                ", fromPassword='" + fromPassword + '\'' +
                '}';
    }

}


