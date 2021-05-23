DROP DATABASE IF EXISTS the_food_world;
CREATE DATABASE the_food_world;
USE the_food_world;

-- ************************************** `customer`*******************
CREATE TABLE `customer`
(
 `customer_id`       int AUTO_INCREMENT ,
 `customer_name`     varchar(45) NOT NULL ,
 `customer_phone`    varchar(45) NOT NULL ,
 `customer_birthday` date NOT NULL ,
 `customer_avatar`   text NULL ,
 `customer_address`  text NOT NULL,

PRIMARY KEY (`customer_id`)
);

-- ************************************** `account`
CREATE TABLE `account`
(
 `account_id`            int AUTO_INCREMENT ,
 `account_name`          varchar(45) NOT NULL ,
 `account_password`      text NOT NULL ,
 `account_email`		 varchar(45) NOT NULL,
 `account_status`        int NOT NULL ,
 `account_register_time` datetime NOT NULL ,
 `account_login_time`    datetime NOT NULL ,
 `customer_id`           int NOT NULL ,

PRIMARY KEY (`account_id`),
KEY `fkIdx_73` (`customer_id`),
CONSTRAINT `FK_72` FOREIGN KEY `fkIdx_73` (`customer_id`) REFERENCES `customer` (`customer_id`)
);

-- ************************************** `role`
CREATE TABLE `role`
(
 `role_id`   int AUTO_INCREMENT ,
 `role_name` varchar(45) NOT NULL ,

PRIMARY KEY (`role_id`)
);

-- ************************************** `account_role`
CREATE TABLE `account_role`
(
 `account_role_id` int AUTO_INCREMENT ,
 `account_id`      int NOT NULL ,
 `role_id`         int NOT NULL ,

PRIMARY KEY (`account_role_id`),
KEY `fkIdx_83` (`account_id`),
CONSTRAINT `FK_82` FOREIGN KEY `fkIdx_83` (`account_id`) REFERENCES `account` (`account_id`),
KEY `fkIdx_86` (`role_id`),
CONSTRAINT `FK_85` FOREIGN KEY `fkIdx_86` (`role_id`) REFERENCES `role` (`role_id`)
);

-- ************************************** `food_category`
CREATE TABLE `food_category`
(
 `food_category_id`   int AUTO_INCREMENT ,
 `food_category_name` varchar(45) NOT NULL ,

PRIMARY KEY (`food_category_id`)
);

-- ************************************** `food`
CREATE TABLE `food`
(
 `food_id`            int AUTO_INCREMENT ,
 `food_name`          TEXT NOT NULL ,
 `food_price`         double NOT NULL ,
 `food_status`        int NOT NULL ,   -- 0 : available ; 1 : not available
 `food_category_id`   int NOT NULL ,
 `food_image`         text NOT NULL ,
 `food_time_post`     date NOT NULL,
 `number_order`		  int NOT NULL,

PRIMARY KEY (`food_id`),
KEY `fkIdx_17` (`food_category_id`),
CONSTRAINT `FK_16` FOREIGN KEY `fkIdx_17` (`food_category_id`) REFERENCES `food_category` (`food_category_id`)
);

-- ************************************** `rating`
CREATE TABLE `rating`
(
 `rating_id`    int AUTO_INCREMENT ,
 `rating_level` int NOT NULL , -- 5 levels : 1 -> 5
 `food_id`      int NOT NULL ,
 `account_id`   int NOT NULL ,

PRIMARY KEY (`rating_id`),
KEY `fkIdx_38` (`food_id`),
CONSTRAINT `FK_37` FOREIGN KEY `fkIdx_38` (`food_id`) REFERENCES `food` (`food_id`),
KEY `fkIdx_89` (`account_id`),
CONSTRAINT `FK_88` FOREIGN KEY `fkIdx_89` (`account_id`) REFERENCES `account` (`account_id`)
);

-- ************************************** `comment`
CREATE TABLE `comment`
(
 `comment_id`      int AUTO_INCREMENT ,
 `comment_content` text NULL ,
 `comment_image`   text NULL ,
 `food_id`         int NOT NULL ,
 `account_id`      int NOT NULL ,
 `comment_time`    datetime NOT NULL ,

PRIMARY KEY (`comment_id`),
KEY `fkIdx_49` (`food_id`),
CONSTRAINT `FK_48` FOREIGN KEY `fkIdx_49` (`food_id`) REFERENCES `food` (`food_id`),
KEY `fkIdx_92` (`account_id`),
CONSTRAINT `FK_91` FOREIGN KEY `fkIdx_92` (`account_id`) REFERENCES `account` (`account_id`)
);

