package cn.blaze.test;

import org.apache.commons.lang3.RandomStringUtils;

public class test {

	public static void main(String[] args) {
		test();
	}

	public static void test(){
		String password = RandomStringUtils.randomNumeric(6);
		System.out.println(password);
	}
}
