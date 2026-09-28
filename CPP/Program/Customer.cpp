class Customer {
private:
    int pelangganID;
    string nama;
    string email;

public:
    Customer(int pelangganID, string nama, string email)
        : pelangganID(pelangganID), nama(nama), email(email) {}

    ~Customer() {
    }

    // ---------- Getter ----------
    int getPelangganID() const { return pelangganID; }
    string getNama() const { return nama; }
    string getEmail() const { return email; }

    // ---------- Setter ----------
    void setPelangganID(int idBaru) { pelangganID = idBaru; }
    void setNama(string namaBaru) { nama = namaBaru; }
    void setEmail(string emailBaru) { email = emailBaru; }

    void printInfo() const {
        cout << "PelangganID: " << pelangganID
             << " | Nama: " << nama
             << " | Email: " << email << "\n";
    }
};
