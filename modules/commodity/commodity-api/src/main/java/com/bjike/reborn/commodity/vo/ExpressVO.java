package com.bjike.reborn.commodity.vo;

/**
 * 快递表现层对象
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-05-20 03:16 ]
 * @Description: [ 快递表现层对象 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
public class ExpressVO {

    /**
     * id
     */
    private String id;

    /**
     * 公司
     */
    private String company;

    /**
     * 快递名称
     */
    private String name;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 电话
     */
    private String phone;

    /**
     * 网址
     */
    private String url;

    /**
     * 排序
     */
    private Integer seq;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否使用
     */
    private Boolean enable;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}