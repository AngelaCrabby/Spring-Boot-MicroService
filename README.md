# Spring-Boot-MicroService

##Run application:
~~~
  Terminal One:
       cd running-information-analysis-service
       docker-compose up
  Terminal Two:
       cd running-information-analysis-service
       mvn clean install        [BUILD SUCCESS]
       cd target/
       java -jar running-information-analysis-service-1.0-SNAPSHOT.jar      [Tomcat : 9000]
~~~
##Test Rest API
~~~
1.postman: POST -> URL:  http://localhost:9000/bulk/runningInformation
           Body -> raw -> JSON -> Data:  running.json -> Send
           Response:  201
  
 Check Result: 
           URL:  localhost:9000       [open HAL Browser]
   HAL Browser:  Explorer -> URL:  http://localhost:9000/all?page=0&size=10  -> Go!
                 Properties -> totalElements

2. HAL Browser:  Explorer -> URL:  http://localhost:9000/information/search/user?username=ross0  -> Go!
                 Embedded Resources -> runningInformations[0] -> Properties

3. HAL Browser:  Explorer -> URL:  http://localhost:9000/information/search/runningId?runningId=7c08973d-bed4-4cbd-9c28-9282a02a6032   -> Go!
                 Embedded Resources -> runningInformations[0] -> Properties

4. HAL Browser:  Explorer -> URL:  http://localhost:9000/healthWarningLevel?page=0   [1st page]
                             URL:  http://localhost:9000/healthWarningLevel?page=3   [last page]
                             URL:  http://localhost:9000/healthWarningLevel?page=2   [middle page]

5.postman: DELETE -> URL:  http://localhost:9000/purge/2f3c321b-d239-43d6-8fe0-c035ecdff232  -> Send

 Check Result:
   HAL Browser:  Explorer -> URL:  http://localhost:9000/all?page=0&size=10  -> Go!
                 Properties -> totalElements   
~~~