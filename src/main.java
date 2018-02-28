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
		System.out.println("Input ciphertext");
		String ciphertext = input.nextLine().toLowerCase();
		System.out.println("Input key");
		int key = input.nextInt();
		System.out.println("Result");
		String plaintext=CipherDecryptions.decryptShiftCipher(ciphertext,key);
		System.out.println(plaintext);
		
		
		//find key
//		System.out.println("Input plaintext");
//		String plaintext = input.nextLine().toLowerCase();
//		System.out.println("Input cipher text");
//		String ciphertext = input.nextLine().toLowerCase();
//		int key = CipherDecryptions.shiftKeyFinder(plaintext, ciphertext);
//		System.out.println("The key is: "+key);
	}

}
