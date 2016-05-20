'use strict';

var $frmBuscaEcletica = $('#frmBuscaEcletica');
$frmBuscaEcletica.submit(function (e) {


    $('#lista').children().detach();

    var idArtista;
    var $artista =  $('input[name=nome]').val() ;
    
    $.ajax({ url: 'https://api.spotify.com/v1/search?q=' + $artista + '&type=artist', type: 'GET' })
       .done(function (res) {
           idArtista = res.artists.items[0].id


           $.ajax({ url: 'https://api.spotify.com/v1/artists/' + idArtista + '/albums?limit=50', type: 'GET' })
                .done(function (ie) {
                    ie.items.forEach(function (obj) {                       

                        if (obj.images.length != 0) {
                            $('#lista').append($('<li>').append($('<img>').attr('src', obj.images[1].url)));
                        }

                    });
                });

       });


    

    return e.preventDefault();
});