$(function () {

    var $container = $('.page__list');

    $.ajax({
        url: '/users',
        dataType: 'json'
    }).done(function (data) {
        var html = '';
        data.forEach(function (user) {

            html += '<div class="user">';
            html += '<div class="user__name">' + user.firstName + ' ' + user.lastName + '</div>';
            html += '<div class="user__contacts">';
            user.contacts.forEach(function (contact) {
               html += '<div class="contact">';
               html += '<div class="contact__type">' + contact.type + '</div>';
               html += '<div class="contact__value">' + contact.value + '</div>';
               html += '</div>';
            });
            html += '</div>';
            html += '</div>'
        });

        $container.html(html);
    })
});