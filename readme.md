SAT CRUD APPLICATION
    
     Before Starting the applicaiton 
        
     Please Configure application.properties file
     as per your local system

     //Create the MYSQL DATABASE sat in workbench

     spring.datasource.url=jdbc:mysql://localhost:3306/sat
     spring.datasource.username=root //Your MySQL Username
     spring.datasource.password=root //Your MySQL Password
     spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
     spring.jpa.show-sql = true
     spring.jpa.generate-ddl=true



     jpa.hibernate.ddl-auto=update
     jpa.hibernate.show-sql=true
     jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

Run the Application on http://localhost:8080 (or your custom specified port)
