public interface QueueADT<T> {
    // Adds one element to the top of the queue.
    public void enqueue(T element);
    
    // Removes and returns a reference to the front element of the queue.
    public T dequeue();
    
    // Returns a reference to the front element, without removing it from the queue.
    public T peek();
    
    // Returns true if the queue contains no elements, false otherwise.
    public boolean isEmpty();
    
    // Returns the number of elements in the queue.
    public int size();
 
    // Clears all elements from the queue
    public void clear();
    
    // Returns a String representation of this queue.
    public String toString();   
}