package com.zxm.palmcampus.utils;

public class SyllabusUtils {
	public SyllabusUtils() {
	}

	// 将星期转化成对应的星期数字
	public int changeStrWeekToInt(String week) {
		// 星期日、一、二、三、四、五、六
		// 对应 1、 2、 3、 4、 5、 6、 7
		int intWeek = 0;
		if (week.equals("一")) {
			intWeek = 2;
		} else if (week.equals("二")) {
			intWeek = 3;
		} else if (week.equals("三")) {
			intWeek = 4;
		} else if (week.equals("四")) {
			intWeek = 5;
		} else if (week.equals("五")) {
			intWeek = 6;
		} else if (week.equals("六")) {
			intWeek = 7;
		} else if (week.equals("日")) {
			intWeek = 1;
		}

		return intWeek;

	}

	// 获取闹钟ID
	public int getAlarmId(int week, String whichLesson) {
		int alarmId = 0;
		// 星期一
		if (week == 2 && whichLesson.equals("1-2")) {
			alarmId = 11;
		} else if (week == 2 && whichLesson.equals("3-4")) {
			alarmId = 12;
		} else if (week == 2 && whichLesson.equals("5-6")) {
			alarmId = 13;
		} else if (week == 2 && whichLesson.equals("7-8")) {
			alarmId = 14;
		} else if (week == 2 && whichLesson.equals("9-10")) {
			alarmId = 15;
		} else if (week == 2 && whichLesson.equals("11-12")) {
			alarmId = 16;
		} else if (week == 2 && whichLesson.equals("13-14")) {
			alarmId = 17;
		} else if (week == 2 && whichLesson.equals("15-16")) {
			alarmId = 18;
		}
		// 星期二
		if (week == 3 && whichLesson.equals("1-2")) {
			alarmId = 21;
		} else if (week == 3 && whichLesson.equals("3-4")) {
			alarmId = 22;
		} else if (week == 3 && whichLesson.equals("5-6")) {
			alarmId = 23;
		} else if (week == 3 && whichLesson.equals("7-8")) {
			alarmId = 24;
		} else if (week == 3 && whichLesson.equals("9-10")) {
			alarmId = 25;
		} else if (week == 3 && whichLesson.equals("11-12")) {
			alarmId = 26;
		} else if (week == 3 && whichLesson.equals("13-14")) {
			alarmId = 27;
		} else if (week == 3 && whichLesson.equals("15-16")) {
			alarmId = 28;
		}
		// 星期三
		if (week == 4 && whichLesson.equals("1-2")) {
			alarmId = 31;
		} else if (week == 4 && whichLesson.equals("3-4")) {
			alarmId = 32;
		} else if (week == 4 && whichLesson.equals("5-6")) {
			alarmId = 33;
		} else if (week == 4 && whichLesson.equals("7-8")) {
			alarmId = 34;
		} else if (week == 4 && whichLesson.equals("9-10")) {
			alarmId = 35;
		} else if (week == 4 && whichLesson.equals("11-12")) {
			alarmId = 36;
		} else if (week == 4 && whichLesson.equals("13-14")) {
			alarmId = 37;
		} else if (week == 4 && whichLesson.equals("15-16")) {
			alarmId = 38;
		}
		// 星期四
		if (week == 5 && whichLesson.equals("1-2")) {
			alarmId = 41;
		} else if (week == 5 && whichLesson.equals("3-4")) {
			alarmId = 42;
		} else if (week == 5 && whichLesson.equals("5-6")) {
			alarmId = 43;
		} else if (week == 5 && whichLesson.equals("7-8")) {
			alarmId = 44;
		} else if (week == 5 && whichLesson.equals("9-10")) {
			alarmId = 45;
		} else if (week == 5 && whichLesson.equals("11-12")) {
			alarmId = 46;
		} else if (week == 5 && whichLesson.equals("13-14")) {
			alarmId = 47;
		} else if (week == 5 && whichLesson.equals("15-16")) {
			alarmId = 48;
		}
		// 星期五
		if (week == 6 && whichLesson.equals("1-2")) {
			alarmId = 51;
		} else if (week == 6 && whichLesson.equals("3-4")) {
			alarmId = 52;
		} else if (week == 6 && whichLesson.equals("5-6")) {
			alarmId = 53;
		} else if (week == 6 && whichLesson.equals("7-8")) {
			alarmId = 54;
		} else if (week == 6 && whichLesson.equals("9-10")) {
			alarmId = 55;
		} else if (week == 6 && whichLesson.equals("11-12")) {
			alarmId = 56;
		} else if (week == 6 && whichLesson.equals("13-14")) {
			alarmId = 57;
		} else if (week == 6 && whichLesson.equals("15-16")) {
			alarmId = 58;
		}
		// 星期六
		if (week == 7 && whichLesson.equals("1-2")) {
			alarmId = 61;
		} else if (week == 7 && whichLesson.equals("3-4")) {
			alarmId = 62;
		} else if (week == 7 && whichLesson.equals("5-6")) {
			alarmId = 63;
		} else if (week == 7 && whichLesson.equals("7-8")) {
			alarmId = 64;
		} else if (week == 7 && whichLesson.equals("9-10")) {
			alarmId = 65;
		} else if (week == 7 && whichLesson.equals("11-12")) {
			alarmId = 66;
		} else if (week == 7 && whichLesson.equals("13-14")) {
			alarmId = 67;
		} else if (week == 7 && whichLesson.equals("15-16")) {
			alarmId = 68;
		}
		// 星期日
		if (week == 1 && whichLesson.equals("1-2")) {
			alarmId = 71;
		} else if (week == 1 && whichLesson.equals("3-4")) {
			alarmId = 72;
		} else if (week == 1 && whichLesson.equals("5-6")) {
			alarmId = 73;
		} else if (week == 1 && whichLesson.equals("7-8")) {
			alarmId = 74;
		} else if (week == 1 && whichLesson.equals("9-10")) {
			alarmId = 75;
		} else if (week == 1 && whichLesson.equals("11-12")) {
			alarmId = 76;
		} else if (week == 1 && whichLesson.equals("13-14")) {
			alarmId = 77;
		} else if (week == 1 && whichLesson.equals("15-16")) {
			alarmId = 78;
		}
		// // 计划
		// if(week==8 && whichLesson.equals("1")){
		// alarmId = 81;
		// }
		// else if(week==8 && whichLesson.equals("2")){
		// alarmId = 82;
		// }
		// else if(week==8 && whichLesson.equals("3")){
		// alarmId = 83;
		// }
		// else if(week==8 && whichLesson.equals("4")){
		// alarmId = 84;
		// }
		// else if(week==8 && whichLesson.equals("5")){
		// alarmId = 85;
		// }

		return alarmId;
	}

	// 剪切过长的课程名称
	public String cutCourseName(String str) {
		String strCut = null;
		if (str.getBytes().length > 10) {
			strCut = str.substring(0, 4) + "...";
		} else {
			strCut = str;
		}

		return strCut;
	}

	// 格式化时间
	public String formateTime(int time) {

		String timeStr = "";
		if (time < 10) {
			timeStr = "0" + String.valueOf(time);
		} else {
			timeStr = String.valueOf(time);
		}
		return timeStr;
	}
}
