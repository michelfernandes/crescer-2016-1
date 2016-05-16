using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuario : IUsuarioRepositorio
    {

        private List<Usuario> _usuarios;

        public RepositorioUsuario()
        {
            _usuarios = new List<Usuario>();

            _usuarios.Add(new Usuario()
            {
                Email = "admin@admin.com",
                Senha = "e99a18c428cb38d5f260853678922e03", //abc123
                Nome = "Usuário Comum"
            });

           
        }

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
         {
             return _usuarios.FirstOrDefault(
                 c => c.Email.Equals(email) && c.Senha.Equals(senha));
         }

        public void CadastrarUsuario(string email, string nome, string senha, string[] permissoes)
        {
            _usuarios.Add(new Usuario()
            {
                Email = email,
                Nome = nome,
                Senha = senha,
                Permissoes = permissoes
            });
        }
    }
}
