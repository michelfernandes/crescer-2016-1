'use strict';

var $frmBuscaEcletica = $('#frmBuscaEcletica');
$frmBuscaEcletica.submit(function (e) {


    $('#lista').children().detach();

    var idArtista;
    var $artista =  $('input[name=nome]').val() ;
    
    $.ajax({ url: 'https://api.spotify.com/v1/search?q=' + $artista + '&type=artist', type: 'GET' })
       .done(function (res) {

           var ehOJustin = res.artists.items[0].id === '1uNFoZAHBGtllmzznpCI3s';

           idArtista = !ehOJustin ? res.artists.items[0].id : ( Math.random() < 0.8 ? 'douchebag' : res.artists.items[0].id );

           $.ajax({ url: 'https://api.spotify.com/v1/artists/' + idArtista + '/albums?limit=50', type: 'GET' })
                .then(function onSucess(ie) {

                    ie.items.forEach(function (obj) {
                        if (obj.images.length != 0) {
                            $('#lista').append($('<li>').append($('<img>').attr('src', obj.images[1].url)));
                        }
                    });
                },
                function onError(ie) {
                    $('#lista').append($('<span>').attr('style', 'color:red').text(
                        'Caro usuário, devido a um erro ' + ie.status + ', não foi possível pesquisar por ' + $('input[name=nome]').val()
                        ));
                }
                );

       });   

    return e.preventDefault();
});