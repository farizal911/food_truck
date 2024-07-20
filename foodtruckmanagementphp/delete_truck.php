<?php
// Handle deletion request from index.html
$id = $_POST['id'];

// Delete record from database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "foodtruck_db";


$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "DELETE FROM foodtrucks WHERE id=$id";

if ($conn->query($sql) === TRUE) {
    echo "Record deleted successfully";
} else {
    echo "Error deleting record: " . $conn->error;
}

$conn->close();
?>
