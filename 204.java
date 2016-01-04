public class Solution {
    public int countPrimes(int n) {
        
   if (n <= 2)
			return 0;
		boolean[] notPrime = new boolean[n];
		int res = 0;
		int bound = (int) Math.sqrt(n);
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				res++;
				if (i <= bound)
					for (int j = i * i; j < n; j += i)
						notPrime[j] = true;
			}
		}
		return res;
}
}