using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVC.Models
{
    public class SobreMimModel
    {
        public string Nome { get; set; }
        public int Idade { get; set; }
        public DateTime DataNascimento;
        public string Pais { get; set; }
        public string Cidade { get; set; }
        public string Gosta { get; set; }
        public string NaoGosta { get; set; }
    }
}