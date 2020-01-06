public class ThreeWay {
	private static int charAt(String s, int d) {
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
	
	private static void exch(String[] a, int i, int j) {
		String tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void sort(String[] a) {
		sort(a, 0, a.length - 1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		if(hi <= lo) return;
		int lt = lo, gt = hi, v = charAt(a[lo], d), i = lo + 1;
		
		while(i <= gt) {
			int t = charAt(a[i], d);
			
			if(t < v) exch(a, i++, lo++);
			else if(t > v) exch(a, i, gt--);
			else i++;
		}
		
		sort(a, lo, lt - 1, d);
		if(v >= 0) sort(a, lt, gt, d + 1);
		sort(a, gt + 1, hi, d);
	}
	
	public static void main(String[] args) {
		String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "she", "sells", "are", "surely", "seashells"};
		sort(a);
		for(int i = 0; i < a.length; i++) System.out.println(a[i]);
	}
}