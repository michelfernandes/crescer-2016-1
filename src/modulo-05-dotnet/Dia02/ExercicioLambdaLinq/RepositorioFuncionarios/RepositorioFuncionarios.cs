﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Dynamic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace Repositorio
{
    public class RepositorioFuncionarios
    {
        public List<Funcionario> Funcionarios { get; private set; }

        public RepositorioFuncionarios()
        {
            CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor1 = new Cargo("Desenvolvedor Júnior", 190);
            Cargo desenvolvedor2 = new Cargo("Desenvolvedor Pleno", 250);
            Cargo desenvolvedor3 = new Cargo("Desenvolvedor Sênior", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Marcelinho Carioca", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor1;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Mark Zuckerberg", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor1;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Aioros de Sagitário", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor1;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Uchiha Madara", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor1;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Barack Obama", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor1;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Whindersson  Nunes", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor1;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Optimus Prime", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor1;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Arnold Schwarzenegger", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor1;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Bill Gates", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = desenvolvedor2;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Linus Torvalds", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = desenvolvedor2;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Dollynho Developer", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = desenvolvedor3;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return Funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo).ToList();
        }

        public IList<Funcionario> OrdenadosPorCargo()
        {
            return Funcionarios.OrderBy(x => x.Cargo.Titulo)
                .ThenBy(x => x.Nome).ToList();
        }

        public IList<Funcionario> BuscarPorNome(string nome)
        {
        //stackoverflow.com/questions/10797309/case-insensitive-comparison-in-c-sharp
            return Funcionarios.Where(x =>
            x.Nome.IndexOf(nome, StringComparison.CurrentCultureIgnoreCase) >= 0)
            .ToList();
        }        

        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var retorna = Funcionarios.Where (x => turnos
            .Contains(x.TurnoTrabalho)).ToList(); 
            return turnos.Length == 0 ? Funcionarios : retorna;
        }        

        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            throw new NotImplementedException();
        }        

        public double SalarioMedio(TurnoTrabalho? turno = null)
        {
            return this.Funcionarios.Where(f => !turno.HasValue || f.TurnoTrabalho == turno.Value)
                                    .Average(f => f.Cargo.Salario);
        }

        public IList<Funcionario> AniversariantesDoMes()
        {
            return Funcionarios.Where(x => x.DataNascimento.Month ==
            DateTime.Now.Month).ToList();
        }

        public IList<dynamic> BuscaRapida()
        {
        //stackoverflow.com/questions/10419709/how-can-i-create-my-own-selectlist-with-values-of-00-and-in-c-sharp-for-mvc
            return Funcionarios.Select(x => new
            {
                NomeFuncionario = x.Nome,
                TituloCargo = x.Cargo.Titulo
            }).ToArray();
        }

        public IList<dynamic> QuantidadeFuncionariosPorTurno()
        {
            return this.Funcionarios.GroupBy(funcionario => funcionario.TurnoTrabalho)
                                    .OrderBy(turno => turno.Key)
                                    .Select(grupo =>
                                        (dynamic)new
                                        {
                                            Turno = grupo.Key,
                                            Quantidade = grupo.Count()
                                        }).ToList();
        }

        public dynamic FuncionarioMaisComplexo()
        {
            CultureInfo ptCulture = new CultureInfo("pt-BR");
            CultureInfo entCulture = new CultureInfo("en-US");

            return this.Funcionarios.Where(f => f.Cargo.Titulo != "Desenvolvedor Júnior" && f.TurnoTrabalho != TurnoTrabalho.Tarde)
                                    .OrderByDescending(f => Regex.Replace(f.Nome, "aouieyAOUIEY", "").Length)
                                    .Select(f =>
                                    new
                                    {
                                        Nome = f.Nome,
                                        DataNascimento = f.DataNascimento.ToString("dd/MM/yyyy"),
                                        SalarioRS = f.Cargo.Salario.ToString("C", ptCulture),
                                        SalarioUS = f.Cargo.Salario.ToString("C", entCulture),
                                        QuantidadeMesmoCargo = this.Funcionarios.Count(c => c.Cargo.Equals(f.Cargo))
                                    }).First();
        }
    }
}
