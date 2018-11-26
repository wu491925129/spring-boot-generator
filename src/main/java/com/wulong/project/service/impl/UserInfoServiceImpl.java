package com.wulong.project.service.impl;

import com.wulong.project.dao.UserInfoMapper;
import com.wulong.project.model.UserInfo;
import com.wulong.project.service.UserInfoService;
import com.wulong.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/11/21.
 */
@Service
@Transactional
public class UserInfoServiceImpl extends AbstractService<UserInfo> implements UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

}
