
public class MathHelper {

	public static int mChoosen(int m, int n) {
		if(n>m) {
			return 0;
		}
		int nChoosem;
		if(n>m-n) {
			nChoosem = (int)(factorial(n,m)/factorial(1,m-n));
		}else {
			nChoosem = (int)(factorial(m-n,m)/factorial(1,n));
		}
		return nChoosem;
	}
	
	public static long factorial(long start, long end) {
		long result = 1;
		for(long i=end;i>start;i--) {
			result*=i;
		}
		return result;
	}
}
