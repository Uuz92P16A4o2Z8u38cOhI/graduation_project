/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : graduation_ui

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 14/05/2020 09:50:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for awards
-- ----------------------------
DROP TABLE IF EXISTS `awards`;
CREATE TABLE `awards`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ACADEMIC_HONORS` bigint(18) NULL DEFAULT NULL COMMENT '学术荣誉',
  `SCIENTIFIC_AWARDS` bigint(18) NULL DEFAULT NULL COMMENT '科研奖项',
  `OTHER_AWARDS` bigint(18) NULL DEFAULT NULL COMMENT '其它获奖',
  `HONORARY_TITLE` bigint(18) NULL DEFAULT NULL COMMENT '荣誉称号',
  `HONOR_WALL` bigint(18) NULL DEFAULT NULL COMMENT '荣誉墙',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968498508894209 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '获奖信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of awards
-- ----------------------------
INSERT INTO `awards` VALUES (699555422746578944, 699555422750773248, 699555422750773249, 699555422750773250, 699555422750773251, NULL, 1, '2020-04-14 09:43:04', 0);
INSERT INTO `awards` VALUES (707920900116844544, 707920900116844545, 707920900116844549, 707920900116844548, 707920900116844546, 707920900116844547, 1, '2020-05-07 11:44:55', 707920896467800064);
INSERT INTO `awards` VALUES (707957772075536384, 707957772075536385, 707957772075536389, 707957772075536388, 707957772075536386, 707957772075536387, 1, '2020-05-07 14:11:26', 707957770360066048);
INSERT INTO `awards` VALUES (707965957620502528, 707965957620502529, 707965957620502533, 707965957620502532, 707965957620502530, 707965957620502531, 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `awards` VALUES (707968498508894208, 707968498508894209, 707968498508894213, 707968498508894212, 707968498508894210, 707968498508894211, 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for awards_item
-- ----------------------------
DROP TABLE IF EXISTS `awards_item`;
CREATE TABLE `awards_item`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ITEM_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `ITEM_CONTENT` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `PARENT_ID` bigint(18) NULL DEFAULT NULL,
  `TYPE` tinyint(2) NULL DEFAULT NULL COMMENT '1、学术荣誉2、科研奖项3、其它获奖4、荣誉称号5、荣誉墙',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968498622140417 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '获奖项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of awards_item
-- ----------------------------
INSERT INTO `awards_item` VALUES (699555422750773255, '校优秀多媒体课件奖', '', 699555422750773249, 2);
INSERT INTO `awards_item` VALUES (699555422754967552, '校优秀多媒体课件奖', '', 699555422750773249, 2);
INSERT INTO `awards_item` VALUES (699555422754967553, '2011年校级优秀教学成果奖', '', 699555422750773249, 2);
INSERT INTO `awards_item` VALUES (699555422754967554, '2010年校教学成果奖（本科教学）', '', 699555422750773249, 2);
INSERT INTO `awards_item` VALUES (699555422759161856, '优秀课程', '', 699555422750773249, 2);
INSERT INTO `awards_item` VALUES (699555422759161857, '2019年春季本科课程教学示范教师 （2019年）', '', 699555422750773250, 3);
INSERT INTO `awards_item` VALUES (699555422759161858, '大连理工大学优秀硕士研究生指导教师 （2019年）', '', 699555422750773250, 3);
INSERT INTO `awards_item` VALUES (699555422763356160, '教育部在线教育研究中心2019年智慧教学之星 （2019年）', '', 699555422750773250, 3);
INSERT INTO `awards_item` VALUES (699555422763356161, '大连理工大学教学质量优秀奖（研究生类） （2017年）', '', 699555422750773250, 3);
INSERT INTO `awards_item` VALUES (699555422763356162, '第九届辽宁省普通高等学校本科教学名师奖 （2013年）', '', 699555422750773250, 3);
INSERT INTO `awards_item` VALUES (707920900129427456, '校优秀多媒体课件奖', NULL, 707920900116844549, 2);
INSERT INTO `awards_item` VALUES (707920900158787584, '校优秀多媒体课件奖', NULL, 707920900116844549, 2);
INSERT INTO `awards_item` VALUES (707920900171370496, '2011年校级优秀教学成果奖', NULL, 707920900116844549, 2);
INSERT INTO `awards_item` VALUES (707920900179759104, '2010年校教学成果奖（本科教学）', NULL, 707920900116844549, 2);
INSERT INTO `awards_item` VALUES (707920900192342016, '优秀课程', NULL, 707920900116844549, 2);
INSERT INTO `awards_item` VALUES (707920900200730624, '2019年春季本科课程教学示范教师 （2019年）', NULL, 707920900116844548, 3);
INSERT INTO `awards_item` VALUES (707920900217507840, '大连理工大学优秀硕士研究生指导教师 （2019年）', NULL, 707920900116844548, 3);
INSERT INTO `awards_item` VALUES (707920900225896448, '教育部在线教育研究中心2019年智慧教学之星 （2019年）', NULL, 707920900116844548, 3);
INSERT INTO `awards_item` VALUES (707920900234285056, '大连理工大学教学质量优秀奖（研究生类） （2017年）', NULL, 707920900116844548, 3);
INSERT INTO `awards_item` VALUES (707920900242673664, '第九届辽宁省普通高等学校本科教学名师奖 （2013年）', NULL, 707920900116844548, 3);
INSERT INTO `awards_item` VALUES (707957772092313600, '校优秀多媒体课件奖', NULL, 707957772075536389, 2);
INSERT INTO `awards_item` VALUES (707957772117479424, '校优秀多媒体课件奖', NULL, 707957772075536389, 2);
INSERT INTO `awards_item` VALUES (707957772130062336, '2011年校级优秀教学成果奖', NULL, 707957772075536389, 2);
INSERT INTO `awards_item` VALUES (707957772138450944, '2010年校教学成果奖（本科教学）', NULL, 707957772075536389, 2);
INSERT INTO `awards_item` VALUES (707957772151033856, '优秀课程', NULL, 707957772075536389, 2);
INSERT INTO `awards_item` VALUES (707957772163616768, '2019年春季本科课程教学示范教师 （2019年）', NULL, 707957772075536388, 3);
INSERT INTO `awards_item` VALUES (707957772176199680, '大连理工大学优秀硕士研究生指导教师 （2019年）', NULL, 707957772075536388, 3);
INSERT INTO `awards_item` VALUES (707957772188782592, '教育部在线教育研究中心2019年智慧教学之星 （2019年）', NULL, 707957772075536388, 3);
INSERT INTO `awards_item` VALUES (707957772197171200, '大连理工大学教学质量优秀奖（研究生类） （2017年）', NULL, 707957772075536388, 3);
INSERT INTO `awards_item` VALUES (707957772209754112, '第九届辽宁省普通高等学校本科教学名师奖 （2013年）', NULL, 707957772075536388, 3);
INSERT INTO `awards_item` VALUES (707965957633085440, '校优秀多媒体课件奖', NULL, 707965957620502533, 2);
INSERT INTO `awards_item` VALUES (707965957654056960, '校优秀多媒体课件奖', NULL, 707965957620502533, 2);
INSERT INTO `awards_item` VALUES (707965957662445568, '2011年校级优秀教学成果奖', NULL, 707965957620502533, 2);
INSERT INTO `awards_item` VALUES (707965957675028480, '2010年校教学成果奖（本科教学）', NULL, 707965957620502533, 2);
INSERT INTO `awards_item` VALUES (707965957679222784, '优秀课程', NULL, 707965957620502533, 2);
INSERT INTO `awards_item` VALUES (707965957687611392, '2019年春季本科课程教学示范教师 （2019年）', NULL, 707965957620502532, 3);
INSERT INTO `awards_item` VALUES (707965957700194304, '大连理工大学优秀硕士研究生指导教师 （2019年）', NULL, 707965957620502532, 3);
INSERT INTO `awards_item` VALUES (707965957704388608, '教育部在线教育研究中心2019年智慧教学之星 （2019年）', NULL, 707965957620502532, 3);
INSERT INTO `awards_item` VALUES (707965957712777216, '大连理工大学教学质量优秀奖（研究生类） （2017年）', NULL, 707965957620502532, 3);
INSERT INTO `awards_item` VALUES (707965957721165824, '第九届辽宁省普通高等学校本科教学名师奖 （2013年）', NULL, 707965957620502532, 3);
INSERT INTO `awards_item` VALUES (707968498525671424, '校优秀多媒体课件奖', NULL, 707968498508894213, 2);
INSERT INTO `awards_item` VALUES (707968498542448640, '校优秀多媒体课件奖', NULL, 707968498508894213, 2);
INSERT INTO `awards_item` VALUES (707968498555031552, '2011年校级优秀教学成果奖', NULL, 707968498508894213, 2);
INSERT INTO `awards_item` VALUES (707968498563420160, '2010年校教学成果奖（本科教学）', NULL, 707968498508894213, 2);
INSERT INTO `awards_item` VALUES (707968498576003072, '优秀课程', NULL, 707968498508894213, 2);
INSERT INTO `awards_item` VALUES (707968498580197376, '2019年春季本科课程教学示范教师 （2019年）', NULL, 707968498508894212, 3);
INSERT INTO `awards_item` VALUES (707968498588585984, '大连理工大学优秀硕士研究生指导教师 （2019年）', NULL, 707968498508894212, 3);
INSERT INTO `awards_item` VALUES (707968498601168896, '教育部在线教育研究中心2019年智慧教学之星 （2019年）', NULL, 707968498508894212, 3);
INSERT INTO `awards_item` VALUES (707968498609557504, '大连理工大学教学质量优秀奖（研究生类） （2017年）', NULL, 707968498508894212, 3);
INSERT INTO `awards_item` VALUES (707968498622140416, '第九届辽宁省普通高等学校本科教学名师奖 （2013年）', NULL, 707968498508894212, 3);

-- ----------------------------
-- Table structure for basic_info
-- ----------------------------
DROP TABLE IF EXISTS `basic_info`;
CREATE TABLE `basic_info`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `NICK_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `SEX` int(1) NULL DEFAULT NULL COMMENT '性别：1、男  0、女',
  `BIRTHDAY` date NULL DEFAULT NULL COMMENT '出生日期',
  `POLITICAL_STATUS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '政治面貌 0、无1、团员、2、党员',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `HOMETOWN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `AVATAT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `FAX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '传真',
  `EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮件',
  `QQ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QQ',
  `WECHAT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信',
  `BLOG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '博客',
  `POST_CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮编',
  `ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `DEPARTMENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门/学院',
  `DEGREE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学位',
  `SUBJECT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学科',
  `POSITION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `JOB_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职称',
  `INTRODUCTION` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '个人简介',
  `RESEARCH_AREAS` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '研究领域',
  `UNIT_ID` int(8) NULL DEFAULT NULL COMMENT '所属学院',
  `SCHOOL_ID` int(8) NULL DEFAULT NULL COMMENT '所属学校',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本id',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968496583708673 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '基础信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of basic_info
-- ----------------------------
INSERT INTO `basic_info` VALUES (700302286920093696, '菜虚堃', '练习生', 0, '1998-03-16', '党员', 21, '四川成都', 'group1/M00/00/00/wKhbgF6dZJaAT5uTAAAICOJst0s557.gif', '15223654862', ' 0451-86402323', '2963487848@qq.com', '2546615650', '', 'https://element.eleme.cn/#/zh-CN', '610000', '长安城长安路110号', '航天学院', '博士', ' 力学', '教授', '博士生导师', '张鲁，博士，副研究员，硕士生导师。主要研究领域：多自由度磁悬浮平面电机及相关技术、直线电机及相关技术、磁悬浮相关技术、高速电机系统等；在《IEEE Transactions on Magnetics》、《Journal of Applied Physics》、《Energies》、《中国电机工程学报》、《电工技术学报》等国内外学术刊物上发表论文40余篇，其中SCI/EI检索28篇；获授权国家发明专利36项；美国发明专利2项；获教育部技术发明二等奖1项；以负责人或主要参与人身份主持、参与国家自然科学基金、国家自然科学基金重点项目、国家科技重大专项、中国博士后基金特别资助项目、中国博士后基金面上项目、黑龙江省自然科学基金等项目20多项。', '自动控制理论(网络化控制、多智能体系统、鲁棒与智能控制)\r\n\r\n信号处理、图像处理、模式识别\r\n\r\n自动光学检测(AOI: Automatic Optical Inspection)\r\n\r\n光机电一体化技术(高速高精度运动控制、贴片机、视觉伺服)\r\n\r\n机器人智能系统(面向复杂任务的工业机器人、机器人智能工艺系统、智能人机交互技术)', 1, 10621, 1, '2020-04-16 11:11:16', 0);
INSERT INTO `basic_info` VALUES (707957770464923648, '菜虚', '练习生', NULL, '1998-03-16', '党员', 21, '四川成都', NULL, '15223654862', ' 0451-86402323', '2963487848@qq.com', '2546615650', NULL, 'https://element.eleme.cn/#/zh-CN', '610000', '长安城长安路110号', '航天学院', '博士', ' 力学', '教授', '博士生导师', '张鲁，博士，副研究员，硕士生导师。主要研究领域：多自由度磁悬浮平面电机及相关技术、直线电机及相关技术、磁悬浮相关技术、高速电机系统等；在《IEEE Transactions on Magnetics》、《Journal of Applied Physics》、《Energies》、《中国电机工程学报》、《电工技术学报》等国内外学术刊物上发表论文40余篇，其中SCI/EI检索28篇；获授权国家发明专利36项；美国发明专利2项；获教育部技术发明二等奖1项；以负责人或主要参与人身份主持、参与国家自然科学基金、国家自然科学基金重点项目、国家科技重大专项、中国博士后基金特别资助项目、中国博士后基金面上项目、黑龙江省自然科学基金等项目20多项。', '自动控制理论(网络化控制、多智能体系统、鲁棒与智能控制)\r\n\r\n信号处理、图像处理、模式识别\r\n\r\n自动光学检测(AOI: Automatic Optical Inspection)\r\n\r\n光机电一体化技术(高速高精度运动控制、贴片机、视觉伺服)\r\n\r\n机器人智能系统(面向复杂任务的工业机器人、机器人智能工艺系统、智能人机交互技术)', 1, 10621, 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `basic_info` VALUES (707965956269936640, '菜虚堃', '练习生', NULL, '1998-03-16', '党员', 21, '四川成都', NULL, '15223654862', ' 0451-86402323', '2963487848@qq.com', '2546615650', NULL, 'https://element.eleme.cn/#/zh-CN', '610000', '长安城长安路110号', '航天学院', '博士', ' 力学', '教授', '博士生导师', '张鲁，博士，副研究员，硕士生导师。主要研究领域：多自由度磁悬浮平面电机及相关技术、直线电机及相关技术、磁悬浮相关技术、高速电机系统等；在《IEEE Transactions on Magnetics》、《Journal of Applied Physics》、《Energies》、《中国电机工程学报》、《电工技术学报》等国内外学术刊物上发表论文40余篇，其中SCI/EI检索28篇；获授权国家发明专利36项；美国发明专利2项；获教育部技术发明二等奖1项；以负责人或主要参与人身份主持、参与国家自然科学基金、国家自然科学基金重点项目、国家科技重大专项、中国博士后基金特别资助项目、中国博士后基金面上项目、黑龙江省自然科学基金等项目20多项。', '自动控制理论(网络化控制、多智能体系统、鲁棒与智能控制)\r\n\r\n信号处理、图像处理、模式识别\r\n\r\n自动光学检测(AOI: Automatic Optical Inspection)\r\n\r\n光机电一体化技术(高速高精度运动控制、贴片机、视觉伺服)\r\n\r\n机器人智能系统(面向复杂任务的工业机器人、机器人智能工艺系统、智能人机交互技术)', 1, 10621, 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `basic_info` VALUES (707968496583708672, '菜虚堃', '练习生', NULL, '1998-03-16', '党员', 21, '四川成都', NULL, '15223654862', ' 0451-86402323', '2963487848@qq.com', '2546615650', NULL, 'https://element.eleme.cn/#/zh-CN', '610000', '长安城长安路110号', '航天学院', '博士', ' 力学', '教授', '博士生导师', '张鲁，博士，副研究员，硕士生导师。主要研究领域：多自由度磁悬浮平面电机及相关技术、直线电机及相关技术、磁悬浮相关技术、高速电机系统等；在《IEEE Transactions on Magnetics》、《Journal of Applied Physics》、《Energies》、《中国电机工程学报》、《电工技术学报》等国内外学术刊物上发表论文40余篇，其中SCI/EI检索28篇；获授权国家发明专利36项；美国发明专利2项；获教育部技术发明二等奖1项；以负责人或主要参与人身份主持、参与国家自然科学基金、国家自然科学基金重点项目、国家科技重大专项、中国博士后基金特别资助项目、中国博士后基金面上项目、黑龙江省自然科学基金等项目20多项。', '自动控制理论(网络化控制、多智能体系统、鲁棒与智能控制)\r\n\r\n信号处理、图像处理、模式识别\r\n\r\n自动光学检测(AOI: Automatic Optical Inspection)\r\n\r\n光机电一体化技术(高速高精度运动控制、贴片机、视觉伺服)\r\n\r\n机器人智能系统(面向复杂任务的工业机器人、机器人智能工艺系统、智能人机交互技术)', 1, 10621, 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for education
-- ----------------------------
DROP TABLE IF EXISTS `education`;
CREATE TABLE `education`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `SCHOOLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校',
  `DEGREE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `SUBJECT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `START_TIME` date NULL DEFAULT NULL COMMENT '开始时间',
  `END_TIME` date NULL DEFAULT NULL COMMENT '结束时间',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968496755675139 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教育经历' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of education
