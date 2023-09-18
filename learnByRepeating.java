import java.util.*;
import java.io.*;

public class learnByRepeating{
	
	public ArrayList<ArrayList<String>> words;
	public ArrayList<String> themes;
	
	//constructor
	public learnByRepeating(){
		this.words = new ArrayList<ArrayList<String>>();
		this.themes = new ArrayList<String>();
	}

	//read file theme and add the words in the arrayList words
	public void readFile(String theme){
		File file = new File(theme);

		try{
			Scanner input = new Scanner(file);
			//for each lines, add words separated by "." in an ArrayListsynonyms, it represents all the word in different languages with the same meaning. This list is then added to this.words
			while (input.hasNextLine()){
				String[] s = input.nextLine().split("[.]");
				ArrayList<String> synonyms = new ArrayList<String>();
				for(int i = 0; i < s.length ; i++){
					synonyms.add(s[i]);
				}
				words.add(synonyms);
			}
		}catch(Exception e){
			System.out.println("could not read the file "+ theme + ". Does it exist? if yes, check if there are 2 words for each lines. If yes, the file could not be reached.");
		}
	}

	//read the fils theme to search all the text files existing
	public void theme(){
		File file = new File("filesName.txt");

		try{
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()){
				this.themes.add(scanner.next());
			}
		}catch(Exception e){
			System.out.println("filesName.txt could not be read or reached. Does your file exist or is it empty ?");
		}
	}

	//Ask user to choose theme among thebtheme in fileName
	public String chooseYourTheme(){
		System.out.println("Choose your theme among those below, to exit program type 0");
		for(String e : this.themes){
			System.out.print(e.replace(".txt","") + " ");
		}
		System.out.print("\n");
		//e = answer of the user
		Scanner scanner = new Scanner(System.in);
		String e = scanner.nextLine();
		System.out.println();
		//check if the user did not ask to exit code
		if (!e.equals("0")){
			//if the theme exists return the file corresponding
			if (this.themes.contains(e+".txt")){
				return e+".txt";
			}else{
				System.out.println("the theme you have chosen does not exist, exiting app.");
			}
		}
		//return value null if exit code
		return null;
		
	}


	public void randomWords(){
		System.out.println("To stop the exercise, write 0 as an answer.");
		Random rand = new Random();
		Scanner scanner = new Scanner(System.in);
		String e = "1";
		do{
			e = "1";
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
	}

	//compile all functions to launch the application
	public void launch(){
		this.theme();
		String theme = this.chooseYourTheme();
		if(theme != null){
			this.readFile(theme);
			this.randomWords();
		}
	}

	public static void main(String[] args){
		learnByRepeating app = new learnByRepeating();
		app.launch();

	}
}

