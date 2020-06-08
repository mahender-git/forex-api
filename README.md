# forex-api
#Step 1:
execute db script for database & collection creation.
#Step 2
please change the db details according to your database.
#Step 3
run the spring boot application.
#step 4
open the postman & invoke the endpoint with post request.
http://localhost:8091/forex-api/exchange
Request payload:
{
  "exchangeFrom": "USD",
  "exchangeTo": "JPY",
  "exchangeDate": "2020-06-07",
  "exchangeValue": 1
}
note:above fields are mandatory. exchangeValue should greater than 0. 
In above USD currency value exchanged to JPY currency.
Response
{
    "exchangeDate": "07-Jun-2020",
    "exchangeFrom": "USD",
    "exchangeTo": "JPY",
    "baseCurrency": "USD",
    "exchangeRate": 1,
    "convertedValue": 109.570849
}
