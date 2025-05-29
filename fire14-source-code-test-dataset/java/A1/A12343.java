package teardrop.jam2012.qr.dancing;

import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CaseSolver {
    private final Reader reader;
    private final Writer writer;

    public CaseSolver(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void solve() throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(reader);

        int tokenType = tokenizer.nextToken();
        assert tokenType == StreamTokenizer.TT_NUMBER;
        int googlersCount = (int) tokenizer.nval;

        tokenType = tokenizer.nextToken();
        assert tokenType == StreamTokenizer.TT_NUMBER;
        int surprisingTripletCount = (int) tokenizer.nval;

        tokenType = tokenizer.nextToken();
        assert tokenType == StreamTokenizer.TT_NUMBER;
        int minimalGoodScore = (int) tokenizer.nval;

        int goodScores = 0;
        int possiblyGoodScores = 0;
        for (int i = 0; i < googlersCount; i++) {
            tokenType = tokenizer.nextToken();
            assert tokenType == StreamTokenizer.TT_NUMBER;
            int totalScore = (int) tokenizer.nval;

            int maxNonSurprisingScore = (totalScore + 2) / 3;
            if (maxNonSurprisingScore >= minimalGoodScore) {
                goodScores++;
            } else {
                int maxSurprisingScore = totalScore == 0 ? 0 : (totalScore + 4) / 3;
                if (maxSurprisingScore >= minimalGoodScore) {
                    possiblyGoodScores++;
                }
            }
        }

        int answer = goodScores + Math.min(possiblyGoodScores, surprisingTripletCount);
        writer.write(String.valueOf(answer));
    }
}
