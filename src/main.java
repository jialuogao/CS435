import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		//encrypt
//		System.out.println("Input plaintext");
//		String plaintext = input.nextLine().toLowerCase();
//		System.out.println("Input key");
//		int key = input.nextInt();
//		System.out.println("Result");
//		String ciphertext = CipherEncryptions.shiftCipher(plaintext,key);
//		System.out.println(ciphertext);
//		CipherEncryptions.printAllShiftCiphers(plaintext);
		
		//decrypt
//		System.out.println("Input ciphertext");
//		String ciphertext = input.nextLine().toLowerCase();
//		System.out.println("Input key");
//		int key = input.nextInt();
//		System.out.println("Result");
//		String plaintext=CipherDecryptions.decryptShiftCipher(ciphertext,key);
//		System.out.println(plaintext);
		
		
		//find key
//		System.out.println("Input plaintext");
//		String plaintext = input.nextLine().toLowerCase();
//		System.out.println("Input cipher text");
//		String ciphertext = input.nextLine().toLowerCase();
//		int key = CipherDecryptions.shiftKeyFinder(plaintext, ciphertext);
//		System.out.println("The key is: "+key);
		
		//ioc
//		double ioc = CipherDecryptions.indexOfCoincidence();
		
		//Friedman Refinement
//		int blockLength = CipherDecryptions.friedmanRefinement();
		
		//Frequency Analysis
		String[] text = {"grxdrqysqoddyerdrdyerqoqys"};
		String[] text2 = {"cclqecerl"};
		int[][]frequency = CipherDecryptions.frequencyAnalysis(text2);
		for(int[] group:frequency) {
			String line ="";
			for(int i=0;i<group.length;i++) {
				int data=group[i];
				if(data!=0) {
					char at=(char) ((char)i+'a');
					line+=at+": "+data+"  ";					
				}
			}
			System.out.println(line);
		}
		
//		for(int i=0;i<26;i++) {
//			char c1=(char)(i+'a');
//			char c2=(char)((i+20)%26+'a');
//			char cl=(char)((i+8)%26+'a');
//			System.out.println(c1+""+c2+"   "+cl);
//		}
	}
}
