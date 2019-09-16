package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import _04_HangMan.HangMan;

public class _02_LogSearch implements ActionListener{
  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton search = new JButton();
	JButton view = new JButton();
	String name;
	
	public static void main(String[] args) {
		_02_LogSearch ls = new _02_LogSearch();
		ls.LogSearch();
	}
	
	public void LogSearch() {
		add.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		
		frame.add(panel);
		panel.add(add);
		panel.add(search);
		panel.add(view);
		frame.setSize(200,200);
		frame.setVisible(true);
		add.setText("add");
		search.setText("search");
		view.setText("view");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == add) {
			String id = JOptionPane.showInputDialog("enter an ID number");
			int ID = Integer.parseInt(id);
			name = JOptionPane.showInputDialog("enter a name");
			hm.put(ID, name);
		}
		
		if(e.getSource() == search) {
			String h = JOptionPane.showInputDialog("enter an ID number");
			int IDsearch = Integer.parseInt(h);

			if(hm.get(IDsearch) != null) {
				JOptionPane.showMessageDialog(null, hm.get(IDsearch));
			}
			else {
				JOptionPane.showMessageDialog(null, "entry does not exist");
			}
			
			
			
		}
		
		if(e.getSource() == view) {
			String s = "";
			for(int key: hm.keySet()) {
				s +=  "ID: " + key + " Name: " + hm.get(key) + "\n";
				
			}
			JOptionPane.showMessageDialog(null, s);

			
		}
		
		
		
		
	}

}
