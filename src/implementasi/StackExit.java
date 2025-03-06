
package implementasi;

public class StackExit {
    private int maxSize;         // Variabel untuk menyimpan ukuran maksimum tumpukan
    private NodeExit[] stackArray;   // Array yang digunakan untuk menyimpan elemen-elemen dalam tumpukan
    private int top;             // Indeks dari elemen teratas dalam tumpukan
    // Konstruktor dengan parameter untuk membuat tumpukan dengan ukuran tertentu
    public StackExit(int size) {
        maxSize = size;
        stackArray = new NodeExit[maxSize]; // Membuat array dengan ukuran maksimum yang diberikan
        top = -1; // Awalnya, tumpukan kosong, jadi indeks teratas diatur ke -1
    }
    // Konstruktor default untuk membuat tumpukan dengan ukuran default (50)
    public StackExit() {
        maxSize = 50; // Ukuran tumpukan default
        stackArray = new NodeExit[maxSize]; // Membuat array dengan ukuran maksimum default
        top = -1; // Awalnya, tumpukan kosong, jadi indeks teratas diatur ke -1
    }
    // Method untuk menambahkan elemen ke tumpukan (push)
    public void push(NodeExit item) {
        stackArray[++top] = item; // Menambahkan elemen baru ke tumpukan dan mengubah indeks teratas
    }
    // Method untuk menghapus dan mengembalikan elemen teratas dari tumpukan (pop)
    public NodeExit pop() {
        return stackArray[top--]; // Mengembalikan elemen teratas dan mengurangi indeks teratas
    }
    // Method untuk melihat elemen teratas dari tumpukan tanpa menghapusnya (peek)
    public NodeExit peek() {
        return stackArray[top]; // Mengembalikan elemen teratas tanpa mengubah indeks teratas
    }
    // Method untuk memeriksa apakah tumpukan kosong
    public boolean isEmpty() {
        return (top == -1); // Tumpukan kosong jika indeks teratas -1
    }
    // Method untuk memeriksa apakah tumpukan penuh
    public boolean isFull() {
        return (top == maxSize - 1); // Tumpukan penuh jika indeks teratas sama dengan ukuran maksimum - 1
    }
}


