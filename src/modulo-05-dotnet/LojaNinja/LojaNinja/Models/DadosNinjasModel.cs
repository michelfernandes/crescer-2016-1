using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Web.Mvc;

namespace LojaNinja.Models
{
    public class DadosNinjasModel
    {
        [DisplayName("Número do Pedido")]
        [Range(0, int.MaxValue, ErrorMessage = "O valor não pode ser negativo.")]
        public int NumeroPedido { get; set; }

        [DisplayName("Data do Pedido")]
        public DateTime DataPedido { get; set; }

        [DisplayName("Data de Entrega")]
        public DateTime DataEntrega { get; set; }

        [DisplayName("Produto")]
        public string NomeProduto { get; set; }

        [DisplayName("Valor do Produto")]
        [Range(0.0, Double.MaxValue,ErrorMessage ="O valor não pode ser negativo.")]
        public decimal Valor { get; set; }

        [DisplayName("Tipo de Pagamento")]
        public EnumTipoPagamento TipoPagamento { get; set; }

        [DisplayName("Nome do Cliente")]
        public string NomeCliente { get; set; }

        [DisplayName("Cidade")]
        public string Cidade { get; set; }

        [DisplayName("Estado")]
        public string Estado { get; set; }
    }
}