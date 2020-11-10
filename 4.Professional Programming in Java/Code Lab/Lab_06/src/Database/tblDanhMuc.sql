USE lab_06;
go
create table tblDanhMuc (
	MaDM int identity primary key,
	TenDM nvarchar(200)
)
insert into tblDanhMuc values (N'Lương')
insert into tblDanhMuc values (N'Xăng xe')
insert into tblDanhMuc values (N'Bán đồng nát')
insert into tblDanhMuc values (N'Sinh hoạt')
insert into tblDanhMuc values (N'Giải trí')