package org.example;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {
    public Courier genericNoPassword(){
        return new Courier("Kek","Sparrow");
    }
    public Courier genericNoLogin(){
        return new Courier("password");
    }
    public Courier random(){
        return new Courier(RandomStringUtils.randomAlphabetic(10),"passwod","Sparrow");
    }
}
