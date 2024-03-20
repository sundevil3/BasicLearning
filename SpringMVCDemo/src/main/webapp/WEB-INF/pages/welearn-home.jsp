

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="" type="image/x-icon">

<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.css" />
<link rel="stylesheet" type="text/css"
	href="http://kenwheeler.github.io/slick/slick/slick-theme.css" />

<meta name="description"
	content="NovoEd provides the best online learning platform for social, collaborative and mobile learning that enables effective online training at scale." />
<meta name="robots" content="noodp" />
<link rel="canonical" href="https://novoed.com/" />
<meta name="twitter:card" content="summary" />
<meta name="twitter:description"
	content="NovoEd provides the best online learning platform for social, collaborative and mobile learning that enables effective online training at scale." />
<meta name="twitter:title" content="Home - NovoEd" />
<script type='application/ld+json'>{"@context":"http:\/\/schema.org","@type":"WebSite","@id":"#website","url":"https:\/\/novoed.com\/","name":"NovoEd","potentialAction":{"@type":"SearchAction","target":"https:\/\/novoed.com\/?s={search_term_string}","query-input":"required name=search_term_string"}}</script>
<!-- / Yoast SEO plugin. -->

<link rel='dns-prefetch' href='//novoed.com' />
<link rel='dns-prefetch' href='//oss.maxcdn.com' />
<link rel='dns-prefetch' href='//js.hsforms.net' />
<link rel='dns-prefetch' href='//s.w.org' />
<script type="text/javascript">
			window._wpemojiSettings = {"baseUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/72x72\/","ext":".png","svgUrl":"https:\/\/s.w.org\/images\/core\/emoji\/2.2.1\/svg\/","svgExt":".svg","source":{"concatemoji":"https:\/\/novoed.com\/wp-includes\/js\/wp-emoji-release.min.js?ver=4.7.5"}};
			!function(a,b,c){function d(a){var b,c,d,e,f=String.fromCharCode;if(!k||!k.fillText)return!1;switch(k.clearRect(0,0,j.width,j.height),k.textBaseline="top",k.font="600 32px Arial",a){case"flag":return k.fillText(f(55356,56826,55356,56819),0,0),!(j.toDataURL().length<3e3)&&(k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,65039,8205,55356,57096),0,0),b=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55356,57331,55356,57096),0,0),c=j.toDataURL(),b!==c);case"emoji4":return k.fillText(f(55357,56425,55356,57341,8205,55357,56507),0,0),d=j.toDataURL(),k.clearRect(0,0,j.width,j.height),k.fillText(f(55357,56425,55356,57341,55357,56507),0,0),e=j.toDataURL(),d!==e}return!1}function e(a){var c=b.createElement("script");c.src=a,c.defer=c.type="text/javascript",b.getElementsByTagName("head")[0].appendChild(c)}var f,g,h,i,j=b.createElement("canvas"),k=j.getContext&&j.getContext("2d");for(i=Array("flag","emoji4"),c.supports={everything:!0,everythingExceptFlag:!0},h=0;h<i.length;h++)c.supports[i[h]]=d(i[h]),c.supports.everything=c.supports.everything&&c.supports[i[h]],"flag"!==i[h]&&(c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&c.supports[i[h]]);c.supports.everythingExceptFlag=c.supports.everythingExceptFlag&&!c.supports.flag,c.DOMReady=!1,c.readyCallback=function(){c.DOMReady=!0},c.supports.everything||(g=function(){c.readyCallback()},b.addEventListener?(b.addEventListener("DOMContentLoaded",g,!1),a.addEventListener("load",g,!1)):(a.attachEvent("onload",g),b.attachEvent("onreadystatechange",function(){"complete"===b.readyState&&c.readyCallback()})),f=c.source||{},f.concatemoji?e(f.concatemoji):f.wpemoji&&f.twemoji&&(e(f.twemoji),e(f.wpemoji)))}(window,document,window._wpemojiSettings);
		</script>
