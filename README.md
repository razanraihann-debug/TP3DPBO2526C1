# JANJI
Saya Razan Raihan Malik dengan NIM 2508838 mengerjakan Tugas Praktikum 3 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

# STRUKTUR FILE
<img width="269" height="682" alt="Screenshot 2026-09-28 at 21 44 36" src="https://github.com/user-attachments/assets/dca2a8a8-92bb-475d-b932-9c3950b5192e" />

# DIAGRAM
<img width="778" height="810" alt="Diagram drawio" src="https://github.com/user-attachments/assets/886dcade-2f2b-47ca-adfc-56a029511e47" />

# ATRIBUT DAN METHOD SETIAP KELAS
- Product (abstract class):
  - Atribut:
    1. productID:	ID unik produk
    2. tokoID: ID toko pemilik produk
    3. nama: Nama produk
    4. harga: Harga satuan (Rp)
    5. stok: Jumlah stok
  - Method:
    1. Constructor dan destructor: Product(...) dan virtual ~Product().
    2. Getter: getProductID, getTokoID, getNama, getHarga, getStok.
    3. Setter: setProductID, setTokoID, setNama, setHarga (menolak nilai negatif), setStok (menolak nilai negatif).
    4. kurangiStok(jumlah): mengurangi stok kalau jumlahnya tidak melebihi stok.
    5. virtual printInfo(): mencetak data umum (tipe, ID, nama, harga, stok), lalu dilengkapi oleh class turunan.
    6. virtual getTipe() = 0: pure virtual. Karena method ini, Product menjadi abstract dan tidak bisa dibuat langsung.
- Game (turunan Product):
  - Atribut:
    1. genre: Genre game
    2. platform: Platform game
  - Method:
    1. Constructor dan destructor: Game(...) dan ~Game(). Constructor memanggil constructor Product, destructor mencetak pesan lalu destructor Product berjalan otomatis.
    2. Getter: getGenre, getPlatform.
    3. Setter: setGenre, setPlatform.
    4. printInfo() (override): memanggil Product::printInfo(), lalu menambahkan genre dan platform.
    5. getTipe() (override): mengembalikan "Game".
- Console (turunan Product):
  - Atribut:
    1. brand: Merek console
    2. storage: Kapasitas penyimpanan
  - Method:
    1. Constructor dan destructor: Console(...) dan ~Console(). Constructor memanggil constructor Product, destructor mencetak pesan lalu destructor Product berjalan otomatis.
    2. Getter: getBrand, getStorage.
    3. Setter: setBrand, setStorage.
    4. printInfo() (override): memanggil Product::printInfo(), lalu menambahkan brand dan storage.
    5. getTipe() (override): mengembalikan "Console".
- Accessory (turunan Product):
  - Atribut:
    1. jenis: Jenis aksesoris
    2. kompabilitas: Platform atau perangkat yang kompatibel
  - Method:
    1. Constructor dan destructor: Accessory(...) dan ~Accessory(). Constructor memanggil constructor Product, destructor mencetak pesan lalu destructor Product berjalan otomatis.
    2. Getter: getJenis, getKompabilitas.
    3. Setter: setJenis, setKompabilitas.
    4. printInfo() (override): memanggil Product::printInfo(), lalu menambahkan jenis dan kompabilitas.
    5. getTipe() (override): mengembalikan "Accessory".
- GameStore:
  - Atribut:
    1. tokoID: ID toko
    2. namaToko: Nama toko
    3. lokasi: Lokasi toko
    4. daftarProduk: Array produk yang dimiliki toko (vector<Product*>)
  - Method:
    1. Constructor dan destructor: GameStore() (kosong), GameStore(tokoID, namaToko, lokasi), dan ~GameStore(). Destructor mencetak pesan, lalu menghapus semua produk di daftarProduk dan mengosongkan vector-nya.
    2. tambahProduk(p): menambah produk ke daftarProduk.
    3. Getter: getTokoID, getNamaToko, getLokasi, getDaftarProduk.
    4. Setter: setTokoID, setNamaToko, setLokasi, setDaftarProduk (menghapus produk lama yang tidak ada di daftar baru).
    5. printInfo(): mencetak identitas toko dan jumlah produk, lalu memanggil printInfo() tiap produk.
- Customer:
  - Atribut:
    1. pelangganID: ID pelanggan
    2. nama: Nama pelanggan
    3. email: Email pelanggan
  - Method:
    1. Constructor dan destructor: Customer(...) dan ~Customer().
    2. Getter: getPelangganID, getNama, getEmail.
    3. Setter: setPelangganID, setNama, setEmail.
    4. printInfo(): mencetak data pelanggan.
