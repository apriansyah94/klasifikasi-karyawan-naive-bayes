import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Laporan {

    private int idLaporan;
    private String periode;
    private LocalDate tanggalCetak;

    public Laporan(int idLaporan, String periode,
                   LocalDate tanggalCetak) {
        this.idLaporan = idLaporan;
        this.periode = periode;
        this.tanggalCetak = tanggalCetak;
    }

    public String buatLaporan(List<HasilKlasifikasi> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("LAPORAN KELAYAKAN KARYAWAN - ")
          .append(periode).append("\n");
        for (HasilKlasifikasi h : data) {
            sb.append(h.getIdKaryawan()).append(" | ")
              .append(h.getKelas()).append(" | ")
              .append(h.getProbLayak()).append("\n");
        }
        return sb.toString();
    }

    public void cetakLaporan(List<HasilKlasifikasi> data) {
        tanggalCetak = LocalDate.now();
        // pada web: tampilkan di halaman laporan lalu window.print()
        System.out.println(buatLaporan(data));
    }
}
