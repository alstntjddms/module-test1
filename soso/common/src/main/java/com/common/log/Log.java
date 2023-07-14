package com.common.log;

import com.common.restapi.AsyncRestAPI;

public class Log {
    private String className;
    private AsyncRestAPI asyncRestAPI;
    public Log(String className, AsyncRestAPI asyncRestAPI) {
        this.className = className;
        this.asyncRestAPI = asyncRestAPI;
    }
    public void debug(String methodName, String log) {
        asyncRestAPI.post("http://localhost:8080/api/log/debug", new LogDTO(className, methodName, log), LogDTO.class).subscribe();
    }
    public void info(String methodName, String log) {
        asyncRestAPI.post("http://localhost:8080/api/log/info", new LogDTO(className, methodName, log), LogDTO.class).subscribe();
    }
    public void warn(String methodName, String log) {
        asyncRestAPI.post("http://localhost:8080/api/log/warn", new LogDTO(className, methodName, log), LogDTO.class).subscribe();
    }
}
