import java.util.Scanner;
public class selection{
    public static void select(int selection[]){
        int n = selection.length;
        int l = n-1;
        for(int i = 0; i < l;  i++){
            int small_index = i;
            for(int h = i+1; h < n; h++){
                if(selection[small_index] > selection[h])
                    small_index = h;
            }
            int x=selection[small_index];
            selection[small_index]=selection[i];
            selection[i]=x;
        }
    }
    public static void main(String[] args){
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
        select(index);
        for (int temp:index){
            System.out.print(temp + "\t");
        }
    }
}