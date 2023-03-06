Online movie ticket booking platform that caters to both B2B (theatre partners) and B2C (end customers) clients

**Functional Requirements**

- Enable theatre partners to onboard their theatres over this platform and get access to a bigger customer base while going digital. 
 
- Enable end customers to browse the platform to get access to movies across different cities, languages, and genres, as well as book tickets in advance with a seamless experience.

We start with four micro service architecture to fulfill the above objectives so that future upscaling to cater to more customers and larger areas.
- Registration Service - This does CRUD operations of Theaters, Movies and Users.
- Show Inventory Service - Create, update, and delete shows for the day for Theater and Movie. Allocate seat inventory and update movie shows with seats and ticket price.
- Booking Service - Users use this for booking ticket, cancelling ticket.
- UI Service - For a city, get all movies. For a movie selected, get all theaters running it. Then based on a chosen date, get all the various shows of the movie.

