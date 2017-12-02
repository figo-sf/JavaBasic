package com.figo;

import lombok.Data;

import java.util.List;

/**
 * Created by 50245 on 2017/9/12.
 */
@Data
public class ServerCfg {
    private int port = 8005;
    private String shutDown = "SHUTDOWN";
    private List<ServiceCfg> services;

    public void setServices(List<ServiceCfg> services) {
        this.services = services;
    }
}
