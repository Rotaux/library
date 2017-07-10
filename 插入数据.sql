

select * from adminTable;


use libraryStock;

/*插入管理员数据*/
insert into adminTable (AdminName,Password,CardId,State)
values ('admin','123','000001','激活');

select * from ReaderBorrowView where 读者编号 = '7';


/*插入图书表数据*/
insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
 ('000001','毛泽东传','(美)特里尔','人民大学出版社','可借','55','文学','7519750190531');
 
 insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
 ('000002','Java语言与面向对象程序设计','张利锋孙丽杨晓玲','清华大学出版社','可借','55.00','计算机','751975019753');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
   ('000003','Dreamweaver网页设计与制作教程','王春风、李勇、唐拥政、卢静','清华大学出版社','可借','49.00','计算机','751953570190537');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000004','时间移民','刘慈欣','江苏文艺出版社','可借','53.00','文学','7519750190531');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000005','海子的诗','海子','中国书店出版社','可借','25.00','科学','75197531510531');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
('000006','舒婷的诗','舒婷','人民文学出版社','可借','20.00','文学','75197513531');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000007','余光中经典作品','余光中','当代世界出版社','可借','23.00','文学','755310190531');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000008','做最好的自己','李开复','人民出版社','可借','43.00','文学','7519757519531');
 
  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000009','细节决定成败','汪中求','新华出版社','可借','30.00','文学','75197903195531');
  
    insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000010','人性的弱点全集','卡耐基','中国发展出版社','可借','15.00','艺术','751519190531');

  insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice,CategoryName,ISBN)
values
  ('000011','本草纲目','李时珍','中国书店出版社','可借','25.00','医学','751953750531');
  
  /*插入图书分类数据*/
  insert into CategoryTable(CategoryName)
  values('计算机'),
  ('科学'),
  ('文学'),
  ('医学'),
  ('艺术');

select * from CategoryTable;




select * from providerInfo;


/*插入供应商数据*/
insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000001','人民大学出版社','星河大街78号','343422','171084@qq.com','31973103573');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000002','清华大学出版社','绿景书城343号','343422','172344@qq.com','3193455573');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000003','江苏文艺出版社','寿望大街79号','343342','123444@qq.com','31342203573');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000004','人民文学出版社','汇景广场99号','343432','172352344@qq.com','31352103573');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000005','当代世界出版社','新世纪时代234号','398762','146354@qq.com','395313');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000006','中国书店出版社','绿景书城389号','30752','194574@qq.com','9053103');
  insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000007','人民出版社','百纳旧街78235号','346345','62345@qq.com','319051353');
    insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000008','新华出版社','新城735号','347575','62345@qq.com','3197125343');
    insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000009','中国发展出版社','京盛大街72345号','34325','1305391@qq.com','31075953');
    insert into providerInfo(ProviderID,ProviderName,ProviderAddress,PostCode,Email,Phone)
values
  ('000010','中国书店出版社','有条大街9527','353155','6275153@qq.com','3053193');
  
  

select * from storageInfo;
select * from bookInfo;
update bookInfo set ISBN = '51539531' where BookID = '000004';

/*插入库存数据*/
insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000001','000001','四楼232号',now(),1,1,55.00,AllMount*UnitPrice,'000001','可借','7519750190531');
 
 insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000002','000001','四楼111号',now(),1,1,75.00,AllMount*UnitPrice,'000002','可借','751975019753');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000003','000001','五楼333号',now(),1,1,25.00,AllMount*UnitPrice,'000002','可借','751953570190537');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000004','000001','五楼666号',now(),1,1,56.00,AllMount*UnitPrice,'000003','可借','75197190531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000005','000001','八楼555号',now(),1,1,23.00,AllMount*UnitPrice,'000010','可借','75197531510531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000006','000001','七楼778号',now(),1,1,65.00,AllMount*UnitPrice,'000004','可借','75197513531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000007','000001','四楼444号',now(),1,1,86.00,AllMount*UnitPrice,'000005','可借','755310190531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000008','000001','六楼666号',now(),1,1,23.00,AllMount*UnitPrice,'000007','可借','7519757519531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000009','000001','三楼222号',now(),1,1,65.00,AllMount*UnitPrice,'000008','可借','75197903195531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000010','000001','二楼235号',now(),1,1,62.00,AllMount*UnitPrice,'000009','可借','751519190531');
 
  insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
 ('000011','000001','四楼535号',now(),1,1,83.00,AllMount*UnitPrice,'000010','可借','751953750531');
 
 
 select * from readerInfo;
 
 /*插入读者信息*/
 insert into readerInfo(ReaderID,ReaderName,Sex,IdentityID,CertificateDate,ReaderType,Phone,Address,Password,State)
 values
    ('000001','小宇','男','35519010139',now(),'学生','51531','广东','456','激活');
 
 select * from adminTable;
 select * from stafferInfo;
 select * from departmentInfo;
 
 /*插入部门数据*/
 insert into departmentInfo(DeptID,DeptName,DeptFunc,DeptPhone)
 values
   ('01','管理部','管理各种事务','12345');
   
/*插入员工数据*/
insert into stafferInfo(StafferID,DeptID,StafferName,Sex,IdentityID,Position,Phone,Password,State)
values
  ('000001','01','admin','男','123456789','管理员','7303246','123','激活');
  
  
  select * from procurementInfo;
  
  insert into procurementInfo(ProviderID,StafferID,BookID,ProcurementDate,Amount,UnitPrice,AllPrice)
  values
    ('000001','000001','000001',now(),2,55,Amount*UnitPrice);
    
    select * from purchaseCarTable;
    
insert into purchaseCarTable(ProviderID,StafferID,BookID,ProcurementDate,Amount,UnitPrice,AllPrice)
  values
    ('000001','000001','000002',now(),2,75,Amount*UnitPrice);
  

update purchaseCarTable set BookID='000002',StafferID='000001',ProviderId='000001',ProcurementDate='2017-07-01',Amount='4',UnitPrice='77
',AllPrice = Amount*UnitPrice where BookID = '000002';



delete from procurementInfo where BookID = '000002';


  select * from readerInfo;


select * from storageInfo;

insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)
values
('000010','000001','九楼999号','2017-03-03','1','1','33',AllMount*UnitPrice,'000001','可借','3653476548');

update storageInfo set StorageAddress = 'ddd',State = '可阅' where StorageID = '100013';


update storageInfo set BookID='000011',StafferID='000001',StorageAddress='hhthth',StorageDate='2019-03-01',AllMount='1',BorrowAmount='1',UnitPrice='53',ProviderID='11',State='可借',ISBN='31531953',AllPrice = AllMount*UnitPrice where StorageID = '100013';


update storageInfo set ISBN = '51539531' where BookID = '000004';

select * from returnBookInfo;

select * from returnbookview;
delete from returnbookview where BookName='时间移民';

