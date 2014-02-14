#!/bin/sh

webdriver_base_url="$1"
test_folder="$2"
wd=`pwd`
java -Dwebdriver.base.url=$webdriver_base_url -Dwebdriver.driver=firefox -jar $wd/billspan-acceptancetest-test-jar-wd.jar $test_folder