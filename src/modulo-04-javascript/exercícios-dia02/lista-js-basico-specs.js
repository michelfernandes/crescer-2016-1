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
/*
describe('Ex 3. Canivete suíço', function() {
  it('receber o cavaleio com mais golpes', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);// março, maio, novembro
  });
});*/
