package com.zxm.palmcampus.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zxm.palmcampus.domain.Course;
import com.zxm.palmcampus.domain.Plan;

public class MyDB {
	private static final String DATABASE_NAME = "dbForiTaoke.db";
	private static final int DATABASE_VERSION = 1;

	private static final String TABLE_NAME_SCHEDULE = "Tb_schedule";
	private static final String ID = "id";
	private static final String WEEK = "week";
	private static final String WHICH_LESSON = "whichLesson";
	private static final String COURSE_NAME = "cName";
	private static final String PERIOD = "period";
	private static final String START_TIME = "startTime";
	private static final String END_TIME = "endTime";
	private static final String ADDRESS = "address";
	private static final String REMIND_TIME = "remindTime";
	private static final String IS_REMIND = "isRemind";
	private static final String IS_REMIND_BY_VIBRATO = "isRemindByVibrato";
	private static final String IS_REMIND_BY_RING = "isRemindByRing";
	private static final String TEACHER = "teacher";
	private static final String SUBMIT_DATE = "submitDate";

	private static final String TABLE_NAME_PLAN = "Tb_plan";
	private static final String PNO = "pno";
	private static final String CONTENT = "content";

	MyDBHelper mOpenHelper;
	Context context;

	public MyDB(Context c) {
		this.context = c;
		mOpenHelper = new MyDBHelper(context);
	}

	// 不需要升级数据库就可以不写入操作代码
	// 如果需要只改DATABASE_VERSION = 2，android就会自动判断版本1升级
	public void initLayout() {
	}

	public void prepareListener() {
	}

