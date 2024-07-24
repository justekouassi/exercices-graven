<?php
echo "Estimation en cours...<br>";

$nom = $_POST["nom"];
$type = $_POST["type"];
$annee = $_POST["annee"];

if (!empty($nom)) {
	echo "<br>L'oeuvre s'appelle : " . $nom;
}
if (!empty($type)) {
	echo "<br>Le type d'oeuvre est : " . $type;
}
if (!empty($annee)) {
	echo "<br>L'année de réalisation est : " . $annee;
	if ($annee <= 1200) {
	}
}
