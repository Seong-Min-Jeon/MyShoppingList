package javaTermProject;
import java.io.IOException;
import java.util.ArrayList;

public class Start {
	ArrayList<List> metaList = new ArrayList<>();
	ArrayList<List> ListAry = new ArrayList<>();

	public Start() {
		FileIO fileIO = new FileIO();
		try {
			ArrayList<List> ListAry = fileIO.OutputFinal("List.txt", metaList);
			this.ListAry = ListAry;
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<List> getList(){
		Start s = new Start();
		return s.ListAry;
	}
}
