package org.parallelexe;

import org.testng.annotations.Test;

public class TestingClass {
	
	@Test
	private void tc01() {
		System.out.println("Test1 TestingClass :" + Thread.currentThread().getId());
	}
	
	@Test
	private void tc02() {
		System.out.println("Test2 TestingClass :" + Thread.currentThread().getId());
	}
	
	@Test
	private void tc03() {
		System.out.println("Test3 TestingClass :" + Thread.currentThread().getId());
	}
	
	@Test
	private void tc04() {
		System.out.println("Test4 TestingClass :" + Thread.currentThread().getId());
	}
	
	@Test
	private void tc05() {
		System.out.println("Test5 TestingClass :" + Thread.currentThread().getId());
	}

}


