﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Megaman : Robo
    {
        public Megaman()
        {
         
        }

        protected override int Ataque
        {
            get
            {
                return 6;
            }
        }

        public override void Atacar(Robo robo)
        {

            int novoAtaque = this.Ataque + BonusAtaque + (this.Vida > 30 ? 0 : 3);
            robo.ReceberAtaque(novoAtaque);
        }
    }
}
