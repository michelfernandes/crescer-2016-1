package br.com.cwi.exerciciosdia04;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Michel
 */
@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem implements Serializable {
    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SQ_PEDIDOITEM")
    @SequenceGenerator(name = "SQ_PEDIDOITEM", sequenceName = "SQ_PEDIDOITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private Long id;
            
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "IDPEDIDO")
    private Pedido pedido;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private Integer quantidade;
    
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private Double precoUnitario;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private Character situacao;
    
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Character getSituacao() {
        return situacao;
    }

    public void setSituacao(Character situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
