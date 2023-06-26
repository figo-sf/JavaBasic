package com.figo;

public interface PackableEx extends Packable {
    void unmarshal(ByteBuf in);
}