-- ************************************** `cart`
CREATE TABLE `cart`
(
 `cart_id`    int AUTO_INCREMENT ,
 `account_id` int NOT NULL ,

PRIMARY KEY (`cart_id`),
KEY `fkIdx_102` (`account_id`),
CONSTRAINT `FK_101` FOREIGN KEY `fkIdx_102` (`account_id`) REFERENCES `account` (`account_id`)
);

-- ************************************** `cart_food`
CREATE TABLE `cart_food`
(
 `cart_food_id` int AUTO_INCREMENT ,
 `cart_id`      int NOT NULL ,
 `food_id`      int NOT NULL ,
 `quantity`     int NOT NULL ,
 `note`         text NULL ,

PRIMARY KEY (`cart_food_id`),
KEY `fkIdx_108` (`cart_id`),
CONSTRAINT `FK_107` FOREIGN KEY `fkIdx_108` (`cart_id`) REFERENCES `cart` (`cart_id`),
KEY `fkIdx_111` (`food_id`),
CONSTRAINT `FK_110` FOREIGN KEY `fkIdx_111` (`food_id`) REFERENCES `food` (`food_id`)
);

-- ************************************** `order`
CREATE TABLE `order_bill`
(
 `order_id`         int AUTO_INCREMENT ,
 `account_id`       int NOT NULL ,
 `total`            double NOT NULL ,
 `delivery_address` text NOT NULL ,
 `method_payment`   int NOT NULL , 

PRIMARY KEY (`order_id`),
KEY `fkIdx_119` (`account_id`),
CONSTRAINT `FK_118` FOREIGN KEY `fkIdx_119` (`account_id`) REFERENCES `account` (`account_id`)
);

-- ************************************** `order_food`
CREATE TABLE `order_food`
(
 `order_food_id` int AUTO_INCREMENT ,
 `order_id`      int NOT NULL ,
 `cart_food_id`  int NOT NULL ,

PRIMARY KEY (`order_food_id`),
KEY `fkIdx_148` (`order_id`),
CONSTRAINT `FK_147` FOREIGN KEY `fkIdx_148` (`order_id`) REFERENCES `order_bill` (`order_id`),
KEY `fkIdx_151` (`cart_food_id`),
CONSTRAINT `FK_150` FOREIGN KEY `fkIdx_151` (`cart_food_id`) REFERENCES `cart_food` (`cart_food_id`)
);

-- ******************************************************************************************************
-- ******************************************************************************************************
-- ************************************** INPUT VALUES TO TABLES ****************************************


-- *********************************************** food_category *********************
INSERT INTO food_category (food_category_name) 
VALUES 
        ('Đồ chay'),
        ('Bánh kem'),
        ('Tráng miệng'),
        ('Vỉa hè'),
        ('Pizza/Burger'),
        ('Món gà'),
        ('Món lẩu'),
        ('Sushi'),
        ('Mì phở'),
        ('Cơm hộp');
       
