<?php
// Handle form data sent by index.html
$id = $_POST['id'];
$name = $_POST['name'];
$address = $_POST['address'];
$phoneNumber = $_POST['phoneNumber'];
$workingTime = $_POST['workingTime'];
$closingDay = $_POST['closingDay'];
$state = $_POST['state'];

// Handle file upload (image)
$image = ''; // Placeholder for image URL or ID

if ($_FILES['image']['error'] == UPLOAD_ERR_OK) {
    $image_name = $_FILES['image']['name'];
    $image_tmp_name = $_FILES['image']['tmp_name'];
    $image_destination = 'uploads/' . $image_name;
    
    // Move uploaded file to destination
    if (move_uploaded_file($image_tmp_name, $image_destination)) {
        $image = $image_destination;
    } else {
        echo "Failed to move uploaded file.";
        exit;
    }
}

// Update database record
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "foodtruck_db";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Prepare SQL query
$sql = "UPDATE foodtrucks SET name='$name', address='$address', phoneNumber='$phoneNumber', workingTime='$workingTime', closingDay='$closingDay', state='$state'";

// Append image update if an image was uploaded
if (!empty($image)) {
    $sql .= ", image='$image'";
}

$sql .= " WHERE id=$id";

if ($conn->query($sql) === TRUE) {
    echo "Record updated successfully";
} else {
    echo "Error updating record: " . $conn->error;
}

$conn->close();
?>
