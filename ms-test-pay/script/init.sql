CREATE DATABASE `db_operation`;

CREATE TABLE `operation` (
                             `id_operation` bigint NOT NULL AUTO_INCREMENT,
                             `amount` decimal(19,2) DEFAULT NULL,
                             `date` datetime(6) DEFAULT NULL,
                             `id_invoice` bigint DEFAULT NULL,
                             PRIMARY KEY (`id_operation`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;