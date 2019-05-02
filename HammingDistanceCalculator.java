import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HammingDistanceCalculator {
	
	public ArrayList<Integer> nodes = new ArrayList<Integer>();
	
	public static String[] words = {"SH"};
	
	public static int sNode0;

	public static int sNode1;

	public static int sNode2;

	public static int sNode3;

	public static int sNode4;
	public static ArrayList<String> wordsAtNode1 = new ArrayList<String>();
	public static ArrayList<String> wordsAtNode2 = new ArrayList<String>();
	public static ArrayList<String> wordsAtNode3 = new ArrayList<String>();
	public static ArrayList<String> wordsAtNode4 = new ArrayList<String>();
	
	public HammingDistanceCalculator(String first, String second) throws IOException{
		//Array to take the two word being compared and then split them down letter for letter
		String[][] compare = new String[2][4];
		
		//Hamming Distance between the words
		int hamDis = 0;
				
		//Variables related to first and second on the numbers graph part
		int fNode1 = 0, fNode2 = 0, fNode3 = 0, fNode4 = 0;
		int sNode0 = 0, sNode1 = 0, sNode2 = 0, sNode3 = 0, sNode4 = 0;
		
		//Counter to count all the words in the file being uploaded
		int wordCounter = 0;
		int counter;
		
		//ArrayList that gets all the words on the left from Mesonet file
		ArrayList<String> mesonetWords = new ArrayList<String>();
		
		// Use a buffered Reader on the file:
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		String strg = new String();
		
		//Adds words from text file to ArrayList
		while((strg = br.readLine()) != null)
		{
			//Adds certain part of text line to ArrayList
			mesonetWords.add(strg.substring(0, 4));
		}
		words = new String[mesonetWords.size()];
		for(int i = 0; i < mesonetWords.size(); i++) {
			words[i] = mesonetWords.get(i);
		}
		//Close the reader:
		br.close();
		
		//Puts String first's letters into the 2 dimensional array
		for(int index = 0; index < first.length(); index++) {
			compare[0][index] = first.substring(index, index + 1);
		}
		
		//Puts String second's letter into the 2 dimensional array
		for(int index = 0; index < second.length(); index++) {
			compare[1][index] = second.substring(index, index + 1);
		}
		
		//Compares the content of the two Strings
		for(int index = 0; index < first.length(); index++) {
			if(!(compare[0][index].equals(compare[1][index]))) {
				hamDis++;
			}
		}
		
		//Counts the nodes of the words for first string
		for(int index = 0; index < mesonetWords.size(); index++) {
			String[] wordLength = new String[4];
			counter = 0;
			wordCounter++;
			for(int charCount = 0; charCount < wordLength.length; charCount++) {
				wordLength[charCount] = mesonetWords.get(index).substring(charCount, charCount + 1);;
			}
			for(int letter = 0; letter < first.length(); letter++) {
				if(!(compare[0][letter].equals(wordLength[letter]))) {
					counter++;
				}
			}
			//Determines what node needs to increase
			if(counter == 0) {
				sNode0++;
			}
			else if(counter == 1) {
				fNode1++;
				wordsAtNode1.add(mesonetWords.get(index));
			}
			else if(counter == 2) {
				fNode2++;
				wordsAtNode2.add(mesonetWords.get(index));
			}
			else if(counter == 3) {
				fNode3++;
				wordsAtNode3.add(mesonetWords.get(index));
			}
			else if(counter == 4){
				fNode4++;
				wordsAtNode4.add(mesonetWords.get(index));
			}
			else {
				
			}
		}
		
		//Counts the nodes of the words for the second string
		for(int index = 0; index < mesonetWords.size(); index++) {
			if(second.equals(mesonetWords.get(index))) {
				continue;
			}
			String[] wordLength = new String[4];
			counter = 0;
			for(int charCount = 0; charCount < wordLength.length; charCount++) {
				wordLength[charCount] = mesonetWords.get(index).substring(charCount, charCount + 1);;
			}
			for(int letter = 0; letter < second.length(); letter++) {
				if(!(compare[1][letter].equals(wordLength[letter]))) {
					counter++;
				}
			}
			//Determines what node needs to increase
			if(counter == 0) {
				sNode0++;
			}
			else if(counter == 1) {
				sNode1++;
				wordsAtNode1.add(mesonetWords.get(index));
			}
			else if(counter == 2) {
				sNode2++;
				wordsAtNode2.add(mesonetWords.get(index));
			}
			else if(counter == 3) {
				sNode3++;
				wordsAtNode3.add(mesonetWords.get(index));
			}
			else if (counter == 4){
				sNode4++;
				wordsAtNode4.add(mesonetWords.get(index));
			}
			else {
				
			}
		}
		
		nodes.add(sNode0);
		nodes.add(sNode1);
		nodes.add(sNode2);
		nodes.add(sNode3);
		nodes.add(sNode4);
	}
	
	
	public ArrayList<Integer> getNodes(){
		return nodes;
	}
	
	public String[] getWords() {
		return words;
	}
	
	public static ArrayList<String> getNode1Words() {
		return wordsAtNode1;
	}
	
	public static ArrayList<String> getNode2Words() {
		return wordsAtNode2;
	}
	
	public static ArrayList<String> getNode3Words() {
		return wordsAtNode3;
	}
	
	public static ArrayList<String> getNode4Words() {
		return wordsAtNode4;
	}
	
	public static HammingDistanceCalculator makeNewHamDisCalc(String j, String k) throws IOException {
		return new HammingDistanceCalculator(j, k);
	}
	
	public void setNodes(int a, int b, int c, int d, int e) {
		sNode0 = a;
		sNode1 = b;
		sNode2 = c;
		sNode3 = d;
		sNode4 = e;
	}
}