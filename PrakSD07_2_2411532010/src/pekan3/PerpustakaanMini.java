package pekan3;

import java.util.*;

class Buku {
    String judul;

    Buku(String judul) {
        this.judul = judul;
    }

    public String toString() {
        return judul;
    }
}
public class PerpustakaanMini {
    static Stack<Buku> tumpukan = new Stack<>();
    static Scanner input = new Scanner(System.in);

    static void tambahBukuAwal() {
        tumpukan.push(new Buku("Algoritma Dasar"));
        tumpukan.push(new Buku("Struktur Data"));
        tumpukan.push(new Buku("Basis Data"));
        tumpukan.push(new Buku("Pemrograman Java"));
        tumpukan.push(new Buku("Jaringan Komputer"));
        tumpukan.push(new Buku("Sistem Operasi"));
    }

    static void tambahBuku() {
        System.out.print("Masukkan judul buku: ");
        String judul = input.nextLine();
        tumpukan.push(new Buku(judul));
        System.out.println("Buku \"" + judul + "\" telah ditambahkan ke tumpukan.");
    }

    static void ambilBuku() {
        if (tumpukan.isEmpty()) {
            System.out.println("Tumpukan kosong, tidak ada buku yang bisa diambil.");
        } else {
            Buku diambil = tumpukan.pop();
            System.out.println("Buku diambil : " + diambil );
        }
    }

    static void lihatTumpukan() {
        if (tumpukan.isEmpty()) {
            System.out.println("Tumpukan kosong.");
        } else {
            System.out.println("Tumpukan Buku Saat Ini:");
            for (int i = tumpukan.size() - 1; i >= 0; i--) {
                System.out.println("- " + tumpukan.get(i));
            }
        }
    }

    static void cariBuku() {
        System.out.print("Masukkan judul buku yang ingin dicari: ");
        String judulDicari = input.nextLine();
        boolean ditemukan = false;

        for (Buku buku : tumpukan) {
            if (buku.judul.equalsIgnoreCase(judulDicari)) {
                ditemukan = true;
                break;
            }
        }

        if (ditemukan) {
            System.out.println("Buku \"" + judulDicari + "\" ditemukan dalam tumpukan.");
        } else {
            System.out.println("Buku \"" + judulDicari + "\" tidak ada dalam tumpukan.");
        }
    }

    public static void main(String[] args) {
      
        tambahBukuAwal();

        int pilihan;

        do {
            System.out.println("\n=== MENU PERPUSTAKAAN MINI ===");
            System.out.println("1. Tambah Buku ke Tumpukan");
            System.out.println("2. Ambil Buku Teratas");
            System.out.println("3. Lihat Tumpukan Buku");
            System.out.println("4. Cari Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahBuku();
                case 2 -> ambilBuku();
                case 3 -> lihatTumpukan();
                case 4 -> cariBuku();
                case 5 -> System.out.println("Terima kasih telah menggunakan sistem.");
                default -> System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);
    }
}