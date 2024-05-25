package com.integracao.totvsmatrix.service;

import com.integracao.totvsmatrix.model.PedidoExame;
import com.integracao.totvsmatrix.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;

@Service
public class ConsultaPedidosService {

    private final RestTemplate restTemplate;
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    ExamesDoPedidoService examesDoPedidoService;


    public ConsultaPedidosService() {
        this.restTemplate = new RestTemplate();
        // Configurando o interceptor de autenticação básica
        this.restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor("mestre", "Totvs644#"));
    }

    public List<PedidoExame> getPedidos() {
        String url = "https://alvorecerassociacao155518.rm.cloudtotvs.com.br:1756/api/framework/v1/consultaSQLServer/RealizaConsulta/INTEGRACAO.001/2/O";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        ResponseEntity<PedidoExame[]> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                PedidoExame[].class);

        List<PedidoExame> pedidos = Arrays.asList(response.getBody());
        return pedidos;
        //pedidos.forEach(System.out::println);
    }
    public void getPedidosByID(int IdOrdemServico) {
        String url = "https://alvorecerassociacao155518.rm.cloudtotvs.com.br:1756/api/framework/v1/consultaSQLServer/RealizaConsulta/INTEGRACAO.001/2/O";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        ResponseEntity<PedidoExame[]> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                PedidoExame[].class);

        List<PedidoExame> pedidos = Arrays.asList(response.getBody());
        pedidos.stream()
                .filter(pedido -> pedido.getOrdemServico() == IdOrdemServico)
                .forEach(System.out::println);
    }

    public void saveAll() {
        List<PedidoExame> pde = getPedidos();
        for (PedidoExame pedidoExame : pde) {
            pedidoRepository.save(pedidoExame);
        }
        examesDoPedidoService.saveAll();
    }

    }


