use libraryStock;

create database libraryStock;

create table departmentInfo
( DeptID char (8) not null,
DeptName char (16) not null,
DeptFunc char (80),
DeptPhone varchar (15),
constraint pk_DeptID primary key(DeptID)
);  

create table stafferInfo
( StafferID char (6) not null,
  DeptID char (8) not null,
  StafferName varchar (8) not null,
  Sex char (2) not null,
  IdentityID char (18) not null,
  Position varchar (8),
  EnterLibraryDate Datetime,
  LeaveLibraryDate Datetime,
  Phone varchar (15),
  constraint pk_StafferID primary key(StafferID),
  constraint fk_DeptID foreign key(DeptID) references departmentInfo(DeptID)
  );

create table readerInfo
( ReaderID char (8) not null,
  ReaderName varchar (10) not null,
  Sex char (2) not null,
  IdentityID char (18) not null,
  CertificateDate Datetime,
  ReaderType char (6),
  Phone varchar (15),
  Address varchar(30),
  Password varchar(10),
  State varchar(4),
  primary key (ReaderID)
  );
  
  create table adminTable 
  (AdminName varchar(14) not null,
   Password varchar(10) not null,
   CardId varchar(18),
   State varchar(4) not null
   );
   
   create table CategoryTable
   (CategoryName varchar(10)
   );
  
  
  create table bookInfo
( BookID char (8) not null,
  BookName  varchar (18) not null,
  Author varchar (10),
  PublishingHouse varchar (48),
  Type varchar (6),
  BookPrice decimal,
  CategoryName varchar(10),
  ISBN varchar(15),
  constraint pk_BookID primary key(BookID)
  );

Create table storageInfo
(
StorageID char(8) not null,
BookID char (8) not null,
StafferID char (6) not null,
StorageAddress varchar (30) not null,
StorageDate Datetime,
AllMount int,
BorrowAmount int,
UnitPrice decimal,
AllPrice decimal,
ProviderID char(8),
State varchar(4),
ISBN varchar(15),
constraint pk_StorageID primary key(StorageID),
constraint fk_BookID foreign key(BookID) references bookInfo(BookID),
constraint fk_StafferID foreign key(StafferID) references stafferInfo(StafferID)
);

Create table providerInfo
( ProviderID  char(8) not null,
ProviderName  varchar  (30)  not  null,
ProviderAddress  varchar  (50),
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

create table returnBookInfo
(ReturnBookID char(8) not null,
ReturnID char (8) not null,
BorrowID char(8) not null,
ReaderID char(8) not null,
StorageID char (8) not null,
StafferID char (6) not null,
ReturnDate Datetime,
constraint pk_ReturnBookID primary key(ReturnBookID),
constraint fk_ReaderID1 foreign key(ReaderID) references readerInfo(ReaderID),
constraint fk_StafferID5 foreign key(StafferID) references stafferInfo(StafferID),
constraint fk_StorageID foreign key(StorageID) references storageInfo(StorageID)
);

select * from readerInfo;


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




