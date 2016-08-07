package com.zxm.palmcampus.base.home.syllabus.fragment;

import java.util.Calendar;
import java.util.Date;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.zxm.palmcampus.R;
import com.zxm.palmcampus.base.home.syllabus.Syllabus;
import com.zxm.palmcampus.base.home.syllabus.activity.CourseInfoActivity;
import com.zxm.palmcampus.db.MyDB;
import com.zxm.palmcampus.domain.Course;
import com.zxm.palmcampus.utils.SyllabusUtils;

public class Fragment1 extends Fragment {

	private View view;
	private Intent intent;
	private Button monday;
	private Button tuesday;
	private Button wednesday;
	private Button thursday;
	private Button friday;

	private Button first;
	private Button second;
	private Button third;
	private Button fourth;
	private Button fifth;
	private Button sixth;

	private Button mon_first;
	private Button mon_second;
	private Button mon_third;
	private Button mon_fourth;
	private Button mon_fifth;
	private Button mon_sixth;

	private Button tues_first;
	private Button tues_second;
	private Button tues_third;
	private Button tues_fourth;
	private Button tues_fifth;
	private Button tues_sixth;

	private Button wed_first;
	private Button wed_second;
	private Button wed_third;
	private Button wed_fourth;
	private Button wed_fifth;
	private Button wed_sixth;

	private Button thurs_first;
	private Button thurs_second;
	private Button thurs_third;
	private Button thurs_fourth;
	private Button thurs_fifth;
	private Button thurs_sixth;

	private Button fri_first;
	private Button fri_second;
	private Button fri_third;
	private Button fri_fourth;
	private Button fri_fifth;
	private Button fri_sixth;

	private EditText dialog_courseName;
	private EditText dialog_address;
	private RadioButton dialog_single;
	private RadioButton dialog_couple;
	private RadioButton dialog_singleAndCouple;

	private View layout;

	private int mon_first_id;
	private int mon_second_id;
	private int mon_third_id;
	private int mon_fourth_id;
	private int mon_fifth_id;
	private int mon_sixth_id;

	private int tues_first_id;
	private int tues_second_id;
	private int tues_third_id;
	private int tues_fourth_id;
	private int tues_fifth_id;
	private int tues_sixth_id;

	private int wed_first_id;
	private int wed_second_id;
	private int wed_third_id;
	private int wed_fourth_id;
	private int wed_fifth_id;
	private int wed_sixth_id;

	private int thurs_first_id;
	private int thurs_second_id;
	private int thurs_third_id;
	private int thurs_fourth_id;
	private int thurs_fifth_id;
	private int thurs_sixth_id;

	private int fri_first_id;
	private int fri_second_id;
	private int fri_third_id;
	private int fri_fourth_id;
	private int fri_fifth_id;
	private int fri_sixth_id;

	private String mon_first_cName = "";
	private String mon_second_cName = "";
	private String mon_third_cName = "";
	private String mon_fourth_cName = "";
	private String mon_fifth_cName = "";
	private String mon_sixth_cName = "";

	private String tues_first_cName = "";
	private String tues_second_cName = "";
	private String tues_third_cName = "";
	private String tues_fourth_cName = "";
	private String tues_fifth_cName = "";
	private String tues_sixth_cName = "";

	private String wed_first_cName = "";
	private String wed_second_cName = "";
	private String wed_third_cName = "";
	private String wed_fourth_cName = "";
	private String wed_fifth_cName = "";
	private String wed_sixth_cName = "";

	private String thurs_first_cName = "";
	private String thurs_second_cName = "";
	private String thurs_third_cName = "";
	private String thurs_fourth_cName = "";
	private String thurs_fifth_cName = "";
	private String thurs_sixth_cName = "";

	private String fri_first_cName = "";
	private String fri_second_cName = "";
	private String fri_third_cName = "";
	private String fri_fourth_cName = "";
	private String fri_fifth_cName = "";
	private String fri_sixth_cName = "";
	
