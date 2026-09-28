class Customer:
    def __init__(self, pelangganID, nama, email):
        self._pelangganID = pelangganID
        self._nama = nama
        self._email = email

    # ---------- Getter ----------
    def getPelangganID(self):
        return self._pelangganID

    def getNama(self):
        return self._nama

    def getEmail(self):
        return self._email

    # ---------- Setter ----------
    def setPelangganID(self, idBaru):
        self._pelangganID = idBaru

    def setNama(self, namaBaru):
        self._nama = namaBaru

    def setEmail(self, emailBaru):
        self._email = emailBaru

    def printInfo(self):
        print(f"PelangganID: {self._pelangganID}"
              f" | Nama: {self._nama}"
              f" | Email: {self._email}")
