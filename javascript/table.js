jQuery.noConflict();

(function ($) {

    var header = ["Secteurs d'activité", "Nombre d'entreprises"];

    function buildTable(data) {
        // Add header.
        thead = $('<thead>').appendTo($('#table'));
        $.each(header, function(key, value) {
            thead.append('<th>' +'<p>titre</p>' + value +'</th>');
        });

        // Add data.
        $.each(data, function(key, line) {
            tr = $('<tr>').appendTo($('#table'));
            tr.append('<td>' +'<p>secteur</p>' + line.sector +'</td>');
            tr.append('<td>' +'<p>nombre entreprise</p>' + line.value +'</td>');
        });
    }

    $(document).ready(function () {
        $.getJSON($('#table').data('src'), buildTable);
    });

}(jQuery));