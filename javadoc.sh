#!/bin/bash

source javaproj.txt

cd $SRC

FILES=$1

for FILE in $FILES
do
    if [ -f $CPSH ]; then
        javadoc -cp $(cat $CPSH) $1
    else
        javadoc $1
    fi
done