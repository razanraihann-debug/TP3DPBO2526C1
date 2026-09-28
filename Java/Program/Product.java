// Product = abstract class (punya abstract method -> tidak bisa diinstansiasi langsung)
public abstract class Product {
    protected int productID;
    protected int tokoID;
    protected String nama;
    protected int harga;
    protected int stok;

    public Product(int productID, int tokoID, String nama, int harga, int stok) {
        this.productID = productID;
        this.tokoID = tokoID;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Java tidak punya destructor yang deterministik, jadi destroy() dipanggil manual
    // sebagai padanan destructor C++.
    public void destroy() {
    }

    // ---------- Getter ----------
    public int getProductID() { return productID; }
    public int getTokoID() { return tokoID; }
    public String getNama() { return nama; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }

    // ---------- Setter ----------
    public void setProductID(int idBaru) { productID = idBaru; }
    public void setTokoID(int idBaru) { tokoID = idBaru; }
    public void setNama(String namaBaru) { nama = namaBaru; }
    public void setHarga(int hargaBaru) { if (hargaBaru >= 0) harga = hargaBaru; } // tidak boleh negatif
    public void setStok(int stokBaru) { if (stokBaru >= 0) stok = stokBaru; }      // tidak boleh negatif

    public void kurangiStok(int jumlah) {
        if (jumlah <= stok) stok -= jumlah;
    }

    // Mencetak data umum; subclass meng-override untuk menambah data khususnya
    public void printInfo() {
        System.out.print("  [" + getTipe() + "] ID:" + productID
                + " | Nama: " + nama
                + " | Harga: Rp" + harga
                + " | Stok: " + stok);
    }

    // Abstract method -> membuat Product jadi abstract class / mirip interface
    public abstract String getTipe();
}
