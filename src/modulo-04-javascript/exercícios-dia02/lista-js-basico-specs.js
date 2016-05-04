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
  it('receber peso médio de 84.27', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
});
