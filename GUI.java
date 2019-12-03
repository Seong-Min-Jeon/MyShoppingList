package javaTermProjectPackage;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;


public class GUI extends JFrame {
	
	public static final int SCREEN_WIDTH = 1024;
	public static final int SCREEN_HEIGHT = 576;
	private JScrollPane scrollPane;
	private JTable table;
	private ImageIcon rename = new ImageIcon(GUI.class.getResource("../image/Comp 1_00003.png"));
	private Icon goToList = new ImageIcon(GUI.class.getResource("../image/Comp 1_00002.png"));
	private Icon addListEnter = new ImageIcon(GUI.class.getResource("../image/Comp 2_00008.png"));
	private Icon addListExit = new ImageIcon(GUI.class.getResource("../image/Comp 2_00009.png"));
	private JButton addList = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 2_00009.png")));
	private Icon pastItemEnter = new ImageIcon(GUI.class.getResource("../image/Comp 2_00000.png"));
	private Icon pastItemExit = new ImageIcon(GUI.class.getResource("../image/Comp 2_00001.png"));
	private JButton pastItem = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 2_00001.png")));
	private Icon todayEnter = new ImageIcon(GUI.class.getResource("../image/Comp 2_00002.png"));
	private Icon todayExit = new ImageIcon(GUI.class.getResource("../image/Comp 2_00003.png"));
	private JButton today = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 2_00003.png")));
	private Icon bookMarkEnter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00000.png"));
	private Icon bookMarkExit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00001.png"));
	private JButton bookMark = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00001.png")));
	private Icon addItemEnter = new ImageIcon(GUI.class.getResource("../image/Comp 2_00004.png"));
	private Icon addItemExit = new ImageIcon(GUI.class.getResource("../image/Comp 2_00005.png"));
	private JButton addItem = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 2_00005.png")));
	private Icon homeEnter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00008.png"));
	private Icon homeExit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00009.png"));
	private JButton home = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00009.png")));
	private Icon trashEnter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00006.png"));
	private Icon trashExit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00007.png"));
	private JButton trash = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00007.png")));
	private Icon trash2Enter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00006.png"));
	private Icon trash2Exit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00007.png"));
	private JButton trash2 = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00007.png")));
	private Icon printEnter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00004.png"));
	private Icon printExit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00005.png"));
	private JButton print = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00005.png")));
	private Icon dupEnter = new ImageIcon(GUI.class.getResource("../image/Comp 2_00006.png"));
	private Icon dupExit = new ImageIcon(GUI.class.getResource("../image/Comp 2_00007.png"));
	private JButton dup = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 2_00007.png")));
	private Icon moveEnter = new ImageIcon(GUI.class.getResource("../image/Comp 4_00000.png"));
	private Icon moveExit = new ImageIcon(GUI.class.getResource("../image/Comp 4_00001.png"));
	private JButton move = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 4_00001.png")));
	private Icon home2Enter = new ImageIcon(GUI.class.getResource("../image/Comp 1_00008.png"));
	private Icon home2Exit = new ImageIcon(GUI.class.getResource("../image/Comp 1_00009.png"));
	private JButton home2 = new JButton(new ImageIcon(GUI.class.getResource("../image/Comp 1_00009.png")));
	private ArrayList<List> listAry;
	private ArrayList<Item> listAry2;
	private DefaultTableModel model;
	private int listIdx;
	private int listIdx2;
	private String listNameField;
	private Container c1;
	private Container c2;
	private Container c3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				GUI frame = new GUI();
				frame.setVisible(true);
			}
		});
	}

	public GUI() {
	
		setTitle("MyShoppingList");
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		setLayout(null);

		//Container c = getContentPane();
		//c.setLayout(null);
		
		Start st = new Start();

		listAry = st.getList();

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				FileIO fileIO = new FileIO();
				try {
					fileIO.Input("List.txt", listAry);
				} catch (Exception E) {
					JOptionPane.showMessageDialog(null, "Can't create files.");
				}
				System.exit(0);
			}
		});
		//d1
		AddListListener addListListener = new AddListListener();
		addList.addMouseListener(addListListener);
		
		TodayListener todayListener = new TodayListener();
		today.addMouseListener(todayListener);
		
		BookMarkListener bookMarkListener = new BookMarkListener();
		bookMark.addMouseListener(bookMarkListener);
		
		TrashListener trashListener = new TrashListener();
		trash.addMouseListener(trashListener);
		
		PastItemListener pastItemListener = new PastItemListener();
		pastItem.addMouseListener(pastItemListener);
		//d2
		AddItemListener addItemListener = new AddItemListener();
		addItem.addMouseListener(addItemListener);
		
		HomeListener homeListener = new HomeListener();
		home.addMouseListener(homeListener);
		
		Trash2Listener trash2Listener = new Trash2Listener();
		trash2.addMouseListener(trash2Listener);
		
		MoveListener moveListener = new MoveListener();
		move.addMouseListener(moveListener);
		
		DupListener dupListener = new DupListener();
		dup.addMouseListener(dupListener);
		//d3
		Home2Listener home2Listener = new Home2Listener();
		home2.addMouseListener(home2Listener);

		d1(listAry);
	}
	
	public void d1(ArrayList<List> listAry) {
		setTitle("Main");
		
		c1 = getContentPane();
		c1.setLayout(null);
		
		// ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		c1.add(scrollPane);

		// Table
		table = new JTable();
		// table.setShowHorizontalLines(false);
		// table.setShowVerticalLines(false);
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return Icon.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("List Name");
		model.addColumn("Go to List");
		model.addColumn("Modify Name");
		model.addColumn("Select");

		table.getColumnModel().getColumn(0).setPreferredWidth(900);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.size() - 2; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(i + 2).name, i, 0);
			model.setValueAt(goToList, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
		
		pastItem.setBounds(5,-10,200,100);
		pastItem.setBorderPainted(false);
		pastItem.setContentAreaFilled(false);
		pastItem.setFocusPainted(false);
		c1.add(pastItem);
		
		addList.setBounds(650,-10,200,100);
		addList.setBorderPainted(false);
		addList.setContentAreaFilled(false);
		addList.setFocusPainted(false);
		c1.add(addList);
		
		today.setBounds(260,-10,200,100);
		today.setBorderPainted(false);
		today.setContentAreaFilled(false);
		today.setFocusPainted(false);
		c1.add(today);
		
		bookMark.setBounds(470,0,80,80);
		bookMark.setBorderPainted(false);
		bookMark.setContentAreaFilled(false);
		bookMark.setFocusPainted(false);
		c1.add(bookMark);
		
		trash.setBounds(900,0,80,80);
		trash.setBorderPainted(false);
		trash.setContentAreaFilled(false);
		trash.setFocusPainted(false);
		c1.add(trash);
		
		ModifyListener modifyListener = new ModifyListener();
		table.addMouseListener(modifyListener);
		
		GoToListListener goToListListener = new GoToListListener();
		table.addMouseListener(goToListListener);
		
	}
		
	private class AddListListener extends JFrame implements MouseListener {


		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			JFrame f = new JFrame();
			f.setTitle("Add List");
			f.setSize(300, 190);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setVisible(true);
			f.setLayout(null);
			JLabel la1 = new JLabel("리스트의 이름");
			la1.setBounds(99,10,120,30);
			f.add(la1);
			JTextField tf1 = new JTextField();
			tf1.setBounds(80,50,120,30);
			f.add(tf1);
			JButton b = new JButton("확인");
			b.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					boolean no = false;
					String nameData = tf1.getText();
					for(int i = 0 ; i < listAry.size() ; i++) {
						String preName = listAry.get(i).name;
						if(nameData.equals(preName)) {
							no = true;
						}
					}
					if(no == false) {
						ArrayList<Item> ary = new ArrayList<>();
						Item i = new Item("NullItemData");
						ary.add(i);
						List list = new List(nameData,ary);
						listAry.add(list);
						model.addRow(new Object[0]);
						model.setValueAt("      " + listAry.get(listAry.size() - 1).name, listAry.size() - 3, 0);
						model.setValueAt(goToList, listAry.size() - 3, 1);
						model.setValueAt(rename, listAry.size() - 3, 2);
						model.setValueAt(false, listAry.size() - 3, 3);
						f.setVisible(false);
					} else JOptionPane.showMessageDialog(null, "같은 이름의 리스트가 이미 존재합니다!");
				}
			});
			b.setBounds(110,90,60,35);
			f.add(b);			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			addList.setIcon(addListEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			addList.setIcon(addListExit);
		}
			
	}
	
	private class ModifyListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if(column == 2) {
				JFrame f = new JFrame();
				f.setTitle("Modify Name");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("  수정할 이름");
				la1.setBounds(99,10,120,30);
				f.add(la1);
				JTextField tf1 = new JTextField();
				tf1.setBounds(80,50,120,30);
				f.add(tf1);
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nameData = tf1.getText();
						listAry.get(row + 2).name = nameData;
						model.setValueAt("      " + listAry.get(row+2).name, row, 0);
						f.setVisible(false);
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);			
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {
		}
		
	}
	
	private class TodayListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			pastItem.setVisible(false);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addList.setVisible(false);
			today.setVisible(false);
			bookMark.setVisible(false);
			trash.setVisible(false);
			addItem.setVisible(true);
			trash2.setVisible(true);
			home.setVisible(true);
			print.setVisible(true);
			dup.setVisible(true);
			move.setVisible(true);
			listIdx = 1;
			d2(listIdx);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			today.setIcon(todayEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			today.setIcon(todayExit);
		}
		
	}
	
	private class BookMarkListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			pastItem.setVisible(false);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addList.setVisible(false);
			today.setVisible(false);
			bookMark.setVisible(false);
			trash.setVisible(false);
			addItem.setVisible(true);
			trash2.setVisible(true);
			home.setVisible(true);
			print.setVisible(true);
			dup.setVisible(true);
			move.setVisible(true);
			listIdx = 0;
			d2(listIdx);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			bookMark.setIcon(bookMarkEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			bookMark.setIcon(bookMarkExit);
		}
		
	}
	
	private class GoToListListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if (column == 1) {
				pastItem.setVisible(false);
				scrollPane.setVisible(false);
				table.setVisible(false);
				addList.setVisible(false);
				today.setVisible(false);
				bookMark.setVisible(false);
				trash.setVisible(false);
				addItem.setVisible(true);
				home.setVisible(true);
				trash2.setVisible(true);
				print.setVisible(true);
				dup.setVisible(true);
				move.setVisible(true);
				listIdx = row + 2;
				d2(listIdx);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
	}
	
	private class TrashListener extends JFrame implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			ArrayList<Integer> CheckBoxAry = new ArrayList<>();
			for(int i = 0 ; i < listAry.size() - 2 ; i++) {
				if ((boolean)table.getValueAt(i,3) == true) 
					CheckBoxAry.add(i);
			}
			if(CheckBoxAry.size() > 0) {
				System.out.println(CheckBoxAry.toString());
				JFrame f = new JFrame();
				f.setTitle("Delete List");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("삭제된 리스트는 복구가 불가능합니다.");
				la1.setBounds(44,0,300,80);
				f.add(la1);
				JLabel la2 = new JLabel("삭제하시겠습니까?");
				la2.setBounds(89,38,120,60);
				f.add(la2);
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int tmp = 2;
						for(int i = 0 ; i < CheckBoxAry.size() ; i++) {
							listAry.remove(CheckBoxAry.get(i) + tmp);	
							tmp--; 
						}
						JOptionPane.showMessageDialog(null, "삭제되었습니다!");
						f.setVisible(false);
						table.setVisible(false);
						scrollPane.setVisible(false);
						UpdateTable();
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);	
			} else JOptionPane.showMessageDialog(null, "체크박스를 선택하지 않았습니다!");
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			trash.setIcon(trashEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			trash.setIcon(trashExit);
		}
		
	}
	
	private class PastItemListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			pastItem.setVisible(false);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addList.setVisible(false);
			today.setVisible(false);
			bookMark.setVisible(false);
			trash.setVisible(false);
			home2.setVisible(true);
			d3();
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			pastItem.setIcon(pastItemEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			pastItem.setIcon(pastItemExit);
		}
		
	}
	
	public void d2(int row) {
		setTitle(listAry.get(listIdx).name);
		
		c2 = getContentPane();
		c2.setLayout(null);
		
		// ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		c2.add(scrollPane);

		// Table
		table = new JTable();
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("Item Name");
		model.addColumn("QTY");
		model.addColumn("Modify Data");
		model.addColumn("Select");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(800);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.get(row).ary.size() - 1; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(row).ary.get(i+1).name, i, 0);
			model.setValueAt("    " + listAry.get(row).ary.get(i+1).num, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
		
		addItem.setBounds(600,-10,200,100);
		addItem.setBorderPainted(false);
		addItem.setContentAreaFilled(false);
		addItem.setFocusPainted(false);
		c2.add(addItem);
		
		home.setBounds(800,0,80,80);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		c2.add(home);
		
		trash2.setBounds(900,0,80,80);
		trash2.setBorderPainted(false);
		trash2.setContentAreaFilled(false);
		trash2.setFocusPainted(false);
		c2.add(trash2);
		
		print.setBounds(20,0,80,80);
		print.setBorderPainted(false);
		print.setContentAreaFilled(false);
		print.setFocusPainted(false);
		c2.add(print);
		
		dup.setBounds(380,-10,200,100);
		dup.setBorderPainted(false);
		dup.setContentAreaFilled(false);
		dup.setFocusPainted(false);
		c2.add(dup);
		
		move.setBounds(150,-10,200,100);
		move.setBorderPainted(false);
		move.setContentAreaFilled(false);
		move.setFocusPainted(false);
		c2.add(move);
	
		ModifyItemListener modifyItemListener = new ModifyItemListener();
		table.addMouseListener(modifyItemListener);
	}
	
	private class AddItemListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			JFrame f = new JFrame();
			f.setTitle("Add Item");
			f.setSize(300, 190);
			f.setLocationRelativeTo(null);
			f.setResizable(false);
			f.setVisible(true);
			f.setLayout(null);
			JLabel la1 = new JLabel("아이템의 이름");
			la1.setLocation(40, -30);
			la1.setSize(100,100);
			JLabel la2 = new JLabel("수량");
			la2.setLocation(196, -30);
			la2.setSize(100,100);
			f.add(la1);
			f.add(la2);
			JTextField tf1 = new JTextField();
			tf1.setBounds(20,50,120,30);
			JTextField tf2 = new JTextField();
			tf2.setBounds(150,50,120,30);
			f.add(tf1);
			f.add(tf2);
			JButton b = new JButton("확인");
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ItemIO itemIO = new ItemIO();
					String nameData = tf1.getText();
					String qtyData = tf2.getText();
					try {
						try {
							if(Integer.parseInt(qtyData) < 0) {
								Exception ex = new Exception();
								throw ex;
							}
						} catch (NumberFormatException exception) {
							JOptionPane.showMessageDialog(null, "수량에는 정수를 넣어주세요!");
						} catch (Exception exception) {
							JOptionPane.showMessageDialog(null, "음수를 넣지 말아주세요!");
						}
						if(Integer.parseInt(qtyData) > 0) {
							Item i = new Item(nameData,Integer.parseInt(qtyData));
							itemIO.InputItem(i,listAry.get(listIdx).ary);
							if (itemIO.b == true) {
								model.addRow(new Object[0]);
								model.setValueAt("      " + listAry.get(listIdx).ary.get(listAry.get(listIdx).ary.size() - 1).name, listAry.get(listIdx).ary.size() - 2, 0);
								model.setValueAt("    " + listAry.get(listIdx).ary.get(listAry.get(listIdx).ary.size() - 1).num, listAry.get(listIdx).ary.size() - 2, 1);
								model.setValueAt(rename, listAry.get(listIdx).ary.size() - 2, 2);
								model.setValueAt(false, listAry.get(listIdx).ary.size() - 2, 3);
								f.setVisible(false);
							}
						}
					} catch (NumberFormatException exception) {} 
				}
			});
			b.setBounds(110,90,60,35);
			f.add(b);			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			addItem.setIcon(addItemEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			addItem.setIcon(addItemExit);
		}
	}

	private class ModifyItemListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			int row = table.getSelectedRow();
			int column = table.getSelectedColumn();
			if(column == 2) {
				JFrame f = new JFrame();
				f.setTitle("Modify Item");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("  수정할 이름");
				la1.setLocation(40, -30);
				la1.setSize(100,100);
				JLabel la2 = new JLabel("수량");
				la2.setLocation(196, -30);
				la2.setSize(100,100);
				f.add(la1);
				f.add(la2);
				JTextField tf1 = new JTextField();
				tf1.setBounds(20,50,120,30);
				JTextField tf2 = new JTextField();
				tf2.setBounds(150,50,120,30);
				f.add(tf1);
				f.add(tf2);
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String nameData = tf1.getText();
						String qtyData = tf2.getText();
						try {
							listAry.get(listIdx).ary.get(row+1).name = nameData;
							listAry.get(listIdx).ary.get(row+1).num = Integer.parseInt(qtyData);
							model.setValueAt("      " + listAry.get(listIdx).ary.get(row+1).name, row, 0);
							model.setValueAt("    " + listAry.get(listIdx).ary.get(row+1).num, row, 1);
							f.setVisible(false);
						}catch(Exception exception) {
							JOptionPane.showMessageDialog(null, "수량에는 정수를 넣어주세요!");
						}
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);			
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
	}

	private class HomeListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			pastItem.setVisible(true);
			addList.setVisible(true);
			today.setVisible(true);
			bookMark.setVisible(true);
			trash.setVisible(true);
			c1.setEnabled(true);
			scrollPane.setVisible(false);
			table.setVisible(false);
			addItem.setVisible(false);
			trash2.setVisible(false);
			home.setVisible(false);
			print.setVisible(false);
			dup.setVisible(false);
			move.setVisible(false);
			d1(listAry);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			home.setIcon(homeEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			home.setIcon(homeExit);
		}
		
	}
	
	private class Trash2Listener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			ArrayList<Integer> CheckBoxAry = new ArrayList<>();
			for(int i = 0 ; i < listAry.get(listIdx).ary.size() - 1 ; i++) {
				if ((boolean)table.getValueAt(i,3) == true) 
					CheckBoxAry.add(i);
			}
			if(CheckBoxAry.size() > 0) {
				JFrame f = new JFrame();
				f.setTitle("Delete Item");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				JLabel la1 = new JLabel("삭제된 아이템은 복구가 불가능합니다.");
				la1.setBounds(44,0,300,80);
				f.add(la1);
				JLabel la2 = new JLabel("삭제하시겠습니까?");
				la2.setBounds(89,38,120,60);
				f.add(la2);
				JButton b = new JButton("확인");
				try {
					b.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							int tmp = 1;
							for(int i = 0 ; i < CheckBoxAry.size() ; i++) {
								listAry.get(listIdx).ary.remove(CheckBoxAry.get(i) + tmp);	
								tmp--; 
							}
							JOptionPane.showMessageDialog(null, "삭제되었습니다!");
							f.setVisible(false);
							table.setVisible(false);
							scrollPane.setVisible(false);
							UpdateTable2();
						}
					});
					b.setBounds(110,90,60,35);
					f.add(b);	
				} catch (Exception except) {
					f.setVisible(false);
				}
			} else JOptionPane.showMessageDialog(null, "체크박스를 선택하지 않았습니다!");
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			trash2.setIcon(trash2Enter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			trash2.setIcon(trash2Exit);
		}
	}
	
	private class MoveListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			ArrayList<Integer> CheckBoxAry = new ArrayList<>();
			for(int i = 0 ; i < listAry.get(listIdx).ary.size() - 1 ; i++) {
				if ((boolean)table.getValueAt(i,3) == true) 
					CheckBoxAry.add(i);
			}
			if(CheckBoxAry.size() > 0) {
				JFrame f = new JFrame();
				f.setTitle("Move Item");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				String[] listName = new String[listAry.size()];
				for(int i = 0 ; i < listAry.size() ; i++)
					listName[i] = listAry.get(i).name;
				JComboBox cBox = new JComboBox(listName);
				cBox.setBounds(40, 30, 204, 20);
				f.add(cBox);
				cBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JComboBox cb = (JComboBox)e.getSource();							
						listNameField = (String)cb.getSelectedItem();
						for(int i = 0 ; i < listAry.size() ; i++) {
							if (listNameField.equals(listAry.get(i).name)) {
								listIdx2 = i;
							}
						}
					}
				});
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						int tmp = 1;
						MoveItem moveItem = new MoveItem();
						for(int i = 0 ; i < CheckBoxAry.size() ; i++) {
							moveItem.Move(listAry.get(listIdx).ary.get(CheckBoxAry.get(i) + tmp), listAry.get(listIdx).ary, listAry.get(listIdx2).ary);
							tmp--;
						}
						f.setVisible(false);
						table.setVisible(false);
						scrollPane.setVisible(false);
						UpdateTable2();
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);	
			} else JOptionPane.showMessageDialog(null, "체크박스를 선택하지 않았습니다!");
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			move.setIcon(moveEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			move.setIcon(moveExit);
		}
		
	}
	
	private class DupListener extends JFrame implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			ArrayList<Integer> CheckBoxAry = new ArrayList<>();
			for(int i = 0 ; i < listAry.get(listIdx).ary.size() - 1 ; i++) {
				if ((boolean)table.getValueAt(i,3) == true) 
					CheckBoxAry.add(i);
			}
			if(CheckBoxAry.size() > 0) {
				JFrame f = new JFrame();
				f.setTitle("Move Item");
				f.setSize(300, 190);
				f.setLocationRelativeTo(null);
				f.setResizable(false);
				f.setVisible(true);
				f.setLayout(null);
				String[] listName = new String[listAry.size()];
				for(int i = 0 ; i < listAry.size() ; i++)
					listName[i] = listAry.get(i).name;
				JComboBox cBox = new JComboBox(listName);
				cBox.setBounds(40, 30, 204, 20);
				f.add(cBox);
				cBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JComboBox cb = (JComboBox)e.getSource();							
						listNameField = (String)cb.getSelectedItem();
						for(int i = 0 ; i < listAry.size() ; i++) {
							if (listNameField.equals(listAry.get(i).name)) {
								listIdx2 = i;
							}
						}
					}
				});
				JButton b = new JButton("확인");
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int i = 0 ; i < CheckBoxAry.size() ; i++) {
							MoveItem moveItem = new MoveItem();
							moveItem.Dup(listAry.get(listIdx).ary.get(CheckBoxAry.get(i) + 1), listAry.get(listIdx2).ary);
						}
						f.setVisible(false);
						table.setVisible(false);
						scrollPane.setVisible(false);
						UpdateTable2();
					}
				});
				b.setBounds(110,90,60,35);
				f.add(b);	
			} else JOptionPane.showMessageDialog(null, "체크박스를 선택하지 않았습니다!");
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			dup.setIcon(dupEnter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			dup.setIcon(dupExit);
		}
		
	}
	
	public void d3() {
		setTitle("이전 등록 아이템");
		
		LoadPastItem load = new LoadPastItem();
		listAry2 = load.getList();
		System.out.println(listAry2);
		
		c3 = getContentPane();
		c3.setLayout(null);
		
		// ScrollPane for Table
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		c3.add(scrollPane);

		// Table
		table = new JTable();
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 17);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("Item Name");
		model.addColumn("QTY");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(800);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry2.size(); i++) {
			model.addRow(new Object[0]);
			model.setValueAt("     " + listAry2.get(i).name, i, 0);
			model.setValueAt("    " + listAry2.get(i).num, i, 1);
		}
		
		home2.setBounds(800,0,80,80);
		home2.setBorderPainted(false);
		home2.setContentAreaFilled(false);
		home2.setFocusPainted(false);
		c3.add(home2);
	}
	
	private class Home2Listener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mousePressed(MouseEvent e) {
			pastItem.setVisible(true);
			addList.setVisible(true);
			today.setVisible(true);
			bookMark.setVisible(true);
			trash.setVisible(true);
			c1.setEnabled(true);
			scrollPane.setVisible(false);
			table.setVisible(false);
			home2.setVisible(false);
			d1(listAry);
		}

		@Override
		public void mouseReleased(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {
			home2.setIcon(home2Enter);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			home2.setIcon(home2Exit);
		}
		
	}
	
	public void UpdateTable() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
		// table.setShowHorizontalLines(false);
		// table.setShowVerticalLines(false);
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return Icon.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		
		table.setModel(model);

		model.addColumn("List Name");
		model.addColumn("Go to List");
		model.addColumn("Modify Name");
		model.addColumn("Select");

		table.getColumnModel().getColumn(0).setPreferredWidth(900);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.size() - 2; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(i + 2).name, i, 0);
			model.setValueAt(goToList, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
	}
	
	public void UpdateTable2() {
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 1013, 461);
		getContentPane().add(scrollPane);

		// Table
		table = new JTable();
		table.setRowHeight(80);
		scrollPane.setViewportView(table);
		Font font = new Font("Godic", Font.BOLD, 20);
		table.setFont(font);

		// Model for Table
		model = new DefaultTableModel() {

			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return Icon.class;
				case 3:
					return Boolean.class;
				default:
					return String.class;
				}
			}
		};
		table.setModel(model);

		model.addColumn("Item Name");
		model.addColumn("QTY");
		model.addColumn("Modify Data");
		model.addColumn("Select");
		
		table.getColumnModel().getColumn(0).setPreferredWidth(800);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

		// Data Row
		for (int i = 0; i < listAry.get(listIdx).ary.size() - 1; i++) {
			model.addRow(new Object[0]);
			model.setValueAt("      " + listAry.get(listIdx).ary.get(i+1).name, i, 0);
			model.setValueAt("    " + listAry.get(listIdx).ary.get(i+1).num, i, 1);
			model.setValueAt(rename, i, 2);
			model.setValueAt(false, i, 3);
		}
	}
}