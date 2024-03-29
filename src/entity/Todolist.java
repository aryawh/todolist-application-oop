package entity;

// Entity disini untuk menyimpan String todo
public class Todolist {
    private String todo; // Variabel untuk menyimpan tugas todo

    // Constructor kosong untuk objek Todolist
    public Todolist(){

    }

    // Constructor dengan parameter untuk objek Todolist dengan tugas todo tertentu
    public Todolist(String todo){
        this.todo = todo; // Inisialisasi variabel todo dengan nilai dari parameter
    }

    // Setter untuk mengatur nilai tugas todo
    public void setTodo(String todo){
        this.todo = todo; // Mengatur nilai tugas todo dengan nilai dari parameter
    }

    // Getter untuk mendapatkan nilai tugas todo
    public String getTodo(){
        return todo; // Mengembalikan nilai tugas todo
    }
}
