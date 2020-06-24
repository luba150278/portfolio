-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Июн 03 2020 г., 16:49
-- Версия сервера: 5.7.15
-- Версия PHP: 7.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `phpmyadmin`
--

-- --------------------------------------------------------

--
-- Структура таблицы `pma__bookmark`
--

CREATE TABLE `pma__bookmark` (
  `id` int(11) NOT NULL,
  `dbase` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Bookmarks';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__central_columns`
--

CREATE TABLE `pma__central_columns` (
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `col_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `col_type` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `col_length` text COLLATE utf8_general_ci,
  `col_collation` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `col_isNull` tinyint(1) NOT NULL,
  `col_extra` varchar(255) COLLATE utf8_general_ci DEFAULT '',
  `col_default` text COLLATE utf8_general_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Central list of columns';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__column_info`
--

CREATE TABLE `pma__column_info` (
  `id` int(5) UNSIGNED NOT NULL,
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `input_transformation` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `input_transformation_options` varchar(255) COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Column information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__designer_settings`
--

CREATE TABLE `pma__designer_settings` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `settings_data` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Settings related to Designer';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__export_templates`
--

CREATE TABLE `pma__export_templates` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `export_type` varchar(10) COLLATE utf8_general_ci NOT NULL,
  `template_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `template_data` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Saved export templates';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__favorite`
--

CREATE TABLE `pma__favorite` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `tables` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Favorite tables';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__history`
--

CREATE TABLE `pma__history` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='SQL history for phpMyAdmin';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__navigationhiding`
--

CREATE TABLE `pma__navigationhiding` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `item_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `item_type` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Hidden items of navigation tree';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__pdf_pages`
--

CREATE TABLE `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `page_nr` int(10) UNSIGNED NOT NULL,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='PDF relation pages for phpMyAdmin';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__recent`
--

CREATE TABLE `pma__recent` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `tables` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Recently accessed tables';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__relation`
--

CREATE TABLE `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__savedsearches`
--

CREATE TABLE `pma__savedsearches` (
  `id` int(5) UNSIGNED NOT NULL,
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `search_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `search_data` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Saved searches';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__table_coords`
--

CREATE TABLE `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float UNSIGNED NOT NULL DEFAULT '0',
  `y` float UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__table_info`
--

CREATE TABLE `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_general_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__table_uiprefs`
--

CREATE TABLE `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `prefs` text COLLATE utf8_general_ci NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__tracking`
--

CREATE TABLE `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `table_name` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `version` int(10) UNSIGNED NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_general_ci NOT NULL,
  `schema_sql` text COLLATE utf8_general_ci,
  `data_sql` longtext COLLATE utf8_general_ci,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_general_ci DEFAULT NULL,
  `tracking_active` int(1) UNSIGNED NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__userconfig`
--

CREATE TABLE `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='User preferences storage for phpMyAdmin';

--
-- Дамп данных таблицы `pma__userconfig`
--

INSERT INTO `pma__userconfig` (`username`, `timevalue`, `config_data`) VALUES
('root', '2020-06-03 16:43:45', '{"Export\\/charset":"utf-8","Server\\/hide_db":"","Server\\/only_db":"","lang":"ru","collation_connection":"utf8mb4_unicode_ci"}');

-- --------------------------------------------------------

--
-- Структура таблицы `pma__usergroups`
--

CREATE TABLE `pma__usergroups` (
  `usergroup` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `tab` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `allowed` enum('Y','N') COLLATE utf8_general_ci NOT NULL DEFAULT 'N'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='User groups with configured menu items';

-- --------------------------------------------------------

--
-- Структура таблицы `pma__users`
--

CREATE TABLE `pma__users` (
  `username` varchar(64) COLLATE utf8_general_ci NOT NULL,
  `usergroup` varchar(64) COLLATE utf8_general_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci COMMENT='Users and their assignments to user groups';

-- --------------------------------------------------------

--
-- Структура таблицы `wp_commentmeta`
--

CREATE TABLE `wp_commentmeta` (
  `meta_id` bigint(20) UNSIGNED NOT NULL,
  `comment_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `meta_key` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `meta_value` longtext COLLATE utf8mb4_unicode_520_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `wp_comments`
--

CREATE TABLE `wp_comments` (
  `comment_ID` bigint(20) UNSIGNED NOT NULL,
  `comment_post_ID` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `comment_author` tinytext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `comment_author_email` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_author_url` varchar(200) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_author_IP` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `comment_date_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `comment_content` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `comment_karma` int(11) NOT NULL DEFAULT '0',
  `comment_approved` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '1',
  `comment_agent` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_type` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_parent` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `user_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_comments`
--

INSERT INTO `wp_comments` (`comment_ID`, `comment_post_ID`, `comment_author`, `comment_author_email`, `comment_author_url`, `comment_author_IP`, `comment_date`, `comment_date_gmt`, `comment_content`, `comment_karma`, `comment_approved`, `comment_agent`, `comment_type`, `comment_parent`, `user_id`) VALUES
(1, 1, 'Коментатор WordPress', 'wapuu@wordpress.example', 'https://wordpress.org/', '', '2020-06-02 10:53:20', '2020-06-02 07:53:20', 'Привіт! Це коментар.\nЩоб почати модерувати, редагувати і видаляти коментарі, перейдіть в розділ Коментарів у Майстерні.\nАватари авторів коментарів завантажуються з сервісу<a href="https://uk.gravatar.com">Gravatar</a>.', 0, '1', '', '', 0, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `wp_links`
--

CREATE TABLE `wp_links` (
  `link_id` bigint(20) UNSIGNED NOT NULL,
  `link_url` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_name` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_image` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_target` varchar(25) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_description` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_visible` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'Y',
  `link_owner` bigint(20) UNSIGNED NOT NULL DEFAULT '1',
  `link_rating` int(11) NOT NULL DEFAULT '0',
  `link_updated` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `link_rel` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `link_notes` mediumtext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `link_rss` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `wp_options`
--

CREATE TABLE `wp_options` (
  `option_id` bigint(20) UNSIGNED NOT NULL,
  `option_name` varchar(191) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `option_value` longtext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `autoload` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'yes'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_options`
--

INSERT INTO `wp_options` (`option_id`, `option_name`, `option_value`, `autoload`) VALUES
(1, 'siteurl', 'http://algfond.com', 'yes'),
(2, 'home', 'http://algfond.com', 'yes'),
(3, 'blogname', 'Азербайджанский культурно-общественный центр', 'yes'),
(4, 'blogdescription', 'Азербайджанский культурно-общественный центр Луганской области. События, контакты, партнеры ', 'yes'),
(5, 'users_can_register', '0', 'yes'),
(6, 'admin_email', 'luba150278@gmail.com', 'yes'),
(7, 'start_of_week', '1', 'yes'),
(8, 'use_balanceTags', '0', 'yes'),
(9, 'use_smilies', '1', 'yes'),
(10, 'require_name_email', '1', 'yes'),
(11, 'comments_notify', '1', 'yes'),
(12, 'posts_per_rss', '10', 'yes'),
(13, 'rss_use_excerpt', '0', 'yes'),
(14, 'mailserver_url', 'mail.example.com', 'yes'),
(15, 'mailserver_login', 'login@example.com', 'yes'),
(16, 'mailserver_pass', 'password', 'yes'),
(17, 'mailserver_port', '110', 'yes'),
(18, 'default_category', '1', 'yes'),
(19, 'default_comment_status', 'open', 'yes'),
(20, 'default_ping_status', 'open', 'yes'),
(21, 'default_pingback_flag', '1', 'yes'),
(22, 'posts_per_page', '10', 'yes'),
(23, 'date_format', 'd.m.Y', 'yes'),
(24, 'time_format', 'H:i', 'yes'),
(25, 'links_updated_date_format', 'd.m.Y H:i', 'yes'),
(26, 'comment_moderation', '0', 'yes'),
(27, 'moderation_notify', '1', 'yes'),
(28, 'permalink_structure', '/%category%/%postname%/', 'yes'),
(29, 'rewrite_rules', 'a:95:{s:11:"^wp-json/?$";s:22:"index.php?rest_route=/";s:14:"^wp-json/(.*)?";s:33:"index.php?rest_route=/$matches[1]";s:21:"^index.php/wp-json/?$";s:22:"index.php?rest_route=/";s:24:"^index.php/wp-json/(.*)?";s:33:"index.php?rest_route=/$matches[1]";s:47:"category/(.+?)/feed/(feed|rdf|rss|rss2|atom)/?$";s:52:"index.php?category_name=$matches[1]&feed=$matches[2]";s:42:"category/(.+?)/(feed|rdf|rss|rss2|atom)/?$";s:52:"index.php?category_name=$matches[1]&feed=$matches[2]";s:23:"category/(.+?)/embed/?$";s:46:"index.php?category_name=$matches[1]&embed=true";s:35:"category/(.+?)/page/?([0-9]{1,})/?$";s:53:"index.php?category_name=$matches[1]&paged=$matches[2]";s:17:"category/(.+?)/?$";s:35:"index.php?category_name=$matches[1]";s:44:"tag/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:42:"index.php?tag=$matches[1]&feed=$matches[2]";s:39:"tag/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:42:"index.php?tag=$matches[1]&feed=$matches[2]";s:20:"tag/([^/]+)/embed/?$";s:36:"index.php?tag=$matches[1]&embed=true";s:32:"tag/([^/]+)/page/?([0-9]{1,})/?$";s:43:"index.php?tag=$matches[1]&paged=$matches[2]";s:14:"tag/([^/]+)/?$";s:25:"index.php?tag=$matches[1]";s:45:"type/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:50:"index.php?post_format=$matches[1]&feed=$matches[2]";s:40:"type/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:50:"index.php?post_format=$matches[1]&feed=$matches[2]";s:21:"type/([^/]+)/embed/?$";s:44:"index.php?post_format=$matches[1]&embed=true";s:33:"type/([^/]+)/page/?([0-9]{1,})/?$";s:51:"index.php?post_format=$matches[1]&paged=$matches[2]";s:15:"type/([^/]+)/?$";s:33:"index.php?post_format=$matches[1]";s:12:"robots\\.txt$";s:18:"index.php?robots=1";s:13:"favicon\\.ico$";s:19:"index.php?favicon=1";s:48:".*wp-(atom|rdf|rss|rss2|feed|commentsrss2)\\.php$";s:18:"index.php?feed=old";s:20:".*wp-app\\.php(/.*)?$";s:19:"index.php?error=403";s:18:".*wp-register.php$";s:23:"index.php?register=true";s:32:"feed/(feed|rdf|rss|rss2|atom)/?$";s:27:"index.php?&feed=$matches[1]";s:27:"(feed|rdf|rss|rss2|atom)/?$";s:27:"index.php?&feed=$matches[1]";s:8:"embed/?$";s:21:"index.php?&embed=true";s:20:"page/?([0-9]{1,})/?$";s:28:"index.php?&paged=$matches[1]";s:27:"comment-page-([0-9]{1,})/?$";s:38:"index.php?&page_id=2&cpage=$matches[1]";s:41:"comments/feed/(feed|rdf|rss|rss2|atom)/?$";s:42:"index.php?&feed=$matches[1]&withcomments=1";s:36:"comments/(feed|rdf|rss|rss2|atom)/?$";s:42:"index.php?&feed=$matches[1]&withcomments=1";s:17:"comments/embed/?$";s:21:"index.php?&embed=true";s:44:"search/(.+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:40:"index.php?s=$matches[1]&feed=$matches[2]";s:39:"search/(.+)/(feed|rdf|rss|rss2|atom)/?$";s:40:"index.php?s=$matches[1]&feed=$matches[2]";s:20:"search/(.+)/embed/?$";s:34:"index.php?s=$matches[1]&embed=true";s:32:"search/(.+)/page/?([0-9]{1,})/?$";s:41:"index.php?s=$matches[1]&paged=$matches[2]";s:14:"search/(.+)/?$";s:23:"index.php?s=$matches[1]";s:47:"author/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:50:"index.php?author_name=$matches[1]&feed=$matches[2]";s:42:"author/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:50:"index.php?author_name=$matches[1]&feed=$matches[2]";s:23:"author/([^/]+)/embed/?$";s:44:"index.php?author_name=$matches[1]&embed=true";s:35:"author/([^/]+)/page/?([0-9]{1,})/?$";s:51:"index.php?author_name=$matches[1]&paged=$matches[2]";s:17:"author/([^/]+)/?$";s:33:"index.php?author_name=$matches[1]";s:69:"([0-9]{4})/([0-9]{1,2})/([0-9]{1,2})/feed/(feed|rdf|rss|rss2|atom)/?$";s:80:"index.php?year=$matches[1]&monthnum=$matches[2]&day=$matches[3]&feed=$matches[4]";s:64:"([0-9]{4})/([0-9]{1,2})/([0-9]{1,2})/(feed|rdf|rss|rss2|atom)/?$";s:80:"index.php?year=$matches[1]&monthnum=$matches[2]&day=$matches[3]&feed=$matches[4]";s:45:"([0-9]{4})/([0-9]{1,2})/([0-9]{1,2})/embed/?$";s:74:"index.php?year=$matches[1]&monthnum=$matches[2]&day=$matches[3]&embed=true";s:57:"([0-9]{4})/([0-9]{1,2})/([0-9]{1,2})/page/?([0-9]{1,})/?$";s:81:"index.php?year=$matches[1]&monthnum=$matches[2]&day=$matches[3]&paged=$matches[4]";s:39:"([0-9]{4})/([0-9]{1,2})/([0-9]{1,2})/?$";s:63:"index.php?year=$matches[1]&monthnum=$matches[2]&day=$matches[3]";s:56:"([0-9]{4})/([0-9]{1,2})/feed/(feed|rdf|rss|rss2|atom)/?$";s:64:"index.php?year=$matches[1]&monthnum=$matches[2]&feed=$matches[3]";s:51:"([0-9]{4})/([0-9]{1,2})/(feed|rdf|rss|rss2|atom)/?$";s:64:"index.php?year=$matches[1]&monthnum=$matches[2]&feed=$matches[3]";s:32:"([0-9]{4})/([0-9]{1,2})/embed/?$";s:58:"index.php?year=$matches[1]&monthnum=$matches[2]&embed=true";s:44:"([0-9]{4})/([0-9]{1,2})/page/?([0-9]{1,})/?$";s:65:"index.php?year=$matches[1]&monthnum=$matches[2]&paged=$matches[3]";s:26:"([0-9]{4})/([0-9]{1,2})/?$";s:47:"index.php?year=$matches[1]&monthnum=$matches[2]";s:43:"([0-9]{4})/feed/(feed|rdf|rss|rss2|atom)/?$";s:43:"index.php?year=$matches[1]&feed=$matches[2]";s:38:"([0-9]{4})/(feed|rdf|rss|rss2|atom)/?$";s:43:"index.php?year=$matches[1]&feed=$matches[2]";s:19:"([0-9]{4})/embed/?$";s:37:"index.php?year=$matches[1]&embed=true";s:31:"([0-9]{4})/page/?([0-9]{1,})/?$";s:44:"index.php?year=$matches[1]&paged=$matches[2]";s:13:"([0-9]{4})/?$";s:26:"index.php?year=$matches[1]";s:27:".?.+?/attachment/([^/]+)/?$";s:32:"index.php?attachment=$matches[1]";s:37:".?.+?/attachment/([^/]+)/trackback/?$";s:37:"index.php?attachment=$matches[1]&tb=1";s:57:".?.+?/attachment/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:52:".?.+?/attachment/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:52:".?.+?/attachment/([^/]+)/comment-page-([0-9]{1,})/?$";s:50:"index.php?attachment=$matches[1]&cpage=$matches[2]";s:33:".?.+?/attachment/([^/]+)/embed/?$";s:43:"index.php?attachment=$matches[1]&embed=true";s:16:"(.?.+?)/embed/?$";s:41:"index.php?pagename=$matches[1]&embed=true";s:20:"(.?.+?)/trackback/?$";s:35:"index.php?pagename=$matches[1]&tb=1";s:40:"(.?.+?)/feed/(feed|rdf|rss|rss2|atom)/?$";s:47:"index.php?pagename=$matches[1]&feed=$matches[2]";s:35:"(.?.+?)/(feed|rdf|rss|rss2|atom)/?$";s:47:"index.php?pagename=$matches[1]&feed=$matches[2]";s:28:"(.?.+?)/page/?([0-9]{1,})/?$";s:48:"index.php?pagename=$matches[1]&paged=$matches[2]";s:35:"(.?.+?)/comment-page-([0-9]{1,})/?$";s:48:"index.php?pagename=$matches[1]&cpage=$matches[2]";s:24:"(.?.+?)(?:/([0-9]+))?/?$";s:47:"index.php?pagename=$matches[1]&page=$matches[2]";s:31:".+?/[^/]+/attachment/([^/]+)/?$";s:32:"index.php?attachment=$matches[1]";s:41:".+?/[^/]+/attachment/([^/]+)/trackback/?$";s:37:"index.php?attachment=$matches[1]&tb=1";s:61:".+?/[^/]+/attachment/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:56:".+?/[^/]+/attachment/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:56:".+?/[^/]+/attachment/([^/]+)/comment-page-([0-9]{1,})/?$";s:50:"index.php?attachment=$matches[1]&cpage=$matches[2]";s:37:".+?/[^/]+/attachment/([^/]+)/embed/?$";s:43:"index.php?attachment=$matches[1]&embed=true";s:22:"(.+?)/([^/]+)/embed/?$";s:63:"index.php?category_name=$matches[1]&name=$matches[2]&embed=true";s:26:"(.+?)/([^/]+)/trackback/?$";s:57:"index.php?category_name=$matches[1]&name=$matches[2]&tb=1";s:46:"(.+?)/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:69:"index.php?category_name=$matches[1]&name=$matches[2]&feed=$matches[3]";s:41:"(.+?)/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:69:"index.php?category_name=$matches[1]&name=$matches[2]&feed=$matches[3]";s:34:"(.+?)/([^/]+)/page/?([0-9]{1,})/?$";s:70:"index.php?category_name=$matches[1]&name=$matches[2]&paged=$matches[3]";s:41:"(.+?)/([^/]+)/comment-page-([0-9]{1,})/?$";s:70:"index.php?category_name=$matches[1]&name=$matches[2]&cpage=$matches[3]";s:30:"(.+?)/([^/]+)(?:/([0-9]+))?/?$";s:69:"index.php?category_name=$matches[1]&name=$matches[2]&page=$matches[3]";s:20:".+?/[^/]+/([^/]+)/?$";s:32:"index.php?attachment=$matches[1]";s:30:".+?/[^/]+/([^/]+)/trackback/?$";s:37:"index.php?attachment=$matches[1]&tb=1";s:50:".+?/[^/]+/([^/]+)/feed/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:45:".+?/[^/]+/([^/]+)/(feed|rdf|rss|rss2|atom)/?$";s:49:"index.php?attachment=$matches[1]&feed=$matches[2]";s:45:".+?/[^/]+/([^/]+)/comment-page-([0-9]{1,})/?$";s:50:"index.php?attachment=$matches[1]&cpage=$matches[2]";s:26:".+?/[^/]+/([^/]+)/embed/?$";s:43:"index.php?attachment=$matches[1]&embed=true";s:38:"(.+?)/feed/(feed|rdf|rss|rss2|atom)/?$";s:52:"index.php?category_name=$matches[1]&feed=$matches[2]";s:33:"(.+?)/(feed|rdf|rss|rss2|atom)/?$";s:52:"index.php?category_name=$matches[1]&feed=$matches[2]";s:14:"(.+?)/embed/?$";s:46:"index.php?category_name=$matches[1]&embed=true";s:26:"(.+?)/page/?([0-9]{1,})/?$";s:53:"index.php?category_name=$matches[1]&paged=$matches[2]";s:33:"(.+?)/comment-page-([0-9]{1,})/?$";s:53:"index.php?category_name=$matches[1]&cpage=$matches[2]";s:8:"(.+?)/?$";s:35:"index.php?category_name=$matches[1]";}', 'yes'),
(30, 'hack_file', '0', 'yes'),
(31, 'blog_charset', 'UTF-8', 'yes'),
(32, 'moderation_keys', '', 'no'),
(33, 'active_plugins', 'a:2:{i:0;s:30:"advanced-custom-fields/acf.php";i:1;s:22:"cyr2lat/cyr-to-lat.php";}', 'yes'),
(34, 'category_base', '', 'yes'),
(35, 'ping_sites', 'http://rpc.pingomatic.com/', 'yes'),
(36, 'comment_max_links', '2', 'yes'),
(37, 'gmt_offset', '', 'yes'),
(38, 'default_email_category', '1', 'yes'),
(39, 'recently_edited', '', 'no'),
(40, 'template', 'azeri', 'yes'),
(41, 'stylesheet', 'azeri', 'yes'),
(42, 'comment_whitelist', '1', 'yes'),
(43, 'blacklist_keys', '', 'no'),
(44, 'comment_registration', '0', 'yes'),
(45, 'html_type', 'text/html', 'yes'),
(46, 'use_trackback', '0', 'yes'),
(47, 'default_role', 'subscriber', 'yes'),
(48, 'db_version', '47018', 'yes'),
(49, 'uploads_use_yearmonth_folders', '1', 'yes'),
(50, 'upload_path', '', 'yes'),
(51, 'blog_public', '1', 'yes'),
(52, 'default_link_category', '2', 'yes'),
(53, 'show_on_front', 'page', 'yes'),
(54, 'tag_base', '', 'yes'),
(55, 'show_avatars', '1', 'yes'),
(56, 'avatar_rating', 'G', 'yes'),
(57, 'upload_url_path', '', 'yes'),
(58, 'thumbnail_size_w', '150', 'yes'),
(59, 'thumbnail_size_h', '150', 'yes'),
(60, 'thumbnail_crop', '1', 'yes'),
(61, 'medium_size_w', '300', 'yes'),
(62, 'medium_size_h', '300', 'yes'),
(63, 'avatar_default', 'mystery', 'yes'),
(64, 'large_size_w', '1024', 'yes'),
(65, 'large_size_h', '1024', 'yes'),
(66, 'image_default_link_type', 'none', 'yes'),
(67, 'image_default_size', '', 'yes'),
(68, 'image_default_align', '', 'yes'),
(69, 'close_comments_for_old_posts', '0', 'yes'),
(70, 'close_comments_days_old', '14', 'yes'),
(71, 'thread_comments', '1', 'yes'),
(72, 'thread_comments_depth', '5', 'yes'),
(73, 'page_comments', '0', 'yes'),
(74, 'comments_per_page', '50', 'yes'),
(75, 'default_comments_page', 'newest', 'yes'),
(76, 'comment_order', 'asc', 'yes'),
(77, 'sticky_posts', 'a:0:{}', 'yes'),
(78, 'widget_categories', 'a:2:{i:2;a:4:{s:5:"title";s:0:"";s:5:"count";i:0;s:12:"hierarchical";i:0;s:8:"dropdown";i:0;}s:12:"_multiwidget";i:1;}', 'yes'),
(79, 'widget_text', 'a:2:{i:1;a:0:{}s:12:"_multiwidget";i:1;}', 'yes'),
(80, 'widget_rss', 'a:2:{i:1;a:0:{}s:12:"_multiwidget";i:1;}', 'yes'),
(81, 'uninstall_plugins', 'a:0:{}', 'no'),
(82, 'timezone_string', 'Europe/Kiev', 'yes'),
(83, 'page_for_posts', '0', 'yes'),
(84, 'page_on_front', '2', 'yes'),
(85, 'default_post_format', '0', 'yes'),
(86, 'link_manager_enabled', '0', 'yes'),
(87, 'finished_splitting_shared_terms', '1', 'yes'),
(88, 'site_icon', '8', 'yes'),
(89, 'medium_large_size_w', '768', 'yes'),
(90, 'medium_large_size_h', '0', 'yes'),
(91, 'wp_page_for_privacy_policy', '3', 'yes'),
(92, 'show_comments_cookies_opt_in', '1', 'yes'),
(93, 'admin_email_lifespan', '1606636399', 'yes'),
(94, 'initial_db_version', '45805', 'yes'),
(95, 'wp_user_roles', 'a:5:{s:13:"administrator";a:2:{s:4:"name";s:13:"Administrator";s:12:"capabilities";a:61:{s:13:"switch_themes";b:1;s:11:"edit_themes";b:1;s:16:"activate_plugins";b:1;s:12:"edit_plugins";b:1;s:10:"edit_users";b:1;s:10:"edit_files";b:1;s:14:"manage_options";b:1;s:17:"moderate_comments";b:1;s:17:"manage_categories";b:1;s:12:"manage_links";b:1;s:12:"upload_files";b:1;s:6:"import";b:1;s:15:"unfiltered_html";b:1;s:10:"edit_posts";b:1;s:17:"edit_others_posts";b:1;s:20:"edit_published_posts";b:1;s:13:"publish_posts";b:1;s:10:"edit_pages";b:1;s:4:"read";b:1;s:8:"level_10";b:1;s:7:"level_9";b:1;s:7:"level_8";b:1;s:7:"level_7";b:1;s:7:"level_6";b:1;s:7:"level_5";b:1;s:7:"level_4";b:1;s:7:"level_3";b:1;s:7:"level_2";b:1;s:7:"level_1";b:1;s:7:"level_0";b:1;s:17:"edit_others_pages";b:1;s:20:"edit_published_pages";b:1;s:13:"publish_pages";b:1;s:12:"delete_pages";b:1;s:19:"delete_others_pages";b:1;s:22:"delete_published_pages";b:1;s:12:"delete_posts";b:1;s:19:"delete_others_posts";b:1;s:22:"delete_published_posts";b:1;s:20:"delete_private_posts";b:1;s:18:"edit_private_posts";b:1;s:18:"read_private_posts";b:1;s:20:"delete_private_pages";b:1;s:18:"edit_private_pages";b:1;s:18:"read_private_pages";b:1;s:12:"delete_users";b:1;s:12:"create_users";b:1;s:17:"unfiltered_upload";b:1;s:14:"edit_dashboard";b:1;s:14:"update_plugins";b:1;s:14:"delete_plugins";b:1;s:15:"install_plugins";b:1;s:13:"update_themes";b:1;s:14:"install_themes";b:1;s:11:"update_core";b:1;s:10:"list_users";b:1;s:12:"remove_users";b:1;s:13:"promote_users";b:1;s:18:"edit_theme_options";b:1;s:13:"delete_themes";b:1;s:6:"export";b:1;}}s:6:"editor";a:2:{s:4:"name";s:6:"Editor";s:12:"capabilities";a:34:{s:17:"moderate_comments";b:1;s:17:"manage_categories";b:1;s:12:"manage_links";b:1;s:12:"upload_files";b:1;s:15:"unfiltered_html";b:1;s:10:"edit_posts";b:1;s:17:"edit_others_posts";b:1;s:20:"edit_published_posts";b:1;s:13:"publish_posts";b:1;s:10:"edit_pages";b:1;s:4:"read";b:1;s:7:"level_7";b:1;s:7:"level_6";b:1;s:7:"level_5";b:1;s:7:"level_4";b:1;s:7:"level_3";b:1;s:7:"level_2";b:1;s:7:"level_1";b:1;s:7:"level_0";b:1;s:17:"edit_others_pages";b:1;s:20:"edit_published_pages";b:1;s:13:"publish_pages";b:1;s:12:"delete_pages";b:1;s:19:"delete_others_pages";b:1;s:22:"delete_published_pages";b:1;s:12:"delete_posts";b:1;s:19:"delete_others_posts";b:1;s:22:"delete_published_posts";b:1;s:20:"delete_private_posts";b:1;s:18:"edit_private_posts";b:1;s:18:"read_private_posts";b:1;s:20:"delete_private_pages";b:1;s:18:"edit_private_pages";b:1;s:18:"read_private_pages";b:1;}}s:6:"author";a:2:{s:4:"name";s:6:"Author";s:12:"capabilities";a:10:{s:12:"upload_files";b:1;s:10:"edit_posts";b:1;s:20:"edit_published_posts";b:1;s:13:"publish_posts";b:1;s:4:"read";b:1;s:7:"level_2";b:1;s:7:"level_1";b:1;s:7:"level_0";b:1;s:12:"delete_posts";b:1;s:22:"delete_published_posts";b:1;}}s:11:"contributor";a:2:{s:4:"name";s:11:"Contributor";s:12:"capabilities";a:5:{s:10:"edit_posts";b:1;s:4:"read";b:1;s:7:"level_1";b:1;s:7:"level_0";b:1;s:12:"delete_posts";b:1;}}s:10:"subscriber";a:2:{s:4:"name";s:10:"Subscriber";s:12:"capabilities";a:2:{s:4:"read";b:1;s:7:"level_0";b:1;}}}', 'yes'),
(96, 'fresh_site', '0', 'yes'),
(97, 'WPLANG', 'ru_RU', 'yes'),
(98, 'widget_search', 'a:2:{i:2;a:1:{s:5:"title";s:0:"";}s:12:"_multiwidget";i:1;}', 'yes'),
(99, 'widget_recent-posts', 'a:2:{i:2;a:2:{s:5:"title";s:0:"";s:6:"number";i:5;}s:12:"_multiwidget";i:1;}', 'yes'),
(100, 'widget_recent-comments', 'a:2:{i:2;a:2:{s:5:"title";s:0:"";s:6:"number";i:5;}s:12:"_multiwidget";i:1;}', 'yes'),
(101, 'widget_archives', 'a:2:{i:2;a:3:{s:5:"title";s:0:"";s:5:"count";i:0;s:8:"dropdown";i:0;}s:12:"_multiwidget";i:1;}', 'yes'),
(102, 'widget_meta', 'a:2:{i:2;a:1:{s:5:"title";s:0:"";}s:12:"_multiwidget";i:1;}', 'yes'),
(103, 'sidebars_widgets', 'a:2:{s:19:"wp_inactive_widgets";a:6:{i:0;s:8:"search-2";i:1;s:14:"recent-posts-2";i:2;s:17:"recent-comments-2";i:3;s:10:"archives-2";i:4;s:12:"categories-2";i:5;s:6:"meta-2";}s:13:"array_version";i:3;}', 'yes'),
(104, 'cron', 'a:7:{i:1591203214;a:1:{s:34:"wp_privacy_delete_old_export_files";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:6:"hourly";s:4:"args";a:0:{}s:8:"interval";i:3600;}}}i:1591214014;a:3:{s:16:"wp_version_check";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:10:"twicedaily";s:4:"args";a:0:{}s:8:"interval";i:43200;}}s:17:"wp_update_plugins";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:10:"twicedaily";s:4:"args";a:0:{}s:8:"interval";i:43200;}}s:16:"wp_update_themes";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:10:"twicedaily";s:4:"args";a:0:{}s:8:"interval";i:43200;}}}i:1591257213;a:1:{s:32:"recovery_mode_clean_expired_keys";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:5:"daily";s:4:"args";a:0:{}s:8:"interval";i:86400;}}}i:1591257246;a:2:{s:19:"wp_scheduled_delete";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:5:"daily";s:4:"args";a:0:{}s:8:"interval";i:86400;}}s:25:"delete_expired_transients";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:5:"daily";s:4:"args";a:0:{}s:8:"interval";i:86400;}}}i:1591257249;a:1:{s:30:"wp_scheduled_auto_draft_delete";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:5:"daily";s:4:"args";a:0:{}s:8:"interval";i:86400;}}}i:1591778179;a:1:{s:30:"wp_site_health_scheduled_check";a:1:{s:32:"40cd750bba9870f18aada2478b24840a";a:3:{s:8:"schedule";s:6:"weekly";s:4:"args";a:0:{}s:8:"interval";i:604800;}}}s:7:"version";i:2;}', 'yes'),
(105, 'widget_pages', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(106, 'widget_calendar', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(107, 'widget_media_audio', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(108, 'widget_media_image', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(109, 'widget_media_gallery', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(110, 'widget_media_video', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(111, 'widget_tag_cloud', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(112, 'widget_nav_menu', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(113, 'widget_custom_html', 'a:1:{s:12:"_multiwidget";i:1;}', 'yes'),
(115, 'recovery_keys', 'a:0:{}', 'yes'),
(125, '_site_transient_timeout_browser_3159e548b459a213a1c6a2a1736ee626', '1591689248', 'no'),
(126, '_site_transient_browser_3159e548b459a213a1c6a2a1736ee626', 'a:10:{s:4:"name";s:6:"Chrome";s:7:"version";s:12:"83.0.4103.61";s:8:"platform";s:7:"Windows";s:10:"update_url";s:29:"https://www.google.com/chrome";s:7:"img_src";s:43:"http://s.w.org/images/browsers/chrome.png?1";s:11:"img_src_ssl";s:44:"https://s.w.org/images/browsers/chrome.png?1";s:15:"current_version";s:2:"18";s:7:"upgrade";b:0;s:8:"insecure";b:0;s:6:"mobile";b:0;}', 'no'),
(127, '_site_transient_timeout_php_check_5cc86f05623c0c7aed403ca34b000981', '1591689249', 'no'),
(128, '_site_transient_php_check_5cc86f05623c0c7aed403ca34b000981', 'a:5:{s:19:"recommended_version";s:3:"7.3";s:15:"minimum_version";s:6:"5.6.20";s:12:"is_supported";b:0;s:9:"is_secure";b:0;s:13:"is_acceptable";b:1;}', 'no'),
(142, 'theme_mods_twentytwenty', 'a:2:{s:18:"custom_css_post_id";i:-1;s:16:"sidebars_widgets";a:2:{s:4:"time";i:1591085785;s:4:"data";a:3:{s:19:"wp_inactive_widgets";a:0:{}s:9:"sidebar-1";a:3:{i:0;s:8:"search-2";i:1;s:14:"recent-posts-2";i:2;s:17:"recent-comments-2";}s:9:"sidebar-2";a:3:{i:0;s:10:"archives-2";i:1;s:12:"categories-2";i:2;s:6:"meta-2";}}}}', 'yes'),
(143, 'current_theme', 'Azeri', 'yes'),
(144, 'theme_mods_azeri', 'a:3:{i:0;b:0;s:18:"nav_menu_locations";a:0:{}s:18:"custom_css_post_id";i:-1;}', 'yes'),
(145, 'theme_switched', '', 'yes'),
(148, 'new_admin_email', 'luba150278@gmail.com', 'yes'),
(156, 'db_upgraded', '', 'yes'),
(161, 'can_compress_scripts', '1', 'no'),
(172, 'recently_activated', 'a:0:{}', 'yes'),
(187, 'acf_version', '5.8.11', 'yes'),
(207, '_transient_health-check-site-status-result', '{"good":11,"recommended":5,"critical":1}', 'yes'),
(213, 'category_children', 'a:0:{}', 'yes'),
(216, '_site_transient_timeout_poptags_40cd750bba9870f18aada2478b24840a', '1591204517', 'no'),
(217, '_site_transient_poptags_40cd750bba9870f18aada2478b24840a', 'O:8:"stdClass":100:{s:6:"widget";a:3:{s:4:"name";s:6:"widget";s:4:"slug";s:6:"widget";s:5:"count";i:4693;}s:11:"woocommerce";a:3:{s:4:"name";s:11:"woocommerce";s:4:"slug";s:11:"woocommerce";s:5:"count";i:4137;}s:4:"post";a:3:{s:4:"name";s:4:"post";s:4:"slug";s:4:"post";s:5:"count";i:2670;}s:5:"admin";a:3:{s:4:"name";s:5:"admin";s:4:"slug";s:5:"admin";s:5:"count";i:2555;}s:5:"posts";a:3:{s:4:"name";s:5:"posts";s:4:"slug";s:5:"posts";s:5:"count";i:1965;}s:9:"shortcode";a:3:{s:4:"name";s:9:"shortcode";s:4:"slug";s:9:"shortcode";s:5:"count";i:1808;}s:8:"comments";a:3:{s:4:"name";s:8:"comments";s:4:"slug";s:8:"comments";s:5:"count";i:1793;}s:7:"twitter";a:3:{s:4:"name";s:7:"twitter";s:4:"slug";s:7:"twitter";s:5:"count";i:1486;}s:6:"images";a:3:{s:4:"name";s:6:"images";s:4:"slug";s:6:"images";s:5:"count";i:1478;}s:6:"google";a:3:{s:4:"name";s:6:"google";s:4:"slug";s:6:"google";s:5:"count";i:1476;}s:8:"facebook";a:3:{s:4:"name";s:8:"facebook";s:4:"slug";s:8:"facebook";s:5:"count";i:1452;}s:5:"image";a:3:{s:4:"name";s:5:"image";s:4:"slug";s:5:"image";s:5:"count";i:1430;}s:3:"seo";a:3:{s:4:"name";s:3:"seo";s:4:"slug";s:3:"seo";s:5:"count";i:1419;}s:7:"sidebar";a:3:{s:4:"name";s:7:"sidebar";s:4:"slug";s:7:"sidebar";s:5:"count";i:1302;}s:5:"email";a:3:{s:4:"name";s:5:"email";s:4:"slug";s:5:"email";s:5:"count";i:1199;}s:7:"gallery";a:3:{s:4:"name";s:7:"gallery";s:4:"slug";s:7:"gallery";s:5:"count";i:1190;}s:4:"page";a:3:{s:4:"name";s:4:"page";s:4:"slug";s:4:"page";s:5:"count";i:1123;}s:9:"ecommerce";a:3:{s:4:"name";s:9:"ecommerce";s:4:"slug";s:9:"ecommerce";s:5:"count";i:1122;}s:6:"social";a:3:{s:4:"name";s:6:"social";s:4:"slug";s:6:"social";s:5:"count";i:1095;}s:5:"login";a:3:{s:4:"name";s:5:"login";s:4:"slug";s:5:"login";s:5:"count";i:991;}s:5:"video";a:3:{s:4:"name";s:5:"video";s:4:"slug";s:5:"video";s:5:"count";i:881;}s:7:"widgets";a:3:{s:4:"name";s:7:"widgets";s:4:"slug";s:7:"widgets";s:5:"count";i:875;}s:5:"links";a:3:{s:4:"name";s:5:"links";s:4:"slug";s:5:"links";s:5:"count";i:873;}s:8:"security";a:3:{s:4:"name";s:8:"security";s:4:"slug";s:8:"security";s:5:"count";i:868;}s:4:"spam";a:3:{s:4:"name";s:4:"spam";s:4:"slug";s:4:"spam";s:5:"count";i:792;}s:10:"e-commerce";a:3:{s:4:"name";s:10:"e-commerce";s:4:"slug";s:10:"e-commerce";s:5:"count";i:772;}s:7:"content";a:3:{s:4:"name";s:7:"content";s:4:"slug";s:7:"content";s:5:"count";i:770;}s:6:"slider";a:3:{s:4:"name";s:6:"slider";s:4:"slug";s:6:"slider";s:5:"count";i:769;}s:9:"analytics";a:3:{s:4:"name";s:9:"analytics";s:4:"slug";s:9:"analytics";s:5:"count";i:758;}s:10:"buddypress";a:3:{s:4:"name";s:10:"buddypress";s:4:"slug";s:10:"buddypress";s:5:"count";i:749;}s:4:"form";a:3:{s:4:"name";s:4:"form";s:4:"slug";s:4:"form";s:5:"count";i:724;}s:3:"rss";a:3:{s:4:"name";s:3:"rss";s:4:"slug";s:3:"rss";s:5:"count";i:717;}s:5:"media";a:3:{s:4:"name";s:5:"media";s:4:"slug";s:5:"media";s:5:"count";i:717;}s:5:"pages";a:3:{s:4:"name";s:5:"pages";s:4:"slug";s:5:"pages";s:5:"count";i:699;}s:6:"search";a:3:{s:4:"name";s:6:"search";s:4:"slug";s:6:"search";s:5:"count";i:690;}s:6:"jquery";a:3:{s:4:"name";s:6:"jquery";s:4:"slug";s:6:"jquery";s:5:"count";i:659;}s:4:"menu";a:3:{s:4:"name";s:4:"menu";s:4:"slug";s:4:"menu";s:5:"count";i:655;}s:6:"editor";a:3:{s:4:"name";s:6:"editor";s:4:"slug";s:6:"editor";s:5:"count";i:651;}s:4:"feed";a:3:{s:4:"name";s:4:"feed";s:4:"slug";s:4:"feed";s:5:"count";i:651;}s:8:"category";a:3:{s:4:"name";s:8:"category";s:4:"slug";s:8:"category";s:5:"count";i:645;}s:4:"ajax";a:3:{s:4:"name";s:4:"ajax";s:4:"slug";s:4:"ajax";s:5:"count";i:630;}s:5:"embed";a:3:{s:4:"name";s:5:"embed";s:4:"slug";s:5:"embed";s:5:"count";i:626;}s:12:"contact-form";a:3:{s:4:"name";s:12:"contact form";s:4:"slug";s:12:"contact-form";s:5:"count";i:592;}s:3:"css";a:3:{s:4:"name";s:3:"css";s:4:"slug";s:3:"css";s:5:"count";i:584;}s:10:"javascript";a:3:{s:4:"name";s:10:"javascript";s:4:"slug";s:10:"javascript";s:5:"count";i:578;}s:7:"youtube";a:3:{s:4:"name";s:7:"youtube";s:4:"slug";s:7:"youtube";s:5:"count";i:576;}s:4:"link";a:3:{s:4:"name";s:4:"link";s:4:"slug";s:4:"link";s:5:"count";i:573;}s:7:"payment";a:3:{s:4:"name";s:7:"payment";s:4:"slug";s:7:"payment";s:5:"count";i:572;}s:5:"share";a:3:{s:4:"name";s:5:"share";s:4:"slug";s:5:"share";s:5:"count";i:555;}s:5:"theme";a:3:{s:4:"name";s:5:"theme";s:4:"slug";s:5:"theme";s:5:"count";i:548;}s:7:"comment";a:3:{s:4:"name";s:7:"comment";s:4:"slug";s:7:"comment";s:5:"count";i:548;}s:9:"affiliate";a:3:{s:4:"name";s:9:"affiliate";s:4:"slug";s:9:"affiliate";s:5:"count";i:543;}s:10:"responsive";a:3:{s:4:"name";s:10:"responsive";s:4:"slug";s:10:"responsive";s:5:"count";i:538;}s:9:"dashboard";a:3:{s:4:"name";s:9:"dashboard";s:4:"slug";s:9:"dashboard";s:5:"count";i:536;}s:6:"custom";a:3:{s:4:"name";s:6:"custom";s:4:"slug";s:6:"custom";s:5:"count";i:529;}s:3:"ads";a:3:{s:4:"name";s:3:"ads";s:4:"slug";s:3:"ads";s:5:"count";i:523;}s:10:"categories";a:3:{s:4:"name";s:10:"categories";s:4:"slug";s:10:"categories";s:5:"count";i:517;}s:15:"payment-gateway";a:3:{s:4:"name";s:15:"payment gateway";s:4:"slug";s:15:"payment-gateway";s:5:"count";i:507;}s:3:"api";a:3:{s:4:"name";s:3:"api";s:4:"slug";s:3:"api";s:5:"count";i:506;}s:7:"contact";a:3:{s:4:"name";s:7:"contact";s:4:"slug";s:7:"contact";s:5:"count";i:503;}s:4:"user";a:3:{s:4:"name";s:4:"user";s:4:"slug";s:4:"user";s:5:"count";i:500;}s:9:"gutenberg";a:3:{s:4:"name";s:9:"gutenberg";s:4:"slug";s:9:"gutenberg";s:5:"count";i:496;}s:4:"tags";a:3:{s:4:"name";s:4:"tags";s:4:"slug";s:4:"tags";s:5:"count";i:493;}s:6:"button";a:3:{s:4:"name";s:6:"button";s:4:"slug";s:6:"button";s:5:"count";i:490;}s:6:"mobile";a:3:{s:4:"name";s:6:"mobile";s:4:"slug";s:6:"mobile";s:5:"count";i:477;}s:5:"users";a:3:{s:4:"name";s:5:"users";s:4:"slug";s:5:"users";s:5:"count";i:476;}s:6:"events";a:3:{s:4:"name";s:6:"events";s:4:"slug";s:6:"events";s:5:"count";i:468;}s:9:"marketing";a:3:{s:4:"name";s:9:"marketing";s:4:"slug";s:9:"marketing";s:5:"count";i:440;}s:4:"chat";a:3:{s:4:"name";s:4:"chat";s:4:"slug";s:4:"chat";s:5:"count";i:439;}s:5:"photo";a:3:{s:4:"name";s:5:"photo";s:4:"slug";s:5:"photo";s:5:"count";i:437;}s:10:"navigation";a:3:{s:4:"name";s:10:"navigation";s:4:"slug";s:10:"navigation";s:5:"count";i:433;}s:9:"slideshow";a:3:{s:4:"name";s:9:"slideshow";s:4:"slug";s:9:"slideshow";s:5:"count";i:428;}s:5:"popup";a:3:{s:4:"name";s:5:"popup";s:4:"slug";s:5:"popup";s:5:"count";i:426;}s:8:"calendar";a:3:{s:4:"name";s:8:"calendar";s:4:"slug";s:8:"calendar";s:5:"count";i:425;}s:5:"stats";a:3:{s:4:"name";s:5:"stats";s:4:"slug";s:5:"stats";s:5:"count";i:423;}s:6:"photos";a:3:{s:4:"name";s:6:"photos";s:4:"slug";s:6:"photos";s:5:"count";i:421;}s:10:"statistics";a:3:{s:4:"name";s:10:"statistics";s:4:"slug";s:10:"statistics";s:5:"count";i:408;}s:5:"forms";a:3:{s:4:"name";s:5:"forms";s:4:"slug";s:5:"forms";s:5:"count";i:407;}s:10:"newsletter";a:3:{s:4:"name";s:10:"newsletter";s:4:"slug";s:10:"newsletter";s:5:"count";i:407;}s:4:"news";a:3:{s:4:"name";s:4:"news";s:4:"slug";s:4:"news";s:5:"count";i:398;}s:10:"shortcodes";a:3:{s:4:"name";s:10:"shortcodes";s:4:"slug";s:10:"shortcodes";s:5:"count";i:397;}s:14:"contact-form-7";a:3:{s:4:"name";s:14:"contact form 7";s:4:"slug";s:14:"contact-form-7";s:5:"count";i:396;}s:12:"social-media";a:3:{s:4:"name";s:12:"social media";s:4:"slug";s:12:"social-media";s:5:"count";i:388;}s:8:"redirect";a:3:{s:4:"name";s:8:"redirect";s:4:"slug";s:8:"redirect";s:5:"count";i:386;}s:4:"code";a:3:{s:4:"name";s:4:"code";s:4:"slug";s:4:"code";s:5:"count";i:378;}s:7:"plugins";a:3:{s:4:"name";s:7:"plugins";s:4:"slug";s:7:"plugins";s:5:"count";i:377;}s:9:"multisite";a:3:{s:4:"name";s:9:"multisite";s:4:"slug";s:9:"multisite";s:5:"count";i:376;}s:11:"performance";a:3:{s:4:"name";s:11:"performance";s:4:"slug";s:11:"performance";s:5:"count";i:372;}s:3:"url";a:3:{s:4:"name";s:3:"url";s:4:"slug";s:3:"url";s:5:"count";i:370;}s:12:"notification";a:3:{s:4:"name";s:12:"notification";s:4:"slug";s:12:"notification";s:5:"count";i:364;}s:4:"meta";a:3:{s:4:"name";s:4:"meta";s:4:"slug";s:4:"meta";s:5:"count";i:360;}s:4:"list";a:3:{s:4:"name";s:4:"list";s:4:"slug";s:4:"list";s:5:"count";i:358;}s:5:"block";a:3:{s:4:"name";s:5:"block";s:4:"slug";s:5:"block";s:5:"count";i:356;}s:9:"elementor";a:3:{s:4:"name";s:9:"elementor";s:4:"slug";s:9:"elementor";s:5:"count";i:353;}s:8:"shipping";a:3:{s:4:"name";s:8:"shipping";s:4:"slug";s:8:"shipping";s:5:"count";i:350;}s:8:"tracking";a:3:{s:4:"name";s:8:"tracking";s:4:"slug";s:8:"tracking";s:5:"count";i:345;}s:16:"google-analytics";a:3:{s:4:"name";s:16:"google analytics";s:4:"slug";s:16:"google-analytics";s:5:"count";i:340;}s:16:"custom-post-type";a:3:{s:4:"name";s:16:"custom post type";s:4:"slug";s:16:"custom-post-type";s:5:"count";i:339;}s:11:"advertising";a:3:{s:4:"name";s:11:"advertising";s:4:"slug";s:11:"advertising";s:5:"count";i:336;}s:5:"cache";a:3:{s:4:"name";s:5:"cache";s:4:"slug";s:5:"cache";s:5:"count";i:335;}}', 'no'),
(219, '_site_transient_timeout_theme_roots', '1591195566', 'no'),
(220, '_site_transient_theme_roots', 'a:1:{s:5:"azeri";s:7:"/themes";}', 'no'),
(221, '_site_transient_update_core', 'O:8:"stdClass":4:{s:7:"updates";a:1:{i:0;O:8:"stdClass":10:{s:8:"response";s:6:"latest";s:8:"download";s:65:"https://downloads.wordpress.org/release/ru_RU/wordpress-5.4.1.zip";s:6:"locale";s:5:"ru_RU";s:8:"packages";O:8:"stdClass":5:{s:4:"full";s:65:"https://downloads.wordpress.org/release/ru_RU/wordpress-5.4.1.zip";s:10:"no_content";b:0;s:11:"new_bundled";b:0;s:7:"partial";b:0;s:8:"rollback";b:0;}s:7:"current";s:5:"5.4.1";s:7:"version";s:5:"5.4.1";s:11:"php_version";s:6:"5.6.20";s:13:"mysql_version";s:3:"5.0";s:11:"new_bundled";s:3:"5.3";s:15:"partial_version";s:0:"";}}s:12:"last_checked";i:1591193776;s:15:"version_checked";s:5:"5.4.1";s:12:"translations";a:0:{}}', 'no'),
(222, '_site_transient_update_plugins', 'O:8:"stdClass":5:{s:12:"last_checked";i:1591193777;s:7:"checked";a:4:{s:30:"advanced-custom-fields/acf.php";s:6:"5.8.11";s:19:"akismet/akismet.php";s:5:"4.1.3";s:22:"cyr2lat/cyr-to-lat.php";s:5:"4.5.0";s:9:"hello.php";s:5:"1.7.2";}s:8:"response";a:1:{s:19:"akismet/akismet.php";O:8:"stdClass":12:{s:2:"id";s:21:"w.org/plugins/akismet";s:4:"slug";s:7:"akismet";s:6:"plugin";s:19:"akismet/akismet.php";s:11:"new_version";s:5:"4.1.5";s:3:"url";s:38:"https://wordpress.org/plugins/akismet/";s:7:"package";s:56:"https://downloads.wordpress.org/plugin/akismet.4.1.5.zip";s:5:"icons";a:2:{s:2:"2x";s:59:"https://ps.w.org/akismet/assets/icon-256x256.png?rev=969272";s:2:"1x";s:59:"https://ps.w.org/akismet/assets/icon-128x128.png?rev=969272";}s:7:"banners";a:1:{s:2:"1x";s:61:"https://ps.w.org/akismet/assets/banner-772x250.jpg?rev=479904";}s:11:"banners_rtl";a:0:{}s:6:"tested";s:5:"5.4.1";s:12:"requires_php";b:0;s:13:"compatibility";O:8:"stdClass":0:{}}}s:12:"translations";a:0:{}s:9:"no_update";a:3:{s:30:"advanced-custom-fields/acf.php";O:8:"stdClass":9:{s:2:"id";s:36:"w.org/plugins/advanced-custom-fields";s:4:"slug";s:22:"advanced-custom-fields";s:6:"plugin";s:30:"advanced-custom-fields/acf.php";s:11:"new_version";s:6:"5.8.11";s:3:"url";s:53:"https://wordpress.org/plugins/advanced-custom-fields/";s:7:"package";s:72:"https://downloads.wordpress.org/plugin/advanced-custom-fields.5.8.11.zip";s:5:"icons";a:2:{s:2:"2x";s:75:"https://ps.w.org/advanced-custom-fields/assets/icon-256x256.png?rev=1082746";s:2:"1x";s:75:"https://ps.w.org/advanced-custom-fields/assets/icon-128x128.png?rev=1082746";}s:7:"banners";a:2:{s:2:"2x";s:78:"https://ps.w.org/advanced-custom-fields/assets/banner-1544x500.jpg?rev=1729099";s:2:"1x";s:77:"https://ps.w.org/advanced-custom-fields/assets/banner-772x250.jpg?rev=1729102";}s:11:"banners_rtl";a:0:{}}s:22:"cyr2lat/cyr-to-lat.php";O:8:"stdClass":9:{s:2:"id";s:21:"w.org/plugins/cyr2lat";s:4:"slug";s:7:"cyr2lat";s:6:"plugin";s:22:"cyr2lat/cyr-to-lat.php";s:11:"new_version";s:5:"4.5.0";s:3:"url";s:38:"https://wordpress.org/plugins/cyr2lat/";s:7:"package";s:56:"https://downloads.wordpress.org/plugin/cyr2lat.4.5.0.zip";s:5:"icons";a:3:{s:2:"2x";s:60:"https://ps.w.org/cyr2lat/assets/icon-256x256.jpg?rev=2022835";s:2:"1x";s:52:"https://ps.w.org/cyr2lat/assets/icon.svg?rev=2022835";s:3:"svg";s:52:"https://ps.w.org/cyr2lat/assets/icon.svg?rev=2022835";}s:7:"banners";a:2:{s:2:"2x";s:63:"https://ps.w.org/cyr2lat/assets/banner-1544x500.png?rev=2022835";s:2:"1x";s:62:"https://ps.w.org/cyr2lat/assets/banner-772x250.png?rev=2022835";}s:11:"banners_rtl";a:0:{}}s:9:"hello.php";O:8:"stdClass":9:{s:2:"id";s:25:"w.org/plugins/hello-dolly";s:4:"slug";s:11:"hello-dolly";s:6:"plugin";s:9:"hello.php";s:11:"new_version";s:5:"1.7.2";s:3:"url";s:42:"https://wordpress.org/plugins/hello-dolly/";s:7:"package";s:60:"https://downloads.wordpress.org/plugin/hello-dolly.1.7.2.zip";s:5:"icons";a:2:{s:2:"2x";s:64:"https://ps.w.org/hello-dolly/assets/icon-256x256.jpg?rev=2052855";s:2:"1x";s:64:"https://ps.w.org/hello-dolly/assets/icon-128x128.jpg?rev=2052855";}s:7:"banners";a:1:{s:2:"1x";s:66:"https://ps.w.org/hello-dolly/assets/banner-772x250.jpg?rev=2052855";}s:11:"banners_rtl";a:0:{}}}}', 'no'),
(223, '_site_transient_update_themes', 'O:8:"stdClass":4:{s:12:"last_checked";i:1591193777;s:7:"checked";a:1:{s:5:"azeri";s:0:"";}s:8:"response";a:0:{}s:12:"translations";a:0:{}}', 'no');

-- --------------------------------------------------------

--
-- Структура таблицы `wp_postmeta`
--

CREATE TABLE `wp_postmeta` (
  `meta_id` bigint(20) UNSIGNED NOT NULL,
  `post_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `meta_key` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `meta_value` longtext COLLATE utf8mb4_unicode_520_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_postmeta`
--

INSERT INTO `wp_postmeta` (`meta_id`, `post_id`, `meta_key`, `meta_value`) VALUES
(1, 2, '_wp_page_template', 'default'),
(2, 3, '_wp_page_template', 'default'),
(3, 5, '_edit_lock', '1591106150:1'),
(4, 6, '_wp_attached_file', '2020/06/big_logo_.png'),
(5, 6, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:500;s:6:"height";i:509;s:4:"file";s:21:"2020/06/big_logo_.png";s:5:"sizes";a:2:{s:6:"medium";a:4:{s:4:"file";s:21:"big_logo_-295x300.png";s:5:"width";i:295;s:6:"height";i:300;s:9:"mime-type";s:9:"image/png";}s:9:"thumbnail";a:4:{s:4:"file";s:21:"big_logo_-150x150.png";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:9:"image/png";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(6, 7, '_wp_attached_file', '2020/06/cropped-big_logo_.png'),
(7, 7, '_wp_attachment_context', 'site-icon'),
(8, 7, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:512;s:6:"height";i:512;s:4:"file";s:29:"2020/06/cropped-big_logo_.png";s:5:"sizes";a:6:{s:6:"medium";a:4:{s:4:"file";s:29:"cropped-big_logo_-300x300.png";s:5:"width";i:300;s:6:"height";i:300;s:9:"mime-type";s:9:"image/png";}s:9:"thumbnail";a:4:{s:4:"file";s:29:"cropped-big_logo_-150x150.png";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-270";a:4:{s:4:"file";s:29:"cropped-big_logo_-270x270.png";s:5:"width";i:270;s:6:"height";i:270;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-192";a:4:{s:4:"file";s:29:"cropped-big_logo_-192x192.png";s:5:"width";i:192;s:6:"height";i:192;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-180";a:4:{s:4:"file";s:29:"cropped-big_logo_-180x180.png";s:5:"width";i:180;s:6:"height";i:180;s:9:"mime-type";s:9:"image/png";}s:12:"site_icon-32";a:4:{s:4:"file";s:27:"cropped-big_logo_-32x32.png";s:5:"width";i:32;s:6:"height";i:32;s:9:"mime-type";s:9:"image/png";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(9, 6, '_wp_attachment_image_alt', 'Логотип'),
(10, 8, '_wp_attached_file', '2020/06/cropped-big_logo_-1.png'),
(11, 8, '_wp_attachment_context', 'site-icon'),
(12, 8, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:512;s:6:"height";i:512;s:4:"file";s:31:"2020/06/cropped-big_logo_-1.png";s:5:"sizes";a:6:{s:6:"medium";a:4:{s:4:"file";s:31:"cropped-big_logo_-1-300x300.png";s:5:"width";i:300;s:6:"height";i:300;s:9:"mime-type";s:9:"image/png";}s:9:"thumbnail";a:4:{s:4:"file";s:31:"cropped-big_logo_-1-150x150.png";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-270";a:4:{s:4:"file";s:31:"cropped-big_logo_-1-270x270.png";s:5:"width";i:270;s:6:"height";i:270;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-192";a:4:{s:4:"file";s:31:"cropped-big_logo_-1-192x192.png";s:5:"width";i:192;s:6:"height";i:192;s:9:"mime-type";s:9:"image/png";}s:13:"site_icon-180";a:4:{s:4:"file";s:31:"cropped-big_logo_-1-180x180.png";s:5:"width";i:180;s:6:"height";i:180;s:9:"mime-type";s:9:"image/png";}s:12:"site_icon-32";a:4:{s:4:"file";s:29:"cropped-big_logo_-1-32x32.png";s:5:"width";i:32;s:6:"height";i:32;s:9:"mime-type";s:9:"image/png";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(13, 5, '_customize_restore_dismissed', '1'),
(14, 9, '_wp_trash_meta_status', 'publish'),
(15, 9, '_wp_trash_meta_time', '1591106278'),
(17, 11, '_wp_attached_file', '2020/06/aze.png'),
(18, 11, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:92;s:6:"height";i:50;s:4:"file";s:15:"2020/06/aze.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(19, 12, '_edit_lock', '1591106538:1'),
(20, 12, '_customize_restore_dismissed', '1'),
(21, 13, '_edit_last', '1'),
(22, 13, '_edit_lock', '1591191658:1'),
(23, 16, '_edit_last', '1'),
(24, 16, '_edit_lock', '1591191956:1'),
(25, 20, '_edit_last', '1'),
(26, 20, '_edit_lock', '1591191895:1'),
(27, 23, '_edit_last', '1'),
(28, 23, '_edit_lock', '1591191980:1'),
(29, 2, '_edit_lock', '1591193415:1'),
(30, 27, '_wp_attached_file', '2020/06/az1.jpg'),
(31, 27, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az1.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az1-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az1-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az1-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az1-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az1-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(32, 28, '_wp_attached_file', '2020/06/az2.jpg'),
(33, 28, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az2.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az2-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az2-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az2-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az2-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az2-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(34, 29, '_wp_attached_file', '2020/06/az3.jpg'),
(35, 29, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az3.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az3-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az3-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az3-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az3-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az3-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(36, 30, '_wp_attached_file', '2020/06/az4.jpg'),
(37, 30, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az4.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az4-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az4-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az4-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az4-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az4-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(38, 31, '_wp_attached_file', '2020/06/az5.jpg'),
(39, 31, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az5.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az5-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az5-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az5-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az5-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az5-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(40, 32, '_wp_attached_file', '2020/06/az6.jpg'),
(41, 32, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az6.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az6-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az6-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az6-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az6-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az6-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(42, 33, '_wp_attached_file', '2020/06/az7.jpg'),
(43, 33, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:1920;s:6:"height";i:1233;s:4:"file";s:15:"2020/06/az7.jpg";s:5:"sizes";a:5:{s:6:"medium";a:4:{s:4:"file";s:15:"az7-300x193.jpg";s:5:"width";i:300;s:6:"height";i:193;s:9:"mime-type";s:10:"image/jpeg";}s:5:"large";a:4:{s:4:"file";s:16:"az7-1024x658.jpg";s:5:"width";i:1024;s:6:"height";i:658;s:9:"mime-type";s:10:"image/jpeg";}s:9:"thumbnail";a:4:{s:4:"file";s:15:"az7-150x150.jpg";s:5:"width";i:150;s:6:"height";i:150;s:9:"mime-type";s:10:"image/jpeg";}s:12:"medium_large";a:4:{s:4:"file";s:15:"az7-768x493.jpg";s:5:"width";i:768;s:6:"height";i:493;s:9:"mime-type";s:10:"image/jpeg";}s:9:"1536x1536";a:4:{s:4:"file";s:16:"az7-1536x986.jpg";s:5:"width";i:1536;s:6:"height";i:986;s:9:"mime-type";s:10:"image/jpeg";}}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(44, 2, '_edit_last', '1'),
(45, 2, 'img_big_logo', '6'),
(46, 2, '_img_big_logo', 'field_5ed664e315b8e'),
(47, 2, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(48, 2, '_title_slider', 'field_5ed6663815b8f'),
(49, 2, 'kto_mi_zag', 'Кто мы:'),
(50, 2, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(51, 2, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(52, 2, '_kto_mi_opis', 'field_5ed6695928ec7'),
(53, 2, 'mission_zag', 'Наша миссия'),
(54, 2, '_mission_zag', 'field_5ed6684440122'),
(55, 2, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(56, 2, '_mission_text', 'field_5ed668a040123'),
(57, 2, 'slider_im1', '27'),
(58, 2, '_slider_im1', 'field_5ed66701020de'),
(59, 2, 'slider_im2', '28'),
(60, 2, '_slider_im2', 'field_5ed66779020df'),
(61, 2, 'slider_im3', '29'),
(62, 2, '_slider_im3', 'field_5ed6679b020e0'),
(63, 35, 'img_big_logo', '6'),
(64, 35, '_img_big_logo', 'field_5ed664e315b8e'),
(65, 35, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(66, 35, '_title_slider', 'field_5ed6663815b8f'),
(67, 35, 'kto_mi_zag', 'Кто мы:'),
(68, 35, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(69, 35, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 	\r\n			\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. \r\n		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(70, 35, '_kto_mi_opis', 'field_5ed6695928ec7'),
(71, 35, 'mission_zag', 'Наша миссия'),
(72, 35, '_mission_zag', 'field_5ed6684440122'),
(73, 35, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(74, 35, '_mission_text', 'field_5ed668a040123'),
(75, 35, 'slider_im1', '27'),
(76, 35, '_slider_im1', 'field_5ed66701020de'),
(77, 35, 'slider_im2', '28'),
(78, 35, '_slider_im2', 'field_5ed66779020df'),
(79, 35, 'slider_im3', '29'),
(80, 35, '_slider_im3', 'field_5ed6679b020e0'),
(81, 36, 'img_big_logo', '6'),
(82, 36, '_img_big_logo', 'field_5ed664e315b8e'),
(83, 36, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(84, 36, '_title_slider', 'field_5ed6663815b8f'),
(85, 36, 'kto_mi_zag', 'Кто мы:'),
(86, 36, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(87, 36, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(88, 36, '_kto_mi_opis', 'field_5ed6695928ec7'),
(89, 36, 'mission_zag', 'Наша миссия'),
(90, 36, '_mission_zag', 'field_5ed6684440122'),
(91, 36, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(92, 36, '_mission_text', 'field_5ed668a040123'),
(93, 36, 'slider_im1', '27'),
(94, 36, '_slider_im1', 'field_5ed66701020de'),
(95, 36, 'slider_im2', '28'),
(96, 36, '_slider_im2', 'field_5ed66779020df'),
(97, 36, 'slider_im3', '29'),
(98, 36, '_slider_im3', 'field_5ed6679b020e0'),
(99, 2, 'slider_im4', '30'),
(100, 2, '_slider_im4', 'field_5ed66fa67947a'),
(101, 2, 'slider_im5', '31'),
(102, 2, '_slider_im5', 'field_5ed673b87947b'),
(103, 2, 'slider_im6', '32'),
(104, 2, '_slider_im6', 'field_5ed673dc7947c'),
(105, 2, 'slider_im7', '33'),
(106, 2, '_slider_im7', 'field_5ed673fc7947d'),
(107, 41, 'img_big_logo', '6'),
(108, 41, '_img_big_logo', 'field_5ed664e315b8e'),
(109, 41, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(110, 41, '_title_slider', 'field_5ed6663815b8f'),
(111, 41, 'kto_mi_zag', 'Кто мы:'),
(112, 41, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(113, 41, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(114, 41, '_kto_mi_opis', 'field_5ed6695928ec7'),
(115, 41, 'mission_zag', 'Наша миссия'),
(116, 41, '_mission_zag', 'field_5ed6684440122'),
(117, 41, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(118, 41, '_mission_text', 'field_5ed668a040123'),
(119, 41, 'slider_im1', '27'),
(120, 41, '_slider_im1', 'field_5ed66701020de'),
(121, 41, 'slider_im2', '28'),
(122, 41, '_slider_im2', 'field_5ed66779020df'),
(123, 41, 'slider_im3', '29'),
(124, 41, '_slider_im3', 'field_5ed6679b020e0'),
(125, 41, 'slider_im4', '30'),
(126, 41, '_slider_im4', 'field_5ed66fa67947a'),
(127, 41, 'slider_im5', '31'),
(128, 41, '_slider_im5', 'field_5ed673b87947b'),
(129, 41, 'slider_im6', '32'),
(130, 41, '_slider_im6', 'field_5ed673dc7947c'),
(131, 41, 'slider_im7', '33'),
(132, 41, '_slider_im7', 'field_5ed673fc7947d'),
(133, 42, '_edit_last', '1'),
(134, 42, '_edit_lock', '1591191712:1'),
(135, 44, '_wp_attached_file', '2020/06/logo_mini.jpg'),
(136, 44, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:88;s:6:"height";i:50;s:4:"file";s:21:"2020/06/logo_mini.jpg";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(137, 44, '_wp_attachment_image_alt', 'Лого в меню'),
(138, 2, 'menu_logo_img', '44'),
(139, 2, '_menu_logo_img', 'field_5ed675d9d7af0'),
(140, 45, 'img_big_logo', '6'),
(141, 45, '_img_big_logo', 'field_5ed664e315b8e'),
(142, 45, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(143, 45, '_title_slider', 'field_5ed6663815b8f'),
(144, 45, 'kto_mi_zag', 'Кто мы:'),
(145, 45, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(146, 45, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(147, 45, '_kto_mi_opis', 'field_5ed6695928ec7'),
(148, 45, 'mission_zag', 'Наша миссия'),
(149, 45, '_mission_zag', 'field_5ed6684440122'),
(150, 45, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(151, 45, '_mission_text', 'field_5ed668a040123'),
(152, 45, 'slider_im1', '27'),
(153, 45, '_slider_im1', 'field_5ed66701020de'),
(154, 45, 'slider_im2', '28'),
(155, 45, '_slider_im2', 'field_5ed66779020df'),
(156, 45, 'slider_im3', '29'),
(157, 45, '_slider_im3', 'field_5ed6679b020e0'),
(158, 45, 'slider_im4', '30'),
(159, 45, '_slider_im4', 'field_5ed66fa67947a'),
(160, 45, 'slider_im5', '31'),
(161, 45, '_slider_im5', 'field_5ed673b87947b'),
(162, 45, 'slider_im6', '32'),
(163, 45, '_slider_im6', 'field_5ed673dc7947c'),
(164, 45, 'slider_im7', '33'),
(165, 45, '_slider_im7', 'field_5ed673fc7947d'),
(166, 45, 'menu_logo_img', '44'),
(167, 45, '_menu_logo_img', 'field_5ed675d9d7af0'),
(168, 46, '_edit_last', '1'),
(169, 46, '_edit_lock', '1591191912:1'),
(170, 51, '_wp_attached_file', '2020/06/prezident.png'),
(171, 51, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:50;s:6:"height";i:54;s:4:"file";s:21:"2020/06/prezident.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(172, 51, '_wp_attachment_image_alt', 'Сайт президента Азербайджана'),
(173, 2, 'zag_azer', 'Больше об Азербайджане'),
(174, 2, '_zag_azer', 'field_5ed67754a1fe0'),
(175, 2, 'href1_text', 'Сайт президента Азербайджана'),
(176, 2, '_href1_text', 'field_5ed67790a1fe1'),
(177, 2, 'href1_img', '51'),
(178, 2, '_href1_img', 'field_5ed677f1a1fe2'),
(179, 2, 'href1', 'https://ru.president.az/'),
(180, 2, '_href1', 'field_5ed67830a1fe3'),
(181, 52, 'img_big_logo', '6'),
(182, 52, '_img_big_logo', 'field_5ed664e315b8e'),
(183, 52, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(184, 52, '_title_slider', 'field_5ed6663815b8f'),
(185, 52, 'kto_mi_zag', 'Кто мы:'),
(186, 52, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(187, 52, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(188, 52, '_kto_mi_opis', 'field_5ed6695928ec7'),
(189, 52, 'mission_zag', 'Наша миссия'),
(190, 52, '_mission_zag', 'field_5ed6684440122'),
(191, 52, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(192, 52, '_mission_text', 'field_5ed668a040123'),
(193, 52, 'slider_im1', '27'),
(194, 52, '_slider_im1', 'field_5ed66701020de'),
(195, 52, 'slider_im2', '28'),
(196, 52, '_slider_im2', 'field_5ed66779020df'),
(197, 52, 'slider_im3', '29'),
(198, 52, '_slider_im3', 'field_5ed6679b020e0'),
(199, 52, 'slider_im4', '30'),
(200, 52, '_slider_im4', 'field_5ed66fa67947a'),
(201, 52, 'slider_im5', '31'),
(202, 52, '_slider_im5', 'field_5ed673b87947b'),
(203, 52, 'slider_im6', '32'),
(204, 52, '_slider_im6', 'field_5ed673dc7947c'),
(205, 52, 'slider_im7', '33'),
(206, 52, '_slider_im7', 'field_5ed673fc7947d'),
(207, 52, 'menu_logo_img', '44'),
(208, 52, '_menu_logo_img', 'field_5ed675d9d7af0'),
(209, 52, 'zag_azer', 'Больше об Азербайджане'),
(210, 52, '_zag_azer', 'field_5ed67754a1fe0'),
(211, 52, 'href1_text', 'Сайт президента Азербайджана'),
(212, 52, '_href1_text', 'field_5ed67790a1fe1'),
(213, 52, 'href1_img', '51'),
(214, 52, '_href1_img', 'field_5ed677f1a1fe2'),
(215, 52, 'href1', 'https://ru.president.az/'),
(216, 52, '_href1', 'field_5ed67830a1fe3'),
(217, 57, '_wp_attached_file', '2020/06/atac.png'),
(218, 57, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:110;s:6:"height";i:40;s:4:"file";s:16:"2020/06/atac.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(219, 2, 'href2', 'https://azertag.az/ru/'),
(220, 2, '_href2', 'field_5ed7821c9d3c9'),
(221, 2, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(222, 2, '_href2_text', 'field_5ed781c767fc3'),
(223, 2, 'href2_img', '57'),
(224, 2, '_href2_img', 'field_5ed781fb0aa6b'),
(225, 58, 'img_big_logo', '6'),
(226, 58, '_img_big_logo', 'field_5ed664e315b8e'),
(227, 58, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(228, 58, '_title_slider', 'field_5ed6663815b8f'),
(229, 58, 'kto_mi_zag', 'Кто мы:'),
(230, 58, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(231, 58, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(232, 58, '_kto_mi_opis', 'field_5ed6695928ec7'),
(233, 58, 'mission_zag', 'Наша миссия'),
(234, 58, '_mission_zag', 'field_5ed6684440122'),
(235, 58, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(236, 58, '_mission_text', 'field_5ed668a040123'),
(237, 58, 'slider_im1', '27'),
(238, 58, '_slider_im1', 'field_5ed66701020de'),
(239, 58, 'slider_im2', '28'),
(240, 58, '_slider_im2', 'field_5ed66779020df'),
(241, 58, 'slider_im3', '29'),
(242, 58, '_slider_im3', 'field_5ed6679b020e0'),
(243, 58, 'slider_im4', '30'),
(244, 58, '_slider_im4', 'field_5ed66fa67947a'),
(245, 58, 'slider_im5', '31'),
(246, 58, '_slider_im5', 'field_5ed673b87947b'),
(247, 58, 'slider_im6', '32'),
(248, 58, '_slider_im6', 'field_5ed673dc7947c'),
(249, 58, 'slider_im7', '33'),
(250, 58, '_slider_im7', 'field_5ed673fc7947d'),
(251, 58, 'menu_logo_img', '44'),
(252, 58, '_menu_logo_img', 'field_5ed675d9d7af0'),
(253, 58, 'zag_azer', 'Больше об Азербайджане'),
(254, 58, '_zag_azer', 'field_5ed67754a1fe0'),
(255, 58, 'href1_text', 'Сайт президента Азербайджана'),
(256, 58, '_href1_text', 'field_5ed67790a1fe1'),
(257, 58, 'href1_img', '51'),
(258, 58, '_href1_img', 'field_5ed677f1a1fe2'),
(259, 58, 'href1', 'https://ru.president.az/'),
(260, 58, '_href1', 'field_5ed67830a1fe3'),
(261, 58, 'href2', 'https://azertag.az/ru/'),
(262, 58, '_href2', 'field_5ed7821c9d3c9'),
(263, 58, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(264, 58, '_href2_text', 'field_5ed781c767fc3'),
(265, 58, 'href2_img', '57'),
(266, 58, '_href2_img', 'field_5ed781fb0aa6b'),
(267, 62, '_wp_attached_file', '2020/06/nizami.png'),
(268, 62, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:50;s:6:"height";i:50;s:4:"file";s:18:"2020/06/nizami.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(269, 2, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(270, 2, '_href3', 'field_5ed78f51e466c'),
(271, 2, 'href3_text', 'Nizami Ganjavi International Center'),
(272, 2, '_href3_text', 'field_5ed78bbeb317d'),
(273, 63, 'img_big_logo', '6'),
(274, 63, '_img_big_logo', 'field_5ed664e315b8e'),
(275, 63, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(276, 63, '_title_slider', 'field_5ed6663815b8f'),
(277, 63, 'kto_mi_zag', 'Кто мы:'),
(278, 63, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(279, 63, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(280, 63, '_kto_mi_opis', 'field_5ed6695928ec7'),
(281, 63, 'mission_zag', 'Наша миссия'),
(282, 63, '_mission_zag', 'field_5ed6684440122'),
(283, 63, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(284, 63, '_mission_text', 'field_5ed668a040123'),
(285, 63, 'slider_im1', '27'),
(286, 63, '_slider_im1', 'field_5ed66701020de'),
(287, 63, 'slider_im2', '28'),
(288, 63, '_slider_im2', 'field_5ed66779020df'),
(289, 63, 'slider_im3', '29'),
(290, 63, '_slider_im3', 'field_5ed6679b020e0'),
(291, 63, 'slider_im4', '30'),
(292, 63, '_slider_im4', 'field_5ed66fa67947a'),
(293, 63, 'slider_im5', '31'),
(294, 63, '_slider_im5', 'field_5ed673b87947b'),
(295, 63, 'slider_im6', '32'),
(296, 63, '_slider_im6', 'field_5ed673dc7947c'),
(297, 63, 'slider_im7', '33'),
(298, 63, '_slider_im7', 'field_5ed673fc7947d'),
(299, 63, 'menu_logo_img', '44'),
(300, 63, '_menu_logo_img', 'field_5ed675d9d7af0'),
(301, 63, 'zag_azer', 'Больше об Азербайджане'),
(302, 63, '_zag_azer', 'field_5ed67754a1fe0'),
(303, 63, 'href1_text', 'Сайт президента Азербайджана'),
(304, 63, '_href1_text', 'field_5ed67790a1fe1'),
(305, 63, 'href1_img', '51'),
(306, 63, '_href1_img', 'field_5ed677f1a1fe2'),
(307, 63, 'href1', 'https://ru.president.az/'),
(308, 63, '_href1', 'field_5ed67830a1fe3'),
(309, 63, 'href2', 'https://azertag.az/ru/'),
(310, 63, '_href2', 'field_5ed7821c9d3c9'),
(311, 63, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(312, 63, '_href2_text', 'field_5ed781c767fc3'),
(313, 63, 'href2_img', '57'),
(314, 63, '_href2_img', 'field_5ed781fb0aa6b'),
(315, 63, 'href3', '62'),
(316, 63, '_href3', 'field_5ed78bee72c8e'),
(317, 63, 'href3_text', 'Nizami Ganjavi International Center'),
(318, 63, '_href3_text', 'field_5ed78bbeb317d'),
(319, 64, 'img_big_logo', '6'),
(320, 64, '_img_big_logo', 'field_5ed664e315b8e'),
(321, 64, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(322, 64, '_title_slider', 'field_5ed6663815b8f'),
(323, 64, 'kto_mi_zag', 'Кто мы:'),
(324, 64, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(325, 64, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(326, 64, '_kto_mi_opis', 'field_5ed6695928ec7'),
(327, 64, 'mission_zag', 'Наша миссия'),
(328, 64, '_mission_zag', 'field_5ed6684440122'),
(329, 64, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(330, 64, '_mission_text', 'field_5ed668a040123'),
(331, 64, 'slider_im1', '27'),
(332, 64, '_slider_im1', 'field_5ed66701020de'),
(333, 64, 'slider_im2', '28'),
(334, 64, '_slider_im2', 'field_5ed66779020df'),
(335, 64, 'slider_im3', '29'),
(336, 64, '_slider_im3', 'field_5ed6679b020e0'),
(337, 64, 'slider_im4', '30'),
(338, 64, '_slider_im4', 'field_5ed66fa67947a'),
(339, 64, 'slider_im5', '31'),
(340, 64, '_slider_im5', 'field_5ed673b87947b'),
(341, 64, 'slider_im6', '32'),
(342, 64, '_slider_im6', 'field_5ed673dc7947c'),
(343, 64, 'slider_im7', '33'),
(344, 64, '_slider_im7', 'field_5ed673fc7947d'),
(345, 64, 'menu_logo_img', '44'),
(346, 64, '_menu_logo_img', 'field_5ed675d9d7af0'),
(347, 64, 'zag_azer', 'Больше об Азербайджане'),
(348, 64, '_zag_azer', 'field_5ed67754a1fe0'),
(349, 64, 'href1_text', 'Сайт президента Азербайджана'),
(350, 64, '_href1_text', 'field_5ed67790a1fe1'),
(351, 64, 'href1_img', '51'),
(352, 64, '_href1_img', 'field_5ed677f1a1fe2'),
(353, 64, 'href1', 'https://ru.president.az/'),
(354, 64, '_href1', 'field_5ed67830a1fe3'),
(355, 64, 'href2', 'https://azertag.az/ru/'),
(356, 64, '_href2', 'field_5ed7821c9d3c9'),
(357, 64, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(358, 64, '_href2_text', 'field_5ed781c767fc3'),
(359, 64, 'href2_img', '57'),
(360, 64, '_href2_img', 'field_5ed781fb0aa6b'),
(361, 64, 'href3', '62'),
(362, 64, '_href3', 'field_5ed78bee72c8e'),
(363, 64, 'href3_text', 'Nizami Ganjavi International Center'),
(364, 64, '_href3_text', 'field_5ed78bbeb317d'),
(365, 2, 'href3_img', '62'),
(366, 2, '_href3_img', 'field_5ed78bee72c8e'),
(367, 65, 'img_big_logo', '6'),
(368, 65, '_img_big_logo', 'field_5ed664e315b8e'),
(369, 65, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(370, 65, '_title_slider', 'field_5ed6663815b8f'),
(371, 65, 'kto_mi_zag', 'Кто мы:'),
(372, 65, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(373, 65, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(374, 65, '_kto_mi_opis', 'field_5ed6695928ec7'),
(375, 65, 'mission_zag', 'Наша миссия'),
(376, 65, '_mission_zag', 'field_5ed6684440122'),
(377, 65, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(378, 65, '_mission_text', 'field_5ed668a040123'),
(379, 65, 'slider_im1', '27'),
(380, 65, '_slider_im1', 'field_5ed66701020de'),
(381, 65, 'slider_im2', '28'),
(382, 65, '_slider_im2', 'field_5ed66779020df'),
(383, 65, 'slider_im3', '29'),
(384, 65, '_slider_im3', 'field_5ed6679b020e0'),
(385, 65, 'slider_im4', '30'),
(386, 65, '_slider_im4', 'field_5ed66fa67947a'),
(387, 65, 'slider_im5', '31'),
(388, 65, '_slider_im5', 'field_5ed673b87947b'),
(389, 65, 'slider_im6', '32'),
(390, 65, '_slider_im6', 'field_5ed673dc7947c'),
(391, 65, 'slider_im7', '33'),
(392, 65, '_slider_im7', 'field_5ed673fc7947d'),
(393, 65, 'menu_logo_img', '44'),
(394, 65, '_menu_logo_img', 'field_5ed675d9d7af0'),
(395, 65, 'zag_azer', 'Больше об Азербайджане'),
(396, 65, '_zag_azer', 'field_5ed67754a1fe0'),
(397, 65, 'href1_text', 'Сайт президента Азербайджана'),
(398, 65, '_href1_text', 'field_5ed67790a1fe1'),
(399, 65, 'href1_img', '51'),
(400, 65, '_href1_img', 'field_5ed677f1a1fe2'),
(401, 65, 'href1', 'https://ru.president.az/'),
(402, 65, '_href1', 'field_5ed67830a1fe3'),
(403, 65, 'href2', 'https://azertag.az/ru/'),
(404, 65, '_href2', 'field_5ed7821c9d3c9'),
(405, 65, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(406, 65, '_href2_text', 'field_5ed781c767fc3'),
(407, 65, 'href2_img', '57'),
(408, 65, '_href2_img', 'field_5ed781fb0aa6b'),
(409, 65, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(410, 65, '_href3', 'field_5ed78f51e466c'),
(411, 65, 'href3_text', 'Nizami Ganjavi International Center'),
(412, 65, '_href3_text', 'field_5ed78bbeb317d'),
(413, 65, 'href3_img', '62'),
(414, 65, '_href3_img', 'field_5ed78bee72c8e'),
(415, 69, '_wp_attached_file', '2020/06/sam.png'),
(416, 69, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:50;s:6:"height";i:50;s:4:"file";s:15:"2020/06/sam.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(417, 69, '_wp_attachment_image_alt', 'Союз азербайджанцев мира лого'),
(418, 2, 'href4_text', 'Союз азербайджанцев мира'),
(419, 2, '_href4_text', 'field_5ed7925a05902'),
(420, 2, 'href4_img', '69'),
(421, 2, '_href4_img', 'field_5ed79295da01e'),
(422, 2, 'href4', 'http://azunion.org/ru/'),
(423, 2, '_href4', 'field_5ed792c29bbbd'),
(424, 70, 'img_big_logo', '6'),
(425, 70, '_img_big_logo', 'field_5ed664e315b8e'),
(426, 70, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(427, 70, '_title_slider', 'field_5ed6663815b8f'),
(428, 70, 'kto_mi_zag', 'Кто мы:'),
(429, 70, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(430, 70, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(431, 70, '_kto_mi_opis', 'field_5ed6695928ec7'),
(432, 70, 'mission_zag', 'Наша миссия'),
(433, 70, '_mission_zag', 'field_5ed6684440122'),
(434, 70, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(435, 70, '_mission_text', 'field_5ed668a040123'),
(436, 70, 'slider_im1', '27'),
(437, 70, '_slider_im1', 'field_5ed66701020de'),
(438, 70, 'slider_im2', '28'),
(439, 70, '_slider_im2', 'field_5ed66779020df'),
(440, 70, 'slider_im3', '29'),
(441, 70, '_slider_im3', 'field_5ed6679b020e0'),
(442, 70, 'slider_im4', '30'),
(443, 70, '_slider_im4', 'field_5ed66fa67947a'),
(444, 70, 'slider_im5', '31'),
(445, 70, '_slider_im5', 'field_5ed673b87947b'),
(446, 70, 'slider_im6', '32'),
(447, 70, '_slider_im6', 'field_5ed673dc7947c'),
(448, 70, 'slider_im7', '33'),
(449, 70, '_slider_im7', 'field_5ed673fc7947d'),
(450, 70, 'menu_logo_img', '44'),
(451, 70, '_menu_logo_img', 'field_5ed675d9d7af0'),
(452, 70, 'zag_azer', 'Больше об Азербайджане'),
(453, 70, '_zag_azer', 'field_5ed67754a1fe0'),
(454, 70, 'href1_text', 'Сайт президента Азербайджана'),
(455, 70, '_href1_text', 'field_5ed67790a1fe1'),
(456, 70, 'href1_img', '51'),
(457, 70, '_href1_img', 'field_5ed677f1a1fe2'),
(458, 70, 'href1', 'https://ru.president.az/'),
(459, 70, '_href1', 'field_5ed67830a1fe3'),
(460, 70, 'href2', 'https://azertag.az/ru/'),
(461, 70, '_href2', 'field_5ed7821c9d3c9'),
(462, 70, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(463, 70, '_href2_text', 'field_5ed781c767fc3'),
(464, 70, 'href2_img', '57'),
(465, 70, '_href2_img', 'field_5ed781fb0aa6b'),
(466, 70, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(467, 70, '_href3', 'field_5ed78f51e466c'),
(468, 70, 'href3_text', 'Nizami Ganjavi International Center'),
(469, 70, '_href3_text', 'field_5ed78bbeb317d'),
(470, 70, 'href3_img', '62'),
(471, 70, '_href3_img', 'field_5ed78bee72c8e'),
(472, 70, 'href4_text', 'Союз азербайджанцев мира'),
(473, 70, '_href4_text', 'field_5ed7925a05902'),
(474, 70, 'href4_img', '69'),
(475, 70, '_href4_img', 'field_5ed79295da01e'),
(476, 70, 'href4', 'http://azunion.org/ru/'),
(477, 70, '_href4', 'field_5ed792c29bbbd'),
(478, 71, 'img_big_logo', '6'),
(479, 71, '_img_big_logo', 'field_5ed664e315b8e'),
(480, 71, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(481, 71, '_title_slider', 'field_5ed6663815b8f'),
(482, 71, 'kto_mi_zag', 'Кто мы:'),
(483, 71, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(484, 71, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(485, 71, '_kto_mi_opis', 'field_5ed6695928ec7'),
(486, 71, 'mission_zag', 'Наша миссия'),
(487, 71, '_mission_zag', 'field_5ed6684440122'),
(488, 71, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(489, 71, '_mission_text', 'field_5ed668a040123'),
(490, 71, 'slider_im1', '27'),
(491, 71, '_slider_im1', 'field_5ed66701020de'),
(492, 71, 'slider_im2', '28'),
(493, 71, '_slider_im2', 'field_5ed66779020df'),
(494, 71, 'slider_im3', '29'),
(495, 71, '_slider_im3', 'field_5ed6679b020e0'),
(496, 71, 'slider_im4', '30'),
(497, 71, '_slider_im4', 'field_5ed66fa67947a'),
(498, 71, 'slider_im5', '31'),
(499, 71, '_slider_im5', 'field_5ed673b87947b'),
(500, 71, 'slider_im6', '32'),
(501, 71, '_slider_im6', 'field_5ed673dc7947c'),
(502, 71, 'slider_im7', '33'),
(503, 71, '_slider_im7', 'field_5ed673fc7947d'),
(504, 71, 'menu_logo_img', '44'),
(505, 71, '_menu_logo_img', 'field_5ed675d9d7af0'),
(506, 71, 'zag_azer', 'Больше об Азербайджане'),
(507, 71, '_zag_azer', 'field_5ed67754a1fe0'),
(508, 71, 'href1_text', 'Сайт президента Азербайджана'),
(509, 71, '_href1_text', 'field_5ed67790a1fe1'),
(510, 71, 'href1_img', '51'),
(511, 71, '_href1_img', 'field_5ed677f1a1fe2'),
(512, 71, 'href1', 'https://ru.president.az/'),
(513, 71, '_href1', 'field_5ed67830a1fe3'),
(514, 71, 'href2', 'https://azertag.az/ru/'),
(515, 71, '_href2', 'field_5ed7821c9d3c9'),
(516, 71, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(517, 71, '_href2_text', 'field_5ed781c767fc3'),
(518, 71, 'href2_img', '57'),
(519, 71, '_href2_img', 'field_5ed781fb0aa6b'),
(520, 71, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(521, 71, '_href3', 'field_5ed78f51e466c'),
(522, 71, 'href3_text', 'Nizami Ganjavi International Center'),
(523, 71, '_href3_text', 'field_5ed78bbeb317d'),
(524, 71, 'href3_img', '62'),
(525, 71, '_href3_img', 'field_5ed78bee72c8e'),
(526, 71, 'href4_text', 'Союз азербайджанцев мира'),
(527, 71, '_href4_text', 'field_5ed7925a05902'),
(528, 71, 'href4_img', '69'),
(529, 71, '_href4_img', 'field_5ed79295da01e'),
(530, 71, 'href4', 'http://azunion.org/ru/'),
(531, 71, '_href4', 'field_5ed792c29bbbd'),
(532, 2, 'href5_text', 'Об\'єднана діаспора азербайджанців України'),
(533, 2, '_href5_text', 'field_5ed794e0c71b5'),
(534, 2, 'href5_img', '11'),
(535, 2, '_href5_img', 'field_5ed7951667192'),
(536, 2, 'href5', 'http://www.aze.in.ua/'),
(537, 2, '_href5', 'field_5ed79538bbaf6'),
(538, 75, 'img_big_logo', '6'),
(539, 75, '_img_big_logo', 'field_5ed664e315b8e'),
(540, 75, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(541, 75, '_title_slider', 'field_5ed6663815b8f'),
(542, 75, 'kto_mi_zag', 'Кто мы:'),
(543, 75, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(544, 75, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(545, 75, '_kto_mi_opis', 'field_5ed6695928ec7'),
(546, 75, 'mission_zag', 'Наша миссия'),
(547, 75, '_mission_zag', 'field_5ed6684440122'),
(548, 75, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(549, 75, '_mission_text', 'field_5ed668a040123'),
(550, 75, 'slider_im1', '27'),
(551, 75, '_slider_im1', 'field_5ed66701020de'),
(552, 75, 'slider_im2', '28'),
(553, 75, '_slider_im2', 'field_5ed66779020df'),
(554, 75, 'slider_im3', '29'),
(555, 75, '_slider_im3', 'field_5ed6679b020e0'),
(556, 75, 'slider_im4', '30'),
(557, 75, '_slider_im4', 'field_5ed66fa67947a'),
(558, 75, 'slider_im5', '31'),
(559, 75, '_slider_im5', 'field_5ed673b87947b'),
(560, 75, 'slider_im6', '32'),
(561, 75, '_slider_im6', 'field_5ed673dc7947c'),
(562, 75, 'slider_im7', '33'),
(563, 75, '_slider_im7', 'field_5ed673fc7947d'),
(564, 75, 'menu_logo_img', '44'),
(565, 75, '_menu_logo_img', 'field_5ed675d9d7af0'),
(566, 75, 'zag_azer', 'Больше об Азербайджане'),
(567, 75, '_zag_azer', 'field_5ed67754a1fe0'),
(568, 75, 'href1_text', 'Сайт президента Азербайджана'),
(569, 75, '_href1_text', 'field_5ed67790a1fe1'),
(570, 75, 'href1_img', '51'),
(571, 75, '_href1_img', 'field_5ed677f1a1fe2'),
(572, 75, 'href1', 'https://ru.president.az/'),
(573, 75, '_href1', 'field_5ed67830a1fe3'),
(574, 75, 'href2', 'https://azertag.az/ru/'),
(575, 75, '_href2', 'field_5ed7821c9d3c9'),
(576, 75, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(577, 75, '_href2_text', 'field_5ed781c767fc3'),
(578, 75, 'href2_img', '57'),
(579, 75, '_href2_img', 'field_5ed781fb0aa6b'),
(580, 75, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(581, 75, '_href3', 'field_5ed78f51e466c'),
(582, 75, 'href3_text', 'Nizami Ganjavi International Center'),
(583, 75, '_href3_text', 'field_5ed78bbeb317d'),
(584, 75, 'href3_img', '62'),
(585, 75, '_href3_img', 'field_5ed78bee72c8e'),
(586, 75, 'href4_text', 'Союз азербайджанцев мира'),
(587, 75, '_href4_text', 'field_5ed7925a05902'),
(588, 75, 'href4_img', '69'),
(589, 75, '_href4_img', 'field_5ed79295da01e'),
(590, 75, 'href4', 'http://azunion.org/ru/'),
(591, 75, '_href4', 'field_5ed792c29bbbd'),
(592, 75, 'href5_text', 'Об\'єднана діаспора азербайджанців України'),
(593, 75, '_href5_text', 'field_5ed794e0c71b5'),
(594, 75, 'href5_img', '11'),
(595, 75, '_href5_img', 'field_5ed7951667192'),
(596, 75, 'href5', 'http://www.aze.in.ua/'),
(597, 75, '_href5', 'field_5ed79538bbaf6'),
(598, 76, 'img_big_logo', '6'),
(599, 76, '_img_big_logo', 'field_5ed664e315b8e'),
(600, 76, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(601, 76, '_title_slider', 'field_5ed6663815b8f'),
(602, 76, 'kto_mi_zag', 'Кто мы:'),
(603, 76, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(604, 76, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(605, 76, '_kto_mi_opis', 'field_5ed6695928ec7'),
(606, 76, 'mission_zag', 'Наша миссия'),
(607, 76, '_mission_zag', 'field_5ed6684440122'),
(608, 76, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(609, 76, '_mission_text', 'field_5ed668a040123'),
(610, 76, 'slider_im1', '27'),
(611, 76, '_slider_im1', 'field_5ed66701020de'),
(612, 76, 'slider_im2', '28'),
(613, 76, '_slider_im2', 'field_5ed66779020df'),
(614, 76, 'slider_im3', '29'),
(615, 76, '_slider_im3', 'field_5ed6679b020e0'),
(616, 76, 'slider_im4', '30'),
(617, 76, '_slider_im4', 'field_5ed66fa67947a'),
(618, 76, 'slider_im5', '31'),
(619, 76, '_slider_im5', 'field_5ed673b87947b'),
(620, 76, 'slider_im6', '32'),
(621, 76, '_slider_im6', 'field_5ed673dc7947c'),
(622, 76, 'slider_im7', '33'),
(623, 76, '_slider_im7', 'field_5ed673fc7947d'),
(624, 76, 'menu_logo_img', '44'),
(625, 76, '_menu_logo_img', 'field_5ed675d9d7af0'),
(626, 76, 'zag_azer', 'Больше об Азербайджане'),
(627, 76, '_zag_azer', 'field_5ed67754a1fe0'),
(628, 76, 'href1_text', 'Сайт президента Азербайджана'),
(629, 76, '_href1_text', 'field_5ed67790a1fe1'),
(630, 76, 'href1_img', '51'),
(631, 76, '_href1_img', 'field_5ed677f1a1fe2'),
(632, 76, 'href1', 'https://ru.president.az/'),
(633, 76, '_href1', 'field_5ed67830a1fe3'),
(634, 76, 'href2', 'https://azertag.az/ru/'),
(635, 76, '_href2', 'field_5ed7821c9d3c9'),
(636, 76, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(637, 76, '_href2_text', 'field_5ed781c767fc3'),
(638, 76, 'href2_img', '57'),
(639, 76, '_href2_img', 'field_5ed781fb0aa6b'),
(640, 76, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(641, 76, '_href3', 'field_5ed78f51e466c'),
(642, 76, 'href3_text', 'Nizami Ganjavi International Center'),
(643, 76, '_href3_text', 'field_5ed78bbeb317d'),
(644, 76, 'href3_img', '62'),
(645, 76, '_href3_img', 'field_5ed78bee72c8e'),
(646, 76, 'href4_text', 'Союз азербайджанцев мира'),
(647, 76, '_href4_text', 'field_5ed7925a05902'),
(648, 76, 'href4_img', '69'),
(649, 76, '_href4_img', 'field_5ed79295da01e'),
(650, 76, 'href4', 'http://azunion.org/ru/'),
(651, 76, '_href4', 'field_5ed792c29bbbd'),
(652, 76, 'href5_text', 'Об\'єднана діаспора азербайджанців України'),
(653, 76, '_href5_text', 'field_5ed794e0c71b5'),
(654, 76, 'href5_img', '11'),
(655, 76, '_href5_img', 'field_5ed7951667192'),
(656, 76, 'href5', 'http://www.aze.in.ua/'),
(657, 76, '_href5', 'field_5ed79538bbaf6'),
(658, 80, '_wp_attached_file', '2020/06/flag.png'),
(659, 80, '_wp_attachment_metadata', 'a:5:{s:5:"width";i:75;s:6:"height";i:50;s:4:"file";s:16:"2020/06/flag.png";s:5:"sizes";a:0:{}s:10:"image_meta";a:12:{s:8:"aperture";s:1:"0";s:6:"credit";s:0:"";s:6:"camera";s:0:"";s:7:"caption";s:0:"";s:17:"created_timestamp";s:1:"0";s:9:"copyright";s:0:"";s:12:"focal_length";s:1:"0";s:3:"iso";s:1:"0";s:13:"shutter_speed";s:1:"0";s:5:"title";s:0:"";s:11:"orientation";s:1:"0";s:8:"keywords";a:0:{}}}'),
(660, 80, '_wp_attachment_image_alt', 'Сайт Азейбарджан лого'),
(661, 2, 'href6', 'https://azerbaijan.az/ru'),
(662, 2, '_href6', 'field_5ed7966a1d301'),
(663, 2, 'href6_text', 'Азербайджан'),
(664, 2, '_href6_text', 'field_5ed7961d1aefe'),
(665, 2, 'href6_img', '80'),
(666, 2, '_href6_img', 'field_5ed7964853ce8'),
(667, 81, 'img_big_logo', '6'),
(668, 81, '_img_big_logo', 'field_5ed664e315b8e'),
(669, 81, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(670, 81, '_title_slider', 'field_5ed6663815b8f'),
(671, 81, 'kto_mi_zag', 'Кто мы:'),
(672, 81, '_kto_mi_zag', 'field_5ed6691c28ec6');
INSERT INTO `wp_postmeta` (`meta_id`, `post_id`, `meta_key`, `meta_value`) VALUES
(673, 81, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(674, 81, '_kto_mi_opis', 'field_5ed6695928ec7'),
(675, 81, 'mission_zag', 'Наша миссия'),
(676, 81, '_mission_zag', 'field_5ed6684440122'),
(677, 81, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(678, 81, '_mission_text', 'field_5ed668a040123'),
(679, 81, 'slider_im1', '27'),
(680, 81, '_slider_im1', 'field_5ed66701020de'),
(681, 81, 'slider_im2', '28'),
(682, 81, '_slider_im2', 'field_5ed66779020df'),
(683, 81, 'slider_im3', '29'),
(684, 81, '_slider_im3', 'field_5ed6679b020e0'),
(685, 81, 'slider_im4', '30'),
(686, 81, '_slider_im4', 'field_5ed66fa67947a'),
(687, 81, 'slider_im5', '31'),
(688, 81, '_slider_im5', 'field_5ed673b87947b'),
(689, 81, 'slider_im6', '32'),
(690, 81, '_slider_im6', 'field_5ed673dc7947c'),
(691, 81, 'slider_im7', '33'),
(692, 81, '_slider_im7', 'field_5ed673fc7947d'),
(693, 81, 'menu_logo_img', '44'),
(694, 81, '_menu_logo_img', 'field_5ed675d9d7af0'),
(695, 81, 'zag_azer', 'Больше об Азербайджане'),
(696, 81, '_zag_azer', 'field_5ed67754a1fe0'),
(697, 81, 'href1_text', 'Сайт президента Азербайджана'),
(698, 81, '_href1_text', 'field_5ed67790a1fe1'),
(699, 81, 'href1_img', '51'),
(700, 81, '_href1_img', 'field_5ed677f1a1fe2'),
(701, 81, 'href1', 'https://ru.president.az/'),
(702, 81, '_href1', 'field_5ed67830a1fe3'),
(703, 81, 'href2', 'https://azertag.az/ru/'),
(704, 81, '_href2', 'field_5ed7821c9d3c9'),
(705, 81, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(706, 81, '_href2_text', 'field_5ed781c767fc3'),
(707, 81, 'href2_img', '57'),
(708, 81, '_href2_img', 'field_5ed781fb0aa6b'),
(709, 81, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(710, 81, '_href3', 'field_5ed78f51e466c'),
(711, 81, 'href3_text', 'Nizami Ganjavi International Center'),
(712, 81, '_href3_text', 'field_5ed78bbeb317d'),
(713, 81, 'href3_img', '62'),
(714, 81, '_href3_img', 'field_5ed78bee72c8e'),
(715, 81, 'href4_text', 'Союз азербайджанцев мира'),
(716, 81, '_href4_text', 'field_5ed7925a05902'),
(717, 81, 'href4_img', '69'),
(718, 81, '_href4_img', 'field_5ed79295da01e'),
(719, 81, 'href4', 'http://azunion.org/ru/'),
(720, 81, '_href4', 'field_5ed792c29bbbd'),
(721, 81, 'href5_text', 'Об\'єднана діаспора азербайджанців України'),
(722, 81, '_href5_text', 'field_5ed794e0c71b5'),
(723, 81, 'href5_img', '11'),
(724, 81, '_href5_img', 'field_5ed7951667192'),
(725, 81, 'href5', 'http://www.aze.in.ua/'),
(726, 81, '_href5', 'field_5ed79538bbaf6'),
(727, 81, 'href6', 'https://azerbaijan.az/ru'),
(728, 81, '_href6', 'field_5ed7966a1d301'),
(729, 81, 'href6_text', 'Азербайджан'),
(730, 81, '_href6_text', 'field_5ed7961d1aefe'),
(731, 81, 'href6_img', '80'),
(732, 81, '_href6_img', 'field_5ed7964853ce8'),
(733, 82, 'img_big_logo', '6'),
(734, 82, '_img_big_logo', 'field_5ed664e315b8e'),
(735, 82, 'title_slider', 'Азербайджанский культурно-общественный центр'),
(736, 82, '_title_slider', 'field_5ed6663815b8f'),
(737, 82, 'kto_mi_zag', 'Кто мы:'),
(738, 82, '_kto_mi_zag', 'field_5ed6691c28ec6'),
(739, 82, 'kto_mi_opis', 'Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.'),
(740, 82, '_kto_mi_opis', 'field_5ed6695928ec7'),
(741, 82, 'mission_zag', 'Наша миссия'),
(742, 82, '_mission_zag', 'field_5ed6684440122'),
(743, 82, 'mission_text', 'Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам'),
(744, 82, '_mission_text', 'field_5ed668a040123'),
(745, 82, 'slider_im1', '27'),
(746, 82, '_slider_im1', 'field_5ed66701020de'),
(747, 82, 'slider_im2', '28'),
(748, 82, '_slider_im2', 'field_5ed66779020df'),
(749, 82, 'slider_im3', '29'),
(750, 82, '_slider_im3', 'field_5ed6679b020e0'),
(751, 82, 'slider_im4', '30'),
(752, 82, '_slider_im4', 'field_5ed66fa67947a'),
(753, 82, 'slider_im5', '31'),
(754, 82, '_slider_im5', 'field_5ed673b87947b'),
(755, 82, 'slider_im6', '32'),
(756, 82, '_slider_im6', 'field_5ed673dc7947c'),
(757, 82, 'slider_im7', '33'),
(758, 82, '_slider_im7', 'field_5ed673fc7947d'),
(759, 82, 'menu_logo_img', '44'),
(760, 82, '_menu_logo_img', 'field_5ed675d9d7af0'),
(761, 82, 'zag_azer', 'Больше об Азербайджане'),
(762, 82, '_zag_azer', 'field_5ed67754a1fe0'),
(763, 82, 'href1_text', 'Сайт президента Азербайджана'),
(764, 82, '_href1_text', 'field_5ed67790a1fe1'),
(765, 82, 'href1_img', '51'),
(766, 82, '_href1_img', 'field_5ed677f1a1fe2'),
(767, 82, 'href1', 'https://ru.president.az/'),
(768, 82, '_href1', 'field_5ed67830a1fe3'),
(769, 82, 'href2', 'https://azertag.az/ru/'),
(770, 82, '_href2', 'field_5ed7821c9d3c9'),
(771, 82, 'href2_text', 'Aзербайджанское государственное информационное агенство'),
(772, 82, '_href2_text', 'field_5ed781c767fc3'),
(773, 82, 'href2_img', '57'),
(774, 82, '_href2_img', 'field_5ed781fb0aa6b'),
(775, 82, 'href3', 'https://www.nizamiganjavi-ic.org/index.html'),
(776, 82, '_href3', 'field_5ed78f51e466c'),
(777, 82, 'href3_text', 'Nizami Ganjavi International Center'),
(778, 82, '_href3_text', 'field_5ed78bbeb317d'),
(779, 82, 'href3_img', '62'),
(780, 82, '_href3_img', 'field_5ed78bee72c8e'),
(781, 82, 'href4_text', 'Союз азербайджанцев мира'),
(782, 82, '_href4_text', 'field_5ed7925a05902'),
(783, 82, 'href4_img', '69'),
(784, 82, '_href4_img', 'field_5ed79295da01e'),
(785, 82, 'href4', 'http://azunion.org/ru/'),
(786, 82, '_href4', 'field_5ed792c29bbbd'),
(787, 82, 'href5_text', 'Об\'єднана діаспора азербайджанців України'),
(788, 82, '_href5_text', 'field_5ed794e0c71b5'),
(789, 82, 'href5_img', '11'),
(790, 82, '_href5_img', 'field_5ed7951667192'),
(791, 82, 'href5', 'http://www.aze.in.ua/'),
(792, 82, '_href5', 'field_5ed79538bbaf6'),
(793, 82, 'href6', 'https://azerbaijan.az/ru'),
(794, 82, '_href6', 'field_5ed7966a1d301'),
(795, 82, 'href6_text', 'Азербайджан'),
(796, 82, '_href6_text', 'field_5ed7961d1aefe'),
(797, 82, 'href6_img', '80'),
(798, 82, '_href6_img', 'field_5ed7964853ce8'),
(799, 91, '_edit_lock', '1591195494:1');

-- --------------------------------------------------------

--
-- Структура таблицы `wp_posts`
--

CREATE TABLE `wp_posts` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `post_author` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `post_date` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_date_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_content` longtext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `post_title` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `post_excerpt` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `post_status` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'publish',
  `comment_status` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'open',
  `ping_status` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'open',
  `post_password` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `post_name` varchar(200) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `to_ping` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `pinged` text COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `post_modified` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_modified_gmt` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `post_content_filtered` longtext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `post_parent` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `guid` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `menu_order` int(11) NOT NULL DEFAULT '0',
  `post_type` varchar(20) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT 'post',
  `post_mime_type` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `comment_count` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_posts`
--

INSERT INTO `wp_posts` (`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`, `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`, `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`, `post_type`, `post_mime_type`, `comment_count`) VALUES
(1, 1, '2020-06-02 10:53:20', '2020-06-02 07:53:20', '<!-- wp:paragraph -->\n<p>Ласкаво просимо до WordPress. Це ваш перший запис. Редагуйте або видаліть, а потім починайте писати!</p>\n<!-- /wp:paragraph -->', 'Привіт, світ!', '', 'publish', 'open', 'open', '', '%d0%bf%d1%80%d0%b8%d0%b2%d1%96%d1%82-%d1%81%d0%b2%d1%96%d1%82', '', '', '2020-06-02 10:53:20', '2020-06-02 07:53:20', '', 0, 'http://algfond.com/?p=1', 0, 'post', '', 1),
(2, 1, '2020-06-02 10:53:20', '2020-06-02 07:53:20', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'publish', 'closed', 'open', '', 'sample-page', '', '', '2020-06-03 15:37:24', '2020-06-03 12:37:24', '', 0, 'http://algfond.com/?page_id=2', 0, 'page', '', 0),
(3, 1, '2020-06-02 10:53:20', '2020-06-02 07:53:20', '<!-- wp:heading --><h2>Хто ми</h2><!-- /wp:heading --><!-- wp:paragraph --><p>Наша адреса сайту: http://algfond.com.</p><!-- /wp:paragraph --><!-- wp:heading --><h2>Які особисті дані ми збираємо та чому ми їх збираємо</h2><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Коментарі</h3><!-- /wp:heading --><!-- wp:paragraph --><p>Коли відвідувачі залишають коментарі на сайті, ми збираємо дані, що відображаються у формі коментарів, а також IP-адреси відвідувачів та рядку агента-браузера користувача, щоб допомогти виявити спам.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Анонімний рядок, створений за вашою адресою електронної пошти (також називається хеш), може бути наданий службі Gravatar, щоб дізнатись, чи ви його використовуєте. Політика конфіденційності служби Gravatar доступна тут: https://automattic.com/privacy/. Після схвалення вашого коментаря, ваше зображення профілю буде видно для громадськості в контексті вашого коментарю.</p><!-- /wp:paragraph --><!-- wp:heading {"level":3} --><h3>Медіафайли</h3><!-- /wp:heading --><!-- wp:paragraph --><p>Якщо ви завантажуєте зображення на сайт, вам слід уникати завантаження зображень із вбудованими даними про місцезнаходження (EXIF GPS). Відвідувачі сайту можуть завантажувати та витягувати будь-які дані про місцезнаходження із зображень на сайті.</p><!-- /wp:paragraph --><!-- wp:heading {"level":3} --><h3>Контактні форми</h3><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Cookies</h3><!-- /wp:heading --><!-- wp:paragraph --><p>Якщо ви залишаєте коментар на нашому сайті, ви можете ввімкнути збереження свого імені, електронної адреси та сайту в файлах cookie. Це для вашої зручності, так що вам не потрібно буде повторно заповнювати ваші дані, коли ви залишатимете наступний коментар. Ці файли cookie зберігатимуться 1 рік.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Якщо у вас є обліковий запис на сайті і ви ввійдете в нього, ми встановимо тимчасовий cookie для визначення підтримки cookies вашим браузером, cookie не містить ніякої особистої інформації і віддаляється при закритті вашого браузера.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Коли ви ввійдете в систему, ми також встановимо декілька файлів cookie, щоб зберегти інформацію про ваш логін та налаштування екрана. Cookie-файли для входу зберігаються 2 дні, а файли cookie-файлів налаштувань екрану - 1 рік. Якщо ви виберете &quot;Запам\'ятати мене&quot;, ваш логін буде зберігатися протягом 2 тижнів. Якщо ви вийдете зі свого облікового запису, файли cookie логіну будуть видалені.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Якщо ви редагуєте або публікуєте статтю, у вашому веб-переглядачі буде збережений додатковий файл cookie. Цей файл cookie не містить особистих даних і просто вказує ідентифікатор статті, яку ви щойно редагували. Його термін дії закінчується через 1 день.</p><!-- /wp:paragraph --><!-- wp:heading {"level":3} --><h3>Вбудований вміст з інших веб-сайтів</h3><!-- /wp:heading --><!-- wp:paragraph --><p>Статті на цьому сайті можуть містити вбудований вміст (наприклад: відео, зображення, статті тощо). Вбудований вміст з інших сайтів веде себе так само, як би користувач відвідав інший сайт.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Ці сайти можуть збирати дані про вас, використовувати файли cookie, вбудовані додатки відстеження третіх сторін та стежити за вашою взаємодією з цим вбудованим вмістом. Зокрема відстежувати взаємодію з вбудованим вмістом, якщо у вас є обліковий запис і ви увійшли на цей сайт.</p><!-- /wp:paragraph --><!-- wp:heading {"level":3} --><h3>Аналітика</h3><!-- /wp:heading --><!-- wp:heading --><h2>З ким ми ділимося вашими даними</h2><!-- /wp:heading --><!-- wp:heading --><h2>Як довго ми зберігаємо ваші дані</h2><!-- /wp:heading --><!-- wp:paragraph --><p>Якщо ви залишаєте коментар, він та його метадані зберігаються протягом невизначеного терміну. Таким чином, ми можемо автоматично визначати та затверджувати кожен наступний коментар замість того, щоб тримати їх у черзі на модерації.</p><!-- /wp:paragraph --><!-- wp:paragraph --><p>Для користувачів, які реєструються на нашому сайті (якщо такі є), ми зберігаємо надану ними персональну інформацію у їхньому профілі користувача. Всі користувачі можуть переглядати, редагувати або видаляти свої особисті дані в будь-який час (за винятком того, що вони не можуть змінити своє ім\'я користувача). Адміністратори сайту також можуть переглядати та редагувати цю інформацію.</p><!-- /wp:paragraph --><!-- wp:heading --><h2>Які права ви маєте відносно своїх даних</h2><!-- /wp:heading --><!-- wp:paragraph --><p>Якщо у вас є обліковий запис на цьому сайті або ви залишили коментарі, ви можете подати запит на отримання експортованого файлу особистих даних які ми зберігаємо про вас, включаючи всі дані, які ви надали нам. Ви також можете вимагати, щоб ми стерли будь-які особисті дані, які ми маємо щодо вас. Це не включає будь-які дані, які ми зобов\'язані зберігати в адміністративних, правових та цілях безпеки.</p><!-- /wp:paragraph --><!-- wp:heading --><h2>Куди ми відправляємо ваші данні</h2><!-- /wp:heading --><!-- wp:paragraph --><p>Коментарі відвідувачів можуть бути перевірені за допомогою служби автоматичного виявлення спаму.</p><!-- /wp:paragraph --><!-- wp:heading --><h2>Ваша контактна інформація</h2><!-- /wp:heading --><!-- wp:heading --><h2>Додаткова інформація</h2><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Як ми захищаємо ваші данні</h3><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Які процедури проти втрати даних ми використовуємо</h3><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Від яких третіх сторін ми отримуємо дані</h3><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Яке автоматичне рішення приймається  і/або профілювання ми робимо з користувацькими даними</h3><!-- /wp:heading --><!-- wp:heading {"level":3} --><h3>Вимоги до розкриття галузевих нормативних вимог</h3><!-- /wp:heading -->', 'Політика конфіденційності', '', 'draft', 'closed', 'open', '', 'privacy-policy', '', '', '2020-06-02 10:53:20', '2020-06-02 07:53:20', '', 0, 'http://algfond.com/?page_id=3', 0, 'page', '', 0),
(4, 1, '2020-06-02 10:54:09', '0000-00-00 00:00:00', '', 'Авточернетка', '', 'auto-draft', 'open', 'open', '', '', '', '', '2020-06-02 10:54:09', '0000-00-00 00:00:00', '', 0, 'http://algfond.com/?p=4', 0, 'post', '', 0),
(5, 1, '2020-06-02 16:55:50', '0000-00-00 00:00:00', '{\n    "blogdescription": {\n        "value": "\\u0410\\u0437\\u0435\\u0440\\u0431\\u0430\\u0439\\u0434\\u0436\\u0430\\u043d\\u0441\\u043a\\u0438\\u0439 \\u043a\\u0443\\u043b\\u044c\\u0442\\u0443\\u0440\\u043d\\u043e-\\u043e\\u0431\\u0449\\u0435\\u0441\\u0442\\u0432\\u0435\\u043d\\u043d\\u044b\\u0439 \\u0446\\u0435\\u043d\\u0442\\u0440. \\u0421\\u043e\\u0431\\u044b\\u0442\\u0438\\u044f \\u0446\\u0435\\u043d\\u0442\\u0440\\u0430. \\u041a\\u043e\\u043d\\u0442\\u0430\\u043a\\u0442\\u044b.",\n        "type": "option",\n        "user_id": 1,\n        "date_modified_gmt": "2020-06-02 13:51:11"\n    },\n    "site_icon": {\n        "value": 7,\n        "type": "option",\n        "user_id": 1,\n        "date_modified_gmt": "2020-06-02 13:55:50"\n    }\n}', '', '', 'auto-draft', 'closed', 'closed', '', '78b6d80d-580b-4296-961b-fd7855910b0e', '', '', '2020-06-02 16:55:50', '2020-06-02 13:55:50', '', 0, 'http://algfond.com/?p=5', 0, 'customize_changeset', '', 0),
(6, 1, '2020-06-02 16:54:52', '2020-06-02 13:54:52', '', 'Логотип', '', 'inherit', 'open', 'closed', '', 'big_logo_', '', '', '2020-06-02 18:15:31', '2020-06-02 15:15:31', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/big_logo_.png', 0, 'attachment', 'image/png', 0),
(7, 1, '2020-06-02 16:55:13', '2020-06-02 13:55:13', 'http://algfond.com/wp-content/uploads/2020/06/cropped-big_logo_.png', 'cropped-big_logo_.png', '', 'inherit', 'open', 'closed', '', 'cropped-big_logo_-png', '', '', '2020-06-02 16:55:13', '2020-06-02 13:55:13', '', 0, 'http://algfond.com/wp-content/uploads/2020/06/cropped-big_logo_.png', 0, 'attachment', 'image/png', 0),
(8, 1, '2020-06-02 16:57:14', '2020-06-02 13:57:14', 'http://algfond.com/wp-content/uploads/2020/06/cropped-big_logo_-1.png', 'cropped-big_logo_-1.png', '', 'inherit', 'open', 'closed', '', 'cropped-big_logo_-1-png', '', '', '2020-06-02 16:57:14', '2020-06-02 13:57:14', '', 0, 'http://algfond.com/wp-content/uploads/2020/06/cropped-big_logo_-1.png', 0, 'attachment', 'image/png', 0),
(9, 1, '2020-06-02 16:57:58', '2020-06-02 13:57:58', '{\n    "blogdescription": {\n        "value": "\\u0410\\u0437\\u0435\\u0440\\u0431\\u0430\\u0439\\u0434\\u0436\\u0430\\u043d\\u0441\\u043a\\u0438\\u0439 \\u043a\\u0443\\u043b\\u044c\\u0442\\u0443\\u0440\\u043d\\u043e-\\u043e\\u0431\\u0449\\u0435\\u0441\\u0442\\u0432\\u0435\\u043d\\u043d\\u044b\\u0439 \\u0446\\u0435\\u043d\\u0442\\u0440 \\u041b\\u0443\\u0433\\u0430\\u043d\\u0441\\u043a\\u043e\\u0439 \\u043e\\u0431\\u043b\\u0430\\u0441\\u0442\\u0438. \\u0421\\u043e\\u0431\\u044b\\u0442\\u0438\\u044f, \\u043a\\u043e\\u043d\\u0442\\u0430\\u043a\\u0442\\u044b, \\u043f\\u0430\\u0440\\u0442\\u043d\\u0435\\u0440\\u044b ",\n        "type": "option",\n        "user_id": 1,\n        "date_modified_gmt": "2020-06-02 13:57:58"\n    },\n    "site_icon": {\n        "value": 8,\n        "type": "option",\n        "user_id": 1,\n        "date_modified_gmt": "2020-06-02 13:57:58"\n    }\n}', '', '', 'trash', 'closed', 'closed', '', '6724a9da-04ab-4278-bfe5-40e0195ddab5', '', '', '2020-06-02 16:57:58', '2020-06-02 13:57:58', '', 0, 'http://algfond.com/?p=9', 0, 'customize_changeset', '', 0),
(11, 1, '2020-06-02 17:01:57', '2020-06-02 14:01:57', '', 'aze', '', 'inherit', 'open', 'closed', '', 'aze', '', '', '2020-06-03 15:20:42', '2020-06-03 12:20:42', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/aze.png', 0, 'attachment', 'image/png', 0),
(12, 1, '2020-06-02 17:02:18', '0000-00-00 00:00:00', '{\n    "site_icon": {\n        "value": 11,\n        "type": "option",\n        "user_id": 1,\n        "date_modified_gmt": "2020-06-02 14:02:18"\n    }\n}', '', '', 'auto-draft', 'closed', 'closed', '', '78663c72-298c-4496-bef9-6988fad72ae1', '', '', '2020-06-02 17:02:18', '0000-00-00 00:00:00', '', 0, 'http://algfond.com/?p=12', 0, 'customize_changeset', '', 0),
(13, 1, '2020-06-02 17:49:13', '2020-06-02 14:49:13', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Главная - большое лого и название сайта', '%d0%b3%d0%bb%d0%b0%d0%b2%d0%bd%d0%b0%d1%8f-%d0%b1%d0%be%d0%bb%d1%8c%d1%88%d0%be%d0%b5-%d0%bb%d0%be%d0%b3%d0%be-%d0%b8-%d0%bd%d0%b0%d0%b7%d0%b2%d0%b0%d0%bd%d0%b8%d0%b5-%d1%81%d0%b0%d0%b9%d1%82%d0%b0', 'publish', 'closed', 'closed', '', 'group_5ed6644f25708', '', '', '2020-06-03 16:43:09', '2020-06-03 13:43:09', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=13', 0, 'acf-field-group', '', 0),
(14, 1, '2020-06-02 17:49:13', '2020-06-02 14:49:13', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:133:"Картинка должна быть круглой или квадратной. Ее размер задан программно.";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:12:"img_big_logo";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:6:"medium";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Картинка-лого', 'img_big_logo', 'publish', 'closed', 'closed', '', 'field_5ed664e315b8e', '', '', '2020-06-03 16:43:09', '2020-06-03 13:43:09', '', 13, 'http://algfond.com/?post_type=acf-field&#038;p=14', 1, 'acf-field', '', 0),
(15, 1, '2020-06-02 17:49:13', '2020-06-02 14:49:13', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:153:"Дублируем сюда название сайта. Не желательно при изменении вводить длинные надписи";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:85:"Азербайджанский культурно-общественный центр";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Подпись под картинкой (название сайта)', 'title_slider', 'publish', 'closed', 'closed', '', 'field_5ed6663815b8f', '', '', '2020-06-03 16:43:09', '2020-06-03 13:43:09', '', 13, 'http://algfond.com/?post_type=acf-field&#038;p=15', 2, 'acf-field', '', 0),
(16, 1, '2020-06-02 17:52:46', '2020-06-02 14:52:46', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Слайдер на главной странице', '%d1%81%d0%bb%d0%b0%d0%b9%d0%b4%d0%b5%d1%80-%d0%bd%d0%b0-%d0%b3%d0%bb%d0%b0%d0%b2%d0%bd%d0%be%d0%b9-%d1%81%d1%82%d1%80%d0%b0%d0%bd%d0%b8%d1%86%d0%b5', 'publish', 'closed', 'closed', '', 'group_5ed666f1a0d03', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=16', 0, 'acf-field-group', '', 0),
(17, 1, '2020-06-02 17:52:46', '2020-06-02 14:52:46', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:202:"Изначально картинка должна иметь соотношение 1920:1233 (ширина:высота) - чтобы в слайдере они отражались нормально";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд1', 'slider_im1', 'publish', 'closed', 'closed', '', 'field_5ed66701020de', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=17', 1, 'acf-field', '', 0),
(18, 1, '2020-06-02 17:52:46', '2020-06-02 14:52:46', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд2', 'slider_im2', 'publish', 'closed', 'closed', '', 'field_5ed66779020df', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=18', 2, 'acf-field', '', 0),
(19, 1, '2020-06-02 17:52:46', '2020-06-02 14:52:46', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд3', 'slider_im3', 'publish', 'closed', 'closed', '', 'field_5ed6679b020e0', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=19', 3, 'acf-field', '', 0),
(20, 1, '2020-06-02 17:57:37', '2020-06-02 14:57:37', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Миссия', '%d0%bc%d0%b8%d1%81%d1%81%d0%b8%d1%8f', 'publish', 'closed', 'closed', '', 'group_5ed66825693e4', '', '', '2020-06-03 16:47:10', '2020-06-03 13:47:10', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=20', 0, 'acf-field-group', '', 0),
(21, 1, '2020-06-02 17:57:37', '2020-06-02 14:57:37', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:0:"";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Заголовок', 'mission_zag', 'publish', 'closed', 'closed', '', 'field_5ed6684440122', '', '', '2020-06-03 16:47:10', '2020-06-03 13:47:10', '', 20, 'http://algfond.com/?post_type=acf-field&#038;p=21', 1, 'acf-field', '', 0),
(22, 1, '2020-06-02 17:57:37', '2020-06-02 14:57:37', 'a:10:{s:4:"type";s:8:"textarea";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:141:"Мы делаем Азербайджан ближе к украинскому народу, а Украину к азербайджанцам";s:11:"placeholder";s:0:"";s:9:"maxlength";s:0:"";s:4:"rows";s:0:"";s:9:"new_lines";s:2:"br";}', 'Миссия - текстовая область', 'mission_text', 'publish', 'closed', 'closed', '', 'field_5ed668a040123', '', '', '2020-06-03 16:47:10', '2020-06-03 13:47:10', '', 20, 'http://algfond.com/?post_type=acf-field&#038;p=22', 2, 'acf-field', '', 0),
(23, 1, '2020-06-02 18:01:31', '2020-06-02 15:01:31', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Кто мы', '%d0%ba%d1%82%d0%be-%d0%bc%d1%8b', 'publish', 'closed', 'closed', '', 'group_5ed668fdc22cc', '', '', '2020-06-03 16:46:18', '2020-06-03 13:46:18', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=23', 0, 'acf-field-group', '', 0),
(24, 1, '2020-06-02 18:01:31', '2020-06-02 15:01:31', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:12:"Кто мы:";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Заголовок раздела', 'kto_mi_zag', 'publish', 'closed', 'closed', '', 'field_5ed6691c28ec6', '', '', '2020-06-03 16:46:18', '2020-06-03 13:46:18', '', 23, 'http://algfond.com/?post_type=acf-field&#038;p=24', 1, 'acf-field', '', 0),
(25, 1, '2020-06-02 18:01:31', '2020-06-02 15:01:31', 'a:10:{s:4:"type";s:8:"textarea";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:874:"Мы азербайджанцы Луганщины, которые любят обе своих Родины, желают им мира и процветания, гордятся их культурами. 				\r\nНаша цель сделать две в чём-то разных, а в чём-то похожих страны, не имеющих общей границы, но много общих интересов, немного ближе друг к другу. 		\r\nНам есть чем поделиться друг с другом и взаимодополнить два древних народа, поэтому мы создаём условия для взаимопроникновения наших культур, диалога между общественностью, наукой и бизнесом Азербайджана и Украины.";s:11:"placeholder";s:0:"";s:9:"maxlength";s:0:"";s:4:"rows";i:15;s:9:"new_lines";s:2:"br";}', 'Кто мы - описание раздела', 'kto_mi_opis', 'publish', 'closed', 'closed', '', 'field_5ed6695928ec7', '', '', '2020-06-03 16:46:18', '2020-06-03 13:46:18', '', 23, 'http://algfond.com/?post_type=acf-field&#038;p=25', 2, 'acf-field', '', 0),
(27, 1, '2020-06-02 18:13:50', '2020-06-02 15:13:50', '', 'az1', '', 'inherit', 'open', 'closed', '', 'az1', '', '', '2020-06-02 18:13:50', '2020-06-02 15:13:50', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az1.jpg', 0, 'attachment', 'image/jpeg', 0),
(28, 1, '2020-06-02 18:14:02', '2020-06-02 15:14:02', '', 'az2', '', 'inherit', 'open', 'closed', '', 'az2', '', '', '2020-06-02 18:14:02', '2020-06-02 15:14:02', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az2.jpg', 0, 'attachment', 'image/jpeg', 0),
(29, 1, '2020-06-02 18:14:05', '2020-06-02 15:14:05', '', 'az3', '', 'inherit', 'open', 'closed', '', 'az3', '', '', '2020-06-02 18:14:05', '2020-06-02 15:14:05', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az3.jpg', 0, 'attachment', 'image/jpeg', 0),
(30, 1, '2020-06-02 18:14:09', '2020-06-02 15:14:09', '', 'az4', '', 'inherit', 'open', 'closed', '', 'az4', '', '', '2020-06-02 18:14:09', '2020-06-02 15:14:09', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az4.jpg', 0, 'attachment', 'image/jpeg', 0),
(31, 1, '2020-06-02 18:14:12', '2020-06-02 15:14:12', '', 'az5', '', 'inherit', 'open', 'closed', '', 'az5', '', '', '2020-06-02 18:14:12', '2020-06-02 15:14:12', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az5.jpg', 0, 'attachment', 'image/jpeg', 0),
(32, 1, '2020-06-02 18:14:15', '2020-06-02 15:14:15', '', 'az6', '', 'inherit', 'open', 'closed', '', 'az6', '', '', '2020-06-02 18:14:15', '2020-06-02 15:14:15', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az6.jpg', 0, 'attachment', 'image/jpeg', 0),
(33, 1, '2020-06-02 18:14:18', '2020-06-02 15:14:18', '', 'az7', '', 'inherit', 'open', 'closed', '', 'az7', '', '', '2020-06-02 18:14:18', '2020-06-02 15:14:18', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/az7.jpg', 0, 'attachment', 'image/jpeg', 0),
(34, 1, '2020-06-02 18:15:28', '2020-06-02 15:15:28', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 18:15:28', '2020-06-02 15:15:28', '', 2, 'http://algfond.com/?p=34', 0, 'revision', '', 0),
(35, 1, '2020-06-02 18:15:31', '2020-06-02 15:15:31', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 18:15:31', '2020-06-02 15:15:31', '', 2, 'http://algfond.com/?p=35', 0, 'revision', '', 0),
(36, 1, '2020-06-02 18:22:26', '2020-06-02 15:22:26', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 18:22:26', '2020-06-02 15:22:26', '', 2, 'http://algfond.com/?p=36', 0, 'revision', '', 0),
(37, 1, '2020-06-02 18:45:42', '2020-06-02 15:45:42', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд4', 'slider_im4', 'publish', 'closed', 'closed', '', 'field_5ed66fa67947a', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=37', 4, 'acf-field', '', 0),
(38, 1, '2020-06-02 18:45:42', '2020-06-02 15:45:42', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд5', 'slider_im5', 'publish', 'closed', 'closed', '', 'field_5ed673b87947b', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=38', 5, 'acf-field', '', 0),
(39, 1, '2020-06-02 18:45:42', '2020-06-02 15:45:42', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд6', 'slider_im6', 'publish', 'closed', 'closed', '', 'field_5ed673dc7947c', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=39', 6, 'acf-field', '', 0),
(40, 1, '2020-06-02 18:45:42', '2020-06-02 15:45:42', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Слайд7', 'slider_im7', 'publish', 'closed', 'closed', '', 'field_5ed673fc7947d', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=40', 7, 'acf-field', '', 0),
(41, 1, '2020-06-02 18:47:46', '2020-06-02 15:47:46', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 18:47:46', '2020-06-02 15:47:46', '', 2, 'http://algfond.com/?p=41', 0, 'revision', '', 0),
(42, 1, '2020-06-02 18:54:51', '2020-06-02 15:54:51', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Главная - малый логотип в меню', '%d0%b3%d0%bb%d0%b0%d0%b2%d0%bd%d0%b0%d1%8f-%d0%bc%d0%b0%d0%bb%d1%8b%d0%b9-%d0%bb%d0%be%d0%b3%d0%be%d1%82%d0%b8%d0%bf-%d0%b2-%d0%bc%d0%b5%d0%bd%d1%8e', 'publish', 'closed', 'closed', '', 'group_5ed675cb324be', '', '', '2020-06-03 16:44:07', '2020-06-03 13:44:07', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=42', 0, 'acf-field-group', '', 0),
(43, 1, '2020-06-02 18:54:51', '2020-06-02 15:54:51', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:59:"Картинка шириной 70px и высотой 30px";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Логотип в меню', 'menu_logo_img', 'publish', 'closed', 'closed', '', 'field_5ed675d9d7af0', '', '', '2020-06-03 16:44:07', '2020-06-03 13:44:07', '', 42, 'http://algfond.com/?post_type=acf-field&#038;p=43', 1, 'acf-field', '', 0),
(44, 1, '2020-06-02 18:57:30', '2020-06-02 15:57:30', '', 'logo_mini', '', 'inherit', 'open', 'closed', '', 'logo_mini', '', '', '2020-06-02 18:57:46', '2020-06-02 15:57:46', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/logo_mini.jpg', 0, 'attachment', 'image/jpeg', 0),
(45, 1, '2020-06-02 18:57:51', '2020-06-02 15:57:51', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 18:57:51', '2020-06-02 15:57:51', '', 2, 'http://algfond.com/?p=45', 0, 'revision', '', 0),
(46, 1, '2020-06-02 19:04:14', '2020-06-02 16:04:14', 'a:7:{s:8:"location";a:1:{i:0;a:1:{i:0;a:3:{s:5:"param";s:9:"page_type";s:8:"operator";s:2:"==";s:5:"value";s:10:"front_page";}}}s:8:"position";s:6:"normal";s:5:"style";s:7:"default";s:15:"label_placement";s:3:"top";s:21:"instruction_placement";s:5:"label";s:14:"hide_on_screen";s:0:"";s:11:"description";s:0:"";}', 'Главная - ссылки на сайты об Азербайджане', '%d0%b3%d0%bb%d0%b0%d0%b2%d0%bd%d0%b0%d1%8f-%d1%81%d1%81%d1%8b%d0%bb%d0%ba%d0%b8-%d0%bd%d0%b0-%d1%81%d0%b0%d0%b9%d1%82%d1%8b-%d0%be%d0%b1-%d0%b0%d0%b7%d0%b5%d1%80%d0%b1%d0%b0%d0%b9%d0%b4%d0%b6%d0%b0', 'publish', 'closed', 'closed', '', 'group_5ed67728066d0', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 0, 'http://algfond.com/?post_type=acf-field-group&#038;p=46', 0, 'acf-field-group', '', 0),
(47, 1, '2020-06-02 19:04:14', '2020-06-02 16:04:14', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:42:"Больше об Азербайджане";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Заголовок', 'zag_azer', 'publish', 'closed', 'closed', '', 'field_5ed67754a1fe0', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=47', 1, 'acf-field', '', 0),
(48, 1, '2020-06-02 19:04:14', '2020-06-02 16:04:14', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:54:"Сайт президента Азербайджана";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Первая ссылка - заголовок', 'href1_text', 'publish', 'closed', 'closed', '', 'field_5ed67790a1fe1', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=48', 2, 'acf-field', '', 0),
(49, 1, '2020-06-02 19:04:14', '2020-06-02 16:04:14', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Первая ссылка - картинка', 'href1_img', 'publish', 'closed', 'closed', '', 'field_5ed677f1a1fe2', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=49', 3, 'acf-field', '', 0),
(50, 1, '2020-06-02 19:04:14', '2020-06-02 16:04:14', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:24:"https://ru.president.az/";s:11:"placeholder";s:0:"";}', 'Первая ссылка - ссылка', 'href1', 'publish', 'closed', 'closed', '', 'field_5ed67830a1fe3', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=50', 4, 'acf-field', '', 0),
(51, 1, '2020-06-02 19:05:17', '2020-06-02 16:05:17', '', 'prezident', '', 'inherit', 'open', 'closed', '', 'prezident', '', '', '2020-06-02 19:05:42', '2020-06-02 16:05:42', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/prezident.png', 0, 'attachment', 'image/png', 0),
(52, 1, '2020-06-02 19:05:58', '2020-06-02 16:05:58', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-02 19:05:58', '2020-06-02 16:05:58', '', 2, 'http://algfond.com/?p=52', 0, 'revision', '', 0),
(54, 1, '2020-06-03 13:56:46', '2020-06-03 10:56:46', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:106:"Aзербайджанское государственное информационное агенство";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Вторая ссылка - заголовок', 'href2_text', 'publish', 'closed', 'closed', '', 'field_5ed781c767fc3', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=54', 5, 'acf-field', '', 0),
(55, 1, '2020-06-03 13:57:20', '2020-06-03 10:57:20', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Вторая ссылка - картинка', 'href2_img', 'publish', 'closed', 'closed', '', 'field_5ed781fb0aa6b', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=55', 6, 'acf-field', '', 0),
(56, 1, '2020-06-03 13:58:13', '2020-06-03 10:58:13', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:22:"https://azertag.az/ru/";s:11:"placeholder";s:0:"";}', 'Вторая ссылка - ссылка', 'href2', 'publish', 'closed', 'closed', '', 'field_5ed7821c9d3c9', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=56', 7, 'acf-field', '', 0),
(57, 1, '2020-06-03 14:01:24', '2020-06-03 11:01:24', '', 'atac', '', 'inherit', 'open', 'closed', '', 'atac', '', '', '2020-06-03 14:01:24', '2020-06-03 11:01:24', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/atac.png', 0, 'attachment', 'image/png', 0),
(58, 1, '2020-06-03 14:34:35', '2020-06-03 11:34:35', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 14:34:35', '2020-06-03 11:34:35', '', 2, 'http://algfond.com/?p=58', 0, 'revision', '', 0),
(59, 1, '2020-06-03 14:39:12', '2020-06-03 11:39:12', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:35:"Nizami Ganjavi International Center";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Третья ссылка - заголовок', 'href3_text', 'publish', 'closed', 'closed', '', 'field_5ed78bbeb317d', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=59', 8, 'acf-field', '', 0),
(60, 1, '2020-06-03 14:53:30', '2020-06-03 11:53:30', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Третья ссылка - картинка', 'href3_img', 'publish', 'closed', 'closed', '', 'field_5ed78bee72c8e', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=60', 9, 'acf-field', '', 0),
(61, 1, '2020-06-03 14:54:36', '2020-06-03 11:54:36', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:43:"https://www.nizamiganjavi-ic.org/index.html";s:11:"placeholder";s:0:"";}', 'Третья ссылка - ссылка', 'href3', 'publish', 'closed', 'closed', '', 'field_5ed78f51e466c', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=61', 10, 'acf-field', '', 0),
(62, 1, '2020-06-03 14:55:57', '2020-06-03 11:55:57', '', 'nizami', '', 'inherit', 'open', 'closed', '', 'nizami', '', '', '2020-06-03 14:55:57', '2020-06-03 11:55:57', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/nizami.png', 0, 'attachment', 'image/png', 0),
(63, 1, '2020-06-03 14:56:12', '2020-06-03 11:56:12', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 14:56:12', '2020-06-03 11:56:12', '', 2, 'http://algfond.com/?p=63', 0, 'revision', '', 0),
(64, 1, '2020-06-03 14:59:53', '2020-06-03 11:59:53', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 14:59:53', '2020-06-03 11:59:53', '', 2, 'http://algfond.com/?p=64', 0, 'revision', '', 0),
(65, 1, '2020-06-03 15:04:16', '2020-06-03 12:04:16', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:04:16', '2020-06-03 12:04:16', '', 2, 'http://algfond.com/?p=65', 0, 'revision', '', 0),
(66, 1, '2020-06-03 15:07:33', '2020-06-03 12:07:33', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:46:"Союз азербайджанцев мира";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Четвертая ссылка - заголовок', 'href4_text', 'publish', 'closed', 'closed', '', 'field_5ed7925a05902', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=66', 11, 'acf-field', '', 0),
(67, 1, '2020-06-03 15:08:15', '2020-06-03 12:08:15', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Четвертая ссылка - картинка', 'href4_img', 'publish', 'closed', 'closed', '', 'field_5ed79295da01e', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=67', 12, 'acf-field', '', 0),
(68, 1, '2020-06-03 15:09:16', '2020-06-03 12:09:16', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:22:"http://azunion.org/ru/";s:11:"placeholder";s:0:"";}', 'Четвертая ссылка - ссылка', 'href4', 'publish', 'closed', 'closed', '', 'field_5ed792c29bbbd', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=68', 13, 'acf-field', '', 0),
(69, 1, '2020-06-03 15:14:09', '2020-06-03 12:14:09', '', 'Союз азербайджанцев мира', '', 'inherit', 'open', 'closed', '', 'sam', '', '', '2020-06-03 15:14:43', '2020-06-03 12:14:43', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/sam.png', 0, 'attachment', 'image/png', 0),
(70, 1, '2020-06-03 15:14:49', '2020-06-03 12:14:49', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:14:49', '2020-06-03 12:14:49', '', 2, 'http://algfond.com/?p=70', 0, 'revision', '', 0),
(71, 1, '2020-06-03 15:16:26', '2020-06-03 12:16:26', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:16:26', '2020-06-03 12:16:26', '', 2, 'http://algfond.com/?p=71', 0, 'revision', '', 0),
(72, 1, '2020-06-03 15:18:17', '2020-06-03 12:18:17', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:78:"Об\'єднана діаспора азербайджанців України";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Пятая ссылка - заголовок', 'href5_text', 'publish', 'closed', 'closed', '', 'field_5ed794e0c71b5', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=72', 14, 'acf-field', '', 0),
(73, 1, '2020-06-03 15:18:51', '2020-06-03 12:18:51', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Пятая ссылка - картинка', 'href5_img', 'publish', 'closed', 'closed', '', 'field_5ed7951667192', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=73', 15, 'acf-field', '', 0),
(74, 1, '2020-06-03 15:19:37', '2020-06-03 12:19:37', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:21:"http://www.aze.in.ua/";s:11:"placeholder";s:0:"";}', 'Пятая ссылка - ссылка', 'href5', 'publish', 'closed', 'closed', '', 'field_5ed79538bbaf6', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=74', 16, 'acf-field', '', 0),
(75, 1, '2020-06-03 15:20:42', '2020-06-03 12:20:42', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:20:42', '2020-06-03 12:20:42', '', 2, 'http://algfond.com/?p=75', 0, 'revision', '', 0),
(76, 1, '2020-06-03 15:21:47', '2020-06-03 12:21:47', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:21:47', '2020-06-03 12:21:47', '', 2, 'http://algfond.com/?p=76', 0, 'revision', '', 0),
(77, 1, '2020-06-03 15:23:23', '2020-06-03 12:23:23', 'a:10:{s:4:"type";s:4:"text";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:22:"Азербайджан";s:11:"placeholder";s:0:"";s:7:"prepend";s:0:"";s:6:"append";s:0:"";s:9:"maxlength";s:0:"";}', 'Шестая ссылка - заголовок', 'href6_text', 'publish', 'closed', 'closed', '', 'field_5ed7961d1aefe', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=77', 17, 'acf-field', '', 0),
(78, 1, '2020-06-03 15:23:57', '2020-06-03 12:23:57', 'a:15:{s:4:"type";s:5:"image";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"return_format";s:3:"url";s:12:"preview_size";s:4:"full";s:7:"library";s:3:"all";s:9:"min_width";s:0:"";s:10:"min_height";s:0:"";s:8:"min_size";s:0:"";s:9:"max_width";s:0:"";s:10:"max_height";s:0:"";s:8:"max_size";s:0:"";s:10:"mime_types";s:0:"";}', 'Шестая ссылка - картинка', 'href6_img', 'publish', 'closed', 'closed', '', 'field_5ed7964853ce8', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=78', 18, 'acf-field', '', 0),
(79, 1, '2020-06-03 15:24:41', '2020-06-03 12:24:41', 'a:7:{s:4:"type";s:3:"url";s:12:"instructions";s:0:"";s:8:"required";i:1;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:13:"default_value";s:24:"https://azerbaijan.az/ru";s:11:"placeholder";s:0:"";}', 'Шестая ссылка - ссылка', 'href6', 'publish', 'closed', 'closed', '', 'field_5ed7966a1d301', '', '', '2020-06-03 16:45:10', '2020-06-03 13:45:10', '', 46, 'http://algfond.com/?post_type=acf-field&#038;p=79', 19, 'acf-field', '', 0),
(80, 1, '2020-06-03 15:26:13', '2020-06-03 12:26:13', '', 'Сайт Азербайджан', '', 'inherit', 'open', 'closed', '', 'flag', '', '', '2020-06-03 15:35:02', '2020-06-03 12:35:02', '', 2, 'http://algfond.com/wp-content/uploads/2020/06/flag.png', 0, 'attachment', 'image/png', 0),
(81, 1, '2020-06-03 15:35:11', '2020-06-03 12:35:11', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:35:11', '2020-06-03 12:35:11', '', 2, 'http://algfond.com/?p=81', 0, 'revision', '', 0),
(82, 1, '2020-06-03 15:37:24', '2020-06-03 12:37:24', '<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->\n\n<!-- wp:paragraph -->\n<p></p>\n<!-- /wp:paragraph -->', 'Главная', '', 'inherit', 'closed', 'closed', '', '2-revision-v1', '', '', '2020-06-03 15:37:24', '2020-06-03 12:37:24', '', 2, 'http://algfond.com/?p=82', 0, 'revision', '', 0),
(84, 1, '2020-06-03 16:41:47', '0000-00-00 00:00:00', '', 'Черновик', '', 'auto-draft', 'closed', 'closed', '', '', '', '', '2020-06-03 16:41:47', '0000-00-00 00:00:00', '', 0, 'http://algfond.com/?post_type=acf-field-group&p=84', 0, 'acf-field-group', '', 0),
(85, 1, '2020-06-03 16:43:09', '2020-06-03 13:43:09', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Большое лого и название сайта', 'big_logo', 'publish', 'closed', 'closed', '', 'field_5ed7a8bf6adc1', '', '', '2020-06-03 16:43:09', '2020-06-03 13:43:09', '', 13, 'http://algfond.com/?post_type=acf-field&p=85', 0, 'acf-field', '', 0),
(86, 1, '2020-06-03 16:44:07', '2020-06-03 13:44:07', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Логотип в меню', 'логотип_в_меню', 'publish', 'closed', 'closed', '', 'field_5ed7a90a69ae5', '', '', '2020-06-03 16:44:07', '2020-06-03 13:44:07', '', 42, 'http://algfond.com/?post_type=acf-field&p=86', 0, 'acf-field', '', 0),
(87, 1, '2020-06-03 16:45:09', '2020-06-03 13:45:09', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Ссылки на сайты', 'ссылки_на_сайты', 'publish', 'closed', 'closed', '', 'field_5ed7a9377f3bf', '', '', '2020-06-03 16:45:09', '2020-06-03 13:45:09', '', 46, 'http://algfond.com/?post_type=acf-field&p=87', 0, 'acf-field', '', 0),
(88, 1, '2020-06-03 16:45:39', '2020-06-03 13:45:39', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Кто мы', 'кто_мы', 'publish', 'closed', 'closed', '', 'field_5ed7a97199136', '', '', '2020-06-03 16:46:18', '2020-06-03 13:46:18', '', 23, 'http://algfond.com/?post_type=acf-field&#038;p=88', 0, 'acf-field', '', 0),
(89, 1, '2020-06-03 16:46:47', '2020-06-03 13:46:47', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Миссия', 'миссия', 'publish', 'closed', 'closed', '', 'field_5ed7a9b5a8cf2', '', '', '2020-06-03 16:47:10', '2020-06-03 13:47:10', '', 20, 'http://algfond.com/?post_type=acf-field&#038;p=89', 0, 'acf-field', '', 0);
INSERT INTO `wp_posts` (`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`, `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`, `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`, `post_type`, `post_mime_type`, `comment_count`) VALUES
(90, 1, '2020-06-03 16:47:52', '2020-06-03 13:47:52', 'a:7:{s:4:"type";s:3:"tab";s:12:"instructions";s:0:"";s:8:"required";i:0;s:17:"conditional_logic";i:0;s:7:"wrapper";a:3:{s:5:"width";s:0:"";s:5:"class";s:0:"";s:2:"id";s:0:"";}s:9:"placement";s:3:"top";s:8:"endpoint";i:1;}', 'Слайдер', 'слайдер', 'publish', 'closed', 'closed', '', 'field_5ed7a9efb06e8', '', '', '2020-06-03 16:48:11', '2020-06-03 13:48:11', '', 16, 'http://algfond.com/?post_type=acf-field&#038;p=90', 0, 'acf-field', '', 0),
(91, 1, '2020-06-03 17:17:41', '0000-00-00 00:00:00', '', 'Черновик', '', 'auto-draft', 'open', 'open', '', '', '', '', '2020-06-03 17:17:41', '0000-00-00 00:00:00', '', 0, 'http://algfond.com/?p=91', 0, 'post', '', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `wp_termmeta`
--

CREATE TABLE `wp_termmeta` (
  `meta_id` bigint(20) UNSIGNED NOT NULL,
  `term_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `meta_key` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `meta_value` longtext COLLATE utf8mb4_unicode_520_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

-- --------------------------------------------------------

--
-- Структура таблицы `wp_terms`
--

CREATE TABLE `wp_terms` (
  `term_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(200) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `slug` varchar(200) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `term_group` bigint(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_terms`
--

INSERT INTO `wp_terms` (`term_id`, `name`, `slug`, `term_group`) VALUES
(1, 'Без категорії', '%d0%b1%d0%b5%d0%b7-%d0%ba%d0%b0%d1%82%d0%b5%d0%b3%d0%be%d1%80%d1%96%d1%97', 0),
(2, 'Слайдер', 'slider', 0),
(3, 'Ссылки', 'hrefs', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `wp_term_relationships`
--

CREATE TABLE `wp_term_relationships` (
  `object_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `term_taxonomy_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `term_order` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_term_relationships`
--

INSERT INTO `wp_term_relationships` (`object_id`, `term_taxonomy_id`, `term_order`) VALUES
(1, 1, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `wp_term_taxonomy`
--

CREATE TABLE `wp_term_taxonomy` (
  `term_taxonomy_id` bigint(20) UNSIGNED NOT NULL,
  `term_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `taxonomy` varchar(32) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `description` longtext COLLATE utf8mb4_unicode_520_ci NOT NULL,
  `parent` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `count` bigint(20) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_term_taxonomy`
--

INSERT INTO `wp_term_taxonomy` (`term_taxonomy_id`, `term_id`, `taxonomy`, `description`, `parent`, `count`) VALUES
(1, 1, 'category', '', 0, 1),
(2, 2, 'category', '', 0, 0),
(3, 3, 'category', '', 0, 0);

-- --------------------------------------------------------

--
-- Структура таблицы `wp_usermeta`
--

CREATE TABLE `wp_usermeta` (
  `umeta_id` bigint(20) UNSIGNED NOT NULL,
  `user_id` bigint(20) UNSIGNED NOT NULL DEFAULT '0',
  `meta_key` varchar(255) COLLATE utf8mb4_unicode_520_ci DEFAULT NULL,
  `meta_value` longtext COLLATE utf8mb4_unicode_520_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_usermeta`
--

INSERT INTO `wp_usermeta` (`umeta_id`, `user_id`, `meta_key`, `meta_value`) VALUES
(1, 1, 'nickname', 'arif'),
(2, 1, 'first_name', ''),
(3, 1, 'last_name', ''),
(4, 1, 'description', ''),
(5, 1, 'rich_editing', 'true'),
(6, 1, 'syntax_highlighting', 'true'),
(7, 1, 'comment_shortcuts', 'false'),
(8, 1, 'admin_color', 'fresh'),
(9, 1, 'use_ssl', '0'),
(10, 1, 'show_admin_bar_front', 'true'),
(11, 1, 'locale', ''),
(12, 1, 'wp_capabilities', 'a:1:{s:13:"administrator";b:1;}'),
(13, 1, 'wp_user_level', '10'),
(14, 1, 'dismissed_wp_pointers', ''),
(15, 1, 'show_welcome_panel', '1'),
(16, 1, 'session_tokens', 'a:2:{s:64:"abc2e2162139a2e69f5a11ae35c538949377b44f0bea9272639547e60fd4e9da";a:4:{s:10:"expiration";i:1591257243;s:2:"ip";s:9:"127.0.0.1";s:2:"ua";s:114:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36";s:5:"login";i:1591084443;}s:64:"f6a0f4349d7653c78c14f3b0babead446263b294353d890be46a1624da467132";a:4:{s:10:"expiration";i:1591335129;s:2:"ip";s:9:"127.0.0.1";s:2:"ua";s:114:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36";s:5:"login";i:1591162329;}}'),
(17, 1, 'wp_dashboard_quick_press_last_post_id', '4'),
(18, 1, 'community-events-location', 'a:1:{s:2:"ip";s:9:"127.0.0.0";}'),
(19, 1, 'wp_user-settings', 'libraryContent=browse'),
(20, 1, 'wp_user-settings-time', '1591106186'),
(21, 1, 'closedpostboxes_page', 'a:6:{i:0;s:23:"acf-group_5ed675cb324be";i:1;s:23:"acf-group_5ed6644f25708";i:2;s:23:"acf-group_5ed666f1a0d03";i:3;s:23:"acf-group_5ed66825693e4";i:4;s:23:"acf-group_5ed668fdc22cc";i:5;s:23:"acf-group_5ed67728066d0";}'),
(22, 1, 'metaboxhidden_page', 'a:0:{}'),
(23, 1, 'meta-box-order_page', 'a:4:{s:6:"normal";s:143:"acf-group_5ed675cb324be,acf-group_5ed6644f25708,acf-group_5ed666f1a0d03,acf-group_5ed66825693e4,acf-group_5ed668fdc22cc,acf-group_5ed67728066d0";s:15:"acf_after_title";s:0:"";s:4:"side";s:0:"";s:8:"advanced";s:0:"";}');

-- --------------------------------------------------------

--
-- Структура таблицы `wp_users`
--

CREATE TABLE `wp_users` (
  `ID` bigint(20) UNSIGNED NOT NULL,
  `user_login` varchar(60) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_pass` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_nicename` varchar(50) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_email` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_url` varchar(100) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_registered` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `user_activation_key` varchar(255) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT '',
  `user_status` int(11) NOT NULL DEFAULT '0',
  `display_name` varchar(250) COLLATE utf8mb4_unicode_520_ci NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;

--
-- Дамп данных таблицы `wp_users`
--

INSERT INTO `wp_users` (`ID`, `user_login`, `user_pass`, `user_nicename`, `user_email`, `user_url`, `user_registered`, `user_activation_key`, `user_status`, `display_name`) VALUES
(1, 'arif', '$P$BPDKlboURBMGQHpSRV75XoppjAwVTv/', 'arif', 'luba150278@gmail.com', '', '2020-06-02 07:53:19', '', 0, 'arif');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `pma__central_columns`
--
ALTER TABLE `pma__central_columns`
  ADD PRIMARY KEY (`db_name`,`col_name`);

--
-- Индексы таблицы `pma__column_info`
--
ALTER TABLE `pma__column_info`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`);

--
-- Индексы таблицы `pma__designer_settings`
--
ALTER TABLE `pma__designer_settings`
  ADD PRIMARY KEY (`username`);

--
-- Индексы таблицы `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_user_type_template` (`username`,`export_type`,`template_name`);

--
-- Индексы таблицы `pma__favorite`
--
ALTER TABLE `pma__favorite`
  ADD PRIMARY KEY (`username`);

--
-- Индексы таблицы `pma__history`
--
ALTER TABLE `pma__history`
  ADD PRIMARY KEY (`id`),
  ADD KEY `username` (`username`,`db`,`table`,`timevalue`);

--
-- Индексы таблицы `pma__navigationhiding`
--
ALTER TABLE `pma__navigationhiding`
  ADD PRIMARY KEY (`username`,`item_name`,`item_type`,`db_name`,`table_name`);

--
-- Индексы таблицы `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  ADD PRIMARY KEY (`page_nr`),
  ADD KEY `db_name` (`db_name`);

--
-- Индексы таблицы `pma__recent`
--
ALTER TABLE `pma__recent`
  ADD PRIMARY KEY (`username`);

--
-- Индексы таблицы `pma__relation`
--
ALTER TABLE `pma__relation`
  ADD PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  ADD KEY `foreign_field` (`foreign_db`,`foreign_table`);

--
-- Индексы таблицы `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `u_savedsearches_username_dbname` (`username`,`db_name`,`search_name`);

--
-- Индексы таблицы `pma__table_coords`
--
ALTER TABLE `pma__table_coords`
  ADD PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`);

--
-- Индексы таблицы `pma__table_info`
--
ALTER TABLE `pma__table_info`
  ADD PRIMARY KEY (`db_name`,`table_name`);

--
-- Индексы таблицы `pma__table_uiprefs`
--
ALTER TABLE `pma__table_uiprefs`
  ADD PRIMARY KEY (`username`,`db_name`,`table_name`);

--
-- Индексы таблицы `pma__tracking`
--
ALTER TABLE `pma__tracking`
  ADD PRIMARY KEY (`db_name`,`table_name`,`version`);

--
-- Индексы таблицы `pma__userconfig`
--
ALTER TABLE `pma__userconfig`
  ADD PRIMARY KEY (`username`);

--
-- Индексы таблицы `pma__usergroups`
--
ALTER TABLE `pma__usergroups`
  ADD PRIMARY KEY (`usergroup`,`tab`,`allowed`);

--
-- Индексы таблицы `pma__users`
--
ALTER TABLE `pma__users`
  ADD PRIMARY KEY (`username`,`usergroup`);

--
-- Индексы таблицы `wp_commentmeta`
--
ALTER TABLE `wp_commentmeta`
  ADD PRIMARY KEY (`meta_id`),
  ADD KEY `comment_id` (`comment_id`),
  ADD KEY `meta_key` (`meta_key`(191));

--
-- Индексы таблицы `wp_comments`
--
ALTER TABLE `wp_comments`
  ADD PRIMARY KEY (`comment_ID`),
  ADD KEY `comment_post_ID` (`comment_post_ID`),
  ADD KEY `comment_approved_date_gmt` (`comment_approved`,`comment_date_gmt`),
  ADD KEY `comment_date_gmt` (`comment_date_gmt`),
  ADD KEY `comment_parent` (`comment_parent`),
  ADD KEY `comment_author_email` (`comment_author_email`(10));

--
-- Индексы таблицы `wp_links`
--
ALTER TABLE `wp_links`
  ADD PRIMARY KEY (`link_id`),
  ADD KEY `link_visible` (`link_visible`);

--
-- Индексы таблицы `wp_options`
--
ALTER TABLE `wp_options`
  ADD PRIMARY KEY (`option_id`),
  ADD UNIQUE KEY `option_name` (`option_name`),
  ADD KEY `autoload` (`autoload`);

--
-- Индексы таблицы `wp_postmeta`
--
ALTER TABLE `wp_postmeta`
  ADD PRIMARY KEY (`meta_id`),
  ADD KEY `post_id` (`post_id`),
  ADD KEY `meta_key` (`meta_key`(191));

--
-- Индексы таблицы `wp_posts`
--
ALTER TABLE `wp_posts`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `post_name` (`post_name`(191)),
  ADD KEY `type_status_date` (`post_type`,`post_status`,`post_date`,`ID`),
  ADD KEY `post_parent` (`post_parent`),
  ADD KEY `post_author` (`post_author`);

--
-- Индексы таблицы `wp_termmeta`
--
ALTER TABLE `wp_termmeta`
  ADD PRIMARY KEY (`meta_id`),
  ADD KEY `term_id` (`term_id`),
  ADD KEY `meta_key` (`meta_key`(191));

--
-- Индексы таблицы `wp_terms`
--
ALTER TABLE `wp_terms`
  ADD PRIMARY KEY (`term_id`),
  ADD KEY `slug` (`slug`(191)),
  ADD KEY `name` (`name`(191));

--
-- Индексы таблицы `wp_term_relationships`
--
ALTER TABLE `wp_term_relationships`
  ADD PRIMARY KEY (`object_id`,`term_taxonomy_id`),
  ADD KEY `term_taxonomy_id` (`term_taxonomy_id`);

--
-- Индексы таблицы `wp_term_taxonomy`
--
ALTER TABLE `wp_term_taxonomy`
  ADD PRIMARY KEY (`term_taxonomy_id`),
  ADD UNIQUE KEY `term_id_taxonomy` (`term_id`,`taxonomy`),
  ADD KEY `taxonomy` (`taxonomy`);

--
-- Индексы таблицы `wp_usermeta`
--
ALTER TABLE `wp_usermeta`
  ADD PRIMARY KEY (`umeta_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `meta_key` (`meta_key`(191));

--
-- Индексы таблицы `wp_users`
--
ALTER TABLE `wp_users`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `user_login_key` (`user_login`),
  ADD KEY `user_nicename` (`user_nicename`),
  ADD KEY `user_email` (`user_email`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `pma__bookmark`
--
ALTER TABLE `pma__bookmark`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `pma__column_info`
--
ALTER TABLE `pma__column_info`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `pma__export_templates`
--
ALTER TABLE `pma__export_templates`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `pma__history`
--
ALTER TABLE `pma__history`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `pma__pdf_pages`
--
ALTER TABLE `pma__pdf_pages`
  MODIFY `page_nr` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `pma__savedsearches`
--
ALTER TABLE `pma__savedsearches`
  MODIFY `id` int(5) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `wp_commentmeta`
--
ALTER TABLE `wp_commentmeta`
  MODIFY `meta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `wp_comments`
--
ALTER TABLE `wp_comments`
  MODIFY `comment_ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `wp_links`
--
ALTER TABLE `wp_links`
  MODIFY `link_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `wp_options`
--
ALTER TABLE `wp_options`
  MODIFY `option_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=226;
--
-- AUTO_INCREMENT для таблицы `wp_postmeta`
--
ALTER TABLE `wp_postmeta`
  MODIFY `meta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=800;
--
-- AUTO_INCREMENT для таблицы `wp_posts`
--
ALTER TABLE `wp_posts`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;
--
-- AUTO_INCREMENT для таблицы `wp_termmeta`
--
ALTER TABLE `wp_termmeta`
  MODIFY `meta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблицы `wp_terms`
--
ALTER TABLE `wp_terms`
  MODIFY `term_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `wp_term_taxonomy`
--
ALTER TABLE `wp_term_taxonomy`
  MODIFY `term_taxonomy_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT для таблицы `wp_usermeta`
--
ALTER TABLE `wp_usermeta`
  MODIFY `umeta_id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT для таблицы `wp_users`
--
ALTER TABLE `wp_users`
  MODIFY `ID` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
