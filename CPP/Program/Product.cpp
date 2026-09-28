// Product = abstract class (punya pure virtual function -> tidak bisa diinstansiasi langsung)
class Product {
protected:
    int productID;
    int tokoID;
    string nama;
    int harga;
    int stok;

public:
    Product(int productID, int tokoID, string nama, int harga, int stok)
        : productID(productID), tokoID(tokoID), nama(nama), harga(harga), stok(stok) {}

    // virtual destructor: wajib supaya "delete" lewat pointer Product*
    // ikut memanggil destructor Game/Console/Accessory
    virtual ~Product() {
    }

    // ---------- Getter ----------
    int getProductID() const { return productID; }
    int getTokoID() const { return tokoID; }
    string getNama() const { return nama; }
    int getHarga() const { return harga; }
    int getStok() const { return stok; }

    // ---------- Setter ----------
    void setProductID(int idBaru) { productID = idBaru; }
    void setTokoID(int idBaru) { tokoID = idBaru; }
    void setNama(string namaBaru) { nama = namaBaru; }
    void setHarga(int hargaBaru) { if (hargaBaru >= 0) harga = hargaBaru; } // tidak boleh negatif
    void setStok(int stokBaru) { if (stokBaru >= 0) stok = stokBaru; }      // tidak boleh negatif

    void kurangiStok(int jumlah) {
        if (jumlah <= stok) stok -= jumlah;
    }

    // Mencetak data umum; subclass meng-override untuk menambah data khususnya
    virtual void printInfo() const {
        cout << "  [" << getTipe() << "] ID:" << productID
             << " | Nama: " << nama
             << " | Harga: Rp" << harga
             << " | Stok: " << stok;
    }

    // Pure virtual function -> membuat Product jadi abstract class / mirip interface
    virtual string getTipe() const = 0;
};
