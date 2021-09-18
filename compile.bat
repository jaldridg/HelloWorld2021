javac -sourcepath src -d build -cp ".;src/main/java/program/*.java" src/main/java/utils/*.java
javac -sourcepath src -d build src/main/java/utils/*.java

mvn archetype:generate -DgroupId=com.hdash.app -DartifactId=HDash -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false
5gz1Qbm304Ajlb1DOAJjhJ6DHvq5lp5lVtDfCEbZ