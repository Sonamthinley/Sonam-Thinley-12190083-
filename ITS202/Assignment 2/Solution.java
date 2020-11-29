import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int size;          // number of nodes in subtree

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        else{
            return false;
        }
        
       
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
       return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        
       if(x == null){
            return 0;
        }
        else{
            return x.size;
        }
       
    }

    /**
     * Does this symbol table contain the given key?
     *
     * @param  key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *         {@code false} otherwise
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    // public boolean contains(Key key) {
       
    // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
        Node curNode = root;
        while(curNode.key != key){
            int temp = key.compareTo(curNode.key);
            if(temp < 0){
                curNode = curNode.left;
            }
            else if(temp > 0){
                curNode = curNode.right;
            }
        }
        if (curNode.key == key){
            return curNode.val;
        }
        return null;
    }

    /*private Value get(Node x, Key key) {
       
        
        
    }*/

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key Cannot be Null");
        if (root == null) 
        {
            root = new Node(key, val, 1);
            return;
        }
        if(value(root, key, val)) 
            return;

        Node node = null, x = root, z = new Node(key, val, 1);
        while (x != null) {
            node = x;

            int temp = key.compareTo(node.key);
            if(temp < 0){
                node.size++;
                x=x.left;

            }
            if (temp > 0){
                node.size++;
                x=x.right;
            }
        }
        int temp = key.compareTo(node.key);
        if (temp < 0){
            node.left  = z;
        } 
        else{
            node.right = z;
        }         
        node.size = 1+size(node.left)+size(node.right);
       
    }

    private boolean value(Node x, Key key, Value val){
        while(x!=null){
            int temp = key.compareTo(x.key);
            if(temp<0){
                x=x.left;
            } 
            else if(temp>0){
                x=x.right;
            }
            else{
                x.val = val;
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */
    public Key min() {
       if(isEmpty()) throw new NoSuchElementException("Empty symbol table");
       return min(root).key;
    } 

    private Node min(Node x) { 
        if(x.left == null){
            return x; 
        }
        for(x=x;x!=null;x=x.left){
            if(x.left == null){
                return x;
            }
        }
        return x;
    } 

   

    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key floor(Key key) {
        if (key == null) throw new IllegalArgumentException("Key is Null");
        if (isEmpty()) throw new NoSuchElementException("Empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 

    private Node floor(Node x, Key key) {
        Node z=null, floor = min(x);

        while(x != null){
            int com = key.compareTo(x.key);

            /*no need to put extra condiction here as the given key should be greater 
            or equal to floor key but it is small so just set x to x.left*/
            if(com < 0) x = x.left;

            /*at right node the keys are small than the given key but we need to store the key
            which is greater than other keys in tree and less than given key*/
            else if (com > 0){
                int temp = floor.key.compareTo(x.key);

                if(temp<=0){
                    floor = x;
                    z = floor;
                }
                x = x.right; 
            }
            else return x;
        }
        return z;
       
    } 

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */
    public Key select(int k) {
        if(k<0 || k>=size()) throw new NoSuchElementException("rank out of limit");

        Node temp = select(root, k);
        if(temp!=null){
            return temp.key; 
        }
        else{
            return null;
        }  
    }
 
    private Node select(Node x, int k) {
        
         while(x!=null){
            int t = size(x.left);
            if(t>k){
                x = x.left;
            }           
            else if(t<k){
                x = x.right;
                k = k-t-1;
            }
            else return x;
        }
        return null;

    } 

    

    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the symbol table between {@code lo} 
     *         (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *         is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if(lo==null || hi==null) throw new IllegalArgumentException("argument to keys() is null");

        Queue<Key> queue = new LinkedList<Key>();
        keys(root, queue, lo, hi);  
        return queue;
    } 

    private void keys(Node x,Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return;  
        
        Node temp1 = x;  
        while (temp1 != null){  
      
            int cmp = temp1.key.compareTo(hi);
            int cam = temp1.key.compareTo(lo);
            if (temp1.left == null){   
                if (cmp <= 0 && cam >= 0)  queue.offer(temp1.key);
                temp1 = temp1.right;

            }else{  
                Node temp2 = temp1.left;
            
                while (temp2.right != null && temp2.right != temp1)  
                    temp2 = temp2.right;  
        
                if (temp2.right == null){  
                    temp2.right = temp1;  
                    temp1 = temp1.left; 

                }else{  
                    temp2.right = null;    
                    if (cmp <= 0 && cam >= 0)  queue.offer(temp1.key);  
                    temp1 = temp1.right;  
                }  
            }  
        }   
    } 
  
    public static void main(String[] args) { 
        
        Solution<String, Integer> obj = new Solution<String, Integer>();
        
        obj.put("ABDUL",1);
        System.out.println(obj.get("ABDUL"));

        obj.put("HRITHIK",2);
        obj.put("SAI",3);
        obj.put("SAMAL",6);
        System.out.println(obj.get("SAI"));

        obj.put("TASHI",4);
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("HRITHIK"));
        System.out.println(obj.floor("HAHA"));
        System.out.println(obj.select(2));

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

        obj.put("CHIMI",5);
        obj.put("SAMAL",4);
        System.out.println(obj.get("SAMAL"));
        obj.put("NIMA",7);
        System.out.println(obj.size());
        System.out.println(obj.get("CHIMI"));
        System.out.println(obj.floor("CHIMI"));
        obj.put("SONAM",8);

        for (String s : obj.keys("ABDUL","TASHI"))
            System.out.print(s+" ");
        System.out.println();

    }
}
