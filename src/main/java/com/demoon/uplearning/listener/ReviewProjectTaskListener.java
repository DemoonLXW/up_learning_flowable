package com.demoon.uplearning.listener;

import com.demoon.uplearning.service.ApplicantService;
import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.utils.ApplicationContextUtils;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.context.ApplicationContext;

public class ReviewProjectTaskListener implements TaskListener {

    public final static String TASK_TEACHER_REVIEW = "teacher-review";
    public final static String TASK_PLATFORM_REVIEWER_REVIEW = "platform-reviewer-review";

    private final TaskService taskService;

    private final ApplicantService applicantService;

    public ReviewProjectTaskListener() {
        ApplicationContext ctx = ApplicationContextUtils.getCtx();
        taskService = ctx.getBean(TaskService.class);
        applicantService = ctx.getBean(ApplicantService.class);
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        Integer userID = (Integer)delegateTask.getVariable("userID");
        String taskName = delegateTask.getName();
        String eventName = delegateTask.getEventName();

        switch (taskName) {
            case TASK_TEACHER_REVIEW: {

                switch (eventName) {
                    case EVENTNAME_CREATE:
                        User user = applicantService.getUserByID(userID);
                        System.out.println(user);
//                        System.out.println(user.getRoles());
                        taskService.setAssignee(delegateTask.getId(), "ui-test-teacher"+userID.toString());
//                        delegateTask.setAssignee("ui-test-teacher"+userID.toString());
                        break;
                }

                break;
            }

            case TASK_PLATFORM_REVIEWER_REVIEW: {

                switch (eventName) {
                    case EVENTNAME_CREATE:
                        delegateTask.setAssignee("ui-test-reviewer"+userID.toString());
                        break;
                }

                break;
            }
        }


    }
}
