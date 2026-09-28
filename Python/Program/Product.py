from abc import ABC, abstractmethod


# Product = abstract class (punya abstract method -> tidak bisa diinstansiasi langsung)
class Product(ABC):
    def __init__(self, productID, tokoID, nama, harga, stok):
        self._productID = productID
        self._tokoID = tokoID
        self._nama = nama
        self._harga = harga
        self._stok = stok

    # ---------- Getter ----------
    def getProductID(self):
        return self._productID

    def getTokoID(self):
        return self._tokoID

    def getNama(self):
        return self._nama

    def getHarga(self):
        return self._harga

    def getStok(self):
        return self._stok

    # ---------- Setter ----------
    def setProductID(self, idBaru):
        self._productID = idBaru

    def setTokoID(self, idBaru):
        self._tokoID = idBaru

    def setNama(self, namaBaru):
        self._nama = namaBaru

    def setHarga(self, hargaBaru):
        if hargaBaru >= 0:  # tidak boleh negatif
            self._harga = hargaBaru

    def setStok(self, stokBaru):
        if stokBaru >= 0:  # tidak boleh negatif
            self._stok = stokBaru

    def kurangiStok(self, jumlah):
        if jumlah <= self._stok:
            self._stok -= jumlah

    # Mencetak data umum; subclass meng-override untuk menambah data khususnya
    def printInfo(self):
        print(f"  [{self.getTipe()}] ID:{self._productID}"
              f" | Nama: {self._nama}"
              f" | Harga: Rp{self._harga}"
              f" | Stok: {self._stok}", end="")

    # Abstract method -> membuat Product jadi abstract class / mirip interface
    @abstractmethod
    def getTipe(self):
        pass
