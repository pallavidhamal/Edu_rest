package com.edu.bean;

import java.util.Date;

public class College {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCollegename() {
		return collegename;
	}

	public void setCollegename(String collegename) {
		this.collegename = collegename;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getpOLineId() {
		return pOLineId;
	}

	public void setpOLineId(int pOLineId) {
		this.pOLineId = pOLineId;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

	public String getInstid() {
		return instid;
	}

	public void setInstid(String instid) {
		this.instid = instid;
	}

	public String getStreams() {
		return streams;
	}

	public void setStreams(String streams) {
		this.streams = streams;
	}

	private String collegename;
	
	private String isDeleted;
	
	private int createdBy;
	private Date createdDate = new Date();
	
	private int updatedBy;
	private Date updatedDate = new Date();

	private int pOLineId ;
	
	private String authKey;
	
	private String instid;

	private String streams;

	
}
