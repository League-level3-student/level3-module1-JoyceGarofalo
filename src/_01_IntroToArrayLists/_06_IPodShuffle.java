package _01_IntroToArrayLists;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		Song s = new Song("demo.mp3");
		s.play();
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button = new JButton();
		JButton stop = new JButton();
		frame.add(panel);
		panel.add(stop);
		panel.add(button);
		frame.setVisible(true);
		button.setText("Surprise me!");
		stop.setText("Stop");
		
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
		ArrayList<Song> songs = new ArrayList<Song>();
		
		for (int i = 0; i < songs.size(); i++) {
			System.out.println(i);
		}
	}
}