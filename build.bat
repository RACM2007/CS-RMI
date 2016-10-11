@echo off

IF  NOT DEFINED JAVA_HOME (
	@echo on
	echo Se requiere tener JAVA_HOME como variable de entorno, [enter] para salir.
	@echo off
	pause
	exit
)

SET TMP_PATH=%PATH%
SET PATH=%PATH%;%JAVA_HOME%\bin

SET CLASSPATH_SERVER="roberto\bancoservidor\src;roberto\bancoservidor\lib\mysql-connector-java-5.1.39-bin.jar"
SET CLASSPATH_CLIENTE="roberto\bancocliente\src"

rd /S /Q client-rmi >nul
rd /S /Q server-rmi >nul
mkdir client-rmi >nul
mkdir server-rmi >nul
mkdir server-rmi\lib >nul
mkdir server-rmi\imagenes >nul
mkdir client-rmi\imagenes >nul
xcopy roberto\bancoservidor\dist\lib server-rmi\lib /Y /s /e >nul
javac -encoding "ISO-8859-15" -d server-rmi -cp %CLASSPATH_SERVER% -sourcepath roberto\bancoservidor\src roberto\bancoservidor\src\servidorvista.java
xcopy roberto\bancoservidor\src\imagenes server-rmi\imagenes /Y /s /e >nul
javac -encoding "ISO-8859-15" -d client-rmi -cp %CLASSPATH_CLIENTE% -sourcepath roberto\bancocliente\src roberto\bancocliente\src\clientermi.java
xcopy roberto\bancocliente\src\imagenes client-rmi\imagenes /Y /s /e >nul

SET PATH=%TMP_PATH%
