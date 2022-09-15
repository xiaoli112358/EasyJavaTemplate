DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(30) NOT NULL COMMENT '用户账号',
  `email` varchar(50) DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) DEFAULT '' COMMENT '手机号码',
  `avatar` varchar(300) DEFAULT '' COMMENT '头像地址',
  `password` varchar(100) DEFAULT '' COMMENT '密码',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('109', 'admin', '1134135987@qq.com', '18086295423', 'https://easyjava.oss-cn-chengdu.aliyuncs.com/common/defaultUserImg.jpg', 'e10adc3949ba59abbe56e057f20f883e', '管理员账号', '2022-05-11 18:47:50', '109', '2022-05-11 18:47:50', '109');
INSERT INTO `sys_user` VALUES ('110', 'test', '测试账号', '18088888888', 'https://easyjava.oss-cn-chengdu.aliyuncs.com/common/defaultUserImg.jpg', 'e10adc3949ba59abbe56e057f20f883e', '123456', '2022-05-11 18:49:20', '109', '2022-06-07 12:58:06', '109');






DROP TABLE IF EXISTS `sys_emp`;
CREATE TABLE `sys_emp` (
`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
`user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工姓名',
`email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
`phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
`remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
`age` int(3) NULL DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_user_name` (`user_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- ----------------------------
-- Records of sys_emp
-- ----------------------------
INSERT INTO `sys_emp` VALUES (1, '张三', '1123600000@qq.com', '18011113330', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (2, '李四', '1123600001@qq.com', '18011113331', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (3, '王五', '1123600002@qq.com', '18011113332', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (4, '赵六', '1123600003@qq.com', '18011113333', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (5, '吴刚', '1123600004@qq.com', '18011113334', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (6, '李俊', '1123600005@qq.com', '18011113335', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (7, '肖亮', '1123600006@qq.com', '18011113336', '测试账号', 25);
INSERT INTO `sys_emp` VALUES (8, '张在军', '1123600007@qq.com', '18011113337', '测试账号', 25);