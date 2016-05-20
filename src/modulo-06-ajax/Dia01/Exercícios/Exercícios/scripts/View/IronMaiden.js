'use strict';


$('#btnCriar').click(function () {
    $.ajax({ url: 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50', type: 'GET' })
        .done(function (res) {
            res.items.forEach(function (obj) {
                $('#lista').append($('<li>').append($('<img>').attr('src', obj.images[1].url)));
                console.log(obj.images[1].url);
            });
        });
});