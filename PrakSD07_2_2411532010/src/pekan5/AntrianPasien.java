package pekan5;

import java.util.*;

public class AntrianPasien {

    static class Node {
        int noAntrian;
        String namaPasien;
        String keluhan;
        Node next;

        Node(int noAntrian, String namaPasien, String keluhan) {
            this.noAntrian = noAntrian;
            this.namaPasien = namaPasien;
            this.keluhan = keluhan;
            this.next = null;} }

    private Node head;

    public void tambahPasien(int noAntrian, String nama, String keluhan) {
        Node baru = new Node(noAntrian, nama, keluhan);
        if (head == null) {
            head = baru;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
        System.out.println("\nData pasien berhasil ditambahkan!\n"); }    

    public void tampilkanAntrian() {
        if (isEmpty()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("\n--- Daftar Antrian Pasien ---");
            Node current = head;
            int i = 1;
            while (current != null) {
                System.out.println(i + ". [" + current.noAntrian + "] " + current.namaPasien + " - " + current.keluhan);
                current = current.next;
                i++; } } }

    public void hapusPasienPertama() {
        if (isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
        } else {
            System.out.println("\nPasien dengan nama " + head.namaPasien + " telah dilayani (dihapus dari antrian).\n");
            head = head.next; } }
    
    public void cariPasien(String nama) {
        Node current = head;
        boolean ditemukan = false;
        while (current != null) {
            if (current.namaPasien.equalsIgnoreCase(nama)) {
                System.out.println("Pasien ditemukan: [" + current.noAntrian + "] " + current.namaPasien + " - " + current.keluhan);
                ditemukan = true;
                break;
            }
            current = current.next;
        }
        if (!ditemukan) {
            System.out.println("Pasien dengan nama \"" + nama + "\" tidak ditemukan dalam antrian."); } }
       

    public boolean isEmpty() {
        return head == null; }

    public int hitungPasien() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;  }
    

    public static void main(String[] args) {
        AntrianPasien antrian = new AntrianPasien();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("=== SISTEM ANTRIAN PASIEN KLINIK ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Tampilkan Antrian");
            System.out.println("3. Layani Pasien (Hapus Antrian Pertama)");
            System.out.println("4. Cari Pasien");
            System.out.println("5. Jumlah Pasien");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nomor Antrian: ");
                    int no = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan Nama Pasien: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Keluhan: ");
                    String keluhan = scanner.nextLine();
                    antrian.tambahPasien(no, nama, keluhan);
                    break;
                case 2:
                    antrian.tampilkanAntrian();
                    break;
                case 3:
                    antrian.hapusPasienPertama();
                    break;
                case 4:
                    System.out.print("Masukkan Nama Pasien yang dicari: ");
                    String cari = scanner.nextLine();
                    antrian.cariPasien(cari);
                    break;
                case 5:
                    System.out.println("\nJumlah pasien saat ini: " + antrian.hitungPasien() + "\n");
                    break;
                case 6:
                    System.out.println("\nTerima kasih telah menggunakan sistem antrian.\n");
                    break;
                default:
                    System.out.println("Pilihan tidak valid."); } }
            
         while (pilihan != 6);

        scanner.close();  } }
    
