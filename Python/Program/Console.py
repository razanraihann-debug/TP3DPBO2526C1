from Product import Product


class Console(Product):
    def __init__(self, productID, tokoID, nama, harga, stok, brand, storage):
        super().__init__(productID, tokoID, nama, harga, stok)
        self._brand = brand
        self._storage = storage
        
    # ---------- Getter ----------
    def getBrand(self):
        return self._brand

    def getStorage(self):
        return self._storage

    # ---------- Setter ----------
    def setBrand(self, brandBaru):
        self._brand = brandBaru

    def setStorage(self, storageBaru):
        self._storage = storageBaru

    def printInfo(self):
        super().printInfo()
        print(f" | Brand: {self._brand} | Storage: {self._storage}")

    def getTipe(self):
        return "Console"
