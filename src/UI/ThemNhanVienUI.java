package UI;

import entities.NhanVienEntity;
import services.NhanVienService;

import javax.swing.*;
import java.awt.*;

public class ThemNhanVienUI extends JFrame {
    private final NhanVienService service = new NhanVienService();

    public ThemNhanVienUI() {
        setTitle("Thêm Nhân Viên");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(90, 173, 234));

        setLayout(new GridLayout(9, 2, 10, 10));

        // Các input field
        JTextField tfManv = new JTextField();
        JTextField tfHoten = new JTextField();
        JComboBox<String> cbGioitinh = new JComboBox<>(new String[]{"Nam", "Nữ"});
        JTextField tfDiachi = new JTextField();
        JTextField tfChucvu = new JTextField();
        JTextField tfNgayvaolam = new JTextField(); // yyyy-MM-dd

        JButton btnThem = new JButton("Thêm nhân viên");

        // Thêm label + input
        add(new JLabel("Mã nhân viên:"));
        add(tfManv);

        add(new JLabel("Họ và tên:"));
        add(tfHoten);

        add(new JLabel("Giới tính:"));
        add(cbGioitinh);

        add(new JLabel("Địa chỉ:"));
        add(tfDiachi);

        add(new JLabel("Chức vụ:"));
        add(tfChucvu);

        add(new JLabel("Ngày vào làm (yyyy-MM-dd):"));
        add(tfNgayvaolam);

        add(new JLabel());
        add(btnThem);

        // Xử lý nút Thêm
        btnThem.addActionListener(e -> {
            NhanVienEntity nv = new NhanVienEntity(
                    tfManv.getText(),
                    tfHoten.getText(),
                    cbGioitinh.getSelectedItem().toString(),
                    tfDiachi.getText(),
                    tfChucvu.getText(),
                    tfNgayvaolam.getText()
            );
            String result = service.addNhanVien(nv);
            JOptionPane.showMessageDialog(this, result);
        });

        setVisible(true);
    }
}

