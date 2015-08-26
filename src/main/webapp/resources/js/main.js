$(function () {

    var $contactDialog = $('.modal_contact'),
        $userDialog = $('.modal_user'),
        $overlay = $('.overlay');

    $('.button_add').bind('click', function () {
        $contactDialog.fadeIn(300);
        $overlay.fadeIn(300);
        var userID = $(this).data('id');
        $('.userid').text(userID);
    });

    $('.button_adduser').bind('click', function () {
        $userDialog.fadeIn(300);
        $overlay.fadeIn(300);
    });

    $overlay.bind('click', function () {
        $contactDialog.hide();
        $userDialog.hide();
        $(this).hide();
    });

    $('.add_contact').bind('submit', function (event) {
        event.preventDefault();
        var typeID = event.target[0].value;
        var value = event.target[1].value;
        var userID = $('.userid').text();
        console.log(userID);
        console.log(typeID);
        console.log(value);
        $.ajax({
            url: '/contacts',
            method: 'POST',
            data: {
                userID: userID,
                typeID: typeID,
                value: value
            }
        }).done(function () {
            location.reload();
        });
    });

    $('.button_deleteuser').bind('click', function () {
        var id = $(this).data('id');

        $.ajax({
            url: '/users/' + id,
            method: 'DELETE'
        }).done(function () {
            location.reload();
        });
    });

    $('.button_delete').bind('click', function () {
        var contactId = $(this).data('id');

        $.ajax({
            url: '/contacts/' + contactId,
            method: 'DELETE'
        }).done(function () {
            location.reload();
        });
    });

    $('.add_user').bind('submit', function (event) {
        event.preventDefault();
        var firstName = event.target[0].value;
        var lastName = event.target[1].value;
        $.ajax({
            url: '/users',
            method: 'POST',
            data: {
                firstName: firstName,
                lastName: lastName
            }
        }).done(function () {
            location.reload();
        });
    });


});