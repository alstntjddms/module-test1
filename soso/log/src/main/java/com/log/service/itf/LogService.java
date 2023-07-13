package com.log.service.itf;

import com.common.LogDTO;

import java.util.List;

public interface LogService {
    public LogDTO info(LogDTO logDTO) throws Exception;
    public LogDTO warn(LogDTO logDTO);
    public LogDTO debug(LogDTO logDTO);

}
