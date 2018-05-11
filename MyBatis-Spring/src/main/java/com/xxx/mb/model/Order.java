package com.xxx.mb.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;

/**
 * Order---与User多对一
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Order implements Serializable {

	private Integer oid;
	private String time;
	private String uidFk;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUidFk() {
		return uidFk;
	}

	public void setUidFk(String uidFk) {
		this.uidFk = uidFk;
	}
}
