-- 如果表已存在，先删除（注意：这会清空已有数据）
DROP TABLE IF EXISTS emp CASCADE;

-- 创建带有 jsonb 字段的表
CREATE TABLE emp (
                     empno INT PRIMARY KEY,
                     ename VARCHAR(50),
                     job VARCHAR(50),
                     mgr INT,
                     hiredate DATE,
                     sal NUMERIC(10, 2),
                     comm NUMERIC(10, 2),
                     deptno INT,
                     status VARCHAR(20) DEFAULT '在职',
    -- 核心：嵌套的 jsonb 字段
                     emergency_contacts JSONB DEFAULT '[]'
);
INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno, status, emergency_contacts) VALUES
                                                                                                      (7369, '马云', '职员', 7902, '1980-12-17', 800.00, NULL, 20, '在职',
                                                                                                       '[{"name": "张女士", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000001"}, {"type": "wechat", "value": "jack_wife"}]}, {"name": "马老先生", "relation": "父亲", "methods": [{"type": "phone", "value": "13900000001"}]}]'),

                                                                                                      (7499, '马化腾', '销售员', 7698, '1981-02-20', 1600.00, 300.00, 30, '在职',
                                                                                                       '[{"name": "王女士", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000002"}]}, {"name": "马先生", "relation": "兄弟", "methods": [{"type": "email", "value": "pony_bro@qq.com"}]}]'),

                                                                                                      (7521, '李彦宏', '销售员', 7698, '1981-02-22', 1250.00, 500.00, 30, '在职',
                                                                                                       '[{"name": "马老师", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000003"}]}, {"name": "李同学", "relation": "子女", "methods": [{"type": "wechat", "value": "robin_junior"}]}]'),

                                                                                                      (7566, '雷军', '经理', 7839, '1981-04-02', 2975.00, NULL, 20, '在职',
                                                                                                       '[{"name": "小米家属", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000004"}, {"type": "phone", "value": "010-8888888"}]}, {"name": "林斌", "relation": "好友", "methods": [{"type": "wechat", "value": "linbin_wx"}]}]'),

                                                                                                      (7654, '丁磊', '销售员', 7698, '1981-09-28', 1250.00, 1400.00, 30, '在职',
                                                                                                       '[{"name": "网易管家", "relation": "兄弟", "methods": [{"type": "email", "value": "ding_home@163.com"}]}, {"name": "老丁", "relation": "父亲", "methods": [{"type": "phone", "value": "13800000005"}]}]'),

                                                                                                      (7698, '张一鸣', '经理', 7839, '1981-05-01', 2850.00, NULL, 30, '在职',
                                                                                                       '[{"name": "字节家属", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000006"}]}, {"name": "梁先生", "relation": "同学", "methods": [{"type": "phone", "value": "13700000006"}]}]'),

                                                                                                      (7782, '王兴', '经理', 7839, '1981-06-09', 2450.00, NULL, 10, '在职',
                                                                                                       '[{"name": "美团小妹", "relation": "妹妹", "methods": [{"type": "phone", "value": "13800000007"}]}, {"name": "穆先生", "relation": "合伙人", "methods": [{"type": "wechat", "value": "mu_wx"}]}]'),

                                                                                                      (7788, '刘强东', '分析师', 7566, '1987-04-19', 3000.00, NULL, 20, '在职',
                                                                                                       '[{"name": "奶茶", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000008"}, {"type": "wechat", "value": "milktea"}]}, {"name": "京东管家", "relation": "员工", "methods": [{"type": "phone", "value": "400-606-5500"}]}]'),

                                                                                                      (7839, '任正非', '总裁', NULL, '1981-11-17', 5000.00, NULL, 10, '在职',
                                                                                                       '[{"name": "孟女士", "relation": "子女", "methods": [{"type": "phone", "value": "13800000009"}]}, {"name": "姚女士", "relation": "子女", "methods": [{"type": "phone", "value": "13700000009"}]}]'),

                                                                                                      (7844, '黄峥', '销售员', 7698, '1981-09-08', 1500.00, 0.00, 30, '在职',
                                                                                                       '[{"name": "拼拼家属", "relation": "母亲", "methods": [{"type": "phone", "value": "13800000010"}]}, {"name": "陈先生", "relation": "好友", "methods": [{"type": "wechat", "value": "pinduoduo_001"}]}]'),

                                                                                                      (7876, '程维', '职员', 7788, '1987-05-23', 1100.00, NULL, 20, '在职',
                                                                                                       '[{"name": "滴滴小张", "relation": "同事", "methods": [{"type": "phone", "value": "13800000011"}]}, {"name": "柳女士", "relation": "合伙人", "methods": [{"type": "phone", "value": "13900000011"}]}]'),

                                                                                                      (7900, '沈南鹏', '职员', 7698, '1981-12-03', 950.00, NULL, 30, '在职',
                                                                                                       '[{"name": "红杉秘书", "relation": "同事", "methods": [{"type": "phone", "value": "021-66668888"}]}, {"name": "沈太太", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000012"}]}]'),

                                                                                                      (7902, '周鸿祎', '分析师', 7566, '1981-12-03', 3000.00, NULL, 20, '在职',
                                                                                                       '[{"name": "360安保", "relation": "同事", "methods": [{"type": "phone", "value": "110"}]}, {"name": "老周家人", "relation": "兄弟", "methods": [{"type": "phone", "value": "13800000013"}]}]'),

                                                                                                      (7934, '张小龙', '职员', 7782, '1982-01-23', 1300.00, NULL, 10, '在职',
                                                                                                       '[{"name": "微信家属", "relation": "配偶", "methods": [{"type": "wechat", "value": "allen_wife"}]}, {"name": "张先生", "relation": "兄弟", "methods": [{"type": "phone", "value": "13800000014"}]}]'),

                                                                                                      (8001, '孙正义', '实习生', 7839, '2023-01-10', 3000.00, NULL, 50, '在职',
                                                                                                       '[{"name": "软银秘书", "relation": "同事", "methods": [{"type": "phone", "value": "0081-123456"}]}, {"name": "孙太太", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000015"}]}]'),

                                                                                                      (8002, '柳传志', '工程师', 7566, '2022-05-15', 7500.00, 800.00, 99, '在职',
                                                                                                       '[{"name": "柳青", "relation": "子女", "methods": [{"type": "phone", "value": "13800000016"}]}, {"name": "联想前台", "relation": "同事", "methods": [{"type": "phone", "value": "400-100-1000"}]}]'),

                                                                                                      (8003, '杨元庆', '顾问', 7839, '2024-03-01', 9000.00, NULL, NULL, '在职',
                                                                                                       '[{"name": "杨夫人", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000017"}]}, {"name": "秘书", "relation": "同事", "methods": [{"type": "phone", "value": "13900000017"}]}]'),

                                                                                                      (8004, '董明珠', '培训师', 9999, '2020-11-11', 5500.00, NULL, 10, '在职',
                                                                                                       '[{"name": "格力管家", "relation": "兄弟", "methods": [{"type": "phone", "value": "13800000018"}]}, {"name": "秘书小孟", "relation": "同事", "methods": [{"type": "wechat", "value": "gree_meng"}]}]'),

                                                                                                      (8005, '宗庆后', '职员', 0, '2021-07-20', 850.00, NULL, 40, '在职',
                                                                                                       '[{"name": "宗女士", "relation": "子女", "methods": [{"type": "phone", "value": "13800000019"}]}, {"name": "娃哈哈工会", "relation": "同事", "methods": [{"type": "phone", "value": "0571-88888888"}]}]'),

                                                                                                      (8006, '李开复', '助理', 0, '2024-01-15', 4500.00, NULL, 0, '待入职',
                                                                                                       '[{"name": "创新工场", "relation": "同事", "methods": [{"type": "email", "value": "hr@sinovation.com"}]}, {"name": "李太太", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000020"}]}]'),

                                                                                                      (8007, '俞敏洪', '咨询顾问', 7839, '2023-08-20', 6000.00, NULL, NULL, '在职',
                                                                                                       '[{"name": "新东方前台", "relation": "同事", "methods": [{"type": "phone", "value": "400-600-0000"}]}, {"name": "俞夫人", "relation": "配偶", "methods": [{"type": "phone", "value": "13800000021"}]}]'),

                                                                                                      (8008, '章四', '实习生', 0, '2024-03-01', 2500.00, NULL, 20, '在职',
                                                                                                       '[{"name": "章大爷", "relation": "父亲", "methods": [{"type": "phone", "value": "13800000022"}]}, {"name": "章二哥", "relation": "兄弟", "methods": [{"type": "wechat", "value": "zhang_bro"}]}]'),

                                                                                                      (8009, '鲁五', '分析师', 7566, '2023-11-10', 3500.00, 200.00, 50, '在职',
                                                                                                       '[{"name": "鲁大妈", "relation": "母亲", "methods": [{"type": "phone", "value": "13800000023"}]}, {"name": "老鲁", "relation": "父亲", "methods": [{"type": "phone", "value": "13900000023"}]}]'),

                                                                                                      (8010, '韦六', '职员', 7782, '2020-05-15', 1200.00, NULL, 10, '暂停',
                                                                                                       '[{"name": "韦小宝", "relation": "兄弟", "methods": [{"type": "phone", "value": "13800000024"}]}, {"name": "双儿", "relation": "配偶", "methods": [{"type": "wechat", "value": "shuang_er"}]}]');