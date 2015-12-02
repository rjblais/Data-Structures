package lab0;

public interface IStack<E> {
	public E push(E x);
	public E pop();
	public boolean empty();
	public E peek();
}
