#!/bin/bash
dir=$(cd `dirname $0`; pwd)
projectRoot=${dir%reborn-java*}
source $projectRoot"reborn-java/"scripts/consumer.sh 1 $*

