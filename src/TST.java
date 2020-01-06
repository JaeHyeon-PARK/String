public class TST<Value> {
	private Node root;
	int N;
	
	private class Node {
		char c;
		Value val;
		Node left, mid, right;
	}
	
	public Value get(String key) {
		Node x = get(root, key, 0);
		if(x == null) return null;
		else return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if(x == null) return null;
		char c = key.charAt(d);
		if(c < x.c) return get(x.left, key, d);
		else if(c > x.c) return get(x.right, key, d);
		else if(d < key.length() - 1) return get(x.mid, key, d + 1);
		else return x;
	}
	
	public void put(String key, Value val) {
		if(!contains(key)) N++;
		root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d) {
		char c = key.charAt(d);
		if(x == null) {
			x = new Node();
			x.c = c;
		}
		if(c < x.c) x.left = put(x.left, key, val, d);
		else if(c > x.c) x.right = put(x.right, key, val, d);
		else if(d < key.length() - 1) x.mid = put(x.mid, key, val, d + 1);
		else x.val = val;
		return x;
	}
	
	private boolean contains(String key) { return get(key) != null; }
	
	public static void main(String[] args) {
		TST<Integer> tst = new TST<Integer>();
		
		tst.put("are", 12); tst.put("by", 4); tst.put("sea", 14); tst.put("sells", 15); tst.put("shells", 15);
		tst.put("she", 10); tst.put("shore", 7); tst.put("sur", 10); tst.put("surely", 13); tst.put("the", 8);
		
		System.out.println("are: " + tst.get("are")); System.out.println("by: " + tst.get("by"));
		System.out.println("sea: " + tst.get("sea")); System.out.println("sells: " + tst.get("sells"));
		System.out.println("shells: " + tst.get("shells")); System.out.println("she: " + tst.get("she"));
		System.out.println("shore: " + tst.get("shore")); System.out.println("sur: " + tst.get("sur"));
		System.out.println("surely: " + tst.get("surely")); System.out.println("the: " + tst.get("the"));
	}
}
