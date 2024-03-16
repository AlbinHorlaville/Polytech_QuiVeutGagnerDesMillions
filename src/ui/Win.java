package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.Icon;

import ui.Main.State;

public class Win extends JPanel {
	Main main;
	
	Win(Main main, String récompense){
		this.main = main;
		
		setBackground(Main.colorBack);
		
		setLayout(new BorderLayout());
		
		JLabel title = new JLabel("<html><CENTER>Gagné ! Tu as gagné : <br>"+récompense+"</html>");
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
