import org.junit.jupiter.api.*;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/*
+ 1. Create test flow
+ 2. Include dependencies
+ 3. Simple test script
4. Test scenarios
+	Create task
+	Check all statuses
+	Delete task
+	Create task with date
5. Best practices
6. Page Object pattern
*/
public class SimpleTests extends UiTest {
    private String correctTaskName = "Creating automated test";
    private String initialTaskStatus = "waiting";
    private String taskStatusInProgress = "in progress";
    private String taskDate = "13-07-2023";
    private int estimation = 15;

    @Test
    void testSimpleTest() {
        mainPage.createTask(correctTaskName, estimation);

        String actualTaskName = mainPage.getCreatedTaskName();
        String actualTaskStatus = mainPage.getCreatedTaskStatus();
        String actualEstimationTime = mainPage.getCreatedTaskEstimationTime();

        assertTrue(mainPage.isTaskCardVisible(), "Card didn't appear");
        assertEquals(correctTaskName, actualTaskName, String.format("Task name is different from the passed. Actual value: %s", actualTaskName));
        assertTrue(actualTaskStatus.contains(initialTaskStatus), String.format("The status is different from waiting: %s", actualTaskStatus));
        assertTrue(actualEstimationTime.contains(String.valueOf(estimation)), String.format("The estimation time is different from %s: %s", estimation, actualEstimationTime));
    }

    @Test
    void testCheckAllStatuses() {
        mainPage.createTask(correctTaskName, estimation);
        mainPage.startTask();

        String actualTaskStatus = mainPage.getCreatedTaskStatus();
        assertTrue(actualTaskStatus.contains(taskStatusInProgress), String.format("The status is different from 'in progress'. %s", actualTaskStatus));
    }


    @Test
    void testDeleteTask() {
        mainPage.createTask(correctTaskName, estimation);
        mainPage.createTask(correctTaskName, estimation);
        mainPage.deleteTask();

        assertTrue(mainPage.onlyOneTaskCardVisible(), "There are still 2 cards. One card supposed to be removed");
    }

    @Test
    void testCreateTaskWithDate() {
        mainPage.createTaskWithDate(correctTaskName, estimation, taskDate);

        assertTrue(mainPage.isTaskCardDateVisible(), "Card didn't appear");
    }
}