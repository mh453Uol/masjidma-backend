package com.mh453Uol.masjidma.utils;

import java.time.LocalTime;

public class Time {
	public static java.sql.Time toSqlTime(LocalTime localTime) {
	    return java.sql.Time.valueOf(localTime);
	  }
}
