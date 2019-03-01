package com.lanou.dao;

import com.lanou.pojo.BMan;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;



public interface BManDao extends Mapper<BMan> {
    //selective:null不能传过去

    //通用Mapper提供单表操作

    List<BMan> selectAllBMan();

    BMan selectById(int id);
}
