"docker-compose up" ausführen

Auf http://localhost:8080/movies gehen, um alle movies zu erhalten.

Mit Postman möglich neue movies hinzuzufügen.
Beispiel:
{
"title": "addedMovie",
"year": "addedYear",
"rating": "addedRating"
}

Auf http://localhost:8080/movies/{id} gehen, um einen spezifischen movie zu erhalten.

Auf http://localhost:8080/delete/{id} gehen, um einen spezifischen movie zu löschen.