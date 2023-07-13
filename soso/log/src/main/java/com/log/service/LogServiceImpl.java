package com.log.service;

import com.common.LogDTO;
import com.log.controller.LogController;
import com.log.service.itf.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    private final static Logger log = LoggerFactory.getLogger(LogServiceImpl.class);

    @Override
    public LogDTO info(LogDTO logDTO) throws Exception {
        try{
            log.info(logToString(logDTO));
            return logDTO;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public LogDTO warn(LogDTO logDTO) {
        return null;
    }

    @Override
    public LogDTO debug(LogDTO logDTO) {
        return null;
    }

    private String logToString(LogDTO logDTO){
        return "[" + logDTO.getClassName() + "]"
                + " " + "[" + logDTO.getMethodName() + "]"
                + " " + logDTO.getLog();
    }
}