	// 查询所有课程
	public Cursor queryAllCourses() {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, null, null, null, null,
				null);
		return c;
	}

	// 查询所有单、双周的课程
	public Cursor queryAllSingleAndCouple() {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		String str = "period = '11' OR period = '12' OR period = '21' OR period = '22' ";
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, str, null, null, null,
				null);
		return c;
	}

	// 增加课程
	public void insertCourse(Course c) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(WEEK, c.getWeek());
		cv.put(WHICH_LESSON, c.getWhichLesson());
		cv.put(COURSE_NAME, c.getcName());
		cv.put(PERIOD, c.getPeriod());
		cv.put(START_TIME, c.getStartTime());
		cv.put(END_TIME, c.getEndTime());
		cv.put(ADDRESS, c.getAddress());
		cv.put(REMIND_TIME, c.getRemindTime());
		cv.put(IS_REMIND, c.isRemind());
		cv.put(IS_REMIND_BY_VIBRATO, c.isRemindByVibrato());
		cv.put(IS_REMIND_BY_RING, c.isRemindByRing());
		cv.put(TEACHER, c.getTeacher());
		cv.put(SUBMIT_DATE, c.getSubmitDate());

		db.insert(TABLE_NAME_SCHEDULE, null, cv);
	}

	// 根据ID更新课程
	public void updateCourseById(int id, Course c) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(WEEK, c.getWeek());
		cv.put(WHICH_LESSON, c.getWhichLesson());
		cv.put(COURSE_NAME, c.getcName());
		cv.put(PERIOD, c.getPeriod());
		cv.put(START_TIME, c.getStartTime());
		cv.put(END_TIME, c.getEndTime());
		cv.put(ADDRESS, c.getAddress());
		cv.put(REMIND_TIME, c.getRemindTime());
		cv.put(IS_REMIND, c.isRemind());
		cv.put(IS_REMIND_BY_VIBRATO, c.isRemindByVibrato());
		cv.put(IS_REMIND_BY_RING, c.isRemindByRing());
		cv.put(TEACHER, c.getTeacher());
		cv.put(SUBMIT_DATE, c.getSubmitDate());
		String str = "id=" + id;
		db.update(TABLE_NAME_SCHEDULE, cv, str, null);
		db.close();
	}

	// 根据ID删除课程
	public void deleteCourseById(int id) {
		try {
			SQLiteDatabase db = mOpenHelper.getWritableDatabase();
			String str = "id=" + id;
			db.delete(TABLE_NAME_SCHEDULE, str, null);
		} catch (SQLException e) {

		}
	}

	// 查询所有星期1-5的课程
	public Cursor queryWeekCourse() {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		String str = "week = '一' OR week = '二' OR week = '三' OR week = '四' OR week = '五' ";
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, str, null, null, null,
				null);
		return c;
	}

	// 根据ID查询星期1-5的课程
	public Course queryCourseById(int id) {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String str = "id=" + id;
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, str, null, null, null,
				null);
		Course course = null;
		String week = null;
		String whichLesson = null;
		String cName = null;
		String period = null;
		String startTime = null;
		String endTime = null;
		String address = null;
		String remindTime = null;
		String isRemind = null;
		boolean b_isRemind = false;
		String isRemindByVibrato = null;
		boolean b_isRemindByVibrato = false;
		String isRemindByRing = null;
		boolean b_isRemindByRing = false;
		String teacher = null;
		String submitDate = null;

		if (c.getCount() > 0) {
			while (c.moveToNext()) {
				week = c.getString(c.getColumnIndex("week"));
				whichLesson = c.getString(c.getColumnIndex("whichLesson"));
				cName = c.getString(c.getColumnIndex("cName"));
				period = c.getString(c.getColumnIndex("period"));
				startTime = c.getString(c.getColumnIndex("startTime"));
				endTime = c.getString(c.getColumnIndex("endTime"));
				address = c.getString(c.getColumnIndex("address"));
				remindTime = c.getString(c.getColumnIndex("remindTime"));
				isRemind = c.getString(c.getColumnIndex("isRemind"));
				submitDate = c.getString(c.getColumnIndex("submitDate"));

				if (isRemind.equals("1")) {
					b_isRemind = true;
				}
				isRemindByVibrato = c.getString(c
						.getColumnIndex("isRemindByVibrato"));
				if (isRemindByVibrato.equals("1")) {
					b_isRemindByVibrato = true;
				}
				isRemindByRing = c
						.getString(c.getColumnIndex("isRemindByRing"));
				if (isRemindByRing.equals("1")) {
					b_isRemindByRing = true;
				}
				teacher = c.getString(c.getColumnIndex("teacher"));
			}
			course = new Course(week, whichLesson, cName, period, startTime,
					endTime, address, remindTime, b_isRemind,
					b_isRemindByVibrato, b_isRemindByRing, teacher, submitDate);
		}

		c.close();
		db.close();
		return course;
	}

	// 查询所有周末的课程
	public Cursor queryWeekendCourses() {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		String str = "week= '六' OR week= '日'";
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, str, null, null, null,
				null);
		return c;
	}

	// 根据week和whichLesson来查询周末的课程
	public Cursor queryWeekendCourseByWeekAndWhichLesson(String w, String wl) {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String str = "week= '" + w + "' and " + "whichLesson= '" + wl + "'";
		String col[] = { ID, WEEK, WHICH_LESSON, COURSE_NAME, PERIOD,
				START_TIME, END_TIME, ADDRESS, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING, TEACHER, SUBMIT_DATE };
		Cursor c = db.query(TABLE_NAME_SCHEDULE, col, str, null, null, null,
				null);
		return c;
	}

	// 添加计划
	public void insertPlan(Plan m) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(PNO, m.getPno());
		cv.put(CONTENT, m.getContent());
		cv.put(REMIND_TIME, m.getRemindTime());
		cv.put(IS_REMIND, m.isRemind());
		cv.put(IS_REMIND_BY_VIBRATO, m.isRemindByVibrato());
		cv.put(IS_REMIND_BY_RING, m.isRemindByRing());

		db.insert(TABLE_NAME_PLAN, null, cv);
		db.close();
	}

	// 查询所有计划
	public Cursor queryAllPlans() {

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, PNO, CONTENT, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING };
		Cursor c = db.query(TABLE_NAME_PLAN, col, null, null, null, null, null);
		return c;
	}

	// 根据计划编号来查询计划
	public Cursor queryPlanByPno(int pno) {

		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String col[] = { ID, PNO, CONTENT, REMIND_TIME, IS_REMIND,
				IS_REMIND_BY_VIBRATO, IS_REMIND_BY_RING };
		String str = "pno=" + pno;
		Cursor c = db.query(TABLE_NAME_PLAN, col, str, null, null, null, null);
		return c;
	}

	// 根据计划编号来删除计划
	public void deletePlan(int pno) {
		try {
			SQLiteDatabase db = mOpenHelper.getWritableDatabase();
			String str = "pno=" + pno;
			db.delete(TABLE_NAME_PLAN, str, null);
			db.close();
		} catch (SQLException e) {

		}

	}

	// 根据pno更新计划
	public void updatePlanByPno(int pno, Plan m) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();

		ContentValues cv = new ContentValues();
		cv.put(REMIND_TIME, m.getRemindTime());
		cv.put(IS_REMIND, m.isRemind());
		cv.put(IS_REMIND_BY_VIBRATO, m.isRemindByVibrato());
		cv.put(IS_REMIND_BY_RING, m.isRemindByRing());
		String str = "pno=" + pno;
		db.update(TABLE_NAME_PLAN, cv, str, null);
		db.close();
	}

	// 查询所有星期1-5的课程
	public static class MyDBHelper extends SQLiteOpenHelper {

		// 在SQLiteOpenHelper构造的子类当中，必须有的构造函数
		MyDBHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			System.out.println(".......................");
			String sql1 = "CREATE TABLE " + TABLE_NAME_SCHEDULE + " (" + ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + WEEK
					+ " String, " + WHICH_LESSON + " String, " + COURSE_NAME
					+ " String, " + PERIOD + " String, " + START_TIME
					+ " String, " + END_TIME + " String, " + ADDRESS
					+ " String, " + REMIND_TIME + " String, " + IS_REMIND
					+ " boolean, " + IS_REMIND_BY_VIBRATO + " boolean, "
					+ IS_REMIND_BY_RING + " boolean, " + TEACHER + " String, "
					+ SUBMIT_DATE + " String" + ");";

			String sql2 = "CREATE TABLE " + TABLE_NAME_PLAN + " (" + ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + PNO
					+ " INTEGER, " + CONTENT + " String, " + REMIND_TIME
					+ " String, " + IS_REMIND + " boolean, "
					+ IS_REMIND_BY_VIBRATO + " boolean, " + IS_REMIND_BY_RING
					+ " boolean" + ");";
			db.execSQL(sql1);
			db.execSQL(sql2);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}

	}

}
