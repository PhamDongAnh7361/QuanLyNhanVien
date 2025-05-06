package UI;

import javax.swing.*;
import java.awt.*;

public class MainMenuUI extends JFrame {
    public MainMenuUI() {
        setTitle("Quản Lý Thông Tin Nhân Viên");
        setSize(600, 500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(90, 173, 234));

        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 10));
        panel.setBackground(new Color(28, 88, 225));

        JButton btnXem = new JButton("Danh sách nhân viên");
        JButton btnThem = new JButton("Thêm nhân viên mới");
        JButton btnSua = new JButton("Cập nhật thông tin nhân viên");
        JButton btnXoa = new JButton("Xoá nhân viên");
        JButton btnTimKiem = new JButton("Tìm kiếm nhân viên");

        Font font = new Font("Arial", Font.BOLD, 14);
        for (JButton btn : new JButton[]{btnXem, btnThem, btnSua, btnXoa, btnTimKiem}) {
            btn.setFont(font);
            btn.setBackground(Color.WHITE);
            btn.setFocusPainted(false);
        }

        panel.add(btnXem);
        panel.add(btnThem);
        panel.add(btnSua);
        panel.add(btnXoa);
        panel.add(btnTimKiem);
        add(panel);

        btnXem.addActionListener(e -> new DanhSachNhanVienUI());
        btnThem.addActionListener(e -> new ThemNhanVienUI());
        btnSua.addActionListener(e -> new CapNhatNhanVienUI());
        btnXoa.addActionListener(e -> new XoaNhanVienUI());
        btnTimKiem.addActionListener(e -> new TimKiemNhanVienUI());

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenuUI();
    }
}
