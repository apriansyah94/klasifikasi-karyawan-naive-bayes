import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Karyawan {

    private int idKaryawan;
    private String nip;
    private String nama;
    private String jabatan;
    private String absensi;
    private String kinerja;
    private String masaKerja;
    private String disiplin;

    public Karyawan(int idKaryawan, String nip, String nama,
            String jabatan, String absensi, String kinerja,
            String masaKerja, String disiplin) {
        this.idKaryawan = idKaryawan;
        this.nip = nip;
        this.nama = nama;
        this.jabatan = jabatan;
        this.absensi = absensi;
        this.kinerja = kinerja;
        this.masaKerja = masaKerja;
        this.disiplin = disiplin;
    }

    public boolean tambahKaryawan() {
        String sql = "INSERT INTO karyawan (nip, nama, jabatan, "
            + "absensi, kinerja, masa_kerja, disiplin) "
            + "VALUES (?,?,?,?,?,?,?)";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nip);
            ps.setString(2, nama);
            ps.setString(3, jabatan);
            ps.setString(4, absensi);
            ps.setString(5, kinerja);
            ps.setString(6, masaKerja);
            ps.setString(7, disiplin);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean ubahKaryawan() {
        String sql = "UPDATE karyawan SET nip=?, nama=?, jabatan=?, "
            + "absensi=?, kinerja=?, masa_kerja=?, disiplin=? "
            + "WHERE id_karyawan=?";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, nip);
            ps.setString(2, nama);
            ps.setString(3, jabatan);
            ps.setString(4, absensi);
            ps.setString(5, kinerja);
            ps.setString(6, masaKerja);
            ps.setString(7, disiplin);
            ps.setInt(8, idKaryawan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean hapusKaryawan() {
        String sql = "DELETE FROM karyawan WHERE id_karyawan=?";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idKaryawan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static List<Karyawan> cariKaryawan(String kata) {
        List<Karyawan> hasil = new ArrayList<>();
        String sql = "SELECT * FROM karyawan "
                   + "WHERE nama LIKE ? OR nip LIKE ?";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, "%" + kata + "%");
            ps.setString(2, "%" + kata + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                hasil.add(new Karyawan(rs.getInt("id_karyawan"),
                    rs.getString("nip"), rs.getString("nama"),
                    rs.getString("jabatan"), rs.getString("absensi"),
                    rs.getString("kinerja"), rs.getString("masa_kerja"),
                    rs.getString("disiplin")));
            }
        } catch (SQLException e) { }
        return hasil;
    }

    public String[] getFitur() {
        return new String[]{absensi, kinerja,
                            masaKerja, disiplin};
    }

    public int getIdKaryawan() { return idKaryawan; }
    public String getNip() { return nip; }
    public String getNama() { return nama; }
    public String getJabatan() { return jabatan; }
}
