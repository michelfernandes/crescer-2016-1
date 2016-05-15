using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.Models;

namespace LojaNinja.Controllers
{
    public class DadosNinjasController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult SucessoPedido(DadosNinjasModel dados)
        {

            if (ModelState.IsValid) { 
                ViewBag.MensagemSucesso = "Pedido cadastrado com sucesso!";
            }
            else
            {
                ModelState.AddModelError("", "Existem erros nos campos do formulário. Por favor corrija.");
            }

            return View("SucessoPedido", dados);
        }
    }
}