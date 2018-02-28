import java.util.ArrayList;
import java.util.Scanner;

public class CipherDecryptions {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Input cipherText");
		String cipherText = parseString(input.nextLine());
		System.out.println(cipherText.length());
		System.out.println(cipherText);
		
		ArrayList<ArrayList<String>> repeatPatterns = repeatPatterns(cipherText);
		System.out.println("repeat patterns:");
		printStructure(repeatPatterns);
		
		ArrayList<ArrayList<String>> difference = patternsIndexDifference(repeatPatterns);
		System.out.println("difference:");
		printStructure(difference);
		
		//int keyLength = guessLenght(difference);
		int keyLength = 2;
		
		String[] textGroups = parseTextGroupsByKeyIndex(cipherText,keyLength);
		for(String text:textGroups) {
			System.out.println(text);
		}
		
		int[][] frequency = frequencyAnalysis(textGroups);
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
		
		//String key = findKeyVigenere();
		String key = "wi";
		String plainText = decryptBlockCipher(cipherText,key);
		System.out.println(plainText);
	}
	//decryption of Vigenere Cipher
	
	public static String parseString(String text) {
		String result=text.trim().toLowerCase();
		String[] noSpace=result.split(" ");
		result="";
		for(String part:noSpace) {
			result+=part;
		}
		return result;
	}
	
	public static ArrayList<ArrayList<String>> repeatPatterns(String cipherText) {
		ArrayList<ArrayList<String>> result = new ArrayList();
		for(int i =0;i<cipherText.length();i++) {
			for(int j=i+1;j<cipherText.length();j++) {
				String key = cipherText.substring(i, j+1);
				boolean isKey = true;
				for(int l =0; l<result.size();l++) {
					ArrayList<String> ele = result.get(l);
					if(ele.get(0).equals(key)) {
						isKey=false;
					}
				}
				if(isKey) {
					if(cipherText.contains(key)) {
						for(int k =j+1;k+j-i<cipherText.length();k++) {
							if(cipherText.substring(k,k+j-i+1).equalsIgnoreCase(key)) {
								boolean added = false;
								for(int l =0; l<result.size();l++) {
									ArrayList<String> ele = result.get(l);
									if(ele.get(0).equals(key)) {
										ele.set(1, (Integer.parseInt(ele.get(1))+1)+"");
										added = true;
										ele.add((1+k)+"");
									}
								}
								if(!added) {
									ArrayList<String> keyArray =new ArrayList<String>();
									keyArray.add(key);
									keyArray.add(2+"");
									keyArray.add((1+i)+"");
									keyArray.add((1+k)+"");
									result.add(keyArray);
								}
							}
						}
					}					
				}
			}
		}
		return result;
	}
	
	public static ArrayList<ArrayList<String>> patternsIndexDifference(ArrayList<ArrayList<String>> patterns){
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		for(int i=0;i<patterns.size();i++) {
			ArrayList<String> ele = patterns.get(i);
			String name = ele.get(0);
			boolean added = false;
			int index = -1;
			for(int l =0; l<result.size();l++) {
				ArrayList<String> eleAdded = result.get(l);
				if(eleAdded.get(0).equals(name)) {
					index = l;
					added = true;
				}
			}
			if(!added) {
				ArrayList<String> resultEle=new ArrayList<>();
				resultEle.add(name);
				index = result.size();
				result.add(resultEle);
			}
			int num = Integer.parseInt(patterns.get(i).get(1));
			for(int a = 0; a<num;a++) {
				for(int b=a+1;b<num;b++) {
					int num1=Integer.parseInt(ele.get(a+2));
					int num2=Integer.parseInt(ele.get(b+2));
					int difference = Math.abs(num1-num2);
					result.get(index).add(difference+"");
				}
			}
		}
		return result;		
	}

	public static String[] parseTextGroupsByKeyIndex(String text, int keyLength) {
		String[] result = new String[keyLength];
		for(int i=0;i<result.length;i++) {
			result[i]="";
		}
		for(int i=0;i<text.length();i++) {
			int switchKey = i%keyLength;
			result[switchKey]+=text.charAt(i);
		}
		return result;
	}

	public static void printStructure(ArrayList<ArrayList<String>> structure) {
		for(ArrayList<String> ele: structure) {
			String output = "";
			for(String data: ele) {
				output+=data+"  ";
			}
			System.out.println(output);
		}
	}

	public static int[][] frequencyAnalysis(String[] textGroups){
		int[][] result = new int[textGroups.length][26];
		for(int i =0;i<result.length;i++) {
			for(int j=0;j<textGroups[i].length();j++) {
				char at = textGroups[i].charAt(j);
				int index = (at - 'a');
				result[i][index]++;
			}
		}
		return result;
	}

	public static String decryptBlockCipher(String cipherText, String key) {
		key=key.toLowerCase();
		String result = "";
		int textLength = cipherText.length();
		int keyLength = key.length();
		int multiples = textLength/keyLength;
		int remainder = textLength%keyLength;
		String keyText = "";
		for(int i=0;i<multiples;i++) {
			keyText+=key;
		}
		for(int i=0;i<remainder;i++) {
			keyText+=key.charAt(i);
		}
		for(int i=0;i<cipherText.length();i++) {
			String character = cipherText.charAt(i)+"";
			int charKey = keyText.charAt(i)-'a';
			System.out.println(charKey);
			System.out.println(character);
			result += decryptShiftCipher(character,charKey);
		}
		return result;
	}

	//decryption for shift cipher
 	public static int shiftKeyFinder(String plainText,String cipherText) {
		int num1 = plainText.charAt(0)-'a';
		int num2 = cipherText.charAt(0)-'a';
		int result = num2-num1;
		while (result<0) {
			result+=26;
		}
		return result;
	}

	public static String decryptShiftCipher(String cipherText,int key) {
		char[] letters = new char[cipherText.length()];
		for(int i = 0; i<cipherText.length();i++) {
			int letter = (cipherText.charAt(i) - 'a' - key)%26;
			while (letter<0) {
				letter+=26;
			}
			letters[i]=(char)(letter+'a');
		}
		String result ="";
		for(char x:letters) {
			result+=x;
		}
		return result;
	}
}
