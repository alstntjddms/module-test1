package com.common;

import com.common.restapi.AsyncRestAPI;

public class Log {
    private String className;
    private AsyncRestAPI asyncRestAPI;
    public Log(String className, AsyncRestAPI asyncRestAPI) {
        this.className = className;
        this.asyncRestAPI = asyncRestAPI;
    }

    public void info(String methodName, String log) {
        System.out.println("methodName = " + methodName);
        System.out.println("log = " + log);
        asyncRestAPI.post("http://localhost:8080/api/log/info", new LogDTO(className, methodName, log), LogDTO.class);
    }
}
