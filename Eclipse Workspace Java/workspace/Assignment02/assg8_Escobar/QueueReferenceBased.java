package assg8_Escobar;

public class QueueReferenceBased<E> implements QueueInterface<E> {
	
	private Node<E> lastNode;

	public QueueReferenceBased() {
		lastNode = null;
	}  // end default constructor

	// queue operations:
	public boolean isEmpty() {
		return lastNode == null;
	}  // end isEmpty

	public void dequeueAll() {
		lastNode = null;
	}  // end dequeueAll

	public void enqueue(E newItem) {
		Node<E> newNode = new Node<E>(newItem);

		// insert the new node
		if (isEmpty()) {
			// insertion into empty queue
			newNode.setNext(newNode);
		}
		else {
			// insertion into nonempty queue
			newNode.setNext(lastNode.getNext());
			lastNode.setNext(newNode);
		}  // end if

		lastNode = newNode;  // new node is at back
	}  // end enqueue

	public E dequeue() throws QueueException {
		if (!isEmpty()) {
			// queue is not empty; remove front
			Node<E> firstNode = lastNode.getNext();
			if (firstNode == lastNode) { // special case?
				lastNode = null;           // yes, one node in queue
			}
			else {
				lastNode.setNext(firstNode.getNext());
			}  // end if
			return firstNode.getItem();
		}
		else {
			throw new QueueException("QueueException on dequeue:"
					+ "queue empty");
		}  // end if
	}  // end dequeue

	public E peek() throws QueueException {
		if (!isEmpty()) {
			// queue is not empty; retrieve front
			Node<E> firstNode = lastNode.getNext();
			return firstNode.getItem();
		}
		else {
			throw new QueueException("QueueException on peek:"
					+ "queue empty");
		}  // end if
	}  // end peek
}