package Main;

import Model.Game;
import Model.PCGame;
import Model.MobileGame;
import Service.GameService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            GameService service = new GameService();
            int pilihan;

            do {
                System.out.println("\n=== Manajemen Daftar Game Favorit ===");
                System.out.println("1. Tambah Game");
                System.out.println("2. Lihat Daftar Game");
                System.out.println("3. Ubah Game");
                System.out.println("4. Hapus Game");
                System.out.println("5. Keluar");
                System.out.print("Pilih menu: ");
                pilihan = input.nextInt();
                input.nextLine();

                switch (pilihan) {
                    case 1 -> { // CREATE
                        System.out.println("Pilih jenis game: ");
                        System.out.println("1. PC Game");
                        System.out.println("2. Mobile Game");
                        System.out.print("Pilihan: ");
                        int jenis = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan nama game: ");
                        String nama = input.nextLine();
                        System.out.print("Masukkan genre game: ");
                        String genre = input.nextLine();
                        System.out.print("Masukkan tahun rilis: ");
                        int tahun = input.nextInt();

                        Game game = (jenis == 1) ?
                                new PCGame(nama, genre, tahun) :
                                new MobileGame(nama, genre, tahun);
                        service.tambah(game);
                    }
                    case 2 -> { // READ
                        System.out.println("1. Lihat PC Game");
                        System.out.println("2. Lihat Mobile Game");
                        System.out.print("Pilihan: ");
                        int jenis = input.nextInt();
                        if (jenis == 1) service.tampilkanPCGame();
                        else service.tampilkanMobileGame();
                    }
                    case 3 -> { // UPDATE
                        System.out.println("Pilih jenis game yang ingin diubah: ");
                        System.out.println("1. PC Game");
                        System.out.println("2. Mobile Game");
                        System.out.print("Pilihan: ");
                        int jenis = input.nextInt();

                        if (jenis == 1) service.tampilkanPCGame();
                        else service.tampilkanMobileGame();

                        System.out.print("Masukkan ID game yang ingin diubah: ");
                        int id = input.nextInt();
                        input.nextLine();

                        System.out.print("Masukkan nama game baru: ");
                        String namaBaru = input.nextLine();
                        System.out.print("Masukkan genre baru: ");
                        String genreBaru = input.nextLine();
                        System.out.print("Masukkan tahun rilis baru: ");
                        int tahunBaru = input.nextInt();

                        Game gameBaru = (jenis == 1) ?
                                new PCGame(namaBaru, genreBaru, tahunBaru) :
                                new MobileGame(namaBaru, genreBaru, tahunBaru);
                        service.ubah(id, gameBaru);
                    }
                    case 4 -> { // DELETE
                        System.out.println("Hapus dari: 1. PC Game | 2. Mobile Game");
                        int jenis = input.nextInt();

                        if (jenis == 1) service.tampilkanPCGame();
                        else service.tampilkanMobileGame();

                        System.out.print("Masukkan ID game yang ingin dihapus: ");
                        int id = input.nextInt();

                        service.hapus(id, jenis == 1);
                    }
                    case 5 -> System.out.println("Terima kasih! Program selesai.");
                    default -> System.out.println("Pilihan tidak valid, coba lagi.");
                }
            } while (pilihan != 5);
        }
    }
}
