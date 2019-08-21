package com.maven.sample;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class Practice1   {
	 @Test
	public  void testt() {
		 String[] s1=new String[1];
		 String[] s2=new String[1];

		 List<String[]> l1=new ArrayList<String[]>();
		 l1.add(s1);
		 List<String[]> l2=new ArrayList<String[]>();
		 l2.add(s2);
		 System.out.println(l1.equals(l2));
		 
		 
	}
}
