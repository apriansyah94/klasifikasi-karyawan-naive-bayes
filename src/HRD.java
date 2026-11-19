import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class HRD extends User {

    // atribut diwarisi dari class User

    public HRD(int idUser, String nama,
               String username, String password) {
        super(idUser, nama, username, password, "HRD");
    }

    public HasilKlasifikasi prosesKlasifikasi(Karyawan k,
                                              NaiveBayes nb) {
        String[] f = k.getFitur();
        double pL = nb.hitungPosterior(f, "Layak");
        double pT = nb.hitungPosterior(f, "Tidak Layak");
        double total = pL + pT;
        String kelas = nb.tentukanKelas(f);

        HasilKlasifikasi h = new HasilKlasifikasi(0,
                k.getIdKaryawan(), pL / total, pT / total,
                kelas, LocalDate.now());
        h.simpanHasil();
        return h;
    }

    public List<HasilKlasifikasi> lihatHasil() {
        return HasilKlasifikasi.tampilHasil();
    }
}
