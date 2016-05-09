using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Protoman : Robo
    {
        public Protoman()
        {
        }
        public Protoman(Chip chip) : base(chip)
        {
        }

        protected override int Defesa
        {
            get
            {
                return 2 + BonusDefesaChip;
            }
        }

        protected override int Ataque
        {
            get
            {
                return BonusAtaqueChip + (jaMorreu ?  7 : 5);
            }
        }

        private bool jaMorreu = false;
        public override void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa - BonusDefesa;
            if(dano > 0) this.Vida -= dano;
            if (this.Vida <= 0 && !jaMorreu)
            {
                this.Vida = 20;
                jaMorreu = true;
            }
        }
    }
}
