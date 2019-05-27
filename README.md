# Product Rating Service
Product Rating Service

It is a Spring boot application for getting Product Ratings. It exposes following rest endpoints:

GET /ratings/{productId}
Used to get aggregated rating for input productId


Other tools used: 

DB - AggregatedReview - It uses mongoDB to store rating data. 

Kafka event consumer - It consumes NewReviewAddedEvent from Kafka topic and updates AggregatedReview (Product Rating) data in DB.

Deployment instructions: https://github.com/Anvipatel/rating/blob/master/build.sh
It needs revrep application - https://github.com/Anvipatel/revrep

Test URL: http://35.237.77.248:8103/swagger-ui.html#
