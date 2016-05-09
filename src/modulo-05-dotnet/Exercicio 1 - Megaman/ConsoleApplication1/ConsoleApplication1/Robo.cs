using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Robo
    {
        public Robo()
        {
            Vida = 100;
        }

        public int Vida { get; protected set; }

        protected virtual int Ataque
        {
            get
            {
                return 5;
            }
        }

        protected virtual int Defesa
        {
            get
            {
                return 0;
            }
        }


        protected int BonusAtaque = 0;
        protected int BonusDefesa = 0;
        private int cont = 0;

        public void EquiparUpgrade(IUpgrade upgrade)
        {
            if (cont < 3)
            {
                BonusAtaque +=  upgrade.BonusDeAtaque;
                BonusDefesa +=  upgrade.BonusDeDefesa;
                cont++;
            }
        }

        public virtual void Atacar(Robo robo)
        {
            robo.ReceberAtaque(this.Ataque + BonusAtaque);
        }

        public virtual void ReceberAtaque(int ataque)
        {
            int dano = ataque - this.Defesa - BonusDefesa;
            if(dano > 0)this.Vida -= dano;
        }

        

        public override string ToString()
        {
            return ("Vida:" + this.Vida +", Ataque:" + this.Ataque + ", Defesa:" + this.Defesa);
        }
    }
}
