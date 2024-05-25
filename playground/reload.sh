#!/bin/bash

cd ..
mvn clean install
cd target
cp wc-alpha-1.0-SNAPSHOT.jar ../playground
cd ../playground 
java -jar wc-alpha-1.0-SNAPSHOT.jar test.txt
