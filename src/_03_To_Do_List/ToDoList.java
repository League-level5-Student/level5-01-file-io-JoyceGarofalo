package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener{
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JButton button5 = new JButton();
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.MakeStuff();
		
	}
	
	void MakeStuff() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(500,100);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		button1.setText("add task");
		button2.setText("view tasks");
		button3.setText("remove task");
		button4.setText("save list");
		button5.setText("load list");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton pressed = (JButton) e.getSource();
		ArrayList<String> arr = new ArrayList<>();
		
		if(pressed == button1) {
			String enteredtask = JOptionPane.showInputDialog("enter a task");
			arr.add(enteredtask);
		}
		if(pressed == button2) {
			System.out.println(arr);
		}
		if(pressed == button3) {
			String removingtask = JOptionPane.showInputDialog("what task do you want removed?");
			for (int i = 0; i < arr.size(); i++) {
				if(arr.get(i) == removingtask) {
					arr.remove(arr.get(i));
				}
			}

		}
		if(pressed == button4) {
			try {
				FileWriter fw = new FileWriter("savedarr.txt");
				
				for (int i = 0; i < arr.size(); i++) {
					fw.write(arr.get(i));
				}
					
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(pressed == button5) {
			String location = JOptionPane.showInputDialog("where is the file located?");
			//not done
		}
		
	}
		

	
}
