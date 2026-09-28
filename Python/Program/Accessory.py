from Product import Product


class Accessory(Product):
    def __init__(self, productID, tokoID, nama, harga, stok, jenis, kompabilitas):
        super().__init__(productID, tokoID, nama, harga, stok)
        self._jenis = jenis
        self._kompabilitas = kompabilitas
        
    # ---------- Getter ----------
    def getJenis(self):
        return self._jenis

    def getKompabilitas(self):
        return self._kompabilitas

    # ---------- Setter ----------
    def setJenis(self, jenisBaru):
        self._jenis = jenisBaru

    def setKompabilitas(self, kompabilitasBaru):
        self._kompabilitas = kompabilitasBaru

    def printInfo(self):
        super().printInfo()
        print(f" | Jenis: {self._jenis} | Kompabilitas: {self._kompabilitas}")

    def getTipe(self):
        return "Accessory"
