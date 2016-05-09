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
            this.chip = Chip.Nivel2;
            VerificarChip(chip);
            Vida = 100;
        }
        public Robo(Chip chip) : this()
        {
            VerificarChip(chip);
        }

        protected Chip chip;
        public int Vida { get; protected set; }

        protected int BonusAtaqueChip = 0;
        protected int BonusDefesaChip = 0;

        protected void VerificarChip(Chip chip)
        {
            switch (chip)
            {
                case Chip.Nivel1:
                    BonusAtaqueChip = -1;
                    break;
                case Chip.Nivel3:
                    BonusAtaqueChip = 2;
                    BonusDefesaChip = 1;
                    break;
                default:
                    BonusAtaqueChip = 0;
                    BonusDefesaChip = 0;
                    break;
            }
        }
        

        protected virtual int Ataque
        {
            get
            {
                return 5 + BonusAtaqueChip;
            }
        }

        protected virtual int Defesa
        {
            get
            {
                return 0 + BonusDefesaChip;
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
