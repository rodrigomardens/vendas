package br.com.marden.vendas.rest.dto;

import br.com.marden.vendas.domain.entity.ItemPedido;
import br.com.marden.vendas.validation.NotEmptyList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    @NotNull(message = "Informe o código do cliente.")
    private Integer cliente;
    @NotNull(message = "Campo Total do pedido é obrigatório.")
    private BigDecimal total;
    @NotEmptyList(message = "Pedido não pode ser realizado sem itens.")
    private List<ItemPedidoDTO> items;

}
