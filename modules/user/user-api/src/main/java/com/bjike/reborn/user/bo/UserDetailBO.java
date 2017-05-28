package com.bjike.reborn.user.bo;

import com.bjike.reborn.common.api.bo.BaseBO;
import com.bjike.reborn.user.enums.SexType;
import com.bjike.reborn.user.enums.UserType;

import java.time.LocalDate;

/**
 * 用户详情业务数据传输
 *
 * @Author: [liguiqin]
 * @Date: [2017-02-23 14:49]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public class UserDetailBO extends BaseBO {


    /**
     * 姓名
     */
    private String username;

    /**
     * 员工编号
     */
    private String employeeNumber;

    /**
     * 电话
     */
    private String phone;


    /**
     * 底薪
     */
    private Double salary;

    /**
     * 岗位
     */
    private String position;

    /**
     * 离职
     */
    private Boolean leaveJob;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 出生年月
     */
    private LocalDate birthday;


    /**
     * 性别
     */
    private SexType sex;
    /**
     * 地址
     */
    private String address;


    /**
     * 身份证
     */
    private String idCard;

    /**
     * 毕业学校
     */
    private String school;

    /**
     * 学历
     */
    private String associateDegree;

    /**
     * 专业
     */
    private String major;

    /**
     * 备注
     */
    private String mark;
    /**
     * 银行卡
     */
    private String creditCard;

    /**
     * 头像
     */
    private String headSculpture;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getLeaveJob() {
        return leaveJob;
    }

    public void setLeaveJob(Boolean leaveJob) {
        this.leaveJob = leaveJob;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getAssociateDegree() {
        return associateDegree;
    }

    public void setAssociateDegree(String associateDegree) {
        this.associateDegree = associateDegree;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getHeadSculpture() {
        return headSculpture;
    }

    public void setHeadSculpture(String headSculpture) {
        this.headSculpture = headSculpture;
    }
}
