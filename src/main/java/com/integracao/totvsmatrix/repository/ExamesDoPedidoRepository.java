package com.integracao.totvsmatrix.repository;

import com.integracao.totvsmatrix.model.ExameDoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamesDoPedidoRepository extends JpaRepository<ExameDoPedido, Integer> {
}
