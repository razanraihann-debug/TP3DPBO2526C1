# Relasi ke Product = COMPOSITION + array of object.
# GameStore adalah PEMILIK produk: semua Product dihapus sendiri oleh GameStore di destructor-nya.
class GameStore:
    # Nilai default menggantikan dua constructor C++ (kosong & berparameter)
    def __init__(self, tokoID=0, namaToko="", lokasi=""):
        self._tokoID = tokoID
        self._namaToko = namaToko
        self._lokasi = lokasi
        self._daftarProduk = []

    def __del__(self):
        # pop(0) berulang: produk dilepas & dihancurkan satu per satu dari yang pertama
        while len(self._daftarProduk) > 0:
            self._daftarProduk.pop(0)

    def tambahProduk(self, p):  # data ditambahkan secara statis dari main
        self._daftarProduk.append(p)

    # ---------- Getter ----------
    def getTokoID(self):
        return self._tokoID

    def getNamaToko(self):
        return self._namaToko

    def getLokasi(self):
        return self._lokasi

    def getDaftarProduk(self):
        return self._daftarProduk

    # ---------- Setter ----------
    def setTokoID(self, idBaru):
        self._tokoID = idBaru

    def setNamaToko(self, namaBaru):
        self._namaToko = namaBaru

    def setLokasi(self, lokasiBaru):
        self._lokasi = lokasiBaru

    # Karena composition: produk lama yang tidak ada di daftar baru ikut dihapus
    def setDaftarProduk(self, daftarBaru):
        lama = self._daftarProduk
        self._daftarProduk = list(daftarBaru)
        while len(lama) > 0:
            lama.pop(0)

    def printInfo(self):
        print(f"GameStore: {self._namaToko} (TokoID:{self._tokoID}, Lokasi: {self._lokasi})")
        print(f"Jumlah produk: {len(self._daftarProduk)}")
        for p in self._daftarProduk:
            p.printInfo()
