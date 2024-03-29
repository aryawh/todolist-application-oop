package service;

// Interface untuk layanan manajemen todo list
public interface TodoListService {
    // Method untuk menampilkan todo list
    void showTodoList();

    // Method untuk menambahkan todo ke dalam todo list
    void addTodoList(String todo);

    // Method untuk menghapus todo dari todo list berdasarkan nomor
    void removeTodoList(Integer number);
}
