  
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>PostMessage Demo</title>
    <style type="text/css">
        #alice-box {
           border: 2px solid blue;
           height: 400px;
           width: 400px;
        }
    </style>
  </head>
<body>

<p>If you click the button, then some stuff will go inside the box.</p>

<button id="alice-button">The Button</button>

<div id="alice-box">The Box</div>


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.2/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="pomp.js"></script>
<script type="text/javascript" >
$(window).load(function() {
    $.fn.pomp.createChannel('alice', 'http://your-server.example.com/proxy.html');
});
$("#alice-button").click(function() {
    var args = { 'type': 'GET',
                 'url': '/api/list/all' }
    $.fn.pomp.sendMessage('alice', args, function(d) { $('#alice-box').html(d); });
});
</script>
</body>
</html>
