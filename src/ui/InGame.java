package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.plaf.FontUIResource;

import fc.Game;
import ui.Main.State;

@SuppressWarnings("serial")
public class InGame extends JPanel {

	Game game;
	Main main;

	protected JLabel question;

	protected JLabel image;

	protected JButton reponseA;
	protected JButton reponseB;
	protected JButton reponseC;
	protected JButton reponseD;
	protected JButton nextQuestion;
	protected JButton defeatB;

	protected JButton Jocker1;
	protected JButton Jocker2;
	protected JButton Jocker3;
	protected JButton Jocker4;

	protected JProgressBar barreS;
	protected JProgressBar barreN;

	protected JLabel rectA;
	protected JLabel rectB;
	protected JLabel rectC;
	protected JLabel rectD;

	public InGame(Main main) {

		this.game = main.game;
		this.main = main;

		setBackground(Color.cyan);

		try {
			setLayout(new BorderLayout());

			// CENTER JPANEL
			JPanel center = new JPanel();
			center.setLayout(new BorderLayout());
			// NORTH JPANEL

			barreS = new JProgressBar();
			barreS.setStringPainted(true);
			barreN = new JProgressBar();
			barreN.setStringPainted(true);
			barreN.setString("");

			center.add(barreN, BorderLayout.NORTH);
			
			JPanel centerCenter = new JPanel();
			centerCenter.setLayout(new BorderLayout());
			
			image = new JLabel();
			image.setHorizontalAlignment(SwingConstants.CENTER);
			centerCenter.add(barreS, BorderLayout.SOUTH);
			centerCenter.add(image, BorderLayout.CENTER);
			
			center.add(centerCenter, BorderLayout.CENTER);

			JPanel centerSouth = new JPanel();
			centerSouth.setLayout(new BorderLayout());
			question = new JLabel();
			question.setHorizontalAlignment(SwingConstants.CENTER);
			question.setVerticalAlignment(SwingConstants.CENTER);
			centerSouth.add(question, BorderLayout.NORTH);
			JPanel centerSouthCenter = new JPanel();
			centerSouthCenter.setLayout(new GridLayout(2, 2));

			// rectangle sous le bouton
			rectA = new JLabel();
			rectA.setHorizontalAlignment(SwingConstants.CENTER);
			setSizeTextButton(rectA);

			rectB = new JLabel();
			rectB.setHorizontalAlignment(SwingConstants.CENTER);
			setSizeTextButton(rectB);

			rectC = new JLabel();
			rectC.setHorizontalAlignment(SwingConstants.CENTER);
			setSizeTextButton(rectC);

			rectD = new JLabel();
			rectD.setHorizontalAlignment(SwingConstants.CENTER);
			setSizeTextButton(rectD);

			reponseA = new JButton();
			reponseB = new JButton();
			reponseC = new JButton();
			reponseD = new JButton();

			reponseA.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (game.Current.getCorrection() == 1) {
						rectA.setForeground(Color.green);
						nextQuestion.setEnabled(true);
					} else {
						rectA.setForeground(Color.red);
						defeatB.setEnabled(true);
					}
					centerSouthCenter.remove(reponseA);
					centerSouthCenter.add(rectA, 0);

					revalidate();
					repaint();
				}
			});

			reponseB.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (game.Current.getCorrection() == 2) {
						rectB.setForeground(Color.green);
						nextQuestion.setEnabled(true);
					} else {
						rectB.setForeground(Color.red);
						defeatB.setEnabled(true);
					}

					centerSouthCenter.remove(reponseB);
					centerSouthCenter.add(rectB, 1);

					revalidate();
					repaint();
				}
			});

			reponseC.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (game.Current.getCorrection() == 3) {
						rectC.setForeground(Color.green);
						nextQuestion.setEnabled(true);
					} else {
						rectC.setForeground(Color.red);
						defeatB.setEnabled(true);
					}

					centerSouthCenter.remove(reponseC);
					centerSouthCenter.add(rectC, 2);

					revalidate();
					repaint();
				}
			});

			reponseD.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (game.Current.getCorrection() == 4) {
						rectD.setForeground(Color.green);
						nextQuestion.setEnabled(true);
					} else {
						rectD.setForeground(Color.red);
						defeatB.setEnabled(true);
					}

					centerSouthCenter.remove(reponseD);
					centerSouthCenter.add(rectD, 3);

					revalidate();
					repaint();
				}
			});

			reponseA.setPreferredSize(new Dimension(reponseA.getWidth(), 100));
			reponseB.setPreferredSize(new Dimension(reponseB.getWidth(), 100));
			reponseC.setPreferredSize(new Dimension(reponseC.getWidth(), 100));
			reponseD.setPreferredSize(new Dimension(reponseD.getWidth(), 100));
			rectA.setPreferredSize(new Dimension(reponseA.getWidth(), 100));
			rectB.setPreferredSize(new Dimension(reponseB.getWidth(), 100));
			rectC.setPreferredSize(new Dimension(reponseC.getWidth(), 100));
			rectD.setPreferredSize(new Dimension(reponseD.getWidth(), 100));

			centerSouthCenter.add(reponseA);
			centerSouthCenter.add(reponseB);
			centerSouthCenter.add(reponseC);
			centerSouthCenter.add(reponseD);

			centerSouthCenter.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

			centerSouth.add(centerSouthCenter, BorderLayout.CENTER);

			center.add(centerSouth, BorderLayout.SOUTH);

			// WEST JPANEL
			JPanel west = new JPanel();
			west.setLayout(new BorderLayout());
			// wPic = ImageIO.read(this.getClass().getResource("images/paliers.png"));
			// wIcon = new JLabel(new ImageIcon(wPic));
			
			ImageIcon myImgIcon = new ImageIcon(getClass().getResource("images/Paliers.gif"));
			JLabel wIcon = new JLabel(myImgIcon);
			west.add(wIcon, BorderLayout.NORTH);

			JPanel flowJoker = new JPanel();
			flowJoker.setLayout(new BoxLayout(flowJoker, BoxLayout.Y_AXIS));
			flowJoker.add(Box.createVerticalGlue());
			flowJoker.add(Box.createHorizontalGlue());
			
			Jocker1 = new JButton("<html><CENTER>L'appel au Polypote</html>");
			Jocker2 = new JButton("<html>50/50");
			Jocker3 = new JButton("<html>75/25");
			Jocker4 = new JButton("<html>Chat-GPT</html>");

			flowJoker.add(Jocker1);
			flowJoker.add(Jocker2);
			flowJoker.add(Jocker3);
			flowJoker.add(Jocker4);

			Jocker1.setPreferredSize(new Dimension(Jocker1.getWidth(), 75));
			Jocker2.setPreferredSize(new Dimension(Jocker2.getWidth(), 75));
			Jocker3.setPreferredSize(new Dimension(Jocker3.getWidth(), 75));
			Jocker4.setPreferredSize(new Dimension(Jocker4.getWidth(), 75));

			Jocker1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jocker1.setEnabled(false);
				}
			});

			Jocker2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jocker2.setEnabled(false);
					switch (game.Current.getCorrection()) {
					case 1:
						reponseB.setEnabled(false);
						reponseD.setEnabled(false);
						break;
					case 2:
						reponseD.setEnabled(false);
						reponseC.setEnabled(false);
						break;
					case 3:
						reponseA.setEnabled(false);
						reponseB.setEnabled(false);
						break;
					case 4:
						reponseA.setEnabled(false);
						reponseC.setEnabled(false);
						break;
					}
				}
			});

			Jocker3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jocker3.setEnabled(false);
					int value = (int) (Math.random()*100)%4+1;
					while (value==game.Current.getCorrection()) {
						value = (int) (Math.random()*100)%4+1;
					}
					switch (value) {
					case 1:
						reponseA.setEnabled(false);
						break;
					case 2:
						reponseB.setEnabled(false);
						break;
					case 3:
						reponseC.setEnabled(false);
						break;
					case 4:
						reponseD.setEnabled(false);
						break;
					}
				}
			});

			Jocker4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Jocker4.setEnabled(false);
				}
			});

			west.add(flowJoker, BorderLayout.SOUTH);

			// EAST JPANEL
			JPanel east = new JPanel();
			east.setLayout(new BorderLayout());
			// wPic = ImageIO.read(this.getClass().getResource("images/paliers.png"));
			// wIcon = new JLabel(new ImageIcon(wPic));
			myImgIcon = new ImageIcon(getClass().getResource("images/Paliers.gif"));
			wIcon = new JLabel(myImgIcon);
			east.add(wIcon, BorderLayout.NORTH);

			JPanel flowBadv = new JPanel();
			flowBadv.setLayout(new BoxLayout(flowBadv, BoxLayout.Y_AXIS));
			flowBadv.add(Box.createVerticalGlue());
			flowBadv.add(Box.createHorizontalGlue());

			nextQuestion = new JButton("<html><CENTER>Question<br>Suivante !</html>");
			nextQuestion.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						game.nextQuestion();
					} catch (Exception e1) {
						centerSouthCenter.removeAll();
						centerSouthCenter.add(reponseA);
						centerSouthCenter.add(reponseB);
						centerSouthCenter.add(reponseC);
						centerSouthCenter.add(reponseD);
						main.changeState(State.win);
						main.revalidate();
						return;
					}

					centerSouthCenter.removeAll();

					centerSouthCenter.add(reponseA);
					centerSouthCenter.add(reponseB);
					centerSouthCenter.add(reponseC);
					centerSouthCenter.add(reponseD);

					updateInterface();
				}
			});
			nextQuestion.setPreferredSize(new Dimension(nextQuestion.getWidth(), 75));
			flowBadv.add(nextQuestion);

			defeatB = new JButton("<html>Perdu !</html>");
			defeatB.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					centerSouthCenter.removeAll();
					centerSouthCenter.add(reponseA);
					centerSouthCenter.add(reponseB);
					centerSouthCenter.add(reponseC);
					centerSouthCenter.add(reponseD);
					main.changeState(State.defeat);
					main.revalidate();
				}
			});
			defeatB.setEnabled(false);
			defeatB.setPreferredSize(new Dimension(defeatB.getWidth(), 75));
			flowBadv.add(defeatB);

			east.add(flowBadv, BorderLayout.SOUTH);

			add(center, BorderLayout.CENTER);
			add(west, BorderLayout.WEST);
			add(east, BorderLayout.EAST);

		} catch (Exception e) {
			System.out.println("Erreur");
		}

		colorBackground(this);
	}

	void updateInterface() {
		question.setText("<html><CENTER>" + game.Current.getQuestion() + "</html>");
		reponseA.setText("<html><CENTER> A : " + game.Current.getA() + "</html>");
		reponseB.setText("<html><CENTER> B : " + game.Current.getB() + "</html>");
		reponseC.setText("<html><CENTER> C : " + game.Current.getC() + "</html>");
		reponseD.setText("<html><CENTER> D : " + game.Current.getD() + "</html>");

		setSizeTextButton(question);
		setSizeTextButton(reponseA);
		setSizeTextButton(reponseB);
		setSizeTextButton(reponseC);
		setSizeTextButton(reponseD);

		barreS.setValue((game.iQuestion + 1) * 100 / 15);

		rectA.setText(reponseA.getText());
		rectB.setText(reponseB.getText());
		rectC.setText(reponseC.getText());
		rectD.setText(reponseD.getText());

		reponseA.setEnabled(true);
		reponseB.setEnabled(true);
		reponseC.setEnabled(true);
		reponseD.setEnabled(true);

		nextQuestion.setEnabled(false);
		defeatB.setEnabled(false);

		// Mini jeu question 8
		if (game.iQuestion == 7) {
			reponseA.setVisible(false);
			reponseB.setVisible(false);
			reponseC.setVisible(false);
			reponseD.setVisible(false);
			nextQuestion.setEnabled(true);
			defeatB.setEnabled(true);
			Jocker1.setVisible(false);
			Jocker2.setVisible(false);
			Jocker3.setVisible(false);
			Jocker4.setVisible(false);
		}
		if (game.iQuestion == 8) {
			Jocker1.setVisible(true);
			Jocker2.setVisible(true);
			Jocker3.setVisible(true);
			Jocker4.setVisible(true);
			reponseA.setVisible(true);
			reponseB.setVisible(true);
			reponseC.setVisible(true);
			reponseD.setVisible(true);
		}
		
		

		String url = game.Current.getURL();
		
		// Cas d'un GIF
		if (url.endsWith(".gif")) {
			Icon myImgIcon = new ImageIcon(getClass().getResource(url));
			image.setIcon(myImgIcon);
			
		// Cas d'une image
		} else if (url.endsWith(".png") || url.endsWith(".jpeg") || url.endsWith(".webp")) {
			try {
				System.out.println(url);
				BufferedImage wPic = ImageIO.read(this.getClass().getResource(url));
				image.setIcon(new ImageIcon(wPic));
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		// Par défaut, gif du pioupiou
		} else {
			try {
				BufferedImage wPic = ImageIO.read(this.getClass().getResource("images/PolyPountos.png"));
				image.setIcon(new ImageIcon(wPic));
				//image.setPreferredSize(new Dimension(100, 100));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		revalidate();
		repaint();
	}

	void colorBackground(Container e) {
		Component[] current = e.getComponents();
		if (!(e instanceof JButton)) {
			e.setBackground(Main.colorBack);
			for (int i = 0; i < current.length; i++) {
				if (current[i] instanceof Container) {
					colorBackground((Container) current[i]);
				}
			}
		}
	}

	void setSizeTextButton(Container elem) {
		elem.setFont(new FontUIResource(elem.getFont().getName(), elem.getFont().getStyle(), 20));
	}
}
