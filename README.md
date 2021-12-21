# Proyecto ABMPracticas


## Herramientas utilizadas en el Proyecto
### Proyecto abmpractica-web
[Node 10.13.0]()
[NPM 6.4.1]()

### Prouecto abmpractica-api
[JDK 8](https://www.oracle.com/ar/java/technologies/javase/javase8-archive-downloads.html)
[NetBeans 12.5](https://netbeans.apache.org/download/nb125/nb125.html)
[Glassfish 5]()
[MySql 8](https://dev.mysql.com/downloads/file/?id=508935)





### Configurar el proyecto abmpractica-api por primera vez
CARGAR DATOS A MYSQL



Abrir el proyecto utilizando NetBeans

Modificar el archivo application.properties ubicado /src/main/resources utilizando los valores correspondientes

```
spring.datasource.url=jdbc:mysql://localhost:3306/abm_practica?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username={USUARIO DE MYSQL}
spring.datasource.password={PASSWORD DEL USUARIO DE MYSQL}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
```



## Arquitectura del proyecto
![](https://github.com/Hashiyama89/ABMPracticas/blob/main/arquitectura.png)
