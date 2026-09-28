public class Accessory extends Product {
    private String jenis;
    private String kompabilitas;

    public Accessory(int productID, int tokoID, String nama, int harga, int stok,
                     String jenis, String kompabilitas) {
        super(productID, tokoID, nama, harga, stok);
        this.jenis = jenis;
        this.kompabilitas = kompabilitas;
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    // ---------- Getter ----------
    public String getJenis() { return jenis; }
    public String getKompabilitas() { return kompabilitas; }

    // ---------- Setter ----------
    public void setJenis(String jenisBaru) { jenis = jenisBaru; }
    public void setKompabilitas(String kompabilitasBaru) { kompabilitas = kompabilitasBaru; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" | Jenis: " + jenis + " | Kompabilitas: " + kompabilitas);
    }

    @Override
    public String getTipe() { return "Accessory"; }
}
