package kr.or.ddit.homework;

import java.util.Date;

public class Homework01 {
	public static void main(String[] args) {
		Date date = new Date();
		
		//기준일로 부터 지난 시간
		long time = date.getTime();
		System.out.println(time);
		
		//기준일로 부터 ?년 ?일 ?시 ?분 ?초
		
		long year = time / 365 / 24 / 60 / 60 / 1000;
		time = time - year * 365 * 24 * 60 * 60 * 1000;
		
		long day = time / 24 / 60 / 60 / 1000;
		time = time - day * 24 * 60 * 60* 1000;
		
		long hour = time / 60 / 60 / 1000;
		time = time - hour * 60 * 60 * 1000;
		
		long min = time / 60 / 1000;
		time = time - min * 60 * 1000;
		
		long sec = time / 1000;
		System.out.println("기준일로 부터"+year+"년"+day+"일"+hour+"시"+min+"분"+sec+"초");
		
		
	}
}
