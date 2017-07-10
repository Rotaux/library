use libraryStock;

create database libraryStock;
drop database libraryStock;

create table departmentInfo
( DeptID char (8) not null,
DeptName nvarchar (16) not null,
DeptFunc nvarchar (20),
DeptPhone varchar (15),
constraint pk_DeptID primary key(DeptID)
);  
alter table departmentInfo modify column DeptName nvarchar(16) not null;
alter table departmentInfo modify column DeptFunc nvarchar(20) not null;

create table stafferInfo
( StafferID char (6) not null,
  DeptID char (8) not null,
  StafferName nvarchar (8) not null,
  Sex nvarchar (2) not null,
  IdentityID char (18) not null,
  Position nvarchar (8),
  Phone varchar (15),
  Password varchar(10) not null,
  State nvarchar(10) not null,
  constraint pk_StafferID primary key(StafferID),
  constraint fk_DeptID foreign key(DeptID) references departmentInfo(DeptID)
  );
  
    drop table departmentInfo;

create table readerInfo
( ReaderID char (8) not null,
  ReaderName nvarchar (10) not null,
  Sex nvarchar(2) not null,
  IdentityID char (18) not null,
  CertificateDate Datetime,
  ReaderType nvarchar (6),
  Phone varchar (15),
  Address nvarchar(30),
  Password varchar(10),
  State nvarchar(4),
  primary key (ReaderID)
  );
   alter table readerInfo modify column Sex nvarchar(2) not null;
      alter table readerInfo modify column ReaderType nvarchar(6);
  drop table readerInfo;
  
  create table adminTable 
  (AdminName nvarchar(14) not null,
   Password varchar(10) not null,
   CardId varchar(18) not null,
   State nvarchar(4) not null
   );
   
   drop table adminTable;
   drop table CategoryTable;
   
   create table CategoryTable
   (CategoryName nvarchar(10)
   );
   
  
  
  create table bookInfo
( BookID char (8) not null,
  BookName  nvarchar (18) not null,
  Author nvarchar (10),
  PublishingHouse nvarchar (48),
  Type nvarchar (6),
  BookPrice decimal,
  CategoryName nvarchar(10),
  ISBN varchar(15),
  constraint pk_BookID primary key(BookID)
  );
  
  alter table bookInfo modify column BookName nvarchar(30) not null;
   alter table bookInfo modify column Author nvarchar(30) not null;

Create table storageInfo
(
StorageID int auto_increment primary key,
BookID char (8) not null,
StafferID varchar(18) not null,
StorageAddress nvarchar (30) not null,
StorageDate Datetime,
AllMount int,
BorrowAmount int,
UnitPrice decimal,
AllPrice decimal,
ProviderID char(8),
State nvarchar(4),
ISBN varchar(15),
constraint fk_BookID foreign key(BookID) references bookInfo(BookID)
);

drop table storageInfo;

alter table storageInfo auto_increment = 100000;

Create table providerInfo
( ProviderID  char(8) not null,
ProviderName  nvarchar  (30)  not  null,
ProviderAddress  nvarchar  (50),
PostCode char (6),
Email varchar (30),
Phone varchar (15),
constraint pk_ProviderID primary key(ProviderID)
);

create table borrowBookInfo
(BorrowBookID char(8) not null,
ReaderID char(8) not null,
BorrowDate Datetime,
ReturnDate Datetime,
BorrowID int auto_increment primary key,
StafferName  varchar(14),
constraint fk_ReaderID foreign key(ReaderID) references readerInfo(ReaderID)
);

alter table borrowBookInfo auto_increment = 100000;

create table returnBookInfo
(ReturnBookID char(8) not null,
ReturnID int auto_increment primary key,
BorrowID char(8) not null,
ReaderID char(8) not null,
StorageID char (8) not null,
StafferID char (6) not null,
ReturnDate Datetime
);

alter table returnBookInfo auto_increment = 100000;
select * from readerInfo;


create table procurementInfo
(
 ProcurementID   int auto_increment primary key,
 ProviderID char (8)  not null,
 StafferID char (6) not null,
 BookID char (8) not null,
 ProcurementDate Datetime,
 Amount int,
 UnitPrice decimal,
 AllPrice decimal,
 constraint fk_ProviderID foreign key(ProviderID) references providerInfo(ProviderID)
);

alter table procurementInfo auto_increment = 100000;

create table purchaseCarTable
(
 ProcurementID   int auto_increment primary key,
 ProviderID char (8)  not null,
 StafferID char (6) not null,
 BookID char (8) not null,
 ProcurementDate Datetime,
 Amount int,
 UnitPrice decimal,
 AllPrice decimal
);

alter table purchaseCarTable auto_increment = 1;







create view ReaderBorrowView 
as
    SELECT   borrowBookInfo.ReaderID AS 读者编号, borrowBookInfo.BorrowDate AS 借书时间, date_add(date_add(borrowBookInfo.BorrowDate,interval 1 day),interval 2 month) AS 应还时间, storageInfo.BookID AS 图书编号, bookInfo.ISBN AS ISBN号, 
                bookInfo.BookName AS 图书书名, bookInfo.Author AS 作者, bookInfo.PublishingHouse AS 出版社
FROM      borrowBookInfo INNER JOIN
                readerInfo ON borrowBookInfo.ReaderID = readerInfo.ReaderID INNER JOIN
                storageInfo ON borrowBookInfo.BorrowBookID = storageInfo.BookID INNER JOIN
                bookInfo ON storageInfo.ISBN = bookInfo.ISBN
WHERE   (borrowBookInfo.ReturnDate IS NULL);


create view ReturnBookView
as
        SELECT   readerInfo.ReaderName, storageInfo.BookID, storageInfo.ISBN, bookInfo.BookName, 
                borrowBookInfo.BorrowDate
FROM      readerInfo INNER JOIN
                storageInfo INNER JOIN
               borrowBookInfo ON storageInfo.BookID = borrowBookInfo.BorrowBookID INNER JOIN
               bookInfo ON storageInfo.ISBN = bookInfo.ISBN AND
              readerInfo.ReaderID = borrowBookInfo.ReaderID
WHERE   (borrowBookInfo.ReturnDate IS NULL);




