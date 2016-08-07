package com.zxm.palmcampus.domain;

public class Plan {
	private int pno;// 提醒内容
	private String content;// 提醒内容
	private String remindTime; // 提醒时间
	private boolean isRemind; // 是否提醒
	private boolean isRemindByVibrato; // 是否震动提醒
	private boolean isRemindByRing; // 是否铃声提醒

	public Plan(int pno, String content, String remindTime, boolean isRemind,
			boolean isRemindByVibrato, boolean isRemindByRing) {
		// TODO Auto-generated constructor stub
		this.pno = pno;
		this.content = content;
		this.remindTime = remindTime;
		this.isRemind = isRemind;
		this.isRemindByVibrato = isRemindByVibrato;
		this.isRemindByRing = isRemindByRing;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
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
}
