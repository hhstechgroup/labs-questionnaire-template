@echo off
set /p webdriver.base.url="Enter webdriver.base.url: " %=%
set /p test.folder="Enter tests folder name: " %=%
java -Dwebdriver.base.url=%webdriver.base.url% -Dwebdriver.driver=firefox -jar %~p0billspan-acceptancetest-test-jar-wd.jar %test.folder%