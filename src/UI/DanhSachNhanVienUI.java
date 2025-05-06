package UI;

import entities.NhanVienEntity;
import services.NhanVienService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class DanhSachNhanVienUI extends JFrame {
    private final NhanVienService service = new NhanVienService();
    private JTable table;
    private DefaultTableModel tableModel;
    private JComboBox<String> cbChucVu;

    public DanhSachNhanVienUI() {
        setTitle("Danh sách nhân viên");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(90, 173, 234));

        // === Layout tổng ===
        setLayout(new BorderLayout());

        // === Top panel: chọn chức vụ để lọc ===
        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.setBackground(new Color(90, 173, 234));

        cbChucVu = new JComboBox<>(new String[]{
                "Tất cả", "CEO", "Trưởng Phòng", "Nhân viên", "Thực Tập"
        });

        JButton btnLoc = new JButton("Lọc");

        topPanel.add(new JLabel("Chức vụ:"));
        topPanel.add(cbChucVu);
        topPanel.add(btnLoc);

        // === Center: bảng nhân viên ===
        String[] columns = {
                "Mã NV", "Họ tên", "Giới tính",
                "Địa chỉ", "Chức vụ", "Ngày vào làm"
        };

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(table);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // === Sự kiện nút lọc ===
        btnLoc.addActionListener(e -> {
            String selected = cbChucVu.getSelectedItem().toString();
            if (selected.equals("Tất cả")) {
                loadAllData();
            } else {
                loadByChucVu(selected);
            }
        });

        // Load dữ liệu ban đầu
        loadAllData();

        setVisible(true);
    }

    private void loadAllData() {
        tableModel.setRowCount(0);
        List<NhanVienEntity> list = service.getAllNhanVien();
        for (NhanVienEntity nv : list) {
            tableModel.addRow(new Object[]{
                    nv.getManv(), nv.getHoten(), nv.getGioitinh(),
                    nv.getDiachi(), nv.getChucvu(), nv.getNgayvaolam()
            });
        }
    }

    private void loadByChucVu(String chucvu) {
        tableModel.setRowCount(0);
        List<NhanVienEntity> list = service.getNhanVienTheoChucVu(chucvu);
        for (NhanVienEntity nv : list) {
            tableModel.addRow(new Object[]{
                    nv.getManv(), nv.getHoten(), nv.getGioitinh(),
                    nv.getDiachi(), nv.getChucvu(), nv.getNgayvaolam()
            });
        }
    }
}
