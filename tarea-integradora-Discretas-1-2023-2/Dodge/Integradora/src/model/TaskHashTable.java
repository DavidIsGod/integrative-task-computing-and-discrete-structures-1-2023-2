package model;

public class TaskHashTable {
    private static final int TABLE_SIZE = 100; // Tamaño de la tabla (puedes ajustarlo según tus necesidades)
    private MiListaEnlazada<Task>[] table;

    @SuppressWarnings("unchecked")
    public TaskHashTable() {
        table = new MiListaEnlazada[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new MiListaEnlazada<>();
        }
    }

    public void addTask(int id, Task task) {
        int index = hashFunction(id);
        table[index].agregar(task);
    }

    public Task getTask(int id) {
        int index = hashFunction(id);
        MiListaEnlazada<Task> lista = table[index];
        Nodo<Task> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.valor.getId() == id) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null; // No se encontró la tarea con el ID especificado
    }

    public void removeTask(int id) {
        int index = hashFunction(id);
        MiListaEnlazada<Task> lista = table[index];
        Nodo<Task> actual = lista.getCabeza();
        while (actual != null) {
            if (actual.valor.getId() == id) {
                lista.eliminar(actual.valor);
                return;
            }
            actual = actual.siguiente;
        }
    }

    // Función de hash simple
    private int hashFunction(int id) {
        return id % TABLE_SIZE;
    }
}
