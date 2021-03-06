﻿using BaseAulaSeguranca.Filters;
using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        [HttpGet]
        [CWIToken]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                var pedido = repositorio.ObterPedidoPorId(id.Value);

                var model = new PedidoModel()
                //{
                //    Id = pedido.Id,
                //    DataEntrega = pedido.DataEntregaDesejada,
                //    NomeCliente = pedido.NomeCliente,
                //    //...
                //}
                ;

                return View("Manter", model);
            }
            else
            {
                return View("Manter");
            }
        }

        [HttpGet]
        [CWIToken]
        public ActionResult Salvar(PedidoModel model)
        {
            if (model.Estado == "RS" && model.Cidade == "SL")
                ModelState.AddModelError("", "Cidade e Estado inválidos");

            if (ModelState.IsValid)
            {
                try
                {
                    var pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);

                    //if (model.Id.HasValue)
                    //    repositorio.AtualizarPedido(pedido);
                    //else
                        repositorio.IncluirPedido(pedido);

                    ViewBag.MensagemSucesso = "Pedido salvo com sucesso!";
                    return View("Detalhes", pedido);
                }
                catch (ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                }
            }

            return View("Manter", model);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult Detalhes(int id)
        {
            var pedido = repositorio.ObterPedidoPorId(id);

            return View(pedido);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult Listagem(string cliente, string produto)
        {
            var pedidos = repositorio.ObterPedidos();

            if (!string.IsNullOrEmpty(cliente))
            {                
                pedidos = pedidos.Where(x => x.NomeCliente.IndexOf(cliente, StringComparison.InvariantCultureIgnoreCase) >= 0).ToList();
            }
            if (!string.IsNullOrEmpty(produto))
            {
                pedidos = pedidos.Where(x => x.NomeProduto.IndexOf(produto, StringComparison.InvariantCultureIgnoreCase) >= 0).ToList();
            }

            return View(pedidos);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            ViewBag.Mensagem = "Pedido excluído com sucesso!";

            return View("Mensagem");
        }
    }
}