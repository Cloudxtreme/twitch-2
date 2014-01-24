import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DictionaryTree {
	char data;
	boolean word;
	DictionaryTree[] children;
	//Create Dictionary Tree from Root
	public DictionaryTree() throws IOException{
		data = ' ';
		children = new DictionaryTree[26];
		BufferedReader in = new BufferedReader(new FileReader("./web2"));
		String line=in.readLine();
		while(line!=null){
			this.addWord(line);
			line = in.readLine();
		}
		word = false;
	}
	public DictionaryTree(char in, boolean done){
		data = in;
		children = new DictionaryTree[26];
		word = done;
	}
	//Checks if prefix exists in tree
	public boolean inTree(String in){
		DictionaryTree curr=this;
		for(int i=0;i<in.length();i++){
			if(curr.children[index(in.charAt(i))]==null) return false;
			curr = curr.children[index(in.charAt(i))];
		}
		return true;
	}
	//Checks if the actual word is in tree
	public boolean wordInTree(String in){
		DictionaryTree curr=this;
		for(int i=0;i<in.length();i++){
			if(curr.children[index(in.charAt(i))]==null) return false;
			curr = curr.children[index(in.charAt(i))];
		}
		return curr.word;
		
	}
	private static int index(char in){
		return (int)in - 97;
	}
	public void addWord(String word){
		DictionaryTree curr = this;
		word = word.toLowerCase();
		//Iterate through all chars but last
		for(int i=0;i<word.length();i++){
			char currChar = word.charAt(i);
			int indexOf = index(currChar);
			boolean isLast = (i==word.length()-1);
			if(curr.children[indexOf] == null){
				curr.children[indexOf] = new DictionaryTree(currChar, isLast);
				curr = curr.children[indexOf];
			}
			else{
				curr = curr.children[indexOf];
			}
		}
	}

}
