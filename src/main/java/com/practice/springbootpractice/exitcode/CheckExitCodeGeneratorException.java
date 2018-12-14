package com.practice.springbootpractice.exitcode;

import org.springframework.boot.ExitCodeGenerator;

public class CheckExitCodeGeneratorException extends RuntimeException implements ExitCodeGenerator {

	public CheckExitCodeGeneratorException(){
		super();
	}
	
	
	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		return 100;
	}

}
