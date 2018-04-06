package practice;

import org.testng.annotations.Test;
public class RunEmulators {
	@Test
	public void go() {

		Emulator1 e1 = new Emulator1();
		Thread a1 = new Thread(e1);
		Emulator2 e2 = new Emulator2();
		Thread a2 = new Thread(e2);

		a1.start();
		a2.start();

	}
}
