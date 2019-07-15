package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	ArrayList<String> guests = new ArrayList<String>();
	
	JButton button1 = new JButton("Add Name");
	JButton button2 = new JButton("View Names");
	public static void main(String[] args) {
		_02_GuestBook g = new _02_GuestBook();
		g.GUI();
	}
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	public void GUI() {
		frame.add(panel);
		panel.add(button2);
		panel.add(button1);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(button1)) {
			String name = JOptionPane.showInputDialog("enter a name");
			guests.add(name);
			
		}
		if(e.getSource().equals(button2)) {
			String message = "";
			for (int i = 0; i < guests.size(); i++) {
				message += "Guest #"  + (i+1) + ":" + guests.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, message);
			
			
		}
		
	}
	
	
	
}
