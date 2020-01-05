public class MSD {
	static String[] aux;
	static int R = 256;
	
	private static int charAt(String s, int d) {
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}
	
	public static void sort(String[] a) {
		aux = new String[a.length];
		sort(a, 0, a.length - 1, 0);
	}
	
	private static void sort(String[] a, int lo, int hi, int d) {
		if(hi <= lo) return;
		int[] count = new int[R + 2];
		
		for(int i = lo; i <= hi; i++) count[charAt(a[i], d) + 2]++;
		for(int i = 1; i < R + 2; i++) count[i] += count[i - 1];
		for(int i = lo; i <= hi; i++) aux[count[charAt(a[i], d) + 1]++] = a[i];
		for(int i = lo; i <= hi; i++) a[i] = aux[i - lo];
		for(int i = 0; i < R; i++) sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
	}
		
	public static void main(String[] args) {
		String[] a = {"she", "sells", "seashells", "by", "the", "sea", "shore", "the", "she", "sells", "are", "surely", "seashells"};
		sort(a);
		for(int i = 0; i < a.length; i++) System.out.println(a[i]);
	}
}