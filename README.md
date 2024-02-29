# App Ecommerce Prices

### Connection to database H2
- Database Name: testdb
- UserName: sa
- Password: ecommercetext

### Curls
>[!NOTE]
>I have implemented two Rest endpoints due ambiguity in the final response

#### Curl one
```json
curl --location --request GET 'http://localhost:8080/api/price' \
--header 'Content-Type: application/json' \
--data '{
    "applicationDate": "2020-06-14 18:00:00",
    "productIdentifier": "3545"
}'
```
#### Response curl one
```json
{
    "id": 2,
    "brandId": 1,
    "startDate": "2020-06-14T15:00:00",
    "endDate": "2020-06-14T18:30:00",
    "priceList": "2",
    "productId": 35455,
    "priority": 1,
    "price": 25.45,
    "curr": "EUR"
}
```

![Alt text](https://github.com/afrancom2/spring-ecommerce-text/blob/master/responsecurlone.png "Curl One")

#### Curl two
```json
curl --location --request GET 'http://localhost:8080/api/priceString' \
--header 'Content-Type: application/json' \
--data '{
    "applicationDate": "2020-06-14 10:00:00",
    "productIdentifier": "35455"
}'
```
#### Response curl two
```json
{
    "productId": 35455,
    "chain": "request at 10:00 a. m. on the 14 for the product 35455 for brand 1",
    "dateApplicable": "2020-06-14T10:00:00",
    "priceFinal": 35.5
}
```

![Alt text](https://github.com/afrancom2/spring-ecommerce-text/blob/master/responsecurlone.png "Curl One")
