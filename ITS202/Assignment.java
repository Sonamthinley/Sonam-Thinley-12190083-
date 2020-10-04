public class Assignment { 
  
    // create Array array[] 
    // count to see no of elements added 
    // size will with size of array[] 
    int array[]; 
    int count; 
    int size; 
  
    public Assignment() // constructor initialize value to variable 

    { 
        array = new int[1]; 
        count = 0; 
        size = 1; 
    } 
    // function add an element at the end of array 
  
    public void add(int data) 
    { 
  
        // check no of element is equal to size of array 
        if (count == size) { 
            growSize(); // make array size double 
        } // insert element at end of array 
        array[count] = data; 
        count++; 
    } 
  
    // function makes size double of array 
    public void growSize() 
    { 
  
        int temp[] = null; 
        if (count == size) { 
  
            // temp is a double size array of array 
            temp = new int[size * 2]; 
            { 
                for (int i = 0; i < size; i++) { 
                    // copy all array value into temp 
                    temp[i] = array[i]; 
                } 
            } 
        } 
  
        // double size array temp initialize 
        // into variable array again 
        array = temp; 
         
        // size is double of array 
        size = size * 2; 
    } 

    // function to add element at given index 
  
    public void addAt(int index, int data) 
    { 
        // if size is not enough make size double 
        if (count == size) { 
            growSize(); 
        } 
  
        for (int i = count - 1; i >= index; i--) { 
  
            // shift all element right  
            // from given index 
            array[i + 1] = array[i]; 
        } 
  
        // insert data at given index 
        array[index] = data; 
        count++; 
    } 
  
    // function remove last element 
    public void remove() 
    { 
        if (count > 0) { 
            array[count - 1] = 0;  //put zero at last index
            count--; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        Assignment obj = new Assignment(); 
        obj.add(1); 
        obj.add(2); 
        obj.add(3); 
        obj.add(4); 
        obj.add(5); 
  
        System.out.println("Elements of array:"); 
        for (int i = 0; i < obj.size; i++) { 
            System.out.print(obj.array[i] + " "); 
        } 
  
        System.out.println(); 
  
        // print size of array and no of element 
        System.out.println("Size of array: " + obj.size); 
        System.out.println("No of elements in array: " + 
                                              obj.count); 

        System.out.println(); 

        // delete last element 
        obj.remove(); 
  
        // print Elements of array after delete last element 
        System.out.println("Elements of array after last element is poped:"); 
        for (int i = 0; i < obj.size; i++) { 
            System.out.print(obj.array[i] + " "); 
        } 
  
        System.out.println(); 
    
        // print size of array and no of element 
        System.out.println("Size of array: " + obj.size); 
        System.out.println("No of elements in array: " + 
                                               obj.count);

        System.out.println();

  
        // add an element at index 4
        obj.addAt(4, 9); 
  
        // print Elements of array after adding element
        System.out.println("Elements of array after" +  
                      " add an element at index 5:"); 
        for (int i = 0; i < obj.size; i++) { 
            System.out.print(obj.array[i] + " "); 
        } 
  
        System.out.println(); 
  
        System.out.println("Size of array: " + obj.size); 
        System.out.println("No of elements in array: " +  
                                               obj.count); 
         
    } 
} 
