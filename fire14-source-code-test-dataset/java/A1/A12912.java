package com.menzus.gcj._2012.qualification.b;

import com.menzus.gcj.common.InputBlockParser;
import com.menzus.gcj.common.OutputProducer;
import com.menzus.gcj.common.impl.AbstractProcessorFactory;

public class BProcessorFactory extends AbstractProcessorFactory<BInput, BOutputEntry> {
    public BProcessorFactory(String inputFileName) {
	super(inputFileName);
    }

    @Override
    protected InputBlockParser<BInput> createInputBlockParser() {
	return new BInputBlockParser();
    }

    @Override
    protected OutputProducer<BInput, BOutputEntry> createOutputProducer() {
	return new BOutputProducer();
    }
}
