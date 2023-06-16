package com.Roc.repository;

import com.Roc.model.Contenido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface ContenidoRepository extends JpaRepository<Contenido, Long> {

}
