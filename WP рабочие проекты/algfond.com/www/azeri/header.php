<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Азербайджанский культурно-общественный центр"/>
	<title><?php bloginfo('name'); echo " | "; bloginfo('description') ?></title>
	<link rel="shortcut icon" href="<?php echo bloginfo("template_url"); ?>/assets/img/big_logo_.png" type="image/png">
	<!-- Global site tag (gtag.js) - Google Analytics -->

	<?php		
			wp_head();
	?> 
    
		<meta name="google-site-verification" content="UjAQHRfDCYADyTDoj_-EmB--9i-hfawETPlumTV9hYE" />
</head>
<body id="top_scroll">
	<header>	
				
				<nav class="navbar navbar-expand-lg navbar-light ">
					<a class="navbar-brand"  href="<?php echo get_home_url() ?>">	
						<?php the_custom_logo() ?>
						<img alt="Лого" src="<?php the_field('menu_logo_img', 87);?>">
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
				
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<?php
											wp_nav_menu( [

							'menu'            => 'Main', 
							'container'       => false, 	
							'menu_class'      => 'navbar-nav mr-auto',								
							'echo'            => true,
							'fallback_cb'     => 'wp_page_menu',
							'items_wrap'      => '<ul class="navbar-nav mr-auto">%3$s</ul>',
							'depth'           => 1,
							
						] );
								?>
		
						<!--<form class="form-inline my-2 my-lg-0">
							<input class="form-control mr-sm-2" type="search" placeholder="Поиск" aria-label="Search">
							<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Поиск</button>
						</form>-->
						
					</div>
			
				</nav>
</header>		