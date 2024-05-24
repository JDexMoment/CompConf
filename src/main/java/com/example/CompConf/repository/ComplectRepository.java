package com.example.CompConf.repository;

import com.example.CompConf.model.Complect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplectRepository  extends JpaRepository<Complect,Long> {
    List<Complect> findByType(String type);
}
