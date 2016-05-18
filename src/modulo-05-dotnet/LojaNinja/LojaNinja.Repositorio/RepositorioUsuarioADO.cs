using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuarioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string ConnectionString = ConfigurationManager.ConnectionStrings["UsuariosDB"].ConnectionString;

            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "SELECT TOP 1 * FROM Usuario WHERE email = @p_email AND senha = @p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario usuarioEncontrado = null;

                if (leitor.Read())
                {
                    usuarioEncontrado = new Usuario();
                   // usuarioEncontrado.Id = Convert.ToInt32(leitor["id"].ToString());
                    usuarioEncontrado.Email = leitor["email"].ToString();
                    usuarioEncontrado.Nome = leitor["nome"].ToString();
                }

                return usuarioEncontrado;
            }
        }

        public void CadastrarUsuario(string email, string nome, string senha, string[] permissoes)
        {
           // TODO: implementar cadastro ADO
           // throw new NotImplementedException();
        }
    }
}
