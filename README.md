# CFDI - Java

![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/percontmx/cfdi-java/.github%2Fworkflows%2Fdeploy_snapshot.yml)
![GitHub Latest Release](https://img.shields.io/github/v/release/percontmx/cfdi-java)
![Maven Central](https://img.shields.io/maven-central/v/io.github.percontmx.cfdi/cfdi-java.svg)
![GitHub License](https://img.shields.io/github/license/percontmx/cfdi-java)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=percontmx_cfdi-java&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=percontmx_cfdi-java)

Clases Java para dar soporte al Comprobante Fiscal Digital por Internet (CFDI),
de acuerdo a las especificaciones del Servicio de Administración Tributaria
(SAT) de México.

## Como utilizarlo

Importa el paquete `bom` en la sección de `dependencyManagement` de tu
   `pom.xml`.

```xml
<dependencyManagement>
   <dependencies>
      <dependency>
          <groupId>io.github.percontmx.cfdi</groupId>
          <artifactId>bom</artifactId>
          <version>2.3.0</version>
          <type>pom</type>
          <scope>import</scope>
      </dependency>
</dependencyManagement> 
```

Después, agrega las dependencias que necesites en la sección de `dependencies`.

```xml
<dependencies>
   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>cfdi-v32</artifactId>
   </dependency>

   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>cfdi-v33</artifactId>
   </dependency>
   
   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>cfdi-v40</artifactId>
   </dependency>

   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>complementos-nomina-v11</artifactId>
   </dependency>

   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>complementos-nomina-v12</artifactId>
   </dependency>

   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>tfd-v1_0</artifactId>
   </dependency>

   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>tfd-v1_1</artifactId>
   </dependency>
   
   <dependency>
      <groupId>io.github.percontmx.cfdi</groupId>
      <artifactId>retenciones-v1</artifactId>
   </dependency>
   
   <!-- Nuevos paquetes agregados en la versión 2.3.0 -->
   <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>cfdi-wrappers-v32</artifactId>
   </dependency>
   <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>cfdi-wrappers-v33</artifactId>
   </dependency>
   <dependency>
        <groupId>io.github.percontmx.cfdi</groupId>
        <artifactId>cfdi-wrappers-v40</artifactId>
   </dependency>
</dependencies>
```

## Paquetes disponibles.

* [CFDI v3.2](cfdi/v32)/[CFDI v3.2 Wrapper](cfdi-wrappers/wrapper-v32)
* [CFDI v3.3](cfdi/v33)/[CFDI v3.3 Wrapper](cfdi-wrappers/wrapper-v33)
* [CFDI v4.0](cfdi/v40)/[CFDI v4.0 Wrapper](cfdi-wrappers/wrapper-v40)
* [Complemento de nómina v1.1](complementos/nomina-v11)
* [Complemento de nómina v1.2](complementos/nomina-v12)
* [Timbre fiscal digital v1.0](complementos/timbre-fiscal-v10)
* [Timbre fiscal digital v1.1](complementos/timbre-fiscal-v11)
* [Retenciones v1.0](retenciones/v1)