@echo off

if "%1" == "" goto usage

if "%1" == "dev" goto dev
if "%1" == "cicd" goto cicd
if "%1" == "sit" goto sit
if "%1" == "uat" goto uat
if "%1" == "prod" goto prod
if "%1" == "wip" goto wip

:usage
    echo "Usage: helix dev
goto end

:dev
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff

:cicd
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff

:sit
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff -Dcucumber.options="--tags @Smoke --tags @SIT"

:uat
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff

:prod
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff -Dcucumber.options="--tags @Smoke --tags @prod"

:wip
    mvn clean test verify -Pchrome -Dwebdriver.base.url=https://www.qantas.com/fflyer/dyn/joinff -Dcucumber.options="--tags @Smoke --tags @WIP"

goto end

:end
