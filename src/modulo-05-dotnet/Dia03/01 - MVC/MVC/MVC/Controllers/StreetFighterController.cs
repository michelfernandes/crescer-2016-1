using MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult Sobre()
        {
            var Pessoa = new SobreMimModel();

            Pessoa.Nome = "Michel Mentz Fernandes";
            Pessoa.Idade = 19;
            Pessoa.DataNascimento = new DateTime(1997, 01, 14);
            Pessoa.Pais = "Brasil";
            Pessoa.Cidade = "Portão";
            Pessoa.Gosta = "Longas caminhadas na praia";
            Pessoa.NaoGosta = "Brócolis";

            return View(Pessoa);
        }
    }
}