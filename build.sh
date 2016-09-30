./clean.sh
mkdir server/dist
mkdir cliente/dist
javac -d server/dist/ server/src/*.java
cp server/src/Sumador.java cliente/src/
javac -d cliente/dist/ cliente/src/*.java