package com.edu.bean;

import java.util.Date;
import java.util.List;

public class User {

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getsCompany() {
		return sCompany;
	}
	public void setsCompany(int sCompany) {
		this.sCompany = sCompany;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public String getApkVersion() {
		return apkVersion;
	}
	public void setApkVersion(String apkVersion) {
		this.apkVersion = apkVersion;
	}
	public String getmObileModel() {
		return mObileModel;
	}
	public void setmObileModel(String mObileModel) {
		this.mObileModel = mObileModel;
	}
	public String getoS() {
		return oS;
	}
	public void setoS(String oS) {
		this.oS = oS;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	private int id;
	private String userName;
	private int sCompany ;
	private String customerName;
	private String userKey;
	private String apkVersion;
	private String mObileModel;
	private String oS;
	private String manufacturer;	
	
}
