# Virta Application.
It has 2 module : 
- Virta
- Virta-consumer

## Virta
It supports CRUD for stations and companies.
It has 2 special APIs
1- Get all stations within the radius of n kilometers from a point (latitude, longitude) ordered by distance.
2- Get all stations including all the children stations in the tree, for the given company_id.
Swagger Address : http://localhost:8080/virta/swagger-ui

## Virta-consumer
It uses feign for make proxy for using Virta APIs.
Swagger Address : http://localhost:8081/virta-consumer/swagger-ui

### more
* One charging company can own one or more other charging companies.
* Hence, the parent company should have the access to all the child company's stations hierarchically. For example, we got 3 companies A, B and C accordingly with 10,5 and 2 stations. Company B belongs to A and company C belongs to B. Then we can say that company A has 17, company B has 7 and company C has 2 stations in total.

### Requirement
    java 11
### The database schema for start point
```JS
1. Station (id, name, latitude, longitude, company_id)
2. Company (id, parent_company_id, name)
```

