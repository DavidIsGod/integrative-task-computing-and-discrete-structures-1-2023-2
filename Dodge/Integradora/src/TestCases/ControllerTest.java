

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

    @Test
    public void testModifyTitle() {
        
        controller.addTask("001", "Tarea 1", "Resumen 1", setDeadline(2023, 7, 27), 1);

       
        String result = controller.modify("Nuevo Título", "001", 1);

        
        Task modifiedTask = controller.search("001");

       
        assertEquals("Se modifico correctamente", result);

        
        assertEquals("Nuevo Título", modifiedTask.getLabel());
    }

    @Test
    public void testModifyDescription() {
        // Agregar una tarea para modificar
        controller.addTask("002", "Tarea 2", "Resumen 2", setDeadline(2023, 7, 27), 1);

        // Modificar la descripción de la tarea
        String result = controller.modify("Nueva Descripción", "002", 2);

        // Obtener la tarea modificada
        Task modifiedTask = controller.search("002");

        // Verificar que el resultado del método sea el esperado
        assertEquals("Se modifico correctamente", result);

        // Verificar que la descripción de la tarea se haya modificado correctamente
        assertEquals("Nueva Descripción", modifiedTask.getOverview());
    }

    private Calendar setDeadline(int year, int month, int day) {
        Calendar deadline = Calendar.getInstance();
        deadline.set(year, month - 1, day);  // Mes es 0-indexado
        return deadline;
    }
}
