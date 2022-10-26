Codebase: Version Control System Gitlab verwendet.

Dependencies: Dependency Management Tool Maven verwendet. Alle dependencies sind in pom.xml

Configurations: Konfiguration ist in einem file in src/main/resources/application.properties

Backing Services: Repository Layer erstellt und mit Spring JPA und PostgreSQL Datenbank aufgesetzt

Build, Release and Run: 

Processes: Prozess sind unabhängig voneinander und jeder Prozess hat seine eigene Backing Services. (Ist in diesem 
microservice gegeben, ohne speziell etwas implementieren zu müssen da keine informationen zu sessions gespeichert werden)

Port Binding: Mit SpringBoot automatisch gegeben. Applikation besitzt Endpoints die über den default Port 8080 laufen.

Concurrency: Mehrere Instanzen eines Microservice/Prozesses sollen laufen können mit intelligenter load distribution. 
Schließt aber auch nicht aus die interne "prozessbehandlung" mithilfe von Threads.
Mehrere Instanzen laufen lassen könnte mit Kubernetes umgesetzt werden. Innerhalb einer Instanz mittels Threads 
concurrency implementieren.

Disposability: Prozesse sollen gestoppt werden können ohne das irgendwelche unerwünschte side-effects auftreten 
(Grundsätzlich idempotent sein) und entsprechend auch so designed sein dass die prozesse wieder schnell gestartet werden
können. Ist in unserem Fall gegeben da Get/Delete sowieso idempotent sind und Post so implementiert wurde, dass wenn
2 mal ein request mit dem selben Objekt gesendet wird nur 1 mal gespeichert wird.
Schnell starten mit Regel5 Build Release and Run zusammenhängend denn wenn zuerst Builded Released und Runned jedes mal
gemacht werden muss dauert es viel länger.

Dev/Prod Parity: Dev environment und production sollen so gleich wie möglich sein. Um zu erreichen: Containerisieren 
mit Docker und verwendung von CI/CD.

Logs: Logging um Verhalten des laufenden Prozesses sichtbar zu machen. Zusätzlich können/sollten logs noch gespeichert 
werden zB mit Fluentd

Admin Processes: Skripte, die einmal aufgerufen werden und direkt wieder beendet werden. Gehören auch zur Codebase.
In unserem Fall ein "skript" bzw eine Klasse, die eine Liste von Movies ausliest und in die Datenbank speichert.