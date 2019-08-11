package _04_HangMan;


import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	static Stack<String> words = new Stack<String>();
	
	public HangMan() {
		frame.setVisible(true);
		frame.add(panel);
		panel.add(label);
		label.add('_' * words.size());
	}
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		String word = JOptionPane.showInputDialog("Welcome to Hangman! \n How many words would you like to guess?");
		int num = Integer.parseInt(word);
		for (int i = 0; i < num; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			words.add(s);
		}
		words.pop();
	
		
	}
	
}
