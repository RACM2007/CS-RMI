@echo off
call clean.bat
mkdir server\dist
mkdir cliente\dist
javac -d server\dist\ server\src\*.java
copy /Y server\src\Sumador.java cliente\src
javac -d cliente\dist\ cliente\src\*.java