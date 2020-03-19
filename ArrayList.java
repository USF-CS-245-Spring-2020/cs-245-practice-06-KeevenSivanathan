import java.util.Arrays; 

public class ArrayList<T> implements List<T> 
{	
	T[] data;
	int size; 
	
	//ArrayList constructor which initialzes an array list of any object type of length 10 and initial size of 0
	public ArrayList() 
	{
		data = (T[]) new Object[10]; 
		size = 0; 
	}

	public T get(int pos)
	{
		if(pos < 0 || pos >= size) // If input position is less than 0 or more than the size of the array then exception thrown. 
		{
			throw new IndexOutOfBoundsException(); 
		}

		else
		{
			return data[pos]; //Returns object of type T given input of pos
		}
	}

	public void add(Object item)
	{
		if(size == data.length) // If size of arraylist is equal to length of data, arraylist is too small, it grows. 
		{
			reSizeArray();
		}

		data[size++] = (T) item; //Size of array grows, and item is added to the end of the arraylist
	}

	public void add(int pos, Object item)
	{	
		if (size == data.length) // If size of arraylist is equal to length of data, arraylist is too small, it grows. 
		{
			reSizeArray(); 
		}


		for(int i = size; i > pos; i--) // Looks for position and pushes previous position forward and inserts new item
		{
			data[i] = data[i-1]; 
		}

		data[pos] = (T) item;
		size++;

	}

	public T remove(int pos)
	{
		if (pos < 0 || pos > size) // If input position is less than 0 or more than the size of the array then exception thrown. 
		{
			throw new IndexOutOfBoundsException(); 
		}

		T item = data[pos]; //Temporary item to hold data for element to be removed

		for(int i = pos; i < size - 1; i++) //Looks for item
		{
			data[i] = data[i+1]; 
		}

		size--; //Reduces the size by 1 as an item has been deleted. 

		return item; //Removed item is then returned
	}

	public void reSizeArray() //Increases the capacity of the array by doubling its size. 
	{	
		int newCapacity = data.length * 2; 
		data = Arrays.copyOf(data, newCapacity); 
	}

	public int size()
	{
		return size; 
	}

	
}