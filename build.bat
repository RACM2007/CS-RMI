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

SET CLASSPATH_SERVER=bancoservidor\src;bancoservidor\lib\mysql-connector-java-5.1.39-bin.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;bancoservidor\lib\jasperreports-javaflow-5.6.0.jar;bancoservidor\lib\jasperreports-fonts-5.6.0.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;bancoservidor\lib\jasperreports-5.6.0.jar;bancoservidor\lib\iText-2.1.7.js2.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;bancoservidor\lib\groovy-all-2.0.1.jar;bancoservidor\lib\commons-logging-1.1.1.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;bancoservidor\lib\commons-javaflow-20060411.jar;bancoservidor\lib\commons-digester-2.1.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;bancoservidor\lib\commons-collections-3.2.1.jar;bancoservidor\lib\commons-beanutils-1.8.0.jar

SET CLASSPATH_CLIENTE=bancocliente\src
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;bancocliente\lib\jasperreports-5.6.0.jar;bancocliente\lib\commons-logging-1.1.1.jar
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;bancocliente\lib\commons-javaflow-20060411.jar;bancocliente\lib\commons-digester-2.1.jar
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;bancocliente\lib\commons-collections-3.2.1.jar;bancocliente\lib\commons-beanutils-1.8.0.jar


rd /S /Q client-rmi >nul
rd /S /Q server-rmi >nul
mkdir client-rmi >nul
mkdir server-rmi >nul
mkdir server-rmi\lib >nul
mkdir server-rmi\imagenes >nul
mkdir server-rmi\reportes >nul
mkdir client-rmi\imagenes >nul
mkdir client-rmi\lib >nul
xcopy bancoservidor\lib server-rmi\lib /Y /s /e >nul
xcopy bancocliente\lib client-rmi\lib /Y /s /e >nul
javac -encoding "ISO-8859-15" -d server-rmi -cp %CLASSPATH_SERVER% -sourcepath bancoservidor\src bancoservidor\src\servidorvista.java
xcopy bancoservidor\src\imagenes server-rmi\imagenes /Y /s /e >nul
xcopy bancoservidor\src\reportes server-rmi\reportes /Y /s /e >nul
javac -encoding "ISO-8859-15" -d client-rmi -cp %CLASSPATH_CLIENTE% -sourcepath bancocliente\src bancocliente\src\clientermi.java
xcopy bancocliente\src\imagenes client-rmi\imagenes /Y /s /e >nul

SET PATH=%TMP_PATH%
SET CLASSPATH_SERVER=
SET CLASSPATH_CLIENTE=
