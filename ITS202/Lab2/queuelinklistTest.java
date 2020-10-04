public class queuelinklistTest
{
	public static void main(String[] args)
	{
		queuelinklist obj = new queuelinklist();

		obj.enqueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);

		assert(obj.size()==4);
		assert(obj.isEmpty()==false);
		assert(obj.first()==1);
		assert(obj.dequeue()==1);
		assert(obj.size()==3);

		System.out.println("All is Well!!");
	}
}