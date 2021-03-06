
DROP TABLE IF EXISTS `BA_USER`;
CREATE TABLE `BA_USER` (
  `USER_ID` varchar(200) NOT NULL,
  `TENANT_ID` bigint(20) NOT NULL,
  `CREATED_BY` varchar(75) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `MODIFIED_BY` varchar(75) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `ACCOUNT_EXPIRED` bit(1) DEFAULT NULL,
  `ACCOUNT_LOCKED` bit(1) DEFAULT NULL,
  `CREDENTIAL_EXPIRED` bit(1) DEFAULT NULL,
  `BIRTH_DATE` datetime DEFAULT NULL,
  `ACTIVE` bit(1) DEFAULT NULL,
  `EXPIRE_DATE` datetime DEFAULT NULL,
  `FAILED_COUNT` int(11) DEFAULT NULL,
  `FIRST_NAME` varchar(200) NOT NULL,
  `GENDER_CODE` varchar(255) DEFAULT NULL,
  `PHOTO` tinyblob,
  `LANGUAGE_ID` varchar(5) DEFAULT NULL,
  `LAST_LOGIN_DATE` datetime DEFAULT NULL,
  `LAST_NAME` varchar(200) NOT NULL,
  `MIDDLE_NAME` varchar(200) DEFAULT NULL,
  `IS_ONLINE` bit(1) DEFAULT NULL,
  `PASSWORD` varchar(200) NOT NULL,
  `PHONE_NUM` varchar(10) NOT NULL,
  `TERMINATION_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `BA_ROLE`;
CREATE TABLE `BA_ROLE` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TENANT_ID` bigint(20) NOT NULL,
  `CREATED_BY` varchar(75) NOT NULL,
  `CREATED_DATE` datetime NOT NULL,
  `MODIFIED_BY` varchar(75) DEFAULT NULL,
  `MODIFIED_DATE` datetime DEFAULT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `BA_PERMISSION`;
CREATE TABLE `BA_PERMISSION` (
  `PERMISSION_ID` bigint(20) NOT NULL,
  `DESCRIPTION` varchar(200) DEFAULT NULL,
  `NAME` varchar(50) NOT NULL,
  `TYPE` int(11) NOT NULL,
  PRIMARY KEY (`PERMISSION_ID`),
  UNIQUE KEY `UK_BA_PERMISSION_NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `BA_ROLE_PERMISSIONS`;
CREATE TABLE `BA_ROLE_PERMISSIONS` (
  `ROLE_ID` bigint(20) NOT NULL,
  `PERMISSION_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ROLE_ID`,`PERMISSION_ID`),
  KEY `FK_BA_ROLE_PERMISSIONS` (`PERMISSION_ID`),
  CONSTRAINT `FK_BA_ROLE_PERMISSIONS` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `BA_PERMISSION` (`PERMISSION_ID`),
  CONSTRAINT `FK_BA_ROLE_PERMISSIONS1` FOREIGN KEY (`ROLE_ID`) REFERENCES `BA_ROLE` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `BA_USER_ROLES`;
CREATE TABLE `BA_USER_ROLES` (
  `USER_ID` varchar(200) NOT NULL,
  `ROLE_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`USER_ID`,`ROLE_ID`),
  UNIQUE KEY `UK_BA_USER_ROLE` (`USER_ID`),
  KEY `FK_BA_USER_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_BA_USER_ROLE` FOREIGN KEY (`ROLE_ID`) REFERENCES `BA_ROLE` (`ROLE_ID`),
  CONSTRAINT `FK_BA_USER_ROLE1` FOREIGN KEY (`USER_ID`) REFERENCES `BA_USER` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `BA_PERM_ACTIONS`;
CREATE TABLE `BA_PERM_ACTIONS` (
  `ACTION_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `MASK` int(11) NOT NULL,
  `NAME` varchar(100) NOT NULL,
  `PERMISSION_ID` bigint(20) NOT NULL,
  PRIMARY KEY (`ACTION_ID`),
  KEY `FK_BA_PERM_ACTIONS` (`PERMISSION_ID`),
  CONSTRAINT `FK_BA_PERM_ACTIONS` FOREIGN KEY (`PERMISSION_ID`) REFERENCES `BA_PERMISSION` (`PERMISSION_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
