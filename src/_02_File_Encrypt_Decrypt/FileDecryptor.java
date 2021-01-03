package _02_File_Encrypt_Decrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up,
	 * at the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	
	public static void main(String[] args) {
		String Encrmessage = "";

		try {
			FileReader fr = new FileReader("encrypted.txt");
			int c = fr.read();
			Encrmessage += (char) c;
			while(c != -1){
				//System.out.print(c);
				c = fr.read();
				Encrmessage += (char) c;
			}
			fr.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		String undoMessage = "";
		char key = 3;
		for (int i = 0; i < Encrmessage.length(); i++) {
			if((char) (Encrmessage.charAt(i) - key) < 'a') {
				undoMessage += ((char) (Encrmessage.charAt(i) - key + 26));
			 }
			else {
				undoMessage += (char) (Encrmessage.charAt(i) - key);
			}
		}
			
		JOptionPane.showMessageDialog(null, undoMessage);
		System.out.println(undoMessage);
		
		
	}
}
