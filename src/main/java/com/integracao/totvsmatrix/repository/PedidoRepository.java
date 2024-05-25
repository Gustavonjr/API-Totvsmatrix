package com.integracao.totvsmatrix.repository;

import com.integracao.totvsmatrix.model.PedidoExame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoExame, Integer> {
}
