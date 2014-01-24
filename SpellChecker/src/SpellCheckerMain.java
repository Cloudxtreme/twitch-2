import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SpellCheckerMain {
	public static void main(String[] args) throws IOException{
		SpellChecker checker = new SpellChecker("");
		InputReader in = new InputReader(System.in);
		System.out.print(">");
		String next=in.next();
		while(next!=null){
			checker.setInput(next.toLowerCase());
			System.out.println(checker.correct());
			System.out.print(">");
			next = in.next();
		}
	}
}

class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

}