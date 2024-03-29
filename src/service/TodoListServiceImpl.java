package service;

import entity.Todolist;
import repository.TodoListRepository;

// Implementasi dari interface TodoListService
public class TodoListServiceImpl implements TodoListService {
    private TodoListRepository todoListRepository;

    // Konstruktor untuk TodoListServiceImpl dengan dependency TodoListRepository
    public TodoListServiceImpl(TodoListRepository todoListRepository){
        this.todoListRepository = todoListRepository;
    }

    // Method untuk menampilkan todo list
    @Override
    public void showTodoList() {
        Todolist[] model = todoListRepository.getAll();
        System.out.println("TODOLIST");
        for(int i = 0; i < model.length; i++){
            Todolist todo = model[i];
            int no = i + 1;
            if(todo != null){
                System.out.println(no + ". " + todo.getTodo());
            }
        }
    }

    // Method untuk menambahkan todo ke dalam todo list
    @Override
    public void addTodoList(String todo) {
        Todolist todolist = new Todolist(todo);
        todoListRepository.add(todolist);
        System.out.println("Sukses menambah TODO: " + todo);
    }

    // Method untuk menghapus todo dari todo list berdasarkan nomor
    @Override
    public void removeTodoList(Integer number) {
        boolean success = todoListRepository.remove(number);
        if(success){
            System.out.println("Sukses menghapus todo: " + number);
        } else {
            System.out.println("Gagal menghapus todo: " + number);
        }
    }
}
