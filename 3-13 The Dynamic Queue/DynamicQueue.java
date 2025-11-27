class DynamicQueue<T> implements QueueADT<T> {
    private LinkedList<T> myList;
    
    // Creates an empty stack (based on a linked list).
    public DynamicQueue() {
        myList = new LinkedList<T>();
    }

    // Adds the specified element to the top of the stack
    public void enqueue( T element ) {
        myList.addLast( element );
    }

    // Removes the element from the top of the stack and returns a reference to it, or null (if empty).
    public T dequeue() {
        return myList.removeFirst();
    }
    
    // Returns a reference to the element at the front of the queue, or null (if empty).
    public T peek() {
        return myList.peekFirst();
    }
    
    // Returns true if the queue contains no elements, false otherwise.
    public boolean isEmpty() {
        return myList.isEmpty();
    }
    
    // Returns the number of elements in the queue.
    public int size() {
        return myList.size();
    }
    
    // Clears all elements from the queue
    public void clear() {
        myList.clear();
    }
    
    // Returns a String representation of the queue.
    public String toString() {
        return myList.toString();
    }
}  