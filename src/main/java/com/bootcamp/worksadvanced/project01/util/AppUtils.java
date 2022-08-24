package com.bootcamp.worksadvanced.project01.util;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class AppUtils {

	public static LocalDateTime localDateTime() {
		return LocalDateTime.now(ZoneId.of("America/Lima"));
	}
}
