using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApplication1;

namespace UnitTestProject1
{
    [TestClass]
    public class UnitTes1t
    {
        [TestMethod]
        public void PersonagensIniciamCom100DeVida()
        {
            var megaman = new Megaman();
            Assert.AreEqual(100, megaman.Vida);

            var protoman = new Protoman();
            Assert.AreEqual(100, protoman.Vida);

            var bot = new Bot();
            Assert.AreEqual(100, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtaca1Vez()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.Atacar(bot);
            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtaca3Vezes()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.Atacar(bot);
            megaman.Atacar(bot);
            megaman.Atacar(bot);
            Assert.AreEqual(82, bot.Vida);
        }

        [TestMethod]
        public void MegamanAtacaComMenosDe30DeVida()
        {
            var megaman = new Megaman();
            var bot = new Bot();
            for (int i = 0; i < 15; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(91, bot.Vida);
        }

        [TestMethod]
        public void ProtomanAtaca1Vez()
        {
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.Atacar(bot);
            Assert.AreEqual(95, bot.Vida);
        }

        [TestMethod]
        public void ProtomanSofreAtaque1Vez()
        {
            var protoman = new Protoman();
            var bot = new Bot();
            bot.Atacar(protoman);
            Assert.AreEqual(97, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanSofreAtaque3Vezes()
        {
            var protoman = new Protoman();
            var bot = new Bot();
            bot.Atacar(protoman);
            bot.Atacar(protoman);
            bot.Atacar(protoman);
            Assert.AreEqual(91, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanSofreAtaqueDeMegaman()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            megaman.Atacar(protoman);
            Assert.AreEqual(96, protoman.Vida);
        }

        [TestMethod]
        public void MegamanAtacaProtomanComMenosDe30DeVida()
        {
            var megaman = new Megaman();
            var protoman = new Protoman();
            for (int i = 0; i < 15; i++)
            {
                protoman.Atacar(megaman);
            }
            megaman.Atacar(protoman);
            Assert.AreEqual(93, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanRenasceCom20DeVida()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            for (int i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            Assert.AreEqual(20, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanRenasceComETomaDano()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            for (int i = 0; i < 26; i++)
            {
                megaman.Atacar(protoman);
            }
            Assert.AreEqual(16, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanRenasceCom7DeAtaque()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            for (int i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            protoman.Atacar(megaman);
            Assert.AreEqual(93, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanSoRenasceUmaVez()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            for (int i = 0; i < 30; i++)
            {
                megaman.Atacar(protoman);
            }
            Assert.AreEqual(0, protoman.Vida);
        }

        [TestMethod]
        public void TodosComAFuncaoToString()
        {
            var protoman = new Protoman();
            var megaman = new Megaman();
            var bot = new Bot();
            Assert.AreEqual("Vida:100, Ataque:5, Defesa:2", protoman.ToString());
            Assert.AreEqual("Vida:100, Ataque:6, Defesa:0", megaman.ToString());
            Assert.AreEqual("Vida:100, Ataque:5, Defesa:0", bot.ToString());
        }
    }
}
