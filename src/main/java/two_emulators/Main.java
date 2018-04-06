package two_emulators;

import org.testng.annotations.Test;

public class Main {
	@Test
public void go() {
	
	One t1=new One();
	Thread a1=new Thread(t1);
	Two t2=new Two();
	Thread a2=new Thread(t2);
	
	
	a1.start();
	a2.start();


}

}
