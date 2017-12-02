package com.figo;

import lombok.Data;

import java.util.List;

/**
 * Created by 50245 on 2017/9/12.
 */
@Data
public class ServiceCfg {
    private String name;
    private List<ConnectorCfg> connectors;

    public void setName(String name) {
        this.name = name;
    }

    public void setConnectors(List<ConnectorCfg> connectors) {
        this.connectors = connectors;
    }
}
