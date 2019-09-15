package _04_HangMan;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener, ActionListener{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel lives = new JLabel();
	JLabel guesses = new JLabel();
	JFrame end = new JFrame();
	JPanel endp = new JPanel();
	JLabel endl = new JLabel();
	JFrame win = new JFrame();
	JPanel winp = new JPanel();
	JLabel winl = new JLabel();
	
	JLabel playAgain_e = new JLabel();
	JButton no_e = new JButton();
	JButton yes_e = new JButton();
	
	JLabel playAgain = new JLabel();
	JButton no = new JButton();
	JButton yes = new JButton();
	
	Boolean Y = false;
	Boolean N = false;
	int life = 10;
	Boolean guessiscorrect;
	static Stack<String> words = new Stack<String>();
	static ArrayList<String> underscores = new ArrayList<String>();
	String currentWord;
	
	public HangMan() {
		
		frame.addKeyListener(this);
		frame.setSize(200,200);
		frame.add(panel);
		panel.add(label);
		panel.add(lives);
		panel.add(guesses);
		panel.add(playAgain_e);
		panel.add(yes_e);
		panel.add(no_e);
		panel.add(playAgain);
		panel.add(yes);
		panel.add(no);
		
		end.addKeyListener(this);
		end.setSize(200,200);
		end.add(endp);
		endp.add(endl);
		endp.add(playAgain_e);
		endp.add(yes_e);
		endp.add(no_e);
		endl.setText("Game Over");
		
		win.addKeyListener(this);
		win.setSize(200,200);
		win.add(winp);
		winp.add(winl);
		winp.add(playAgain);
		winp.add(yes);
		winp.add(no);
		winl.setText("Congratulations!");
		
		guesses.setText("guess any letter");
		lives.setText("lives: " + life);
		playAgain_e.setText("Would you like to play again?");
		yes_e.setText("yes");
		no_e.setText("no");
		playAgain.setText("Would you like to play again?");
		yes.setText("yes");
		no.setText("no");
		
		no.addActionListener(this);
		yes.addActionListener(this);
		no_e.addActionListener(this);
		yes_e.addActionListener(this);
		
		
		//yes.setVisible(false);
		//no.setVisible(false);
		
		
	}
	
	public static void main(String[] args) {
		HangMan hm = new HangMan();
		hm.setup();
	}
	
	public void setup() { //picks words
		String word = JOptionPane.showInputDialog("Welcome to Hangman! \n How many words would you like to guess?");
		int num = Integer.parseInt(word);
		for (int i = 0; i < num + 1; i++) {
			String s = Utilities.readRandomLineFromFile("dictionary.txt");
			words.add(s);
		}
		wordSetup();

	}
	
	public void wordSetup() { //sets up frame
		life = 10;
		currentWord = words.pop();
		System.out.println(currentWord);
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
		int underscoreCount = 0;
		for (int i = 0; i < underscores.size(); i++) {
			if(underscores.get(i).equals("_")) {
				underscoreCount += 1;
			}
		}
		if(underscoreCount > 0 && life > 0) {
			
		}
		else if(underscoreCount == 0 && life > 0){
			life = 10;
			lives.setText("lives: " + life);
			underscores.clear();
			wordSetup();
			if(words.isEmpty() == true) {
				frame.setVisible(false);
				win.setVisible(true);
				//playAgain.setVisible(true);               
				//yes.setVisible(true);
				//no.setVisible(true);
				
			}
		}
		else if(underscoreCount > 0 && life == 0){        
			frame.setVisible(false);
			end.setVisible(true);
			//playAgain.setVisible(true);
			//yes.setVisible(true);
			//no.setVisible(true);
			
			
		}
		
		/*
		if(lettersGuessed == currentWord.length() && life > 0) { //changes to next word
			
			//System.out.println(label);
			life = 10;
			//label.setText("");
			wordSetup();
		}
		
		else if(life == 0) {
			frame.setVisible(false);
			end.setVisible(true);
		}
		*/
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("e");
		if(e.getSource() == yes_e) {
			setup();
			life = 10;
			lives.setText("lives: " + life);
			underscores.clear();

		}
		else if(e.getSource() == no_e) {
			System.exit(0);
		}
		if(e.getSource() == yes) {
			setup();
			life = 10;
			lives.setText("lives: " + life);
			underscores.clear();

		}
		else if(e.getSource() == no) {
			System.exit(0);;
		}

		
	}
	
	
	
	
	
	
}
