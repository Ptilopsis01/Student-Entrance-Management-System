package com.example.demo.mapper;

import com.example.demo.model.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMapper extends JpaRepository<Log, Integer> {
    Log findLogByStuId(Integer id);
}
