# Appium Automation Framework

## The technologies used are:
* Java
* Appium
* Maven
* Selenium
* Nodejs
* Android studio (Android virtual devices)

***

## Required tool installations

* Java JDK [download](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
* Android Studio (for virtual devices) [download](https://developer.android.com/studio?hl=es-419)
* Nodejs [download](https://nodejs.org/en/)
* Maven [download](https://maven.apache.org/download.cgi)
* Appium inspector [download](https://github.com/appium/appium-inspector/releases)

***

## Recommended tool installations

* IDE - IntelliJ IDEA Community Edition [download](https://www.jetbrains.com/idea/download)

***
## Create and manage virtual devices
* Android virtual devices [documentation](https://developer.android.com/studio/run/managing-avds)
***

## Setting required environment variables

We recommended going the official documentation for necessary setup.

* Java [Documentation](https://java.com/en/download/help/path.html)
* Maven [Documentation](https://maven.apache.org/install.html)

¡*(It is important to install Android studio and create one virtual device for the next step)*!

### ANDROID_HOME
* As first, we should create the variable ANDROID_HOME in User variables section with the value "C:\Users\\{YOURUSER}\AppData\Local\Android\Sdk"
* The next step is set up three variables in the Path of User variables:
* - %ANDROID_HOME%\platform-tools
* - %ANDROID_HOME%\tools
* - %ANDROID_HOME%\emulator
* - Make sure that the path %JAVA_HOME%\bin is there too

Test if it is OK
```
emulator -list-avds
```

***

## Installing appium server from NodeJs
```
npm install -g appium
```

The next step is install Appium Doctor tool
```
npm install -g appium-doctor
```

Now, we should run 
```
appium-doctor
```
to verify that all of the dependencies are set up correctly.
You can see the documentation [here](https://appium.io/docs/en/about-appium/getting-started/?lang=en#verifying-the-installation)

***

## Project compilation

It is important to compile the project before making a Pull Request in order to guarantee that the framework is working correctly.

```
mvn compile
```
And 
``` 
mvn clean
```
***

## Run tests


* Execute specific test using tags [Ex: smoke, regression]. The default suite is *smoke*
``` java
 mvn clean verify -DtestSuite=smoke
```

* These tests will be run for Android. If we want to run for iOS. The default driver is *android*
``` java
 mvn clean verify -DtestSuite=smoke -Dplatform=ios
```

* Run smoke tests (default) and report generation
``` java
 mvn clean verify aggregate
```

## Report
The report will be available at

``` 
├──appium-java
|   └── target
|       └── surefire-reports
|           └── index.html
```
