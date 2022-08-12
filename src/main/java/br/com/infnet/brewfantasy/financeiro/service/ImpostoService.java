package br.com.infnet.brewfantasy.financeiro.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ImpostoService {
    public Long calculateTotalTax(List<Long> beers){
        Long reduce = beers.stream().reduce(0L, (subtotal, element) -> subtotal + new Random().nextLong(8));
        return reduce;
    }
}
