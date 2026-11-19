import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class Koneksi {

    private static final String URL =
        "jdbc:mysql://localhost:3306/db_karyawan";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getKoneksi() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
