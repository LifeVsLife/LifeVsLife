#!/bin/sh

./javacAll.sh

source javaproj.txt

JARNAME=LifeVsLife

cd $BIN

jar cfm $JARNAME.jar $PROJ/manifest.txt * $RES $LIB
mv $JARNAME.jar $JAR$JARNAME.jar
