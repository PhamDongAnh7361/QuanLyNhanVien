package services;

import entities.NhanVienEntity;
import repository.NhanVienRepository;

import java.util.List;

public class NhanVienService {
    private final NhanVienRepository repository = new NhanVienRepository();

    public List<NhanVienEntity> getAllNhanVien() {
        return repository.findAll();
    }

    public String addNhanVien(NhanVienEntity nv) {
        return repository.add(nv) == 1 ? "Thêm thành công" : "Thêm thất bại";
    }

    public String updateNhanVien(NhanVienEntity nv) {
        return repository.update(nv) == 1 ? "Cập nhật thành công" : "Cập nhật thất bại";
    }

    public String deleteNhanVien(String manv) {
        return repository.deleteById(manv) == 1 ? "Xoá thành công" : "Xoá thất bại";
    }

    public List<NhanVienEntity> getNhanVienTheoChucVu(String chucvu) {
        return repository.findByChucVu(chucvu);
    }
}
