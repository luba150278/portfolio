<section id="footer">
	<div class="container">
		<div class="row">			

			<div class="col-lg-3 col-md-12">
				<h3>НАВИГАЦИЯ</h3>
				<hr>
				<ul>
					<li><a href="#top_scroll">Вверх</a></li>
					<li><a href="#servic">Наши услуги</a></li>
					<li><a href="#gal">Галерея</a></li>
					<li><a href="#safity">Система качества</a></li>
					<li><a href="#reviews">Отзывы</a></li>
					<li><a class="popmake-367" href="#">Цены</a></li>
				</ul>
				<div class="social">
					<a class="fab" target="_blank" href="https://m.facebook.com/%D0%A2%D0%B0%D1%82%D1%83%D0%B0%D0%B6-%D0%B3%D1%83%D0%B1_%D0%B1%D1%80%D0%BE%D0%B2%D0%B5%D0%B9_%D0%B3%D0%BB%D0%B0%D0%B7%D0%9A%D0%B8%D0%B5%D0%B2-105746887473084/">	<i class="fab fa-facebook-square"></i> </a>
					<a class="fab" target="_blank" href="https://instagram.com/anna_permanent_makeup_kiev?igshid=2b28kfyszeyx"> <i class="fab fa-instagram"></i> </a>
				</div>
			</div>
			<div class="col-lg-5 col-md-12">
				<h3>КАРТА</h3>
				<hr>
		
				<iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d40622.199609367126!2d30.4738408!3d50.4804385!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cc22597b3bf5%3A0xfa4ccdb8e0446c1f!2z0YPQuy4g0JTQtdGB0L3Rj9C90YHQutCw0Y8sIDE5LCDQmtC40LXQsiwgMDIwMDA!5e0!3m2!1sru!2sua!4v1583312765292!5m2!1sru!2sua" width="400" height="400" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
				

			</div>
			<div class="col-lg-4 col-md-12 contacts_main">
				<h3>КОНТАКТЫ</h3>
				<hr>

					<div class="row contacts">
						<div class="col-2">
							<i class="fas fa-envelope"></i>
						</div>
						<div class="col-10">
							<p>ОТПРАВИТЬ СООБЩЕНИЕ</p>
							<p class="trd_p popmake-171"  class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="info@companyname.com"><?php the_field('mail' , 19);?></p>
						</div>
					</div>

					<div class="row contacts">
								<div class="col-2">
									<i class="fas fa-phone-alt"></i>
								</div>
								<div class="col-10">
									<p>НОМЕР ТЕЛЕФОНА</p>
									<a href="tel:<?php the_field('phone' , 19);?>"><p class="trd_p"><?php the_field('phone' , 19);?></p></a>
									<a href="tel:<?php the_field('phone2' , 19);?>"><p class="trd_p"><?php the_field('phone2' , 19);?></p></a>
								</div>
							
					</div>
					
					<div class="row contacts">
								<div class="col-2">
								<i class="fas fa-map-marker-alt"></i>
								</div>
								<div id="kart" class="col-10">
									<p>Адрес</p>
									<p id="ad1" class="trd_p"><?php the_field('adress1' , 19);?></p>
									<p id="ad2" class="trd_p"><?php the_field('adress2' , 19);?></p>
									<p id="ad3" class="trd_p"><?php the_field('adress3' , 19);?></p>
								</div>
							
					</div>

				<?php
					echo do_shortcode('[contact-form-7 id="161" title="Подписка на акции"]');
				?>

			</div>
		</div>

		<div class="pp">
			<a href="privacy-policy" target="_blank">Политика конфиденциальности</a>
		</div>


	</div>
	
</section>
<?php
  wp_footer();
?>