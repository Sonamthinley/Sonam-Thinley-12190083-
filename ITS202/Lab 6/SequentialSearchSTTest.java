public class SequentialSearchSTTest{
	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();

		st.put("A", 1);
        st.put("B", 2);
        st.put("C", 1);
        st.put("D",5);
        st.delete("D");

        assert(st.isEmpty() == false);



       st.put("a",8);
       st.delete("a");
       System.out.println(st.keys());

        
       System.out.println(st.isEmpty());
       System.out.println(st.size());
       System.out.println("All test passed");
	}
}