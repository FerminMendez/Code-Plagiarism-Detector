package com.codegem.zaidansari;

import java.util.ArrayList;
import java.util.List;


class Score {

    int score1, score2, score3;
    int bestScore;
    boolean isSurprising;

    public Score(int score1, int score2, int score3) {
        super();
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.bestScore = Math.max(Math.max(score1, score2), score3);
        this.isSurprising = (Math.abs(score1 - score2) == 2) || (Math.abs(score1 - score3) == 2) || (Math.abs(score2 - score3) == 2);
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getBestScore() {
        return bestScore;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public boolean isSurprising() {
        return isSurprising;
    }

    public void setSurprising(boolean isSurprising) {
        this.isSurprising = isSurprising;
    }

    public static List<Score> getPossibleScoreCombinations(int totalScore) {
        List<Score> possibleScores = new ArrayList<Score>();
        if (totalScore == 0) {
            possibleScores.add(new Score(0, 0, 0));
            possibleScores.add(new Score(0, 0, 0));
            return possibleScores;
        }

        int mean = totalScore / 3;
        int remainder = totalScore % 3;
        switch (remainder) {
            case 0:
                possibleScores.add(new Score(mean, mean, mean));
                possibleScores.add(new Score(mean, mean - 1, mean + 1));
                break;
            case 1:
                possibleScores.add(new Score(mean, mean, mean + 1));
                possibleScores.add(new Score(mean - 1, mean + 1, mean + 1));
                break;
            case 2:
                possibleScores.add(new Score(mean, mean, mean + 2));
                possibleScores.add(new Score(mean, mean + 1, mean + 1));
                break;
        }
        return possibleScores;
    }
}

public class ProblemB {

    private int noofGooglers;
    private int surprisingCount;
    public static int bestResult;
    // private List<PersonScore> googlers = new ArrayList<PersonScore>();
    private BTree tree;
    public static List<Node> leafLevelNodes = new ArrayList<Node>();

    public ProblemB(int noofGooglers, int surprisingCount, int bestResult, int[] totalScores) {
        super();
        ProblemB.bestResult = bestResult;
        Node rootNode = new Node(new Score(0, 0, 0), totalScores, 0, 0);
        tree = new BTree(rootNode);
        this.noofGooglers = noofGooglers;
        this.surprisingCount = surprisingCount;

        // int[] childNodeScores = new int[totalScores.length - 1];
        // for (int index = 1; index < totalScores.length; index++) {
        // childNodeScores[index - 1] = totalScores[index];
        // }
        // List<Score> scores = Score.getPossibleScoreCombinations(totalScores[0]);
        // tree.getRootNode().setLeftNode(new Node(scores.get(0), childNodeScores, 0, 0));
        // tree.getRootNode().setRightNode(new Node(scores.get(1), childNodeScores, 0, 0));

    }

    public static void main(String[] args) {
        String inputLine = "6 2 8 29 20 8 18 18 21";
        String[] inputValues = inputLine.split(" ");
        int noofGooglers = Integer.parseInt(inputValues[0]);
        int surprisingCount = Integer.parseInt(inputValues[1]);
        int bestResult = Integer.parseInt(inputValues[2]);
        int[] totalScores = new int[noofGooglers];

        for (int index = 0; index < noofGooglers; index++) {
            totalScores[index] = Integer.parseInt(inputValues[3 + index]);
        }
        ProblemB problemB = new ProblemB(noofGooglers, surprisingCount, bestResult, totalScores);
        int result = -1;
        for (Node node : ProblemB.leafLevelNodes) {
            if (node.getParentNodesSuprisingCount() == surprisingCount) {
                result = Math.max(result, node.getParentBestMatchCount());
            }
        }
        System.out.println(result);
    }

}

class BTree {

    private Node rootNode;

    public BTree(Node rootNode) {
        super();
        this.rootNode = rootNode;
    }

    public Node getRootNode() {
        return rootNode;
    }

    public void setRootNode(Node rootNode) {
        this.rootNode = rootNode;
    }
}

class Node {

    private int parentNodesSuprisingCount;
    private int parentBestMatchCount;
    private Score score;
    private Node leftNode;
    private Node rightNode;

    public Node(Score score, int[] scores, int parentNodesSuprisingCount, int parentBestMatchCount) {
        this.parentNodesSuprisingCount = parentNodesSuprisingCount;
        this.parentBestMatchCount = parentBestMatchCount;
        this.score = score;
        int[] childNodeScores = null;
        if (scores != null && scores.length > 0) {
            childNodeScores = new int[scores.length - 1];
            for (int index = 1; index < scores.length; index++) {
                childNodeScores[index - 1] = scores[index];
            }
        }
        List<Score> scoresList = null;
        if (scores != null && scores.length > 0) scoresList = Score.getPossibleScoreCombinations(scores[0]);
        if (score != null) {

            this.setLeftNode(new Node((scoresList != null ? scoresList.get(0) : null), childNodeScores, parentNodesSuprisingCount
                    + (scoresList != null && scoresList.get(0) != null && scoresList.get(0).isSurprising ? 1 : 0), parentBestMatchCount
                    + (scoresList != null && scoresList.get(0) != null && scoresList.get(0).getBestScore() >= ProblemB.bestResult ? 1 : 0)));
            this.setRightNode(new Node((scoresList != null ? scoresList.get(1) : null), childNodeScores, parentNodesSuprisingCount
                    + (scoresList != null && scoresList.get(1) != null && scoresList.get(1).isSurprising ? 1 : 0), parentBestMatchCount
                    + (scoresList != null && scoresList.get(1) != null && scoresList.get(1).getBestScore() >= ProblemB.bestResult ? 1 : 0)));
            if (childNodeScores != null && childNodeScores.length == 0) {
                ProblemB.leafLevelNodes.add(this.leftNode);
                ProblemB.leafLevelNodes.add(this.rightNode);
            }
        }
    }

    public int getParentNodesSuprisingCount() {
        return parentNodesSuprisingCount;
    }


    public void setParentNodesSuprisingCount(int parentNodesSuprisingCount) {
        this.parentNodesSuprisingCount = parentNodesSuprisingCount;
    }


    public int getParentBestMatchCount() {
        return parentBestMatchCount;
    }


    public void setParentBestMatchCount(int parentBestMatchCount) {
        this.parentBestMatchCount = parentBestMatchCount;
    }


    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }
}