-- *************************************************************** food *******************************************************       
INSERT into food (food_name, food_price, food_status, food_category_id, food_image, food_time_post, number_order)
VALUES 
	('Cơm chay( Mixed Rice)', 20000, 0, 1, 'https://images.foody.vn/res/g15/145635/s570x570/ce803887-f69e-4d63-bb48-4483386bda7e.jpg', '2021-04-15', 0),
    ('Mì Chay ( Noodles)', 20000, 0, 1, 'https://images.foody.vn/res/g15/145635/s570x570/9b1927ad-3168-4a41-9848-dbc521a2-9b57bd4a-201129100629.jpeg', '2021-04-15', 0),
    ('Bún Riêu Chay (Soup Noodles)', 20000, 0, 1, 'https://images.foody.vn/res/g15/145635/s570x570/3985fc39-a0ff-4ebf-9c2e-ddf4face-643688e4-201224112922.jpeg', '2021-04-15', 0),
    ('Cơm Chay Đặc Biệt', 30000, 0, 1, 'https://images.foody.vn/res/g15/145635/s570x570/ad65762a-2ab3-4d16-9d59-7921ea13-ad3ec0cb-201224113042.jpeg', '2021-04-15', 0),
    ('Bún Căn Nướng Trộn ( Dry Noodles)', 20000, 0, 1, 'https://images.foody.vn/res/g15/145635/s570x570/4ac8fe95-8958-46cd-b49d-32bb9a76-e7b99b70-201020114334.jpeg', '2021-04-15', 0),
    
    ('Bánh mì phô mai bơ tỏi', 25000, 0, 2, 'https://images.foody.vn/res/g69/681602/s570x570/8899466f-25f0-4dbf-867e-b5d8db7abc2a.jpg', '2021-04-15', 0),
    ('Bánh mì chả bò', 15000, 0, 2, 'https://images.foody.vn/res/g69/681602/s570x570/ef2f9bd9-3bba-430b-8163-3e85f2fc-df2d2d67-201109155731.jpeg', '2021-04-15', 0),
    ('Bánh sâu dừa phô mai', 12000, 0, 2, 'https://images.foody.vn/res/g19/182215/s570x570/2018620112811-banhs-sau-dua-472x378f.jpg', '2021-04-15', 0),
    ('Bánh sốt Hàn Quốc Bulgogi', 29000, 0, 2, 'https://images.foody.vn/res/g19/182215/s570x570/de5a37dd-3f13-414e-ab7a-4d18fa83-cbdf2a3c-210129100304.jpeg', '2021-04-15', 0),
    ('Bánh cuộn quế', 22000, 0, 2, 'https://images.foody.vn/res/g19/182215/s570x570/c60ab3bb-c74b-4119-87ac-36a31c6d-cbd969ce-210405153303.jpeg', '2021-04-15', 0),
    
    ('Chè Thái sầu riêng', 20000, 0, 3, 'https://images.foody.vn/res/g2/12567/s570x570/94a0a549-035d-4c75-ac5d-83ee91004ee1.jpg', '2021-04-15', 0),
    ('Rau câu phô mai', 15000, 0, 3, 'https://images.foody.vn/res/g2/12567/s570x570/20181239270-rau-cau-pho-mai.jpg', '2021-04-15', 0),
    ('Chè khoai dẻo đậu', 25000, 0, 3, 'https://images.foody.vn/res/g92/916002/s570x570/92e6ac93-fc98-47d4-7e2f-703d9e83046c.jpg', '2021-04-15', 0),
    ('TUYẾT YẾN MỸ NHÂN (chè dưỡng nhan)', 20000, 0, 3, 'https://images.foody.vn/res/g92/916002/s570x570/7faf1270-2fa9-4811-a72f-f3e69e530a28.jpeg', '2021-04-15', 0),
    ('Kem bơ đà nẵng', 22000, 0, 3, 'https://images.foody.vn/res/g92/916002/s570x570/8339172b-1132-434b-be5c-aedd84de-f4f8a124-210302130700.jpeg', '2021-04-15', 0),
    
	('Bánh tráng bơ', 23000, 0, 4, 'https://images.foody.vn/res/g11/100499/s570x570/b17c249c-6945-4674-92b7-24c9eec3d4c8.jpeg', '2021-04-15', 0),
    ('Xoài ruốc', 20000, 0, 4, 'https://images.foody.vn/res/g11/100499/s570x570/201853013444-foody-an-vat-truong-kim-dong-988-636551073670537268.jpg', '2021-04-15', 0),
    ('Tré trộn', 35000, 0, 4, 'https://images.foody.vn/res/g11/100499/s570x570/723750dc-aa6b-46a6-9b29-954e59aa-f6b9f203-210419145732.jpeg', '2021-04-15', 0),
    ('Bánh gạo cay', 33000, 0, 4, 'https://images.foody.vn/res/g92/916002/s570x570/7faf1270-2fa9-4811-a72f-f3e69e530a28.jpeg', '2021-04-15', 0),
    ('Trứng cút lộn', 14000, 0, 4, 'https://images.foody.vn/res/g11/109520/s570x570/0a246e32-7afb-4284-85cc-809d28ec-b5fad8c6-201115112954.jpeg', '2021-04-15', 0),
    
    ('Pizza thập cẩm size L', 109000, 0, 5, 'https://images.foody.vn/res/g74/732280/s570x570/fb804b19-9477-4bcd-9aac-ba6aa3435437.jpg', '2021-04-15', 0),
    ('Pizza gà Teriyaki size S', 39000, 0, 5, 'https://images.foody.vn/res/g74/732280/s570x570/226659e1-810f-4b9e-92f8-3210008e3e2d.jpeg', '2021-04-15', 0),
    ('Sandwich Gà Nướng mật ong (vỏ bánh burger)', 19000, 0, 5, 'https://images.foody.vn/res/g71/703190/s570x570/6a533795-797e-4f94-8e24-4c5804c8412b.jpg', '2021-04-15', 0),
    ('Burger bò phô mai', 39000, 0, 5, 'https://images.foody.vn/res/g71/703190/s570x570/2018228154840-img_3489.jpg', '2021-04-15', 0),
    ('Burger Hawaiian (lát bò & dứa nướng)', 39000, 0, 5, 'https://images.foody.vn/res/g71/703190/s570x570/0409ec31-c393-4dab-bcba-f4ea95f3f5d0.jpg', '2021-04-15', 0),
    
    ('Gà rán 2 miếng', 56000, 0, 6, 'https://images.foody.vn/res/g97/964342/s570x570/1ca9ccc9-6961-49df-a80e-6ec794d9417a.jpg', '2021-04-15', 0),
    ('Gà rán (đùi)', 30000, 0, 6, 'https://images.foody.vn/res/g97/964342/s570x570/758bb7bb-01af-42a0-a2b6-19be67cc-cbc152c7-201014145609.jpeg', '2021-04-15', 0),
    ('Gà rán (cánh)', 28000, 0, 6, 'https://images.foody.vn/res/g97/964342/s570x570/eb914319-fdcc-4d33-8b27-a88b631f-c36d4432-201010075504.jpeg', '2021-04-15', 0),
    ('Gà nướng muối ớt lá chanh', 199000, 0, 6, 'https://images.foody.vn/res/g105/1045790/s570x570/3bd1f21c-0cbf-4b1c-b2f4-7e1cf1ff-c0efc6f8-200923192743.jpeg', '2021-04-15', 0),
    ('Gà sốt cay Hàn Quốc', 100000, 0, 6, 'https://images.foody.vn/res/g105/1045790/s570x570/bfba98ca-92ae-41c6-b1fc-c700b9e6-236e4aa4-210310072221.jpeg', '2021-04-15', 0),
    
    ('Lẩu sườn bò', 250000, 0, 7, 'https://images.foody.vn/res/g2/12925/s570x570/f2135a13-6de3-4a8a-bb6e-05aa3098-71025e79-200929183529.jpeg', '2021-04-15', 0),
    ('Lẩu cá câu', 99000, 0, 7, 'https://images.foody.vn/res/g106/1058537/s570x570/c48fce5a-44fe-4cf3-b601-100d06d8-ac8b4059-201208195118.jpeg', '2021-04-15', 0),
    ('Lẩu hải sản', 195000, 0, 7, 'https://images.foody.vn/res/g91/908158/s570x570/4f1130bf-0a49-4913-9331-d40cbd63-aadbceb3-210514120422.jpeg', '2021-04-15', 0),
    ('Lẩu cá bớp', 199000, 0, 7, 'https://images.foody.vn/res/g91/908158/s570x570/fe273db3-f1f1-4384-bfe3-c2ad827f1f78.jpg', '2021-04-15', 0),
    ('Lẫu mực', 100000, 0, 7, 'https://images.foody.vn/res/g91/908158/s570x570/597dded5-df68-410f-b6ce-4d35c423-cc79f3ad-201129172410.jpeg', '2021-04-15', 0),
    
    ('Kimbap tôm tempura sốt trứng muối', 57000, 0, 8, 'https://images.foody.vn/res/g11/103795/s570x570/55a390ba-a180-42a6-a122-42430c12-a2939e64-200906110647.jpeg', '2021-04-15', 0),
    ('Kimbap trứng cuộn', 39000, 0, 8, 'https://images.foody.vn/res/g11/103795/s570x570/2018127154827-kimbap-trung-cuon.jpg', '2021-04-15', 0),
    ('Tokbokki truyền thống', 42000, 0, 8, 'https://images.foody.vn/res/g11/103795/s570x570/35c707dd-813e-4749-a3c8-701a1a2f7106.jpg', '2021-04-15', 0),
    ('Set cá hồi vs lươn tươi ngon', 149000, 0, 8, 'https://images.foody.vn/res/g73/726393/s570x570/492d47ae-5fd5-4972-b9e7-cfb29baa-8ba6abe1-210511214559.jpeg', '2021-04-15', 0),
    ('HỘP SUSHI LOVE 2', 218000, 0, 8, 'https://images.foody.vn/res/g73/726393/s570x570/6f65aa82-e093-42e1-b7a2-db3f3c48-dcb8f70d-201110172925.jpeg', '2021-04-15', 0),
    
    ('Bún đậu thập cẩm', 30000, 0, 9, 'https://images.foody.vn/res/g90/892174/s570x570/38618d95-9f99-44aa-9ee7-ee0adeb1d96d.jpg', '2021-04-15', 0),
    ('Bún thập cẩm', 40000, 0, 9, 'https://images.foody.vn/res/g77/763295/s570x570/2018823144937-bun-thap-cam.jpg', '2021-04-15', 0),
    ('Bún giò heo', 35000, 0, 9, 'https://images.foody.vn/res/g77/763295/s570x570/2018823144828-bun-gio-heo.jpg', '2021-04-15', 0),
    ('Bún bò Huế đặc biệt', 50000, 0, 9, 'https://images.foody.vn/res/g77/763295/s570x570/a89fdb37-8b5d-4566-b188-b46cc09e-4b530666-200929100105.jpeg', '2021-04-15', 0),
    ('Bún chả cua', 30000, 0, 9, 'https://images.foody.vn/res/g77/763295/s570x570/471ae694-4aac-42c0-9a97-8072f29d-bfec3583-200928112846.jpeg', '2021-04-15', 0),
    
    ('Cơm ba chỉ giòn da', 40000, 0, 10, 'https://images.foody.vn/res/g21/209552/s570x570/83faec13-b548-4ff2-a88c-bb3d4d7d-3ca943f5-210205134327.jpeg', '2021-04-15', 0),
    ('Cơm gà cánh', 50000, 0, 10, 'https://images.foody.vn/res/g21/209552/s570x570/df73772f-2036-469e-953c-24ef9379-46c402ef-210205134437.jpeg', '2021-04-15', 0),
    ('Cơm chiên dương châu', 40000, 0, 10, 'https://images.foody.vn/res/g21/209552/s570x570/1cd1406c-601f-419a-8a8a-6850e74c-1da6649a-210205134356.jpeg', '2021-04-15', 0),
    ('Cơm sườn rim', 35000, 0, 10, 'https://images.foody.vn/res/g21/209552/s570x570/c0cd6d68-ba34-4613-8df1-2f2f039d-242e7f50-210205134509.jpeg', '2021-04-15', 0),
    ('Cơm gà xé', 50000, 0, 10, 'https://images.foody.vn/res/g21/209552/s570x570/7f200c7e-49b9-4a66-8b11-fcf8327e-7437cfce-210205135910.jpeg', '2021-04-15', 0);
		
        
