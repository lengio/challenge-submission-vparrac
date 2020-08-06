import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Slang Challenge 06/08/2020
 * @author Valerie Parra Cortés
 * Main Class of the challenge. The input will be by console.
 */
public class Main {

	public static void main(String[] args) throws IOException {
		//Read the input
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		//Split the string
		String[] input = bf.readLine().split(",");
		String string = input[0];
		//Parse the size
		int ngrams=Integer.parseInt(input[1]);
		//Call of method
		String[] ngramas = calculateNGrams(string,ngrams);		
		System.out.println(Arrays.toString(ngramas));
	}


	private static String[] calculateNGrams(String string, int n) {	
		int lenghNGrams=string.length()+1-n;	
		String[] ngrams= new String[lenghNGrams];
		for (int i = 0; i < lenghNGrams; i++) {
			ngrams[i]=string.substring(i, i+n);
		}
		return ngrams;
	}

	private static String mostFrequentNGram(String string, int n) {
		return null;
	}
}