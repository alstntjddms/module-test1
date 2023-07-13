package com.common;

import com.common.restapi.AsyncRestAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogFactory {
    @Autowired AsyncRestAPI asyncRestAPI;
    public Log createLog(Class<?> clazz) {
        return new Log(clazz.getSimpleName(), this.asyncRestAPI);
    }
}
