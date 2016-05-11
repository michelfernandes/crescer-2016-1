﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVC.Controllers
{
    public class DesafioController : Controller
    {
        // GET: Desafio
        public ActionResult Index(string aluno)
        {

            if (aluno == null) aluno = "michel";

            ViewBag.CssRecebido = aluno;
            return View();            
        }
    }
}