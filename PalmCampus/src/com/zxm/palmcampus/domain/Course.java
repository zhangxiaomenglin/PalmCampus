package com.zxm.palmcampus.domain;

public class Course {
	private String week;// 星期
	private String whichLesson;// 课次
	private String cName; // 课程名称
	private String period; // 单、双、单双周
	private String startTime; // 上课时间
	private String endTime; // 下课时间
	private String address; // 地点
	private String remindTime; // 提醒时间
	private boolean isRemind; // 是否提醒
	private boolean isRemindByVibrato; // 是否震动提醒
	private boolean isRemindByRing; // 是否铃声提醒
	private String teacher; // 任课老师
	private String submitDate;// 设置日期

	public Course(String week, String whichLesson, String cName, String period,
			String startTime, String endTime, String address,
			String remindTime, boolean isRemind, boolean isRemindByVibrato,
			boolean isRemindByRing, String teacher, String submitDate) {
		this.week = week;
		this.whichLesson = whichLesson;
		this.cName = cName;
		this.period = period;
		this.startTime = startTime;
		this.endTime = endTime;
		this.address = address;
		this.remindTime = remindTime;
		this.isRemind = isRemind;
		this.isRemindByVibrato = isRemindByVibrato;
		this.isRemindByRing = isRemindByRing;
		this.teacher = teacher;
		this.submitDate = submitDate;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getWhichLesson() {
		return whichLesson;
	}

	public void setWhichLesson(String whichLesson) {
		this.whichLesson = whichLesson;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public boolean isRemind() {
		return isRemind;
	}

	public void setRemind(boolean isRemind) {
		this.isRemind = isRemind;
	}

	public boolean isRemindByVibrato() {
		return isRemindByVibrato;
	}

	public void setRemindByVibrato(boolean isRemindByVibrato) {
		this.isRemindByVibrato = isRemindByVibrato;
	}

	public boolean isRemindByRing() {
		return isRemindByRing;
	}

	public void setRemindByRing(boolean isRemindByRing) {
		this.isRemindByRing = isRemindByRing;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(String submitDate) {
		this.submitDate = submitDate;
	}
}
