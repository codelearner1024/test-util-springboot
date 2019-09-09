package com.wwg.vo;

/**
 * Created by jane on 2017/9/8.
 */
public abstract class BaseVersionModel extends BaseModel{

	private static final long serialVersionUID = 4200793456152094796L;
	/** 数据更新版本管理用。*/
    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
