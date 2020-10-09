import java.util.Scanner;
public class bubble{

	public static void bubble_Sort(int temp[])
	{
		int n=temp.length;
		int l=0;
		for(int k=0;k<n;k++)
		{
			for (int j=1;j<n-k;j++ ) 
			{
				if(temp[j-1]>temp[j]){
					l=temp[j-1];
					temp[j-1]=temp[j];
					temp[j]=l;

				}
			}

		}
	}
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);

        System.out.print ("Size of an array: ");
        int num = input.nextInt();
        int index[] = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print ("index" + i + ": ");
            index[i] = input.nextInt();
        }
        System.out.print ("The unsorted array: ");
        for (int temp : index){
            System.out.print(temp + "\t");
        }    

        System.out.print("\n"+"The sorted array: ");
        bubble_Sort(index);
        for (int temp : index){
            System.out.print(temp + "\t");
        }
		

	}
}