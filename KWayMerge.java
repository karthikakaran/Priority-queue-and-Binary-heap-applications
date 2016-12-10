//=============================================================================================================================================================================================//
//	  							*** KWayMerge - Splits the array into k parts and combines them in O(kn logk) after sorting them individually ***    												   //
//=============================================================================================================================================================================================//
/*
 	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-03-1016
	 *  @author: 			-Nevhetha,karthika,kritika
 */
//=============================================================================================================================================================================================//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;



public class KWayMerge<T>{
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-
	 *
	 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
	 *  					-value_T:								private												value of the entry										
	 *  					-arrIndex_int:							private												index of the array from which this element was added
	 *  					-subIndex_int:							private												index from the array at which this element was present
	 *  
	 *  @constructor: 		-constructorSignature:																		description:
	 *  
	 *  @memberFunction: 	-methodSignature:																			description:
	 *  					-public void exactPower(int n) 																functions that prints the exact powers of the form a raised to b from 2 through n
	 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	 */
	class Entry<T extends Comparable<T>> implements Comparable<Entry>{
		/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  @dateCreated:		-October-30-2016
		 *  @dateLastModified:	-November-04-2016
		 *  @author: 			-Nevhetha,karthika,kritika
		 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  
		 *  @comment:			-
		 *
		 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
		 *  					-value_T:								private												value of the entry										
		 *  					-arrIndex_int:							private												index of the array from which this element was added
		 *  					-subIndex_int:							private												index from the array at which this element was present
		 *  
		 *  @constructor: 		-constructorSignature:																		description:
		 *  					-Entry(T array, int ai,int si):																Parameterized constructor
		 *  
		 *  @memberFunction: 	-methodSignature:																			description:
		 *  					-public int compareTo(Entry o)																
		 *  					-private T getValue()																		
		 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		 */
		T value;
		int arrIndex;
		int subIndex;
		Entry(T array, int ai,int si){
			value=array;
			arrIndex=ai;
			subIndex=si;
		}
		@Override
		public int compareTo(Entry o) {
			int cmp=this.getValue().compareTo((T) o.getValue());
			return cmp;
		}
		private T getValue() {
			return this.value;
		}
	}
	void sort(T[] arr,int k) {
		List<T[]> kArrays=new ArrayList<>();
		PriorityQueue<Entry> pq=new PriorityQueue<>();
		int size=(int) Math.ceil(arr.length/k); // # of small arrays
		
		/*breaking into k fragments each of size arrayLength/k*/
		T[] a;;
		int l=(k-1)*size;
		int p=0;
		for(int i=0;i<k-1;i++){
			int j=0;
			a=(T[]) new Object[arr.length/k];
			while(j<Math.ceil(arr.length/k)){
				a[j++]=arr[p++];
			}
			kArrays.add(i, a);
		}
		a=(T[]) new Object[arr.length-l];
		int o=0;
		for(int i=l;i<arr.length;i++){
			a[o++]=arr[i];
		}
		kArrays.add(k-1,a);	
		/* kArrays at this point has the k- fragments*/
		for(int i=0;i<k;i++){
			Arrays.sort(kArrays.get(i));
		}
		for(int i=0;i<k;i++){
			T[] array=kArrays.get(i);
			Entry n=new Entry((Comparable) array[0],i,0);
			pq.add(n);
		}
		int index=0;
		while(!pq.isEmpty()){
			Entry min=pq.remove();
			arr[index++]=(T) min.getValue();
			if(min.subIndex<kArrays.get(min.arrIndex).length-1){
				Entry n=new Entry((Comparable) kArrays.get(min.arrIndex)[min.subIndex+1],min.arrIndex,min.subIndex+1);
				pq.add(n);
			}
		}
		
	}
	private void printArray(T[] ts) {
		for(int i=0;i<ts.length;i++){
			System.out.println(ts[i]);
		}
		
	}
	public static void main(String[] args){
		Integer[] arr=new Integer[100];
		int k;
		Scanner in=new Scanner(System.in);
		for(int i=0; i<100; i++) {
		    arr[i] = new Integer(i);
		}
		System.out.println("Enter the value of k");
		k=in.nextInt();
		Shuffle.shuffle(arr);
		KWayMerge<Integer> kwm=new KWayMerge();
		kwm.sort(arr,k);
		for(int i=0;i<100;i++)
			System.out.println(arr[i]);
		in.close();
	}
}