#!/bin/sh

./javacAll.sh

source javaproj.txt

cd $JAR

jar cfm LifeVsLife.jar manifest.txt $BIN $RES $LIB
