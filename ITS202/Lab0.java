/*public class Lab0{
	public static void main(String[] args){
		int Num[];
		Num = new int[3];
		Num[0] = 1;
		Num[1] = 2;   //initialization of array
		Num[2] = 3;
		for(int i=0; i<Num.length; i++){
			System.out.println(Num[i]);
		}

	}
}
*/

public class Lab0{
	static int[] Num;
	public static int[] resize(int length){
		int[]temp = new int[length];
		for(int i=0; i<Num.length; i++){
			temp[i]=Num[i];
		}
		temp[length-1]=4;
		Num=temp;
		return Num;
	}

	public static void main(String[] args){
		Num=new int[3];
		int[] newNum = resize(4);
		Num[0] = 1;
		Num[1] = 2;
		Num[2] = 3;
		for(int i = 0; i<newNum.length; i++){
			System.out.println(newNum[i]);
		}
	}
}
