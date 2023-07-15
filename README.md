# Introduction

## Tools & Framework components:

1. Playwright
2. Cucumber BDD
3. Scripting Language: Java

## Local Tests:
### By default, it runs in headed mode
```
mvn clean verify -Dcucumber.filter.tags="@UI" -DbrowserName="chromium"
```
### For headless:
```
mvn clean verify -Dcucumber.filter.tags="@UI" -DbrowserName="chromium" -Dheadless="true"
```
### For Open Trace viewer:
```
mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace target/trace.zip"
```