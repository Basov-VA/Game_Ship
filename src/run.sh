# remove src/ from files paths

find . -type f -name '*.class' -delete

javac Main.java

java Main

find . -type f -name '*.class' -delete
