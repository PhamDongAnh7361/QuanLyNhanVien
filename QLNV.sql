create database QLNV;
use QLNV;

create table nhanvien
(
   manv char(3) primary key,
   hoten varchar (20),
   gioitinh varchar(5),
   diachi varchar(20),
   chucvu varchar(20),
   ngayvaolam DATE
); 

insert into nhanvien (manv, hoten, gioitinh, diachi, chucvu, ngayvaolam)
values  ('M01','Le Van Hoa','Nam','AG','Nhan Vien','2021-03-12'),
		('M02','Huynh Tan Huy','Nam','HN','Nhan Vien','2025-03-05'),
        ('M03','Nguyen Tuan Duc','Nam','HCM','Truong Phong','2021-07-15'),
        ('M04','Pham Dong Anh','Nu','KG','Thuc Tap','2025-03-20'),
        ('M05','Le Quang Dat','Nam','KH','CEO','2020-02-01'),
        ('M06','Pham Thu Anh','Nu','CM','Nhan Vien','2022-11-07'),
        ('M07','Phan Minh Hung','Nam','PT','Thuc Tap','2025-03-23'),
        ('M08','Lam Yen Nhi','Nu','BD','Nhan Vien','2024-07-06'),
        ('M09','Dang Gia Bao','Nam','HCM','Nhan Vien','2022-12-01'),
        ('M10','Le Hoai Nam','Nam','AG','Thuc Tap','2025-02-21'),
        ('M11','Quach Thanh Dong','Nam','KH','Nhan Vien','2022-02-01'),
        ('M12','Le Thanh Trong','Nam','KG','Truong Phong','2020-09-10'),
        ('M13','Vo Khanh Bang','Nu','CM','Nhan Vien','2022-06-12'),
        ('M14','Pham Van Hai','Nam','DN','Thuc Tap','2025-01-08'),
        ('M15','Ly Chi Hao','Nam','KG','Nhan Vien','2023-10-30');
         
     
drop database QLNV;