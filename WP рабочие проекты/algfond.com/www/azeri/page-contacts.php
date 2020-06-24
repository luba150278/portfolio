<?php
/*
Template Name: Контакты

*/
?>
<?php
	get_header();
?>
	
<section id="contacts">
<div class="container" >
	<h2 data-aos="fade-left">Наши контакты</h2>
							<hr>
	<div data-aos="flip-left" class="row">
	<i class="fas fa-user"></i>
	<p class="podr fio"><?php the_field('fio',107);?></p>
	</div>

	<div data-aos="flip-left" class="row">
		<i class="fas fa-phone-alt zag"></i>		
		<a href="tel:<?php the_field('tel');?>"><p class="podr"><?php the_field('tel',107);?></p></a>
	</div>

	<div data-aos="flip-left" class="row">
		<i class="fas fa-envelope zag"></i>	
		<p class="popmake-154" class="podr" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="<?php the_field('email',107);?>"><?php the_field('email',107);?></p>
	</div>
					
</div>
		
</section>	

<?php
	get_footer();
?>