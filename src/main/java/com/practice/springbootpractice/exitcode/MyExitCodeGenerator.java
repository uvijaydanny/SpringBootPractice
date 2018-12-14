package com.practice.springbootpractice.exitcode;

import org.springframework.boot.ExitCodeGenerator;

public class MyExitCodeGenerator implements ExitCodeGenerator {

	@Override
	public int getExitCode() {
		// TODO Auto-generated method stub
		return 500;
	}

}
