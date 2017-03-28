<?php
 $amount = $_REQUEST['amount'];

$XMLData =
"<?xml version='1.0' encoding='UTF-8'?>
<item>
<title>USD</title>
<pubDate>12.04.16</pubDate>
<description>336.87</description>
<quant>1</quant>
<index>DOWN</index>
<change>-3.44</change>
</item>";

$xml=simplexml_load_string($XMLData) or die("Error: Cannot create object");
//print_r($xml);
echo json_encode($xml);


?>