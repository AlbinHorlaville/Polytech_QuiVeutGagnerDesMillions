package fc;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
	public ArrayList<Question[]> tabPlayer;
	public int player;
	public int iQuestion;
	public Question Current;

	public Game() {
		iQuestion = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/fc/candidats.txt")));
			String q, u, a, b, c, d; // Question, url, A, B, C, D
			int r; // Réponse

			// 15 questions et 5 candidats = 75 questions
			tabPlayer = new ArrayList<Question[]>();

			int k = 0;
			int m = 0;
			Question[] manche = new Question[15];
			while (true) {
				q = br.readLine();
				if (q == null) {
					System.out.println(tabPlayer.size());
					break;
				}
				u = br.readLine();
				a = br.readLine();
				b = br.readLine();
				c = br.readLine();
				d = br.readLine();
				r = Integer.parseInt(br.readLine());
				
				
				Question Iquestion = new Question(q, u, a, b, c, d, r);
				manche[k] = Iquestion;
				k++;
				
				if (k == 15) {
					m++;
					tabPlayer.add(manche);
					k = 0;
					manche = new Question[15];
				}
			}
			/*
			// TEST PARSING INPUT
			Iterator<Question[]> iter = tabPlayer.iterator();
			int i = 0;
			while (iter.hasNext()) {
				Question[] Current = iter.next();
				System.out.println("Player " + i);
				i++;
				for (int j = 0; j < Current.length; j++) {
					System.out.println(Current[j].getQuestion());
					System.out.println(Current[j].getA());
					System.out.println(Current[j].getB());
					System.out.println(Current[j].getC());
					System.out.println(Current[j].getD());
					System.out.println(Current[j].getCorrection());
				}
			}
			*/
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR");
		}
	}

	// Choix du joueur dans le menu (détermine le set de question)
	public void setPlayer(int p) {
		this.player = p;
		this.iQuestion = 0;
		this.Current = tabPlayer.get(player)[iQuestion];
	}

	// Passage à la question suivante
	public void nextQuestion() {
		this.iQuestion++;
		this.Current = tabPlayer.get(player)[iQuestion];
	}

	// Retour à la question précédente
	public void prevQuestion() {
		this.iQuestion--;
		this.Current = tabPlayer.get(player)[iQuestion];
	}

	public String getRecompense() {
		switch (iQuestion) {
		case 0:
			return "Un trophée";
		case 1:
			return "Coup de boule de Zizou";
		case 2:
			return "vraiment pas grand chose (le plaisir d'être venu je suppose)";
		case 3:
			return "un câlin (lot de consolation)";
		case 4:
			return "1€ symbolique";
		case 5:
			return "ecocup bda";
		case 6:
			return "Chi fou reviens dans le jeu";
		case 7:
			return "Cookie crous";
		case 8:
			return "lance un dé si c'est un celui annoncé tu reviens en jeu";
		case 9:
			return "Pascal le grand frère";
		case 10:
			return "Autographe George";
		case 11:
			return "bubble bubble fnac";
		case 12:
			return "Une peluche géante";
		case 13:
			return "poids /(IMC x taille²) kg de chocolat";
		case 14:
			return "1 bouteille de chartreuse";
		case 15:
			return "gameboy + pokemon (rubis/saphir/etc...)";
		default:
			return "ERROR iQuestion";
		}
	}
}
