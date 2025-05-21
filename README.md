# CFDI - Java

[![Pruebas previas a integración](https://github.com/percontmx/cfdi-java/actions/workflows/pre_integration_tests.yml/badge.svg)](https://github.com/percontmx/cfdi-java/actions/workflows/pre_integration_tests.yml)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/percontmx/cfdi?color=green&label=Versi%C3%B3n)
[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
[![Donaciones](https://img.shields.io/badge/Donate-PayPal-blue.svg)](https://paypal.me/alexpercont)

## Descripción

Paquetes Java para dar soporte a Comprobante Fiscal Digital por Internet.

## Como utilizarlo

### Como dependencias de Maven

1. Agrega las siguientes líneas en la sección de `<servers>` de tu archivo de configuración de Maven 
   (`$M2_HOME/conf/settings.xml` o `~/.m2/settings.xml`):
   
```
<server>
    <id>github</id>
    <username>tuUsuarioDeGithub</username>
    <password>tuToken</password>
</server>
```

2. Agrega la siguiente dependencia en la sección `<dependencyManagement>` de tu archivo `pom.xml`:

```
<dependency>
    <groupId>io.github.percontmx.cfdi</groupId>
    <artifactId>bom-all</artifactId>
    <version>1.1</version>
    <type>pom</type>
    <scope>import</scope>
</dependency>
```

3. En tu sección de `<dependencies>` agrega los componentes que necesites. Para agregar, por ejemplo, el paquete de CFDI
   3.3, agrega lo siguiente:
   
```
<dependency>
    <groupId>io.github.percontmx.cfdi</groupId>
    <artifactId>cfdi-v3_3</artifactId>
</dependency>
```

#### Ejemplo

```
<?xml version="1.0" encoding="UTF-8" ?>
<project xmlns="http://maven.apache.org/POM/4.0.0">
  <modelVersion>4.0.0</modelVersion>
  <groupId>io.mycompany</groupId>
  <artifactId>cfdi-ejemplo</artifactId>
  <version>1.0.0-SNAPSHOT</version>

  <dependencyManagement>
     <dependencies>
        <dependency>
            <groupId>io.github.percontmx.cfdi</groupId>
            <artifactId>bom-all</artifactId>
            <version>1.1</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
  </dependencyManagement>

  <dependencies>
    <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>cfdi-v3_3</artifactId>
    </dependency>

    <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>nomina-v1_2</artifactId>
    </dependency>

    <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>tfd-v1_1</artifactId>
    </dependency>
  </dependencies>
</project>
```
