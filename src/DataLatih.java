import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class DataLatih {

    private int idLatih;
    private String absensi;
    private String kinerja;
    private String masaKerja;
    private String disiplin;
    private String kelayakan;   // Layak / Tidak Layak

    public DataLatih(int idLatih, String absensi,
            String kinerja, String masaKerja,
            String disiplin, String kelayakan) {
        this.idLatih = idLatih;
        this.absensi = absensi;
        this.kinerja = kinerja;
        this.masaKerja = masaKerja;
        this.disiplin = disiplin;
        this.kelayakan = kelayakan;
    }

    public boolean tambahData() {
        String sql = "INSERT INTO data_latih (absensi, kinerja, "
            + "masa_kerja, disiplin, kelayakan) VALUES (?,?,?,?,?)";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, absensi);
            ps.setString(2, kinerja);
            ps.setString(3, masaKerja);
            ps.setString(4, disiplin);
            ps.setString(5, kelayakan);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean ubahData() {
        String sql = "UPDATE data_latih SET absensi=?, kinerja=?, "
            + "masa_kerja=?, disiplin=?, kelayakan=? "
            + "WHERE id_latih=?";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, absensi);
            ps.setString(2, kinerja);
            ps.setString(3, masaKerja);
            ps.setString(4, disiplin);
            ps.setString(5, kelayakan);
            ps.setInt(6, idLatih);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public boolean hapusData() {
        String sql = "DELETE FROM data_latih WHERE id_latih=?";
        try (Connection c = Koneksi.getKoneksi();
         PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, idLatih);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    public static int importData(String pathCsv) {
        int jumlah = 0;
        try (BufferedReader br =
                new BufferedReader(new FileReader(pathCsv))) {
            br.readLine();                 // lewati baris header
            String baris;
            while ((baris = br.readLine()) != null) {
                String[] k = baris.split(",");
                DataLatih d = new DataLatih(0, k[0], k[1],
                                            k[2], k[3], k[4]);
                if (d.tambahData()) jumlah++;
            }
        } catch (IOException e) { }
        return jumlah;
    }

    public String[] getFitur() {
        return new String[]{absensi, kinerja,
                            masaKerja, disiplin};
    }

    public int getIdLatih() { return idLatih; }
    public String getKelayakan() { return kelayakan; }
}
