// Ver 1.0:  PQ interface
//===========================================================================================================================
//Program : Class for Priority queue
//===========================================================================================================================
//@author: Karthika, Nevhetha, Kritika, sample code provided by Dr. Balaji
//	Date created: 2016/11/01
//===========================================================================================================================
public interface PQ<T> {
	public void insert(T x);

	public T deleteMin();

	public T min();

	public void add(T x);

	public T remove();

	public T peek();
}
