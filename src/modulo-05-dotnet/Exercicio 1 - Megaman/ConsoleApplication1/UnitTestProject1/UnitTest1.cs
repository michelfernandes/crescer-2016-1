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
            var protoman = new Protoman();
            var bot = new Bot();
            var rush = new Rush();
            Assert.AreEqual(100, megaman.Vida);            
            Assert.AreEqual(100, protoman.Vida);            
            Assert.AreEqual(100, bot.Vida);
            Assert.AreEqual(100, rush.Vida);
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

        [TestMethod]
        public void BonusDeAtaqueEDefesaParaTodosUpgrades()
        {
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            Assert.AreEqual(2, canhao.BonusDeAtaque);
            Assert.AreEqual(0, canhao.BonusDeDefesa);
            Assert.AreEqual(0, escudo.BonusDeAtaque);
            Assert.AreEqual(2, escudo.BonusDeDefesa);
            Assert.AreEqual(1, botas.BonusDeAtaque);
            Assert.AreEqual(1, botas.BonusDeDefesa);
        }

        [TestMethod]
        public void MegamanEquipadoComCanhao()
        {
            var canhao = new CanhaoDePlasma();
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.EquiparUpgrade(canhao);
            megaman.Atacar(bot);
            Assert.AreEqual(92, bot.Vida);
        }

        [TestMethod]
        public void MegamanEquipadoComEscudo()
        {
            var escudo = new EscudoDeEnergia();
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.EquiparUpgrade(escudo);
            bot.Atacar(megaman);
            Assert.AreEqual(97, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanEquipadoComDoisEscudosESemPerderVida()
        {
            var escudo = new EscudoDeEnergia();
            var escudo2 = new EscudoDeEnergia();
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.EquiparUpgrade(escudo);
            protoman.EquiparUpgrade(escudo2);
            bot.Atacar(protoman);
            Assert.AreEqual(100, protoman.Vida);
        }

        [TestMethod]
        public void MegamanEquipadoComCanhaoEComMenosDe30DeVida()
        {
            var canhao = new CanhaoDePlasma();
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.EquiparUpgrade(canhao);
            for (int i = 0; i < 18; i++)
            {
                bot.Atacar(megaman);
            }
            megaman.Atacar(bot);
            Assert.AreEqual(89, bot.Vida);
        }

        [TestMethod]
        public void BotEquipadoComTodosUpgrades()
        {
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var bot = new Bot();
            var bot2 = new Bot();
            bot.EquiparUpgrade(canhao);
            bot.EquiparUpgrade(escudo);
            bot.EquiparUpgrade(botas);
            bot2.Atacar(bot);
            bot.Atacar(bot2);
            Assert.AreEqual(98, bot.Vida);
            Assert.AreEqual(92, bot2.Vida);
        }

        [TestMethod]
        public void ProtomanEquipadoComTodosUpgrades()
        {
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var protoman = new Protoman();
            var bot = new Bot();

            protoman.EquiparUpgrade(canhao);
            protoman.EquiparUpgrade(escudo);
            protoman.EquiparUpgrade(botas);
            bot.Atacar(protoman);
            protoman.Atacar(bot);
            Assert.AreEqual(92, bot.Vida);
            Assert.AreEqual(100, protoman.Vida);
        }

        [TestMethod]
        public void ProtomanRenasceComEEquipa3Canhoes()
        {
            var canhao = new CanhaoDePlasma();
            var canhao2 = new CanhaoDePlasma();
            var canhao3 = new CanhaoDePlasma();
            var protoman = new Protoman();
            var megaman = new Megaman();
            for (int i = 0; i < 25; i++)
            {
                megaman.Atacar(protoman);
            }
            protoman.EquiparUpgrade(canhao);
            protoman.EquiparUpgrade(canhao2);
            protoman.EquiparUpgrade(canhao3);
            protoman.Atacar(megaman);
            Assert.AreEqual(87, megaman.Vida);
        }

        [TestMethod]
        public void BotTentaEquiparMaisDe3Upgrades()
        {
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var outroCanhao = new CanhaoDePlasma();
            var bot = new Bot();
            var megaman = new Megaman();

            bot.EquiparUpgrade(canhao);
            bot.EquiparUpgrade(escudo);
            bot.EquiparUpgrade(botas);
            bot.EquiparUpgrade(outroCanhao);
            bot.Atacar(megaman);

            Assert.AreEqual(92, megaman.Vida);
        }

        [TestMethod]
        public void RushAtaca1Vez()
        {
            var rush = new Rush();
            var bot = new Bot();
            rush.Atacar(bot);
            Assert.AreEqual(96, bot.Vida);
        }

        [TestMethod]
        public void RushSofreAtaque1Vez()
        {
            var rush = new Rush();
            var bot = new Bot();
            bot.Atacar(rush);
            Assert.AreEqual(98, rush.Vida);
        }

        [TestMethod]
        public void RushAtacaComCanhao()
        {
            var canhao = new CanhaoDePlasma();
            var rush = new Rush();
            var bot = new Bot();
            rush.EquiparUpgrade(canhao);
            rush.Atacar(bot);
            Assert.AreEqual(94, bot.Vida);
        }

        [TestMethod]
        public void RushSofreAtaqueComEscudoEBotas()
        {
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var rush = new Rush();
            var bot = new Bot();
            rush.EquiparUpgrade(botas);
            rush.EquiparUpgrade(escudo);
            bot.Atacar(rush);
            Assert.AreEqual(100, rush.Vida);
        }

        [TestMethod]
        public void MegamanEquipaRush()
        {
            var rush = new Rush();
            var megaman = new Megaman();
            var bot = new Bot();
            megaman.EquiparUpgrade(rush);
            bot.Atacar(megaman);
            megaman.Atacar(bot);
            Assert.AreEqual(90, bot.Vida);
            Assert.AreEqual(98, megaman.Vida);
        }

        [TestMethod]
        public void ProtomanEquipaRush()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var bot = new Bot();
            protoman.EquiparUpgrade(rush);
            bot.Atacar(protoman);
            protoman.Atacar(bot);
            Assert.AreEqual(91, bot.Vida);
            Assert.AreEqual(100, protoman.Vida);
        }

        [TestMethod]
        public void MegamanEquipaRushEquipadoComCanhao()
        {
            var rush = new Rush();
            var megaman = new Megaman();
            var bot = new Bot();
            var canhao = new CanhaoDePlasma();
            rush.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(bot);
            Assert.AreEqual(88, bot.Vida);
        }

        [TestMethod]
        public void MegamanComCanhaoEquipaRushEquipadoComCanhao()
        {
            var rush = new Rush();
            var megaman = new Megaman();
            var bot = new Bot();
            var canhao = new CanhaoDePlasma();
            rush.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(canhao);
            megaman.EquiparUpgrade(rush);
            megaman.Atacar(bot);
            Assert.AreEqual(86, bot.Vida);
        }

        [TestMethod]
        public void ProtomanEquipaRushEquipadoComCanhao()
        {
            var rush = new Rush();
            var protoman = new Protoman();
            var bot = new Bot();
            var canhao = new CanhaoDePlasma();
            rush.EquiparUpgrade(canhao);
            protoman.EquiparUpgrade(rush);
            protoman.Atacar(bot);
            Assert.AreEqual(89, bot.Vida);
        }

        [TestMethod]
        public void BotEquipaRushEquipadoComTodos()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var protoman = new Protoman();
            var bot = new Bot();

            rush.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(botas);
            bot.EquiparUpgrade(rush);
            protoman.Atacar(bot);
            bot.Atacar(protoman);
            Assert.AreEqual(100, bot.Vida);
            Assert.AreEqual(90, protoman.Vida);
        }

        [TestMethod]
        public void MegamanComCanhaoEquipaRushEquipadoComTodos()
        {
            var rush = new Rush();
            var canhao = new CanhaoDePlasma();
            var escudo = new EscudoDeEnergia();
            var botas = new BotasDeSuperVelocidade();
            var megaman = new Megaman();
            var bot = new Bot();

            rush.EquiparUpgrade(canhao);
            rush.EquiparUpgrade(escudo);
            rush.EquiparUpgrade(botas);
            megaman.EquiparUpgrade(canhao);

            megaman.EquiparUpgrade(rush);
            bot.EquiparUpgrade(rush);
            megaman.Atacar(bot);
            bot.Atacar(megaman);
            Assert.AreEqual(91, bot.Vida);
            Assert.AreEqual(94, megaman.Vida);
        }

        [TestMethod]
        public void CriarRobosComChips()
        {
            var protoman = new Protoman();
            var megaman = new Megaman(Chip.Nivel1);
            var bot = new Bot(Chip.Nivel2);
            var rush = new Rush(Chip.Nivel3);
            Assert.AreEqual("Vida:100, Ataque:5, Defesa:2", protoman.ToString());
            Assert.AreEqual("Vida:100, Ataque:5, Defesa:0", megaman.ToString());
            Assert.AreEqual("Vida:100, Ataque:5, Defesa:0", bot.ToString());
            Assert.AreEqual("Vida:100, Ataque:6, Defesa:4", rush.ToString());
        }

        [TestMethod]
        public void CriarRobosComChipNivel1EAtacar()
        {
            var protoman = new Protoman();
            var megaman = new Megaman(Chip.Nivel1);
            megaman.Atacar(protoman);
            Assert.AreEqual(97, protoman.Vida);
        }

        [TestMethod]
        public void CriarRobosComChipNivel1EReceberAtaque()
        {
            var megaman = new Megaman();
            var protoman = new Protoman(Chip.Nivel1);
            protoman.Atacar(megaman);
            Assert.AreEqual(96, megaman.Vida);
        }

        [TestMethod]
        public void CriarRoboComChipNivel3EUpgrades()
        {
            var megaman = new Megaman();
            var protoman = new Protoman(Chip.Nivel3);
            var canhao = new CanhaoDePlasma();
            var botas = new BotasDeSuperVelocidade();
            protoman.EquiparUpgrade(canhao);
            protoman.EquiparUpgrade(botas);
            protoman.Atacar(megaman);
            megaman.Atacar(protoman);
            Assert.AreEqual(90,megaman.Vida);
            Assert.AreEqual(98,protoman.Vida);
        }
    }
}
