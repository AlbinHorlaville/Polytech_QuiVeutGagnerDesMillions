package fc;

public class Question {
	private String question;
	private String url;
	private String reponseA;
	private String reponseB;
	private String reponseC;
	private String reponseD;
	private int correction;
	
	Question(String q, String u, String A, String B, String C, String D, int c){
		question = q;
		url = u;
		reponseA = A;
		reponseB = B;
		reponseC = C;
		reponseD = D;
		correction = c;
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getURL() {
		return url;
	}
	
	public String getA() {
		return reponseA;
	}
	
	public String getB() {
		return reponseB;
	}
	
	public String getC() {
		return reponseC;
	}
	
	public String getD() {
		return reponseD;
	}
	
	public int getCorrection() {
		return correction;
	}
	
	
}
