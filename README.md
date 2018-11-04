Open FlightReservationClasses.xml in draw.io

Implement Gulp, BrowserSync, sass

Create flight ticket;
1) ID
2) Name
3) Surname
4) direction (one/two direction)
5) departure date
6) included amenities (food, etc.)
7) luggage (checked(big) / hand luggage)
8) coupon number
9) Price

View flight ticket;
Delete flight ticket;
Update flight ticket;

Create flight;
View flights;
Update flight;
Delete flight;

View available seats;
View flight reservations;

Create endpoints to return:
1) flights per depart country (from Spain);
2) flights per date (on 12.01.2019);
3) flights for certain date and country depart from (from Spain on 12.01.2019)
4) flights per date and country and destination country (Spain to Riga on 12.01.2019)
5) flight's included amenities, like food, sleep pillows, tv-screen

second reservation:
6) flight's plane's name, model and description(Boeing 747)
7) flight's captian and biography (Christopher Stewarts)

third microservice:
8) links to Taxi services in destination country
9) links to partner's insurance companies


Domain: flight
Resources: Reservation, Luggage, Amenity
Versions: v1

second microservice
Domain: plane
Resources: Brief, Description
Versions: v1

Domain: pilot
Resource: Brief, Biography
Version: v11

Third microservice:
Domain: Taxi
Resource: Companies
Version: v1

Domain: Insurance
Resource: Companies
Version: v1

Check how to implement tokens.