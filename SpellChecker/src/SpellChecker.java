import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;
public class SpellChecker {
	String input;
	DictionaryTree tree;
	ArrayList<String> blocks;
	final static String[] vowels = {"a", "e", "i", "o", "u"};
	static ArrayList<String> vowelPermute = new ArrayList<String>();
	public SpellChecker(String in) throws IOException{
		input = in.toLowerCase();
		char last = ' ';
		blocks = new ArrayList<String>();
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)!=last){
				last = in.charAt(i);
				blocks.add(""+last);
			}
			else{
				String lastString = blocks.remove(blocks.size()-1);
				blocks.add(lastString+last);
			}
		}
		tree = new DictionaryTree();
	}
	public String correct(){
		Stack<WordPair> dfs = new Stack<WordPair>();
		ArrayList<String> next = permute(blocks.get(0));
		for(int i=next.size()-1;i>=0;i--){
			dfs.push(new WordPair(next.get(i), 0));
		}
		while(!dfs.empty()){
			WordPair current = dfs.pop();
			if(tree.inTree(current.word)){
				if(current.depth==blocks.size()-1){
					if(tree.wordInTree(current.word)) return current.word;
				}
				else{
					next = permute(blocks.get(current.depth+1));
					for(int i=next.size()-1;i>=0;i--){
						dfs.push(new WordPair(current.word+next.get(i), current.depth+1));
					}
				}
			}
		}
		return "NO SUGGESTION";
	}
	public static ArrayList<String> permute(String in){
		ArrayList<String> list = new ArrayList<String>();
		if(isVowel(in.charAt(0))){
			for(int i=1;i<=in.length();i++){
				vowelPermute.clear();
				permuteVowel(i, "");
				list.addAll(vowelPermute);
			}
		}
		else{
			String curr = "";
			for(int i=0;i<in.length();i++){
				curr+=in.charAt(i);
				list.add(curr);
			}
		}
		return list;
	}
	public static void permuteVowel(int num, String curr){
		if(num==0){vowelPermute.add(curr); return;}
		else{
			for(int i=0;i<vowels.length;i++){
				permuteVowel(num-1, curr+vowels[i]);
			}
		}
	}
	public static boolean isVowel(char in){
		return (in=='a'||in=='e'||in=='i'||in=='o'||in=='u');
	}
	public void setInput(String in){
		input = in;
		char last = ' ';
		blocks = new ArrayList<String>();
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)!=last){
				last = in.charAt(i);
				blocks.add(""+last);
			}
			else{
				String lastString = blocks.remove(blocks.size()-1);
				blocks.add(lastString+last);
			}
		}
	}

}
class WordPair{
	String word;
	int depth;
	public WordPair(String inWord, int inDepth){
		word = inWord;
		depth = inDepth;
	}
}
