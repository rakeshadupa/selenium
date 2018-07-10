package sikuli;

import java.io.IOException;

import org.sikuli.script.Finder;
import org.sikuli.script.Pattern;


public class SikuliUtils {

	public static void compareImageInSikuli(String actualImagePath, String expectedImagePath) throws IOException {

		Pattern p = new Pattern(actualImagePath);

		Finder findr = new Finder(expectedImagePath);
		findr.find(p);
		if (findr.hasNext()) {
			System.out.println("Matching");
			findr.next();
		} else {
			System.out.println("Not matching");
		}

	}
}
