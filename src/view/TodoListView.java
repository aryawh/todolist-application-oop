package view;

import service.TodoListService;
import service.TodoListServiceImpl;
import util.InputUtil;

public class TodoListView {
    private TodoListService todoListService;

    public TodoListView(TodoListService todoListService){
        this.todoListService = todoListService;
    }
    public void showTodoList(){
        while (true){
            todoListService.showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. TAMBAH");
            System.out.println("2. HAPUS");
            System.out.println("x. KELUAR");
            var input = InputUtil.input("Pilih: ");

            if(input.equals("1")){
                addTodoList();
            } else if (input.equals("2")) {
                removeTodoList();
            } else if(input.equals("x")){
                break;
            } else {
                System.out.println("Tidak Mengerti");
            }
        }
    }
    public void addTodoList(){
        System.out.println("MENAMBAH TODOLIST");
        var input = InputUtil.input("Todo (X jika batal) ");
        if(input.equals("x")){
            //
        }else {
            todoListService.addTodoList(input);
        }
    }
    public void removeTodoList(){
        System.out.println("MENGHAPUS TODOLIST");
        var number = InputUtil.input("Todo (X jika batal)");
        if(number.equals("x")){
            //
        }else {
            todoListService.removeTodoList(Integer.valueOf(number));
        }
    }
}
