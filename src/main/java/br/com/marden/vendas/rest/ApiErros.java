package br.com.marden.vendas.rest;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class ApiErros {

    private List<String> erros;

    public ApiErros(List<String> erros) {
        this.erros = erros;
    }

    public ApiErros(String mensagemErro) {
        this.erros = Arrays.asList(mensagemErro);
    }

}
