./clean.sh
mkdir server/dist
mkdir cliente/dist
javac -d server/dist/ -cp server/src server/src/*.java
cp -R server/src/remoto cliente/src
javac -d cliente/dist/ -cp cliente/src cliente/src/*.java