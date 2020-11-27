public class SolutionTest{
	public static void main(String[] args){
		Solution<String, Integer> obj = new Solution<String, Integer>();
		obj.put("Abdul", 1);
        obj.put("Hrithik", 2);
        obj.put("Karma", 5);
        assert(obj.isEmpty() == false);
        assert(obj.size() == 3);
        assert(obj.get("Hrithik") == 2);
        assert(obj.contains("karma") == true);
		assert(obj.min() == "Abdul");
        assert(obj.floor("Abdul") == "Abdul");
        System.out.println("All test cases passed");
	}
}