-- ******************************************************** customer ****************************************************
insert into customer (customer_name, customer_phone, customer_birthday, customer_avatar, customer_address)
values 
	('Lê Phước Thanh Cao', '0777542581', '1996-12-13', 'https://anhdep123.com/wp-content/uploads/2020/05/h%C3%ACnh-v%E1%BA%BD-m%C3%A8o-cute.jpg', '41b Mai Lão Bạng'),
    ('Phạm Châu', '0122755368', '1991-10-24', 'https://i.pinimg.com/originals/c6/72/e0/c672e04c9edaa5c8bd4679ef1a6d38af.jpg', '123 Hoàng Hoa Thám');
  
-- ******************************************************** account ****************************************************  
insert into account (account_name, account_password, account_email, account_status, account_register_time, account_login_time, customer_id)
values
	('leechoncaao', '$2y$12$O5l4LNddjCsTKD/EcsEmx.j9bLJKYIxzlJ5tj64QMJx26K6ZXrqX.', 'lephuocthanhcao@gmail.com', 0, '2021-05-16 07:39:00.000+07:00', '2021-05-16 08:39:00.000+07:00', 1),
    ('phamchau', '$2y$12$O5l4LNddjCsTKD/EcsEmx.j9bLJKYIxzlJ5tj64QMJx26K6ZXrqX.', 'hathaykhongbanghayhat18@gmail.com', 0, '2021-05-16 07:39:00.000+07:00', '2021-05-16 08:39:00.000+07:00', 2);
    
-- ******************************************************** role **************************************************** 
INSERT INTO `role` (role_name)
VALUES ('ADMIN'),
       ('MEMBER');
       
-- ******************************************************** account_role ****************************************************   
INSERT INTO `account_role`(account_id, role_id)
VALUES (1, 1),
       (2, 2);