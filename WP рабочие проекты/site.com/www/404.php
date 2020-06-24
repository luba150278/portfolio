<?php
	get_header();
?>

<div class="container">
  <h2 class="subtitle">
    <a class="empty_adrees" href="<?php echo get_home_url(); ?>"> 
    Такая страница на сайте отсутствует. Перейти на главную страницу?
    </a>
  </h2>
  <a href="<?php echo get_home_url(); ?>"><img src="<?php echo bloginfo("template_url"); ?>/assets/img/404.png" alt="Страница 404"></a>
</div>
<?php
	get_footer();
?>