package com.wwg.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 金服平台所有实体类（Model, Vo）等父类，实现toString() 方法
 * @author lizhixiong
 *
 * 2018年5月24日
 */
public abstract class AbstractModel {

	@Override
	public String toString() {
		return JSON.toJSONString(this, SerializerFeature.WriteMapNullValue);
	}

	
}
