SET CLASSPATH_SERVER="server\src:server\libs\mysql-connector-java-5.1.39.jar"
SET CLASSPATH_CLIENTE="cliente\src"

@echo off
call clean.bat
mkdir server\dist
mkdir cliente\dist
javac -d server\dist\ -cp %CLASSPATH_SERVER% server\src\*.java
copy \Y server\src\remoto cliente\src\remoto
javac -d cliente\dist\ -cp %CLASSPATH_CLIENTE% cliente\src\*.java