package shas.devices;

import java.util.Date;

public class usage {

	
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getDurationran() {
		return durationran;
	}
	public void setDurationran(float durationran) {
		this.durationran = durationran;
	}
	public float getPowerconsumed() {
		return powerconsumed;
	}
	public void setPowerconsumed(float powerconsumed) {
		this.powerconsumed = powerconsumed;
	}
	public void setWaterconsumed(float waterconsumed) {
		this.waterconsumed = waterconsumed;
	}
	public float getWaterconsumed() {
		return waterconsumed;
	}
	private String deviceid;  
	private Date date;
	private float durationran;
	private float powerconsumed;
	private float waterconsumed;
	
}
