package br.com.marden.vendas.rest.controller;

import br.com.marden.vendas.exception.RegraNegocioExpection;
import br.com.marden.vendas.rest.ApiErros;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioExpection.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraNegocioExpection(RegraNegocioExpection ex) {
        String mensagemErro = ex.getMessage();
        return new ApiErros(mensagemErro);
    }

}
