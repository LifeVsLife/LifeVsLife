#!/bin/bash

source javaproj.txt

cd $SRC

javadoc -cp .:../res/:../lib/* -d ../doc/ *
