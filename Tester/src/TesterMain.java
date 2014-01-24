import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.*;

public class TesterMain {
	final static char[] vowel = {'a','e','i','o','u'};
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("web2"));
		String line=in.readLine();
		while(line!=null){
			System.out.println(modify(line));
			line = in.readLine();
		}
	}
	public static String modify(String in){
		in = in.toLowerCase();
		String returnString = "";
		for(int i=0;i<in.length();i++){
			char current = in.charAt(i);
			//Repeat Random Amount
			if(current=='a'||current=='e'||current=='i'||current=='o'||current=='u'){
				if(Math.random()>0.5) returnString+=vowel[(int)Math.random()*5];
				else returnString+=Character.toUpperCase(vowel[(int)Math.random()*5]);
			}
			else {
				for(int j=0;j<(int)Math.random()*5+1;j++){
				if(Math.random()>0.5) returnString+=current;
				else returnString+=Character.toUpperCase(current);
				}
			}
		}
		return returnString;
	}
}
