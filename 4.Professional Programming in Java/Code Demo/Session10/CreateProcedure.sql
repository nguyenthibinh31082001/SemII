create proc proc_category_getall

AS
SELECT * FROM Category

GO

create proc proc_category_getbyid
@CateId int
AS
SELECT * FROM Category WHERE CateId=@CateId

GO

create proc proc_category_insert
@CateId int,
@CateName nvarchar(100),
@ParentId int,
@ImgUrl nvarchar(100),
@Status bit,
@Error nvarchar(200) OUTPUT
AS
BEGIN 
IF NOT EXISTS(SELECT * FROM Category WHERE CateId=@CateId)
BEGIN
SET NOCOUNT ON;
INSERT INTO Category VALUES(@CateId, @CateName, @ParentId, @ImgUrl, @Status);
END
ELSE
BEGIN
 SET @Error = 'Id da ton tai'
END
END


exec proc_category_getall

exec proc_category_getbyid 3

DROP PROC proc_category_insert
exec proc_category_insert 11, 'THE THAO', 1,'http://localhost/',1