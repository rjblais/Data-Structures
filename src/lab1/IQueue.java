package lab1;

public interface IQueue <E>{

	public void offer(E element);
	public E poll() throws EmptyQueueExcetion;
	public E peek() throws EmptyQueueExcetion;
	public boolean isEmpty();
	public int size();
	
	
	
}
