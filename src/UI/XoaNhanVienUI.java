package UI;

import services.NhanVienService;

import javax.swing.*;
import java.awt.*;

public class XoaNhanVienUI extends JFrame {
    private final NhanVienService service = new NhanVienService();

    public XoaNhanVienUI() {
        setTitle("Xoá Nhân Viên");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(90, 173, 234));

        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblManv = new JLabel("Mã nhân viên cần xoá:");
        JTextField tfManv = new JTextField();
        JButton btnXoa = new JButton("Xoá");

        add(lblManv);
        add(tfManv);
        add(new JLabel()); // trống
        add(btnXoa);

        // Xử lý sự kiện xoá
        btnXoa.addActionListener(e -> {
            String manv = tfManv.getText();
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "Bạn có chắc muốn xoá nhân viên này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                String result = service.deleteNhanVien(manv);
                JOptionPane.showMessageDialog(this, result);
            }
        });

        setVisible(true);
    }
}
