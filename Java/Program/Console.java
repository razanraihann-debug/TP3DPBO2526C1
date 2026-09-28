public class Console extends Product {
    private String brand;
    private String storage;

    public Console(int productID, int tokoID, String nama, int harga, int stok,
                   String brand, String storage) {
        super(productID, tokoID, nama, harga, stok);
        this.brand = brand;
        this.storage = storage;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    // ---------- Getter ----------
    public String getBrand() { return brand; }
    public String getStorage() { return storage; }

    // ---------- Setter ----------
    public void setBrand(String brandBaru) { brand = brandBaru; }
    public void setStorage(String storageBaru) { storage = storageBaru; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" | Brand: " + brand + " | Storage: " + storage);
    }

    @Override
    public String getTipe() { return "Console"; }
}
