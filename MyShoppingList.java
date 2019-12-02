//Æó±â


package javaTermProject;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class MyShoppingList extends JFrame{
	
	public MyShoppingList() {
		setTitle("Test");
		Start st = new Start();
		
		ArrayList<List> ListAry = st.getList();

		System.out.println(ListAry);
		
		/*
		for(int i = 1 ; i < 3 ; i++) {
			String group = "group" + i;
			s.metaList.add(group);
		}
		*/
		
		/*
		Item i1 = new Item("aa");
		Item i2 = new Item("bb",5);
		Item i3 = new Item("ccc", 10);
		ArrayList<Item> a = new ArrayList<>();
		ArrayList<Item> b = new ArrayList<>();
		a.add(i1);
		b.add(i2);
		b.add(i3);
		List l1 = new List("name1", a);
		List l2 = new List("name2", b);
		ListAry.add(l1);
		ListAry.add(l2);
		*/
		
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileIO fileIO = new FileIO();
				try {
					fileIO.Input("List.txt",ListAry);
					
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Can't create files.");
				}
				System.exit(0);
			}
		});
		
		Container c = getContentPane();
		Item i = new Item("name",3);
		c.add(new JCheckBox(i.name));
		
		setSize(500,700);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyShoppingList();
	}
}
