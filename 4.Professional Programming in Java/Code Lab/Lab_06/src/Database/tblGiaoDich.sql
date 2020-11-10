USE lab_06;
go
create table tblGiaoDich (
	MaGD int identity primary key, 
	TenGD nvarchar(200),
	NgayGD date, 
	MaDM int foreign key references tblDanhMuc(MaDM), 
	SoTien float
)