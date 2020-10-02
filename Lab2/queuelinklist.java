public class queuelinklist
{
	Node head;
	Node tail;
	int size;
	public queuelinklist()
	{
		head=null;
		tail=null;
		size=0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		if(size==0)
		{
			return true;
		}
		return false;
	}
	public void enqueue(int x)
	{
		Node newest = new Node(x, null);
		if(isEmpty())
		{
			head = newest;
			tail = newest;
		}
		else
		{
			tail.setNext(newest);
			tail = newest;
		}
		size +=1; 
	}
	public int first()
	{
		if(isEmpty())
		{
			return 0;
		}
		return head.getElement();
	}
	public int dequeue()
	{
		int first = head.getElement();
		if(isEmpty())
		{
			return 0;
		}
		head = head.getNext();
		size-= 1;
		return first;
	}
}
class Node
{
	private int element;
	private Node next;
	public Node(int element , Node next)
	{
		this.element = element;
		this.next = next;
	}
	public int getElement()
	{
		return element;
	}
	public Node getNext()
	{
		return next;
	}
	public void setElement(int x)
	{
		element = x;
	}
	public void setNext(Node x)
	{
		next = x;
	}
}