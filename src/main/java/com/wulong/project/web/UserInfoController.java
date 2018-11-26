package com.wulong.project.web;
import com.wulong.project.core.Result;
import com.wulong.project.core.ResultGenerator;
import com.wulong.project.model.UserInfo;
import com.wulong.project.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wulong.project.slog.SLog;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * @Author:wulong
 * @Date:2018/11/19 14:25
 * @mail:491925129@qq.com
 * @CrossOrigin 注解 支持跨域
 * @Transactional 事务
*/
@CrossOrigin
@Transactional(rollbackFor = Exception.class)
@RestController
@RequestMapping("/user/info")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/regist")
    @SLog(type = "regist",tag = "用户注册",msg = "用户注册")
    public Result add(@RequestBody(required = false) UserInfo userInfo) {
        userInfo.setUserId(UUID.randomUUID().toString().replace("-",""));
    	userInfoService.save(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        userInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(UserInfo userInfo) {
        userInfoService.update(userInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        UserInfo userInfo = userInfoService.findById(id);
        return ResultGenerator.genSuccessResult(userInfo);
    }

    @PostMapping("/list")
    @SLog(type = "user",tag = "用户信息",msg = "获取用户列表信息")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<UserInfo> list = userInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
