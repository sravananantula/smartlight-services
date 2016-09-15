package com.ge.predix.solsvc.dto;

public class DashBoardDetails {
	private String cityName;
	private Long noOfStreetlights;
	private Long noOfStreetlightsON ;
	private Double PercentOfLightsON  ;
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Long getNoOfStreetlights() {
		return noOfStreetlights;
	}
	public void setNoOfStreetlights(Long noOfStreetlights) {
		this.noOfStreetlights = noOfStreetlights;
	}
	public Long getNoOfStreetlightsON() {
		return noOfStreetlightsON;
	}
	public void setNoOfStreetlightsON(Long noOfStreetlightsON) {
		this.noOfStreetlightsON = noOfStreetlightsON;
	}
	public Double getPercentOfLightsON() {
		return PercentOfLightsON;
	}
	public void setPercentOfLightsON(Double percentOfLightsON) {
		PercentOfLightsON = percentOfLightsON;
	}
	
	
}
