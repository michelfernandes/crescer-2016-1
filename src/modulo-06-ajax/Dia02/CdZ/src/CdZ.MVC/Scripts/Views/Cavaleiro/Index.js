'use strict';

var arrayCavaleiros = [];

function carregarDadosNaPagina() {
    $.ajax({ url: urlCavaleiroGet, type: 'GET' })
    .then(
        function onSuccess(res) {
            console.log(res.data);
            var $cavaleiros = $('#cavaleiros');
            res.data.forEach(function (cava) {
                $cavaleiros.append(
                    $('<li>').append(cava.Nome)
                );
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
};
registrarEventoDoBotao();

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
                                $('#cavaleiros').append(
                                     $('<li>').append(e.Nome)
                                    );
                                arrayCavaleiros.push(e.Id);
                                cont++;
                            }
                        });
                        if (cont != 0)notificarNovosCavaleiros(cont);
                    })
                }, 5000);
            });


/*.done(function (res) {
    console.log(res.data);
        var $cavaleiros = $('#cavaleiros');
        res.data.forEach(function (cava) {
            $cavaleiros.append(
                $('<li>').append(cava.Nome)
            );
        });
})
.fail(function (res) {
    console.error(':(');
    console.error(res);

    var criarSpanComErro = function (msg) {
        return $('<span>').text(msg).addClass('erro');
    };

    $('#feedback')
    .append(criarSpanComErro(res.status))
    .append($('<br>'))
    .append(criarSpanComErro(res.statusText));
});*/