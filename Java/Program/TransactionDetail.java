// Relasi ke Product = ASSOCIATION -> hanya mengambil data (productID, nama, harga)
// saat dibuat, tidak menyimpan/mengelola referensi Product-nya
public class TransactionDetail {
    private int transactionID;
    private int productID;
    private String namaProduk;
    private int jumlah;
    private int subTotal;

    public TransactionDetail(int transactionID, Product produk, int jumlah) {
        this.transactionID = transactionID;
        this.productID = produk.getProductID();
        this.namaProduk = produk.getNama();
        this.jumlah = jumlah;
        this.subTotal = produk.getHarga() * jumlah;
        produk.kurangiStok(jumlah);
    }

    // Padanan destructor C++
    public void destroy() {
    }

    // ---------- Getter ----------
    public int getTransactionID() { return transactionID; }
    public int getProductID() { return productID; }
    public String getNamaProduk() { return namaProduk; }
    public int getJumlah() { return jumlah; }
    public int getSubTotal() { return subTotal; }

    // ---------- Setter ----------
    public void setTransactionID(int idBaru) { transactionID = idBaru; }
    public void setProductID(int idBaru) { productID = idBaru; }
    public void setNamaProduk(String namaBaru) { namaProduk = namaBaru; }
    public void setJumlah(int jumlahBaru) { if (jumlahBaru > 0) jumlah = jumlahBaru; }
    public void setSubTotal(int subTotalBaru) { if (subTotalBaru >= 0) subTotal = subTotalBaru; }

    public void printInfo() {
        System.out.println("  - ProductID: " + productID
                + " | Nama: " + namaProduk
                + " | Jumlah: " + jumlah
                + " | SubTotal: Rp" + subTotal);
    }
}
