package br.com.infnet.brewfantasy.financeiro.controller;

import br.com.infnet.brewfantasy.financeiro.service.ImpostoService;
import br.com.infnet.brewfantasy.financeiro.vo.PedidoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class FinanceiroController {
    @Autowired
    ImpostoService impostoService;
    @PostMapping
    public ResponseEntity<Map<String, Long>> calculateImposto(@RequestBody PedidoVO pedidoVO){
        Long totalTax = impostoService.calculateTotalTax(pedidoVO.getBeers());
        System.out.println(totalTax);
        return ResponseEntity.ok(Map.of("totalTax", totalTax));
    }
}
