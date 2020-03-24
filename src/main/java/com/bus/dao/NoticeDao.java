package com.bus.dao;

import com.bus.pojo.Notice;
import com.bus.pojo.Route;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDao {

    int insert(Notice notice);

    int delete(Integer id);
}
