USE lab_06;
go
create table tblNhanVien (
MaNV int identity primary key,
HoTen nvarchar(50), 
NamSinh int, 
PhongBan nvarchar(200), 
Email nvarchar(100)
)