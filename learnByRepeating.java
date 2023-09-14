import java.util.*;
import java.io.*;

public class learnByRepeating{
	
	public ArrayList<ArrayList<String>> words;

	public learnByRepeating(){
		this.words = new ArrayList<ArrayList<String>>();
		File file = new File("wordsAndTraduction.txt");

		try{
			Scanner input = new Scanner(file);

			while (input.hasNextLine()){
				String[] s = input.nextLine().split("[.]");
				ArrayList<String> synonyms = new ArrayList<String>();
				for(int i = 0; i < s.length ; i++){
					synonyms.add(s[i]);
				}
				words.add(synonyms);
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
			ArrayList<String> synonyms = this.words.get(r1);
			int r2 = rand.nextInt(synonyms.size());
			System.out.println(synonyms.get(r2));
			e = scanner.nextLine();
			System.out.print("Your answer is ");
			boolean answer = synonyms.contains(e) && !e.equals(synonyms.get(r2));
				System.out.println(Boolean.toString(answer));
			if (!answer){
				System.out.print("Correction : ");
				for(String el : synonyms){
					System.out.print(el + ", ");
				}
				System.out.print("\n");
			}
		}while(!e.equals("0"));
		scanner.close();
	}

	public static void main(String[] args){
		learnByRepeating app = new learnByRepeating();
		app.randomWords();
	}
}

