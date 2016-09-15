package com.ge.predix.solsvc.dto;

public class PoleData {
	
	private String cityName;
	private String zoneName;
	private String poleID;
	private String healthStatus;
	private String switchStatus;
	private String batteryPercentage;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getPoleID() {
		return poleID;
	}
	public void setPoleID(String poleID) {
		this.poleID = poleID;
	}
	public String getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}
	public String getSwitchStatus() {
		return switchStatus;
	}
	public void setSwitchStatus(String switchStatus) {
		this.switchStatus = switchStatus;
	}
	public String getBatteryPercentage() {
		return batteryPercentage;
	}
	public void setBatteryPercentage(String batteryPercentage) {
		this.batteryPercentage = batteryPercentage;
	}

	
	
	
}
