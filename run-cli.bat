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

SET CLASSPATH_CLIENTE=client-rmi
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;client-rmi\lib\jasperreports-5.6.0.jar;client-rmi\lib\commons-logging-1.1.1.jar
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;client-rmi\lib\commons-javaflow-20060411.jar;client-rmi\lib\commons-digester-2.1.jar
SET CLASSPATH_CLIENTE=%CLASSPATH_CLIENTE%;client-rmi\lib\commons-collections-3.2.1.jar;client-rmi\lib\commons-beanutils-1.8.0.jar

START javaw -classpath %CLASSPATH_CLIENTE% clientermi

pause
SET PATH=%TMP_PATH%
SET CLASSPATH_CLIENTE=
EXIT
