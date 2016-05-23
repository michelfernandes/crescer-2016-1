'use strict';

var arrayCavaleiros = [];

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            res.data.forEach(function (cava) {
                
                carregarCavaleiro(cava);

                arrayCavaleiros.push(cava.Id);
            });
        },
        function onError(res) {
            console.error(':(');
            console.error(res);

            var criarSpanComErro = function (msg) {
                return $('<span>').text(msg).addClass('erro');
            };

            $('#feedback')
            .append(criarSpanComErro(res.status))
            .append($('<br>'))
            .append(criarSpanComErro(res.statusText));
        }
    )
    .always(function (res) {
        console.log('acabouuuuuuuu');
    });
};
carregarDadosNaPagina();

function registrarEventoDoBotao() {
    $('#btnCriar').click(function () {

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: 'Xiru ' + new Date().getTime(),
                AlturaCm: 187,
                Signo: 7,
                TipoSanguineo: 1,
                DataNascimento: new Date(),
                Golpes: ['Cólera do Dragão', 'Cólera dos 100 dragões'],
                LocalNascimento: {
                    Texto: 'Beijing'
                },
                LocalTreinamento: {
                    Texto: '5 picos de rosan'
                },
                Imagens: [{
                    Url: 'http://images.uncyc.org/pt/3/37/Shiryumestrepokemon.jpg',
                    IsThumb: true
                }, {
                    Url: 'http://images.uncyc.org/pt/thumb/5/52/Shyryugyarados.jpg/160px-Shyryugyarados.jpg',
                    IsThumb: false
                }]
            }
        });

    });

    $('#btnNovoCavaleiro').click(function (e) {

        var formData = new FormData($('#frmNovoCavaleiro')[0]);

        var novasImagens = [];
        $('#novasImagens li').each(function (i) {
            novasImagens.push({
                url: $(this).find('input[name=urlImagem]').val(),
                isThumb: $(this).find('input[name=isThumb]').is(':checked')
            });
        });

        var novosGolpes = [];
        $('#novosGolpes li').each(function (i) {
            novosGolpes.push($(this).find('input[name=golpe]').val());
        });

        $.ajax({
            url: urlCavaleiroPost,
            type: 'POST',
            data: {
                Nome: formData.get('nome'),
                AlturaCm: parseFloat(formData.get('alturaMetros')) * 100,
                pesoLb: parseFloat(formData.get('pesoKg')) * 2.20462262,
                Signo: formData.get('signo'),
                TipoSanguineo: formData.get('tipoSanguineo'),
                DataNascimento: formData.get('dataNascimento'),
                Golpes: novosGolpes,
                LocalNascimento: {
                    Texto: formData.get('localNascimento')
                },
                LocalTreinamento: {
                    Texto: formData.get('localTreinamento')
                },
                Imagens: novasImagens
            }
        });

        $frmNovoCavaleiro[0].reset();
        e.preventDefault();
    });
};
registrarEventoDoBotao();

function obterThumb(cavaleiro) {
    // Pegando a primeira imagem que é thumbnail
    return cavaleiro.Imagens.filter(function (i) {
        return i.IsThumb.is(':checked');
    })[0];
};

function carregarCavaleiro(cavaleiro) {

    var imagem = obterThumb(cavaleiro) || { Url: 'https://i.ytimg.com/vi/trKzSiBOqt4/hqdefault.jpg' };

    $('#cavaleiros').append(
                    $('<li>').append(cavaleiro.Nome).append($('<img>').attr('src', imagem.Url).addClass('imgCava'))
                     .append($('<button>').text('Editar'))
                     .append($('<button>').text('Excluir'))
                );
}

function notificarNovosCavaleiros(numero) {
    Notification.requestPermission().then(function (result) {
        console.log(result);
        if (result === 'granted') {
            var plural = (numero === 1 ? '' : 's');
            var options = {
                body: numero + ' novo'+ plural +' cavaleiro' + plural + ' adicionado' + plural,
                icon: 'http://vignette1.wikia.nocookie.net/vsbattles/images/4/41/Seiya_Render_1.png/revision/latest?cb=20160227173402'
            }
            new Notification('', options);
        }
    });
};

$(document).ready(
            function () {
                setInterval(function () {                    
                    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
                    .done(function (res) {
                        var cont = 0;
                        res.data.forEach(function (e) {
                            if($.inArray(e.Id,arrayCavaleiros) === -1)
                            {
                                carregarCavaleiro(e);

                                arrayCavaleiros.push(e.Id);
                                cont++;
                            }
                        });
                        if (cont != 0)notificarNovosCavaleiros(cont);
                    })
                }, 5000);
            });

$('#btnAdicionarGolpe').click(function () {
    var $novoTxt = $('<input>').attr('name', 'golpe').attr('type', 'text').attr('placeholder', 'Ex: Pó de diamante');
    $('#novosGolpes').append( $('<li>').append($novoTxt) );
});

$('#btnAdicionarImg').click(function () {
var $novoTxt = $('<input>').attr('name', 'urlImagem').attr('type', 'text').attr('placeholder', 'Ex: bit.ly/shiryu.png');
var $novoCheckbox =
  $('<label>').append(
    $('<input>')
    .attr('type', 'checkbox')
    .attr('name', 'isThumb')
    .attr('checked', 'checked')
  ).append('É thumbnail?');
$('#novasImagens').append( $('<li>').append($novoTxt).append($novoCheckbox));
});