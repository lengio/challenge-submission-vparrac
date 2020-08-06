import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Slang Challenge 06/08/2020
 * @author Valerie Parra Cortés
 * Main Class of the challenge. The input will be by console.
 */
public class Main {

	/**
	 * Main method of the challenge. This method read the input by console and calls to
	 * the method that solved the rotation problem
	 * @param args standard input arguments of Java
	 * @throws IOException if any error in the writing/reading in console
	 */
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
		// Call 2 of method	
		String ngram = mostFrequentNGram(string, ngrams);	
		System.out.println("Part 1");
		System.out.println(Arrays.toString(ngramas));
		System.out.println("Part 2");
		System.out.println(ngram);
	}
	/**
	 * This method compute the n-grams. The complexity of this algorithm is O(|string|)
	 * @param string to extract the n-grams
	 * @param n the length of grams
	 * @return an array of String that contains the n-grams
	 */

	private static String[] calculateNGrams(String string, int n) {	
		int lenghNGrams=string.length()+1-n;	
		String[] ngrams= new String[lenghNGrams];
		// Read the string
		for (int i = 0; i < lenghNGrams; i++) {
			//... And split it in the n-grams
			ngrams[i]=string.substring(i, i+n);
		}
		return ngrams;
	}

	/**
	 * This method return the most frequent n-gram of the String. Complexity |string|*log(|string|)
	 * cause the 
	 * @param string to extract the most-common n-gram
	 * @param n the length of grams
	 * @return The most frequently n-gram
	 */
	private static String mostFrequentNGram(String string, int n) {
		// Part one: calculate n-grams
		String[] ngrams= calculateNGrams(string,n);
		// Create a Tree map to save the frequencies
		Map<String, Integer> frequencies= new TreeMap<String, Integer>();		
		for (int i = 0; i < ngrams.length; i++) {
			// Update the frequencies
			if(frequencies.containsKey(ngrams[i])) {
				Integer previousValue=frequencies.get(ngrams[i]);
				frequencies.put(ngrams[i], previousValue+1);
			}
			else {
				frequencies.put(ngrams[i], 1);
			}
		}
		int maxFrequency=0;
		String ngram="";
		//Search for the first most frequent n-gram
		for (int i = 0; i < ngrams.length; i++) {
			int frequency= frequencies.get(ngrams[i]);
			if(frequency>maxFrequency) {
				ngram=ngrams[i];
				maxFrequency=frequency;
			}
		}
		return ngram;
	}
}