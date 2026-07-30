package com._1_calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class _1_1_Calendar {

	public static void main(String[] args) {
		//calendarFields();;
		//settingValues();
		//addingAndSubtractingDates();
		//beforeAfterAndCompare();
		datePasing();

	}
	
	public static void datePasing_Lenient_false() {
		//String inputDate = "14-09-2000";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		//String inputDate = "14-sep-2000";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		String inputDate = "14-September-2000";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
		
		
		simpleDateFormat.setLenient(false);
		
		try {
			Date date = simpleDateFormat.parse(inputDate);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			System.out.println("Date: "+date);
			System.out.println("Day: "+calendar.get(Calendar.DAY_OF_MONTH));
	        System.out.println("Month# : " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
			System.out.println("Month: "+(calendar.get(Calendar.MONTH)+1));
			System.out.println("Year: "+calendar.get(Calendar.YEAR));
		} catch (ParseException e) {
			System.out.println(inputDate+" is invalid date.");
			e.printStackTrace();
		}
		
		
	}
	
	public static void datePasing() {
		//String inputDate = "14-09-2000";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		//String inputDate = "14-sep-2000";
		//SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
		
		String inputDate = "31-September-2000";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
		
		
		
		try {
			Date date = simpleDateFormat.parse(inputDate);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			System.out.println("Date: "+date);
			System.out.println("Day: "+calendar.get(Calendar.DAY_OF_MONTH));
	        System.out.println("Month# : " + calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
			System.out.println("Month: "+(calendar.get(Calendar.MONTH)+1));
			System.out.println("Year: "+calendar.get(Calendar.YEAR));
		} catch (ParseException e) {
			System.out.println(inputDate+" is invalid date.");
			e.printStackTrace();
		}
		
		
	}
	
	public static void beforeAfterAndCompare() {
		Calendar calendar = Calendar.getInstance();
		Calendar futureCalendar = Calendar.getInstance();
		futureCalendar.add(Calendar.DATE, 365);
		
		System.out.println("current Time: "+calendar.getTime());
		System.out.println("future time: "+futureCalendar.getTime());
		
		System.out.println("calendar.before(futureCalendar): "+calendar.before(futureCalendar));
		System.out.println("futureCalendar.after(calendar): "+futureCalendar.after(calendar));
		System.out.println("calendar.after(futureCalendar): "+calendar.after(futureCalendar));
		System.out.println("futureCalendar.before(calendar): "+futureCalendar.before(calendar));
		
		System.out.println("calendar.compareTo(futureCalendar): "+calendar.compareTo(futureCalendar));
		System.out.println("calendar.compareTo(calendar): "+calendar.compareTo(calendar));
		System.out.println("futureCalendar.compareTo(calendar): "+futureCalendar.compareTo(calendar));
	}
	
	public static void addAndRoll() {
		Calendar calendar = Calendar.getInstance();
		//Difference between add() and roll()
				/*
				 * add() 
				 * 		Changes the specified field. 
				 * 		Carries over to larger fields when necessary (month, year, etc.).
				 */
				calendar.set(2026, Calendar.DECEMBER, 31);
				calendar.add(Calendar.DATE,5);
				System.out.println(calendar.getTime());
				/*
				 * roll() 
				 * 		Changes only the specified field. 
				 * 		Does NOT change larger fields.
				 */
				
				calendar.set(2026, Calendar.DECEMBER, 31);
				calendar.roll(Calendar.DATE,5);
				System.out.println(calendar.getTime());
								
	}
	
	public static void addingAndSubtractingDates() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("current Date: "+calendar.getTime());
		
		calendar.add(Calendar.DATE,5);
		System.out.println("Date after added 5 days: "+ calendar.getTime());
		
		calendar.add(Calendar.DATE, -10);
		System.out.println("Date after subtracted 10 days: "+calendar.getTime());
		
		
	}
	
	public static void settingValues() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("current Date: "+calendar.getTime());
		calendar.set(Calendar.YEAR, 2026);
		calendar.set(Calendar.MONTH, 11);
		calendar.set(Calendar.DATE, 14);
		
		System.out.println("Date after setted: "+calendar.getTime());
	}
	public static void calendarFields() {
		Calendar calendar = Calendar.getInstance();
		System.out.println("Year: "+ calendar.get(Calendar.YEAR));
		System.out.println("Month: "+calendar.get(Calendar.MONTH));
		System.out.println("DayOfMonth: "+calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DayOfWeak: "+calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("Date: "+calendar.get(Calendar.DATE));
		System.out.println("Hour: "+calendar.get(Calendar.HOUR));
		System.out.println("Minute: "+ calendar.get(Calendar.MINUTE));
		System.out.println("Second: "+calendar.get(Calendar.SECOND));
		System.out.println("MilliSecond: "+calendar.get(Calendar.MILLISECOND));
				
	}
}
