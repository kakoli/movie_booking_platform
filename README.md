Online movie ticket booking platform that caters to both B2B (theatre partners) and B2C (end customers) clients

**Functional Requirements**

- Enable theatre partners to onboard their theatres over this platform and get access to a bigger customer base while going digital. 
 
- Enable end customers to browse the platform to get access to movies across different cities, languages, and genres, as well as book tickets in advance with a seamless experience.

We start with four micro service architecture to fulfill the above objectives so that future upscaling to cater to more customers and larger areas.
- Registration Service - This does CRUD operations of Theaters, Movies and Users.
- Seat Inventory Service - Create, update, and delete shows for the day for Theater and Movie. Allocate seat inventory and update movie shows with seats and ticket price.
- Booking Service - Users use this for booking ticket, cancelling ticket.
- UI Service - For a city, get all movies. For a movie selected, get all theaters running it. Then based on a chosen date, get all the various shows of the movie.

H/L or System Design and ER Diagram is added to the word doc.

**Technologies used and Implementation**

Microservice implementation is in SpringBoot with Java as the implementation language and MySQL is the RDBMS database chosen as there are transactional data like booking and the entities are bound by relations.

The microservices expose their respective functionality via REST calls using web layer of Spring modelled after MVC pattern.

Builder pattern is used to build the models and REST request response objects.

Spring library used - Spring-data-jpa which provides repository support for JPA data sources, here MySQL.

Other libraries - Lombok for logging, builder, getter and setter on the model classes and the REST request response objects.
Build and Dependency - Maven

**SeatInventoryService API :**
This is modelled into Controller, Service and Repository packages

1. POST /api/v1/seatInventory

*{
    "movie_name": "Pathaan",
    "theater_name": "PVR",
    "show": "EVENING",
    "show_date": "2022-01-10"
}*

2. GET api/v1/seatInventory/theater/{theaterName}/movie/{movieName}
Returns List of ShowDetails.

3. PUT api/v1/seatInventory

*{
    "movie_name": "Pathaan",
    "theater_name": "PVR",
    "seat_count": 50,
    "ticket_price": 250.70
}*

4. DELETE /api/v1/seatInventory/{showId}

5. Bulk creation of seatInventory, say for a new movie, creation of all shows for the next 7 days in one API.

This service and other microservices use the common module **platform-model**. This has all the model classes, REST request response objects and all the
JPA Entity objects.
Have implemented the first 3 APIs.


**BookingService API :**
1. POST /api/v1/ticketBooking
*{
    "movie_name": "Pathaan",
    "theater_name": "PVR",
    "show": "EVENING",
    "show_date": "2022-01-10"
    "seat_count": ""
}*
This operation adds an entry to BookingDetails table and updates ShowDetails table with reduced seat count.
Both should happen in 1 transaction. Here discount rules, if any, are applied.

2. DELETE /api/v1/ticketBooking/{id}
This operation cancels the booking, deletes entry to BookingDetails table and updates ShowDetails table in 1 transaction.

User-id is needed for both transactions. 

**Non Functional Requirements**
- Scalability and Availability - For scalability the microservices need to be deployed on public cloud 
infrastructure like AWS, preferably on managed container services like Fargate.

- Caching - As the platform is upscaled to extend to countries and more cities, browsing through list of 
theaters, movies etc needs to have caching instead of fetching from database everytime. For this distributed 
in-memory cache, Redis is a choice.

- Security -  all data inside the system or its part should be protected against malware attacks or 
unauthorized access. Security NFR can include specific security standards and/or encryption
methods, types of  malware attacks to fend off, guidelines like no storage of hard coded 
sensitive information.

- Monetize platform - Theater owners while onboarding their theater onto the platform need to pay 
'fees' which can be based on multiple variables like number of screens in the theater, theater location etc.
Also users while booking tickets need to pay a 'convenience' fee for getting the services.
Advertisements on the platform site(mobile/desktop)

- Integration with payment gateway - Booking Service needs to have integration with payment gateways like RazorPay

TBD :
Unit test cases
General cleanup and review of code.
Log not coming up in console
