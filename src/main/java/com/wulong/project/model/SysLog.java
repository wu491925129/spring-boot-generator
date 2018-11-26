package com.wulong.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "sys_log")
public class SysLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 用户昵称
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 日志类型
     */
    private String type;

    private String tag;

    /**
     * 执行类
     */
    private String src;

    /**
     * 请求ip
     */
    private String ip;

    /**
     * 操作人id
     */
    @Column(name = "op_user_id")
    private String opUserId;

    /**
     * 操作人用户名
     */
    @Column(name = "op_user_name")
    private String opUserName;

    /**
     * 操作时间
     */
    @Column(name = "op_time")
    private Date opTime;

    /**
     * 日志内容
     */
    private String msg;

    /**
     * 请求参数
     */
    private String param;

    /**
     * 执行结果
     */
    private String result;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户昵称
     *
     * @return display_name - 用户昵称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置用户昵称
     *
     * @param displayName 用户昵称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取日志类型
     *
     * @return type - 日志类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置日志类型
     *
     * @param type 日志类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取执行类
     *
     * @return src - 执行类
     */
    public String getSrc() {
        return src;
    }

    /**
     * 设置执行类
     *
     * @param src 执行类
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * 获取请求ip
     *
     * @return ip - 请求ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置请求ip
     *
     * @param ip 请求ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取操作人id
     *
     * @return op_user_id - 操作人id
     */
    public String getOpUserId() {
        return opUserId;
    }

    /**
     * 设置操作人id
     *
     * @param opUserId 操作人id
     */
    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId;
    }

    /**
     * 获取操作人用户名
     *
     * @return op_user_name - 操作人用户名
     */
    public String getOpUserName() {
        return opUserName;
    }

    /**
     * 设置操作人用户名
     *
     * @param opUserName 操作人用户名
     */
    public void setOpUserName(String opUserName) {
        this.opUserName = opUserName;
    }

    /**
     * 获取操作时间
     *
     * @return op_time - 操作时间
     */
    public Date getOpTime() {
        return opTime;
    }

    /**
     * 设置操作时间
     *
     * @param opTime 操作时间
     */
    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    /**
     * 获取日志内容
     *
     * @return msg - 日志内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置日志内容
     *
     * @param msg 日志内容
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取请求参数
     *
     * @return param - 请求参数
     */
    public String getParam() {
        return param;
    }

    /**
     * 设置请求参数
     *
     * @param param 请求参数
     */
    public void setParam(String param) {
        this.param = param;
    }

    /**
     * 获取执行结果
     *
     * @return result - 执行结果
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置执行结果
     *
     * @param result 执行结果
     */
    public void setResult(String result) {
        this.result = result;
    }
}