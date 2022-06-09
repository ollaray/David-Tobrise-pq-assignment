# Payconiq
Project Demo For Payconiq
Note: To run this application, it is important to have docker installed.
You may choose either installation methods (Installation 1 or 2)

**INSTALLATION** 1:
  Just do a docker pull with this command:
  >docker pull ollaray/payconiq-david-tobrise.jar

**INSTALLATION** 2:
 -clone this repo
 -CD to the project Directory
 -Run the following commands:
 #docker build -t payconiq-david-tobrise.jar . 
 #docker run -p:9090:8085 payconiq-david-tobrise.jar
 
** **API DOCUMENTATION**:
 
** **CREATE A STOCK****:
    EndPoint: http://localhost:9090/api/stocks/
    Method: POST
    ContentType: JSON
    Request Body:{"name":"Bluetooth Speaker","price": "10.0","lastUpdate":"2022-06-06T16:42:30.895+00:00" }
    ResponseType:JSON
 
** **LIST ALL STOCKS**
   EndPoint: http://localhost:9090/api/stocks/
   Method: GET
   ContentType: JSON
   ResponseType:JSON
   
** **GET A STOCK**
     EndPoint: http://localhost:9090/api/stocks/1
     Method: GET
     ContentType: JSON
     ResponseType:JSON
     
 **UPDATE A STOCK**
       EndPoint: http://localhost:9090/api/stocks/1
       Method: PATCH
       ContentType: JSON
       Request body:{"name":"Home Theater Speaker","price": "10.0","lastUpdate":"2022-06-06T16:42:30.895+00:00" }
       ResponseType:JSON
   
 **DELETE A STOCK**
       EndPoint: http://localhost:9090/api/stocks/1
       Method: Delete
       ContentType: JSON
       ResponseType:JSON
       
 
