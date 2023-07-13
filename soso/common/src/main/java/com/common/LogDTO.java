package com.common;

import lombok.Data;

@Data
public class LogDTO {
    String className;
    String methodName;
    String log;

    public LogDTO(String className, String methodName, String log) {
        this.className = className;
        this.methodName = methodName;
        this.log = log;
    }
}
