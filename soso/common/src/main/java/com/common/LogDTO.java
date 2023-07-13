package com.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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
