'use strict';

var $frmBuscaEcletica = $('#frmBuscaEcletica');
$frmBuscaEcletica.submit(function (e) {

    var idArtista;
    var $artista = encodeURI( $('input[name=nome]').val() );
    
    $.ajax({ url: 'https://api.spotify.com/v1/search?q=' + $artista + '&type=artist', type: 'GET' })
       .done(function (res) {
           idArtista = res.artists.items[0].id

           $.ajax({ url: 'https://api.spotify.com/v1/artists/' + idArtista + '/albums?limit=50', type: 'GET' })
                .done(function (ie) {
                    ie.items.forEach(function (obj) {

                        console.log(idArtista);
                        $('#lista').append($('<li>').append($('<img>').attr('src', obj.images[1].url)));
                        console.log(obj.images[1].url);
                    });
                });

       });


    

    return e.preventDefault();
});