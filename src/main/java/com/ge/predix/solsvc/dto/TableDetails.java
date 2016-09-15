package com.ge.predix.solsvc.dto;

public class TableDetails {
	private String zoneName;
	private String cityName;
	private String noOfStreetlightsOff;
	private String noOfStreetlightsON ;
	private String currentBattery  ;
	private String recentLumensValue  ;
	private String totalLights  ;
	
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getNoOfStreetlightsOff() {
		return noOfStreetlightsOff;
	}
	public void setNoOfStreetlightsOff(String noOfStreetlightsOff) {
		this.noOfStreetlightsOff = noOfStreetlightsOff;
	}
	public String getNoOfStreetlightsON() {
		return noOfStreetlightsON;
	}
	public void setNoOfStreetlightsON(String noOfStreetlightsON) {
		this.noOfStreetlightsON = noOfStreetlightsON;
	}
	public String getCurrentBattery() {
		return currentBattery;
	}
	public void setCurrentBattery(String currentBattery) {
		this.currentBattery = currentBattery;
	}
	public String getRecentLumensValue() {
		return recentLumensValue;
	}
	public void setRecentLumensValue(String recentLumensValue) {
		this.recentLumensValue = recentLumensValue;
	}
	public String getTotalLights() {
		return totalLights;
	}
	public void setTotalLights(String totalLights) {
		this.totalLights = totalLights;
	}
	
	
}
