# Grocery Store - Products API
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)

## :point_right: About
This is a fictional API rest made to be consumed by other services (as a stock manager, sells manager etc...) that list products and its sections.

## :point_down: Heroku deploy
https://grocerystore-products.herokuapp.com/


## :link: Endpoints
### Sections
1. Return all the sections in the database || Insert a new section
```
(GET and POST) - /sections
```

```
Post JSON format:
{
  "name": "new section name"
}
```


2. "Action"ById: Return the section and its products || Update the section (only the name) || 
Delete the section (only if the section has no products)
```
(GET - PUT - DELETE) - /sections/{id}
```



### Products
1. Return all the products || Insert a new product
```
(GET) - /products
```

```
Post JSON format:
{
    "name": "NEW PRODUCT",
    "price": 9.99,
    "stock": 99,
    "section": {
        "id": 9,
        "name": "section's name"
    }
}
```

2. "Action"ById: Return the product (get - 200 ok) || Update the product (put - 204 no content) || 
Delete the product (delete - 204 no content)
```
(GET - PUT - DELETE) - /product/{id}
```


## :cd: Getting Started (Only if you clone/fork the repository)
### Starting with H2 Database
1. Change the active profile in "application.properties" to "test". Now you're using the H2 Database to run the application.
2. Run the application using your favorite IDE with SpringBoot.
PS.: If the application doesn't work after step 1, copy the "application-test.properties" data, and paste it into "application.properties". Then, go to "TestCongig" file
(inside "config" package) and comment the annotation "@Profile(value = "test")"

## Important:
If you find any error, or want to make the API better, feel free to make your pull requests :smile:

