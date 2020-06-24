<footer>
			<div class="container">	
						<div class="social">
							<h2 data-aos="fade-left"><?php the_field('socseti',87);?></h2>
							<hr>
							<div id="social_fab">
								<a data-aos="flip-left" class="fab" target="_blank" href="#">	<i class="fab fa-facebook-square"></i> </a>
								<a data-aos="flip-right" class="fab" target="_blank" href="#"> <i class="fab fa-instagram"></i> </a>
								<a data-aos="flip-left" class="fab" target="_blank" href="#"> <i class="fab fa-telegram"></i> </a>
							</div>
						</div>					
			</div>
		</footer>
		</body>
</html>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-168424352-1"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-168424352-1');
</script>
<?php
  wp_footer();
?>