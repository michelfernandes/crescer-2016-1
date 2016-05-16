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
    public class LoginController : Controller
    {

        private UsuarioServico _usuarioServico; 

        public LoginController()
        {
            // O serviço de usuário sabe que precisamos de alguém que persista usuário, alguém que implementa
            // as regras dessa persistência, afinal, o Método BuscarUsuarioPorAutenticacao do serviço utiliza
            // o repositório, concorda?
            // Bem, no domínio, só temos as regras de persistência, não a implementação.
            // Aqui na camada WEB, onde tudo se junta, podemos definir quem vai ter o papel do que.
            // Neste caso, definimos que a regra de persistência de usuário será realizada pela classe UsuarioRepositorio.
            _usuarioServico = new UsuarioServico(
                    new RepositorioUsuario()
                );
        }

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Cadastro()
        {
            return View();
        }
        [HttpPost]
        public ActionResult ValidaCadastro(LoginViewModel model)
        {
            if (model.Senha != model.ConfirmarSenha)
            {
                ModelState.AddModelError("", "As senhas devem ser iguais");                
            }
            else
            {
                string[] permissoes = new string[] { "COMUM" };

                _usuarioServico.CadastrarUsuario(model.Email, model.Nome, model.Senha, permissoes );
                
                ViewBag.Mensagem = "Parabéns, você foi cadastrado com sucesso!";
            }            
            return View("Cadastro");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Entrar(LoginViewModel model)
        {
            return View("Index");
        }
    }
}