package com.bootcamp.worksadvanced.project01.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bootcamp.worksadvanced.project01.dto.ResponseMessage;
import com.bootcamp.worksadvanced.project01.util.GlobalMessage;
import com.bootcamp.worksadvanced.project01.util.GlobalType;


@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = Exception.class)
	public ResponseMessage<String> defaultErrorHandler(){
		return ResponseMessage.<String>builder().entity("Exception Handled").errorCode(GlobalType.Error.GENERIC_ERROR).message(GlobalMessage.Error.GENERIC_ERROR).build();
	}
}
