package com.pingan.rym.dao.master;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pingan.rym.dto.ItemParamDTO;
import com.pingan.rym.dto.ItemParamDTO2;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 刘欣武
 * @version $Id: ItemParamMapper, v 0.1 2019/6/25 11:29 刘欣武 Exp$
 */
@Mapper
@Repository
public interface ItemParamMapper {

    @Select("select * from tb_item_param_group")
    List<ItemParamDTO> getItemParams();

    ItemParamDTO getOne(Integer id);

    @Select("select * from tb_item_param_group")
    @Results(id="ite",value = {
            @Result(property = "id",column ="id" ,jdbcType =JdbcType.INTEGER),
            @Result(property = "groupName",column ="group_name" ,jdbcType =JdbcType.VARCHAR),
            @Result(property = "itemCatId",column ="item_cat_id" ,jdbcType =JdbcType.VARCHAR)
    })
    @ResultType(ItemParamDTO2.class)
    List<ItemParamDTO2> getItemParamsList();

    @Select("select * from tb_item_param_group")
    @ResultMap("ite")
    List<ItemParamDTO2> getItemParamsListFuck();


//    @Insert("INSERT INTO monitor_alarm_info(id,device_id,train_code,manufactor,cc_str,alarm_type,alarm_event,work_condition,alarm_chn,driver_id,vice_driver_id,start_time,end_time,alarm_time,gps_lng,gps_tidu,analyze_status,audit_status,audit_opinion,create_time,remark) " +
//            "VALUES (null,#{deviceId},#{trainCode},#{manufactor},#{ccStr},#{alarmType},#{alarmEvent},#{workCondition},#{alarmChn},#{driverId},#{viceDriverId},#{startTime},#{endTime},#{alarmTime},#{gpsLng},#{gpsTidu},#{analyzeStatus},#{auditStatus},#{auditOpinion},now(),#{remark})")
//    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
//    Integer insertAlarmInfo(MonitorAlarmInfo monitorAlarmInfo);
}