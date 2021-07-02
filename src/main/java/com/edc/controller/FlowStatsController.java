package com.edc.controller;


import com.edc.common.Constants;
import com.edc.entry.FlowStatsKV;
import com.edc.mapper.FlowStatsInterface;
import com.edc.util.ResMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流量模块控制器
 */
@RestController
public class FlowStatsController {

    @Autowired
    FlowStatsInterface flowStatsInterface;

    /**
     *获取年龄段的平均访问次数
     * @return
     * {
     * "code":200,
     * "msg":"请求成功",
     * "data":[239,789,3424,12]
     * "data":[0,789,3424,12]
     * }
     */
    @RequestMapping("/ageVisit/{dt}")
    public ResMsg ageRange(@PathVariable("dt") String dt){
        ResMsg resMsg = null;
        try {
            //调用接口
            List<FlowStatsKV> li =flowStatsInterface.ageVisit(dt);
            //定义一个数组，长度为4，初始值为0
            int[] res = new int[]{0,0,0,0};
            for (int i = 0; i < 4; i++) {

            }

            //循环li
           for (int i = 0;i<li.size();i++){
               //判断key是否存在
               String k = li.get(i).key;
               int v = Integer.parseInt(li.get(i).value);
               if(k.equals(Constants.ONE)){
                   res[0] = v;
               } else if(k.equals(Constants.TWO)){
                   res[1] = v;
               } else if(k.equals(Constants.THREE)){
                   res[2] = v;
               } else if(k.equals(Constants.FOUR)){
                   res[3] = v;
               }
           }
           //将res数组赋值给data
            resMsg = ResMsg.success();
            resMsg.setData(res);
        } catch (Exception e) {
            //失败
            resMsg = ResMsg.fail();
            e.printStackTrace();
        }
        //返回
        return resMsg;
    }


    /**
     * 获取年龄段的平均访问时长
     * @return
     */
    @RequestMapping("/ageDuration/{dt}")
    public ResMsg ageDuration(@PathVariable("dt") String dt){
        ResMsg resMsg = null;
        try {
            //调用接口
            List<FlowStatsKV> li =  flowStatsInterface.ageRangeDuration(dt);
            //定义list存储map
            List<Map<String,String>> res = init();
            for (int i=0;i<li.size();i++){
                if (li.get(i).getKey().equals("01")){
                    Map<String,String> m1 = res.get(0);
                    m1.put("value",li.get(i).getValue());
                } else if(li.get(i).getKey().equals("02")){
                    Map<String,String> m2 = res.get(1);
                    m2.put("value",li.get(i).getValue());
                } else if(li.get(i).getKey().equals("03")){
                    Map<String,String> m3 = res.get(2);
                    m3.put("value",li.get(i).getValue());
                } else if(li.get(i).getKey().equals("04")){
                    Map<String,String> m4 = res.get(3);
                    m4.put("value",li.get(i).getValue());
                }
            }
            //将res数组赋值给data
            resMsg = ResMsg.success();
            resMsg.setData(res);
        } catch (Exception e) {
            //失败
            resMsg = ResMsg.fail();
            e.printStackTrace();
        }
        //返回
        return resMsg;
    }

    /**
     * 初始化map
     * @return
     */
    public static List<Map<String,String>> init(){
        List<Map<String,String>> res = new ArrayList<Map<String,String>>();
        //循环初始化
        for(int i=0;i<4;i++){
            if(i == 0){
               Map<String,String> m1 = new HashMap<String,String>();
               m1.put("name","0-17岁");
               m1.put("value","0");
               res.add(0,m1);
            } else if(i == 1){
                Map<String,String> m2 = new HashMap<String,String>();
                m2.put("name","18-45岁");
                m2.put("value","0");
                res.add(1,m2);
            } else if(i == 2){
                Map<String,String> m3 = new HashMap<String,String>();
                m3.put("name","46-60岁");
                m3.put("value","0");
                res.add(2,m3);
            } else if(i == 3){
                Map<String,String> m4 = new HashMap<String,String>();
                m4.put("name","61-150岁");
                m4.put("value","0");
                res.add(3,m4);
            }
        }
        return res;
    }

}
