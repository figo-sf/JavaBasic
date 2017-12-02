package com.figo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 50245 on 2017/9/12.
 */
public class ConfigTest {
    @Autowired
    ServerCfg cfg;

    public static void main(String[] args) {
       // System.out.println(cfg.toString());
    }
}
