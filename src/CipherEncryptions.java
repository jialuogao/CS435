public class CipherEncryptions {
	
	public static String shiftCipher(String plaintext,int key) {
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
	public static void printAllShiftCiphers(String plaintext) {
		System.out.println("All shifts");
		for(int i=0;i<26;i++) {
			System.out.println(shiftCipher(plaintext,i));
		}
	}
}