- TransactionDetail:
  - Atribut:
    1. transactionID: ID transaksi induk
    2. productID: ID produk yang dibeli
    3. namaProduk: Nama produk (disalin saat dibuat)
    4. jumlah: Jumlah yang dibeli
    5. subTotal: Harga × jumlah
  - Method:
    1. Constructor dan destructor: TransactionDetail(transactionID, Product*, jumlah) dan ~TransactionDetail(). Constructor mengambil productID, nama, dan harga dari produk, menghitung subTotal, lalu memanggil kurangiStok(jumlah).
    2. Getter: getTransactionID, getProductID, getNamaProduk, getJumlah, getSubTotal.
    3. Setter: setTransactionID, setProductID, setNamaProduk, setJumlah (harus lebih dari 0), setSubTotal (menolak nilai negatif).
    4. printInfo(): mencetak satu baris item.
- Transaction:
  - Atribut:
    1. transactionID: ID transaksi
    2. pelangganID: ID pelanggan (hanya ID, bukan objek Customer)
    3. tanggal: Tanggal transaksi
    4. totalBayar: Total seluruh subTotal
    5. details: Daftar item transaksi (vector<TransactionDetail*>)
  - Method:
    1. Constructor dan destructor: Transaction(transactionID, Customer&, tanggal) dan ~Transaction(). Constructor mengambil pelangganID dari customer dan mengisi totalBayar dengan 0. Destructor mencetak pesan, lalu menghapus semua detail.
    2. tambahDetail(produk, jumlah): membuat TransactionDetail baru, menambahkannya ke daftar, dan menambah totalBayar.
    3. hitungUlangTotal(): menghitung ulang totalBayar dari semua subTotal detail.
    4. Getter: getTransactionID, getPelangganID, getTanggal, getTotalBayar, getDetails.
    5. Setter: setTransactionID, setPelangganID, setTanggal, setTotalBayar (menolak nilai negatif), setDetails (menghapus detail lama yang tidak ada di daftar baru, lalu memanggil hitungUlangTotal()).
    6. printInfo(): mencetak header transaksi, semua item, dan total bayar.

# DESAIN
- Inheritance (hierarchical): Product → Game, Console, Accessory
- Composition: GameStore → Product (1 : banyak)
- Composition: Transaction → TransactionDetail (1 : banyak)
- Association: Customer → Transaction (1 : banyak)
- Association: TransactionDetail → Product (banyak : 1)

# FLOW CODE
  Flow code main()
  - Mulai program
  Fungsi main() dijalankan.
  - Diulang untuk GameStore 1, 2, dan 3 (isi tiap perulangan sama, hanya datanya beda)
  Buat 3 objek Product dengan new: Game, Console, Accessory.
  Buat objek GameStore kosong, lalu isi tokoID, namaToko, lokasi lewat setter.
  tambahProduk() dipanggil 2 kali: masukkan Game dan Console ke daftarProduk.
  printInfo() dipanggil pada GameStore → cetak katalog SEBELUM Accessory ditambahkan.
  tambahProduk() dipanggil sekali lagi: masukkan Accessory.
  printInfo() dipanggil lagi pada GameStore → cetak katalog SESUDAH Accessory ditambahkan.
  Buat objek Customer.
  printInfo() dipanggil pada Customer → cetak data pelanggan.
  Buat objek Transaction, lalu tambahDetail() dipanggil sekali: masukkan 1 item pertama.
  printInfo() dipanggil pada Transaction → cetak struk SEBELUM item kedua ditambahkan.
  tambahDetail() dipanggil lagi: masukkan item kedua.
  printInfo() dipanggil lagi pada Transaction → cetak struk SESUDAH item kedua ditambahkan.
  - Destruction (di akhir main)
  Setiap variabel lokal dihapus otomatis dengan urutan terbalik dari deklarasi.
  Untuk tiap toko: Transaction dihapus dulu (destructor Transaction ikut menghapus semua TransactionDetail miliknya).
  Lalu Customer dihapus.
  Lalu GameStore dihapus (destructor GameStore ikut menghapus semua Product miliknya: Game, Console, Accessory — destructor anak jalan dulu, baru destructor Product karena   virtual).
  Urutan penghapusan toko: GameStore 3 → GameStore 2 → GameStore 1 (kebalikan urutan pembuatan).
  - Program selesai
  return 0.

# DOKUMENTASI
# CPP
<img width="880" height="490" alt="cpp1" src="https://github.com/user-attachments/assets/106037bd-bce7-4675-a451-3b9a428eb011" />
<img width="880" height="982" alt="cpp2" src="https://github.com/user-attachments/assets/0f0a16e8-4e0a-4d78-9bbf-89eafd9dc132" />

# Java
<img width="880" height="497" alt="java1" src="https://github.com/user-attachments/assets/1a4e96b1-8228-4399-9c26-2118d30d4069" />
<img width="880" height="982" alt="java2" src="https://github.com/user-attachments/assets/a5960108-1a72-4dff-9d4e-17773851dab0" />

# Python
<img width="880" height="490" alt="py1" src="https://github.com/user-attachments/assets/f7b0537a-da2f-4408-b125-1326048155cd" />
<img width="880" height="948" alt="py2" src="https://github.com/user-attachments/assets/f1278bc7-452f-4d77-8601-7f797fbd6c2e" />
