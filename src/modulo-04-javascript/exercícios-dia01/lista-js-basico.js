'use strict';

// 1 - Daisy Game!
var daisyGame = function(number){
  return number%2 === 0 ? 'Love me not' : 'Love me';
}

// 2 - Maior texto
var maiorTexto = function(array){
var maiorTexto="";
for(var i=0; i<array.length; i++) {
  if(array[i].length > maiorTexto.length) maiorTexto = array[i];
}
  return maiorTexto;
}
