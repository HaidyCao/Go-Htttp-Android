#!/bin/bash

cd `dirname $0`
version=`cat version`

../gradlew :go-http:gobind

if [ ! -d "../go-http-java/libs/" ];then
    mkdir ../go-http-java/libs
fi

newVersion=`expr $[version] + 1`
echo "build version = ${newVersion}"

mv go-http.aar ../go-http-java/libs/go-http-v${newVersion}.aar
# mv frp-sources.jar ../go-http-java/libs/

echo ${newVersion} > version