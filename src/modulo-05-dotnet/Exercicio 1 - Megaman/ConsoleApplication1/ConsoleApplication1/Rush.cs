using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    public class Rush : Robo , IUpgrade
    {
        
        protected override int Ataque
        {
            get
            {
                return 4;
            }
        }

        protected override int Defesa
        {
            get
            {
                return 3;
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
    }
}
