from Product import Product


class Game(Product):
    def __init__(self, productID, tokoID, nama, harga, stok, genre, platform):
        super().__init__(productID, tokoID, nama, harga, stok)
        self._genre = genre
        self._platform = platform

    def __del__(self):
        super().__del__()  # lalu destructor Product (sama seperti urutan di C++)

    # ---------- Getter ----------
    def getGenre(self):
        return self._genre

    def getPlatform(self):
        return self._platform

    # ---------- Setter ----------
    def setGenre(self, genreBaru):
        self._genre = genreBaru

    def setPlatform(self, platformBaru):
        self._platform = platformBaru

    def printInfo(self):
        super().printInfo()
        print(f" | Genre: {self._genre} | Platform: {self._platform}")

    def getTipe(self):
        return "Game"
