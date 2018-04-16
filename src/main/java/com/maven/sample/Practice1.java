package com.maven.sample;

class Boom {
	protected Boom() {
		System.out.println("super");

	}
}

public class Practice1 extends Boom {

	private Practice1() {
		System.out.println("sub");
	}

	public static void main(String[] args) {
		new Practice1();
	}
}
