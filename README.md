# Klasifikasi Kelayakan Karyawan Menggunakan Algoritma Naive Bayes Berbasis Web

Proyek mata kuliah Rekayasa Perangkat Lunak (RPL). Sistem web untuk mengklasifikasikan kelayakan karyawan (Layak / Tidak Layak) dengan algoritma Naive Bayes berdasarkan empat atribut: absensi, kinerja, masa kerja, dan disiplin.

Repositori ini dipakai untuk latihan kolaborasi tim dengan GitHub (branch, pull request, code review, dan merge).

## Anggota Tim

| Nama | Akun GitHub | Branch | Bagian yang dikerjakan |
|---|---|---|---|
| Fikri Apriansyah | apriansyah94 | `feature/class-diagram` | Class diagram, object diagram, dan pemetaan kelas ke kode Java (`docs/uml`, `docs/class-ke-java`) |
| Ahmad Hidayat | ahmad-hidayat04 | `ahmad-hidayat04-patch-1` | Kode program Java 10 kelas (`src`) |
| Safik Akbar | Safik111 | `Safik111-patch-1` | Desain UI/UX 9 layar (`ui`) |
| Raden Alfian Pramudya | radenalfian665 | `feature/uml-perilaku` | Use case, activity, sequence, dan state diagram (`docs/uml`) |

## Struktur Folder

| Folder | Isi |
|---|---|
| `docs/uml/` | Diagram UML (format draw.io): use case, activity, sequence, state, class, dan object diagram |
| `docs/class-ke-java/` | Gambar pemetaan tiap kelas pada class diagram ke kode Java |
| `src/` | Kode Java: User, Admin, HRD, Pimpinan, Karyawan, DataLatih, NaiveBayes, HasilKlasifikasi, Laporan, dan Koneksi (kelas pembantu database) |
| `ui/png/` | Gambar 9 layar UI/UX |
| `ui/html/` | Sumber HTML 9 layar UI/UX |

## 9 Layar UI/UX

1. Login
2. Dashboard Admin
3. Dashboard HRD
4. Dashboard Pimpinan
5. Data Karyawan
6. Data Latih
7. Proses Klasifikasi
8. Hasil Klasifikasi
9. Laporan Cetak

Desain dan prototipe interaktif di Figma: [Buka prototipe Figma](https://www.figma.com/proto/lJFfmqfS9jQwY3Tj4ZJBPa/Untitled?node-id=6-128&t=UhX2C6IA6PJJpB15-0&scaling=min-zoom&content-scaling=fixed&page-id=0%3A1&starting-point-node-id=6%3A128)

## Kelas Utama

User, Admin, HRD, Pimpinan, Karyawan, DataLatih, NaiveBayes, HasilKlasifikasi, dan Laporan. Kelas `Koneksi` adalah kelas pembantu untuk terhubung ke database MySQL.

## Cara Menjalankan

1. Clone repository: `git clone https://github.com/apriansyah94/klasifikasi-karyawan-naive-bayes.git`
2. Buka folder proyek dengan IDE (IntelliJ IDEA / Eclipse / NetBeans).
3. Siapkan database MySQL bernama `db_karyawan` dengan tabel `karyawan`, `data_latih`, dan `hasil_klasifikasi`, lalu tambahkan MySQL JDBC driver ke proyek.
4. Kompilasi kode di folder `src`: `javac *.java`

## Alur Kerja Tim

- Setiap anggota bekerja di branch sendiri (`feature/...`).
- Perubahan digabung ke `main` lewat Pull Request dan harus direview anggota lain.
- Pesan commit ditulis jelas, misalnya "Menambahkan kode Java 10 kelas".
