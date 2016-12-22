package stack;

public class Stack<T> 
{
	// Constructors
	
	// Instance Methods
	/**
	 * Utility method: checks whether the stack is empty to avoid popping
	 * off an empty stack
	 * @return true if stack is empty, false otherwise
	 */
	private boolean isEmpty()
	{
		return top == null;
	}
	
	/**
	 * Utility method: push a value onto the stack
	 * @param newData
	 */
	public void push(T newData)
	{
		StackNode newNode = new StackNode(newData);
		
		newNode.next = top;
		top = newNode;
	}
	
	/**
	 * Utility method: retrieve the top value off of the stack
	 * @return
	 */
	public T pop()
	{
		if(!isEmpty())
		{
			T retVal = top.data;
			top = top.next;
			return retVal;
		}
		else return null;
	}
	
	// Instance Fields
	StackNode top;
	
	// Internal Classes
	private class StackNode
	{
		// Constructors
		/**
		 * Default constructor
		 * @param newData
		 */
		private StackNode(T newData)
		{
			data = newData;
			next = null;
		}
		
		// Instance Fields
		StackNode next;
		T data;
	}
}
