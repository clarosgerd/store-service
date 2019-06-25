/***********************************************************************************************/
CREATE PROCEDURE GetAllBuy
AS
    SELECT * FROM Buy;
    GO
/***********************************************************************************************/
CREATE PROCEDURE GetAllSstatus
AS
    SELECT * FROM status;
    GO
/***********************************************************************************************/
CREATE PROCEDURE GetAllClient
AS
    SELECT * FROM client;
    GO
/***********************************************************************************************/
CREATE PROCEDURE GetAllProduct
AS
    SELECT * FROM product;
    GO
/***********************************************************************************************/
CREATE PROCEDURE GetAllProvider
AS
    SELECT * FROM provider;
    GO
/***********************************************************************************************/
CREATE PROCEDURE GetAllImageFile
AS
    SELECT * FROM image_file;
    GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

/***********************************************************************************************/
CREATE PROCEDURE [dbo].[SaveBill]
    @billCode nvarchar(50)
    ,@isDeleted BIT
    ,@nit nvarchar(50)
    ,@totalPay int
    ,@createdAt DATE
    ,@version int

AS
    insert into bill (bill_code,is_deleted,nit,total_pay,created_at,version) values( @billCode,@isDeleted,@nit,@totalPay,@createdAt,@version )
    (select * from Bill where id = SCOPE_IDENTITY())
    return
GO

