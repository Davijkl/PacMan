import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

public class myMain {

	//faccio un array con gli input da tastiera
	static ArrayList<Character> array = new ArrayList();

	public static void main(String[] args) {

		Frame f = new Frame();
		f.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//ogni volta che lascio un tasto, rimuovo quel carattere dai miei input
				synchronized(array) {
					if(array.contains(e.getKeyChar()))
						array.remove(new Character(e.getKeyChar()));
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//ogni volta che premo un tasto, aggiungo quel carattere ai miei input
				synchronized(array) {
					if(!array.contains(e.getKeyChar()))
						array.add(e.getKeyChar());
				}
			}
		});

		//creo un thread (timer) che ogni 50 ms esegue il codice al suo interno
		Timer t = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//controllo i tasti che sono premuti e sposto di conseguenza
				synchronized(array) {
					for(int i=0;i<array.size();i++) {
						if(array.get(i) == 'd') {
							f.getPanel().getMario().moveRight();
						}
						if(array.get(i) == 'a') {
							f.getPanel().getMario().moveLeft();
						}
						if(array.get(i) == 'w') {
							//							f.getPanel().getMario().moveRight();
						}
					}
				}

	}
		}
	}
}

