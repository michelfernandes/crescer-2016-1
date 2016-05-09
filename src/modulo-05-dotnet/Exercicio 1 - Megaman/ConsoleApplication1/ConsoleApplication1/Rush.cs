using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Rush : Robo , IUpgrade
    {
        public Rush()
        {
        }
        public Rush(Chip chip) : base(chip)
        {
        }
        protected override int Ataque
        {
            get
            {
                return 4 + BonusAtaqueChip;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3 + BonusDefesaChip;
            }
        }
        public int BonusDeAtaque
        {
            get
            {
                return this.Ataque + BonusAtaque;
            }
        }

        public int BonusDeDefesa
        {
            get
            {
               return this.Defesa + BonusDefesa;
            }
        }

        public override void Atacar(Robo robo)
        {
            if (!(robo is Megaman))
            robo.ReceberAtaque(this.Ataque + BonusAtaque);
        }
    }
}
