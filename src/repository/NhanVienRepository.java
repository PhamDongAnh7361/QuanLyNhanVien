package repository;

import config.MysqlConfig;
import entities.NhanVienEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    public List<NhanVienEntity> findAll() {
        List<NhanVienEntity> list = new ArrayList<>();
        String query = "SELECT * FROM nhanvien";
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                NhanVienEntity nv = new NhanVienEntity();
                nv.setManv(rs.getString("manv"));
                nv.setHoten(rs.getString("hoten"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setChucvu(rs.getString("chucvu"));
                nv.setNgayvaolam(rs.getString("ngayvaolam"));
                list.add(nv);
            }

        } catch (Exception e) {
            System.out.println("findAll: " + e.getMessage());
        }

        return list;
    }

    public int add(NhanVienEntity nv) {
        String query = "INSERT INTO nhanvien (manv, hoten, gioitinh, diachi, chucvu, ngayvaolam) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nv.getManv());
            stmt.setString(2, nv.getHoten());
            stmt.setString(3, nv.getGioitinh());
            stmt.setString(4, nv.getDiachi());
            stmt.setString(5, nv.getChucvu());
            stmt.setString(6, nv.getNgayvaolam());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("add: " + e.getMessage());
            return 0;
        }
    }

    public int update(NhanVienEntity nv) {
        String query = "UPDATE nhanvien SET hoten = ?, gioitinh = ?, diachi = ?, chucvu = ?, ngayvaolam = ? WHERE manv = ?";
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, nv.getHoten());
            stmt.setString(2, nv.getGioitinh());
            stmt.setString(3, nv.getDiachi());
            stmt.setString(4, nv.getChucvu());
            stmt.setString(5, nv.getNgayvaolam());
            stmt.setString(6, nv.getManv());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("update: " + e.getMessage());
            return 0;
        }
    }

    public int deleteById(String manv) {
        String query = "DELETE FROM nhanvien WHERE manv = ?";
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, manv);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("delete: " + e.getMessage());
            return 0;
        }
    }

    public List<NhanVienEntity> findByChucVu(String chucvu) {
        List<NhanVienEntity> list = new ArrayList<>();
        String query = "SELECT * FROM nhanvien WHERE chucvu = ?";
        try (Connection conn = MysqlConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, chucvu);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                NhanVienEntity nv = new NhanVienEntity();
                nv.setManv(rs.getString("manv"));
                nv.setHoten(rs.getString("hoten"));
                nv.setGioitinh(rs.getString("gioitinh"));
                nv.setDiachi(rs.getString("diachi"));
                nv.setChucvu(rs.getString("chucvu"));
                nv.setNgayvaolam(rs.getString("ngayvaolam"));
                list.add(nv);
            }

        } catch (Exception e) {
            System.out.println("findByChucVu: " + e.getMessage());
        }
        return list;
    }
}
