package com.example.CompConf.repository;

import com.example.CompConf.model.Complect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplectRepository  extends JpaRepository<Complect,Long> {
    //List<Complect> findByType(String type);

    @Query("SELECT c FROM Complect c WHERE c.type = :type ORDER BY c.rating DESC")
    List<Complect> findTopRatedComplectByType(String type);

}
