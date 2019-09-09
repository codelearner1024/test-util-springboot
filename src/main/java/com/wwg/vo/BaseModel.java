package com.wwg.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jane on 2017/9/8.
 */
public abstract class BaseModel extends AbstractModel implements Serializable{

	private static final long serialVersionUID = -6238185641614615826L;

	// 表主键ID
    private Long id;

    // 记录（对象）入库（创建）时间
    private Date gmtCreate;

    // 记录（对象）更新时间
    private Date gmtUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}
