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
        public ActionResult Entrar(LoginModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                // Buscamos o usuário de nosso "Banco de Dados" por seu login e senha.
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    // É sempre bom criar uma Model só para o usuário logado.
                    // Digamos que você queira utilizar somente a classe Usuário para isso,
                    // então se quisesse guardar coisas que são da sessão e não da classe usuário, como faria?
                    // mudaria a classe Usuario? Não, porque não é de sua responsabilidade os dados de sessão.
                    // mas uma view model pode ser mais flexivel.
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    // Encapsulamos aqui a regra para criar a sessão.
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