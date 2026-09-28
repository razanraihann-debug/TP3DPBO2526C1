// Relasi ke TransactionDetail = COMPOSITION + array of object.
// Transaction adalah PEMILIK detail: dibuat lewat new, dihapus di destructor Transaction.
class Transaction {
private:
    int transactionID;
    int pelangganID; // association ke Customer (hanya simpan ID)
    string tanggal;
    int totalBayar;
    vector<TransactionDetail*> details;

public:
    Transaction(int transactionID, Customer& pelanggan, string tanggal)
        : transactionID(transactionID), pelangganID(pelanggan.getPelangganID()),
          tanggal(tanggal), totalBayar(0) {}

    ~Transaction() {
        for (TransactionDetail* d : details) {
            delete d;
        }
        details.clear();
    }

    void tambahDetail(Product* produk, int jumlah) { // data ditambahkan secara statis dari main
        TransactionDetail* d = new TransactionDetail(transactionID, produk, jumlah);
        totalBayar += d->getSubTotal();
        details.push_back(d);
    }

    // totalBayar adalah nilai turunan: hitung ulang dari semua subTotal detail
    void hitungUlangTotal() {
        totalBayar = 0;
        for (const TransactionDetail* d : details) {
            totalBayar += d->getSubTotal();
        }
    }

    // ---------- Getter ----------
    int getTransactionID() const { return transactionID; }
    int getPelangganID() const { return pelangganID; }
    string getTanggal() const { return tanggal; }
    int getTotalBayar() const { return totalBayar; }
    const vector<TransactionDetail*>& getDetails() const { return details; }

    // ---------- Setter ----------
    void setTransactionID(int idBaru) { transactionID = idBaru; }
    void setPelangganID(int idBaru) { pelangganID = idBaru; }
    void setTanggal(string tanggalBaru) { tanggal = tanggalBaru; }
    void setTotalBayar(int totalBaru) { if (totalBaru >= 0) totalBayar = totalBaru; }

    // Karena composition: detail lama yang tidak ada di daftar baru ikut dihapus
    void setDetails(const vector<TransactionDetail*>& detailBaru) {
        for (TransactionDetail* lama : details) {
            bool masihDipakai = false;
            for (TransactionDetail* baru : detailBaru) {
                if (baru == lama) { masihDipakai = true; break; }
            }
            if (!masihDipakai) delete lama;
        }
        details = detailBaru;
        hitungUlangTotal();
    }

    void printInfo() const {
        cout << "Transaksi #" << transactionID
             << " | Tanggal: " << tanggal
             << " | PelangganID: " << pelangganID << "\n";
        cout << "Jumlah item: " << details.size() << "\n";
        for (const TransactionDetail* d : details) {
            d->printInfo();
        }
        cout << "TOTAL BAYAR: Rp" << totalBayar << "\n";
    }
};
