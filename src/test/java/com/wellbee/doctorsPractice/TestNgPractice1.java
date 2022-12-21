package com.wellbee.doctorsPractice;

import org.testng.annotations.Test;

public class TestNgPractice1 {
	@Test
	public void test1() {
		System.out.println("TEST1");
	}
	
	@Test(groups="regression")
	public void test2() {
		System.out.println("TEST2");
	}
	
	@Test(groups="sanity")
	public void test3() {
		System.out.println("TEST3");
	}

}
