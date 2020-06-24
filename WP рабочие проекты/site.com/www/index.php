

<?php
	get_header();
?>
	
	
<section id="crsl">
	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel" ><!--data-interval="false"-->
		  <ol class="carousel-indicators">				
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>

			
		  <div class="carousel-inner">				
				
						<div class="carousel-item active">
									<img src="<?php the_field('img1'); ?>" class="d-block w-100" alt="...">
								
									<div class="carousel-caption d-none d-md-block"> <!----класс который делает невидимым надписи и кнопку при малом экране-->
										<p><?php the_field('title1'); ?></p>
										<h2 class="vse_vidi"><?php the_field('text1'); ?></h2>
										<button class="contact"><?php the_field('button1'); ?></button>
									</div>
						</div>
				
						<div class="carousel-item">
								<img src="<?php the_field('img2'); ?>" class="d-block w-100" alt="..."> 
								<div class="carousel-caption d-none d-md-block"> <!----класс который делает невидимым надписи и кнопку при малом экране-->
										<p><?php the_field('title2'); ?></p>
										<h2><?php the_field('text2'); ?></h2>
										<button class="contact"><?php the_field('button2'); ?></button>
									</div>
						</div>
					
			    <div class="carousel-item">
			      <img src="<?php the_field('img3'); ?>" class="d-block w-100" alt="..."> 
			      <div class="carousel-caption d-none d-md-block"> <!----класс который делает невидимым надписи и кнопку при малом экране-->
							<p><?php the_field('title3'); ?></p>
							<h2><?php the_field('text3'); ?></h2>
							<button class="contact"><?php the_field('button3'); ?></button>
						</div>
			    </div>

		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>
		
</section>




<section id="podr">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-12"><img id="podr_img" src="<?php the_field('wc_img'); ?>" alt="..."></div>
			<div class="col-lg-6 col-md-12 opis" data-aos="fade-right" data-aos-delay="1000" data-aos-duration="2000">
				<h3 id="welc"><?php the_field('wc_title'); ?></h3>
				<h2 id="welc_h2"><?php the_field('wc_podzag'); ?></h2>
				<p id="wc_opis"><?php the_field('wc_text'); ?></p>
			</div>
		</div>
	</div>
</section>


<section id="servic">
	<div class="container">
		<div class="row">
			
			<div class="col-lg-6 col-md-12 serv_div1" data-aos="fade-right" data-aos-delay="1000" data-aos-duration="2000">
				<h2><a name="usl"></a><?php the_field('serv_title'); ?></h2>
				<p><?php the_field('serv_text'); ?></p>
				<ul>
					<li> >>  <?php the_field('micro'); ?> </li>
					<li> >>  <?php the_field('eys_line'); ?> </li>
					<li> >>  <?php the_field('lips'); ?> </li>
				</ul>
				<form action="<?php the_field('serv_butt'); ?>">
				<button class="more_rew"><?php the_field('serv_butt_text'); ?></button>
				</form>

			</div>

			<div class="col-lg-6 col-md-12"><img  src="<?php the_field('serv_img'); ?>" alt="Наши услуги"></div>
		</div>
	</div>
</section>

<section id="safity">
	<div class="container">
		<div class="row">			

			<div class="col-lg-6 col-md-12"><img  src="<?php the_field('img_sertf'); ?>" alt="..."></div>

			<div class="col-lg-6 col-md-12 serv_div2" data-aos="fade-right" data-aos-delay="1000" data-aos-duration="2000">
				<h2 id="st_kac"><?php the_field('title3'); ?></h2>
				<p id="st_opis"><?php the_field('opis3'); ?></p>
				<ul>
					<li> >>  <?php the_field('punkt1'); ?>   </li>
					<li> >>  <?php the_field('punkt2'); ?> </li>
					<li> >>  <?php the_field('punkt3'); ?> </li>
				</ul>
				<form action="<?php the_field('butt_sertf'); ?>">
				<button class="more_safity"><?php the_field('butt_sertf_text'); ?></button>
				</form>
			</div>
		</div>
	</div>
</section>

<section id="gal">
	<div class="container">
<h2 id="our_gal">НАША ГАЛЕРЕЯ</h2>
		<div class="row">

  <!-- Grid column -->
  <div class="col-md-12 d-flex justify-content-center mb-5">

    <button type="button" class="btn btn-outline-black waves-effect filter" data-rel="all">Все</button>
    <button type="button" class="btn btn-outline-black waves-effect filter" data-rel="1">Губы</button>
    <button type="button" class="btn btn-outline-black waves-effect filter" data-rel="2">Глаза</button>
    <button type="button" class="btn btn-outline-black waves-effect filter" data-rel="3">Брови</button>

  </div>
  <!-- Grid column -->

</div>
<!-- Grid row -->

<!-- Grid row -->
<div class="gallery" id="gallery">

  <!-- Grid column -->
  <div class="mb-3 pics animation all 3">
		<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our3.jpg"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our3.png" alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

  <!-- Grid column -->
  <div class="mb-3 pics animation all 1">
		<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our1.jpg"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our1.png" alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

  <!-- Grid column -->
  <div class="mb-3 pics animation all 1">
		<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our66.png"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our6.png" alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

  <!-- Grid column -->
  <div class="mb-3 pics animation all 2">
		<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our4.jpeg"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our4.png" alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

  <!-- Grid column -->
  <div class="mb-3 pics animation all 2">
		<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our55.png"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our5.png" alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

  <!-- Grid column -->
  <div class="mb-3 pics animation all 1">
	<a data-fancybox="gallery" href="<?php echo bloginfo("template_url"); ?>/assets/img/our22.png"><img class="img-fluid" src="<?php echo bloginfo("template_url"); ?>/assets/img/our2.png"alt="Card image cap"></a>
  </div>
  <!-- Grid column -->

</div>
<!-- Grid row -->
	</div>

</section>


<section id="reviews">
	<div class="container">
		<h3>ОТЗЫВЫ</h3>
		
		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
			  <div class="carousel-inner">
					<?php
														// параметры по умолчанию
										$posts = get_posts( array(
											'numberposts' => -1,
											'category_name'    => 'testimonials',
											'orderby'     => 'date',
											'order'       => 'ASC',											
											'post_type'   => 'post',
											'suppress_filters' => true, // подавление работы фильтров изменения SQL запроса
										) );

										foreach( $posts as $key => $post ){
											setup_postdata($post);
												// формат вывода the_title() ...
												?>
												 <div class="carousel-item <?php if ($key == 0) echo('active'); ?>">
												 <div class="carousel-caption">
													 <p><?php the_field('testem_p')?></p>
													 <h3><?php the_field('testem_u')?></h3>
													 
												 </div>
											 </div>

												<?php
												

										}

										wp_reset_postdata(); // сброс
					?>
				   

				   
			  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
			    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
			    <span class="carousel-control-next-icon" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
		</div>
		<form action="<?php the_field('more_otz_link'); ?>">
				<button class="more_rew"><?php the_field('butt_otz_text'); ?></button>
		</form>
	</div>

</section>

<?php
	get_footer();
?>


</body>


 
	



</html>