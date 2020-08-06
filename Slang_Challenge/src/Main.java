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


	private static String[] calculateNGrams(String string, int n) {	
		int lenghNGrams=string.length()+1-n;	
		String[] ngrams= new String[lenghNGrams];
		for (int i = 0; i < lenghNGrams; i++) {
			ngrams[i]=string.substring(i, i+n);
		}
		return ngrams;
	}

	private static String mostFrequentNGram(String string, int n) {
		String[] ngrams= calculateNGrams(string,n);		
		Map<String, Integer> frecuencies= new TreeMap<String, Integer>();		
		for (int i = 0; i < ngrams.length; i++) {
			if(frecuencies.containsKey(ngrams[i])) {
				Integer previousValue=frecuencies.get(ngrams[i]);
				frecuencies.put(ngrams[i], previousValue+1);
			}
			else {
				frecuencies.put(ngrams[i], 1);
			}
		}
		int maxFrequency=0;
		String ngram="";
		for (int i = 0; i < ngrams.length; i++) {
			int frequency= frecuencies.get(ngrams[i]);
			if(frequency>maxFrequency) {
				ngram=ngrams[i];
			}
		}
		return ngram;
	}
}