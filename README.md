# Proyecto ABMPracticas
El proyecto se compone de dos paquetes:
* abmpractica-web: El cual contiene el frontend y se ejecute del lado cliente
* abmpractica-api: El cual contiene el backend y se ejecuta del lado servidor


## Herramientas utilizadas en el Proyecto
[Node 10.13.0](https://nodejs.org/dist/v10.13.0/node-v10.13.0-x64.msi)
[JDK 11.0.12](https://www.oracle.com/ar/java/technologies/javase/jdk11-archive-downloads.html)
[NetBeans 12.5](https://netbeans.apache.org/download/nb125/nb125.html)
[Glassfish 5.0](https://javaee.github.io/glassfish/download) (Se puede descargar desde NetBeans) Necesita del JDK 1.8 para funcionar
[MySql 8](https://dev.mysql.com/downloads/file/?id=508935)



### Configurar el proyecto abmpractica-api por primera vez
1. Abrir el proyecto utilizando NetBeans
2. En la pestaña de servicios, adañir un nuevo servidor de Glassfish con las version 5.0
3. Abrir el archivo application.properties ubicado /src/main/resources y reemplazar los valores correspondientes

   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/mysql?useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username={USUARIO DE MYSQL}
   spring.datasource.password={PASSWORD DEL USUARIO DE MYSQL}
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
   spring.jpa.generate-ddl=true
   spring.jpa.hibernate.ddl-auto=update
   ```

4. En la pestaña del proyecto, hacer click derecho en el proyecto y ejecutar la opcion `Build`
5. Una vez que termina de hacer el build, hacer click derecho en el proyecto y ejecutar la opcion `Run`
6. Si el proyecto levanta correctamente, debe abrir una url, al cual se debe cerrar




### Configurar el proyecto abmpractica-web por primera vez
1. En una terminal en la carpeta raid del proyecto correr el comando

	`npm install`

2. Una vez terminada la instalación, para levantar el servidor node, correr el comando

	`npm start`

3. Una vez que levanta el servdidor node, en un navegador web entrar a la url `http://localhost:4200/` (Url por defecto)



## Arquitectura del proyecto
![](https://github.com/Hashiyama89/ABMPracticas/blob/main/arquitectura.png)
