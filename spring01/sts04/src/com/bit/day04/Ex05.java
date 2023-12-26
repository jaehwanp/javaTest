package com.bit.day04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.bit.day04.modul.Module;

public class Ex05 {
	public static void main(String[] args) {
		String filename="classpath:/applicationContext.xml";
		
		ApplicationContext ctxt=null;
//		ctxt=new ClassPathXmlApplicationContext(filename);
		String path="C:\\java\\workspace4\\sts04\\src\\";
//		ctxt=new FileSystemXmlApplicationContext(path+filename); // root를 기준으로 경로 설정
		
		new GenericXmlApplicationContext(filename);				//classpath, filesystem 합친 것
		
		Module module=(Module)ctxt.getBean("module");
		System.out.println(module.getMsg());
	}
}
