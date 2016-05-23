using CdZ.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace CdZ.Repositorio.EF
{
    /*
     * Criamos nosso repositório de pedidos aqui, implementando nossa
     * interface de regras de repositório de pedidos.
     */
    public class CavaleiroRepositorioEF : ICavaleiroRepositorio
    {
        public int Adicionar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Para informarmos um INSERT, devemos setar o State como Added.
                 */
                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Added;
                db.SaveChanges();
                return cavaleiro.Id;
            }
        }

        public Cavaleiro Buscar(int id)
        {
            using (var db = new ContextoDeDados())
            {
                return db.Cavaleiro
                   .Include(_ => _.LocalNascimento)
                   .Include(_ => _.LocalTreinamento)
                   .Include(_ => _.Golpes)
                   .Include(_ => _.Imagens)
                   .SingleOrDefault(_ => _.Id == id);
            }
        }

        public IEnumerable<Cavaleiro> Todos()
        {
            using (var db = new ContextoDeDados())
            {
                //TODO: paginar
                return db.Cavaleiro
                    .Include(_ => _.LocalNascimento)
                    .Include(_ => _.LocalTreinamento)
                    .Include(_ => _.Golpes)
                    .Include(_ => _.Imagens)
                    .OrderBy(c => c.Nome)
                    .ToList();
            }
        }

        public void Excluir(int id)
        {
            using (var db = new ContextoDeDados())
            {
                /*
                 * Para realizar um DELETE no banco de dados,
                 * infelizmente precisamos buscar o objeto no banco para então
                 * removê-lo.
                 */
                var cavaleiroASerExcluido = db.Cavaleiro.Find(id);
                var localNascimento = db.Cavaleiro.Include(_ => _.LocalNascimento).Single(_ => _.Id == id).LocalNascimento;
                var localTreinamento = db.Cavaleiro.Include(_ => _.LocalTreinamento).Single(_ => _.Id == id).LocalTreinamento;
                // devido à FK partindo de cavaleiro para local primeiro removemos cavaleiro
                db.Cavaleiro.Remove(cavaleiroASerExcluido);
                db.Local.Remove(localNascimento);
                db.Local.Remove(localTreinamento);
                db.SaveChanges();
            }
        }

        public void Atualizar(Cavaleiro pedido)
        {
            /*
             * Para fazermos uma conexão com o banco via EF, precisamos
             * instanciar um objeto do mesmo tipo de nosso DbContext, que no nosso
             * caso é o ContextoDeDados.
             */
            using (var db = new ContextoDeDados())
            {
                /*
                 * Existem várias formas de fazer um Update de uma entidade.
                 * Um deles é utilizando o método Entry, na qual você informa o tipo
                 * de objeto que será feito o update (<Pedido>), passa o objeto
                 * como parâmetro em seguida seta o stado deste objeto no banco de dados.
                 * O EF irá saber que deve fazer um Update quando o estado for EntityState.Modified.
                 * 
                 * Em seguida chamaremos o método .SaveChanges(), que irá definitivamente
                 * executar a query no banco de dados.
                 */
                db.Entry<Cavaleiro>(pedido).State = EntityState.Modified;
                db.SaveChanges();
            }
        }
    }
}
