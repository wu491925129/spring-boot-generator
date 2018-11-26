package com.wulong.project.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(name = "user_id")
    private String userId;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 金币
     */
    private Integer gold;

    /**
     * 积分等级
     */
    @Column(name = "my_level")
    private Integer myLevel;

    /**
     * 是否在线
     */
    @Column(name = "on_line")
    private Byte onLine;

    /**
     * 是否禁用
     */
    private Byte disable;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String mobile;

    /**
     * 登陆时间
     */
    @Column(name = "login_time")
    private Date loginTime;

    /**
     * 登陆ip地址
     */
    @Column(name = "login_ip")
    private String loginIp;

    /**
     * 登陆次数
     */
    @Column(name = "login_count")
    private Integer loginCount;

    /**
     * 主题
     */
    @Column(name = "login_theme")
    private String loginTheme;

    /**
     * 操作人id
     */
    @Column(name = "op_user_id")
    private String opUserId;

    /**
     * 操作人姓名
     */
    @Column(name = "op_user_name")
    private String opUserName;

    /**
     * 操作时间
     */
    @Column(name = "op_time")
    private Date opTime;

    /**
     * 删除标记
     */
    @Column(name = "del_flag")
    private Byte delFlag;

    /**
     * 登陆国家
     */
    private String country;

    /**
     * 登陆城市
     */
    private String city;

    /**
     * 登陆省份
     */
    private String region;

    /**
     * 登陆运营商
     */
    private String isp;

    /**
     * 国家id
     */
    @Column(name = "country_id")
    private String countryId;

    /**
     * 省份id
     */
    @Column(name = "region_id")
    private String regionId;

    /**
     * 城市id
     */
    @Column(name = "city_id")
    private String cityId;

    /**
     * 运营商id
     */
    @Column(name = "isp_id")
    private String ispId;

    /**
     * 订阅标签
     */
    @Column(name = "like_tag")
    private String likeTag;

    /**
     * 头像图片url
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取昵称
     *
     * @return display_name - 昵称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置昵称
     *
     * @param displayName 昵称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取金币
     *
     * @return gold - 金币
     */
    public Integer getGold() {
        return gold;
    }

    /**
     * 设置金币
     *
     * @param gold 金币
     */
    public void setGold(Integer gold) {
        this.gold = gold;
    }

    /**
     * 获取积分等级
     *
     * @return my_level - 积分等级
     */
    public Integer getMyLevel() {
        return myLevel;
    }

    /**
     * 设置积分等级
     *
     * @param myLevel 积分等级
     */
    public void setMyLevel(Integer myLevel) {
        this.myLevel = myLevel;
    }

    /**
     * 获取是否在线
     *
     * @return on_line - 是否在线
     */
    public Byte getOnLine() {
        return onLine;
    }

    /**
     * 设置是否在线
     *
     * @param onLine 是否在线
     */
    public void setOnLine(Byte onLine) {
        this.onLine = onLine;
    }

    /**
     * 获取是否禁用
     *
     * @return disable - 是否禁用
     */
    public Byte getDisable() {
        return disable;
    }

    /**
     * 设置是否禁用
     *
     * @param disable 是否禁用
     */
    public void setDisable(Byte disable) {
        this.disable = disable;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取电话号码
     *
     * @return mobile - 电话号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置电话号码
     *
     * @param mobile 电话号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取登陆时间
     *
     * @return login_time - 登陆时间
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * 设置登陆时间
     *
     * @param loginTime 登陆时间
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * 获取登陆ip地址
     *
     * @return login_ip - 登陆ip地址
     */
    public String getLoginIp() {
        return loginIp;
    }

    /**
     * 设置登陆ip地址
     *
     * @param loginIp 登陆ip地址
     */
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    /**
     * 获取登陆次数
     *
     * @return login_count - 登陆次数
     */
    public Integer getLoginCount() {
        return loginCount;
    }

    /**
     * 设置登陆次数
     *
     * @param loginCount 登陆次数
     */
    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    /**
     * 获取主题
     *
     * @return login_theme - 主题
     */
    public String getLoginTheme() {
        return loginTheme;
    }

    /**
     * 设置主题
     *
     * @param loginTheme 主题
     */
    public void setLoginTheme(String loginTheme) {
        this.loginTheme = loginTheme;
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
     * 获取操作人姓名
     *
     * @return op_user_name - 操作人姓名
     */
    public String getOpUserName() {
        return opUserName;
    }

    /**
     * 设置操作人姓名
     *
     * @param opUserName 操作人姓名
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
     * 获取删除标记
     *
     * @return del_flag - 删除标记
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     *
     * @param delFlag 删除标记
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * 获取登陆国家
     *
     * @return country - 登陆国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置登陆国家
     *
     * @param country 登陆国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取登陆城市
     *
     * @return city - 登陆城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置登陆城市
     *
     * @param city 登陆城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取登陆省份
     *
     * @return region - 登陆省份
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置登陆省份
     *
     * @param region 登陆省份
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取登陆运营商
     *
     * @return isp - 登陆运营商
     */
    public String getIsp() {
        return isp;
    }

    /**
     * 设置登陆运营商
     *
     * @param isp 登陆运营商
     */
    public void setIsp(String isp) {
        this.isp = isp;
    }

    /**
     * 获取国家id
     *
     * @return country_id - 国家id
     */
    public String getCountryId() {
        return countryId;
    }

    /**
     * 设置国家id
     *
     * @param countryId 国家id
     */
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    /**
     * 获取省份id
     *
     * @return region_id - 省份id
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * 设置省份id
     *
     * @param regionId 省份id
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * 获取城市id
     *
     * @return city_id - 城市id
     */
    public String getCityId() {
        return cityId;
    }

    /**
     * 设置城市id
     *
     * @param cityId 城市id
     */
    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    /**
     * 获取运营商id
     *
     * @return isp_id - 运营商id
     */
    public String getIspId() {
        return ispId;
    }

    /**
     * 设置运营商id
     *
     * @param ispId 运营商id
     */
    public void setIspId(String ispId) {
        this.ispId = ispId;
    }

    /**
     * 获取订阅标签
     *
     * @return like_tag - 订阅标签
     */
    public String getLikeTag() {
        return likeTag;
    }

    /**
     * 设置订阅标签
     *
     * @param likeTag 订阅标签
     */
    public void setLikeTag(String likeTag) {
        this.likeTag = likeTag;
    }

    /**
     * 获取头像图片url
     *
     * @return avatar_url - 头像图片url
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置头像图片url
     *
     * @param avatarUrl 头像图片url
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}