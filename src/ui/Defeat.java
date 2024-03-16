package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import fc.Game;
import ui.Main.State;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Defeat extends JPanel{
	
	Main main;
	
	Defeat(Main main, String récompense){
		this.main = main;
		
		setBackground(Main.colorBack);
		
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("<html><CENTER>Perdu ! Tu as gagné : <br>"+récompense+"</html>");
		title.setFont(new FontUIResource(title.getFont().getName(), title.getFont().getStyle(), 50));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setVerticalAlignment(SwingConstants.CENTER);
		
		add(title, BorderLayout.CENTER);
		
		JButton menu = new JButton("Return to Menu");
		menu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.changeState(State.menu);
				main.revalidate();
			}
			
		});
		
		add(menu, BorderLayout.SOUTH);
	}
}
