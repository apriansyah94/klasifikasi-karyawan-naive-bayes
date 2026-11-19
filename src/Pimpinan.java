import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Pimpinan extends User {

    // atribut diwarisi dari class User

    public Pimpinan(int idUser, String nama,
                    String username, String password) {
        super(idUser, nama, username, password, "Pimpinan");
    }

    public List<HasilKlasifikasi> lihatHasil() {
        return HasilKlasifikasi.tampilHasil();
    }

    public void cetakLaporan(String periode) {
        Laporan l = new Laporan(0, periode, LocalDate.now());
        l.cetakLaporan(HasilKlasifikasi.tampilHasil());
    }
}
