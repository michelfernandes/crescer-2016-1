'use strict';

describe('Ex 1. Doadores de sangue', function() {
  it('receber todos os tipos sanguineos O', function() {
    expect(obterDoadores()[0]).toEqual(goldSaints[4]);
    expect(obterDoadores()[1]).toEqual(goldSaints[8]);
    expect(obterDoadores()[2]).toEqual(goldSaints[11]);
  });
});

describe('Ex 2. Canivete suíço', function() {
  it('receber o cavaleio com mais golpes', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);
  });
});

describe('Ex 3. Aniversários', function() {
  it('receber o meses de março, maio e novembro', function() {
    expect(obterMesesComMaisAniversarios()).toEqual(["Março", "Maio", "Novembro"]);
  });
});

describe('Ex 4. Altura média', function() {
  it('receber altura média de 1.85', function() {
    expect(obterAlturaMedia()).toEqual(1.85);
  });
});

describe('Ex 5. Altura mediana', function() {
  it('receber altura mediana de 1.84', function() {
    expect(obterAlturaMediana()).toEqual(1.84);
  });
});

describe('Ex 6. Peso médio', function() {
  it('receber peso médio de todos', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
  it('receber peso médio dos doadores', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});

describe('Ex 7. IMC', function() {
  it('receber o IMC de todos cavaleiros', function() {
    expect(obterIMC()).toEqual([22.64, 29.48, 24.62, 24.22, 24.84, 20.53, 24.54, 24.31, 23.99, 22.45, 21.5]);
  });
});

describe('Ex 8. IMC', function() {
  it('receber os cavaleiros acima do peso', function() {
    expect(obterSobrepeso()[0]).toEqual(goldSaints[1]);
  });
});
