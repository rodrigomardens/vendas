package br.com.marden.vendas.service.impl;

import br.com.marden.vendas.domain.entity.Cliente;
import br.com.marden.vendas.domain.entity.ItemPedido;
import br.com.marden.vendas.domain.entity.Pedido;
import br.com.marden.vendas.domain.entity.Produto;
import br.com.marden.vendas.domain.repository.Clientes;
import br.com.marden.vendas.domain.repository.ItemsPedido;
import br.com.marden.vendas.domain.repository.Pedidos;
import br.com.marden.vendas.domain.repository.Produtos;
import br.com.marden.vendas.exception.RegraNegocioExpection;
import br.com.marden.vendas.rest.dto.ItemPedidoDTO;
import br.com.marden.vendas.rest.dto.PedidoDTO;
import br.com.marden.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos repository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedido itemsPedidoRepository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioExpection("Código de cliente inválido."));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setData(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        repository.save(pedido);
        itemsPedidoRepository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);

        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioExpection("Não é possível realizar um pedido sem items.");
        }

        return items.stream().map(dto -> {
            Integer idProduto = dto.getProduto();
            Produto produto = produtosRepository.findById(idProduto)
                    .orElseThrow(() -> new RegraNegocioExpection("Código de produto inválido: " + idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);
            return itemPedido;
        }).collect(Collectors.toList());
    }
}
