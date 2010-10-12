<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml"> 
<head> 
<title>{{kw}} - SouHub</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" /> 
<meta name="Keywords" content="souhub,search engine,seo,multi search,multi maps,multi books,multi images" /> 
<meta name="Description" content="supply search results for {{kw}} from different eninges。" /> 
<link type="text/css" rel="stylesheet" href="static/search.css?v0.1" /> 
<script type="text/javascript" src="static/jquery.min.js?v1.3.2"></script> 
<script type="text/javascript" src="static/jquery.hotkeys.min.js?v0.7.9"></script> 
<script type="text/javascript" src="static/jquery.suggest.js?v1.1"></script> 
<script type="text/javascript"> 
$(document).ready(function(){
$('input[name=p]:first').suggest('/', {onSelect: function(){
$(this).parent().find('input[type=submit]').click();
}});
});
 
window.show_more_similar = function(o)
{
$(o).parent().hide();
$(".more_similar").show();
}
 
function checkSuggest()
{
if(window.insuggest == 'undefined')
return true;
else
return (!window.insuggest);
}
</script> 
</head> 
<body> 
<div class="frame" id="toolbar"> 
</div><div> 
<form method="get" action="search" onsubmit="return checkSuggest();"> 
<div id="logo"><a href="/"><img src="static/logo_nav.gif" width="180" height="50" /></a></div> 
<div class="wrap" id="stype"><a href="http://news.souhub.com/">News</a><b>Web</b><a href="http://www.souhub.com/">Scholar</a><a href="http://ask.souhub.com/">Ask</a><a href="http://music.souhub.com/">Music</a><a href="http://vedio.souhub.com/">Videos</a><a href="http://image.souhub.com/">Images</a><a href="http://blog.souhub.com/">Blogs</a><a href="http://map.souhub.com/">Map</a><a href="http://book.souhub.com/">Books</a></div> 
<div class="wrap"> 
<input type="text" name="q" id="q" value="{{kw}}" /> 
<input type="submit" id="submit" value="SouHub Search" /> 
</div> 
</form> 
</div> 
<div class="clear"></div> 
<div class="wrap" id="resultcount"> 
<div class="left"><b>WEB</b></div> 
<div class="right"><b>{{display_range.0}}-{{display_range.1}}</b> of <b>{{count}}</b>({{time}})</div> 
</div> 
<div class="clear"></div> 
<div style="width:850px;"> 
<div class="wrap content"> 
<div class="item from"> 
From:&nbsp;<a href="http://www.baidu.com/s?wd={{kw}}" target="_blank"><img src="/static/101_logo.gif" title="百度 3,150 条结果"/></a>&nbsp;<a href="http://www.youdao.com/search?q={{kw}}" target="_blank"><img src="/static/105_logo.gif" title="有道 939 条结果"/></a></div> 
<div class="clear"></div> 

{% for result in search_list %}
<div class="item" id="result{{forloop.counter}}"> 
<div class="title"> 
<a href="{{result.2}}" target="_blank"><font size="3">{{result.3}}</font></a></div> 
<font size="-1"> 
{{result.4}}<br /> 
<font color="#008000">{{result.2}}</font> 
&nbsp;<a href="{{result.5}}" target="_blank"><img src="static/101_ico.gif" title="engine number x"/></a>&nbsp;<a href="{{result.5}}" target="_blank"><img src="static/105_ico.gif" title="engine number x"/></a></font> 
</div> 
{% endfor %}
 </div>
<!--Ad--> 
<div id="gogole_ad"> 
<script type="text/javascript"><!--
google_ad_client = "pub-8288329169750787";
google_ad_slot = "7237966126";
google_ad_width = 160;
google_ad_height = 600;
//-->
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script> 
</div> 
<!--End Ad--> 
</div> 
<div class="clear"></div> 
 
<div class="wrap pages">
{% for page in page_range %}
{% if page.2 %}
<b>{{page.1}}</b>
{% else %}
<a href="?q={{kw}}{% if page.0 %}&s={{page.0}}{% endif %}" class="next">{{page.1}}</a>
{% endif %}
{% endfor %}
<a href="?q={{kw}}{% if next%}&s={{next}}{% endif %}" class="next">Next</a>
</div> 
<div class="clear"></div> 
<div class="wrap bottomtools"> 
<div id="bottomtools"> 
<form method="get" action="search"> 
<input type="text" name="q" id="p1" value="{{kw}}" /> 
<input type="submit" id="submit1" value="SouHub Search" /> 
</form> 
</div> 
<div id="more"> 
<a href="#">Search within results</a><span>|</span><a href="#">Advanced</a><a href="#">More>></a> 
</div> 
</div> 
<div class="frame" id="copyright"> 
<span>&copy; 2010 SouHub</span>
&nbsp;<a href="#">SiteMap</a> 
</div> 
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-18737404-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</body> 
</html>