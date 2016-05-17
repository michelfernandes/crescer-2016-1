using BaseAulaSeguranca.Models.Login;
using BaseAulaSeguranca.Services;
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
             _usuarioServico = new UsuarioServico(
                 new RepositorioUsuarioADO()
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
        public ActionResult Entrar(LoginModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                     var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);
                    
                    ServicoDeSessao.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Listagem","Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }
    }
}