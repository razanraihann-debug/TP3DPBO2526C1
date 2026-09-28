class Console : public Product {
private:
    string brand;
    string storage;

public:
    Console(int productID, int tokoID, string nama, int harga, int stok,
            string brand, string storage)
        : Product(productID, tokoID, nama, harga, stok), brand(brand), storage(storage) {}

    ~Console() override {
    }

    // ---------- Getter ----------
    string getBrand() const { return brand; }
    string getStorage() const { return storage; }

    // ---------- Setter ----------
    void setBrand(string brandBaru) { brand = brandBaru; }
    void setStorage(string storageBaru) { storage = storageBaru; }

    void printInfo() const override {
        Product::printInfo();
        cout << " | Brand: " << brand << " | Storage: " << storage << "\n";
    }

    string getTipe() const override { return "Console"; }
};
