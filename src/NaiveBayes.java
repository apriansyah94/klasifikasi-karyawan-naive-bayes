import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class NaiveBayes {

    private static final int JML_KATEGORI = 3;
    private double priorLayak;
    private double priorTidakLayak;
    private int jmlDataLatih;
    private List<DataLatih> dataLatih;

    public NaiveBayes(List<DataLatih> dataLatih) {
        this.dataLatih = dataLatih;
        this.jmlDataLatih = dataLatih.size();
        hitungPrior();
    }

    public void hitungPrior() {
        int layak = 0;
        for (DataLatih d : dataLatih) {
            if (d.getKelayakan().equals("Layak")) layak++;
        }
        priorLayak = (double) layak / jmlDataLatih;
        priorTidakLayak = 1 - priorLayak;
    }

    public double hitungLikelihood(String[] fitur, String kelas) {
        int jmlKelas = 0;
        for (DataLatih d : dataLatih) {
            if (d.getKelayakan().equals(kelas)) jmlKelas++;
        }
        double hasil = 1.0;
        for (int i = 0; i < fitur.length; i++) {
            int cocok = 0;
            for (DataLatih d : dataLatih) {
                if (d.getKelayakan().equals(kelas)
                    && d.getFitur()[i].equals(fitur[i])) cocok++;
            }
            // Laplace smoothing
            hasil *= (cocok + 1.0) / (jmlKelas + JML_KATEGORI);
        }
        return hasil;
    }

    public double hitungPosterior(String[] fitur, String kelas) {
        double prior = kelas.equals("Layak")
                     ? priorLayak : priorTidakLayak;
        return prior * hitungLikelihood(fitur, kelas);
    }

    public String tentukanKelas(String[] fitur) {
        double pLayak = hitungPosterior(fitur, "Layak");
        double pTidak = hitungPosterior(fitur, "Tidak Layak");
        return pLayak >= pTidak ? "Layak" : "Tidak Layak";
    }

    public double hitungAkurasi(List<DataLatih> dataUji) {
        int benar = 0;
        for (DataLatih d : dataUji) {
            String prediksi = tentukanKelas(d.getFitur());
            if (prediksi.equals(d.getKelayakan())) benar++;
        }
        return (double) benar / dataUji.size() * 100;
    }
}
