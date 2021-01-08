/**
 *  
 *  @author Hadi El-Kadri
 *  Represents an array being implemented as a stack
 * 
 */

public class ArrayStack<T> implements ArrayStackADT<T> {

  /**
   * a constant DEFAULT_CAPACITY representing the start capacity of the array
   */
	
	private final int DEFAULT_CAPACITY = 20;
	
/**
   * An int "top" that represents the number of elements in the array
   * and also the next available position in the array
   */
	
	private int top;

  /**
   * an array representing elements called "stack"
   */
	
	private T[] stack;
	
/**
 * An empty stack is created that can hold elements up to the DEFAULT_CAPACITY
 */

	public ArrayStack() {
		top = -1;
		stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

/**
 * An empty stack is created with a desired capacity
 * @param initialCapacity represents a desired capacity 
 */

	public ArrayStack(int initialCapacity) {
		top = -1;
		stack = (T[]) (new Object[initialCapacity]);
	}

/**
 * An element is added to the top of the stack and the capacity
 * is expanded if necessary
 * @param an element called "dataItem" is going to be pushed onto the stack
 */

	public void push(T dataItem) {
		if (top + 1 == stack.length) {
			if (stack.length < 100) {
				T[] tempStack = (T[]) new Object[stack.length * 2];

				for (int i = 0; i <= top; i++)
					tempStack[i] = stack[i];

				stack = tempStack;
			} else if (stack.length >= 100) {
				T[] tempStack = (T[]) new Object[stack.length + 50];

				for (int i = 0; i <= top; i++)
					tempStack[i] = stack[i];

				stack = tempStack;
			}
		}
		top++;
		stack[top] = dataItem;
	}

	/**
	 * The top element of the stack is popped and a reference is given
	 * If there are no elements in the stack an exception is thrown
	 * 
	 * @return The element T is removed from the top of the stack
	 * @throws EmptyCollectionException if the stack is empty and can not be popped
	 */

	public T pop() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack");

		T poppedItem = stack[top];
		stack[top] = null;
		top--;

		if ((size()) < stack.length / 3 && stack.length > 20) {
			T[] decreaseStack = (T[]) (new Object[stack.length / 2]);
			for (int i = 0; i <= top; i++) {
				decreaseStack[i] = stack[i];
			}
			stack = decreaseStack;
		}
		return poppedItem;
	}

	/**
	 * Throws an exception if the stack is empty and returns a reference to the top
	 * of the stack
	 * 
	 * @return T element on top of stack
	 * @throws EmptyCollectionException if a peek is attempted on empty stack
	 */

	public T peek() throws EmptyStackException {
		if (isEmpty())
			throw new EmptyStackException("Stack");

		return stack[top];
	}

	/**
	 * Returns true if this stack is empty and false if it is not empty
	 * 
	 * @return boolean true if stack is empty, false if not
	 */

	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * Returns the number of elements in this stack
	 * 
	 * @return int the number of elements in this stack
	 */
	public int size() {
		return top + 1;
	}

	/**
	 * Returns a string representing this stack.
	 * 
	 * @return String representing this stack
	 */
	public String toString() {
		String result = "";

		for (int count = 0; count < stack.length; count++) {
			if (count == 0) {
				result = stack[count].toString();
			}

			else {

				result += ", " + stack[count].toString();
			}
		}
		return ("Stack: " + result);
	}

	public int length() {
		return stack.length;
	}
}
