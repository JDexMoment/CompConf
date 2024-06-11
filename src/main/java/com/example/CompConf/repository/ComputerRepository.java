package com.example.CompConf.repository;

import com.example.CompConf.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComputerRepository extends JpaRepository<Computer,Long> {
    List<Computer> findByWishListId(Long id);
}
