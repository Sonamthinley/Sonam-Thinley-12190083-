import java.util.*;
public class BinarySearch<Key extends Comparable<Key>, Value> {
    private Node root;             

    private class Node {
        private Key key;           
        private Value val;         
        private Node left, right;  
        private int size;          

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }
    //create empty symbol table
    public BinarySearch(){
    	root = null;
    }

    public int size() {
       return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        
       if(x == null){
            return 0;
        }
        else{
            return x.size; //x is root
        }
       
    }

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("Key Cannot be Null");
        if (root == null) 
        {
            root = new Node(key, val, 0);
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

    public Value get(Key key){
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
    	if(curNode.key == key){
    		return curNode.val;
    	}
    	else
    		return null;
    }

    public Key min(){
    	if(size() == 0) throw new NoSuchElementException ("Empty symbol table");
    	return min(root).key;

    }

    private Node min(Node x){
    	if(x.left == null){
    		return x;
    	}
    	for(x=x; x!=null; x=x.left){
    		if(x.left == null){
    			return x;
    		}
    	}
    	return x;
    }

    public Key floor (Key key){
    	if(key == null) throw new IllegalArgumentException("key is null");
    	if(size()==0) throw new NoSuchElementException("Empty Symbol table");
    	Node x = floor(root, key);
    	if(x == null) return null;
    	else return x.key;
    }

     private Node floor(Node x, Key key) {
        Node z=null, floor = min(x);

        while(x != null){
            int com = key.compareTo(x.key);
            if(com < 0) x = x.left;
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

    public Key select(int k){
    	if(k<0 || k>=size()) throw new NoSuchElementException("Rank is out of limit");
    	Node temp = select(root, k);
    	if(temp!=null){
    		return temp.key;
    	}
    	else{
    		return null;
    	}
    }

    private Node select(Node x, int k){
    	while (x!=null){
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

    public Iterable<Key> keys(Key lo, Key hi){
    	if(lo == null || hi==null) throw new IllegalArgumentException("argument to keys() is null");
    	Queue<Key> queue = new LinkedList<Key>();
    	keys(root, queue, lo, hi);
    	return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi){
    	if(x == null) return;

    	Node temp1 = x;
    	while (temp1 != null){
    		int cmp = temp1.key.compareTo(hi);
    		int cam = temp1.key.compareTo(lo);
    		if(temp1.left == null){
    			if(cmp <= 0 && cam >=0) queue.offer(temp1.key);
    			temp1 = temp1.right;
    		}
    		else{
    			Node temp2 = temp1.left;
    			while (temp2.right != null && temp2.right != temp1)
    				temp2 = temp2.right;

    			if(temp2.right == null){
    				temp2.right = temp1;
    				temp1 = temp1.left;
    			}
    			else{
    				temp2.right = null;
    				if(cmp <=0 && cam >=0) queue.offer(temp1.key);
    				temp1 = temp1.right;
    			}
    		}
    	}
    }

    public void delete(Key key){
    	root = delete(root, key);
    }               

    private Node delete(Node x, Key key){
    	if(x == null) return null;
    	int cmp = key.compareTo(x.key);
    	if (cmp<0) x.left = delete(x.left, key);
    	else if(cmp>0) x.right = delete(x.right, key);
    	else{
    		if(x.right == null) return x.left;
    		if(x.left == null) return x.right;
    		Node t = x;
    		x = min(t.right);
    		x.right = deleteMin(t.right);
    		x.left = t.left;
    	}
    	x.size = size(x.left) + size(x.right) + 1;
    	return x;
    }

    public void deleteMin(){
    	root = deleteMin(root);
    }

    private Node deleteMin(Node x){
    	if(x.left == null) return x.right;
    	x.left = deleteMin(x.left);
    	x.size=size(x.left) + size(x.right) + 1;
    	return x;
    }
     
public static void main(String[] args) 
{ 
        
        BinarySearch<String, Integer> obj = new BinarySearch<String, Integer>();
        obj.put("Ada", 1);
        obj.put("Ballerina", 3);
        System.out.println(obj.get("Ada"));
        obj.put("HTML", 5);
        obj.put("Java", 7);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
        System.out.println(obj.min());
        System.out.println(obj.floor("Ada"));
        System.out.println(obj.select(1));
        System.out.println(obj.keys("Ada", "Java"));
        obj.put("Java", 8);
        obj.put("Dart", 9);
        System.out.println(obj.get("Java"));
        System.out.println(obj.size());
     
        System.out.println(obj.keys("Ballerina", "Java"));
      




    }
}
