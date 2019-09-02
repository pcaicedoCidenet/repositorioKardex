package com.kardex.core.model;

public class Product {
	
	private long PRODUCTID;
	private String PRODUCTNAME;
	private int PRODUCTPRICE;
	private String PRODUCTCATEGORY;
	
	public long getPRODUCTID() {
		return PRODUCTID;
	}
	public void setPRODUCTID(long pRODUCTID) {
		PRODUCTID = pRODUCTID;
	}
	public String getPRODUCTNAME() {
		return PRODUCTNAME;
	}
	public void setPRODUCTNAME(String pRODUCTNAME) {
		PRODUCTNAME = pRODUCTNAME;
	}
	public int getPRODUCTPRICE() {
		return PRODUCTPRICE;
	}
	public void setPRODUCTPRICE(int pRODUCTPRICE) {
		PRODUCTPRICE = pRODUCTPRICE;
	}
	public String getPRODUCTCATEGORY() {
		return PRODUCTCATEGORY;
	}
	public void setPRODUCTCATEGORY(String pRODUCTCATEGORY) {
		PRODUCTCATEGORY = pRODUCTCATEGORY;
	}
	
}
