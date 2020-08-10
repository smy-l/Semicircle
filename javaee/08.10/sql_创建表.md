```sql
-- 创建管理员表
CREATE TABLE `administrator` (
  `id` varchar(30) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `pwd` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 创建用户表
CREATE TABLE `bidder` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `phone` varchar(30) NOT NULL,
  `address` varchar(100) NOT NULL,
  `postalCode` int(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 创建商品表
CREATE TABLE `product` (
  `id` varchar(30) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `startPrice` float(30,0) DEFAULT NULL,
  `lastPrice` float(30,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 创建记录表
CREATE TABLE `record` (
  `productId` varchar(30) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `money` float(30,0) DEFAULT NULL,
  `bidderId` varchar(30) DEFAULT NULL,
  `id` int(30) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 创建最终结果表
CREATE TABLE `result` (
  `productId` varchar(30),
  `bidderId` varchar(30) DEFAULT NULL,
  `price` float(30,0) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```

