<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Перманентный макияж в Киеве. Перманентный татуаж губ, бровей, глаз. Услуги бровиста."/>
	<title><?php bloginfo('name'); echo " | "; bloginfo('description') ?></title>
	<link rel="shortcut icon" href="<?php echo bloginfo("template_url"); ?>/assets/img/logo_m1.png" type="image/png">
	<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-159818844-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-159818844-1');
</script>


	<?php		
			wp_head();
	?>
	
    
    
  
</head>
<body id='top_scroll'>
		
	
	<header>
		<div id="logo">
			<?php the_custom_logo();?>
	</div>
		<div class="container">
				<div class="call"><!---верхнее меню для мобильных-->
					<div class="call_in"><i class="fas fa-phone-square-alt"></i>
						<i class="my_bars fas fa-times"></i>
					</div>
					<div class="bars"> 
						<i class="fas fa-bars"></i>					
					</div>
				</div>				

			<div class="row row_call">
				
					<div class="col-md-4">
						<div class="wh">
							<i class="fas fa-map-marker-alt"></i>
							<p id="mesto">Киев</p>
							<div class="nazv">
								<a href="https://goo.gl/maps/3n3LyqCgGQpwZ5TC6" target="_blank"><p class="trd_p"><?php the_field('adress1' , 19);?></p></a>
								<a href="https://goo.gl/maps/FrKLYa5M5foEQF4A9" target="_blank"><p class="trd_p"><?php the_field('adress2' , 19);?></p></a>
								<a href="https://goo.gl/maps/vrE8c3w8CAujYhLH8" target="_blank"><p class="trd_p"><?php the_field('adress3' , 19);?></p></a>
							</div>
						</div>
						
					</div>
					<div class="col-md-4" >
						<div class="wh">
							<i class="fas fa-envelope"></i>
							<div class="nazv">
								<p class="trd_p popmake-171 " class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="info@companyname.com"><?php the_field('mail' , 19);?></p></div>
						</div>
						
					</div>
					<div class="col-md-4 phn">
						<div class="phone">
						<i class="fas fa-phone-alt"></i>
						<div>
							<a href="tel:<?php the_field('phone' , 19);?>"><p class="trd_p"><?php the_field('phone' , 19);?></p>
							<a href="tel:<?php the_field('phone2' , 19);?>"><p class="trd_p"><?php the_field('phone2' , 19);?></p>
						</div>
						</div>
						
					</div>
				
			</div>
		</div>	
		
	</header>	

		<!--Вторая строка-->
		<div class="row menu">
		<div class="container">
			<ul class="nav">
			  <li class="nav-item">
			    <a class="nav-link active" href="#">ГЛАВНАЯ</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#servic">УСЛУГИ</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#gal">ГАЛЕРЕЯ</a>
			  </li>
			  <li class="nav-item">
			    <a class="nav-link" href="#reviews">ОТЗЫВЫ</a>
			  </li>
				<li class="nav-item">
			    <a class="nav-link price popmake-367" href="#">ЦЕНЫ</a>
			  </li>
			  
			</ul>
		</div>
	</div>