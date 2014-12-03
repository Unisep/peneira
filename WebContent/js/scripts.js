$(document).ready(function(){
	// hide buttons for login!
	$('#buttons').toggle();

	// animate the title in home logged-out
	$('.home-title').transition('bounce');
});

$('.dropdown')
  .dropdown({
    transition: 'drop'
 });

$('.video-item .image').dimmer({
  on: 'hover'
});

$('.ui.rating')
  .rating({
    rating: 3,
    maxRating: 5
});

$('#login, #login-2').on('click', function(){
	$('#login, #login-2').toggle();
	
	$('#buttons').transition('fade in');
});

$('.ui.video').video();

$('.message .close').on('click', function() {
  $(this).closest('.message').transition('fade out');
});