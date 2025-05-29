import java.io.IOException;
import java.util.List;

public class ReverseWords extends JamProblem {
    public static void main(String[] args) throws IOException {
        ReverseWords p = new ReverseWords();
        p.go();
    }
    @Override
    String solveCase(JamCase jamCase) {
        StringBuilder builder = new StringBuilder();
        ReverseWordsCase c = (ReverseWordsCase) jamCase;
        int length = c.words.length;
        for (int i = 0; i < length; i++) {
            String word = c.words[length-i-1];
            builder.append(word + " ");
        }
        return builder.toString();
    }

    @Override
    JamCase parseCase(List<String> file, int line) {
        ReverseWordsCase c= new ReverseWordsCase();
        c.lineCount = 1;
        c.words = file.get(line).split(" ");
        return c;
    }
}

class ReverseWordsCase extends JamCase{
    String[] words;
}