CREATE DATABASE ProductManagement
GO
use ProductManagement

GO 
CREATE TABLE Product(
	ProductId int identity primary key,
--	ProductId varchar(10) 
	ProductName nvarchar(100),
	Price float,
	Producer nvarchar(100),
	DateCreated date,
	Status bit
)

GO 
-- Thêm mới dữ liệu
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('NOTE 8', 18000, 'Sam Sung Viet Nam', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('NOTE 9', 19000, 'Sam Sung Viet Nam', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('NOTE 10', 20000, 'Sam Sung Viet Nam', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('NOTE 11', 22000, 'Sam Sung Viet Nam', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('NOTE 12', 25000, 'Sam Sung Viet Nam', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('Iphone 11', 22000, 'Apple', '2020-11-20',1)
INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES ('Iphone 12', 27000, 'Apple', '2020-11-20',1)

-- Tạo thủ tục lấy tất cả sản phẩm có trong database
GO
CREATE PROC proc_product_GetAll
AS
	SELECT * FROM Product

GO
-- Tạo thủ tục lấy sản phẩm theo ProductId
CREATE PROC proc_product_GetById
@ProductId int
AS
	SELECT * FROM Product WHERE ProductId = @ProductId

GO
-- Thủ tục tìm kiếm sản phẩm theo tên
CREATE PROC proc_product_SearchByName
@ProductName nvarchar(100)
AS
	SELECT * FROM Product WHERE ProductName like '%'+@ProductName + '%'

GO
-- Thủ tục thêm sản phẩm
CREATE PROC proc_product_Insert
@ProductName nvarchar(100),
@Price float,
@Producer nvarchar(100),
	@DateCreated date,
	@Status bit,
	@Msg nvarchar(100) OUT
AS
	if(EXISTS(SELECT * FROM Product WHERE ProductName like @ProductName))
	BEGIN
		SET @Msg = N'Tên sản phẩm đã tồn tại'
		return
	END
	INSERT INTO Product(ProductName, Price, Producer, DateCreated, Status) VALUES(@ProductName, @Price, @Producer, @DateCreated, @Status)
	SET @Msg=''

GO
-- Thủ tục sửa sản phẩm
CREATE PROC proc_product_Update
@ProcuctId int,
@ProductName nvarchar(100),
@Price float,
@Producer nvarchar(100),
@DateCreated date,
@Status bit
AS
	UPDATE Product SET ProductName=@ProductName, Price=@Price,Producer=@Producer, DateCreated=@DateCreated,Status=@Status WHERE ProductId=@ProcuctId

GO
-- Thủ tục xóa
CREATE PROC proc_product_Delete
@ProductId int
AS
	DELETE FROM Product WHERE ProductId=@ProductId



-- Kiểm tra thủ tục
EXEC proc_product_GetAll