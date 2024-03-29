package test.service;

import entity.Todolist;
import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListServiceTest {
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();
    }
    public static void testShowTodoList(){
        TodoListRepositoryImpl todoListRepository = new TodoListRepositoryImpl();
        todoListRepository.data[0]= new Todolist("Arya");
        todoListRepository.data[1]= new Todolist("Arya Widya");
        todoListRepository.data[2]= new Todolist("Arya Hastungkoro");

        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.showTodoList();
    }
    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java OOP pagi hari");
        todoListService.addTodoList("Belajar Java Standart Classes siang hari");
        todoListService.addTodoList("Belajar Java Studi Kasus malam hari");

        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);

        todoListService.addTodoList("Belajar Java OOP pagi hari");
        todoListService.addTodoList("Belajar Java Standart Classes siang hari");
        todoListService.addTodoList("Belajar Java Studi Kasus malam hari");

        todoListService.showTodoList();
        todoListService.removeTodoList(5);
        todoListService.removeTodoList(2);
        todoListService.showTodoList();
        todoListService.removeTodoList(1);
        todoListService.showTodoList();
    }
}
