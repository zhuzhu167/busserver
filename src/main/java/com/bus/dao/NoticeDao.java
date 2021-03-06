package com.bus.dao;

import com.bus.pojo.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeDao {

    int insert(Notice notice);

    int delete(Integer id);

    List selectAll();
}
