jQuery.noConflict();

(function ($) {

    var header = ["Secteurs d'activité", "Nombre d'entreprises"];

    function buildTable(data) {
        // Add header.
        thead = $('<thead>').appendTo($('#table'));
        $.each(header, function(key, value) {
            thead.append('<th>' + value +'</th>');
        });

        // Add data.
        $.each(data, function(key, line) {
            tr = $('<tr>').appendTo($('#table'));
            tr.append('<td>' + line.sector +'</td>');
            tr.append('<td>' + line.value +'</td>');
        });
    }

    $(document).ready(function () {
        $.getJSON($('#table').data('src'), buildTable);
    });

}(jQuery));
