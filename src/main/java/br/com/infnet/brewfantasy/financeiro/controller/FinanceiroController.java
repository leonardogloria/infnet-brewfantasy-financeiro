package br.com.infnet.brewfantasy.financeiro.controller;

import br.com.infnet.brewfantasy.financeiro.service.ImpostoService;
import br.com.infnet.brewfantasy.financeiro.vo.NotaVO;
import br.com.infnet.brewfantasy.financeiro.vo.PedidoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping
public class FinanceiroController {
    private static Logger log = LoggerFactory.getLogger(FinanceiroController.class);

    @Autowired
    ImpostoService impostoService;
    @Autowired
    RestTemplate restTemplate;
    @PostMapping
    public ResponseEntity<Map<String, Long>> calculateImposto(@RequestBody PedidoVO pedidoVO){
        Long totalTax = impostoService.calculateTotalTax(pedidoVO.getBeers());
        System.out.println(totalTax);
        int randomico = new Random().nextInt(6000);
        log.info("Financeiro - passando id randomico... " + randomico);
        NotaVO forObject = restTemplate.getForObject("http://NOTA-FISCAL/nota/" + randomico, NotaVO.class);
        return ResponseEntity.ok(Map.of("totalTax", totalTax));
    }
}
