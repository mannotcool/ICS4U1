class StaticStack<T> implements StackADT<T> {
    private int top;
    private T[] stackArray;
    private final int MAX_SIZE;

    // Creates an empty stack using the specified capacity.
    public StaticStack(int maxSize) {
        MAX_SIZE = maxSize;
        clear();
    }

    // Adds the specified element on the top of the stack, or does nothing if full.
    @Override
    public void push(T element) {
        if ( top < stackArray.length-1 ) {
            top++;
            stackArray[top] = element;
        }
    }

    // Removes element on the top of the stack and returns a reference to it, or null (if empty).
    @Override
    public T pop() {
        if ( isEmpty() )
            return null;

        T result = stackArray[top];
        stackArray[top] = null;
        top--;
        return result;
    }

    // Returns a reference to the element on the top of the stack, or null (if empty).
    @Override
    public T peek() {
        if ( isEmpty() )
            return null;

        return stackArray[top];
    }

    // Returns true if the stack contains no elements, false otherwise.
    @Override
    public boolean isEmpty() {
        return (top == -1);
    }

    // Returns the number of elements in the stack.
    @Override
    public int size() {
        return (top+1);
    }

    // Clears all elements from the stack
    @Override
    @SuppressWarnings("unchecked")      // Don't show warning, line 59 is safe!
    public void clear() {
        top = -1;
        stackArray = (T[])(new Object[MAX_SIZE]);
    }

    // Returns a String representation of the stack.
    @Override
    public String toString() {
        String result = "Stack Contains: ";

        for (T element : stackArray) {
            result += "["+element+"] ";
        }

        return result;
    }
}