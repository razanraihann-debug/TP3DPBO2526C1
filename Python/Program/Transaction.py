from TransactionDetail import TransactionDetail


# Relasi ke TransactionDetail = COMPOSITION + array of object.
# Transaction adalah PEMILIK detail: dibuat di tambahDetail, dihapus di destructor Transaction.
class Transaction:
    def __init__(self, transactionID, pelanggan, tanggal):
        self._transactionID = transactionID
        self._pelangganID = pelanggan.getPelangganID()  # association ke Customer (hanya simpan ID)
        self._tanggal = tanggal
        self._totalBayar = 0
        self._details = []
        
    def tambahDetail(self, produk, jumlah):  # data ditambahkan secara statis dari main
        d = TransactionDetail(self._transactionID, produk, jumlah)
        self._totalBayar += d.getSubTotal()
        self._details.append(d)

    # totalBayar adalah nilai turunan: hitung ulang dari semua subTotal detail
    def hitungUlangTotal(self):
        self._totalBayar = 0
        for d in self._details:
            self._totalBayar += d.getSubTotal()

    # ---------- Getter ----------
    def getTransactionID(self):
        return self._transactionID

    def getPelangganID(self):
        return self._pelangganID

    def getTanggal(self):
        return self._tanggal

    def getTotalBayar(self):
        return self._totalBayar

    def getDetails(self):
        return self._details

    # ---------- Setter ----------
    def setTransactionID(self, idBaru):
        self._transactionID = idBaru

    def setPelangganID(self, idBaru):
        self._pelangganID = idBaru

    def setTanggal(self, tanggalBaru):
        self._tanggal = tanggalBaru

    def setTotalBayar(self, totalBaru):
        if totalBaru >= 0:
            self._totalBayar = totalBaru

    # Karena composition: detail lama yang tidak ada di daftar baru ikut dihapus
    def setDetails(self, detailBaru):
        lama = self._details
        self._details = list(detailBaru)
        while len(lama) > 0:
            lama.pop(0)
        self.hitungUlangTotal()

    def printInfo(self):
        print(f"Transaksi #{self._transactionID}"
              f" | Tanggal: {self._tanggal}"
              f" | PelangganID: {self._pelangganID}")
        print(f"Jumlah item: {len(self._details)}")
        for d in self._details:
            d.printInfo()
        print(f"TOTAL BAYAR: Rp{self._totalBayar}")
