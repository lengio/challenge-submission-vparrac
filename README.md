# SlangChallenge
This repository contains the solution of my Slang Challenge

The main class is in SlangChallenge/src/Main.java

The program reads the input by console in this way: "String,n-gram_size". For the example "Slang,2".

## Part one

This method compute the n-grams. The complexity of this algorithm is O(|string|)

## Part two 

This method return the most frequent n-gram of the String. Complexity O(|string|log(|string|))
cause the first loop is |string| and the operations in a tree map (by javadocs) is log(n).
It is important that if we considerate that compare 2 strings is O(min(|string1|,|string2|), 
and to insert in the map we need to do compare operations, the entire complexity of algorithm
is O(|string|log(|string|)min(|string1|,|string2|) which is approximately O(n x n x log(n)) 
	  
