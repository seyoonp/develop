CREATE TABLE `tb_file` (
	`file_idx` INT(11) NOT NULL AUTO_INCREMENT COMMENT '파일고유번호',
	`org_file_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '원본파일명',
	`save_file_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '리네임파일명',
	`use_yn` CHAR(1) NULL DEFAULT 'N' COMMENT '사용여부',
	`ins_no` INT(11) NULL DEFAULT NULL COMMENT '등록자',
	`ins_date` DATETIME NULL DEFAULT NULL COMMENT '등록일',
	`upt_no` INT(11) NULL DEFAULT NULL COMMENT '수정자',
	`upt_date` DATE NULL DEFAULT NULL COMMENT '수정일',
	PRIMARY KEY (`file_idx`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;