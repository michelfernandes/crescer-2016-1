'use strict';

// 1 - Daisy Game!
var daisyGame = function(numero){
  return numero%2 === 0 ? 'Love me not' : 'Love me';
}

// 2 - Maior texto
var maiorTexto = function(array){
var maiorTexto="";
for(var i=0; i<array.length; i++) {
  if(array[i].length > maiorTexto.length) maiorTexto = array[i];
}
  return maiorTexto;
}

// 3 - Instrutor querido
var imprime = function(array,funcao){
  if(typeof funcao === 'function'){
    for(var i=0; i<array.length; i++) {
      funcao(array[i]);
    }
  }
}

// 4 - Soma diferentona
function somar(x){
  return function(y){
    return x + y;
  };
}

// 5 - Fibona
var fiboSum = function(numero){
  var atual_numero = 0;
  var proximo_numero = 1;
  var aux;
  var soma = 0;
  while ( cont <= numero )
  {
      soma += atual_numero;
      aux = proximo_numero;
      proximo_numero = proximo_numero + atual_numero;
      atual_numero = aux;
  }
  return soma;
}

// 6 - Quero café
var queroCafe = function(preco,array){
  var lista = [];
  for(var i=0; i<array.length; i++) {
    if(array[i] <= preco) {
    lista.push(array[i]);
    }
  }
  return lista.sort().join(',').toString();
}

// 7 - Vários tipos
function getType(v) {
    return v === null ? 'null' : typeof v !== 'undefined' && v.constructor === Array ? 'array' : typeof v;
  }

var contarPorTipo = function(obj,tipo){
  var cont=0;
  for(var prop in obj) {
    if  (getType(obj[prop]) === tipo){
    cont++;
    }
  }
  return cont;
}


// 8 - Reflexões
var gohan = 'gohan', goku = 'Goku';
function revelarSaiyaman() {
  console.log(gohan);
  goku = 'Son Goku';  // atribui outra string para a variável global goku
  var gohan = 'Son ' + gohan; // declara a variável gohan dentro da função porem ela está undefined
  return gohan;
}
console.log(revelarSaiyaman()); // o console exibe gohan, que é o resultado de 'Son' + undefined
console.log(goku); // exibe a variável goku com o novo conteúdo que foi escrito dentro da função
