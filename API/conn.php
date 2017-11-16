<?php

$db_name="android6";
$mysql_username="root";
$mysql_passward="";
$server_name="localhost";

$conn=mysqli_connect($server_name,$mysql_username,$mysql_passward,$db_name);

if ($conn) {
	//echo "Success";
}
else{
	echo "error";
}

?>
