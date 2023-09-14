import java.util.*;
import java.io.*;

public class learnByRepeating{
	
	public class pair{
		private String s0;
		private String s1;
		public pair(String s0, String s1){
			this.s0 = s0;
			this.s1 = s1;
		}
		public String getS(short i){
			if (i == 0) {
				return s0;
			}else{
				return s1;
			}
		}
		
		public void setS0(String s0){this.s0 = s0;}
		public void setS1(String s1){this.s1 = s1;}

	}

	public ArrayList<pair> words;

	public learnByRepeating(){
		this.words = new ArrayList<pair>();
		File file = new File("wordsAndTraduction.txt");

		try{
			Scanner input = new Scanner(file);

			while (input.hasNextLine()){
				String[] s = input.nextLine().split("[.]");
					String word1 = s[0];
					String word2 = s[1];
				pair couple = new pair(word1,word2);
				words.add(couple);
			}
		}catch(Exception e){
			System.out.println("learByRepeating could not read the file wordsAndTraduction.txt. Check if there is 2 words for each lines. If yes, the file could not be reached.");
		}
	}

	public void randomWords(){
		System.out.println("To stop the exercise, write 0 as an answer.");
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		String e = "1";
		do{
			int r1 = rand.nextInt(this.words.size());
			short r2 = (short) rand.nextInt(2);
			System.out.println(this.words.get(r1).getS(r2));
			e = scanner.nextLine();
			System.out.print("Your answer is ");
			boolean answer ;
			if (r2 == 0){
				answer = e.equals(this.words.get(r1).getS((short)1));
				System.out.println(Boolean.toString(answer));
			}else{
				answer = e.equals(this.words.get(r1).getS((short)0));
				System.out.println(Boolean.toString(answer));
			}
			if (!answer){
				System.out.println("Correction : " + this.words.get(r1).getS((short)0) + " = " + this.words.get(r1).getS((short)1));
			}
		}while(!e.equals("0"));
		scanner.close();
	}

	public static void main(String[] args){
		learnByRepeating app = new learnByRepeating();
		app.randomWords();
	}
}

