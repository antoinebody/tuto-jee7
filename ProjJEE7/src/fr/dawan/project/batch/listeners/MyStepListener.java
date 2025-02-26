package fr.dawan.project.batch.listeners;

import javax.batch.api.listener.StepListener;
import javax.batch.runtime.context.StepContext;
import javax.inject.Inject;
import javax.inject.Named;


@Named
//@RequestScoped
public class MyStepListener implements StepListener {
	
	@Inject
	private StepContext stepContext;

	@Override
	public void afterStep() throws Exception {
		System.out.println("MyStepListener::afterStep");
		System.out.println(stepContext.getStepName());
		System.out.println(stepContext.getStepExecutionId());
		
	}

	@Override
	public void beforeStep() throws Exception {
		System.out.println("MyStepListener::beforeStep");
		
	}

}
