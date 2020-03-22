package com.user.dao;

import com.user.pojo.Complaint;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintDao {
    int insert(Complaint complaint);
}
