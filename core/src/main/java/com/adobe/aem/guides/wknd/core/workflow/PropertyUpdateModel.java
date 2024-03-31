package com.adobe.aem.guides.wknd.core.workflow;

import com.adobe.granite.workflow.exec.WorkflowData;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.search.QueryBuilder;

@Component(property = {
        Constants.SERVICE_DESCRIPTION + "= Property Update process",
        Constants.SERVICE_VENDOR + "= Neha Systems",
        "process.label" + "= Property Update process"
})
public class PropertyUpdateModel implements WorkflowProcess {

    private static final Logger log = LoggerFactory.getLogger(PropertyUpdateModel.class);
    @Reference
    QueryBuilder queryBuilder;

    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap processArguments)
            throws WorkflowException {
        // TODO Auto-generated method stub
        log.info("Inside execute method");
        WorkflowData workflowData = workItem.getWorkflowData();
         String payLoad = workflowData.getPayload().toString();
         log.info("payLoad is {}", payLoad);
    }
}
