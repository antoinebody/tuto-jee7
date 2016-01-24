package fr.dawan.project.batch.chunk;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;

@Named
public class MyItemProcessor implements ItemProcessor {

	@Override
	public Object processItem(Object item) throws Exception {
		System.out.println("**** MyItemProcessor::processItem  : " + item);
		return null;
	}

}
