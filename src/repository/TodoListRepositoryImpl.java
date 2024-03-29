package repository;

import entity.Todolist;

// Kelas implementasi dari antarmuka TodoListRepository
public class TodoListRepositoryImpl implements TodoListRepository {
    // Array untuk menyimpan data todo
    public Todolist[] data = new Todolist[10];

    // Mengembalikan seluruh data todo
    @Override
    public Todolist[] getAll() {
        return data;
    }

    // Method untuk mengecek apakah array penuh
    public boolean isFull(){
        // Inisialisasi variabel untuk menandai apakah array penuh
        boolean isFull = true;
        // Iterasi melalui array untuk memeriksa apakah ada elemen yang kosong
        for(int i = 0; i < data.length; i++){
            if(data[i] == null){
                // Jika ada elemen yang kosong, array tidak penuh
                isFull = false;
            }
        }
        return isFull;
    }

    // Method untuk mengubah ukuran array menjadi dua kali lipat jika penuh
    public void resizeIfFull(){
        // Memeriksa apakah array penuh
        if(isFull()){
            // Jika array penuh, buat array sementara dengan ukuran dua kali lipat
            Todolist[] temp = data;
            data = new Todolist[data.length * 2];
            // Salin elemen dari array lama ke array baru
            for(int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
    }

    // Method untuk menambahkan todo ke repository
    @Override
    public void add(Todolist todolist) {
        // Memeriksa dan mengubah ukuran array jika penuh
        resizeIfFull();
        // Menambahkan data ke array yang kosong
        for(int i = 0; i < data.length; i++){
            if (data[i] == null){
                data[i] = todolist;
                break;
            }
        }
    }

    // Method untuk menghapus todo dari repository berdasarkan nomor
    @Override
    public boolean remove(Integer number) {
        // Memeriksa apakah nomor melebihi indeks array atau jika elemen di indeks tersebut kosong
        if((number-1) >= data.length || data[number-1] == null){
            return false;
        } else {
            // Menggeser elemen setelah elemen yang dihapus ke posisi sebelumnya
            for(int i = (number-1); i < data.length; i++){
                if(i == (data.length-1)){
                    data[i] = null;
                } else {
                    data[i] = data[i+1];
                }
            }
        }
        return true;
    }
}
