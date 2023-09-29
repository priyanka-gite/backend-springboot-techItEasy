package com.novi.TechItEasy.repository;

import com.novi.TechItEasy.model.Television;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TelevisionRepository extends JpaRepository<Television, Long> {
}
