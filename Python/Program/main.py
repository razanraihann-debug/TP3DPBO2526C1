from Game import Game
from Console import Console
from Accessory import Accessory
from GameStore import GameStore
from Customer import Customer
from Transaction import Transaction


def main():
    # ================= GameStore 1 =================
    game1 = Game(101, 1, "Elden Ring", 750000, 10, "RPG", "PS5")
    console1 = Console(102, 1, "PlayStation 5", 8500000, 5, "Sony", "1TB")
    acc1 = Accessory(103, 1, "DualSense Controller", 950000, 15, "Controller", "PS5")

    store1 = GameStore()
    store1.setTokoID(1)
    store1.setNamaToko("GameHub Bandung")
    store1.setLokasi("Bandung")
    store1.tambahProduk(game1)
    store1.tambahProduk(console1)

    print("╔══════════════════════════════════════╗")
    print("║            GAMESTORE 1               ║")
    print("╚══════════════════════════════════════╝")
    print("--- Katalog SEBELUM ditambah produk ---")
    store1.printInfo()
    store1.tambahProduk(acc1)
    print("\n--- Katalog SESUDAH ditambah produk ---")
    store1.printInfo()

    cust1 = Customer(1, "Andi", "andi@email.com")
    trx1 = Transaction(5001, cust1, "2026-09-27")
    trx1.tambahDetail(game1, 1)
    print("\n--- Data Customer ---")
    cust1.printInfo()
    print("\n--- Struk SEBELUM ditambah item ---")
    trx1.printInfo()
    trx1.tambahDetail(acc1, 2)
    print("\n--- Struk SESUDAH ditambah item ---")
    trx1.printInfo()

    # ================= GameStore 2 =================
    game2 = Game(201, 2, "Forza Horizon 5", 690000, 8, "Racing", "Xbox")
    console2 = Console(202, 2, "Xbox Series X", 9000000, 4, "Microsoft", "1TB")
    acc2 = Accessory(203, 2, "Xbox Wireless Controller", 900000, 12, "Controller", "Xbox")

    store2 = GameStore()
    store2.setTokoID(2)
    store2.setNamaToko("PixelZone Jakarta")
    store2.setLokasi("Jakarta")
    store2.tambahProduk(game2)
    store2.tambahProduk(console2)

    print("\n╔══════════════════════════════════════╗")
    print("║            GAMESTORE 2               ║")
    print("╚══════════════════════════════════════╝")
    print("--- Katalog SEBELUM ditambah produk ---")
    store2.printInfo()
    store2.tambahProduk(acc2)
    print("\n--- Katalog SESUDAH ditambah produk ---")
    store2.printInfo()

    cust2 = Customer(2, "Budi", "budi@email.com")
    trx2 = Transaction(5002, cust2, "2026-09-28")
    trx2.tambahDetail(console2, 1)
    print("\n--- Data Customer ---")
    cust2.printInfo()
    print("\n--- Struk SEBELUM ditambah item ---")
    trx2.printInfo()
    trx2.tambahDetail(game2, 2)
    print("\n--- Struk SESUDAH ditambah item ---")
    trx2.printInfo()

    # ================= GameStore 3 =================
    game3 = Game(301, 3, "Zelda: Tears of the Kingdom", 850000, 6, "Adventure", "Switch")
    console3 = Console(302, 3, "Nintendo Switch OLED", 4700000, 7, "Nintendo", "64GB")
    acc3 = Accessory(303, 3, "Joy-Con Pair", 1250000, 9, "Controller", "Switch")

    store3 = GameStore()
    store3.setTokoID(3)
    store3.setNamaToko("Nintendo Corner Surabaya")
    store3.setLokasi("Surabaya")
    store3.tambahProduk(game3)
    store3.tambahProduk(console3)

    print("\n╔══════════════════════════════════════╗")
    print("║            GAMESTORE 3               ║")
    print("╚══════════════════════════════════════╝")
    print("--- Katalog SEBELUM ditambah produk ---")
    store3.printInfo()
    store3.tambahProduk(acc3)
    print("\n--- Katalog SESUDAH ditambah produk ---")
    store3.printInfo()

    cust3 = Customer(3, "Citra", "citra@email.com")
    trx3 = Transaction(5003, cust3, "2026-09-29")
    trx3.tambahDetail(acc3, 1)
    print("\n--- Data Customer ---")
    cust3.printInfo()
    print("\n--- Struk SEBELUM ditambah item ---")
    trx3.printInfo()
    trx3.tambahDetail(game3, 1)
    print("\n--- Struk SESUDAH ditambah item ---")
    trx3.printInfo()

if __name__ == "__main__":
    main()
