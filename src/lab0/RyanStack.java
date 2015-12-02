package lab0;

public class RyanStack<E> implements IStack<E> {
	
	ArrayList<E> myDate = new ArrayList<>();
	
	@Override
	public E push(E x) {
		if (myData.add(x)) {
			return x;
		}
		return null;
	}

	@Override
	public E pop() {
		if (!empty()) {
			return myData.remove(myData.size() - 1);
		} else {
			throw new EmptyRyanStackException("Pop error");
		}
		return null;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}
}
