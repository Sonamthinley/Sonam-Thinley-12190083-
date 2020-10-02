public class Stacktest{
	public static void main(String[] args){
		Stack obj1=new Stack();
		obj1.push(2);
		obj1.push(8);
		/*System.out.println(obj1.pop() + " is removed");
		System.out.println(obj1.size() + " is the size");
		System.out.println(obj1.top() + " is the top element");
		System.out.println(obj1.isEmpty());*/
		assert(obj1.pop() == 8);
		assert(obj1.size() == 1);
		assert(obj1.top() == 2);
		assert(obj1.isEmpty() == false);
		System.out.println("All Clear!!");
	}
}