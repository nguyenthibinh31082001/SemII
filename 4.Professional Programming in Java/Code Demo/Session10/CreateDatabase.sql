USE [master]
GO
/****** Object:  Database [DBTrainghiem]    Script Date: 11/5/2020 2:50:06 PM ******/
CREATE DATABASE [DBTrainghiem]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DBTrainghiem', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DBTrainghiem.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'DBTrainghiem_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\DBTrainghiem_log.ldf' , SIZE = 816KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [DBTrainghiem] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DBTrainghiem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DBTrainghiem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DBTrainghiem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DBTrainghiem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DBTrainghiem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DBTrainghiem] SET ARITHABORT OFF 
GO
ALTER DATABASE [DBTrainghiem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DBTrainghiem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DBTrainghiem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DBTrainghiem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DBTrainghiem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DBTrainghiem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DBTrainghiem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DBTrainghiem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DBTrainghiem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DBTrainghiem] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DBTrainghiem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DBTrainghiem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DBTrainghiem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DBTrainghiem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DBTrainghiem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DBTrainghiem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DBTrainghiem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DBTrainghiem] SET RECOVERY FULL 
GO
ALTER DATABASE [DBTrainghiem] SET  MULTI_USER 
GO
ALTER DATABASE [DBTrainghiem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DBTrainghiem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DBTrainghiem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DBTrainghiem] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [DBTrainghiem] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'DBTrainghiem', N'ON'
GO
USE [DBTrainghiem]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CateId] [int] NOT NULL,
	[CateName] [nvarchar](100) NULL,
	[ParentId] [int] NULL,
	[ImgUrl] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[CateId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProId] [int] IDENTITY(1,1) NOT NULL,
	[CateId] [int] NULL,
	[ProName] [nvarchar](100) NULL,
	[ShortName] [nvarchar](200) NULL,
	[Description] [ntext] NULL,
	[Warranty] [nvarchar](50) NULL,
	[Price] [float] NULL,
	[SalePrice] [float] NULL,
	[Quantity] [int] NULL,
	[Promotion] [nvarchar](100) NULL,
	[ProStatus] [nvarchar](30) NULL,
	[ImgUrl] [nvarchar](100) NULL,
	[ImgUrlBack] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ProId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductImage]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductImage](
	[ImageId] [int] IDENTITY(1,1) NOT NULL,
	[ProId] [int] NULL,
	[ImageUrl] [nvarchar](100) NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[ImageId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (1, N'Phụ kiện làm đẹp', 0, N'', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (2, N'Quần áo thời trang', 0, N'', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (3, N'Phụ kiện - AMAZE', 1, N'96fdfc7e25383e6042498db5ed85f941_thumb.png', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (4, N'Mỹ phẩm - AMAZE', 1, N'edcf3450afbcf84049fcd649feecd714_thumb.png', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (5, N'Đồ Jean - AMAZE', 2, N'618e3badab287154a7096a1b7a03ca3b_thumb.png', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (6, N'Áo đầm - AMAZE', 2, N'56c5ef35588f17c86cbd75d9e230f7fc_thumb.png', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (11, N'THE THAO', 1, N'http://localhost/', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (12, N'TEST', 0, N'http', 1)
INSERT [dbo].[Category] ([CateId], [CateName], [ParentId], [ImgUrl], [Status]) VALUES (13, N'TEST', 0, N'http', 1)
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (1, 3, N'Phụ Kiện - Amaze 1', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 800000, 0, 100, N'1 cây viết', N'hot', N'82c6601a48f60c3e56611514b1166a85.jpg', N'4dd9686ff2094d4059b2b0de8d6dbc92.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (2, 3, N'Phụ Kiện - Amaze 2', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 500000, 0, 100, N'Tặng balo thời trang', N'hot', N'9a406b3de7ae5661bf2d0ac7538b9a9e.jpg', N'9feb11a8ad71aa27396457a754424ca7.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (3, 3, N'Phụ Kiện - Amaze 3', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 200000, 0, N'Tặng balo thời trang', N'Bán chạy', N'3fb6a3e017572958b1202d1cce3c6ffd.jpg', N'65747f33a83a8a7e75b1437b439e4ad6.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (4, 3, N'Phụ Kiện - Amaze 4', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 500000, 0, 100, N'1 cây viết', N'mới', N'4d653922fa72b8649b2c3b88742f6234.jpg', N'3c9d3dc849099659c75d9edd4357474c.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (5, 4, N'amazefashion - Sản Phẩm DEMO 1', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 10, N'Giảm 10% cho sản phẩm', N'hot', N'9787f0e7dc61ec80d439807bfaa9a389.jpg', N'278fc2b204a0d35a466c28da09bf701b.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (6, 4, N'amazefashion - Sản Phẩm DEMO 2', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 100, N'Giảm 10% cho sản phẩm', N'', N'dd2b2af7d2c52fd9bc595f61e7326e82.jpg', N'278fc2b204a0d35a466c28da09bf701b.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (7, 4, N'amazefashion - Sản Phẩm DEMO 3', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 100, N'Giảm 10% cho sản phẩm', N'hot', N'a25cb1b813e1d701d3a56530b1c812a0.jpg', N'f292b2f6a2a5e389e845aa789ce5082c.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (8, 4, N'amazefashion - Sản Phẩm DEMO 4', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 800000, 0, 100, N'1 cây viết', N'mới', N'78956805d8e99591fcc3ce075a9172c3.jpg', N'be4c5f41e1a1f18ab7be17fb66fd280d.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (9, 5, N'Đồ jean - Amaze 1', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 800000, 200000, 100, N'', N'hot', N'9357681a8984f6b459aac99614e92104.jpg', N'be4c5f41e1a1f18ab7be17fb66fd280d.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (10, 5, N'Đồ jean - Amaze 2', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 0, 10, N'', N'hot', N'b58ba41a45db4adb709321254ea17f0e.jpg', N'ae29bf302467a09bd441fcf9cf08639c.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (11, 5, N'Đồ jean - Amaze 3', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 100, N'Giảm 10% cho sản phẩm', N'hot', N'839f3abac7b9cd8117ee0c6a6a9fb9af.jpg', N'f9f657cb81d62e7615dcd135f6537478.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (12, 5, N'Đồ jean - Amaze 4', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 100, N'Giảm 10% cho sản phẩm', N'mới', N'987d4a14e23f35ef335e8b919ab7fe26.jpg', N'b2dbfc467e24191136257165c5cf80ad.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (13, 5, N'Đồ jean - Amaze 5', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 600000, 20000, 100, N'1 cây viết', N'mới', N'1ad016a1d86cec7c02f07b05296c6181.jpg', N'839f3abac7b9cd8117ee0c6a6a9fb9af.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (14, 6, N'Đồ đầm - Amaze 1', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1000000, 100000, 100, N'1 cây viết', N'hot', N'7496c17800976c44dbf1277f6c183c83.jpg', N'7496c17800976c44dbf1277f6c183c83.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (15, 6, N'Đồ đầm - Amaze 2', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 900000, 50000, 100, N'1 cây viết', N'hot', N'b58ba41a45db4adb709321254ea17f0e.jpg', N'b58ba41a45db4adb709321254ea17f0e.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (16, 6, N'Đồ đầm - Amaze 3', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 900000, 90000, 100, N'Giảm 10% cho sản phẩm', N'hot', N'9064bad43ade26208e251288de5fc299.jpg', N'9064bad43ade26208e251288de5fc299.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (17, 6, N'Đồ đầm - Amaze 4', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 1200000, 120000, 100, N'Giảm 10% cho sản phẩm', N'mới', N'9064bad43ade26208e251288de5fc299.jpg', N'9064bad43ade26208e251288de5fc299.jpg', 1)
INSERT [dbo].[Product] ([ProId], [CateId], [ProName], [ShortName], [Description], [Warranty], [Price], [SalePrice], [Quantity], [Promotion], [ProStatus], [ImgUrl], [ImgUrlBack], [Status]) VALUES (18, 6, N'Đồ đầm - Amaze 5', N'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco', N'The standard Lorem Ipsum passage, used since the 1500s

"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."<br/><img src=''/><br/>Section 1.10.32 of "de Finibus Bonorum et Malorum", written by Cicero in 45 BC

"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?"<br/><img src=''/>', N'12 tháng', 800000, 0, 20, N'', N'mới', N'd26fb9122a2cbbcf893b47bde75005a5.jpg', N'd26fb9122a2cbbcf893b47bde75005a5.jpg', 1)
SET IDENTITY_INSERT [dbo].[Product] OFF
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([CateId])
REFERENCES [dbo].[Category] ([CateId])
GO
ALTER TABLE [dbo].[ProductImage]  WITH CHECK ADD FOREIGN KEY([ProId])
REFERENCES [dbo].[Product] ([ProId])
GO
/****** Object:  StoredProcedure [dbo].[proc_category_getall]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[proc_category_getall]

AS
SELECT * FROM Category
GO
/****** Object:  StoredProcedure [dbo].[proc_category_getbyid]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create proc [dbo].[proc_category_getbyid]
@CateId int
AS
SELECT * FROM Category WHERE CateId=@CateId
GO
/****** Object:  StoredProcedure [dbo].[proc_category_insert]    Script Date: 11/5/2020 2:50:06 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[proc_category_insert]
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
GO
USE [master]
GO
ALTER DATABASE [DBTrainghiem] SET  READ_WRITE 
GO
