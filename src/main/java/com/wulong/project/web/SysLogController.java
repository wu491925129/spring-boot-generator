package com.wulong.project.web;
import com.wulong.project.core.Result;
import com.wulong.project.core.ResultGenerator;
import com.wulong.project.model.SysLog;
import com.wulong.project.service.SysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/11/20.
*/
@RestController
@RequestMapping("/sys/log")
public class SysLogController {
    @Resource
    private SysLogService sysLogService;

    @PostMapping("/add")
    public Result add(SysLog sysLog) {
        sysLogService.save(sysLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysLogService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(SysLog sysLog) {
        sysLogService.update(sysLog);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysLog sysLog = sysLogService.findById(id);
        return ResultGenerator.genSuccessResult(sysLog);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysLog> list = sysLogService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
