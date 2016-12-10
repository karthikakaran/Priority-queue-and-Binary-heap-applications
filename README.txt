CS 5V81.012 : Implementation of Data Structures and Algorithms
Optional Project - Group 3

Contents of the folder
**************************

README.txt
KWayMerge.java
HuffmanCoding.java
ExactPower.java
Median.java
BinaryHeap.java
PQ.java
Shuffle.java
		
Instructions for Compiling
******************************

***********************************************************************************************************************************************************************************
KWayMerge.java
***********************************************************************************************************************************************************************************
compile		: javac KWayMerge.java
run		: java KWayMerge 
***********************************************************************************************************************************************************************************

Input		:	Enter the value of k
			10

Output		:	0
			1
			2
			3
			4
			.
			.
			.
			96
			97
			98
			99


Explanation	:	The program takes in as an input the value for k, it then performs the k way merge on the shuffled first 100 numbers starting with 0.
************************************************************************************************************************************************************************************
compile		: javac HuffmanCoding.java
run		: java HuffmanCoding 
************************************************************************************************************************************************************************************
Input format	:	Enter the number of characters:
			<# of characters in the input>
			<character_1 frequency_1>
			<character_2 frequency_2>
			.				
			.
			.
			.
			<character_n frequency_n>

Input		:	Enter the number of characters:
			6
			a	    5
    			b           9
    			c           12
    			d           13
    			e           16
    			f           45

Output		:
			Char: f Code: 0
			Char: c Code: 100
			Char: d Code: 101
			Char: a Code: 1100
			Char: b Code: 1101
			Char: e Code: 111

				
Explanation	: 	The program takes as input the number of characters, followed by characters themselves along with their frequencies and outputs the corresponding Huffman code.
***********************************************************************************************************************************************************************************
compile		: javac ExactPower.java
run		: java ExactPower 
***********************************************************************************************************************************************************************************
Input		:	Enter the value of n
			100

Output		:	4
			8
			9
			16
			25
			27
			32
			36
			49
			64	
			81
			100

Explanation	:	The program takes a number n, and prints all the numbers of the form a raised to b from 2 through n.	
***********************************************************************************************************************************************************************************
compile		: javac Median.java
run		: java Median 
***********************************************************************************************************************************************************************************
Input		:	Enter n :: 
			50

Output		:	Median ::25
			Removed median ::25

Explanation	: This program represents the data structure that adds and deletes an element in O(log n) time but retrieves the median in O(1) time.
		  [Checked by inserting first n natural numbers and calling median() and removeMedian() method twice].
***********************************************************************************************************************************************************************************
compile		: javac BinaryHeap.java
run		: java BinaryHeap 
***********************************************************************************************************************************************************************************
Input		:	Enter n :: 
			50
			Enter k vaue :: 
			6

Output		:	6th smallest element :: 6

Explanation	: This program implements binary heap wherein the insertion and deletion are performed in log(n) time and search of minimum/maximum is performed in O(1) time.
		  [Prints the nth smallest element from the n value entered in natural order].
***********************************************************************************************************************************************************************************

