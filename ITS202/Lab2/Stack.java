public class Stack{
	int max_size = 10;
	int top;
	int size;
	int [] Array = new int[max_size];

	public void push(int e){
		if(size==0){
			Array[0]=e;
			top=0;
		}
		else{
			Array[top+1]=e;
			top= top + 1;
		}
		size= size + 1;
	}

	public int pop(){
		if(size==0){
			System.out.println("The stack is empty");
		}
		else{
			top= top-1;
			size= size-1;
		}
		return Array[top+1];
	}
	public int size(){
		return size;
	}
	public int top(){
		if(top==-1){
			return 0;
		}
		return Array[top];
	}
	public boolean isEmpty(){
		if(size==0){
			return true;
		}
		return false;
	}
}