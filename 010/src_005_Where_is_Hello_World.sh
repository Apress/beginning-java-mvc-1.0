#!/bin/bash
JAVA_HOME=/path/to/your/openjdk-8

rm -rf build/*
cp -a src/webapp/* build
mkdir build/WEB-INF/classes

$JAVA_HOME/bin/javac \
    -cp src/webapp/WEB-INF/lib/javaee-api-8.0.jar:
        src/webapp/WEB-INF/lib/javax.mvc-api-1.0.0.jar \
    -d build/WEB-INF/classes \
    src/java/book/javamvc/helloworld/* 

cd build
$JAVA_HOME/bin/jar cf ../HelloWorld.war *
cd ..
