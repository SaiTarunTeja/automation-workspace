package com._1_calendar;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class _1_2_TimeAPI {

	public static void main(String[] args) {
		getcurrentTimeStamp();

	}
	public static void getcurrentTimeStamp() {
	LocalDate localDate = LocalDate.now();
	System.out.println(localDate);
	System.out.println(localDate.getYear());
	System.out.println(localDate.getMonth());
	System.out.println(localDate.getDayOfMonth());
	System.out.println(localDate.getMonthValue());
	System.out.println(localDate.getDayOfYear());
	System.out.println(localDate.getDayOfWeek());
	System.out.println(localDate.getChronology());
		
	LocalTime localTime = LocalTime.now(); 
	System.out.println(localTime);
	System.out.println(localTime.getHour());
	System.out.println(localTime.getMinute());
	System.out.println(localTime.getSecond());
	System.out.println(localTime.getNano());
	
	LocalDateTime localDateTime = LocalDateTime.now();
	System.out.println(localDateTime);
	System.out.println(localDateTime.getYear());
	System.out.println(localDateTime.getMonth()+" "+localDateTime.getMonthValue());
	System.out.println(localDateTime.getDayOfMonth());
	System.out.println(localDateTime.getHour()+" "+localDateTime.getMinute()+" "+localDateTime.getSecond());
	
	Instant instant = Instant.now();
	System.out.println(instant);
	System.out.println(instant.getEpochSecond());
	
	//ZoneId
	System.out.println(ZoneId.getAvailableZoneIds());
	System.out.println(ZoneId.systemDefault());
	List<String> asiaZoneIds = ZoneId.getAvailableZoneIds()
			.stream()
			.filter(zone -> zone.startsWith("Asia/"))
			.sorted()
			.toList();
	asiaZoneIds.forEach(System.out::println);
	
	//ZoneTime
	System.out.println(ZonedDateTime.now());
	System.out.println("India: "+ZonedDateTime.now(ZoneId.of("Asia/Calcutta"))+" \nLondon: "+ZonedDateTime.now(ZoneId.of("Europe/London")));
	
	//OffsetDateTime
    System.out.println(OffsetDateTime.now());
    
    //Duration
    Duration duration = Duration.parse("P1DT20H30M");
    System.out.println(duration);
    
    LocalTime start = LocalTime.of(9, 0);
    LocalTime end = LocalTime.of(10, 30);
    
    System.out.println(Duration.between(start, end));
    
    //Duration Ex2
    Instant start1 = Instant.now();

 // Some work
 try {
	Thread.sleep(1500);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

 Instant end1 = Instant.now();

 Duration duration1 = Duration.between(start1, end1);
 System.out.println(duration1.toMillis()); // ~1500
    
	}
}
