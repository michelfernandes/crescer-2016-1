using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;

namespace LojaNinja.Domino.Test
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void FazCadastroComUrgência()
        {
            var dataPedido = DateTime.Now.AddDays(2);
            // dataPedido;
            var pedido = new Pedido(dataPedido, "katana", 1200, TipoPagamento.Amex, "samurai", "SL", "RS");
            Assert.AreEqual(true, pedido.PedidoUrgente);
        }
        [TestMethod]
        public void FazCadastroSemUrgência()
        {
            var dataPedido = DateTime.Now.AddDays(7);
            // dataPedido;
            var pedido = new Pedido(dataPedido, "katana", 1200, TipoPagamento.Amex, "samurai", "SL", "RS");
            Assert.AreEqual(false, pedido.PedidoUrgente);
        }
    }
}
