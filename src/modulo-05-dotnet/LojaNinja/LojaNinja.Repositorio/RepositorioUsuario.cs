using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    class RepositorioUsuario
    {
         // FINGE QUE ESSA LISTA É NOSSO BANCO DE DADOS =)
         private List<Usuario>  usuarios = new List<Usuario>();

        private void CadastroPadrao()
        {
            usuarios.Add(new Usuario()
            {
                Email = "admin@admin.com",
                Nome = "Administrador",
                Senha = "63874adc5789a6e2e1fc51e40871dd53",
                Permissoes = new string[] { "ADMIN" }
            });
        }
         // VOCE NUNCA VIU ISSO =P

         public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
         {
             return usuarios.FirstOrDefault(
                 c => c.Email.Equals(email) && c.Senha.Equals(senha));
         }

        public void CadastrarUsuario(string email, string nome, string senha, string[] permissoes)
        {
            usuarios.Add(new Usuario()
            {
                Email = email,
                Nome = nome,
                Senha = senha,
                Permissoes = permissoes
            });
        }
    }
}
