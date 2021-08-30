package com.mangxiao.sample.webflux.util;

import java.util.Random;

public class NumberUtil {

    private static final Integer MAX_VALUE = 100000;
    private static final Integer MIN_VALUE = 0;

    public static int generateId(){

        Random random = new Random();
        int v = random.nextInt(MAX_VALUE)%(MAX_VALUE - MIN_VALUE+1) + MIN_VALUE;
        return v;
    }
}
