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

SET CLASSPATH_CLIENTE="client-rmi"

START javaw -classpath %CLASSPATH_CLIENTE% clientermi

SET PATH=%TMP_PATH%
EXIT
