package br.com.marden.vendas.service;

import br.com.marden.vendas.domain.entity.Pedido;
import br.com.marden.vendas.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

}
