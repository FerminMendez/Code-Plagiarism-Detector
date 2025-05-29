package com.menzus.gcj._2012.qualification.b;

import com.menzus.gcj.common.OutputProducer;

public class BOutputProducer implements OutputProducer<BInput, BOutputEntry> {

    @Override
    public BOutputEntry produceOutput(BInput input) {
	int avaragesAboveLimit = 0;
	int avaragesBelowLimitIfTheyWereSuprising = 0;
	for (int i = 0; i < input.getGooglerScores().length; i++) {
	    if (maximumNotSurprisingScoreOfTotalScore(input.getGooglerScores()[i]) >= input.getLimit()) {
		avaragesAboveLimit++;
	    } else if (maximumSurprisingScoreOfTotalScore(input.getGooglerScores()[i]) >= input.getLimit()) {
		avaragesBelowLimitIfTheyWereSuprising++;
	    }
	}
	BOutputEntry outputEntry = new BOutputEntry();
	outputEntry.setMaximumGooglersNumber(avaragesAboveLimit
		+ Math.min(avaragesBelowLimitIfTheyWereSuprising, input.getSurprisingTripletsNumber()));
	return outputEntry;
    }

    private int maximumNotSurprisingScoreOfTotalScore(int totalScore) {
	if (totalScore % 3 == 0) {
	    return totalScore / 3;
	} else {
	    return totalScore / 3 + 1;
	}
    }

    private int maximumSurprisingScoreOfTotalScore(int totalScore) {
	int maximumNotSurprisingScoreOfTotalScore = maximumNotSurprisingScoreOfTotalScore(totalScore);
	if (maximumNotSurprisingScoreOfTotalScore == 0) {
	    return maximumNotSurprisingScoreOfTotalScore;
	} else {
	    return maximumNotSurprisingScoreOfTotalScore + 1;
	}
    }
}
