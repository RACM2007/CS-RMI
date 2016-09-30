@echo off
call clean.bat
mkdir server\dist
mkdir cliente\dist
javac -d server\dist\ -cp server\src server\src\*.java
copy /Y server\src\remoto cliente\src\remoto
javac -d cliente\dist\ -cp server\src cliente\src\*.java