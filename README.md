# No country

## Nombre del Proyecto

descripcion...

## Ejecución del Proyecto
### Requisitos
<details>
<summary>  Java 17 </summary>

### **Java**
- **Descripción**: Java es un lenguaje de programación de propósito general, orientado a objetos y ampliamente utilizado para el desarrollo de aplicaciones empresariales. Su popularidad se debe a su portabilidad, rendimiento y robustez.
* Asegúrate de tener instalado Java JDK en tu sistema. Puedes verificarlo usando el siguiente comando en tu terminal o consola:
  ```bash
  java -version
  ```
    * Si no lo tienes, descarga e instala el [JDK desde aquí](https://www.oracle.com/java/technologies/downloads/#java11).
    * [Instructiones](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A__INSTALLINGTHEJDKANDJREONMICROSOFTWI-E04E8B17).

#### Configurar Variables de Entorno 

* ##### En Windows:
  * [Viode tutorial ](https://www.youtube.com/watch?v=TRsCMJrKglw)
  * Abre las propiedades del sistema:
  * Haz clic derecho en "Este PC" o "Mi PC", selecciona "Propiedades".
  * Ve a "Configuración avanzada del sistema".
  * Haz clic en "Variables de entorno".
  * Configurar JAVA_HOME:
  * En "Variables del sistema", haz clic en "Nuevo".
  * Nombre de la variable: JAVA_HOME.
  *  Valor de la variable: la ruta donde está instalado tu JDK (ej, C:\Program Files\Java\jdk-17).
  *  Agregar Java al PATH:
  *  Busca la variable Path en "Variables del sistema" y haz clic en "Editar".
  *  Añade una nueva entrada con la ruta %JAVA_HOME%\bin.
  *  Guarda los cambios y reinicia la terminal.
* ##### En Linux/MacOS:
  *  Abre un terminal y edita el archivo de perfil (como .bashrc, .bash_profile, o .zshrc dependiendo de tu shell):
  ````bash
  Copiar código
  nano ~/.bashrc
  ````
  * Añade las siguientes líneas:
  ```bash
  export JAVA_HOME=/ruta/a/tu/jdk
  export PATH=$JAVA_HOME/bin:$PATH
  ```
  * Guarda los cambios y ejecuta:
  ```bash
  source ~/.bashrc
  ```
</details>

<details>
<summary>  Maven </summary>

### **Maven**
* Puedes verificar si ya tienes Maven instalado ejecutando:
    ```bash
    mvn -version
    ```
    * Si no lo tienes, puedes descargarlo de [aquí](https://maven.apache.org/download.cgi) e instalarlo.
    * [Instructiones](https://maven.apache.org/install.html).
  
#### Instalación de Maven en Windows.
  * Visita la página oficial de descarga de Apache Maven.
  * Descarga la versión binaria ZIP (por ejemplo, apache-maven-3.9.5-bin.zip).
  * Descomprime el archivo ZIP en una carpeta, por ejemplo: C:\Program Files\Apache\Maven.
  * Haz clic derecho en "Este PC" o "Mi PC" y selecciona "Propiedades".
  * Ve a "Configuración avanzada del sistema" y haz clic en "Variables de entorno".
  * Busca la variable Path en "Variables del sistema" y haz clic en "Editar".
    Añade una nueva entrada con la ruta (ej, C:\Program Files\Apache\Maven\apache-maven-3.9.9\bin).
  * Abre una terminal (PowerShell o CMD).
    ```bash
    mvn -version
    ```
  * Si Maven está correctamente instalado, verás la versión de Maven y de Java configurada.

</details>

### Demo

1) Bajar el proyecto y acceder

```bash
git clone https://github.com/No-Country-simulation/c21-11-m-java-angular
cd c21-11-m-java-angular
git switch develop-back
```

2) Iniciar el backend

```bash
cd demo
mvn spring-boot:run -D spring-boot.run.profiles=dev
```

2) Acceder a la API

API - http://localhost:8080/swagger-ui/index.html

falta la configuracion de mySQL ...
y la de las variables de entorno

  
