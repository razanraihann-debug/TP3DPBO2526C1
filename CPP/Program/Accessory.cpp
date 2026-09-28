class Accessory : public Product {
private:
    string jenis;
    string kompabilitas;

public:
    Accessory(int productID, int tokoID, string nama, int harga, int stok,
              string jenis, string kompabilitas)
        : Product(productID, tokoID, nama, harga, stok), jenis(jenis), kompabilitas(kompabilitas) {}

    ~Accessory() override {
    }

    // ---------- Getter ----------
    string getJenis() const { return jenis; }
    string getKompabilitas() const { return kompabilitas; }

    // ---------- Setter ----------
    void setJenis(string jenisBaru) { jenis = jenisBaru; }
    void setKompabilitas(string kompabilitasBaru) { kompabilitas = kompabilitasBaru; }

    void printInfo() const override {
        Product::printInfo();
        cout << " | Jenis: " << jenis << " | Kompabilitas: " << kompabilitas << "\n";
    }

    string getTipe() const override { return "Accessory"; }
};
