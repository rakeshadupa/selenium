package com.maven.sample;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Practice2 {
	 public static void main(String[] args) throws Exception{ 
	      String exp = "15+20+(3.84*25)*(78/3.8)";
	      LinkedList<String> a = new LinkedList<String>();

	      StringTokenizer st = new StringTokenizer(exp, "+*/-()", true);
	      while(st.hasMoreTokens())
	         System.out.println( a.add(st.nextToken()));
	    } 
}