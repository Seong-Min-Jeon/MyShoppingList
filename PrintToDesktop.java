package javaTermProjectPackage;
import java.util.ArrayList;
import java.io.*;

public class PrintToDesktop {
	
	public PrintToDesktop(ArrayList<Item> ary, String name) throws IOException {
		String str = System.getProperty("user.home") + "/Desktop";
		File fn  = new File(str + "\\" + name + ".txt");
		try {
			FileWriter fw = new FileWriter(fn);
			Writer output = new BufferedWriter(fw);
			for(int i = 0 ; i < ary.size() - 1 ; i++) {
				output.write(ary.get(i + 1).toString() + "\n");
			}
			output.close();
		} catch (Exception e1) {
			System.err.println(e1);
		}
	}

}
