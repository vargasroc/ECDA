package com.Roc.repository;

import com.Roc.model.Semana;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface SemanaRepository extends JpaRepository<Semana, Long> {

}


