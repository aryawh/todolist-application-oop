public class AplikasiToDoList {
    //    1. Membuat Model
    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

//    2. Merancang Business Logic
    /**
     * Menampilkan Todo list
     */
    public static void showTodoList() {
        for (int i = 0; i < model.length; i++) {
            var no = i + 1;
            var todo = model[i];
            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }
    }
    public static void testShowTodoList() {
        model[0] = "Membuat Todo list";
        model[1] = "Belajar java dasar";
        showTodoList();
    }
    /**
     * Menambahkan  Todo ke list
     */
    public static void addTodoList(String todo) {
        // Cek apakah model penuh?
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // Jika penuh kita resize ukuran arraynya *2
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            // Menyalin data lama ke array baru
            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Menambahkan ke posisi yang data arraynya null
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList(){
        for(var i =0; i<25; i++) {
            addTodoList("Contoh ke. "+ i);
        }

        showTodoList();
    }
    /**
     * Menghapus Todo dari list
     */
    public static boolean removeTodoList(int number) {
        // Cek apakah nomor melebihi nilai list
        if ((number - 1) >= model.length) {
            return false;
        }
        // Cek apakah nilai tersebut kosong
        else if (model[number - 1] == null) {
            return false;
        } else {
            // Geser elemen-elemen berikutnya ke posisi yang sesuai
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }


    public static void testRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(4);
        System.out.println(result);

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi " + name);

        var channel = input("Channel");
        System.out.println(channel);
    }

//    3. Menentukan VIEW
    /**
     * Menampilkan view Todo list
     */
    public static void viewShowTodoList(){
        while(true){
            showTodoList();

            System.out.println("MENU");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");
            var input = input("Pilih");

            if(input.equals("1")){
                viewAddTodoList();
            }else if (input.equals("2")){
                viewRemoveTodoList();
            }else if (input.equals("x")){
                break;
            }else {
                System.out.println("Tidak Dimengerti");
            }

        }
    }
    public static void testViewShowTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");
        addTodoList("Empat");
        addTodoList("Lima");

        viewShowTodoList();
    }
    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList(){
        System.out.println("TAMBAH DATA");
        var todo = input("Todo(x jika batal)  ");

        if(todo.equals("x")){
//            Batal
        }else{
            addTodoList(todo);
        }

    }
    public static void testViewAddTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");

        viewAddTodoList();

        showTodoList();
    }
    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList(){
        System.out.println("MENGHAPUS TODO LIST");
        var number = input("Hapus todo (x jika batal)");

        if(number.equals("x")){
//            Batal
        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus todo list : "+ number);
            }
        }

    }

    public static void testViewRemoveTodoList(){
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();
        viewRemoveTodoList();
        showTodoList();
    }
}
