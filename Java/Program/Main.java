import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        // Supaya karakter kotak ╔═╗ tampil benar di semua terminal
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        // ================= GameStore 1 =================
        Game game1 = new Game(101, 1, "Elden Ring", 750000, 10, "RPG", "PS5");
        Console console1 = new Console(102, 1, "PlayStation 5", 8500000, 5, "Sony", "1TB");
        Accessory acc1 = new Accessory(103, 1, "DualSense Controller", 950000, 15, "Controller", "PS5");

        GameStore store1 = new GameStore();
        store1.setTokoID(1);
        store1.setNamaToko("GameHub Bandung");
        store1.setLokasi("Bandung");
        store1.tambahProduk(game1);
        store1.tambahProduk(console1);

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║            GAMESTORE 1               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("--- Katalog SEBELUM ditambah produk ---");
        store1.printInfo();
        store1.tambahProduk(acc1);
        System.out.println("\n--- Katalog SESUDAH ditambah produk ---");
        store1.printInfo();

        Customer cust1 = new Customer(1, "Andi", "andi@email.com");
        Transaction trx1 = new Transaction(5001, cust1, "2026-09-27");
        trx1.tambahDetail(game1, 1);
        System.out.println("\n--- Data Customer ---");
        cust1.printInfo();
        System.out.println("\n--- Struk SEBELUM ditambah item ---");
        trx1.printInfo();
        trx1.tambahDetail(acc1, 2);
        System.out.println("\n--- Struk SESUDAH ditambah item ---");
        trx1.printInfo();

        // ================= GameStore 2 =================
        Game game2 = new Game(201, 2, "Forza Horizon 5", 690000, 8, "Racing", "Xbox");
        Console console2 = new Console(202, 2, "Xbox Series X", 9000000, 4, "Microsoft", "1TB");
        Accessory acc2 = new Accessory(203, 2, "Xbox Wireless Controller", 900000, 12, "Controller", "Xbox");

        GameStore store2 = new GameStore();
        store2.setTokoID(2);
        store2.setNamaToko("PixelZone Jakarta");
        store2.setLokasi("Jakarta");
        store2.tambahProduk(game2);
        store2.tambahProduk(console2);

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║            GAMESTORE 2               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("--- Katalog SEBELUM ditambah produk ---");
        store2.printInfo();
        store2.tambahProduk(acc2);
        System.out.println("\n--- Katalog SESUDAH ditambah produk ---");
        store2.printInfo();

        Customer cust2 = new Customer(2, "Budi", "budi@email.com");
        Transaction trx2 = new Transaction(5002, cust2, "2026-09-28");
        trx2.tambahDetail(console2, 1);
        System.out.println("\n--- Data Customer ---");
        cust2.printInfo();
        System.out.println("\n--- Struk SEBELUM ditambah item ---");
        trx2.printInfo();
        trx2.tambahDetail(game2, 2);
        System.out.println("\n--- Struk SESUDAH ditambah item ---");
        trx2.printInfo();

        // ================= GameStore 3 =================
        Game game3 = new Game(301, 3, "Zelda: Tears of the Kingdom", 850000, 6, "Adventure", "Switch");
        Console console3 = new Console(302, 3, "Nintendo Switch OLED", 4700000, 7, "Nintendo", "64GB");
        Accessory acc3 = new Accessory(303, 3, "Joy-Con Pair", 1250000, 9, "Controller", "Switch");

        GameStore store3 = new GameStore();
        store3.setTokoID(3);
        store3.setNamaToko("Nintendo Corner Surabaya");
        store3.setLokasi("Surabaya");
        store3.tambahProduk(game3);
        store3.tambahProduk(console3);

        System.out.println("\n╔══════════════════════════════════════╗");
        System.out.println("║            GAMESTORE 3               ║");
        System.out.println("╚══════════════════════════════════════╝");
        System.out.println("--- Katalog SEBELUM ditambah produk ---");
        store3.printInfo();
        store3.tambahProduk(acc3);
        System.out.println("\n--- Katalog SESUDAH ditambah produk ---");
        store3.printInfo();

        Customer cust3 = new Customer(3, "Citra", "citra@email.com");
        Transaction trx3 = new Transaction(5003, cust3, "2026-09-29");
        trx3.tambahDetail(acc3, 1);
        System.out.println("\n--- Data Customer ---");
        cust3.printInfo();
        System.out.println("\n--- Struk SEBELUM ditambah item ---");
        trx3.printInfo();
        trx3.tambahDetail(game3, 1);
        System.out.println("\n--- Struk SESUDAH ditambah item ---");
        trx3.printInfo();

        System.out.println("\n----- Proses Destruction (otomatis saat main() selesai) -----");
        // Di C++ destructor dipanggil otomatis dengan urutan terbalik dari deklarasi.
        // Java tidak punya itu, jadi urutan yang sama dipanggil eksplisit lewat destroy().
        trx3.destroy();
        cust3.destroy();
        store3.destroy();

        trx2.destroy();
        cust2.destroy();
        store2.destroy();

        trx1.destroy();
        cust1.destroy();
        store1.destroy();
    }
}
