
<?php
	/* Template Name: Azeri */
	get_header();
?>
		
		<section   id="main_logo">
			<div class="container">
				<div class="row" id="mis">
						<div data-aos="zoom-in-up" id="logo" class="col-md-6 col-xl-4">
							<img id="img_big_logo" alt="Лого" src="<?php the_field('img_big_logo');?>">	
							<h1 ><?php the_field('title_slider') ;?></h1>
						</div>

						<div id="carouselExampleSlidesOnly" class="carousel slide col-md-6 col-xl-8" data-ride="carousel" >
							<div class="carousel-inner">
								
								<div class="carousel-item active">
										<img src="<?php the_field('slider_im1');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im2');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im3');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im4');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im5');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im6');?>" class="d-block w-100" alt="...">
								</div>
								<div class="carousel-item">
									<img src="<?php the_field('slider_im7');?>" class="d-block w-100" alt="...">
								</div>

								<div class="carousel-item">
									<img src="<?php the_field('slider_im8');?>" class="d-block w-100" alt="...">
								</div>

								<div class="carousel-item">
									<img src="<?php the_field('slider_im9');?>" class="d-block w-100" alt="...">
								</div>

								<div class="carousel-item">
									<img src="<?php the_field('slider_im10');?>" class="d-block w-100" alt="...">
								</div>
							</div>
						</div>
				</div>
			</div>
		</section>

		

		<section id="mission">
			<div class="container">
				<h2 data-aos="fade-left"><?php the_field('mission_zag');?></h2>
				<hr>
				<ul id="ul_miss">
				<li data-aos="fade-up"> <?php the_field('mission_text');?> </li>				
			</ul>

			</div>
		</section>

		<section id="who">
			<div class="container">			
				<div class="row">
					<div data-aos="zoom-in-down" class="col-lg-3 dv_flag" >
							<img src="<?php the_field('flag_ua');?>"  class="img_fl" alt="...">
					</div>
					<div data-aos="fade-left" class="col-lg-6">
				<h2 data-aos="fade-left"><?php the_field('kto_mi_zag');?></h2>
				<hr>				
				<p data-aos="fade-up">
					<?php the_field('kto_mi_opis');?>
				</p>				
				</div>
					<div data-aos="zoom-in-up" class="col-lg-3 dv_flag">
						<img src="<?php the_field('flag_az');?>" class="img_fl" alt="...">						
					</div>
				</div>				
			</div>
		</section>


		<section id="partners">
			<div class="container">
				<h2 data-aos="fade-left"><?php the_field('zag_azer');?></h2>
				<hr>		
				
				<div  class="row">
					<div data-aos="zoom-in-down" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
						<div class="card">
							<div class="card-body">							
								<img src="<?php the_field('href1_img');?>" alt="...">
								<p class="card-text"><?php the_field('href1_text');?></p>								
								<a target="_blank" href="<?php the_field('href1');?>" class="btn btn-primary">Перейти</a>
							</div>
						</div>
					</div>
					<div data-aos="zoom-in-up" data-aos="flip-right" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
						<div class="card">
							<div class="card-body">								
								<img src="<?php the_field('href2_img');?>" alt="...">
								<p class="card-text"><?php the_field('href2_text');?></p>								
								<a target="_blank" href="<?php the_field('href2');?>" class="btn btn-primary">Перейти</a>
							</div>
						</div>
					</div>

					<div data-aos="zoom-in-down" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
						<div class="card">
							<div class="card-body">								
								<img src="<?php the_field('href3_img');?>" alt="...">
								<p class="card-text"><?php the_field('href3_text');?></p>							
								<a target="_blank" href="<?php the_field('href3');?>" class="btn btn-primary">Перейти</a>
							</div>
						</div>
					</div>
			
						<div data-aos="zoom-in-up" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
							<div class="card">
								<div class="card-body">							
									<img src="<?php the_field('href4_img');?>" alt="...">
									<p class="card-text"><?php the_field('href4_text');?></p>								
									<a target="_blank" href="<?php the_field('href4');?>" class="btn btn-primary">Перейти</a>
								</div>
							</div>
						</div>
						<div data-aos="zoom-in-down" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
							<div class="card">
								<div class="card-body">								
									<img src="<?php the_field('href5_img');?>" alt="...">
									<p class="card-text"><?php the_field('href5_text');?></p>								
									<a target="_blank" href="<?php the_field('href5');?>" class="btn btn-primary">Перейти</a>
								</div>
							</div>
						</div>
	
						<div data-aos="zoom-in-up" class="col-sm-12 col-md-6 col-lg-6 col-xl-4">
							<div class="card">
								<div class="card-body">								
									<img src="<?php the_field('href6_img');?>" alt="...">
									<p class="card-text"><?php the_field('href6_text');?></p>							
									<a target="_blank" href="<?php the_field('href6');?>" class="btn btn-primary">Перейти</a>
								</div>
							</div>
						</div>	
				</div>

		
		</div>
		</section>

		<?php
	get_footer();
?>
