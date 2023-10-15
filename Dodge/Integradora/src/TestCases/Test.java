import model.ControllerDodge;
import model.Action;
import model.HashNode;
import model.IHashTable;
import model.IPriorityQueue;    
import model.IStack;
import model.NodeHeap;
import model.Nodo;
import model.Queue;
import model.Stack;
import model.Task;
import model.TaskHashTable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Test {

    static ControllerDodge controller;

    static ArrayList<Task> tasks;


    @Test
    public void testAddTask() {
        // Crear una nueva instancia de ControllerDodge
        controller = new ControllerDodge();

        // Agregar una tarea
        assertTrue(controller.addTask("001", "Tarea 1", "Resumen 1", setDeadline(2023, 7, 27), 1));

        // Recuperar la tarea agregada y verificar su existencia
        Task addedTask = controllerDodge.search("001");
        assertNotNull(addedTask);
        assertEquals("Tarea 1", addedTask.getLabel());
        assertEquals("Resumen 1", addedTask.getOverview());
        assertEquals(createDate(2023, 7, 27), addedTask.getDeadline());
        assertEquals(1, addedTask.getPriority());
    }

   