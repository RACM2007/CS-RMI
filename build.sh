CLASSPATH_SERVER="server/src:server/libs/mysql-connector-java-5.1.39.jar"
CLASSPATH_CLIENTE="cliente/src"

./clean.sh
mkdir server/dist
mkdir cliente/dist
javac -d server/dist/ -cp $CLASSPATH_SERVER server/src/*.java
cp -R server/src/remoto cliente/src
javac -d cliente/dist/ -cp $CLASSPATH_CLIENTE cliente/src/*.java