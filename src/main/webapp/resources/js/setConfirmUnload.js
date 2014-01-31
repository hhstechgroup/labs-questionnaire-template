/**
 * Created with IntelliJ IDEA.
 * User: anna.zagrebelnaya
 * Date: 1/30/14
 * Time: 6:20 PM
 * To change this template use File | Settings | File Templates.
 */

$(function() {
    // Set the unload message whenever any input element get changed.
    $(':input').on('change', function() {
        setConfirmUnload(true);
    });

    // Turn off the unload message whenever a form get submitted properly.
    $('form').on('submit', function() {
        setConfirmUnload(false);
    });
});

function setConfirmUnload(on) {
    var message = "You have unsaved data. Are you sure to leave the page?";
    window.onbeforeunload = (on) ? function() { return message; } : null;
}