-- ----------------------------
INSERT INTO `education` VALUES (1, '哈尔滨工业大学', '大学本科', '电机专业', '1994-07-02', '1998-07-02', 1, '2020-04-02 20:06:55', 0);
INSERT INTO `education` VALUES (2, '哈尔滨工业大学', '硕士研究生', '电机与电器专业', '1998-09-06', '2002-06-05', 1, '2020-04-02 20:06:55', 0);
INSERT INTO `education` VALUES (3, '哈尔滨工业大学', '博士研究生', '电机与电器专业', '2003-08-09', '2004-06-08', 1, '2020-04-02 20:06:55', 0);
INSERT INTO `education` VALUES (707957770896936960, '哈尔滨工业大学', '博士研究生', '电机与电器专业', '2003-08-09', '2004-06-08', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `education` VALUES (707957770896936961, '哈尔滨工业大学', '硕士研究生', '电机与电器专业', '1998-09-06', '2002-06-05', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `education` VALUES (707957770896936962, '哈尔滨工业大学', '大学本科', '电机专业', '1994-07-02', '1998-07-02', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `education` VALUES (707965956521594880, '哈尔滨工业大学', '博士研究生', '电机与电器专业', '2003-08-09', '2004-06-08', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `education` VALUES (707965956521594881, '哈尔滨工业大学', '硕士研究生', '电机与电器专业', '1998-09-06', '2002-06-05', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `education` VALUES (707965956521594882, '哈尔滨工业大学', '大学本科', '电机专业', '1994-07-02', '1998-07-02', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `education` VALUES (707968496755675136, '哈尔滨工业大学', '博士研究生', '电机与电器专业', '2003-08-09', '2004-06-08', 1, '2020-05-07 14:54:03', 707968496239775744);
INSERT INTO `education` VALUES (707968496755675137, '哈尔滨工业大学', '硕士研究生', '电机与电器专业', '1998-09-06', '2002-06-05', 1, '2020-05-07 14:54:03', 707968496239775744);
INSERT INTO `education` VALUES (707968496755675138, '哈尔滨工业大学', '大学本科', '电机专业', '1994-07-02', '1998-07-02', 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for family_base
-- ----------------------------
DROP TABLE IF EXISTS `family_base`;
CREATE TABLE `family_base`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `POPULATION` int(3) NULL DEFAULT NULL COMMENT '家庭人口',
  `ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497552592897 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '家庭情况_基础' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_base
-- ----------------------------
INSERT INTO `family_base` VALUES (1, 5, '四川省成都市双流区华阳镇戛纳湾金棕榈11栋2单元1403', 1, '2020-04-09 15:47:15', 0);
INSERT INTO `family_base` VALUES (707957771064709120, 5, '四川省成都市双流区华阳镇戛纳湾金棕榈11栋2单元1403', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `family_base` VALUES (707965956664201216, 5, '四川省成都市双流区华阳镇戛纳湾金棕榈11栋2单元1403', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `family_base` VALUES (707968497552592896, 5, '四川省成都市双流区华阳镇戛纳湾金棕榈11栋2单元1403', 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for family_member
-- ----------------------------
DROP TABLE IF EXISTS `family_member`;
CREATE TABLE `family_member`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `AVATAR_TYPE` tinyint(1) NULL DEFAULT NULL COMMENT '头像',
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `SEX` tinyint(1) NULL DEFAULT NULL COMMENT '性别',
  `BIRTH` datetime(0) NULL DEFAULT NULL COMMENT '出生日期',
  `JOB` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位',
  `POLITICAL_STATUS` tinyint(1) NULL DEFAULT NULL COMMENT '政治面貌',
  `RELATION` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '关系',
  `EMAIL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `BASE_ID` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497644867585 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '家庭成员' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of family_member
-- ----------------------------
INSERT INTO `family_member` VALUES (1, 1, '菜德子', 1, '2000-02-01 15:58:05', '学生', 1, '儿子', '254999@qq.com', '16216438596', 1);
INSERT INTO `family_member` VALUES (2, 2, '李芬', 0, '1984-01-01 16:04:09', '家庭主妇', 2, '妻子', '6556898@163.com', '15626847539', 1);
INSERT INTO `family_member` VALUES (3, 5, '菜权', 1, '1961-04-09 16:12:26', '退休', 2, '父亲', '', '19236589875', 1);
INSERT INTO `family_member` VALUES (4, 4, '张凤', 0, NULL, '退休', 0, '母亲', '', ' ', 1);
INSERT INTO `family_member` VALUES (707957771106652160, 1, '菜德', 1, '2000-02-01 15:58:05', '学生', 1, '儿子', '254999@qq.com', '16216438596', 707957771064709120);
INSERT INTO `family_member` VALUES (707957771140206592, 2, '李芬', NULL, '1984-01-01 16:04:09', '家庭主妇', 2, '妻子', '6556898@163.com', '15626847539', 707957771064709120);
INSERT INTO `family_member` VALUES (707957771156983808, 5, '菜权', 1, '1961-04-09 16:12:26', '退休', 2, '父亲', NULL, '19236589875', 707957771064709120);
INSERT INTO `family_member` VALUES (707957771169566720, 4, '张凤', NULL, NULL, '退休', NULL, '母亲', NULL, ' ', 707957771064709120);
INSERT INTO `family_member` VALUES (707965956701949952, 1, '菜德子', 1, '2000-02-01 15:58:05', '学生', 1, '儿子', '254999@qq.com', '16216438596', 707965956664201216);
INSERT INTO `family_member` VALUES (707965956735504384, 2, '李芬', NULL, '1984-01-01 16:04:09', '家庭主妇', 2, '妻子', '6556898@163.com', '15626847539', 707965956664201216);
INSERT INTO `family_member` VALUES (707965956748087296, 5, '菜权', 1, '1961-04-09 16:12:26', '退休', 2, '父亲', NULL, '19236589875', 707965956664201216);
INSERT INTO `family_member` VALUES (707965956760670208, 4, '张凤', NULL, NULL, '退休', NULL, '母亲', NULL, ' ', 707965956664201216);
INSERT INTO `family_member` VALUES (707968497586147328, 1, '菜德子', 1, '2000-02-01 15:58:05', '学生', 1, '儿子', '254999@qq.com', '16216438596', 707968497552592896);
INSERT INTO `family_member` VALUES (707968497615507456, 2, '李芬', NULL, '1984-01-01 16:04:09', '家庭主妇', 2, '妻子', '6556898@163.com', '15626847539', 707968497552592896);
INSERT INTO `family_member` VALUES (707968497632284672, 5, '菜权', 1, '1961-04-09 16:12:26', '退休', 2, '父亲', NULL, '19236589875', 707968497552592896);
INSERT INTO `family_member` VALUES (707968497644867584, 4, '张凤', NULL, NULL, '退休', NULL, '母亲', NULL, ' ', 707968497552592896);

-- ----------------------------
-- Table structure for file_upload
-- ----------------------------
DROP TABLE IF EXISTS `file_upload`;
CREATE TABLE `file_upload`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `upload_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 704655364960161793 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of file_upload
-- ----------------------------
INSERT INTO `file_upload` VALUES (1, 'group1/M00/00/00/http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6dUPqAVrD3AAzebrjGzbU614.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6dZJaAT5uTAAAICOJst0s557.gif', '2020-04-20 15:55:45');
INSERT INTO `file_upload` VALUES (2, 'group1/M00/00/00/wKhbgF6dUPqAVrD3AAzebrjGzbU614.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6dUPqAVrD3AAzebrjGzbU614.jpg', '2020-04-20 15:55:47');
INSERT INTO `file_upload` VALUES (3, 'group1/M00/00/00/wKhbgl5Cf9OAcRJsAAC3UabHGoY561.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5Cf9OAcRJsAAC3UabHGoY561.jpg', '2020-04-20 15:55:49');
INSERT INTO `file_upload` VALUES (4, 'group1/M00/00/00/wKhbgl5CgD6ABCEVAACpT1yiFvE505.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5CgD6ABCEVAACpT1yiFvE505.jpg', '2020-04-20 15:55:51');
INSERT INTO `file_upload` VALUES (5, 'group1/M00/00/00/wKhbgl5OSaWAFs_zAAGfcgRR7i0982.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSaWAFs_zAAGfcgRR7i0982.jpg', '2020-04-20 15:55:53');
INSERT INTO `file_upload` VALUES (6, 'group1/M00/00/00/wKhbgl5OSb2AV2jHAAGKX3pdH44843.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSb2AV2jHAAGKX3pdH44843.jpg', '2020-04-20 15:55:56');
INSERT INTO `file_upload` VALUES (7, 'group1/M00/00/00/wKhbgl5OSfOAF4SOAAAS_PUpRDA729.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSfOAF4SOAAAS_PUpRDA729.jpg', '2020-04-20 15:55:58');
INSERT INTO `file_upload` VALUES (8, 'group1/M00/00/00/wKhbgl5OSHmAHkKeAAHDlRZ75TY816.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSHmAHkKeAAHDlRZ75TY816.jpg', '2020-04-20 15:56:00');
INSERT INTO `file_upload` VALUES (9, 'group1/M00/00/00/wKhbgl5OSLeAZq68AAIBnBLNjiQ154.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSLeAZq68AAIBnBLNjiQ154.jpg', '2020-04-20 15:56:02');
INSERT INTO `file_upload` VALUES (10, 'group1/M00/00/00/wKhbgl5OSNOAXcJnAAHMRJamRPk607.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSNOAXcJnAAHMRJamRPk607.jpg', '2020-04-20 15:56:04');
INSERT INTO `file_upload` VALUES (11, 'group1/M00/00/00/wKhbgl5OSWKAZQYRAAGkRa5vcW4636.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSWKAZQYRAAGkRa5vcW4636.jpg', '2020-04-20 15:56:06');
INSERT INTO `file_upload` VALUES (12, 'group1/M00/00/00/wKhbgl5OSYGAQW_OAACOCSaHwl0012.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgl5OSYGAQW_OAACOCSaHwl0012.jpg', '2020-04-20 15:56:09');
INSERT INTO `file_upload` VALUES (703302863551860736, 'group1/M00/00/00/wKhbgF6it1WAQwoQAAwbb8ZpZAU848.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6it1WAQwoQAAwbb8ZpZAU848.jpg', '2020-04-24 17:54:29');
INSERT INTO `file_upload` VALUES (703563768428630016, 'group1/M00/00/00/wKhbgF6jqlOAUGm4AAzebrjGzbU922.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6jqlOAUGm4AAzebrjGzbU922.jpg', '2020-04-25 11:11:14');
INSERT INTO `file_upload` VALUES (703564020263030784, 'group1/M00/00/00/wKhbgF6jqo-AFx2PAAzebrjGzbU183.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6jqo-AFx2PAAzebrjGzbU183.jpg', '2020-04-25 11:12:14');
INSERT INTO `file_upload` VALUES (703564746301247488, 'group1/M00/00/00/wKhbgF6jqzyAGRs7AAvFuJIfBro994.png', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6jqzyAGRs7AAvFuJIfBro994.png', '2020-04-25 11:15:07');
INSERT INTO `file_upload` VALUES (703566548614647808, 'group1/M00/00/00/wKhbgF6jrOmAEq4rAAbgBJW4jAw713.jpg', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6jrOmAEq4rAAbgBJW4jAw713.jpg', '2020-04-25 11:22:16');
INSERT INTO `file_upload` VALUES (704655364960161792, 'group1/M00/00/00/wKhbgF6novKALnS3AAQnkg8mfjM693.png', 'http://192.168.91.128:8888/group1/M00/00/00/wKhbgF6novKALnS3AAQnkg8mfjM693.png', '2020-04-28 11:28:50');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `PARENT_ID` int(18) NOT NULL COMMENT '父级id',
  `PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
  `STATUS` int(2) NULL DEFAULT NULL COMMENT '状态',
  `CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `ODR` int(8) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 150008 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (100001, '教师信息', -1, NULL, 0, 'teacherInformation', 'iconfont icon-jiaoshixinxiguanli', NULL);
INSERT INTO `menu` VALUES (100002, '组织机构管理', -1, NULL, 0, 'organizationManagement', 'iconfont icon-zuzhijigou', NULL);
INSERT INTO `menu` VALUES (100003, '系统管理', -1, NULL, 0, 'authorityManagement', 'iconfont icon-quanxian', NULL);
INSERT INTO `menu` VALUES (100004, '数据接口', -1, NULL, 0, 'dataInterface', 'iconfont icon-shujujiekouguanli', NULL);
INSERT INTO `menu` VALUES (100005, '服务治理', -1, NULL, 0, 'server', 'iconfont icon-fuwuzhili', NULL);
INSERT INTO `menu` VALUES (110001, '基础信息', 100001, '/basicInformation', 0, 'basicInformation', 'iconfont icon-jcxx-nor', NULL);
INSERT INTO `menu` VALUES (110002, '受教育情况', 100001, '/education', 0, 'education', 'iconfont icon-jiaoyu', NULL);
INSERT INTO `menu` VALUES (110003, '工作情况', 100001, '/work', 0, 'work', 'el-icon-monitor', NULL);
INSERT INTO `menu` VALUES (110004, '家庭情况', 100001, '/family', 0, 'family', 'iconfont icon-jiating', NULL);
INSERT INTO `menu` VALUES (110005, '教学活动', 100001, '/teach', 0, 'teach', 'iconfont icon-jiaoxue', NULL);
INSERT INTO `menu` VALUES (110006, '科研活动', 100001, '/research', 0, 'research', 'iconfont icon-keyan', NULL);
INSERT INTO `menu` VALUES (110007, '获奖信息', 100001, '/award', 0, 'award', 'iconfont icon-huojiang', NULL);
INSERT INTO `menu` VALUES (120001, '行政机构', 100002, '/org/admin', 0, 'administration', 'iconfont icon-hangzheng', NULL);
INSERT INTO `menu` VALUES (120002, '教学单位', 100002, '/org/unit', 0, 'teachingUnit', 'iconfont icon-jiaoxuedanwei', NULL);
INSERT INTO `menu` VALUES (130001, '用户管理', 100003, '/sys/user', 0, 'user', NULL, NULL);
INSERT INTO `menu` VALUES (130002, '角色管理', 100003, '/sys/role', 0, 'role', NULL, NULL);
INSERT INTO `menu` VALUES (130003, '资源管理', 100003, '/sys/permission', 0, 'permission', NULL, NULL);
INSERT INTO `menu` VALUES (130004, '字典管理', 100003, '/sys/dict', 0, 'dictionary', NULL, NULL);
INSERT INTO `menu` VALUES (130005, '日志记录', 100003, '/sys/log', 0, 'logging', NULL, NULL);
INSERT INTO `menu` VALUES (150001, 'Eureka', 100005, '/service/eureka', 0, 'eureka', 'iconfont icon-Eureka', NULL);
INSERT INTO `menu` VALUES (150002, 'Sentinel', 100005, '/service/sentinel', 0, 'sentinel', 'iconfont icon-Sentinel', NULL);
INSERT INTO `menu` VALUES (150003, 'Nacos', 100005, '/service/nacos', 0, 'nacos', 'iconfont icon-service-nacos', NULL);
INSERT INTO `menu` VALUES (150004, 'RabbitMQ', 100005, '/service/rabbitMQ', 0, 'rabbitMQ', 'iconfont icon-rabbitmq', NULL);
INSERT INTO `menu` VALUES (150005, 'SkyWalking', 100005, '/service/skyWalking', 0, 'skyWalking', 'iconfont ', NULL);
INSERT INTO `menu` VALUES (150006, 'AdminServer', 100005, '/service/adminServer', 0, 'adminServer', 'iconfont icon-Dashboard-selected', NULL);
INSERT INTO `menu` VALUES (150007, 'Swagger-ui', 100005, '/service/swaggerUi', 0, 'swaggerUi', 'iconfont ', NULL);

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org`  (
  `id` bigint(18) NOT NULL,
  `unit_id` bigint(18) NULL DEFAULT NULL COMMENT '教学单位',
  `organization_id` bigint(18) NULL DEFAULT NULL COMMENT '行政机构',
  `people_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教师组织关系' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for organization
-- ----------------------------
DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '机构名称',
  `CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构编码',
  `PARENT_ID` int(8) NULL DEFAULT NULL COMMENT '父机构',
  `ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构图标',
  `SCHOOL_CODE` bigint(20) NULL DEFAULT NULL COMMENT '所属学校编码',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '行政机构' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of organization
-- ----------------------------
INSERT INTO `organization` VALUES (1, '党政办公室（党委办公室、校长办公室）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (2, '科技处（局校合作办公室、校地合作处）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (3, '党委组织部、党委统战部', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (4, '人事处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (5, '党委宣传部', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (6, '招生就业处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (7, '纪委办公室', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (8, '计划财务处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (9, '学生工作处（党委学生工作部）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (10, '后勤基建处（后勤服务公司）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (11, '保卫处（党委保卫部、武装部）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (12, '资产管理处（招投标中心）', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (13, '发展规划处、教学评估中心', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (14, '校友工作办公室', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (15, '审计处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (16, '离退休工作处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (17, '国际交流与合作处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (18, '校团委', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (19, '教务处', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (20, '校工会', NULL, -1, NULL, 10621);
INSERT INTO `organization` VALUES (21, '研究生处', NULL, -1, NULL, 10621);

-- ----------------------------
-- Table structure for research
-- ----------------------------
DROP TABLE IF EXISTS `research`;
CREATE TABLE `research`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `RESEARCH_AREAS` bigint(18) NULL DEFAULT NULL COMMENT '研究领域',
  `THESIS_RESULTS` bigint(18) NULL DEFAULT NULL COMMENT '论文成果',
  `PATENT` bigint(18) NULL DEFAULT NULL COMMENT '专利',
  `ACHIEVEMENTS` bigint(18) NULL DEFAULT NULL COMMENT '著作成果',
  `RESEARCH_PROJECTS` bigint(18) NULL DEFAULT NULL COMMENT '科研项目',
  `RESEARCH_TEAM` bigint(18) NULL DEFAULT NULL COMMENT '科研团队',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968498076880897 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科研活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of research
-- ----------------------------
INSERT INTO `research` VALUES (699296329570062336, 699296329574256640, 699296329574256641, 699296329574256645, 699296329574256642, 699296329574256643, 699296329574256644, 1, '2020-04-13 16:44:16', 0);
INSERT INTO `research` VALUES (707957771689660416, 707957771689660419, 707957771689660422, 707957771689660418, 707957771689660417, 707957771689660420, 707957771689660421, 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `research` VALUES (707965957251403776, 707965957251403779, 707965957251403782, 707965957251403778, 707965957251403777, 707965957251403780, 707965957251403781, 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `research` VALUES (707968498076880896, 707968498076880899, 707968498076880902, 707968498076880898, 707968498076880897, 707968498076880900, 707968498076880901, 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for research_item
-- ----------------------------
DROP TABLE IF EXISTS `research_item`;
CREATE TABLE `research_item`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ITEM_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `ITEM_CONTENT` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `PARENT_ID` bigint(18) NULL DEFAULT NULL,
  `TYPE` tinyint(2) NULL DEFAULT NULL COMMENT '类型：1、研究领域2、论文成果、3、专利4、著作成果5、科研项目6、科研团队',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968498429202433 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '科研活动项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of research_item
-- ----------------------------
INSERT INTO `research_item` VALUES (699296329578450944, 'Big-Data Electronics & Artificial-Intelligence Micro-System', 'Big-data (i.e., one Tb/s and beyond) transmission with artifical-intelligence operation is the trend in the future wireless transmission. Many applications of internet of everything (IoE) will improve the life-quality of human-beings and make the world connection closer. As one of the key micro-systems in the total big-data system, the on-chip transceiver demands novel proof-of-concepts to achieve requirements of high performance IoE system. Such transceiver aims to conquer new frontiers in terms of carrier frequency, signal processing, and RF semiconductor design.', 699296329574256640, 1);
INSERT INTO `research_item` VALUES (699296329578450945, 'Digitally-Assisted RF/Microwave/MM-Wave Integrated Circuit', 'With the aim to meet the requirement of low power & high efficiency wireless communication, the digital-assisted RF is the key solution. To increase the data-rates with enhanced bandwidth, microwave/mm-wave IC with digital-assisted techniques are the essential module in the whole system. New high efficiency architecture with novel low power circuits will be innovated and developed for minimizing the use of conventional digital/analog circuit functions by replacing them with digital equivalents RF/microwave/mm-wave, which are more amenable to scaling in advanced CMOS technologies.', 699296329574256640, 1);
INSERT INTO `research_item` VALUES (699296329578450946, 'On-Chip THz Communication', 'THz communication is one of the trend for future talk between things & human-beings. The heart-key elements, i.e., THz IC, should be carefully developed considering the process limits from Si-based process. Novel unit circuit, i.e., resonator, with improved physical meaning is dramatically demanded for THz active circuits design. Besides, THz IC with sub-system implementation should be higly developed with novelty. Consequently, there is a great need for reliable and feasiable passive devices and high-speed ICs intended for THz frequencies.', 699296329574256640, 1);
INSERT INTO `research_item` VALUES (699296329578450947, 'Reconfigurable Passive Circuit & System', 'For the coming 5G & future communication, data-rates and frequency spectrum are the limitation. For the front-end implemetation, reconfigurable mechanism should be highly developed for the multi-mode and multi-band operation. Novel tunable passive with simultaneous frequency and bandwidth adjustment is the essential key component in pratical communication system, which still remains chanllenges for scientific research and development.', 699296329574256640, 1);
INSERT INTO `research_item` VALUES (699296329578450948, 'Smart Sensor Network', 'To improve the life-quality of human-beings, sensor network is rapidly developed. Large numbers, low energy use, self-organization, collaborative signal processing, and querying ability are recognized great challenges for sensor network. Novel intelligence innovation is dramatically demanded to overcome these limits, especially for the field of smart array integrated circuits and systems with strong performance covering bands from MHz to THz.', 699296329574256640, 1);
INSERT INTO `research_item` VALUES (699296329578450949, '', 'H. Qian, Y. Shu, J. Zhou, and X. Luo, “A 20−32GHz quadrature digital transmitter using synthesized impedance variation compensation,” IEEE J. Solid-State Circuits, on-line publication (early access), 2020.', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450950, '', 'J. Zhou, H. Qian, J. Ren, and X. Luo, “Reconfigurable wideband filtering balun with tunable dual-notched bands using CPW-to-slot transition and varactor-loaded shorted-slot,” IEEE Access, vol. 7, pp. 36761–36771, Mar. 2019.', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450951, '', 'X. Luo, S. Sun, et al., “Tunable bandpass filter with two adjustable transmission poles and compensable coupling,” IEEE Trans. Microw. Theory Tech., vol. 62, no. 9, pp. 2003–2013, Sep. 2014. (IEEE TMTT Download Ranking No.1, Sep. 2014)', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450952, '', 'X. Luo, J.-G. Ma, E.-P. Li, and K. Ma, “Hybrid microstrip T-stub/defected ground structure cell for electromagnetic interference bandpass filter design,” IEEE Trans. Electromagnetic Compatibility, vol. 53, no. 3, pp. 717–725, Aug, 2011. (IEEE TEMC Download Ranking No.10, Sep. 2011)', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450953, '', 'X. Luo, J.-G. Ma, and K. S. Yeo, “Dual-band bandpass filter using embedded spiral resonator (ESR) and broadside-coupled meander slot-line (MSL),” Electronic Lett., vol. 46, no. 16, pp. 1390–1391, Aug. 2010.', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450954, '', 'D. Tang, C. Han, Z. Deng, H. Qian, and X. Luo, “Compact bandpass filter with wide stopband and low radiation loss,” in IEEE MTT-S Int. Microwave Sym. Dig., Los Angeles, CA, USA, Jun. 2020. (IMS2020 Best Student Paper Finalist)', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450955, '', 'C. Han, Y. Rao, H. Qian, and X. Luo, “High-selectivity bandpass filter with wide upper stopband using harmonic suppression structure,”in IEEE Int. Symp. Radio-Freq. Integra. Techn., Nanjing, China, Aug. 2019. (RFIT2019 Best Student Paper Award, 3rd Place)', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450956, '', 'J. Ren, H. Qian, and X. Luo, “A wideband filtering balun using CPW-to-slotline transitions,” in IEEE MTT-S Int. Microwave Sym. Dig., Philadelphia, PA, USA, Jun. 2018. (IMS2018 Best Student Paper Finalist)', 699296329574256641, 2);
INSERT INTO `research_item` VALUES (699296329578450957, 'The double notch resonators of mixed microstrip line/co-planar waveguide, trapper and electronic equipment, CN109449556B, 2020', '', 699296329574256645, 3);
INSERT INTO `research_item` VALUES (699296329582645248, 'Dual-mode oscillator and multi-phase oscillator, US10498289B2, 2019', '', 699296329574256645, 3);
INSERT INTO `research_item` VALUES (699296329582645249, 'A kind of phase shifter and feeding network, CN105977583B, 2019', '', 699296329574256645, 3);
INSERT INTO `research_item` VALUES (699296329582645250, 'Frequency multiplier and method of generating frequency-multiplied signal, EP2660972B1, 2016', '', 699296329574256645, 3);
INSERT INTO `research_item` VALUES (699296329582645251, 'Transmitter, receiver, and method for RF transceiving, CN103430456B, 2015', '', 699296329574256645, 3);
INSERT INTO `research_item` VALUES (699296329582645252, '脉冲磁轭均匀热成像稀疏微纹分离研究, 2016/06/30', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645253, '雷达隐身涂层质量智能检测与识别技术研究, 2015/12/01', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645254, '电磁热成像复合材料冲击缺陷贝叶斯盲源分离与识别研究', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645255, '社交辅助设备的设计和测试，英国SIDE研究协会和MRC研究理事会', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645256, '研发动作识别技术提高帕金森患者运动机能，英国工程和物理研究理事会（KTA）', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645257, '未来可靠再生能源转换网络系统（EP/F06151X/1），英国工程和物理科学研究理事会（EPSRC）', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645258, '涡流传感器阵列针对应力与损坏映射技术（EP/E005071/1）， 英国工程和物理科学研究理事会（EPSRC）', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (699296329582645259, '国产碳纤维复合材料无损检测技术研究及应用，四川省科技支撑计划项目，2016GZ0185（联合主持）', '', 699296329574256643, 5);
INSERT INTO `research_item` VALUES (707957771706437632, 'Big-Data Electronics & Artificial-Intelligence Micro-System', 'Big-data (i.e., one Tb/s and beyond) transmission with artifical-intelligence operation is the trend in the future wireless transmission. Many applications of internet of everything (IoE) will improve the life-quality of human-beings and make the world connection closer. As one of the key micro-systems in the total big-data system, the on-chip transceiver demands novel proof-of-concepts to achieve requirements of high performance IoE system. Such transceiver aims to conquer new frontiers in terms of carrier frequency, signal processing, and RF semiconductor design.', 707957771689660419, 1);
INSERT INTO `research_item` VALUES (707957771739992064, 'Digitally-Assisted RF/Microwave/MM-Wave Integrated Circuit', 'With the aim to meet the requirement of low power & high efficiency wireless communication, the digital-assisted RF is the key solution. To increase the data-rates with enhanced bandwidth, microwave/mm-wave IC with digital-assisted techniques are the essential module in the whole system. New high efficiency architecture with novel low power circuits will be innovated and developed for minimizing the use of conventional digital/analog circuit functions by replacing them with digital equivalents RF/microwave/mm-wave, which are more amenable to scaling in advanced CMOS technologies.', 707957771689660419, 1);
INSERT INTO `research_item` VALUES (707957771756769280, 'On-Chip THz Communication', 'THz communication is one of the trend for future talk between things & human-beings. The heart-key elements, i.e., THz IC, should be carefully developed considering the process limits from Si-based process. Novel unit circuit, i.e., resonator, with improved physical meaning is dramatically demanded for THz active circuits design. Besides, THz IC with sub-system implementation should be higly developed with novelty. Consequently, there is a great need for reliable and feasiable passive devices and high-speed ICs intended for THz frequencies.', 707957771689660419, 1);
INSERT INTO `research_item` VALUES (707957771769352192, 'Reconfigurable Passive Circuit & System', 'For the coming 5G & future communication, data-rates and frequency spectrum are the limitation. For the front-end implemetation, reconfigurable mechanism should be highly developed for the multi-mode and multi-band operation. Novel tunable passive with simultaneous frequency and bandwidth adjustment is the essential key component in pratical communication system, which still remains chanllenges for scientific research and development.', 707957771689660419, 1);
INSERT INTO `research_item` VALUES (707957771781935104, 'Smart Sensor Network', 'To improve the life-quality of human-beings, sensor network is rapidly developed. Large numbers, low energy use, self-organization, collaborative signal processing, and querying ability are recognized great challenges for sensor network. Novel intelligence innovation is dramatically demanded to overcome these limits, especially for the field of smart array integrated circuits and systems with strong performance covering bands from MHz to THz.', 707957771689660419, 1);
INSERT INTO `research_item` VALUES (707957771790323712, NULL, 'H. Qian, Y. Shu, J. Zhou, and X. Luo, “A 20−32GHz quadrature digital transmitter using synthesized impedance variation compensation,” IEEE J. Solid-State Circuits, on-line publication (early access), 2020.', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771802906624, NULL, 'J. Zhou, H. Qian, J. Ren, and X. Luo, “Reconfigurable wideband filtering balun with tunable dual-notched bands using CPW-to-slot transition and varactor-loaded shorted-slot,” IEEE Access, vol. 7, pp. 36761–36771, Mar. 2019.', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771815489536, NULL, 'X. Luo, S. Sun, et al., “Tunable bandpass filter with two adjustable transmission poles and compensable coupling,” IEEE Trans. Microw. Theory Tech., vol. 62, no. 9, pp. 2003–2013, Sep. 2014. (IEEE TMTT Download Ranking No.1, Sep. 2014)', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771823878144, NULL, 'X. Luo, J.-G. Ma, E.-P. Li, and K. Ma, “Hybrid microstrip T-stub/defected ground structure cell for electromagnetic interference bandpass filter design,” IEEE Trans. Electromagnetic Compatibility, vol. 53, no. 3, pp. 717–725, Aug, 2011. (IEEE TEMC Download Ranking No.10, Sep. 2011)', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771836461056, NULL, 'X. Luo, J.-G. Ma, and K. S. Yeo, “Dual-band bandpass filter using embedded spiral resonator (ESR) and broadside-coupled meander slot-line (MSL),” Electronic Lett., vol. 46, no. 16, pp. 1390–1391, Aug. 2010.', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771844849664, NULL, 'D. Tang, C. Han, Z. Deng, H. Qian, and X. Luo, “Compact bandpass filter with wide stopband and low radiation loss,” in IEEE MTT-S Int. Microwave Sym. Dig., Los Angeles, CA, USA, Jun. 2020. (IMS2020 Best Student Paper Finalist)', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771853238272, NULL, 'C. Han, Y. Rao, H. Qian, and X. Luo, “High-selectivity bandpass filter with wide upper stopband using harmonic suppression structure,”in IEEE Int. Symp. Radio-Freq. Integra. Techn., Nanjing, China, Aug. 2019. (RFIT2019 Best Student Paper Award, 3rd Place)', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771865821184, NULL, 'J. Ren, H. Qian, and X. Luo, “A wideband filtering balun using CPW-to-slotline transitions,” in IEEE MTT-S Int. Microwave Sym. Dig., Philadelphia, PA, USA, Jun. 2018. (IMS2018 Best Student Paper Finalist)', 707957771689660422, 2);
INSERT INTO `research_item` VALUES (707957771874209792, 'The double notch resonators of mixed microstrip line/co-planar waveguide, trapper and electronic equipment, CN109449556B, 2020', NULL, 707957771689660418, 3);
INSERT INTO `research_item` VALUES (707957771882598400, 'Dual-mode oscillator and multi-phase oscillator, US10498289B2, 2019', NULL, 707957771689660418, 3);
INSERT INTO `research_item` VALUES (707957771890987008, 'A kind of phase shifter and feeding network, CN105977583B, 2019', NULL, 707957771689660418, 3);
INSERT INTO `research_item` VALUES (707957771903569920, 'Frequency multiplier and method of generating frequency-multiplied signal, EP2660972B1, 2016', NULL, 707957771689660418, 3);
INSERT INTO `research_item` VALUES (707957771916152832, 'Transmitter, receiver, and method for RF transceiving, CN103430456B, 2015', NULL, 707957771689660418, 3);
INSERT INTO `research_item` VALUES (707957771924541440, '脉冲磁轭均匀热成像稀疏微纹分离研究, 2016/06/30', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771928735744, '雷达隐身涂层质量智能检测与识别技术研究, 2015/12/01', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771941318656, '电磁热成像复合材料冲击缺陷贝叶斯盲源分离与识别研究', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771953901568, '社交辅助设备的设计和测试，英国SIDE研究协会和MRC研究理事会', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771962290176, '研发动作识别技术提高帕金森患者运动机能，英国工程和物理研究理事会（KTA）', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771974873088, '未来可靠再生能源转换网络系统（EP/F06151X/1），英国工程和物理科学研究理事会（EPSRC）', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771983261696, '涡流传感器阵列针对应力与损坏映射技术（EP/E005071/1）， 英国工程和物理科学研究理事会（EPSRC）', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707957771991650304, '国产碳纤维复合材料无损检测技术研究及应用，四川省科技支撑计划项目，2016GZ0185（联合主持）', NULL, 707957771689660420, 5);
INSERT INTO `research_item` VALUES (707965957268180992, 'Big-Data Electronics & Artificial-Intelligence Micro-System', 'Big-data (i.e., one Tb/s and beyond) transmission with artifical-intelligence operation is the trend in the future wireless transmission. Many applications of internet of everything (IoE) will improve the life-quality of human-beings and make the world connection closer. As one of the key micro-systems in the total big-data system, the on-chip transceiver demands novel proof-of-concepts to achieve requirements of high performance IoE system. Such transceiver aims to conquer new frontiers in terms of carrier frequency, signal processing, and RF semiconductor design.', 707965957251403779, 1);
INSERT INTO `research_item` VALUES (707965957284958208, 'Digitally-Assisted RF/Microwave/MM-Wave Integrated Circuit', 'With the aim to meet the requirement of low power & high efficiency wireless communication, the digital-assisted RF is the key solution. To increase the data-rates with enhanced bandwidth, microwave/mm-wave IC with digital-assisted techniques are the essential module in the whole system. New high efficiency architecture with novel low power circuits will be innovated and developed for minimizing the use of conventional digital/analog circuit functions by replacing them with digital equivalents RF/microwave/mm-wave, which are more amenable to scaling in advanced CMOS technologies.', 707965957251403779, 1);
INSERT INTO `research_item` VALUES (707965957297541120, 'On-Chip THz Communication', 'THz communication is one of the trend for future talk between things & human-beings. The heart-key elements, i.e., THz IC, should be carefully developed considering the process limits from Si-based process. Novel unit circuit, i.e., resonator, with improved physical meaning is dramatically demanded for THz active circuits design. Besides, THz IC with sub-system implementation should be higly developed with novelty. Consequently, there is a great need for reliable and feasiable passive devices and high-speed ICs intended for THz frequencies.', 707965957251403779, 1);
INSERT INTO `research_item` VALUES (707965957314318336, 'Reconfigurable Passive Circuit & System', 'For the coming 5G & future communication, data-rates and frequency spectrum are the limitation. For the front-end implemetation, reconfigurable mechanism should be highly developed for the multi-mode and multi-band operation. Novel tunable passive with simultaneous frequency and bandwidth adjustment is the essential key component in pratical communication system, which still remains chanllenges for scientific research and development.', 707965957251403779, 1);
INSERT INTO `research_item` VALUES (707965957326901248, 'Smart Sensor Network', 'To improve the life-quality of human-beings, sensor network is rapidly developed. Large numbers, low energy use, self-organization, collaborative signal processing, and querying ability are recognized great challenges for sensor network. Novel intelligence innovation is dramatically demanded to overcome these limits, especially for the field of smart array integrated circuits and systems with strong performance covering bands from MHz to THz.', 707965957251403779, 1);
INSERT INTO `research_item` VALUES (707965957335289856, NULL, 'H. Qian, Y. Shu, J. Zhou, and X. Luo, “A 20−32GHz quadrature digital transmitter using synthesized impedance variation compensation,” IEEE J. Solid-State Circuits, on-line publication (early access), 2020.', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957368844288, NULL, 'J. Zhou, H. Qian, J. Ren, and X. Luo, “Reconfigurable wideband filtering balun with tunable dual-notched bands using CPW-to-slot transition and varactor-loaded shorted-slot,” IEEE Access, vol. 7, pp. 36761–36771, Mar. 2019.', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957377232896, NULL, 'X. Luo, S. Sun, et al., “Tunable bandpass filter with two adjustable transmission poles and compensable coupling,” IEEE Trans. Microw. Theory Tech., vol. 62, no. 9, pp. 2003–2013, Sep. 2014. (IEEE TMTT Download Ranking No.1, Sep. 2014)', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957385621504, NULL, 'X. Luo, J.-G. Ma, E.-P. Li, and K. Ma, “Hybrid microstrip T-stub/defected ground structure cell for electromagnetic interference bandpass filter design,” IEEE Trans. Electromagnetic Compatibility, vol. 53, no. 3, pp. 717–725, Aug, 2011. (IEEE TEMC Download Ranking No.10, Sep. 2011)', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957398204416, NULL, 'X. Luo, J.-G. Ma, and K. S. Yeo, “Dual-band bandpass filter using embedded spiral resonator (ESR) and broadside-coupled meander slot-line (MSL),” Electronic Lett., vol. 46, no. 16, pp. 1390–1391, Aug. 2010.', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957410787328, NULL, 'D. Tang, C. Han, Z. Deng, H. Qian, and X. Luo, “Compact bandpass filter with wide stopband and low radiation loss,” in IEEE MTT-S Int. Microwave Sym. Dig., Los Angeles, CA, USA, Jun. 2020. (IMS2020 Best Student Paper Finalist)', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957419175936, NULL, 'C. Han, Y. Rao, H. Qian, and X. Luo, “High-selectivity bandpass filter with wide upper stopband using harmonic suppression structure,”in IEEE Int. Symp. Radio-Freq. Integra. Techn., Nanjing, China, Aug. 2019. (RFIT2019 Best Student Paper Award, 3rd Place)', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957427564544, NULL, 'J. Ren, H. Qian, and X. Luo, “A wideband filtering balun using CPW-to-slotline transitions,” in IEEE MTT-S Int. Microwave Sym. Dig., Philadelphia, PA, USA, Jun. 2018. (IMS2018 Best Student Paper Finalist)', 707965957251403782, 2);
INSERT INTO `research_item` VALUES (707965957435953152, 'The double notch resonators of mixed microstrip line/co-planar waveguide, trapper and electronic equipment, CN109449556B, 2020', NULL, 707965957251403778, 3);
INSERT INTO `research_item` VALUES (707965957444341760, 'Dual-mode oscillator and multi-phase oscillator, US10498289B2, 2019', NULL, 707965957251403778, 3);
INSERT INTO `research_item` VALUES (707965957452730368, 'A kind of phase shifter and feeding network, CN105977583B, 2019', NULL, 707965957251403778, 3);
INSERT INTO `research_item` VALUES (707965957469507584, 'Frequency multiplier and method of generating frequency-multiplied signal, EP2660972B1, 2016', NULL, 707965957251403778, 3);
INSERT INTO `research_item` VALUES (707965957477896192, 'Transmitter, receiver, and method for RF transceiving, CN103430456B, 2015', NULL, 707965957251403778, 3);
INSERT INTO `research_item` VALUES (707965957486284800, '脉冲磁轭均匀热成像稀疏微纹分离研究, 2016/06/30', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957494673408, '雷达隐身涂层质量智能检测与识别技术研究, 2015/12/01', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957507256320, '电磁热成像复合材料冲击缺陷贝叶斯盲源分离与识别研究', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957515644928, '社交辅助设备的设计和测试，英国SIDE研究协会和MRC研究理事会', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957524033536, '研发动作识别技术提高帕金森患者运动机能，英国工程和物理研究理事会（KTA）', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957536616448, '未来可靠再生能源转换网络系统（EP/F06151X/1），英国工程和物理科学研究理事会（EPSRC）', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957545005056, '涡流传感器阵列针对应力与损坏映射技术（EP/E005071/1）， 英国工程和物理科学研究理事会（EPSRC）', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707965957553393664, '国产碳纤维复合材料无损检测技术研究及应用，四川省科技支撑计划项目，2016GZ0185（联合主持）', NULL, 707965957251403780, 5);
INSERT INTO `research_item` VALUES (707968498089463808, 'Big-Data Electronics & Artificial-Intelligence Micro-System', 'Big-data (i.e., one Tb/s and beyond) transmission with artifical-intelligence operation is the trend in the future wireless transmission. Many applications of internet of everything (IoE) will improve the life-quality of human-beings and make the world connection closer. As one of the key micro-systems in the total big-data system, the on-chip transceiver demands novel proof-of-concepts to achieve requirements of high performance IoE system. Such transceiver aims to conquer new frontiers in terms of carrier frequency, signal processing, and RF semiconductor design.', 707968498076880899, 1);
INSERT INTO `research_item` VALUES (707968498135601152, 'Digitally-Assisted RF/Microwave/MM-Wave Integrated Circuit', 'With the aim to meet the requirement of low power & high efficiency wireless communication, the digital-assisted RF is the key solution. To increase the data-rates with enhanced bandwidth, microwave/mm-wave IC with digital-assisted techniques are the essential module in the whole system. New high efficiency architecture with novel low power circuits will be innovated and developed for minimizing the use of conventional digital/analog circuit functions by replacing them with digital equivalents RF/microwave/mm-wave, which are more amenable to scaling in advanced CMOS technologies.', 707968498076880899, 1);
INSERT INTO `research_item` VALUES (707968498148184064, 'On-Chip THz Communication', 'THz communication is one of the trend for future talk between things & human-beings. The heart-key elements, i.e., THz IC, should be carefully developed considering the process limits from Si-based process. Novel unit circuit, i.e., resonator, with improved physical meaning is dramatically demanded for THz active circuits design. Besides, THz IC with sub-system implementation should be higly developed with novelty. Consequently, there is a great need for reliable and feasiable passive devices and high-speed ICs intended for THz frequencies.', 707968498076880899, 1);
INSERT INTO `research_item` VALUES (707968498156572672, 'Reconfigurable Passive Circuit & System', 'For the coming 5G & future communication, data-rates and frequency spectrum are the limitation. For the front-end implemetation, reconfigurable mechanism should be highly developed for the multi-mode and multi-band operation. Novel tunable passive with simultaneous frequency and bandwidth adjustment is the essential key component in pratical communication system, which still remains chanllenges for scientific research and development.', 707968498076880899, 1);
INSERT INTO `research_item` VALUES (707968498236264448, 'Smart Sensor Network', 'To improve the life-quality of human-beings, sensor network is rapidly developed. Large numbers, low energy use, self-organization, collaborative signal processing, and querying ability are recognized great challenges for sensor network. Novel intelligence innovation is dramatically demanded to overcome these limits, especially for the field of smart array integrated circuits and systems with strong performance covering bands from MHz to THz.', 707968498076880899, 1);
INSERT INTO `research_item` VALUES (707968498244653056, NULL, 'H. Qian, Y. Shu, J. Zhou, and X. Luo, “A 20−32GHz quadrature digital transmitter using synthesized impedance variation compensation,” IEEE J. Solid-State Circuits, on-line publication (early access), 2020.', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498253041664, NULL, 'J. Zhou, H. Qian, J. Ren, and X. Luo, “Reconfigurable wideband filtering balun with tunable dual-notched bands using CPW-to-slot transition and varactor-loaded shorted-slot,” IEEE Access, vol. 7, pp. 36761–36771, Mar. 2019.', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498257235968, NULL, 'X. Luo, S. Sun, et al., “Tunable bandpass filter with two adjustable transmission poles and compensable coupling,” IEEE Trans. Microw. Theory Tech., vol. 62, no. 9, pp. 2003–2013, Sep. 2014. (IEEE TMTT Download Ranking No.1, Sep. 2014)', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498269818880, NULL, 'X. Luo, J.-G. Ma, E.-P. Li, and K. Ma, “Hybrid microstrip T-stub/defected ground structure cell for electromagnetic interference bandpass filter design,” IEEE Trans. Electromagnetic Compatibility, vol. 53, no. 3, pp. 717–725, Aug, 2011. (IEEE TEMC Download Ranking No.10, Sep. 2011)', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498278207488, NULL, 'X. Luo, J.-G. Ma, and K. S. Yeo, “Dual-band bandpass filter using embedded spiral resonator (ESR) and broadside-coupled meander slot-line (MSL),” Electronic Lett., vol. 46, no. 16, pp. 1390–1391, Aug. 2010.', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498286596096, NULL, 'D. Tang, C. Han, Z. Deng, H. Qian, and X. Luo, “Compact bandpass filter with wide stopband and low radiation loss,” in IEEE MTT-S Int. Microwave Sym. Dig., Los Angeles, CA, USA, Jun. 2020. (IMS2020 Best Student Paper Finalist)', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498299179008, NULL, 'C. Han, Y. Rao, H. Qian, and X. Luo, “High-selectivity bandpass filter with wide upper stopband using harmonic suppression structure,”in IEEE Int. Symp. Radio-Freq. Integra. Techn., Nanjing, China, Aug. 2019. (RFIT2019 Best Student Paper Award, 3rd Place)', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498307567616, NULL, 'J. Ren, H. Qian, and X. Luo, “A wideband filtering balun using CPW-to-slotline transitions,” in IEEE MTT-S Int. Microwave Sym. Dig., Philadelphia, PA, USA, Jun. 2018. (IMS2018 Best Student Paper Finalist)', 707968498076880902, 2);
INSERT INTO `research_item` VALUES (707968498311761920, 'The double notch resonators of mixed microstrip line/co-planar waveguide, trapper and electronic equipment, CN109449556B, 2020', NULL, 707968498076880898, 3);
INSERT INTO `research_item` VALUES (707968498320150528, 'Dual-mode oscillator and multi-phase oscillator, US10498289B2, 2019', NULL, 707968498076880898, 3);
INSERT INTO `research_item` VALUES (707968498332733440, 'A kind of phase shifter and feeding network, CN105977583B, 2019', NULL, 707968498076880898, 3);
INSERT INTO `research_item` VALUES (707968498345316352, 'Frequency multiplier and method of generating frequency-multiplied signal, EP2660972B1, 2016', NULL, 707968498076880898, 3);
INSERT INTO `research_item` VALUES (707968498353704960, 'Transmitter, receiver, and method for RF transceiving, CN103430456B, 2015', NULL, 707968498076880898, 3);
INSERT INTO `research_item` VALUES (707968498362093568, '脉冲磁轭均匀热成像稀疏微纹分离研究, 2016/06/30', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498370482176, '雷达隐身涂层质量智能检测与识别技术研究, 2015/12/01', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498378870784, '电磁热成像复合材料冲击缺陷贝叶斯盲源分离与识别研究', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498387259392, '社交辅助设备的设计和测试，英国SIDE研究协会和MRC研究理事会', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498395648000, '研发动作识别技术提高帕金森患者运动机能，英国工程和物理研究理事会（KTA）', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498408230912, '未来可靠再生能源转换网络系统（EP/F06151X/1），英国工程和物理科学研究理事会（EPSRC）', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498420813824, '涡流传感器阵列针对应力与损坏映射技术（EP/E005071/1）， 英国工程和物理科学研究理事会（EPSRC）', NULL, 707968498076880900, 5);
INSERT INTO `research_item` VALUES (707968498429202432, '国产碳纤维复合材料无损检测技术研究及应用，四川省科技支撑计划项目，2016GZ0185（联合主持）', NULL, 707968498076880900, 5);

-- ----------------------------
-- Table structure for school
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名称',
  `CODE` int(20) NULL DEFAULT NULL COMMENT '学校编码',
  `ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校地址',
  `ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校图标',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学校' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES (1, '成都信息工程大学', 10621, '', 'group1/M00/00/00/wKhbgF6novKALnS3AAQnkg8mfjM693.png');
INSERT INTO `school` VALUES (2, '加里敦大学', 99666, '', '');
INSERT INTO `school` VALUES (3, '超神学院', 10101, '', 'group1/M00/00/00/wKhbgl5Cf9OAcRJsAAC3UabHGoY561.jpg');

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(11) NULL DEFAULT 0 COMMENT ' 父ID ',
  `data_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 数据类别,首字母大写 ',
  `data_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 数据编码 ',
  `data_value` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 数据名称/值 ',
  `sort_no` int(11) UNSIGNED NULL DEFAULT 1 COMMENT ' 顺序 ',
  `status` tinyint(2) NULL DEFAULT 0 COMMENT '0正常,1删除',
  `data_desc` varchar(400) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据描述',
  `update_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `G_SYS_DICT_PK`(`id`) USING BTREE,
  INDEX `idx_dc_dt`(`data_type`, `data_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, 0, 'TeacherTitle', 'TeachingAssistant', '助教', 1, 0, NULL, '2020-02-03 19:02:23');
INSERT INTO `sys_dict` VALUES (2, 0, 'TeacherTitle', 'Lecturer', '讲师', 1, 0, NULL, '2020-02-03 19:03:05');
INSERT INTO `sys_dict` VALUES (3, 0, 'TeacherTitle', 'AssociateProfessor', '副教授', 1, 0, NULL, '2020-02-03 19:03:56');
INSERT INTO `sys_dict` VALUES (4, 0, 'TeacherTitle', 'Professor', '教授', 1, 0, NULL, '2020-02-03 19:04:38');

-- ----------------------------
-- Table structure for teach_unit
-- ----------------------------
DROP TABLE IF EXISTS `teach_unit`;
CREATE TABLE `teach_unit`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '单位名称',
  `CODE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位编码',
  `PARENT_ID` int(8) NOT NULL COMMENT '父id',
  `SCHOOL_CODE` int(20) NULL DEFAULT NULL COMMENT '所属学校编码',
  `ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '单位图标',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教学单位' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teach_unit
-- ----------------------------
INSERT INTO `teach_unit` VALUES (1, '大气科学学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSHmAHkKeAAHDlRZ75TY816.jpg');
INSERT INTO `teach_unit` VALUES (2, '管理学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (3, '资源环境学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSb2AV2jHAAGKX3pdH44843.jpg');
INSERT INTO `teach_unit` VALUES (4, '物流学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSaWAFs_zAAGfcgRR7i0982.jpg');
INSERT INTO `teach_unit` VALUES (5, '应用数学学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (6, '电子工程学院（大气探测学院）', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSLeAZq68AAIBnBLNjiQ154.jpg');
INSERT INTO `teach_unit` VALUES (7, '统计学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (8, '控制工程学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (9, '文化艺术学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (10, '通信工程学院（微电子学院）', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSWKAZQYRAAGkRa5vcW4636.jpg');
INSERT INTO `teach_unit` VALUES (11, '外国语学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSYGAQW_OAACOCSaHwl0012.jpg');
INSERT INTO `teach_unit` VALUES (12, '计算机学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSfOAF4SOAAAS_PUpRDA729.jpg');
INSERT INTO `teach_unit` VALUES (13, '马克思主义学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (14, '软件工程学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (15, '工程实践中心', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (16, '网络空间安全学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (17, '计算中心', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (18, '光电工程学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (19, '体育部', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (20, '启迪科技学院', '', 0, 10621, '');
INSERT INTO `teach_unit` VALUES (21, '艾欧尼亚', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (22, '德玛西亚', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (23, '诺克萨斯', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (24, '祖安', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (25, '皮尔特沃夫', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (26, '暗影岛', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (27, '巨神峰', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (28, '恕瑞玛', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (29, '比尔吉沃特', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (30, '弗雷尔卓德', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (31, '班德尔城', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (32, '虚空之地', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (33, '自符文之地', '', 0, 10101, '');
INSERT INTO `teach_unit` VALUES (34, '光电工程学院', '', 0, 10621, 'group1/M00/00/00/wKhbgl5OSNOAXcJnAAHMRJamRPk607.jpg');

-- ----------------------------
-- Table structure for teaching
-- ----------------------------
DROP TABLE IF EXISTS `teaching`;
CREATE TABLE `teaching`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `RESEARCH` bigint(18) NULL DEFAULT NULL COMMENT '教学研究',
  `RESOURCES` bigint(18) NULL DEFAULT NULL COMMENT '教学资源',
  `CLASS_INFO` bigint(18) NULL DEFAULT NULL COMMENT '授课信息',
  `ACHIEVEMENTS` bigint(18) NULL DEFAULT NULL COMMENT '教学成果',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497745530881 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教学活动' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching
-- ----------------------------
INSERT INTO `teaching` VALUES (699344898473725952, 699344898473725953, 699344898477920256, 699344898477920257, 699344898477920258, 1, '2020-04-10 10:25:15', 0);
INSERT INTO `teaching` VALUES (707957771282812928, 707957771282812931, 707957771282812932, 707957771282812930, 707957771282812929, 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `teaching` VALUES (707965956857139200, 707965956857139203, 707965956857139204, 707965956857139202, 707965956857139201, 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `teaching` VALUES (707968497745530880, 707968497745530883, 707968497745530884, 707968497745530882, 707968497745530881, 1, '2020-05-07 14:54:03', 707968496239775744);

-- ----------------------------
-- Table structure for teaching_class
-- ----------------------------
DROP TABLE IF EXISTS `teaching_class`;
CREATE TABLE `teaching_class`  (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `TYPE` tinyint(4) NULL DEFAULT NULL COMMENT '类型 1、本科生，2、研究生',
  `COURSE_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '课程名称',
  `SCHOOL_YEAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '学年',
  `SEMESTER` tinyint(4) NULL DEFAULT NULL COMMENT '学期',
  `THEORY_HOURS` int(3) NULL DEFAULT NULL COMMENT '理论学时',
  `PRACTICE_HOURS` int(3) NULL DEFAULT NULL COMMENT '实践学时',
  `CREDIT` decimal(3, 1) NULL DEFAULT NULL COMMENT '学分',
  `COURSE_NUM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程号',
  `CLASS_INFO_ID` bigint(18) NULL DEFAULT NULL,
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` int(100) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497934274561 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '授课信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching_class
-- ----------------------------
INSERT INTO `teaching_class` VALUES (699344898482114565, 1, '火箭推进原理', '2019-2020', 1, 32, 0, 1.0, '1040441130', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898482114566, 1, '火箭与空间推进', '2019-2020', 1, 24, 12, 2.0, '2040440011', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898482114567, 1, '航空航天技术概论', '2018-2019', 2, 26, 0, 2.5, '1040440900', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898482114568, 1, '火箭推进原理', '2018-2019', 1, 36, 8, 2.0, '1040441130', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898486308864, 1, '火箭与空间推进', '2018-2019', 2, 42, 0, 3.0, '2040440011', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898486308865, 1, '航空航天技术概论', '2017-2018', 2, 16, 16, 1.0, '1040440900', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898486308866, 2, '机械制造装备设计', '2018-2019', 1, 24, 0, 2.0, '1050141000', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898486308867, 2, '机械制造装备设计', '2018-2019', 2, 32, 32, 3.0, '1050141000', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (699344898486308868, 2, '机械制造装备设计', '2017-2018', 1, 42, 0, 3.5, '1050141000', 699344898477920257, 1, '2020-04-13 20:01:45', 0);
INSERT INTO `teaching_class` VALUES (707957771387670528, 1, '火箭推进原理', '2019-2020', 1, 32, NULL, 1.0, '1040441130', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771438002176, 1, '火箭与空间推进', '2019-2020', 1, 24, 12, 2.0, '2040440011', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771450585088, 1, '航空航天技术概论', '2018-2019', 2, 26, NULL, 2.5, '1040440900', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771467362304, 1, '火箭推进原理', '2018-2019', 1, 36, 8, 2.0, '1040441130', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771484139520, 1, '火箭与空间推进', '2018-2019', 2, 42, NULL, 3.0, '2040440011', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771496722432, 1, '航空航天技术概论', '2017-2018', 2, 16, 16, 1.0, '1040440900', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771509305344, 2, '机械制造装备设计', '2018-2019', 1, 24, NULL, 2.0, '1050141000', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771526082560, 2, '机械制造装备设计', '2018-2019', 2, 32, 32, 3.0, '1050141000', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707957771547054080, 2, '机械制造装备设计', '2017-2018', 1, 42, NULL, 3.5, '1050141000', 707957771282812930, NULL, '2020-05-07 14:11:25', NULL);
INSERT INTO `teaching_class` VALUES (707965956932636672, 1, '火箭推进原理', '2019-2020', 1, 32, NULL, 1.0, '1040441130', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965956966191104, 1, '火箭与空间推进', '2019-2020', 1, 24, 12, 2.0, '2040440011', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965956978774016, 1, '航空航天技术概论', '2018-2019', 2, 26, NULL, 2.5, '1040440900', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965956995551232, 1, '火箭推进原理', '2018-2019', 1, 36, 8, 2.0, '1040441130', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965957029105664, 1, '火箭与空间推进', '2018-2019', 2, 42, NULL, 3.0, '2040440011', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965957045882880, 1, '航空航天技术概论', '2017-2018', 2, 16, 16, 1.0, '1040440900', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965957058465792, 2, '机械制造装备设计', '2018-2019', 1, 24, NULL, 2.0, '1050141000', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965957071048704, 2, '机械制造装备设计', '2018-2019', 2, 32, 32, 3.0, '1050141000', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707965957083631616, 2, '机械制造装备设计', '2017-2018', 1, 42, NULL, 3.5, '1050141000', 707965956857139202, NULL, '2020-05-07 14:43:57', NULL);
INSERT INTO `teaching_class` VALUES (707968497821028352, 1, '火箭推进原理', '2019-2020', 1, 32, NULL, 1.0, '1040441130', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497854582784, 1, '火箭与空间推进', '2019-2020', 1, 24, 12, 2.0, '2040440011', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497867165696, 1, '航空航天技术概论', '2018-2019', 2, 26, NULL, 2.5, '1040440900', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497875554304, 1, '火箭推进原理', '2018-2019', 1, 36, 8, 2.0, '1040441130', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497883942912, 1, '火箭与空间推进', '2018-2019', 2, 42, NULL, 3.0, '2040440011', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497896525824, 1, '航空航天技术概论', '2017-2018', 2, 16, 16, 1.0, '1040440900', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497909108736, 2, '机械制造装备设计', '2018-2019', 1, 24, NULL, 2.0, '1050141000', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497917497344, 2, '机械制造装备设计', '2018-2019', 2, 32, 32, 3.0, '1050141000', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);
INSERT INTO `teaching_class` VALUES (707968497934274560, 2, '机械制造装备设计', '2017-2018', 1, 42, NULL, 3.5, '1050141000', 707968497745530882, NULL, '2020-05-07 14:54:03', NULL);

-- ----------------------------
-- Table structure for teaching_item
-- ----------------------------
DROP TABLE IF EXISTS `teaching_item`;
CREATE TABLE `teaching_item`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ITEM` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `PARENT_ID` bigint(18) NULL DEFAULT NULL,
  `TYPE` tinyint(2) NULL DEFAULT NULL COMMENT '类型：1、教学研究2、教学资源、3、教学成果',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497812639745 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '教学活动项' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teaching_item
-- ----------------------------
INSERT INTO `teaching_item` VALUES (699344898482114560, '2009年，国家级教学成果一等奖，第1获奖人', 699344898477920258, 3);
INSERT INTO `teaching_item` VALUES (699344898482114561, '2018年，国家级教学成果一等奖，第2获奖人', 699344898477920258, 3);
INSERT INTO `teaching_item` VALUES (699344898482114562, '大连理工大学2014年校教学质量优良奖', 699344898477920258, 3);
INSERT INTO `teaching_item` VALUES (699344898482114563, '2005年，国家级教学成果二等奖，第3获奖人', 699344898477920258, 3);
INSERT INTO `teaching_item` VALUES (699344898482114564, '大连理工大学2012年青年教师讲课竞赛一等奖', 699344898477920258, 3);
INSERT INTO `teaching_item` VALUES (707957771303784448, '2009年，国家级教学成果一等奖，第1获奖人', 707957771282812929, 3);
INSERT INTO `teaching_item` VALUES (707957771337338880, '2018年，国家级教学成果一等奖，第2获奖人', 707957771282812929, 3);
INSERT INTO `teaching_item` VALUES (707957771349921792, '大连理工大学2014年校教学质量优良奖', 707957771282812929, 3);
INSERT INTO `teaching_item` VALUES (707957771366699008, '2005年，国家级教学成果二等奖，第3获奖人', 707957771282812929, 3);
INSERT INTO `teaching_item` VALUES (707957771375087616, '大连理工大学2012年青年教师讲课竞赛一等奖', 707957771282812929, 3);
INSERT INTO `teaching_item` VALUES (707965956869722112, '2009年，国家级教学成果一等奖，第1获奖人', 707965956857139201, 3);
INSERT INTO `teaching_item` VALUES (707965956890693632, '2018年，国家级教学成果一等奖，第2获奖人', 707965956857139201, 3);
INSERT INTO `teaching_item` VALUES (707965956903276544, '大连理工大学2014年校教学质量优良奖', 707965956857139201, 3);
INSERT INTO `teaching_item` VALUES (707965956911665152, '2005年，国家级教学成果二等奖，第3获奖人', 707965956857139201, 3);
INSERT INTO `teaching_item` VALUES (707965956924248064, '大连理工大学2012年青年教师讲课竞赛一等奖', 707965956857139201, 3);
INSERT INTO `teaching_item` VALUES (707968497762308096, '2009年，国家级教学成果一等奖，第1获奖人', 707968497745530881, 3);
INSERT INTO `teaching_item` VALUES (707968497779085312, '2018年，国家级教学成果一等奖，第2获奖人', 707968497745530881, 3);
INSERT INTO `teaching_item` VALUES (707968497791668224, '大连理工大学2014年校教学质量优良奖', 707968497745530881, 3);
INSERT INTO `teaching_item` VALUES (707968497800056832, '2005年，国家级教学成果二等奖，第3获奖人', 707968497745530881, 3);
INSERT INTO `teaching_item` VALUES (707968497812639744, '大连理工大学2012年青年教师讲课竞赛一等奖', 707968497745530881, 3);

-- ----------------------------
-- Table structure for version
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本名称',
  `SIGN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本标志',
  `REMARKS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `PEOPLE_ID` bigint(18) NULL DEFAULT NULL,
  `TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968496239775745 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of version
-- ----------------------------
INSERT INTO `version` VALUES (707920896467800064, '测试版本', '0.0.1', 'test', 1, '2020-05-07 14:04:51');
INSERT INTO `version` VALUES (707957770360066048, '牛逼的第二版', '0.2.0', '测试', 1, '2020-05-07 14:12:34');
INSERT INTO `version` VALUES (707965955993112576, '时间', '0.2.1', '奥斯卡卡号打不开', 1, NULL);
INSERT INTO `version` VALUES (707968496239775744, '修改', '1.0.0', '奥耍的', 1, '2020-05-07 14:54:02');

-- ----------------------------
-- Table structure for work
-- ----------------------------
DROP TABLE IF EXISTS `work`;
CREATE TABLE `work`  (
  `ID` bigint(18) NOT NULL AUTO_INCREMENT,
  `POSITION` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `WORK_UNIT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作单位/学校',
  `COLLEGE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学院/部门',
  `SUBJECT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学科',
  `START_TIME` date NULL DEFAULT NULL COMMENT '开始时间',
  `END_TIME` date NULL DEFAULT NULL COMMENT '结束时间',
  `PEOPLE_ID` bigint(20) NULL DEFAULT NULL,
  `UPLOAD_TIME` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '上传时间',
  `VERSION` bigint(18) NULL DEFAULT 0 COMMENT '版本号',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 707968497489678339 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '工作情况' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of work
-- ----------------------------
INSERT INTO `work` VALUES (1, '教师', '成都信息工程大学', '计算机学院', '计算机科学', '2003-03-18', '2007-03-18', 1, '2020-03-25 17:59:50', 0);
INSERT INTO `work` VALUES (2, '教师', '成都信息工程大学', '软件工程学院', '软件工程', '2008-03-18', '2011-03-18', 1, '2020-03-25 17:59:50', 0);
INSERT INTO `work` VALUES (3, '教师', '成都信息工程大学', '计算机学院', '数字媒体', '2012-03-18', '2015-03-18', 1, '2020-03-25 17:59:50', 0);
INSERT INTO `work` VALUES (4, '教授', '成都信息工程大学', '计算机学院', '计算机科学', '2002-03-18', '2007-03-18', 1, '2020-03-26 17:59:50', 1);
INSERT INTO `work` VALUES (5, '教授', '成都信息工程大学', '软件工程学院', '软件工程', '2008-03-18', '2011-03-18', 1, '2020-03-26 17:59:50', 1);
INSERT INTO `work` VALUES (6, '教授', '成都信息工程大学', '计算机学院', '数字媒体', '2012-03-18', '2015-03-18', 1, '2020-03-26 17:59:50', 1);
INSERT INTO `work` VALUES (707957770993405952, '教师', '成都信息工程大学', '计算机学院', '数字媒体', '2012-03-18', '2015-03-18', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `work` VALUES (707957770993405953, '教师', '成都信息工程大学', '软件工程学院', '软件工程', '2008-03-18', '2011-03-18', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `work` VALUES (707957770993405954, '教师', '成都信息工程大学', '计算机学院', '计算机科学', '2003-03-18', '2007-03-18', 1, '2020-05-07 14:11:25', 707957770360066048);
INSERT INTO `work` VALUES (707965956601286656, '教师', '成都信息工程大学', '计算机学院', '数字媒体', '2012-03-18', '2015-03-18', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `work` VALUES (707965956601286657, '教师', '成都信息工程大学', '软件工程学院', '软件工程', '2008-03-18', '2011-03-18', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `work` VALUES (707965956601286658, '教师', '成都信息工程大学', '计算机学院', '计算机科学', '2003-03-18', '2007-03-18', 1, '2020-05-07 14:43:57', 707965955993112576);
INSERT INTO `work` VALUES (707968497489678336, '教师', '成都信息工程大学', '计算机学院', '数字媒体', '2012-03-18', '2015-03-18', 1, '2020-05-07 14:54:03', 707968496239775744);
INSERT INTO `work` VALUES (707968497489678337, '教师', '成都信息工程大学', '软件工程学院', '软件工程', '2008-03-18', '2011-03-18', 1, '2020-05-07 14:54:03', 707968496239775744);
INSERT INTO `work` VALUES (707968497489678338, '教师', '成都信息工程大学', '计算机学院', '计算机科学', '2003-03-18', '2007-03-18', 1, '2020-05-07 14:54:03', 707968496239775744);

SET FOREIGN_KEY_CHECKS = 1;
