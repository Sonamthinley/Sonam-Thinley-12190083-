public class BinarySearch{
	public static void Binary(int arr[], int f, int l, int k){
		int m = (f+1)/2;
		while (f <= 1){
			if( arr[m] < k){
				f = m+1;
			}
			else if(arr[m] == k){
				System.out.println("Element is found at index: " + m);
				break;
			}
			else{
				l = m-1;
			}
			m = (f+1)/2;
		}
		if ( f > 1){
			System.out.println("Element is not found");
		}
	}
	public static void main(String[] args){
		int arr[] = {10, 40, 60, 30, 20};
		int k = 30;
		int l = arr.length - 1;
		Binary(arr, l, k, 0);

	}
}