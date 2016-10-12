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

SET CLASSPATH_SERVER=server-rmi;server-rmi\lib\mysql-connector-java-5.1.39-bin.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;server-rmi\lib\jasperreports-javaflow-5.6.0.jar;server-rmi\lib\jasperreports-fonts-5.6.0.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;server-rmi\lib\jasperreports-5.6.0.jar;server-rmi\lib\iText-2.1.7.js2.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;server-rmi\lib\groovy-all-2.0.1.jar;server-rmi\lib\commons-logging-1.1.1.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;server-rmi\lib\commons-javaflow-20060411.jar;server-rmi\lib\commons-digester-2.1.jar
SET CLASSPATH_SERVER=%CLASSPATH_SERVER%;server-rmi\lib\commons-collections-3.2.1.jar;server-rmi\lib\commons-beanutils-1.8.0.jar

ECHO %CLASSPATH_SERVER%

START javaw -classpath %CLASSPATH_SERVER% servidorvista

SET PATH=%TMP_PATH%
SET CLASSPATH_SERVER=
EXIT
