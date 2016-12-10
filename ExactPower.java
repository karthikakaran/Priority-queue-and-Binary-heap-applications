//=============================================================================================================================================================================================//
//	  							*** ExactPower - Prints the numbers of the form a raised to b from 2 through n ***    																		   //
//=============================================================================================================================================================================================//
/*
 	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
 */
//=============================================================================================================================================================================================//



import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ExactPower{
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-
	 *
	 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
	 *  					-pq_PriorityQueue<Entry>:				private												Priority Queue of entries that holds the value of a raised to b, a and b										
	 *  					
	 *  @constructor: 		-constructorSignature:																		description:
	 *  
	 *  @memberFunction: 	-methodSignature:																			description:
	 *  					-public void exactPower(int n) 																functions that prints the exact powers of the form a raised to b from 2 through n
	 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	 */
	class Entry implements Comparable<Entry>{
		/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  @dateCreated:		-October-30-2016
		 *  @dateLastModified:	-November-04-2016
		 *  @author: 			-Nevhetha,karthika,kritika
		 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  
		 *  @comment:			-
		 *
		 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
		 *						-raise_int:								private												the value of a raised to b ( to be processed )
		 *						-a_int:									private												the corresponding b value for the triplet
		 *						-b_int: 								private												the corresponding b value for the triplet
		 *   					
		 *  @constructor: 		-constructorSignature:																		description:
		 *  					-Entry(int r,int i,int j)																	Non-Parameterized Constructor
		 *  
		 *  @memberFunction: 	-methodSignature:																			description:
		 *  					-public int compareTo(Entry o) 																overridden method that for implementing Comparable for the class
		 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		 */
		

		/*---------------------------------------------------------------
		* @memberVariable:
		* ---------------------------------------------------------------
		*/
		int raise;
		int a;
		int b;
		
		/*---------------------------------------------------------------
		* @constructor function:
		* ---------------------------------------------------------------
		*/
		Entry(int r,int i,int j){
			raise=r;
			a=i;
			b=j;
		}
		
		/*---------------------------------------------------------------
		* @overridden method to implement the comparable
		* ---------------------------------------------------------------
		*/
		/* returns the result of comparing the current object with the object being passed by comparing their corresponding 'raise' values */
		@Override
		public int compareTo(Entry o) {
			return this.raise-o.raise;
		}
	}
	
	
	class EntryComparator implements Comparator<Entry>{
		/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  @dateCreated:		-October-30-2016
		 *  @dateLastModified:	-November-04-2016
		 *  @author: 			-Nevhetha,karthika,kritika
		 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  
		 *  @comment:			-
		 *
		 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
		 *
		 *  @constructor: 		-constructorSignature:																		description:
		 *  
		 *  @memberFunction: 	-methodSignature:																			description:
		 *  					-public int compareTo(Entry o1,Entry o2) 													overridden method that for implementing Comparator
		 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		 */
		
		/*---------------------------------------------------------------
		* @overridden method to implement the comparator
		* ---------------------------------------------------------------
		*/
		/* returns the result of comparing the objects being passed by comparing their corresponding 'raise' values */
		@Override
		public int compare(Entry o1, Entry o2) {
			return o1.raise-o2.raise;
		}
		
	}
	
	/*---------------------------------------------------------------
	* @memberVariable:
	* ---------------------------------------------------------------
	*/
	PriorityQueue<Entry> pq=new PriorityQueue<>(new EntryComparator());
	

	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void exactPower(...) is a function that takes a number n and finds all the numbers of the form a raised to b from 2 through n
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  					-n_int: 										number upto which the exact powers are to be found     
	 *  
	 *  @localVariables: 	-variableName_dataType:							description:
	 *  					-tri_Entry:										that holds the current value of a raised to b being processed
	 *  					-last_int:										that holds the previous value of a raised to b to avoid 
	 *						-r_int:											Intermediate buffer to hold the value to be added to the priority queue
	 *
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	public void exactPower(int n) {
		
		/*Initial value of exact power, raise-4 ,a=2, b=2*/
		Entry tri=new Entry(4,2,2);
		pq.add(tri);
		
		/*Intial value of 'last' assigned to maximum value of integers*/
		int last=Integer.MAX_VALUE;
		
		while(!pq.isEmpty()){
			tri=pq.remove();
			if(tri.raise>n)
				break;
			if(last!=tri.raise){
				System.out.println(tri.raise);
				last=tri.raise;
			}
			int r;
			if(tri.a==2){
				r=(int) Math.pow(tri.a, tri.b+1);
				pq.add(new Entry(r,tri.a,tri.b+1));
			}
			r=(int) Math.pow(tri.a+1, tri.b);
			pq.add(new Entry(r,tri.a+1,tri.b));
		}
	}
	
	public static void main(String[] args){
		int n;
		Scanner in=new Scanner(System.in);
		if(args.length>0){
			n=Integer.parseInt(args[0]);
		}
		else {
			System.out.println("Enter the value of n");
			n=in.nextInt();
		}
		ExactPower e=new ExactPower();
		e.exactPower(n);
	}

}