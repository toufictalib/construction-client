
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(225) NOT NULL,
  `county` tinyint(4) DEFAULT NULL,
  `caza` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `block` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `floor_nb` int(11) DEFAULT '0',
  `nb_flat_per_floor` int(11) DEFAULT '0',
  `flat_nb` int(11) DEFAULT '0',
  `store_nb` int(11) DEFAULT '0',
  `warehouse_nb` int(11) DEFAULT '0',
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_block_project` (`project_id`),
  CONSTRAINT `FK_block_project` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(225) NOT NULL,
  `address_id` bigint(20) NOT NULL,
  `date_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `date_creation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_project_address` (`address_id`),
  CONSTRAINT `FK_project_address` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


