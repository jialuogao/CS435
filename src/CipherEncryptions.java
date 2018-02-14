import java.util.Scanner;

public class CipherEncryptions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Input plaintext");
		String plaintext = input.nextLine().toLowerCase();
		System.out.println("Input key");
		int key = input.nextInt();
		System.out.println("Result");
		String ciphertext = shiftCipher(plaintext,key);
		System.out.println(ciphertext);
		
		//printAllShiftCiphers(plaintext);
	}

	
	private static String shiftCipher(String plaintext,int key) {
		char[] letters = new char[plaintext.length()];
		for(int i = 0; i<plaintext.length();i++) {
			letters[i]=(char)((plaintext.charAt(i) - 'a' + key)%26+'a');
		}
		String result ="";
		for(char x:letters) {
			result+=x;
		}
		return result;
	}
	private static void printAllShiftCiphers(String plaintext) {
		System.out.println("All shifts");
		for(int i=0;i<26;i++) {
			System.out.println(shiftCipher(plaintext,i));
		}
	}
}
