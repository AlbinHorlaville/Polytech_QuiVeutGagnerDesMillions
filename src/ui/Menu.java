package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import ui.Main.State;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Menu extends JPanel {

	Main main;

	public Menu(Main main) {

		this.main = main;
		
		setBackground(Main.colorBack);

		setLayout(new BorderLayout());

		JPanel south = new JPanel();
		south.setLayout(new GridLayout(2, 5));

		JLabel title = new JLabel("PolyPountos", SwingConstants.CENTER);
		title.setFont(new FontUIResource(title.getFont().getName(), title.getFont().getStyle(), 100));
		add(title, BorderLayout.NORTH);

		for (int i = 1; i < 6; i++) {
			JButton player = new JButton("Joueur " + i);
			int iPlayer = i;
			player.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					main.game.setPlayer(iPlayer-1);
					main.changeState(State.inGame);
					main.revalidate();
				}
			});
			south.add(player);
		}
		
		Icon myImgIcon = new ImageIcon(getClass().getResource("images/BirdGif.gif"));
		JLabel image = new JLabel();
		image.setIcon(myImgIcon);
		south.add(image);

		south.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
		south.setBackground(Main.colorBack);

		add(south, BorderLayout.CENTER);
	}

}
