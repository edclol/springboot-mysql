package com.qfanfeng.entry;

/**
 * 和mysql整合测试实体
 *
 * 实体中的属性需要和mysql语句的别名一样。
 */
public class SpringBootMysqlTest {
    private String gender;
    private String age_range;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge_range() {
        return age_range;
    }

    public void setAge_range(String age_range) {
        this.age_range = age_range;
    }
}
