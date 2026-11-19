import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class HasilKlasifikasi {

    private int idHasil;
    private int idKaryawan;
    private double probLayak;
    private double probTidakLayak;
    private String kelas;
    private LocalDate tanggal;

    public HasilKlasifikasi(int idHasil, int idKaryawan,
            double probLayak, double probTidakLayak,
            String kelas, LocalDate tanggal) {
        this.idHasil = idHasil;
        this.idKaryawan = idKaryawan;
        this.probLayak = probLayak;
        this.probTidakLayak = probTidakLayak;
        this.kelas = kelas;
        this.tanggal = tanggal;
    }

    public boolean simpanHasil() {
        String sql = "INSERT INTO hasil_klasifikasi (id_karyawan, "
            + "prob_layak, prob_tidak_layak, kelas, tanggal) "
            + "VALUES (?,?,?,?,?)";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idKaryawan);
            ps.setDouble(2, probLayak);
            ps.setDouble(3, probTidakLayak);
            ps.setString(4, kelas);
            ps.setDate(5, java.sql.Date.valueOf(tanggal));
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<HasilKlasifikasi> tampilHasil() {
        List<HasilKlasifikasi> daftar = new ArrayList<>();
        String sql = "SELECT * FROM hasil_klasifikasi "
                   + "ORDER BY tanggal DESC";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                daftar.add(new HasilKlasifikasi(
                    rs.getInt("id_hasil"),
                    rs.getInt("id_karyawan"),
                    rs.getDouble("prob_layak"),
                    rs.getDouble("prob_tidak_layak"),
                    rs.getString("kelas"),
                    rs.getDate("tanggal").toLocalDate()));
            }
        } catch (SQLException e) { }
        return daftar;
    }

    public int getIdHasil() { return idHasil; }
    public int getIdKaryawan() { return idKaryawan; }
    public double getProbLayak() { return probLayak; }
    public double getProbTidakLayak() { return probTidakLayak; }
    public String getKelas() { return kelas; }
    public LocalDate getTanggal() { return tanggal; }
}
