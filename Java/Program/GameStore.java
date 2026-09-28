import java.util.ArrayList;
import java.util.List;

// Relasi ke Product = COMPOSITION + array of object.
// GameStore adalah PEMILIK produk: semua Product dihancurkan sendiri oleh GameStore di destroy().
public class GameStore {
    private int tokoID;
    private String namaToko;
    private String lokasi;
    private List<Product> daftarProduk = new ArrayList<>();

    public GameStore() {
        this(0, "", "");
    }

    public GameStore(int tokoID, String namaToko, String lokasi) {
        this.tokoID = tokoID;
        this.namaToko = namaToko;
        this.lokasi = lokasi;
    }

    // Padanan destructor C++
    public void destroy() {
        for (Product p : daftarProduk) {
            p.destroy(); // polimorfik: destroy Game/Console/Accessory lalu Product
        }
        daftarProduk.clear();
    }

    public void tambahProduk(Product p) { // data ditambahkan secara statis dari main
        daftarProduk.add(p);
    }

    // ---------- Getter ----------
    public int getTokoID() { return tokoID; }
    public String getNamaToko() { return namaToko; }
    public String getLokasi() { return lokasi; }
    public List<Product> getDaftarProduk() { return daftarProduk; }

    // ---------- Setter ----------
    public void setTokoID(int idBaru) { tokoID = idBaru; }
    public void setNamaToko(String namaBaru) { namaToko = namaBaru; }
    public void setLokasi(String lokasiBaru) { lokasi = lokasiBaru; }

    // Karena composition: produk lama yang tidak ada di daftar baru ikut dihapus
    public void setDaftarProduk(List<Product> daftarBaru) {
        for (Product lama : daftarProduk) {
            if (!daftarBaru.contains(lama)) {
                lama.destroy();
            }
        }
        daftarProduk = new ArrayList<>(daftarBaru);
    }

    public void printInfo() {
        System.out.println("GameStore: " + namaToko + " (TokoID:" + tokoID
                + ", Lokasi: " + lokasi + ")");
        System.out.println("Jumlah produk: " + daftarProduk.size());
        for (Product p : daftarProduk) {
            p.printInfo();
        }
    }
}
