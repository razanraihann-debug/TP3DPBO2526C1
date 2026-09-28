class Game : public Product {
private:
    string genre;
    string platform;

public:
    Game(int productID, int tokoID, string nama, int harga, int stok,
         string genre, string platform)
        : Product(productID, tokoID, nama, harga, stok), genre(genre), platform(platform) {}

    ~Game() override {
    }

    // ---------- Getter ----------
    string getGenre() const { return genre; }
    string getPlatform() const { return platform; }

    // ---------- Setter ----------
    void setGenre(string genreBaru) { genre = genreBaru; }
    void setPlatform(string platformBaru) { platform = platformBaru; }

    void printInfo() const override {
        Product::printInfo();
        cout << " | Genre: " << genre << " | Platform: " << platform << "\n";
    }

    string getTipe() const override { return "Game"; }
};
