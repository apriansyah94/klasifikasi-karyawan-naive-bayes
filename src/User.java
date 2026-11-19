import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class User {

    private int idUser;
    private String nama;
    private String username;
    private String password;
    private String role;

    public User(int idUser, String nama, String username,
                String password, String role) {
        this.idUser = idUser;
        this.nama = nama;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username)
            && this.password.equals(password);
    }

    public void logout() {
        // hapus session pengguna
        System.out.println(nama + " telah logout");
    }
}
