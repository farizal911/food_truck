<?php
// Fetch data from database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "foodtruck_db";

$conn = new mysqli($servername, $username, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Query to fetch all food trucks
$sql = "SELECT * FROM foodtrucks";
$result = $conn->query($sql);

$trucks = array();

if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        $trucks[] = $row;
    }
}

$conn->close();

// Organize trucks by state
$organizedTrucks = array(
    'Perlis' => array(),
    'Selangor' => array(),
    'Johor' => array(),
    'Sabah' => array()
);

foreach ($trucks as $truck) {
    $state = $truck['state'];
    $organizedTrucks[$state][] = $truck;
}

// Output organized trucks as JSON
header('Content-Type: application/json');
echo json_encode($organizedTrucks);
?>
