<?php
/*
Template Name: События
*/
?>

<?php
	get_header();
?>

<section id="events">
<div class="container">
    <div  class="row event_row">
        <div class="card event" class="col-sm-12 col-6" >
          <img src="<?php echo bloginfo("template_url"); ?>/assets/img/big_logo_.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Название карточки</h5>
            <p class="card-text">Some quick example text to build on<br>the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
          </div>
        </div>

        <div class="card event" class="col-sm-12 col-6" >
          <img src="<?php echo bloginfo("template_url"); ?>/assets/img/big_logo_.png" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Название карточки</h5>
            <p class="card-text">Some quick example text to build on<br>the card title and make up the bulk of the card's content.</p>
            <a href="#" class="btn btn-primary">Переход куда-нибудь</a>
          </div>
        </div>
    </div>
</div>
</section>
<?php
	get_footer();
?>
