$(function() {
    $(".btn-outline-danger").click(function() {
         $.ajax({
            url: window.location,
            type: 'DELETE',
            success: function(result) {
                window.location.href = "/customers";
            }
        });
    });
});
