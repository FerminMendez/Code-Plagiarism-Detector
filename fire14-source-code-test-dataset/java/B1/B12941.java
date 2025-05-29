package com.menzus.gcj._2012.qualification.c;

import com.menzus.gcj.common.InputBlockParser;
import com.menzus.gcj.common.OutputProducer;
import com.menzus.gcj.common.impl.AbstractProcessorFactory;

public class CProcessorFactory extends AbstractProcessorFactory<CInput, COutputEntry> {
    public CProcessorFactory(String inputFileName) {
	super(inputFileName);
    }

    @Override
    protected InputBlockParser<CInput> createInputBlockParser() {
	return new CInputBlockParser();
    }

    @Override
    protected OutputProducer<CInput, COutputEntry> createOutputProducer() {
	return new COutputProducer();
    }
}
