public class Game extends Product {
    private String genre;
    private String platform;

    public Game(int productID, int tokoID, String nama, int harga, int stok,
                String genre, String platform) {
        super(productID, tokoID, nama, harga, stok);
        this.genre = genre;
        this.platform = platform;
    }

    @Override
    public void destroy() {
        super.destroy(); // lalu destructor Product (sama seperti urutan di C++)
    }

    // ---------- Getter ----------
    public String getGenre() { return genre; }
    public String getPlatform() { return platform; }

    // ---------- Setter ----------
    public void setGenre(String genreBaru) { genre = genreBaru; }
    public void setPlatform(String platformBaru) { platform = platformBaru; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(" | Genre: " + genre + " | Platform: " + platform);
    }

    @Override
    public String getTipe() { return "Game"; }
}
