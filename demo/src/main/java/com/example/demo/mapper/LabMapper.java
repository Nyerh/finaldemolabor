package com.example.demo.mapper;

import com.example.demo.domain.entity.Lab;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
@Mapper
public interface LabMapper {
    int deleteByPrimaryKey(Integer lId);

    int insert(Lab record);

    int insertSelective(Lab record);

    Lab selectByPrimaryKey(Integer lId);

    int updateByPrimaryKeySelective(Lab record);

    int updateByPrimaryKey(Lab record);

    List<Lab> selectAll(@Param("lab") Lab lab,@Param("page") int page, @Param("pageSize")int pageSize);

    int countAll();

    int updateStatus(@Param("order") int order,@Param("status") int status);


}