public class LSD {
	public static void sort(String[] a, int W) {
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];
		
		for(int d = W - 1; d >= 0; d--) {
			int[] count = new int[R];
			
			for(int i = 0; i < N; i++) count[a[i].charAt(d)]++;
			for(int i = 1; i < R; i++) count[i] += count[i - 1];
			for(int i = N - 1; i >= 0; i--) aux[--count[a[i].charAt(d)]] = a[i];
			for(int i = 0; i < N; i++) a[i] = aux[i];
		}
	}
	
	public static void main(String[] args) {
		String[] a = {"dab", "add", "cab", "fad", "fee", "bad", "dad", "bee", "fed", "bed", "ebb", "ace"};
		sort(a, 3);
		for(int i = 0; i < a.length; i++) System.out.println(a[i]);
	}
}