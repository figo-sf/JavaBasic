package com.figo.javabaisc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: figo sffchxd@qq.com
 * @Date: 2018/12/12 09:36
 * @Description: //todo
 */
public class Music {

    public static void main(String[] args) {
        List<Instrument> instruments = new ArrayList<>();
        instruments.add(new Wind());
        instruments.add(new Percussion());
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}


