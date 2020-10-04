public class queuetest
{
	public static void main(String []args)
{
	queue obj=new queue(5);
	obj.enqueue(10);
	obj.enqueue(20);
	obj.enqueue(30);
	obj.enqueue(40);
	obj.enqueue(50);
	System.out.println(obj.isEmpty());
	System.out.println(obj.len() + " is the length");
	System.out.println(obj.first()+ " is first element");
	System.out.println(+obj.dequeue()+ " is the first element removed");
	System.out.println(obj.len() + " is length after removing an element");
}
}