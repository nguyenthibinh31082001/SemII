use lab_06
go
CREATE TABLE GiaoDichLab09(
	MaDg int IDENTITY(1,1) NOT NULL,
	TenDg nvarchar(100) ,
	LoaiDg nvarchar(250) ,
	GioDg time ,
	NgayDg date ,
	MoTa nvarchar(250)
)
GO 
select * from GiaoDichLab09
go
-- Thêm mới dữ liệu
INSERT INTO GiaoDichLab09(TenDg, LoaiDg, GioDg, NgayDg, MoTa) VALUES ('Giao dịch 1', 'vietcombank', '07:43', '2020-11-25','không')
INSERT INTO GiaoDichLab09(TenDg, LoaiDg, GioDg, NgayDg, MoTa) VALUES ('Giao dịch 2', 'viettinbank', '07:45', '2020-11-25','không')
INSERT INTO GiaoDichLab09(TenDg, LoaiDg, GioDg, NgayDg, MoTa) VALUES ('Giao dịch 3', 'vietcombank', '07:47', '2020-11-25','không')
INSERT INTO GiaoDichLab09(TenDg, LoaiDg, GioDg, NgayDg, MoTa) VALUES ('Giao dịch 4', 'viettinbank', '07:49', '2020-11-25','không')

GO
CREATE PROC proc_giaodich_GetAll
AS
	SELECT * FROM GiaoDichLab09

GO
CREATE PROC proc_giaodich_Insert
@TenDg nvarchar(100) ,
@LoaiDg nvarchar(250) ,
@GioDg time ,
@NgayDg date ,
@MoTa nvarchar(250),
@Msg nvarchar(100) OUT
AS
	if(EXISTS(SELECT * FROM GiaoDichLab09 WHERE TenDg like @TenDg))
	BEGIN
		SET @Msg = N'Tên giao dịch đã tồn tại'
		return
	END
	INSERT INTO GiaoDichLab09(TenDg, LoaiDg, GioDg, NgayDg, MoTa) VALUES(@TenDg, @LoaiDg, @GioDg, @NgayDg, @MoTa)
	SET @Msg=''

GO
CREATE PROC proc_giaodich_Update
@MaDg int,
@TenDg nvarchar(100) ,
@LoaiDg nvarchar(250) ,
@GioDg time ,
@NgayDg date ,
@MoTa nvarchar(250)
AS
	UPDATE GiaoDichLab09 SET TenDg=@TenDg, LoaiDg=@LoaiDg,GioDg=@GioDg, NgayDg=@NgayDg,MoTa=@MoTa WHERE MaDg=@MaDg

GO
-- Thủ tục xóa
CREATE PROC proc_giaodich_Delete
@MaDg int
AS
	DELETE FROM GiaoDichLab09 WHERE MaDg=@MaDg
go

CREATE PROC proc_giaodich_SearchByName
@TenDg nvarchar(100)
AS
	SELECT * FROM GiaoDichLab09 WHERE TenDg like '%'+@TenDg + '%'

GO
/*create proc proc_giaodich_date
@NgayDg date
as
	select count(*) as giaodich_date from GiaoDichLab09 where YEAR(NgayDg) = @NgayDg
go
exec proc_giaodich_date 25/11/2020
go*/
