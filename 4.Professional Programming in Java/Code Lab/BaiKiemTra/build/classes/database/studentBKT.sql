use lab_06
go
CREATE TABLE studentBKT(
	id int IDENTITY(1,1) NOT NULL,
	ten nvarchar(100) ,
	gioitinh bit,
	tuoi int ,
	toan float,
	ly float,
	hoa float,
	trungbinh float
)
--drop table studentBKT
go
INSERT INTO studentBKT(ten, gioitinh, tuoi, toan, ly, hoa, trungbinh) VALUES ('Nguyen Gia Bao', 0 , 23, 13, 15, 10, 12.66)
INSERT INTO studentBKT(ten, gioitinh, tuoi, toan, ly, hoa, trungbinh) VALUES ('Nguyen The An', 0 , 21,17, 11, 12, 13.33)
INSERT INTO studentBKT(ten, gioitinh, tuoi, toan, ly, hoa, trungbinh) VALUES ('Lai Thanh Tam', 1 , 22,10, 14, 8, 10.66)
INSERT INTO studentBKT(ten, gioitinh, tuoi, toan, ly, hoa, trungbinh) VALUES ('Hoang Bao Ngoc', 1 , 19,13, 15, 17, 15)
go
select * from studentBKT
go
CREATE PROC proc_getAllStudent
AS
	SELECT * FROM studentBKT order by ten ASC 

GO
exec proc_getAllStudent
go
CREATE PROC proc_addStudent
@ten nvarchar(100),
@gioitinh bit,
@tuoi int ,
@toan float,
@ly float,
@hoa float,
@trungbinh float
AS
	INSERT INTO studentBKT(ten, gioitinh, tuoi, toan, ly, hoa, trungbinh) VALUES(@ten, @gioitinh, @tuoi, @toan, @ly, @hoa, @trungbinh)

GO
CREATE PROC proc_deleteStudent
@id int
AS
	DELETE FROM studentBKT WHERE id=@id
go
CREATE PROC proc_UpdateStudent
@id int ,
@ten nvarchar(100) ,
@gioitinh bit,
@tuoi int ,
@toan float,
@ly float,
@hoa float,
@trungbinh float
AS
	UPDATE studentBKT SET ten=@ten,gioitinh=@gioitinh, tuoi=@tuoi,toan=@toan,ly=@ly,hoa=@hoa,trungbinh=@trungbinh WHERE id=@id

GO
CREATE PROC proc_SearchByName
@ten nvarchar(100)
AS
	SELECT * FROM studentBKT WHERE ten like '%'+@ten + '%'

GO