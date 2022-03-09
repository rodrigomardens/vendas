package br.com.marden.vendas.exception;

public class PedidoNaoEncontradoExpection extends RuntimeException {

    public PedidoNaoEncontradoExpection() {
        super("Pedido não encontrado.");
    }
}
