
use lab_06
go
CREATE TABLE tblShoes(
	id int IDENTITY(1,1) NOT NULL,
	name nvarchar(32) ,
	price float,
	year int ,
	description nvarchar(64)
)
go
INSERT INTO tblShoes(name, price, year, description) VALUES ('Nike', 250 , 2016,'không')
INSERT INTO tblShoes(name, price, year, description) VALUES ('Adidas', 450 , 2019,'không')
INSERT INTO tblShoes(name, price, year, description) VALUES ('Balance 574', 150 , 2017,'không')
INSERT INTO tblShoes(name, price, year, description) VALUES ('Balance CRT300', 130 , 2016,'không')
GO
select *from tblShoes
go

CREATE PROC proc_getAllShoes
AS
	SELECT * FROM tblShoes order by name ASC 

GO

exec proc_getAllShoes
go

CREATE PROC proc_getShoesByName
@name nvarchar(100)
AS
	SELECT * FROM tblShoes WHERE name like '%' + @name + '%'

GO

CREATE PROC proc_addShoes
@name nvarchar(32) ,
@price float,
@year int ,
@description nvarchar(64),
@Msg nvarchar(100) OUT
AS
	if(EXISTS(SELECT * FROM tblShoes WHERE name like @name))
	BEGIN
		SET @Msg = N'Tên sản phẩm đã tồn tại'
		return
	END
	INSERT INTO tblShoes(name, price, year, description) VALUES(@name, @price, @year, @description)
	SET @Msg=''

GO
CREATE PROC proc_Update
@id int,
@name nvarchar(32) ,
@price float,
@year int ,
@description nvarchar(64)
AS
	UPDATE tblShoes SET name=@name, price=@price,year=@year, description=@description WHERE id=@id

GO
-- Thủ tục xóa
CREATE PROC proc_Delete
@id int
AS
	DELETE FROM tblShoes WHERE id=@id
go
