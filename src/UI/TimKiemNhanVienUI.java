package UI;

import entities.NhanVienEntity;
import services.NhanVienService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class TimKiemNhanVienUI extends JFrame {
    private final NhanVienService service = new NhanVienService();
    private JTable table;
    private DefaultTableModel tableModel;

    public TimKiemNhanVienUI() {
        setTitle("Tìm kiếm nhân viên");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(new Color(90, 173, 234));

        setLayout(new BorderLayout());

        // === Top Panel: form tìm kiếm ===
        JPanel searchPanel = new JPanel(new GridLayout(2, 4, 10, 10));
        searchPanel.setBackground(new Color(90, 173, 234));
        JTextField tfManv = new JTextField();

        JButton btnSearch = new JButton("Tìm kiếm");

        searchPanel.add(new JLabel("Mã nhân viên:"));
        searchPanel.add(tfManv);
        searchPanel.add(new JLabel());
        searchPanel.add(btnSearch);

        // === Center: bảng kết quả ===
        String[] columns = {
                "Mã NV", "Họ tên", "Giới tính",
                "Địa chỉ", "Chức vụ", "Ngày vào làm"
        };

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // === Xử lý tìm kiếm ===
        btnSearch.addActionListener(e -> {
            String manv = tfManv.getText().trim().toLowerCase();

            List<NhanVienEntity> all = service.getAllNhanVien();
            List<NhanVienEntity> filtered = all.stream()
                    .filter(nv -> manv.isEmpty() || nv.getManv().toLowerCase().contains(manv))
                    .collect(Collectors.toList());

            showResults(filtered);
        });

        setVisible(true);
    }

    private void showResults(List<NhanVienEntity> list) {
        tableModel.setRowCount(0);
        for (NhanVienEntity nv : list) {
            tableModel.addRow(new Object[]{
                    nv.getManv(), nv.getHoten(), nv.getGioitinh(),
                    nv.getDiachi(), nv.getChucvu(), nv.getNgayvaolam()
            });
        }
    }
}
