//===========================================================================================================================
//Program : To find the Kth smallest element
//===========================================================================================================================
//@author: Karthika, Nevhetha, Kritika, sample code provided by Dr. Balaji
//	Date created: 2016/11/01
//===========================================================================================================================
// Ver 1.0:  Starter code for Binary Heap implementation

import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

public class BinaryHeap<T> implements PQ<T> {
	T[] pq;
	Comparator<T> c;
	int size;

	/** Build a priority queue with a given array q */
	BinaryHeap(T[] q, Comparator<T> comp) {
		pq = q;
		c = comp;
		size = q.length - 1;
		buildHeap();
	}

	/** Create an empty priority queue of given maximum size */
	BinaryHeap(int n, Comparator<T> comp) { /* to be implemented */
		size = n;
		c = comp;
	}

	public void insert(T x) {
		add(x);
	}

	public T deleteMin() {
		return remove();
	}

	public T min() {
		return peek();
	}

	public T[] resize() {
		int pqLength = pq.length * 2;
		T[] temp = (T[]) new Object[pqLength];
		System.arraycopy(pq, 0, temp, 0, size);
		pq = temp;
		return pq;
	}

	public void add(T x) { /* to be implemented */
		if (size == pq.length - 1) {
			// Resize the array pq
			resize();
		}
		size++;
		pq[size] = x;
		percolateUp(size);
	}

	public T remove() { /* to be implemented */
		// Return first element
		T min = peek();
		if (min != null) {
			pq[1] = pq[size--]; // remove and decread the size;
			percolateDown(1);
		}
		return min;
	}

	public T peek() { /* to be implemented */
		return (size >= 2) ? pq[1] : null;
	}

	/** pq[i] may violate heap order with parent */
	void percolateUp(int i) { /* to be implemented */
		pq[0] = pq[i];

		while (c.compare(pq[i / 2], pq[0]) > 0) {
			pq[i] = pq[i / 2];
			i = i / 2;
		}

		pq[i] = pq[0];
	}

	/** pq[i] may violate heap order with children */
	void percolateDown(int i) { /* to be implemented */
		int size = pq.length;
		T x = pq[i];
		while (2 * i <= size) {
			if (2 * i == size) {
				if (c.compare(x, pq[(2 * i) - 1]) > 0) {
					pq[i] = pq[size - 1];
					i = size - 1;
				} else
					break;
			} else {
				int sChild = 2 * i - 1; // -1 may be required
				if (c.compare(pq[sChild], pq[sChild + 1]) > 0) {
					sChild = sChild + 1;
				}
				if (c.compare(x, pq[sChild]) > 0) {
					pq[i] = pq[sChild];
					i = sChild;
				} else
					break;
			}
		}
		pq[i] = x;
	}

	/** Create a heap. Precondition: none. */
	void buildHeap() {
		// Runs in O(n)
		for (int i = size / 2; i > 0; i--) {
			percolateDown(i);
		}
	}
	
	/** Procedure to find the kth smallest element 
	 * @parameter k : int : kth index
	 * @return element : Object : kth smallest element 
	 */
	 T kthSmallest(int k) {
		 if (size < k) return null;
		 else {
			 //Create a max heap of size K + 1
			 BinaryHeap<T> maxHP = new BinaryHeap<>(k + 1, c.reversed());
			 //Copy the first K elements of  existing pq into new one
			 T[] temp = (T[]) new Object[k+1];
			 maxHP.pq = temp;
			 System.arraycopy(pq, 0, maxHP.pq, 0, k + 1); 
			 int i = k + 1;
			 maxHP.buildHeap();
			 //Of the remaining elements add those that are smaller than the root
			 while (i <= this.size) {
				 if (c.compare(maxHP.peek(), pq[i]) > 0) {
					 maxHP.remove(); 
					 maxHP.add(pq[i]);
				 }
				 i++;
			 }
			 //Final root would give the K the smallest element;
			 return maxHP.peek();
		 }
	 }
	 
     public static void main(String[] args) {
     	Scanner in = new Scanner(System.in);
     	System.out.println("Enter n :: ");
     	int n = in.nextInt();
     	//Random rand = new Random();
     	Integer[] arr = new Integer[n];
     	for (int i = 1; i < n; i++) {
     		arr[i] = i;
     		//System.out.print(arr[i] + " ");
     	}
     	BinaryHeap<Integer> bin = new BinaryHeap<>(arr, Comparator.naturalOrder());
     	System.out.println("Enter k vaue :: ");
     	int k = in.nextInt();
     	System.out.println(k + "th smallest element :: " + bin.kthSmallest(k));
     	in.close();
     }
}
