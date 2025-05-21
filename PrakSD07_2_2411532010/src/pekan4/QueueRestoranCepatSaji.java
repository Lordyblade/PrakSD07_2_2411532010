package pekan4;
import java.util.*;

class Pelanggan {
   String ID;
   int jumlahPesanan;

    Pelanggan(String ID, int jumlahPesanan) {
      this.ID = ID;
      this.jumlahPesanan = jumlahPesanan; }
   }
public class AntrianRestoran {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<Pelanggan> queue = new LinkedList<>();

        System.out.print("Masukkan jumlah pelanggan: ");
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            System.out.print("Masukkan ID pelanggan ke-" + (i + 1) + ": ");
            String id = scanner.next();
            System.out.print("Masukkan jumlah pesanan untuk " + id + ": ");
            int jumlahPesanan = scanner.nextInt();
            queue.add(new Pelanggan(id, jumlahPesanan)); }
        
        System.out.println("\n      -SERVICE RESULT- ");
        int waktuKumulatif = 0;

        while (!queue.isEmpty()) {
            Pelanggan p = queue.poll();
            waktuKumulatif += p.jumlahPesanan;
            System.out.println(p.ID + " selesai dalam " + waktuKumulatif + " menit");  }

        scanner.close();
    }
}