<style type="text/css">
img.wp-smiley, img.emoji {
	display: inline !important;
	border: none !important;
	box-shadow: none !important;
	height: 1em !important;
	width: 1em !important;
	margin: 0 .07em !important;
	vertical-align: -0.1em !important;
	background: none !important;
	padding: 0 !important;
}

.slick-prev:before, .slick-next:before {
	color: red;
}

.slick-dots li {
	position: relative;
	display: inline-block;
	width: 20px;
	height: 20px;
	margin: 16px 22px 14px 6px;
	padding: 0px 23px 0px 30px;
	cursor: pointer;
}

ol {
	counter-reset: li; /* Initiate a counter */
	list-style: none; /* Remove default numbering */
	*list-style: decimal; /* Keep using default numbering for IE6/7 */
	font: 21px 'trebuchet MS', 'lucida sans';
	padding: 0;
	margin-bottom: 4em;
	text-shadow: 0 1px 0 rgba(255, 255, 255, .5);
}

.rounded-list a {
	position: relative;
	display: block;
	padding: .4em .4em .4em 2em;
	*padding: .4em;
	margin: .5em 0;
	background: #ddd;
	color: #444;
	text-decoration: none;
	border-radius: .3em;
	transition: all .3s ease-out;
}

.rounded-list a:hover {
	background: #eee;
}

.rounded-list a:hover:before {
	transform: rotate(360deg);
}

.rounded-list a:before {
	content: counter(li);
	counter-increment: li;
	position: absolute;
	left: -1.3em;
	top: 50%;
	margin-top: -1.3em;
	background: #87ceeb;
	height: 2em;
	width: 2em;
	line-height: 2em;
	border: .3em solid #fff;
	text-align: center;
	font-weight: bold;
	border-radius: 2em;
	transition: all .3s ease-out;
}
</style>
<link rel='stylesheet' id='styles-css'
	href='https://novoed.com/wp-content/themes/novoed/style.css?ver=4.7.5'
	type='text/css' media='all' />
<link rel='stylesheet' id='tipsy-css'
	href='https://novoed.com/wp-content/plugins/wp-shortcode/css/tipsy.css?ver=4.7.5'
	type='text/css' media='all' />
<link rel='stylesheet' id='mts_wpshortcodes-css'
	href='https://novoed.com/wp-content/plugins/wp-shortcode/css/wp-shortcode.css?ver=4.7.5'
	type='text/css' media='all' />
<script type='text/javascript'
	src='https://js.hsforms.net/forms/v2.js?ver=4.7.5'></script>
<script type="text/javascript"
	src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="icon"
	href="https://novoed.com/wp-content/uploads/2016/12/cropped-NovoEd-Logo-v4-Favicon-Blue-512x517-60x60.png"
	sizes="32x32" />
<link rel="icon"
	href="https://novoed.com/wp-content/uploads/2016/12/cropped-NovoEd-Logo-v4-Favicon-Blue-512x517-280x280.png"
	sizes="192x192" />
<link rel="apple-touch-icon-precomposed"
	href="https://novoed.com/wp-content/uploads/2016/12/cropped-NovoEd-Logo-v4-Favicon-Blue-512x517-280x280.png" />
<meta name="msapplication-TileImage"
	content="https://novoed.com/wp-content/uploads/2016/12/cropped-NovoEd-Logo-v4-Favicon-Blue-512x517-280x280.png" />
</head>
<body>
	<script type="text/javascript"
		src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script type='text/javascript'
		src='https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.8.1/slick.js'></script>
	<header>
		<div class="container">
			<nav>

				<ul id="personal-menu">
					<li><a href="loginPage" class="btn btn-transparent" style="color:black;"> Log In </a></li>
				</ul>
				<ul id="personal-menu">
					<li></li>
				</ul>
			</nav>
		</div>
	</header>


</body>
</html>