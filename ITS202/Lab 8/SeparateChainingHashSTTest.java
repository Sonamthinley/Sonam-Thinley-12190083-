 public class SeparateChainingHashSTTest{
     public static void main(String[] args) { 
            SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
            st.put("Sonam", 3);
            st.put("Tashi", 4);
            st.put("Sonam", 6);
            st.put("karma", 9);
            st.put("Dorji", 8);

            assert(st.isEmpty() == false);
            assert(st.size() == 4);
            assert(st.contains("Dorji") == true);
            assert(st.hash("Sonam") == 2);
            assert(st.get("Sonam") == 6);
            System.out.println("All test cases passed");


           /* System.out.println(st.isEmpty());
            System.out.println(st.size());
            System.out.println(st.contains("Dorji")); 
            System.out.println(st.hash("Sonam"));       
            System.out.println(st.get("Sonam"));*/
    }
}
   