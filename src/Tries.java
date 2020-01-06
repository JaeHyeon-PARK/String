public class Tries<Value> {
	private static int R = 256;
	private Node root;
	private int N;
	
	private class Node<Value> {
		private Object val;
		private Node[] next = new Node[R];
	}
	
	public Value get(String key) {
		Node x = get(root, key, 0);
		if(x == null) return null;
		else return (Value) x.val;
	}
	
	private Node get(Node x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}
	
	public void put(String key, Value val) {
		if(val == null) delete(key);
		else root = put(root, key, val, 0);
	}
	
	private Node put(Node x, String key, Value val, int d) {
		if(x == null) x = new Node();
		if(d == key.length()) {
			if(x.val == null) N++;
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
	
	public void delete(String key) { root = delete(root, key, 0); }
	
	private Node delete(Node x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) {
			if(x.val != null) N--;
			x.val = null;
		}
		else {
			char c = key.charAt(d);
			x.next[c] = delete(x.next[c], key, d + 1);
		}
		if(x.val != null) return x;
		for(char c = 0; c < R; c++) {
			if(x.next[c] != null) return x;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Tries<Integer> tries = new Tries<Integer>();
		
		tries.put("are", 12); tries.put("by", 4); tries.put("sea", 14); tries.put("sells", 15); tries.put("shells", 15);
		tries.put("she", 10); tries.put("shore", 7); tries.put("sur", 10); tries.put("surely", 13); tries.put("the", 8);
		
		tries.delete("shells"); tries.delete("sur");
		
		System.out.println("are: " + tries.get("are")); System.out.println("by: " + tries.get("by"));
		System.out.println("sea: " + tries.get("sea")); System.out.println("sells: " + tries.get("sells"));
		System.out.println("shells: " + tries.get("shells")); System.out.println("she: " + tries.get("she"));
		System.out.println("shore: " + tries.get("shore")); System.out.println("sur: " + tries.get("sur"));
		System.out.println("surely: " + tries.get("surely")); System.out.println("the: " + tries.get("the"));
	}
}
