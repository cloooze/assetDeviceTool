package com.ericsson.assetDeviceTool.bean;

public class Device {
	
	private String brandId = null;
	private String sku = null;
	private String associatedAssetId = null;
	private String device = null;
	private String isDataOnly = null;
	private String userGuideName = null;
	
	
	public String getBrandId() {
		return brandId;
	}
	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getAssociatedAssetId() {
		return associatedAssetId;
	}
	public void setAssociatedAssetId(String associatedAssetId) {
		this.associatedAssetId = associatedAssetId;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public String getIsDataOnly() {
		return isDataOnly;
	}
	public void setIsDataOnly(String isDataOnly) {
		this.isDataOnly = isDataOnly;
	}
	public String getUserGuideName() {
		return userGuideName;
	}
	public void setUserGuideName(String userGuideName) {
		this.userGuideName = userGuideName;
	}
	@Override
	public String toString() {
		return "Device [sku=" + sku + ", associatedAssetId="
				+ associatedAssetId + ", device=" + device + ", isDataOnly="
				+ isDataOnly + ", userGuideName=" + userGuideName + "]";
	}
	
	public String toStringForCsv() {
		return sku + associatedAssetId + device + isDataOnly + userGuideName;
	}
	

	
}
