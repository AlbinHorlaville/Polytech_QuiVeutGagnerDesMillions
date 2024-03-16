package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import fc.Game;

public class Main extends JFrame {

	// final static Color colorBack = new Color(150, 150, 250);
	final static Color colorBack = new Color(100, 200, 200);

	public enum State {
		menu, inGame, defeat, win
	}

	State state = State.menu;
	Game game;
	InGame ingame;
	Menu menu;
	Defeat defeat;
	Win win;

	Main() {

		// Listener pour arrêter le programme automatiquement à la fermeture de la
		// fenêtre
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		game = new Game();
		ingame = new InGame(this);
		menu = new Menu(this);

		setContentPane(menu);

		setMinimumSize(new Dimension(1080, 720));
		//setMaximumSize(new Dimension(1080, 720));

		pack();
	}

	void changeState(State s) {
		if (s == State.inGame) {
			ingame.Jocker1.setEnabled(true);
			ingame.Jocker2.setEnabled(true);
			ingame.Jocker3.setEnabled(true);
			ingame.Jocker4.setEnabled(true);
			state = s;
			ingame.updateInterface();
			setContentPane(ingame);
		} else if (s == State.menu) {
			state = State.menu;
			setContentPane(menu);
		} else if (s == State.defeat) {
			defeat = new Defeat(this, game.getRecompense());
			state = State.defeat;
			setContentPane(defeat);
		} else if (s == State.win) {
			win = new Win(this, game.getRecompense());
			state = State.win;
			setContentPane(win);
		} else {
			System.out.println("Error automata");
		}
	}

	public static void main(String[] argv) {
		/*
	    try {
	        UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
	     } catch (Exception e) {
	                e.printStackTrace();
	     }
	     */

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().setVisible(true);
			}
		});
	}
}
