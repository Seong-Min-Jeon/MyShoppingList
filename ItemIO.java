package javaTermProject;
import java.util.ArrayList;

import javax.swing.JOptionPane;
// Item�� input output�ϴ� Ŭ�����Դϴ�. Minimum Functions 1
public class ItemIO {
	
	public void InputItem(Item item, ArrayList<Item> ary) { //Item�� input�ϴ� method�Դϴ�.
		//���� ary�ȿ� �ִ� Item �� item�� ���� �̸��� ���� ���Ұ� �ִٸ� ary�� input�� �ȵǵ��� ��.
		FileIO fileIO = new FileIO();
		try {
			fileIO.InputItem("Past List.txt",item);
		} catch (Exception E) {
			JOptionPane.showMessageDialog(null, "Can't create files.");
		}
	}
	public Item OutputItem(String name, ArrayList<Item> ary) { //name�� �׸��̸��� Item�� Output�մϴ�. 
		//���� ary�ȿ� name�̶�� �̸��� ���� Item�� ���ٸ� ���ٰ� ����� ���� return null;
		return null; //Output���� Item�� return�˴ϴ�. �Ŀ� 'name'�� �����Ǿ����ϴ�. �޼����� �̿�.
	}
}