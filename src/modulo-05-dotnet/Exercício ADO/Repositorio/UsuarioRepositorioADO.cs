using Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["UsuariosDB"].ConnectionString;
            var usuarioEncontrado = new Usuario();
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));                

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                while (leitor.Read())
                {
                    usuarioEncontrado.Senha = leitor["senha"] as string;
                    usuarioEncontrado.Nome = leitor["nome"] as string;
                    usuarioEncontrado.Email = leitor["email"] as string;
                }
            }
            return usuarioEncontrado;
        }
    }
}
