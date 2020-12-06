--create database lab_06
--go
use lab_06
go
CREATE TABLE [dbo].[ProductLab7_1](
	ProductId int IDENTITY(1,1) NOT NULL,
	CatelogId int NULL,
	ProductName nvarchar(100) NULL,
	Content nvarchar(250) NULL,
	ContentDetail ntext NULL,
	PriceInput float NULL,
	PriceOutput float NULL,
	Created date NULL,
	Views int NULL,
	BuyItem int NULL,
	Status bit NULL

)

create proc proc_product_count_date
@YEAR int
as
	select count(*) as SoNam from [ProductLab7_1] where YEAR(Created) = @YEAR
go
exec proc_product_count_date 2000
go
select *from [dbo].[ProductLab7_1]
go