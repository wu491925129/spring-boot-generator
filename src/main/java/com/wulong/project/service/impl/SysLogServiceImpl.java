package com.wulong.project.service.impl;

import com.wulong.project.dao.SysLogMapper;
import com.wulong.project.model.SysLog;
import com.wulong.project.service.SysLogService;
import com.wulong.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/20.
 */
@Service
@Transactional
public class SysLogServiceImpl extends AbstractService<SysLog> implements SysLogService {
    @Resource
    private SysLogMapper sysLogMapper;

}
