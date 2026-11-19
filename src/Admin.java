import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Admin extends User {

    // atribut diwarisi dari class User

    public Admin(int idUser, String nama,
                 String username, String password) {
        super(idUser, nama, username, password, "Admin");
    }

    public boolean kelolaKaryawan(Karyawan k, String aksi) {
        switch (aksi) {
            case "tambah": return k.tambahKaryawan();
            case "ubah":   return k.ubahKaryawan();
            case "hapus":  return k.hapusKaryawan();
            default:       return false;
        }
    }

    public boolean kelolaDataLatih(DataLatih d, String aksi) {
        switch (aksi) {
            case "tambah": return d.tambahData();
            case "ubah":   return d.ubahData();
            case "hapus":  return d.hapusData();
            default:       return false;
        }
    }
}
