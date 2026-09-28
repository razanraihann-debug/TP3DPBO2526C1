import java.util.ArrayList;
import java.util.List;

// Relasi ke TransactionDetail = COMPOSITION + array of object.
// Transaction adalah PEMILIK detail: dibuat di tambahDetail, dihancurkan di destroy() Transaction.
public class Transaction {
    private int transactionID;
    private int pelangganID; // association ke Customer (hanya simpan ID)
    private String tanggal;
    private int totalBayar;
    private List<TransactionDetail> details = new ArrayList<>();

    public Transaction(int transactionID, Customer pelanggan, String tanggal) {
        this.transactionID = transactionID;
        this.pelangganID = pelanggan.getPelangganID();
        this.tanggal = tanggal;
        this.totalBayar = 0;
    }

    // Padanan destructor C++
    public void destroy() {
        for (TransactionDetail d : details) {
            d.destroy();
        }
        details.clear();
    }

    public void tambahDetail(Product produk, int jumlah) { // data ditambahkan secara statis dari main
        TransactionDetail d = new TransactionDetail(transactionID, produk, jumlah);
        totalBayar += d.getSubTotal();
        details.add(d);
    }

    // totalBayar adalah nilai turunan: hitung ulang dari semua subTotal detail
    public void hitungUlangTotal() {
        totalBayar = 0;
        for (TransactionDetail d : details) {
            totalBayar += d.getSubTotal();
        }
    }

    // ---------- Getter ----------
    public int getTransactionID() { return transactionID; }
    public int getPelangganID() { return pelangganID; }
    public String getTanggal() { return tanggal; }
    public int getTotalBayar() { return totalBayar; }
    public List<TransactionDetail> getDetails() { return details; }

    // ---------- Setter ----------
    public void setTransactionID(int idBaru) { transactionID = idBaru; }
    public void setPelangganID(int idBaru) { pelangganID = idBaru; }
    public void setTanggal(String tanggalBaru) { tanggal = tanggalBaru; }
    public void setTotalBayar(int totalBaru) { if (totalBaru >= 0) totalBayar = totalBaru; }

    // Karena composition: detail lama yang tidak ada di daftar baru ikut dihapus
    public void setDetails(List<TransactionDetail> detailBaru) {
        for (TransactionDetail lama : details) {
            if (!detailBaru.contains(lama)) {
                lama.destroy();
            }
        }
        details = new ArrayList<>(detailBaru);
        hitungUlangTotal();
    }

    public void printInfo() {
        System.out.println("Transaksi #" + transactionID
                + " | Tanggal: " + tanggal
                + " | PelangganID: " + pelangganID);
        System.out.println("Jumlah item: " + details.size());
        for (TransactionDetail d : details) {
            d.printInfo();
        }
        System.out.println("TOTAL BAYAR: Rp" + totalBayar);
    }
}