	Date date =new Date();
	Calendar calendar = Calendar.getInstance();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.syllabus_tab_1, null);

		/* 找到第一行的按钮 */

		monday = (Button) view.findViewById(R.id.monday);
		tuesday = (Button) view.findViewById(R.id.thursday);
		wednesday = (Button) view.findViewById(R.id.wednesday);
		thursday = (Button) view.findViewById(R.id.thursday);
		friday = (Button) view.findViewById(R.id.friday);

		/* 找到第一列的按钮 */
		first = (Button) view.findViewById(R.id.week1);
		second = (Button) view.findViewById(R.id.week2);
		third = (Button) view.findViewById(R.id.week3);
		fourth = (Button) view.findViewById(R.id.week4);
		fifth = (Button) view.findViewById(R.id.week5);
		sixth = (Button) view.findViewById(R.id.week6);

		/* 找到第2lie的按钮 */
		mon_first = (Button) view.findViewById(R.id.monday1);
		mon_second = (Button) view.findViewById(R.id.monday2);
		mon_third = (Button) view.findViewById(R.id.monday3);
		mon_fourth = (Button) view.findViewById(R.id.monday4);
		mon_fifth = (Button) view.findViewById(R.id.monday5);
		mon_sixth = (Button) view.findViewById(R.id.monday6);

		/* 找到第3lie的按钮 */
		tues_first = (Button) view.findViewById(R.id.tuesday1);
		tues_second = (Button) view.findViewById(R.id.tuesday2);
		tues_third = (Button) view.findViewById(R.id.tuesday3);
		tues_fourth = (Button) view.findViewById(R.id.tuesday4);
		tues_fifth = (Button) view.findViewById(R.id.tuesday5);
		tues_sixth = (Button) view.findViewById(R.id.tuesday6);

		/* 找到第4lie的按钮 */
		wed_first = (Button) view.findViewById(R.id.wednesday1);
		wed_second = (Button) view.findViewById(R.id.wednesday2);
		wed_third = (Button) view.findViewById(R.id.wednesday3);
		wed_fourth = (Button) view.findViewById(R.id.wednesday4);
		wed_fifth = (Button) view.findViewById(R.id.wednesday5);
		wed_sixth = (Button) view.findViewById(R.id.wednesday6);

		/* 找到第5lie的按钮 */
		thurs_first = (Button) view.findViewById(R.id.thursday1);
		thurs_second = (Button) view.findViewById(R.id.thursday2);
		thurs_third = (Button) view.findViewById(R.id.thursday3);
		thurs_fourth = (Button) view.findViewById(R.id.thursday4);
		thurs_fifth = (Button) view.findViewById(R.id.thursday5);
		thurs_sixth = (Button) view.findViewById(R.id.thursday6);

		/* 找到第6lie的按钮 */
		fri_first = (Button) view.findViewById(R.id.friday1);
		fri_second = (Button) view.findViewById(R.id.friday2);
		fri_third = (Button) view.findViewById(R.id.friday3);
		fri_fourth = (Button) view.findViewById(R.id.friday4);
		fri_fifth = (Button) view.findViewById(R.id.friday5);
		fri_sixth = (Button) view.findViewById(R.id.friday6);

		/* 分别添加点击事件 */
		mon_first.setOnClickListener(new MyButtonListener());
		mon_second.setOnClickListener(new MyButtonListener());
		mon_third.setOnClickListener(new MyButtonListener());
		mon_fourth.setOnClickListener(new MyButtonListener());
		mon_fifth.setOnClickListener(new MyButtonListener());
		mon_sixth.setOnClickListener(new MyButtonListener());

		tues_first.setOnClickListener(new MyButtonListener());
		tues_second.setOnClickListener(new MyButtonListener());
		tues_third.setOnClickListener(new MyButtonListener());
		tues_fourth.setOnClickListener(new MyButtonListener());
		tues_fifth.setOnClickListener(new MyButtonListener());
		tues_sixth.setOnClickListener(new MyButtonListener());

		wed_first.setOnClickListener(new MyButtonListener());
		wed_second.setOnClickListener(new MyButtonListener());
		wed_third.setOnClickListener(new MyButtonListener());
		wed_fourth.setOnClickListener(new MyButtonListener());
		wed_fifth.setOnClickListener(new MyButtonListener());
		wed_sixth.setOnClickListener(new MyButtonListener());

		thurs_first.setOnClickListener(new MyButtonListener());
		thurs_second.setOnClickListener(new MyButtonListener());
		thurs_third.setOnClickListener(new MyButtonListener());
		thurs_fourth.setOnClickListener(new MyButtonListener());
		thurs_fifth.setOnClickListener(new MyButtonListener());
		thurs_sixth.setOnClickListener(new MyButtonListener());

		fri_first.setOnClickListener(new MyButtonListener());
		fri_second.setOnClickListener(new MyButtonListener());
		fri_third.setOnClickListener(new MyButtonListener());
		fri_fourth.setOnClickListener(new MyButtonListener());
		fri_fifth.setOnClickListener(new MyButtonListener());
		fri_sixth.setOnClickListener(new MyButtonListener());

		//初始化课表
		initTable();
		return view;
	}
	
	//初始化课表
	public void initTable(){
		MyDB db = new MyDB(getActivity());
		Cursor cursor = db.queryAllCourses();
		SyllabusUtils base = new SyllabusUtils();
		while(cursor.moveToNext()){
			String strWeek = cursor.getString(cursor.getColumnIndex("week"));
        	String strWhichLesson = cursor.getString(cursor.getColumnIndex("whichLesson"));
        	// 星期一
        	if(strWeek.equals("一") && strWhichLesson.equals("1-2")){
        		mon_first_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_first_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_first.setText(base.cutCourseName(mon_first_cName));
        		mon_first.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("一") && strWhichLesson.equals("3-4")){
        		mon_second_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_second_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_second.setText(base.cutCourseName(mon_second_cName));
        		mon_second.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("一") && strWhichLesson.equals("5-6")){
        		mon_third_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_third_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_third.setText(base.cutCourseName(mon_third_cName));
        		mon_third.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("一") && strWhichLesson.equals("7-8")){
        		mon_fourth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_fourth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_fourth.setText(base.cutCourseName(mon_fourth_cName));
        		mon_fourth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("一") && strWhichLesson.equals("9-10")){
        		mon_fifth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_fifth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_fifth.setText(base.cutCourseName(mon_fifth_cName));
        		mon_fifth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("一") && strWhichLesson.equals("11-12")){
        		mon_sixth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		mon_sixth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		mon_sixth.setText(base.cutCourseName(mon_sixth_cName));
        		mon_sixth.setBackgroundResource(android.R.color.holo_blue_light);
        	}

        	// 星期二
        	if(strWeek.equals("二") && strWhichLesson.equals("1-2")){
        		tues_first_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_first_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_first.setText(base.cutCourseName(tues_first_cName));
        		tues_first.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("二") && strWhichLesson.equals("3-4")){
        		tues_second_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_second_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_second.setText(base.cutCourseName(tues_second_cName));
        		tues_second.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("二") && strWhichLesson.equals("5-6")){
        		tues_third_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_third_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_third.setText(base.cutCourseName(tues_third_cName));
        		tues_third.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("二") && strWhichLesson.equals("7-8")){
        		tues_fourth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_fourth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_fourth.setText(base.cutCourseName(tues_fourth_cName));
        		tues_fourth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("二") && strWhichLesson.equals("9-10")){
        		tues_fifth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_fifth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_fifth.setText(base.cutCourseName(tues_fifth_cName));
        		tues_fifth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("二") && strWhichLesson.equals("11-12")){
        		tues_sixth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		tues_sixth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		tues_sixth.setText(base.cutCourseName(tues_sixth_cName));
        		tues_sixth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	
        	// 星期三
        	if(strWeek.equals("三") && strWhichLesson.equals("1-2")){
        		wed_first_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_first_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_first.setText(base.cutCourseName(wed_first_cName));
        		wed_first.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("三") && strWhichLesson.equals("3-4")){
        		wed_second_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_second_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_second.setText(base.cutCourseName(wed_second_cName));
        		wed_second.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("三") && strWhichLesson.equals("5-6")){
        		wed_third_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_third_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_third.setText(base.cutCourseName(wed_third_cName));
        		wed_third.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("三") && strWhichLesson.equals("7-8")){
        		wed_fourth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_fourth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_fourth.setText(base.cutCourseName(wed_fourth_cName));
        		wed_fourth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("三") && strWhichLesson.equals("9-10")){
        		wed_fifth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_fifth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_fifth.setText(base.cutCourseName(wed_fifth_cName));
        		wed_fifth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("三") && strWhichLesson.equals("11-12")){
        		wed_sixth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		wed_sixth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		wed_sixth.setText(base.cutCourseName(wed_sixth_cName));
        		wed_sixth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	
        	// 星期四
        	if(strWeek.equals("四") && strWhichLesson.equals("1-2")){
        		thurs_first_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_first_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_first.setText(base.cutCourseName(thurs_first_cName));
        		thurs_first.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("四") && strWhichLesson.equals("3-4")){
        		thurs_second_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_second_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_second.setText(base.cutCourseName(thurs_second_cName));
        		thurs_second.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("四") && strWhichLesson.equals("5-6")){
        		thurs_third_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_third_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_third.setText(base.cutCourseName(thurs_third_cName));
        		thurs_third.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("四") && strWhichLesson.equals("7-8")){
        		thurs_fourth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_fourth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_fourth.setText(base.cutCourseName(thurs_fourth_cName));
        		thurs_fourth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("四") && strWhichLesson.equals("9-10")){
        		thurs_fifth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_fifth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_fifth.setText(base.cutCourseName(thurs_fifth_cName));
        		thurs_fifth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("四") && strWhichLesson.equals("11-12")){
        		thurs_sixth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		thurs_sixth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		thurs_sixth.setText(base.cutCourseName(thurs_sixth_cName));
        		thurs_sixth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	
        	// 星期五
        	if(strWeek.equals("五") && strWhichLesson.equals("1-2")){
        		fri_first_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_first_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_first.setText(base.cutCourseName(fri_first_cName));
        		fri_first.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("五") && strWhichLesson.equals("3-4")){
        		fri_second_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_second_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_second.setText(base.cutCourseName(fri_second_cName));
        		fri_second.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("五") && strWhichLesson.equals("5-6")){
        		fri_third_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_third_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_third.setText(base.cutCourseName(fri_third_cName));
        		fri_third.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("五") && strWhichLesson.equals("7-8")){
        		fri_fourth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_fourth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_fourth.setText(base.cutCourseName(fri_fourth_cName));
        		fri_fourth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("五") && strWhichLesson.equals("9-10")){
        		fri_fifth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_fifth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_fifth.setText(base.cutCourseName(fri_fifth_cName));
        		fri_fifth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
        	else if(strWeek.equals("五") && strWhichLesson.equals("11-12")){
        		fri_sixth_cName = cursor.getString(cursor.getColumnIndex("cName"));
        		fri_sixth_id = cursor.getInt(cursor.getColumnIndex("id"));
        		fri_sixth.setText(base.cutCourseName(fri_sixth_cName));
        		fri_sixth.setBackgroundResource(android.R.color.holo_blue_light);
        	}
		}
        cursor.close();
	}

	// 按钮事件的内部类
	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.monday1:
				if (mon_fifth_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ first.getText());
				} else {
					openShowCourseDetailDialog(mon_first_id);
				}
				break;

			case R.id.tuesday1:
				if (tues_first_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ first.getText());
				} else {
					openShowCourseDetailDialog(tues_first_id);
				}
				break;
			case R.id.wednesday1:
				if (wed_first_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ first.getText());
				} else {
					openShowCourseDetailDialog(wed_first_id);
				}
				break;
			case R.id.thursday1:
				if (thurs_first_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ first.getText());
				} else {
					openShowCourseDetailDialog(thurs_first_id);
				}
				break;
			case R.id.friday1:
				if (fri_first_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ first.getText());
				} else {
					openShowCourseDetailDialog(fri_first_id);
				}
				break;

			case R.id.monday2:
				if (mon_second_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ second.getText());
				} else {
					openShowCourseDetailDialog(mon_second_id);
				}
				break;
			case R.id.tuesday2:
				if (tues_second_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ second.getText());
				} else {
					openShowCourseDetailDialog(tues_second_id);
				}
				break;
			case R.id.wednesday2:
				if (wed_second_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ second.getText());
				} else {
					openShowCourseDetailDialog(wed_second_id);
				}
				break;
			case R.id.thursday2:
				if (thurs_second_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ second.getText());
				} else {
					openShowCourseDetailDialog(thurs_second_id);
				}
				break;
			case R.id.friday2:
				if (fri_second_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ second.getText());
				} else {
					openShowCourseDetailDialog(fri_second_id);
				}
				break;

			case R.id.monday3:
				if (mon_third_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ third.getText());
				} else {
					openShowCourseDetailDialog(mon_third_id);
				}
				break;
			case R.id.tuesday3:
				if (tues_third_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ third.getText());
				} else {
					openShowCourseDetailDialog(tues_third_id);
				}
				break;
			case R.id.wednesday3:
				if (wed_third_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ third.getText());
				} else {
					openShowCourseDetailDialog(wed_third_id);
				}
				break;
			case R.id.thursday3:
				if (thurs_third_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ third.getText());
				} else {
					openShowCourseDetailDialog(thurs_third_id);
				}
				break;
			case R.id.friday3:
				if (fri_third_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ third.getText());
				} else {
					openShowCourseDetailDialog(fri_third_id);
				}
				break;

			case R.id.monday4:
				if (mon_fourth_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ fourth.getText());
				} else {
					openShowCourseDetailDialog(mon_fourth_id);
				}
				break;
			case R.id.tuesday4:
				if (tues_fourth_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ fourth.getText());
				} else {
					openShowCourseDetailDialog(tues_fourth_id);
				}
				break;
			case R.id.wednesday4:
				if (wed_fourth_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ fourth.getText());
				} else {
					openShowCourseDetailDialog(wed_fourth_id);
				}
				break;
			case R.id.thursday4:
				if (thurs_fourth_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ fourth.getText());
				} else {
					openShowCourseDetailDialog(thurs_fourth_id);
				}
				break;
			case R.id.friday4:
				if (fri_fourth_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ fourth.getText());
				} else {
					openShowCourseDetailDialog(fri_fourth_id);
				}
				break;

			case R.id.monday5:
				if (mon_fifth_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ fifth.getText());
				} else {

					openShowCourseDetailDialog(mon_fifth_id);
				}
				break;
			case R.id.tuesday5:
				if (tues_fifth_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ fifth.getText());
				} else {
					openShowCourseDetailDialog(tues_fifth_id);
				}
				break;
			case R.id.wednesday5:
				if (wed_fifth_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ fifth.getText());
				} else {
					openShowCourseDetailDialog(wed_fifth_id);
				}
				break;
			case R.id.thursday5:
				if (thurs_fifth_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ fifth.getText());
				} else {
					openShowCourseDetailDialog(thurs_fifth_id);
				}
				break;
			case R.id.friday5:
				if (fri_fifth_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ fifth.getText());
				} else {
					openShowCourseDetailDialog(fri_fifth_id);
				}
				break;

			case R.id.monday6:
				if (mon_sixth_cName.equals("")) {
					openAddCourseEditDialog(monday.getText() + "  "
							+ sixth.getText());
				} else {
					openShowCourseDetailDialog(mon_sixth_id);
				}
				break;
			case R.id.tuesday6:
				if (tues_sixth_cName.equals("")) {
					openAddCourseEditDialog(tuesday.getText() + "  "
							+ sixth.getText());
				} else {
					openShowCourseDetailDialog(tues_sixth_id);
				}
				break;
			case R.id.wednesday6:
				if (wed_sixth_cName.equals("")) {
					openAddCourseEditDialog(wednesday.getText() + "  "
							+ sixth.getText());
				} else {
					openShowCourseDetailDialog(wed_sixth_id);
				}
				break;
			case R.id.thursday6:
				if (thurs_sixth_cName.equals("")) {
					openAddCourseEditDialog(thursday.getText() + "  "
							+ sixth.getText());
				} else {
					openShowCourseDetailDialog(thurs_sixth_id);
				}
				break;
			case R.id.friday6:
				if (fri_sixth_cName.equals("")) {
					openAddCourseEditDialog(friday.getText() + "  "
							+ sixth.getText());
				} else {
					openShowCourseDetailDialog(fri_sixth_id);
				}
				break;

			default:
				break;
			}
		}

	}

	/**
	 * 打开添加课程对话框
	 */
	public void openAddCourseEditDialog(String title) {
		// 获取另一个布局的引用，从此能再次activity中使用该布局引用的组件id，即findViewById可以顺利使用
		LayoutInflater inflater = getActivity().getLayoutInflater();
		layout = inflater.inflate(R.layout.syllabus_dialog,
				(ViewGroup) view.findViewById(R.id.dialog));

		dialog_courseName = (EditText) layout
				.findViewById(R.id.dialog_coursename);
		dialog_address = (EditText) layout.findViewById(R.id.dialog_address);
		dialog_single = (RadioButton) layout.findViewById(R.id.single);
		dialog_couple = (RadioButton) layout.findViewById(R.id.couple);
		dialog_singleAndCouple = (RadioButton) layout
				.findViewById(R.id.singleandcouple);

		AlertDialog.Builder builder = new Builder(this.getActivity());
		builder.setTitle("星期" + title + "节").setView(layout)
				.setPositiveButton("确定", dialogButtonListener(title))
				.setNegativeButton("取消", dialogButtonListener(title)).show();

	}

	// 打开查看课程信息列表对话框
	public void openShowCourseDetailDialog(final int id) {
		intent = getActivity().getIntent();
		final MyDB db = new MyDB(getActivity());
		final Course course = db.queryCourseById(id);
		String strcName = course.getcName();
		if (strcName.equals("有课")) {
			strcName = "";
		}
		String strIsRemind;
		String strIsRemindByVibrato;
		String strIsRemindByRing;
		if (course.isRemind()) {
			strIsRemind = "是";
		} else {
			strIsRemind = "否";
		}
		if (course.isRemindByVibrato()) {
			strIsRemindByVibrato = "是";
		} else {
			strIsRemindByVibrato = "否";
		}
		if (course.isRemindByRing()) {
			strIsRemindByRing = "是";
		} else {
			strIsRemindByRing = "否";
		}
		String period = course.getPeriod();
		String strPeriod = null;
		if (period.equals("0")) {
			strPeriod = "单双周";
		} else if (period.equals("11") || period.equals("12")) {
			strPeriod = "单周";
		} else if (period.equals("22") || period.equals("21")) {
			strPeriod = "双周";
		}
		String infoItemp[] = {
				"课程名称：" + strcName,
				"上课地点：" + course.getAddress(),
				"时间(" + strPeriod + ")：" + course.getStartTime() + "-"
						+ course.getEndTime(),
				"提醒时间：" + course.getRemindTime(), "启动提醒：" + strIsRemind,
				"提醒震动：" + strIsRemindByVibrato, "提醒铃声：" + strIsRemindByRing,
				"任课老师：" + course.getTeacher() };
		
		AlertDialog.Builder builder = new Builder(this.getActivity());
		builder.setTitle("课程信息（"+"星期"+course.getWeek()+"  "+course.getWhichLesson()+"节）").setItems(infoItemp, null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		}).setNeutralButton("编辑", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				intent.setClass(getActivity().getBaseContext(), CourseInfoActivity.class);
				intent.putExtra("id", id+"");
				getActivity().startActivity(intent);
				getActivity().finish();
			}
		}).setNegativeButton("删除", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				openIsConfirmDeleteDialog(id, db, course);
			}
		}).show();
		
		
	}

	/**
	 * 对话框里的按钮事件(确定 取消)
	 */
	public android.content.DialogInterface.OnClickListener dialogButtonListener(
			final String title) {

		return new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case -1:
					String strRadioButtonText = null;
					if (dialog_single.isChecked()) {
						strRadioButtonText = dialog_single.getText().toString();
					} else if (dialog_couple.isChecked()) {
						strRadioButtonText = dialog_couple.getText().toString();
					} else if (dialog_singleAndCouple.isChecked()) {
						strRadioButtonText = dialog_singleAndCouple.getText()
								.toString();
					}
					intent = getActivity().getIntent();
					intent.setClass(getActivity().getBaseContext(),
							CourseInfoActivity.class);   //跳转到详细页面
					intent.putExtra("id", "");
					intent.putExtra("week_classnumber", title);
					intent.putExtra("courseName", dialog_courseName
							.getEditableText().toString());
					intent.putExtra("address", dialog_address.getEditableText()
							.toString());
					intent.putExtra("period", strRadioButtonText);
					getActivity().startActivity(intent);
					getActivity().finish();
					break;
				case -2:
					dialog.cancel();
					break;

				default:
					break;
				}
			}
		};

	}
	
	// 打开确认删除星期1-5某个课程的对话框
    public void openIsConfirmDeleteDialog(final int id, final MyDB db, final Course course) {
    	String cName = course.getcName();
    	if(cName.equals("有课")){
    		cName = "";
    	}
    	
    	AlertDialog.Builder builder = new Builder(this.getActivity());
    	builder.setTitle("删除确认对话框")
    	.setMessage("星期"+course.getWeek()+"  "+course.getWhichLesson()+"节\n"+cName+"\n确定删除吗？")
    	.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog, int which) {
				db.deleteCourseById(id);// 删除数据库里的对应记录
				
				getActivity().finish();
				intent = getActivity().getIntent();
				intent.setClass(getActivity(), Syllabus.class);
				getActivity().startActivity(intent);
			}
		}).setNegativeButton("取消", null).show();
	}
	

}
