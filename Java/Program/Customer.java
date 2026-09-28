public class Customer {
    private int pelangganID;
    private String nama;
    private String email;

    public Customer(int pelangganID, String nama, String email) {
        this.pelangganID = pelangganID;
        this.nama = nama;
        this.email = email;
    }

    // Padanan destructor C++
    public void destroy() {
    }

    // ---------- Getter ----------
    public int getPelangganID() { return pelangganID; }
    public String getNama() { return nama; }
    public String getEmail() { return email; }

    // ---------- Setter ----------
    public void setPelangganID(int idBaru) { pelangganID = idBaru; }
    public void setNama(String namaBaru) { nama = namaBaru; }
    public void setEmail(String emailBaru) { email = emailBaru; }

    public void printInfo() {
        System.out.println("PelangganID: " + pelangganID
                + " | Nama: " + nama
                + " | Email: " + email);
    }
}
