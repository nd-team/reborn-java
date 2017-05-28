package com.bjike.reborn.storage.entity;

import com.bjike.reborn.common.api.entity.BaseEntity;
import com.bjike.reborn.storage.enums.FileType;

import javax.persistence.*;


/**
 * 文件存储
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-03-25 02:02 ]
 * @Description: [ 文件存储 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Entity
@Table(name = "storage_file")
public class File extends BaseEntity {

    /**
     * 文件名
     */
    @Column(columnDefinition = "VARCHAR(255)   COMMENT '文件名'")
    private String name;

    /**
     * 文件路径(从模块名起)
     */
    @Column(columnDefinition = "VARCHAR(255)   COMMENT '文件路径'")
    private String path;

    /**
     * 文件类型
     */
    @Column(columnDefinition = "TINYINT(2) COMMENT '文件类型'", nullable = false)
    private FileType fileType;

    /**
     * 文件大小
     */
    @Column(columnDefinition = "VARCHAR(10)   COMMENT '文件大小'")
    private String size;


    /**
     * 所属模块用户
     */
    @Column(name = "module", columnDefinition = "VARCHAR(100)   COMMENT '所属模块,用户'")
    private String module;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}