package br.com.marden.vendas.service;

import br.com.marden.vendas.domain.entity.Pedido;
import br.com.marden.vendas.domain.enums.StatusPedido;
import br.com.marden.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus(Integer id, StatusPedido statusPedido);

}
