package pekan6;

import java.util.Scanner;

public class DaftarBelanja {
    private Node head;
    private Node tail;

    public DaftarBelanja() {
        this.head = null;
        this.tail = null;
    }
    public void tambahItem(String nama, int kuantitas, String kategori) {
        ItemBelanja item = new ItemBelanja(nama, kuantitas, kategori);
        Node nodeBaru = new Node(item);

        if (head == null) {
            head = tail = nodeBaru;
        } else {
            tail.next = nodeBaru;
            nodeBaru.prev = tail;
            tail = nodeBaru;
        }
        System.out.println("Item berhasil ditambahkan!");
    }
    public void hapusItem(String nama) {
        Node current = head;
        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                if (current == head) {
                    head = current.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null) tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Item berhasil dihapus.");
                return; }           
            current = current.next;
        }
        System.out.println("Item tidak ditemukan.");
    }
    public void tampilkanSemuaItem() {
        if (head == null) {
            System.out.println("Daftar belanja kosong.");
            return;
        }

        System.out.println("--- Daftar Belanja ---");
        Node current = head;
        while (current != null) {
            ItemBelanja item = current.data;
            System.out.printf("- " + item.nama + " (" + item.kuantitas + ") [" + item.kategori + "]\n");
            current = current.next;
        }
    }
    public void tampilkanPerKategori(String kategori) {
        boolean ditemukan = false;
        Node current = head;

        System.out.printf("--- Item dalam kategori '" + kategori + "' ---\n", kategori);
        while (current != null) {
            if (current.data.kategori.equalsIgnoreCase(kategori)) {
                System.out.printf("- " + current.data.nama + " (" + current.data.kuantitas + ")\n");
                ditemukan = true;
            }
            current = current.next; }
        if (!ditemukan) {
            System.out.println("Tidak ada item dalam kategori tersebut."); }
    }
    public void cariItem(String nama) {
        Node current = head;

        while (current != null) {
            if (current.data.nama.equalsIgnoreCase(nama)) {
                System.out.printf("- " + current.data.nama + " (" + current.data.kuantitas + ") [" + current.data.kategori + "]\n");
                return;
            }
            current = current.next; }        
        System.out.println("Item tidak ditemukan.");
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DaftarBelanja daftar = new DaftarBelanja();

        System.out.println("=== MENU DAFTAR BELANJA ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Hapus Item");
        System.out.println("3. Tampilkan Semua Item");
        System.out.println("4. Tampilkan Item Berdasarkan Kategori");
        System.out.println("5. Cari Item");
        System.out.println("6. Keluar");

        while (true) {
            System.out.print("\nPilih menu: ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid.");
                continue;
            }

            switch (pilihan) {
            
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String nama = input.nextLine();
                    System.out.print("Masukkan kuantitas: ");
                    int kuantitas;
                    try {
                        kuantitas = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Kuantitas harus berupa angka.");
                        break;
                    }
                    System.out.print("Masukkan kategori: ");
                    String kategori = input.nextLine();
                    daftar.tambahItem(nama, kuantitas, kategori);
                    break;

                case 2:
                    System.out.print("Masukkan nama item yang ingin dihapus: ");
                    String hapus = input.nextLine();
                    daftar.hapusItem(hapus);
                    break;

                case 3:
                    daftar.tampilkanSemuaItem();
                    break;

                case 4:
                    System.out.print("Masukkan kategori: ");
                    String kategoriFilter = input.nextLine();
                    daftar.tampilkanPerKategori(kategoriFilter);
                    break;

                case 5:
                    System.out.print("Masukkan nama item yang dicari: ");
                    String cari = input.nextLine();
                    daftar.cariItem(cari);
                    break;

                case 6:
                    System.out.println("Terima kasih! Keluar dari program.");
                    input.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}