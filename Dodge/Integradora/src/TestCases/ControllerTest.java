package TestCases;

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
        // Crear una nueva instancia de ControllerDodge
        controller = new ControllerDodge();
        Calendar deadline = Calendar.getInstance();
        deadline.set(2023, 6, 27);
        // Agregar una tarea
        assertTrue(controller.addTask("001", "Tarea 1", "Resumen 1", deadline, 1));

        // Recuperar la tarea agregada y verificar su existencia
        Task addedTask = controller.search("001");
        assertNotNull(addedTask);
        assertEquals("Tarea 1", addedTask.getLabel());
        assertEquals("Resumen 1", addedTask.getOverview());
        assertEquals(deadline, addedTask.getDeadline());
        assertEquals(1, addedTask.getPriority());
    }

    @Test
    public void testDeleteTaskFromQueue() {
        ControllerDodge controller = new ControllerDodge();
        Calendar deadline = Calendar.getInstance();
        deadline.set(2023, 6, 27);
      
        controller.addTask("001", "Tarea 1", "Resumen 1", deadline, 0);
       
        Task addedTask = controller.search("001");
        assertNotNull(addedTask);
        assertTrue(controller.deleteTask("001"));
        assertNull(controller.search("001"));
    }

    
}
