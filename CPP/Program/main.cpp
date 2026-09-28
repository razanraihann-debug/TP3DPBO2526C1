#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Urutan include PENTING (tanpa include guard): class induk/dependensi harus lebih dulu.
#include "Product.cpp"
#include "Game.cpp"
#include "Console.cpp"
#include "Accessory.cpp"
#include "GameStore.cpp"
#include "Customer.cpp"
#include "TransactionDetail.cpp"
#include "Transaction.cpp"

int main() {
    // ================= GameStore 1 =================
    // Produk dibuat dengan new karena GameStore adalah PEMILIK (composition)
    // dan akan menghapusnya sendiri di destructor.
    Game* game1 = new Game(101, 1, "Elden Ring", 750000, 10, "RPG", "PS5");
    Console* console1 = new Console(102, 1, "PlayStation 5", 8500000, 5, "Sony", "1TB");
    Accessory* acc1 = new Accessory(103, 1, "DualSense Controller", 950000, 15, "Controller", "PS5");

    GameStore store1;
    store1.setTokoID(1);
    store1.setNamaToko("GameHub Bandung");
    store1.setLokasi("Bandung");
    store1.tambahProduk(game1);
    store1.tambahProduk(console1);

    cout << "╔══════════════════════════════════════╗\n";
    cout << "║            GAMESTORE 1               ║\n";
    cout << "╚══════════════════════════════════════╝\n";
    cout << "--- Katalog SEBELUM ditambah produk ---\n";
    store1.printInfo();
    store1.tambahProduk(acc1);
    cout << "\n--- Katalog SESUDAH ditambah produk ---\n";
    store1.printInfo();

    Customer cust1(1, "Andi", "andi@email.com");
    Transaction trx1(5001, cust1, "2026-09-27");
    trx1.tambahDetail(game1, 1);
    cout << "\n--- Data Customer ---\n";
    cust1.printInfo();
    cout << "\n--- Struk SEBELUM ditambah item ---\n";
    trx1.printInfo();
    trx1.tambahDetail(acc1, 2);
    cout << "\n--- Struk SESUDAH ditambah item ---\n";
    trx1.printInfo();


    // ================= GameStore 2 =================
    Game* game2 = new Game(201, 2, "Forza Horizon 5", 690000, 8, "Racing", "Xbox");
    Console* console2 = new Console(202, 2, "Xbox Series X", 9000000, 4, "Microsoft", "1TB");
    Accessory* acc2 = new Accessory(203, 2, "Xbox Wireless Controller", 900000, 12, "Controller", "Xbox");

    GameStore store2;
    store2.setTokoID(2);
    store2.setNamaToko("PixelZone Jakarta");
    store2.setLokasi("Jakarta");
    store2.tambahProduk(game2);
    store2.tambahProduk(console2);

    cout << "\n╔══════════════════════════════════════╗\n";
    cout << "║            GAMESTORE 2               ║\n";
    cout << "╚══════════════════════════════════════╝\n";
    cout << "--- Katalog SEBELUM ditambah produk ---\n";
    store2.printInfo();
    store2.tambahProduk(acc2);
    cout << "\n--- Katalog SESUDAH ditambah produk ---\n";
    store2.printInfo();

    Customer cust2(2, "Budi", "budi@email.com");
    Transaction trx2(5002, cust2, "2026-09-28");
    trx2.tambahDetail(console2, 1);
    cout << "\n--- Data Customer ---\n";
    cust2.printInfo();
    cout << "\n--- Struk SEBELUM ditambah item ---\n";
    trx2.printInfo();
    trx2.tambahDetail(game2, 2);
    cout << "\n--- Struk SESUDAH ditambah item ---\n";
    trx2.printInfo();


    // ================= GameStore 3 =================
    Game* game3 = new Game(301, 3, "Zelda: Tears of the Kingdom", 850000, 6, "Adventure", "Switch");
    Console* console3 = new Console(302, 3, "Nintendo Switch OLED", 4700000, 7, "Nintendo", "64GB");
    Accessory* acc3 = new Accessory(303, 3, "Joy-Con Pair", 1250000, 9, "Controller", "Switch");

    GameStore store3;
    store3.setTokoID(3);
    store3.setNamaToko("Nintendo Corner Surabaya");
    store3.setLokasi("Surabaya");
    store3.tambahProduk(game3);
    store3.tambahProduk(console3);

    cout << "\n╔══════════════════════════════════════╗\n";
    cout << "║            GAMESTORE 3               ║\n";
    cout << "╚══════════════════════════════════════╝\n";
    cout << "--- Katalog SEBELUM ditambah produk ---\n";
    store3.printInfo();
    store3.tambahProduk(acc3);
    cout << "\n--- Katalog SESUDAH ditambah produk ---\n";
    store3.printInfo();

    Customer cust3(3, "Citra", "citra@email.com");
    Transaction trx3(5003, cust3, "2026-09-29");
    trx3.tambahDetail(acc3, 1);
    cout << "\n--- Data Customer ---\n";
    cust3.printInfo();
    cout << "\n--- Struk SEBELUM ditambah item ---\n";
    trx3.printInfo();
    trx3.tambahDetail(game3, 1);
    cout << "\n--- Struk SESUDAH ditambah item ---\n";
    trx3.printInfo();

    cout << "\n----- Proses Destruction (otomatis saat main() selesai) -----\n";
    return 0;
}
