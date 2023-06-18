package com.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Common {
    private static final Logger log = LoggerFactory.getLogger(Common.class);

    public String com(){
        log.info("common");

        return "zzzz";
    }
}
