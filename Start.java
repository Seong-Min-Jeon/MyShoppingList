package javaTermProjectPackage;
import java.io.IOException;
import java.util.ArrayList;

public class Start {
	ArrayList<List> ListAry = new ArrayList<>();

	public Start() {
		FileIO fileIO = new FileIO();
		try {
			ArrayList<List> ListAry = fileIO.OutputFinal("List.txt");
			this.ListAry = ListAry;
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	public ArrayList<List> getList(){
		return ListAry;
	}
}
