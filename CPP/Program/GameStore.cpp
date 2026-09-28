// Relasi ke Product = COMPOSITION + array of object.
// GameStore adalah PEMILIK produk: semua Product dibuat lewat new,
// lalu dihapus sendiri oleh GameStore di destructor-nya.
class GameStore {
private:
    int tokoID;
    string namaToko;
    string lokasi;
    vector<Product*> daftarProduk;

public:
    GameStore() : tokoID(0), namaToko(""), lokasi("") {}

    GameStore(int tokoID, string namaToko, string lokasi)
        : tokoID(tokoID), namaToko(namaToko), lokasi(lokasi) {}

    ~GameStore() {
        for (Product* p : daftarProduk) {
            delete p; // polimorfik: memanggil destructor Game/Console/Accessory lalu Product
        }
        daftarProduk.clear();
    }

    void tambahProduk(Product* p) { // data ditambahkan secara statis dari main
        daftarProduk.push_back(p);
    }

    // ---------- Getter ----------
    int getTokoID() const { return tokoID; }
    string getNamaToko() const { return namaToko; }
    string getLokasi() const { return lokasi; }
    const vector<Product*>& getDaftarProduk() const { return daftarProduk; }

    // ---------- Setter ----------
    void setTokoID(int idBaru) { tokoID = idBaru; }
    void setNamaToko(string namaBaru) { namaToko = namaBaru; }
    void setLokasi(string lokasiBaru) { lokasi = lokasiBaru; }

    // Karena composition: produk lama yang tidak ada di daftar baru ikut dihapus
    void setDaftarProduk(const vector<Product*>& daftarBaru) {
        for (Product* lama : daftarProduk) {
            bool masihDipakai = false;
            for (Product* baru : daftarBaru) {
                if (baru == lama) { masihDipakai = true; break; }
            }
            if (!masihDipakai) delete lama;
        }
        daftarProduk = daftarBaru;
    }

    void printInfo() const {
        cout << "GameStore: " << namaToko << " (TokoID:" << tokoID
             << ", Lokasi: " << lokasi << ")\n";
        cout << "Jumlah produk: " << daftarProduk.size() << "\n";
        for (const Product* p : daftarProduk) {
            p->printInfo();
        }
    }
};
