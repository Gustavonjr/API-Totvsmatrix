package com.integracao.totvsmatrix.controller;


import com.integracao.totvsmatrix.model.PedidoExame;
import com.integracao.totvsmatrix.repository.PedidoRepository;
import com.integracao.totvsmatrix.service.ConsultaPedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ExamesController {

    @Autowired
    ConsultaPedidosService consultaPedidosService;

    @Autowired
    PedidoRepository pedidoRepository;

    @RequestMapping(value = "/pedidos", method = RequestMethod.GET)
    public ResponseEntity<List<PedidoExame>> getSetores() {
        List<PedidoExame> pedidos = pedidoRepository.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

}
