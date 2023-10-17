

import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import model.ControllerDodge;
import model.Task;

public class ControllerTest {

    static ControllerDodge controller;

    static ArrayList<Task> tasks;

    @Test
    public void testAddTask() {
        // Create a new instance of ControllerDodge
        controller = new ControllerDodge();
        Calendar deadline = Calendar.getInstance();
        deadline.set(2023, 6, 27);
        // Add a task
        assertTrue(controller.addTask("001", "Task 1", "Overview 1", deadline, 1));

        // Retrieve the added task and verify its existence
        Task addedTask = controller.search("001");
        assertNotNull(addedTask);
        assertEquals("Task 1", addedTask.getLabel());
        assertEquals("Overview 1", addedTask.getOverview());
        assertEquals(deadline, addedTask.getDeadline());
        assertEquals(1, addedTask.getPriority());
    }

    @Test
    public void testDeleteTaskFromQueue() {
        ControllerDodge controller = new ControllerDodge();
        Calendar deadline = Calendar.getInstance();
        deadline.set(2023, 6, 27);
      
        controller.addTask("001", "Task 1", "Overview 1", deadline, 0);
       
        Task addedTask = controller.search("001");
        assertNotNull(addedTask);
        assertTrue(controller.deleteTask("001"));
        assertNull(controller.search("001"));
    }

    @Test
    public void testModifyTitle() {
        
        controller.addTask("001", "Task 1", "Overview 1", setDeadline(2023, 7, 27), 1);

       
        String result = controller.modify("New label", "001", 1);

        
        Task modifiedTask = controller.search("001");

       
        assertEquals("Correctly modified", result);

        
        assertEquals("New label", modifiedTask.getLabel());
    }

    @Test
    public void testModifyDescription() {
        // Add a task to modify
        controller.addTask("002", "Task 2", "Overview 2", setDeadline(2023, 7, 27), 1);

        // Modify the task description
        String result = controller.modify("New description", "002", 2);

        // Get the modified task
        Task modifiedTask = controller.search("002");

        // Verify that the result of the method is the expected one.
        assertEquals("Correctly modified", result);

        // Verify that the task description has been modified correctly
        assertEquals("New description", modifiedTask.getOverview());
    }

    private Calendar setDeadline(int year, int month, int day) {
        Calendar deadline = Calendar.getInstance();
        deadline.set(year, month - 1, day);  // Month is 0-indexed
        return deadline;
    }
}
