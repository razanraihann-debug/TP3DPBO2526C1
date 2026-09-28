# Relasi ke Product = ASSOCIATION -> hanya mengambil data (productID, nama, harga)
# saat dibuat, tidak menyimpan/mengelola referensi Product-nya
class TransactionDetail:
    def __init__(self, transactionID, produk, jumlah):
        self._transactionID = transactionID
        self._productID = produk.getProductID()
        self._namaProduk = produk.getNama()
        self._jumlah = jumlah
        self._subTotal = produk.getHarga() * jumlah
        produk.kurangiStok(jumlah)

    # ---------- Getter ----------
    def getTransactionID(self):
        return self._transactionID

    def getProductID(self):
        return self._productID

    def getNamaProduk(self):
        return self._namaProduk

    def getJumlah(self):
        return self._jumlah

    def getSubTotal(self):
        return self._subTotal

    # ---------- Setter ----------
    def setTransactionID(self, idBaru):
        self._transactionID = idBaru

    def setProductID(self, idBaru):
        self._productID = idBaru

    def setNamaProduk(self, namaBaru):
        self._namaProduk = namaBaru

    def setJumlah(self, jumlahBaru):
        if jumlahBaru > 0:
            self._jumlah = jumlahBaru

    def setSubTotal(self, subTotalBaru):
        if subTotalBaru >= 0:
            self._subTotal = subTotalBaru

    def printInfo(self):
        print(f"  - ProductID: {self._productID}"
              f" | Nama: {self._namaProduk}"
              f" | Jumlah: {self._jumlah}"
              f" | SubTotal: Rp{self._subTotal}")
