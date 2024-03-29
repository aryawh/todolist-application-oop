package test.view;

import repository.TodoListRepository;
import repository.TodoListRepositoryImpl;
import service.TodoListService;
import service.TodoListServiceImpl;
import view.TodoListView;

public class TodoListViewTest {
    public static void main(String[] args) {
//        testShowTodoList();
//        testAddTodoList();
        testRemoveTodoList();
    }
    public static void testShowTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar OOP Gils");
        todoListService.addTodoList("Belajar OOP Anjay");
        todoListService.addTodoList("Belajar OOP Asem Lah!");

//        todoListService.showTodoList();
        todoListView.showTodoList();
    }

    public static void testAddTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListView.addTodoList();
        todoListService.showTodoList();
    }

    public static void testRemoveTodoList(){
        TodoListRepository todoListRepository = new TodoListRepositoryImpl();
        TodoListService todoListService = new TodoListServiceImpl(todoListRepository);
        TodoListView todoListView = new TodoListView(todoListService);

        todoListService.addTodoList("Belajar OOP Gils");
        todoListService.addTodoList("Belajar OOP Anjay");
        todoListService.addTodoList("Belajar OOP Asem Lah!");

        todoListService.showTodoList();
        todoListView.removeTodoList();
        todoListService.showTodoList();
    }
}
