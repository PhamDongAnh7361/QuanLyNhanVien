package entities;

public class NhanVienEntity {
    private String manv;
    private String hoten;
    private String gioitinh;
    private String diachi;
    private String chucvu;
    private String ngayvaolam;

    public NhanVienEntity() {}

    public NhanVienEntity(String manv, String hoten, String gioitinh,
                          String diachi, String chucvu, String ngayvaolam) {
        this.manv = manv;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.chucvu = chucvu;
        this.ngayvaolam = ngayvaolam;
    }

    // Getters & Setters
    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getNgayvaolam() {
        return ngayvaolam;
    }

    public void setNgayvaolam(String ngayvaolam) {
        this.ngayvaolam = ngayvaolam;
    }

    @Override
    public String toString() {
        return "Mã NV: " + manv +
                ", Họ tên: " + hoten +
                ", Giới tính: " + gioitinh +
                ", Địa chỉ: " + diachi +
                ", Chức vụ: " + chucvu +
                ", Ngày vào làm: " + ngayvaolam;
    }
}
