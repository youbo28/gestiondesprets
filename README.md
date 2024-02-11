
# Spring Gestion Des Pret(Loans management)

## Overview 
this is spring mini project that simulate  Loan management software created using 
spring,postgresql and angular 17 as frontend(the link will be provided)
## spring Element
### entities 
#### employe(idEmploye : integer ,nomComplet: string,post : string , prets:Pret[] );
#### Pret(id : integer,montant:float,dureeEnMois:integer,employe:Employe);
### Restcontrollers
## API Reference
### Employe endpoint

#### get all emloyes

```https
  GET https://localhost8080:/api/employe
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| / | `string` | no key required for this endpoint |

#### Get Employe by id 

```https
  GET https://localhost8080:/api/employe/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employe to fetch the elmpoye |


#### create new  Employe 

```http
  POST https://localhost8080:/api/employe/
```

| body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nomComplet`      | `String` | **Required** ,**notNull** ,**notEmpty**. the name of the employe  |:-------------------------------- |
| `post`      | `String` | **Required** ,**notNull** ,**notEmpty**. the job title of the employe  |:-------------------------------- |
| `salaire`      | `integer` | **Required** **Positive** **NOtZero**. The Employe salary |



#### update existing  Employe 

```http
  PUT https://localhost8080:/api/employe/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required** ,**notNull** ,**notEmpty**. the id of the employe  |:-------------------------------- |
| `post`      | `String` | **Required** ,**notNull** ,**notEmpty**. the job title of the employe  

| body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nomComplet`      | `String` | **Required** ,**notNull** ,**notEmpty**. the name of the employe  |:-------------------------------- |
| `post`      | `String` | **Required** ,**notNull** ,**notEmpty**. the job title of the employe  |:-------------------------------- |
| `salaire`      | `integer` | **Required** **Positive** **NOtZero**. The Employe salary |

#### delete Employe by id 

```https
  DELETE https://localhost8080:/api/employe/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employe to delete the elmpoye |

### Pret endpoint
#### get all Prets

```https::
  GET https://localhost8080:/api/prets
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| / | `string` | no key required for this endpoint |

#### Get Pret by id 

```https
  GET https://localhost8080:/api/Prets/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employe to fetch the loan |

#### create new  loan 

```http
  POST https://localhost8080:/api/prets/
```

| body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `montant`      | `Float` | **Required** **Positive** . the price of the employe  
| `dureeEnMois`      | `integer` | **Required** ,**notNull** ,**notEmpty**. the time of the loan  
| `statut`      | `integer` | **Required** **Approved** **Rejected** **Pending** . The Status of the loan 
| `statut`      | `integer` | **Required** **Approved** **Rejected** **Pending** . The Status of the loan |
| `employe`      | `Employe` | **Required**  . Employe object must have idEmploye|

#### update existing  loan 

```http
  PUT https://localhost8080:/api/prets/{id}
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employe to fetch the loan |


| body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required** **notNull** . the id of the loan 
| `montant`      | `Float` | **Required** **Positive** . the price of the employe  
| `dureeEnMois`      | `integer` | **Required** ,**notNull** ,**notEmpty**. the time of the loan  
| `statut`      | `integer` | **Required** **Approved** **Rejected** **Pending** . The Status of the loan 
| `statut`      | `integer` | **Required** **Approved** **Rejected** **Pending** . The Status of the loan |
| `employe`      | `Employe` | **Required**  . Employe object must have idEmploye|


#### Get Pret by id 

```https
  DELETE https://localhost8080:/api/Prets/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. Id of employe to Delete the loan |

## Run Locally

Clone the project

```bash
  git clone https://github.com/youbo28/gestiondesprets.git
```

Go to the project directory gestiondespret 

#### Access /src/main/resources/application.properties
  #### Change the varibles based on your envirement
 #### spring.datasource.url=jdbc:postgresql://localhost:5433/gestiondespret **change the link based on your postgresql configuration **
#### you have to create the database manually however  the data are  integrated in data.sql in **gestiondespret/src/main/resources/data.sql**
#### spring.datasource.username=**your postgresql username**
#### spring.datasource.password=**your password**

