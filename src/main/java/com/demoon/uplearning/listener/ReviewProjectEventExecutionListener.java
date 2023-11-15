package com.demoon.uplearning.listener;

import com.demoon.uplearning.service.ApplicantService;
import com.demoon.uplearning.entity.Project;
import com.demoon.uplearning.entity.Role;
import com.demoon.uplearning.utils.ApplicationContextUtils;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.ExecutionListener;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ReviewProjectEventExecutionListener implements ExecutionListener {

//    activity id
    public final static String ACT_START = "start";
    public final static String ACT_SUCCEEDED = "succeeded";
    public final static String ACT_FAILED = "failed";

// some constants
    public final static String STATUS_AGREE = "agree";
    public final static String STATUS_DENY = "deny";

//    services
    private final RuntimeService runtimeService;

    private final ApplicantService applicantService;

    public ReviewProjectEventExecutionListener() {
        ApplicationContext ctx = ApplicationContextUtils.getCtx();
        runtimeService = ctx.getBean(RuntimeService.class);
        applicantService = ctx.getBean(ApplicantService.class);
    }

    @Override
    public void notify(DelegateExecution execution) {
        String activityId = execution.getCurrentActivityId();
        String eventName = execution.getEventName();


        Integer userID = (Integer)execution.getVariable("userID");
        String reviewStatus = (String)execution.getVariable("reviewStatus");
//        Integer projectID = (Integer)execution.getVariable("projectID");



        switch (activityId) {

            case ACT_START:

                switch (eventName) {
                    case EVENTNAME_START:
                        List<Role> roles = applicantService.getRolesByUserID(userID);
                        boolean isTeacher = roles.stream().map(Role::getName).toList().contains("teacher");
                        execution.setVariable("isTeacher", isTeacher);
                        break;
                }

                break;

            case ACT_SUCCEEDED:

                switch (eventName) {
                    case EVENTNAME_END:
                        runtimeService.updateBusinessStatus(execution.getProcessInstanceId(), reviewStatus);
                        Integer projectID = Integer.parseInt(execution.getProcessInstanceBusinessKey());
                        Project project = new Project();
                        switch (reviewStatus) {
                            case STATUS_AGREE:
                                project.setReviewStatus(2);
                                break;
                            case STATUS_DENY:
                                project.setReviewStatus(3);
                                break;
                        }
                        applicantService.modifyProjectByProjectID(projectID, project);
                        break;
                }

                break;

            case ACT_FAILED:

                switch (eventName) {
                    case EVENTNAME_END:
                        runtimeService.updateBusinessStatus(execution.getProcessInstanceId(), reviewStatus);
                        break;
                }

                break;
        }
    }
}
