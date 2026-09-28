# JANJI
Saya Razan Raihan Malik dengan NIM 2508838 mengerjakan Tugas Praktikum 3 pada Mata Kuliah Desain dan Pemrograman Berorientasi Objek (DPBO) untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin

# STRUKTUR FILE

# DIAGRAM
<img width="763" height="780" alt="Diagram TP3 drawio" src="https://github.com/user-attachments/assets/39f08812-b0f4-4e57-827b-f31b31689912" />

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
- Game, Console, Accessory (turunan Product):
  Kelas	Atribut tambahan	Method khusus
  Game	- genre, - platform (string)	getGenre/setGenre, getPlatform/setPlatform
  Console	- brand, - storage (string)	getBrand/setBrand, getStorage/setStorage
  Accessory	- jenis, - kompabilitas (string)	getJenis/setJenis, getKompabilitas/setKompabilitas

Ketiganya punya pola method yang sama:

Constructor memanggil constructor Product, lalu mengisi atribut miliknya.
Destructor mencetak pesan class-nya sendiri, lalu destructor Product berjalan otomatis.
printInfo() meng-override versi induk: memanggil Product::printInfo() dulu, lalu menambahkan data khususnya.
getTipe() meng-override method abstract dan mengembalikan "Game", "Console", atau "Accessory".
GameStore
Atribut	Tipe	Keterangan
- tokoID	int	ID toko
- namaToko	string	Nama toko
- lokasi	string	Lokasi toko
- daftarProduk	vector<Product*>	Array produk yang dimiliki toko
Constructor: dua versi, yaitu kosong GameStore() dan berparameter GameStore(tokoID, namaToko, lokasi).
Destructor: mencetak pesan, lalu delete semua produk di daftarProduk dan mengosongkan vector-nya.
tambahProduk(p): menambah produk ke daftar.
Getter: getTokoID, getNamaToko, getLokasi, getDaftarProduk.
Setter: setTokoID, setNamaToko, setLokasi, setDaftarProduk. Yang terakhir menghapus produk lama yang tidak ada di daftar baru.
printInfo(): mencetak identitas toko dan jumlah produk, lalu memanggil printInfo() tiap produk.
Customer
Atribut	Tipe
- pelangganID	int
- nama	string
- email	string
Method: constructor, destructor, getter dan setter untuk ketiga atribut, dan printInfo().
TransactionDetail
Atribut	Tipe	Keterangan
- transactionID	int	ID transaksi induk
- productID	int	ID produk yang dibeli
- namaProduk	string	Nama produk (disalin saat dibuat)
- jumlah	int	Jumlah yang dibeli
- subTotal	int	Harga × jumlah
Constructor (transactionID, Product*, jumlah): mengambil productID, nama, dan harga dari produk, menghitung subTotal, lalu memanggil produk->kurangiStok(jumlah).
Destructor: mencetak pesan.
Getter dan setter untuk semua atribut. setJumlah harus lebih dari 0, dan setSubTotal tidak boleh negatif.
printInfo(): mencetak satu baris item.
Transaction
Atribut	Tipe	Keterangan
- transactionID	int	ID transaksi
- pelangganID	int	ID pelanggan (hanya ID, bukan objek Customer)
- tanggal	string	Tanggal transaksi
- totalBayar	int	Total seluruh subTotal
- details	vector<TransactionDetail*>	Daftar item transaksi
Constructor (transactionID, Customer&, tanggal): mengambil pelangganID dari customer, dan totalBayar dimulai dari 0.
Destructor: mencetak pesan, lalu delete semua detail.
tambahDetail(produk, jumlah): membuat TransactionDetail baru, menambahkannya ke daftar, dan menambah totalBayar.
hitungUlangTotal(): menghitung ulang totalBayar dari semua subTotal detail. Diperlukan karena totalBayar adalah nilai turunan.
Getter: getTransactionID, getPelangganID, getTanggal, getTotalBayar, getDetails.
Setter: setTransactionID, setPelangganID, setTanggal, setTotalBayar, setDetails. Yang terakhir menghapus detail lama yang tidak ada di daftar baru, lalu memanggil hitungUlangTotal().
printInfo(): mencetak header transaksi, semua item, dan total bayar.
# DESAIN

# FLOW CODE

# DOKUMENTASI
# CPP

# Java

# Python

# PHP
