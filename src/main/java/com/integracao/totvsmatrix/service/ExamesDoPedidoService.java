package com.integracao.totvsmatrix.service;

import com.integracao.totvsmatrix.model.ExameDoPedido;
import com.integracao.totvsmatrix.repository.ExamesDoPedidoRepository;
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
public class ExamesDoPedidoService {

    private final RestTemplate restTemplate;

    @Autowired
    private ExamesDoPedidoRepository examesDoPedidoRepository;

    public ExamesDoPedidoService() {
        this.restTemplate = new RestTemplate();
        // Configurando o interceptor de autenticação básica
        this.restTemplate.getInterceptors().add(
                new BasicAuthenticationInterceptor("mestre", "Totvs644#"));
    }

    public List<ExameDoPedido> getExamesDoPedido() {
        String url = "https://alvorecerassociacao155518.rm.cloudtotvs.com.br:1756/api/framework/v1/consultaSQLServer/RealizaConsulta/INTEGRACAO.001.1/2/O";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        ResponseEntity<ExameDoPedido[]> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                ExameDoPedido[].class);

        List<ExameDoPedido> exames = Arrays.asList(response.getBody());
        return exames;

    }

    public void getExamesDoPedidoById(int IdOrdemServico) {
        String url = "https://alvorecerassociacao155518.rm.cloudtotvs.com.br:1756/api/framework/v1/consultaSQLServer/RealizaConsulta/INTEGRACAO.001.1/2/O";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);

        ResponseEntity<ExameDoPedido[]> response = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                ExameDoPedido[].class);

        List<ExameDoPedido> exames = Arrays.asList(response.getBody());
        exames.stream()
                .filter(pedido -> pedido.getOrdemservico() == IdOrdemServico)
                .forEach(System.out::println);
    }

    public void saveAll() {
        List<ExameDoPedido> exames = getExamesDoPedido();
        for (ExameDoPedido pedidoExame : exames) {
            examesDoPedidoRepository.save(pedidoExame);
        }
    }

}
