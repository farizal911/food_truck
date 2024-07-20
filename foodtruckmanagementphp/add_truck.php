<?php
// Handle form data sent by index.html
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
} else {
    echo "Image upload failed.";
    exit;
}

// Insert into database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "foodtruck_db";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO foodtrucks (name, address, image, phoneNumber, workingTime, closingDay, state)
        VALUES ('$name', '$address', '$image', '$phoneNumber', '$workingTime', '$closingDay', '$state')";

if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . $conn->error;
}

$conn->close();
?>
