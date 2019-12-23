package com.qfanfeng.mapper;


import com.qfanfeng.entry.SpringBootMysqlTest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 和mysql整合测试接口
 * 需要注解
 */
@Mapper
public interface SpringBootMysqlInterface {

    @Select("SELECT\n" +
            "pfs.gender gender,\n" +
            "pfs.age_range age_range\n" +
            "FROM platform_flow_stat pfs\n" +
            ";")
    List<SpringBootMysqlTest> list();
}
