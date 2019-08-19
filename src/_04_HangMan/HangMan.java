package _04_HangMan;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	JLabel guesses = new JLabel();
	int life = 10;
	Boolean guessiscorrect;
	static Stack<String> words = new Stack<String>();
	static ArrayList<String> underscores = new ArrayList<String>();
	String currentWord;
	
	public HangMan() {
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		panel.add(guesses);
		guesses.setText("guess any letter");
		lives.setText("lives: " + life);
		frame.setSize(200,200);
		frame.addKeyListener(this);
		
		//label.add('_' * words.size());
	}
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}
	
	public void setup() {
		String word = JOptionPane.showInputDialog("Welcome to Hangman! \n How many words would you like to guess?");
		int num = Integer.parseInt(word);
		for (int i = 0; i < num; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			words.add(s);
			
		}
		currentWord = words.pop();
		//System.out.println(currentWord);
		for (int j = 0; j < currentWord.length(); j++) {
			underscores.add("_");
			
		}
		
		frame.setVisible(true);
		//words.pop();
		
		labelText();
		
		
		
	}
	
	
	public void labelText() { //sets the label to underscores and fills with letters
		String text = "";
		for (int i = 0; i < underscores.size(); i++) {
			text += underscores.get(i) + " ";
			
		}
		label.setText(text);
		
		
	}
	
	public void checkForLetter(char guess) { //checks if guess is in the word
		guessiscorrect = false;
		for (int i = 0; i < currentWord.length(); i++) {
			if(currentWord.charAt(i) == guess) {
				underscores.set(i, guess + "");
				guessiscorrect = true;
			}
		
		}
		if(guessiscorrect == false) {
			life -= 1;
			lives.setText("lives: " + life);
		}
		else {
			
		}
		labelText();
	}

	
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		checkForLetter(e.getKeyChar());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}
