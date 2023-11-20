package com.demoon.uplearning.listener;

import com.demoon.uplearning.entity.College;
import com.demoon.uplearning.entity.Student;
import com.demoon.uplearning.entity.Teacher;
import com.demoon.uplearning.service.ApplicantService;
import com.demoon.uplearning.entity.User;
import com.demoon.uplearning.utils.ApplicationContextUtils;
import jakarta.transaction.Transactional;
import org.flowable.engine.TaskService;
import org.flowable.engine.delegate.TaskListener;
import org.flowable.task.service.delegate.DelegateTask;
import org.springframework.context.ApplicationContext;

public class ReviewProjectTaskListener implements TaskListener {

    public final static String TASK_TEACHER_REVIEW = "teacher-review";
    public final static String TASK_PLATFORM_REVIEWER_REVIEW = "platform-reviewer-review";

    public final static Integer ACTION_AGREE = 0;
    public final static Integer ACTION_DENY= 1;

    private final TaskService taskService;

    private final ApplicantService applicantService;

    public ReviewProjectTaskListener() {
        ApplicationContext ctx = ApplicationContextUtils.getCtx();
        taskService = ctx.getBean(TaskService.class);
        applicantService = ctx.getBean(ApplicantService.class);
    }


    public void setTeacherReviewer(String taskID, Integer userID) {
        User user = applicantService.getUserByID(userID);
        Student student = user.getStudent();
        Teacher teacher = student.getTeacher();
        if (teacher != null) {
            taskService.setAssignee(taskID, teacher.getUser().getId().toString());
        } else {
            College college = student.getClasse().getMajor().getCollege();
            taskService.addCandidateGroup(taskID, "teacher project reviewer"+college.getId().toString());
        }

    }

    @Transactional
    @Override
    public void notify(DelegateTask delegateTask) {
        Integer userID = (Integer)delegateTask.getVariable("userID");
        String taskName = delegateTask.getName();
        String eventName = delegateTask.getEventName();

        switch (taskName) {
            case TASK_TEACHER_REVIEW: {

                switch (eventName) {
                    case EVENTNAME_CREATE:
                        setTeacherReviewer(delegateTask.getId(), userID);
                        break;
                    case EVENTNAME_COMPLETE:
                        Integer action = (Integer)delegateTask.getVariable("action");
                        Integer reviewer = (Integer)delegateTask.getVariable("reviewer");
                        delegateTask.setVariableLocal("action", action);
                        delegateTask.setVariableLocal("reviewer", reviewer);
                        break;
                }

                break;
            }

            case TASK_PLATFORM_REVIEWER_REVIEW: {

                switch (eventName) {
                    case EVENTNAME_CREATE:
                        taskService.addCandidateGroup(delegateTask.getId(), "platform project reviewer");
                        break;
                    case EVENTNAME_COMPLETE:
                        Integer action = (Integer)delegateTask.getVariable("action");
                        Integer reviewer = (Integer)delegateTask.getVariable("reviewer");
                        delegateTask.setVariableLocal("action", action);
                        delegateTask.setVariableLocal("reviewer", reviewer);
                        break;
                }

                break;
            }
        }


    }
}
