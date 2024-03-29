package repository;

import entity.Todolist;

// Interface untuk repository todo list
public interface TodoListRepository {
    Todolist[] getAll(); // Mengambil seluruh data todo

    // Method untuk menambahkan todo ke repository
    void add(Todolist todolist);

    // Method untuk menghapus todo dari repository berdasarkan nomor
    boolean remove(Integer number);
}
