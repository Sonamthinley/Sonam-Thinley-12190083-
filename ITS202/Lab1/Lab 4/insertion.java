import java.util.Scanner;

public class insertion {

    public static void insertion_1(int arr[]) //arr method to store elements
    {
        int n=arr.length;
        for (int k=1; k<n; k++) //iteration over each element
        {
            int l=arr[k]; //stores the element of array
            int i=k-1;

            while( (i > -1) && arr [i] > l) //value at index i greater than value at index l
            {
                arr[i+1]= arr[i];
                i--;
            }
            arr[i+1]=l;
        }

    }
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print ("Size of an array: ");
        int num = input.nextInt();
        int index[] = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print ("index" + i + ": ");
            index[i] = input.nextInt();
        }
        System.out.print ("The unsorted array array: ");
        for (int temp : index){
            System.out.print(temp + "\t");
        }    

        System.out.print("\n"+"The sorted array array: ");
        insertion_1(index);
        for (int temp:index){
            System.out.print(temp + "\t");
        }
    }
}