package cn.tuyucheng.taketoday.jbpm.engine;

import org.kie.api.runtime.manager.Context;
import org.kie.api.runtime.process.ProcessInstance;

public interface WorkflowEngine {

   ProcessInstance runjBPMEngineForProcess(String processId, Context<String> initialContext, String kbaseId, String persistenceUnit);
}