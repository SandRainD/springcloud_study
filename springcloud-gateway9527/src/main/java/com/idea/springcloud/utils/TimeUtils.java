package com.idea.springcloud.utils;

import java.time.ZonedDateTime;

public class TimeUtils {
    public ZonedDateTime time(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
        return now;
    }
}
