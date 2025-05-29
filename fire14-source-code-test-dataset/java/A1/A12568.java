import java.io.IOException;
import java.util.*;

public class AlienLanguage extends JamProblem {
    private int wordsC;
    private int wordsL;
    List<String> words = new ArrayList<String>();
    TreeNode startNode;

    public static void main(String[] args) throws IOException {
        AlienLanguage p = new AlienLanguage();
        p.go();
    }

    @Override
    void parseFirstLine(List<String> file) {
        int[] firstLine = JamUtil.parseIntList(file.get(0), 3);
        caseCount = firstLine[2];
        wordsC = firstLine[1];
        wordsL = firstLine[0];
        startNode = new TreeNode(null);
        for (int i=0; i<wordsC; i++) {
            String word = file.get(i + 1);
            words.add(word);
            buildTree(word, startNode);
        }
        lastLine = wordsC + 1;
    }

    @Override
    String solveCase(JamCase jamCase) {
        ALCase cas = (ALCase) jamCase;
        Set<TreeNode> curr = new HashSet<>();
        curr.add(startNode);
        List<Set<Character>> pattern = cas.pattern;
        for (int i = 0; i < pattern.size(); i++) {
            Set<Character> characters = pattern.get(i);
            Set<TreeNode> next = new HashSet<>();
            for (Character ch : characters) {
                for (TreeNode node : curr) {
                    if (node.childred.containsKey(ch)) {
                        next.add(node.childred.get(ch));
                    }
                }
            }
            curr = next;
        }
        return "" + curr.size();
    }

    @Override
    JamCase parseCase(List<String> file, int lineI) {
        ALCase cas = new ALCase();
        cas.lineCount = 1;
        String line = file.get(lineI);
        boolean inGroup = false;
        char[] chars = line.toCharArray();
        Set<Character> current = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            switch (ch) {
                case '(':
                    inGroup = true;
                    current = new HashSet<>();
                    cas.pattern.add(current);
                    break;
                case ')':
                    inGroup = false;
                    break;
                default:
                    if (inGroup) {
                        current.add(ch);
                    } else {
                        current = new HashSet<>();
                        cas.pattern.add(current);
                        current.add(ch);
                    }
            }
        }
        return cas;
    }

    void buildTree(String str, TreeNode node) {
        char c = str.charAt(0);
        String remain = str.substring(1);
        if (node.childred.get(c) == null) {
            TreeNode newNode = new TreeNode(c);
            node.childred.put(c,newNode);
        }
        if (!remain.isEmpty()) {
            buildTree(remain,node.childred.get(c));
        }
    }
}

class ALCase extends JamCase {
    TreeNode startNode = new TreeNode(null);
    List<Set<Character>> pattern = new ArrayList<Set<Character>>();
}

class TreeNode {
    TreeNode(Character ch) {
        this.ch = ch;
    }

    Character ch;
    Map<Character,TreeNode> childred = new HashMap<Character, TreeNode>();
}


