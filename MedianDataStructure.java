//===========================================================================================================================
//Program : To form a data structure median in O(1)
//===========================================================================================================================
//@author: Karthika, Nevhetha, Kritika
//	Date created: 2016/11/02
//===========================================================================================================================
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianDataStructure<T> {
	//Create two heaps one is min and another is max
	PriorityQueue<Integer> pqLeft = new PriorityQueue<>(Comparator.naturalOrder()); //min-heap
	PriorityQueue<Integer> pqRight = new PriorityQueue<>(Comparator.reverseOrder()); //max-heap
	

	/** Procedure to add the array of elements 
	 * Runs in O(log n)
	 * @parameter a[] : Integer array : elements to be added
	 */
	//Store the elements one by one in the heaps by balancing the length of both
	public void add(Integer[] a) {
		//only if array is not empty
		if (a.length > 0) {
			//First add into max-heap
			pqRight.add(a[0]);
			
			for (int i = 1; i < a.length; i++) {
				//if the new element is lesser than root of max-heap, then store in max-heap else store in min-heap
				if(pqRight.peek() < a[i]) {
					//storing in min-heap as max-heap root is smaller than the element
					pqLeft.add(a[i]);
					//After insertion into left, check the size of left(min-heap) is greater than right(max-heap)
					//then remove the root of min-heap(left) and store in max-heap(right)   
					leftAdd();
				} else {
					//Store element in max-heap when it is less than max-heap root
					pqRight.add(a[i]);
					//Remove max-heap(right) root and store in min-heap(left) if the size of max-heap(right) is larger than min-heap(left) after insertion
					rightAdd();
				} 		
			}
		}
	}
	
	/** Procedure to balance the PQs after left addition 
	 */
	//Addition happens in O(logn) along with percolation up
	public void leftAdd() {
		//checks the size imbalance and transfers the element
		if (pqLeft.size() > pqRight.size()) {
			int min = pqLeft.remove();
			pqRight.add(min);
		} else
			return;
	}
	
	/** Procedure to balance the PQs after right addition 
	 */
	public void rightAdd() {
		//checks if max-heap size is greater than min-heap size after add, then transfers the element
		if (pqRight.size() > pqLeft.size()) {
			int max = pqRight.remove();
			pqLeft.add(max);
		} else
			return;
	}
	
	/** Procedure to find median
	 * Runs in O(1)
	 * @return : element : Object : that is median 
	 */
	//FindMedian in O(1)
	public Integer findMedian() {
		//Root of max-heap(right) is the median
		return pqRight.peek();
	}
	
	/** Procedure to remove median
	 * Runs in O(1)
	 * @return : element : Object : that is removed
	 */
	//Removes in O(logn) because after deletion 
	public Integer removeMedian() {
		//Removes the root of max-heap and return the removed object
		return pqRight.poll();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
     	System.out.println("Enter n :: ");
     	int n = in.nextInt();
     	Integer[] arr = new Integer[n];
     	for (int i = 0; i < n; i++) {
     		arr[i] = i + 1;
     	}
		MedianDataStructure<Integer> med = new MedianDataStructure<>();
		med.add(arr);
		System.out.println("Median ::" + med.findMedian());
		System.out.println("Removed median ::" + med.removeMedian());
		in.close();
	}

}
