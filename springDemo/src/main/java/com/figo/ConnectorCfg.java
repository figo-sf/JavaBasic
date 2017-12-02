package com.figo;

import lombok.Data;

/**
 * Created by 50245 on 2017/9/12.
 */
@Data
public class ConnectorCfg {
    private int port = 8080;
    private String protocol = "HTTP/1.1";

    public void setPort(int port) {
        this.port = port;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
