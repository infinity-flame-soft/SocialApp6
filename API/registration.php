<?php

require "conn.php";

$name=$_POST["post_name"];
$password=$_POST["post_pass"];
$email=$_POST["post_email"];
$mobile=$_POST["post_mobile"];

$sql="INSERT INTO `user`(`name`, `email`, `password`, `mobile`) VALUES ('$name','$email','$password','$mobile');";

if ($conn->query($sql)=== TRUE){
	echo "success";
}
else{
    echo "error";
}
$conn->close();

?>