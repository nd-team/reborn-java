package com.bjike.reborn.user.entity;


import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.user.enums.SexType;
import com.bjike.reborn.user.enums.UserType;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 用户详情
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Entity
@Table(name = "user_detail")
public class UserDetail extends BaseEntity {

    /**
     * 所属用户
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false, unique = true, columnDefinition = "VARCHAR(36) COMMENT '所属用户' ")
    private User user;

    /**
     * 所在部门
     */
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "department_id", columnDefinition = "VARCHAR(36) COMMENT '所在部门' ")
    private Department department;

    /**
     * 员工编号
     */
    @Column( columnDefinition = "VARCHAR(12) COMMENT '用户员工编号'")
    private String employeeNumber;

    /**
     * 电话
     */
    @Column(columnDefinition = "VARCHAR(11) COMMENT '电话' ")
    private String phone;


    /**
     * 底薪
     */
    @Column(columnDefinition = "DECIMAL(5,2) COMMENT '底薪' ")
    private Double salary;

    /**
     * 岗位
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '岗位' ")
    private String position;

    /**
     * 离职
     */
    @Column(nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0 COMMENT '离职(0:在职 1:离职)' ", insertable = false)
    private Boolean leaveJob;

    /**
     * 排序
     */
    @Column(columnDefinition = "TINYINT COMMENT '排序'")
    private Integer seq;

    /**
     * 出生年月
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '出生年月' ")
    private LocalDate birthday;


    /**
     * 性别
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '用户性别' ")
    private SexType sex;
    /**
     * 地址
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '地址' ")
    private String address;


    /**
     * 身份证
     */
    @Column(columnDefinition = "VARCHAR(18) COMMENT '身份证' ")
    private String idCard;

    /**
     * 毕业学校
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '身份证' ")
    private String school;

    /**
     * 学历
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '学历' ")
    private String associateDegree;

    /**
     * 专业
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '专业' ")
    private String major;

    /**
     * 备注
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '备注' ")
    private String mark;
    /**
     * 银行卡
     */
    @Column(columnDefinition = "VARCHAR(20) COMMENT '银行卡' ")
    private String creditCard;

    /**
     * 头像
     */
    @Column(columnDefinition = "VARCHAR(255) COMMENT '头像' ")
    private String headSculpture;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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
