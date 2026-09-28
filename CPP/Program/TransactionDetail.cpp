// Relasi ke Product = ASSOCIATION -> hanya mengambil data (productID, nama, harga)
// saat dibuat, tidak menyimpan/mengelola pointer Product-nya
class TransactionDetail {
private:
    int transactionID;
    int productID;
    string namaProduk;
    int jumlah;
    int subTotal;

public:
    TransactionDetail(int transactionID, Product* produk, int jumlah)
        : transactionID(transactionID), productID(produk->getProductID()),
          namaProduk(produk->getNama()), jumlah(jumlah) {
        subTotal = produk->getHarga() * jumlah;
        produk->kurangiStok(jumlah);
    }

    ~TransactionDetail() {
    }

    // ---------- Getter ----------
    int getTransactionID() const { return transactionID; }
    int getProductID() const { return productID; }
    string getNamaProduk() const { return namaProduk; }
    int getJumlah() const { return jumlah; }
    int getSubTotal() const { return subTotal; }

    // ---------- Setter ----------
    void setTransactionID(int idBaru) { transactionID = idBaru; }
    void setProductID(int idBaru) { productID = idBaru; }
    void setNamaProduk(string namaBaru) { namaProduk = namaBaru; }
    void setJumlah(int jumlahBaru) { if (jumlahBaru > 0) jumlah = jumlahBaru; }
    void setSubTotal(int subTotalBaru) { if (subTotalBaru >= 0) subTotal = subTotalBaru; }

    void printInfo() const {
        cout << "  - ProductID: " << productID
             << " | Nama: " << namaProduk
             << " | Jumlah: " << jumlah
             << " | SubTotal: Rp" << subTotal << "\n";
    }
};
