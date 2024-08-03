CodeCraft Web
================================

### CodeCraft Web use Axelor Open Suite to build multi-domain web applications.

This is the project template, which you can customize to suit your needs by following the configuration/customization instructions.

Installation
================================

```
git clone https://github.com/CodeCraftOrg/codecraft-web.git
```

This project use Gradle to build the project.

```bash
./gradlew clean
```
```bash
./gradlew build
```

You can run the webapp with copy the war into your web server. (ex : Apache Tomcat)

The generated war can be found in the [build/libs](build/libs) output directory.

Axelor configuration
================================
It is not a fork of Axelor Webapp, but, you can configure the desired version in the dependencies section of the [versions.gradle](versions.gradle) file :

```
ext.openSuiteVersion = '8.1.3'

dependencies {
api "com.axelor.apps:axelor-base:${openSuiteVersion}"
}
```

The list of Axelor Open Suite applications can be found here : [List of Axelor Open Suite applications](https://axelor.com/fr/toutes-les-applications/)

The packages can be found here : [Axelor Nexus packages](https://repository.axelor.com/nexus/#browse/search=group.raw%3Dcom.axelor.apps/)

Every Axelor package contain the compiled sources.

To set the server properties, you can see the Axelor documentation : https://docs.axelor.com/adk/7.1/tutorial/step6.html

Codecraft configuration
================================

You can customize the webapp by adding other modules or existing Codecraft applications :

```bash
$ git submodule add -f <remote_url> <modules/[module name|app name]>
```

The current list of Codecraft modules/applications is :

* [codecraft-core](https://github.com/CodeCraft-developpement/codecraft-core/)
* [codecraft-base](https://github.com/CodeCraft-developpement/codecraft-base/)
* [codecraft-import-export](https://github.com/CodeCraft-developpement/codecraft-import-export/)

You can find the installation guide in every repository.