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

        public ActionResult Detalhes(DadosNinjasModel dados)
        {

            if (dados.Valor < 0)
            {
                ModelState.AddModelError("Valor", "O valor do pedido não deve ser negativo");
                return View("Index", dados);
            }
            if (ModelState.IsValid) { 
                ViewBag.MensagemSucesso = "Pedido cadastrado com sucesso!";
            }
            else
            {
                ModelState.AddModelError("", "Existem erros nos campos do formulário. Por favor corrija.");
            }

            return View("Detalhes", dados);
        }
    }
}