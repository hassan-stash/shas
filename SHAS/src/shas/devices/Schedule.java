package shas.devices;

import java.util.Date;

public class Schedule {

	private Date dtfrom;
	public Date getDtfrom() {
		return dtfrom;
	}

	public void setDtfrom(Date dtfrom) {
		this.dtfrom = dtfrom;
	}

	public Date getDtto() {
		return dtto;
	}

	public void setDtto(Date dtto) {
		this.dtto = dtto;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private String sprinklerid;  
	private Date dtto;
	private Integer level;
	private Integer duration;
	private Integer status;
	
	public Schedule(Date from, Date to, int level,int duration, int status) {
		
		setDtfrom(from);
		setDtto(to);
		setLevel(level);
		setDuration(duration);
		setStatus(status);
	}
	
	public Schedule()
	{
	
	}

	public void setSprinklerid(String sprinklerid) {
		this.sprinklerid = sprinklerid;
	}

	public String getSprinklerid() {
		return sprinklerid;
	}

}
