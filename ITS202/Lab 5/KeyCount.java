public class KeyCount{
	public static void main(String[] args){
		int[] a = {3, 4, 1, 9, 0, 5, 7, 6, 2, 8};
		int N = a.length;
		int R = 10;
		int[] aux = new int[a.length];
		int[] count = new int [R+1];

		for(int i = 0; i < N; i++)
			count[ a[i] + 1 ] ++;

		for(int r = 0; r < R; r++)
			count [r+1] += count[r];

		for(int i = 0; i < N; i++)
			aux[count [a[i]]++] = a[i];

		for (int i = 0; i < N; i++)
			a[i] = aux[i];

		for(int i = 0; i < N; i++)
			System.out.print(" "+a[i]);

		System.out.print(" \n");

	}
}