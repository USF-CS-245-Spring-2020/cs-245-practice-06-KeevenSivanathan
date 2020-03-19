class Node<T> //Node class
{
	public Node next;
	public T data;

	public Node(Object data) //Node constructor with paramters of any Object
	{
		this.data = (T) data; 
	}

}

public class LinkedList<T> implements List<T>
{	
	Node<T> head; 
	int size;

	public LinkedList() //LinkedList constructor which sets head of node to null and size to 0
	{
		head = null;
		size = 0; 
	}

	public T get(int pos)
	{
		Node temp = head; //Sets a temporary node to equal to the head

		for(int i = 0; i < pos; i++) //Iterate through the linked list until input pos 
		{
			temp = temp.next; //Temp node is set to equal node of input pos
		}

		return (T) temp.data;
	} 

	public int size()
	{
		return size;
	}

	public void add(T item)
	{
		if(head == null) //If linkedlist is empty
		{
			head = new Node<T>(item); //Create a new head 
			++size; //Increase the size of the linked list
		}
		else
		{
			Node<T> temp2 = head; 
			while(temp2.next != null) //While iterating through the list, it does not equal to null
			{
				temp2 = temp2.next; //Go to the end of the list 
			}

			temp2.next = new Node<T>(item); //Add new node to the end of the list
			++size; //Increase capacity of linked list
		}
	}

	public void add(int pos, T item)
	{
		if (pos == 0) //If input pos is at the head
		{
			Node<T> temp = new Node<T>(item); //New temporary node with data
			temp.next = head; //Previous head is now set next to temporary node
			head = temp; //New head is given values from the temporary node
			++size; //Increase capacity
			return;
		}

		Node<T> temp = new Node<T>(item); //New temporary node with data
		Node<T> temp2 = head; //Temporary node 2

		for(int i = 0; i < pos-1; i++) //Iterate through linked list until one node before input pos 
		{
			temp2 = temp2.next; //Temp Node 2 is given data from input pos - 1 
		}
		
		temp.next = temp2.next;  
		temp2.next = temp; //Data is input into input pos
		++size; //Increase capacity 
		return; 
	}


	public T remove(int pos)
	{
		if(pos == 0) //If input pos is at the head 
		{
			T item = (T) head.data; 
			head = head.next; //New head is given by taking the next node
			size--; //Decrease linked list capacity
			return item; //Return removed item
		}

		else
		{
			Node temp2 = head;
			Node<T> temp = temp2;
			for(int i = 0; i < pos-1; i++) //Iterate through linkedlist until input pos-1
			{
				temp2 = temp2.next; //Temp Node 2 is at index pos 
			}
			Node temp3 = temp2.next; 
			T item = (T) temp3.data; //Item taken out of linked list
			size--; // Decrease linked list capacity 
			return item;  //Return removed item
		}
	}


}

