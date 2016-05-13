using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;
using System.Globalization;

namespace LojaNinja.Domino.Test
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void InstanciaUmPedidoSemID()
        {
            var data = new DateTime(2016, 12, 28);
            var pedido = new Pedido(data, "kunai", 1200, TipoPagamento.Amex, "Mariana", "SL", "RS");
            Assert.AreEqual("28/12/2016 00:00:00", pedido.DataEntregaDesejada.ToString());
            Assert.AreEqual("kunai", pedido.NomeProduto);
            Assert.AreEqual(1200, pedido.Valor);
            Assert.AreEqual(TipoPagamento.Amex, pedido.TipoPagamento);
            Assert.AreEqual("Mariana", pedido.NomeCliente);
            Assert.AreEqual("SL", pedido.Cidade);
            Assert.AreEqual("RS", pedido.Estado);
        }
        [TestMethod]
        public void InstanciaUmPedidoSemIDSemUrgencia()
        {
            /* var data = DateTime.Today;
             data.AddDays(8);*/
            var data = new DateTime(2017, 05, 17);
            var pedido = new Pedido(data, "kunai", 1200, TipoPagamento.Amex, "Mariana", "SL", "RS");
            Assert.AreEqual(false, pedido.PedidoUrgente);
        }
        [TestMethod]
        public void InstanciaUmPedidoComIDSemUrgencia()
        {
            /* var data = DateTime.Today;
             data.AddDays(3);*/
            var data = new DateTime(2016, 05, 17);
            var pedido = new Pedido(data, "kunai", 1200, TipoPagamento.Amex, "Mariana", "SL", "RS");

            Assert.AreEqual(true, pedido.PedidoUrgente);
        }
        [TestMethod]
        public void IntanciaComADataMenorQueAAtual()
        {
            var data = new DateTime(2015, 05, 17);
            var pedido = new Pedido(data, "kunai", 1200, TipoPagamento.Amex, "Mariana", "SL", "RS");

            Assert.IsNull(pedido.PedidoUrgente);
        }
    }
}
