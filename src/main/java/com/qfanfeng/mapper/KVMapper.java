package com.qfanfeng.mapper;

import com.qfanfeng.entry.KVEntry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface KVMapper {

    @Select("SELECT\n" +
            "od.user_id k,\n" +
            "od.order_type v\n" +
            "FROM us_order od limit 10;")
    public List<KVEntry> listkv();
}
