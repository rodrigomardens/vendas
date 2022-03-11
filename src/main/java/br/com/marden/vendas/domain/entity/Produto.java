package br.com.marden.vendas.domain.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "Campo Descrição é obrigatório.")
    private String descricao;
    @NotNull(message = "Campo Preço é obrigatório")
    @Column(name="preco_unitario", precision = 20, scale = 2)
    private BigDecimal preco;

}
