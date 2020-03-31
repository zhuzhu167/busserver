package com.user.dao;

import com.user.pojo.Lost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LostDao {
    int insert(Lost lost);

    int delete(Integer id);

    List<Lost> selectAll();
}
