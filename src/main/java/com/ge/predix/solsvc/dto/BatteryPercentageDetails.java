package com.ge.predix.solsvc.dto;

public class BatteryPercentageDetails {
	
	
	private String zoneName;
	private String capacity ;
	private String totalCapacity;
	private String chargeMode;
	private String currentLevelOfCharge;
	private String batteryPercent;
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(String totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	public String getChargeMode() {
		return chargeMode;
	}
	public void setChargeMode(String chargeMode) {
		this.chargeMode = chargeMode;
	}
	public String getCurrentLevelOfCharge() {
		return currentLevelOfCharge;
	}
	public void setCurrentLevelOfCharge(String currentLevelOfCharge) {
		this.currentLevelOfCharge = currentLevelOfCharge;
	}
	public String getBatteryPercent() {
		return batteryPercent;
	}
	public void setBatteryPercent(String batteryPercent) {
		this.batteryPercent = batteryPercent;
	}
	
	
}
