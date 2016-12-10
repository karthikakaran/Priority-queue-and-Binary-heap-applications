//=============================================================================================================================================================================================//
//	  							*** HuffmanCoding: For the given set of characters and their frequencies, this program returns the binary code for each symbol  ***    																		   //
//=============================================================================================================================================================================================//
/*
 	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
 */
//=============================================================================================================================================================================================//



import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanCoding  {
	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-
	 *
	 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
	 *  					-hTree_PriorityQueue<Entry>:				private											has the optimal Huffman tree for the characters processed so far										
	 *  					
	 *  @constructor: 		-constructorSignature:																		description:
	 *  
	 *  @memberFunction: 	-methodSignature:																			description:
	 *  					-void huffmanCode()			 																computes the Huffman tree for the given set of characters and their frequencies
	 *  					-void printCode()																			computes the binary code for the characters by using the huffman tree generated and prints them
	 *  					-void traversePrint(Node node)																helper function that prints the binary code for the corresponding characters
	 *  					-void printCode(Node node,Node child)														helper function that computes the binary code for the characters in the huffman tree
	 *  					-void add(String x, int f) 																	adds the string of given frequency to the priority queue
	 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
	 */
	class Node implements Comparable<Node>{
		/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  @dateCreated:		-October-30-2016
		 *  @dateLastModified:	-November-04-2016
		 *  @author: 			-Nevhetha,karthika,kritika
		 *----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		 *  
		 *  @comment:			-
		 *
		 *  @memberVariable: 	-variableName_dataType:					accessSpecifier:									description:	
		 *  					-value_String:							private												String, that is either the concatenation of the children  node's values (for internal nodes)
		 *  																												character itself (leaf nodes).	
		 *  					-frequency_int:							private												frequency of the character(leaf node)
		 *  																												sum of the frequencies of the children (internal node)
		 *  					-code_String:							private												binary code corresponding to the node in the huffman tree
		 *  					-left_Node:								private												left Child of the node
		 *  					-right_Node:							private												right child of the node
		 *  
		 *  @constructor: 		-constructorSignature:																		description:
		 *  					-Node(String x,int f)																		Parameterized constructor
		 *  
		 *  @memberFunction: 	-methodSignature:																			description:
		 *  					-public int compareTo(Node o)																overridden method to implement the comparable
		 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		 */
		
		/*---------------------------------------------------------------
		* @memberVariable:
		* ---------------------------------------------------------------
		*/
		String value;
		int frequency;
		String code;
		Node left;
		Node right;
		
		/*---------------------------------------------------------------
		* @constructor function:
		* ---------------------------------------------------------------
		*/
		Node(String x,int f){
			value=x;
			frequency=f;
			left=null;
			right=null;
		}
		
		/*---------------------------------------------------------------
		* @overridden method to implement the comparable
		* ---------------------------------------------------------------
		*/
		/* returns the result of comparing the current object with the object being passed by comparing their corresponding 'frequency' values */
		@Override
		public int compareTo(Node o) {
			return this.frequency-o.frequency;
		}
	}
	class huffmanComparator implements Comparator<Node>{
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
		 *  					-public int compareTo(Node o1,Node o2)														overridden method to implement the comparator
		 *  --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------		
		 */
		
		/*---------------------------------------------------------------
		* @overridden method to implement the comparator
		* ---------------------------------------------------------------
		*/
		/* returns the result of comparing the objects being passed by comparing their corresponding 'frequency' values */
		@Override
		public int compare(Node o1, Node o2) {
			return o1.frequency-o2.frequency;
		}	
	}
	
	/*---------------------------------------------------------------
	* @memberVariable:
	* ---------------------------------------------------------------
	*/
	PriorityQueue<Node> hTree=new PriorityQueue<>();
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void huffmanCode() is a function that computes the huffman tree for the given set of characters and their frequencies 
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  
	 *  @localVariables: 	-variableName_dataType:							description:
	 *						-n1_Node:										node with least frequency from the huffman tree constructed so far
	 *						-n2_Node:										node with second least frequency from the huffman tree constructed so far
	 *						-n_Node:										new Node with n1 and n2 as its children and frequency = sum of its chilren's frequencies
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	void huffmanCode(){
		while(hTree.size()>1){
			Node n1=hTree.remove();
			Node n2=hTree.remove();
			Node n=new Node(n1.value+n2.value,n1.frequency+n2.frequency);
			n.left=n1;
			n.right=n2;
			hTree.add(n);
		}
		printCode();
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void printCode() is a function that computes the huffman tree for the given set of characters and their frequencies 
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  
	 *  @localVariables: 	-variableName_dataType:							description:
	 *						
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	void printCode() {
		Node node=hTree.peek();
		printCode(null,node);
		traversePrint(node);
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void traversePrint(....) is a function that prints the binary codes generated using huffman trees for the given set of characters 
	 *  					 and frequencies
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  					-node_Node:										current node being processed
	 *  	
	 *  @localVariables: 	-variableName_dataType:							description:
	 *						
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	void traversePrint(Node node) {
		if(node.left!= null&&node.right!=null) {
		    traversePrint(node.left);
		    traversePrint(node.right);
		}
		if(node.value.length()==1)
			System.out.println("Char: "+node.value+" Code: "+node.code);
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void printcode(....) is a helper function that computes the huffman code for the current node. 
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  					-child_Node:									current node being processed whose binary code is to be found
	 *  					-node_Node:										Parent of the node being processed	
	 *  								
	 *  @localVariables: 	-variableName_dataType:							description:
	 *						
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	void printCode(Node node,Node child) {
		if(child==null)
			return;
		if(node==null)
			child.code="";
		if(node!=null){
			if(child==node.left){
				child.code=node.code+"0";
			}
			else if(child==node.right){
				child.code=node.code+"1";
			}
		}
		if(child!=null)
			printCode(child,child.left);
		if(child!=null)
			printCode(child,child.right);
	}
	
	/*-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  @dateCreated:		-October-30-2016
	 *  @dateLastModified:	-November-04-2016
	 *  @author: 			-Nevhetha,karthika,kritika
	 *-------------------------------------------------------------------------------------------------------------------------------------------------------
	 *  
	 *  @comment:			-void add(....) is a function that adds the node (character and its frequency).
	 *
	 *  @param: 			-variableName_dataType:							description:	
	 *  					-x_String:										character
	 *  					-f_int:											frequency of the character being processed
	 *  								
	 *  @localVariables: 	-variableName_dataType:							description:
	 *						
	 *  @return:			-variableName_dataType:							description:	   
	 *  -----------------------------------------------------------------------------------------------------------------------------------------------------	
	 *  
	 *  	
	 */
	void add(String x, int f) {
		Node n=new Node(x,f);
		hTree.add(n);
	}
	public static void main(String[] args){
		int n;
		Scanner in=new Scanner(System.in);
		if(args.length>0)
			n=Integer.parseInt(args[0]);
		else{
			System.out.println("Enter the number of characters:");
			n=in.nextInt();
		}
		HuffmanCoding hc=new HuffmanCoding();
		for(int i=0;i<n;i++){
			String s=in.next();
			int freq=in.nextInt();
			hc.add(s, freq);
		}
		hc.huffmanCode();
		in.close();	
	}
}
