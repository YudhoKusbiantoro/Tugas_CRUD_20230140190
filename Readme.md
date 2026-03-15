# POST
## http://localhost:8080/ktp
```json
{
  "nomorktp": "3274012501950008",
  "namalengkap": "Fio Antika",
  "alamat": "Sleman DIY",
  "tanggallahir": "2004-06-11",
  "jeniskelamin": "L"
}
```
Respon
```json
{
    "data": {
        "id": 2,
        "nomorktp": "3274012501950008",
        "namalengkap": "Fio Antika",
        "alamat": "Sleman DIY",
        "tanggallahir": "2004-06-11",
        "jeniskelamin": "L"
    },
    "success": true,
    "message": "Data KTP berhasil ditambahkan"
}
```
# PUT
## http://localhost:8080/ktp/id
```json
{
  "nomorktp": "3274012501950008",
  "namalengkap": "Fio Antika",
  "alamat": "Sumatera Barat",
  "tanggallahir": "2004-06-11",
  "jeniskelamin": "L"
}
```
Respon
```json
{
    "data": {
        "id": 2,
        "nomorktp": "3274012501950008",
        "namalengkap": "Fio Antika",
        "alamat": "Sumatera Barat",
        "tanggallahir": "2004-06-11",
        "jeniskelamin": "L"
    },
    "success": true,
    "message": "Data KTP berhasil diperbarui"
}
```
# Delete
## DELETE : http://localhost:8080/ktp/id
Respon
```json
{
    "success": true,
    "message": "Data KTP berhasil dihapus"
}
```
## Tampilan
# Input
![Input.png](ss/Input.png)
# validasi harus 16 digit no kt
![validasi No ktp harus 16 digit.png](ss/validasi%20No%20ktp%20harus%2016%20digit.png)
# validasi no ktp already
![Validasi no ktp already.png](ss/Validasi%20no%20ktp%20already.png)
# Edit
![edit.png](ss/edit.png)
# konfirmasi hapus data
![Validasi delete.png](ss/Validasi%20delete.png)
# Data berhasil di hapus
![data berhasil di hapus.png](ss/data%20berhasil%20di%20hapus.png)
