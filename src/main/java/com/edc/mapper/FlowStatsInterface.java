package com.edc.mapper;

import com.edc.entry.FlowStatsKV;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 流量接口
 */
@Mapper
public interface FlowStatsInterface {

    /**
     * 获取年龄段的平均访问次数
     * @return
     */
    @Select("SELECT\n" +
            "pfs.age_range `key`,\n" +
            "SUM(pfs.avg_visit) `value`\n" +
            "FROM platform_flow_stat pfs\n" +
            "WHERE pfs.ct = #{dt} \n" +
            "GROUP BY pfs.age_range\n" +
            ";")
    List<FlowStatsKV> ageVisit(String dt);


    /**
     * 获取年龄段的平均访问时长
     * @return
     */
    @Select("SELECT\n" +
            "pfs.age_range `key`,\n" +
            "SUM(pfs.avg_duration) `value`\n" +
            "FROM platform_flow_stat pfs\n" +
            "WHERE pfs.ct = #{dt} \n" +
            "GROUP BY pfs.age_range\n" +
            ";")
    List<FlowStatsKV> ageRangeDuration(String dt);
}
