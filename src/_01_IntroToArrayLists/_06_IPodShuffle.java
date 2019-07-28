package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	ArrayList<Song> songs = new ArrayList<Song>();	
	Song s = new Song("demo.mp3");
	Song l = new Song("lh.mp3");
	Song m = new Song("sm.mp3");
	Song k = new Song("tk.mp3");
	
	
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.

		songs.add(s);
		songs.add(l);
		songs.add(m);
		songs.add(k);
		
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		

		frame.add(panel);
		panel.add(button);
		frame.setVisible(true);
		button.setText("Surprise me!");
		button.addActionListener(this);

	}
	public static void main(String[] args) {
		_06_IPodShuffle ipod = new _06_IPodShuffle();
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			for (int i = 0; i < songs.size(); i++) {
				songs.get(i).stop();
			}
			Random r = new Random();
			int rand = r.nextInt(songs.size());
			for (int i = 0; i < songs.size(); i++) {
				if(i == rand) {
					songs.get(i).play();
					if(songs.get(i).equals(s)) {
						JOptionPane.showMessageDialog(null, "Playing demo song");
					}
					else if(songs.get(i).equals(m)) {
						JOptionPane.showMessageDialog(null, "Playing Walkin' On The Sun by Smash Mouth");
					}
					else if(songs.get(i).equals(l)) {
						JOptionPane.showMessageDialog(null, "Playing Mrs. Robinson by The Lemonheads");
					}
					else if(songs.get(i).equals(k)) {
						JOptionPane.showMessageDialog(null, "Playing Spaceman by The Killers");
					}
					
				}
			}
		}
		
		
		
		
	}
}