# Hands-On |  Spring API
<img src="https://img.shields.io/badge/by-Alejandro.Fuentes-informational?style=flat-square&logoColor=white&color=cdcdcd" />

> This project is for DIO platform study.
> 
> <img src="https://img.shields.io/badge/Java-232F3E?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java language"/>
> <img src="https://img.shields.io/badge/Spring-232F3E?style=for-the-badge&logo=Spring&logoColor=white" alt="Spring framework"/>
> <img src="https://img.shields.io/badge/PostgreSQL_DB-232F3E?style=for-the-badge&logo=PostgreSQL&logoColor=white" alt="Postgresql database"/>
> <img src="https://img.shields.io/badge/H2_DB-232F3E?style=for-the-badge&logoColor=white" alt="H2 database"/>
> <img src="https://img.shields.io/badge/Cloud_Railway-232F3E?style=for-the-badge&logoColor=white" alt="Amazon AWS"/>

> 🧰 **Technologies**
> 
> * JAVA <br>
> * H2 - Data Base (_DEV environment_) <br>
> * Postgres - Data Base (_PRD environment_) <br>
> * Spring Boot 3 <br>
> * Spring Data JPA <br>
> * OpenAPI (_Swagger_) <br>
> * RailWay (_Cloud_) <br>

**DEV Environment Sections**
* [Step 1 | Create spring project](#step-1--create-spring-project)
* [Step 2 | Versioing in one repository](#step-2--versioning-in-one-repository)
* [Step 3 | Abstraction for UX design](#step-3--abstraction-from-ux-design)
* [Step 4 | Entities on Model Layer](#step-4--entities-on-model-layer)
* [Step 5 | Business on Services Layer](#step-5--business-on-service-layer)
* [Step 6 | RESTful on Controller Layer](#step-6--restful-on-controller-layer)
* [Step 7 | Handler Exceptions](#step-7--handler-exceptions)

**PRD Environment Sections**

* [Prepare `properties-prd.yml` file](#prepare-properties-prdyml-file)
* [1º modification : Prepare `build.gradle`](#1º-modification--prepare-buildgradle)
* [2º modification : Create file `Procfile`](#2º-modification--create-file-procfile)

## Steps DEV

### Step 1 | Create spring project

We can use the [Spring Initializr][link-initializr] to create our project.
This site is a good platform where we can create the structure of our project quickly and easily.

#### tools that were used in this project

* Spring Web
* Spring Data JPA (_Java Persistence API_)
* H2 Database (_in-memory database that support JDBC API and R2DBC access_)
* PostgreSQL Driver

### Step 2 | Versioning in one repository

We can use some repository platforms such GitLab, GitHub, and so on.

#### steps for it
**in the platform (remote repository)**
1. create one account
2. create one repository in the chosen platform

**in the local terminal**
3. create a work folder
4. start `git init`
5. link with our remote repository `git remote add <url-of-our-remote-repository>`
6. after adding or changing some files, to do synchronize 

```bash
git commit -m"some message"
git push
```

### Step 3 | Abstraction from UX design

In this [figma graph][link-figmaabstration] is where I did abstraction.

I use [Json editor online][link-jsoneditoronline] how tools for create abstraction. Next if my result to abstraction in JSON format:

```json
{
  "name": "alefuuu",
  "account": {
    "picture": "myphoto.jpg",
    "number": "1230032100-10",
    "agency": "0001",
    "balance": 1234.12,
    "accountLimit": 10000.00
  },
  "cards": [
    {
      "number": "xxxx xxxx xxxx 0010",
      "name": "ale fuuuu",
      "valid": "12/24",
      "cardLimit": 5000.00
    },
    {
      "number": "xxxx xxxx xxxx 0021",
      "name": "ale fuuuu 21",
      "valid": "08/25",
      "cardLimit": 7500.00
    }
  ],
  "transactions": [
    {
      "icon": "Nubank.jpg",
      "description": "Deposit from my",
      "amount": 150.00,
      "date": "28/03/2024"
    }
  ],
  "weekActivities": [
    {
      "activityDay": "Sunday",
      "amountIn": 150.00,
      "amountOut": 75.00
    }
  ],
  "expenseStatistics": [
    {
      "percent": 20.00,
      "description": "Investment"
    }
  ],
  "quickTransfers": [
    {
      "icon": "",
      "name": "Daniel Fuentes",
      "title": "Designer"
    }
  ],
  "balanceHistories": [
    {
      "monthBalance": "March",
      "amount": 575.00
    }
  ]
}
```

> 💡 **TIPs**: After get our abstraction we can use IA for generate our class representations.
>   How promtp, did use: 
> 
>   _Generate a class diagram (using Mermaid syntax) given the following JSON that represents a database user. Keep a simple structure and faithful to the model I will give:_

Next result of our Abstraction:

```mermaid
classDiagram
	class User {
		-String icon 
		-String name 
		-Account account 
		-List<Card> cards 
		-List<Transaction> transactions 
		-List<WeekActivity> weekActivity 
		-List<Expense> expenses 
		-List<QuickTransfer> quickTransfers 
		-List<BalanceHistory> balanceHistory 
	}
	class Account {
		-String number 
		-String agency 
		-float balance 
		-float limit 
	}
	class Card {  
		-String number 
		-String name 
		-String valid 
		-float limit
	}
	class Transaction {  
		-String icon 
		-String description 
		-float amount 
		-String date 
	}
	class WeekActivity {  
		-String day 
		-float amountIn 
		-float amountOut 
	}
	class ExpenseStatistics {  
		-int percent 
		-String description 
	}
	class QuickTransfer {
		-String icon
		-String name
		-String title
	}
	class BalanceHistory {
		-String month
		-float amount
	}

	User "1" --* "1" Account : Composition
	User "1" --* "0..n" Card : Composition
	User "1" --* "0..n" Transaction : Composition
	User "1" --* "0..n" WeekActivity : Composition
	User "1" --* "0..n" ExpenseStatistics : Composition
	User "1" --* "0..n" QuickTransfer : Composition
	User "1" --* "0..n" BalanceHistory : Composition
	
	style User fill:#cdcdcd,stroke-width:0px
```

### Step 4 | Entities on Model Layer

Create all models inner `model` package (_Object Relations Mapping (ORM)_).

Add configuration in `properties.yml` for access to H2 memory DB.

```yaml
application:
  title: API Rest Cloud - LAB
  version: v1.0
  author: Alejandro Fuentes - alefuentes.edu
spring:
  application:
    name: api-rest-cloud-lab-2024
  # Database
  datasource:
    url: jdbc:h2:mem:apirestlab2024
    username: alefu
    password: 
  jpa:
    show-sql: true
    open-in-view: false
    hibernate:
      ddl-auto: create # validate | update | create | create-drop
    properties:
      hibernate:
        format_sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
      settings:
        trace: false
        web-allow-others: false
```

> ✒️ OBS. we can see our H2 database using this link `http://localhost:8080/h2-console/`.
> 
> For connect see `properties.yml` file configuration, the section `h2`
> 

### Step 5 | Business on Service Layer

In this step, to create the Service where to apply business rules.
The best practice says:

1. create a Service interface for my Entity
2. implement these Service interfaces in my class

### Step 6 | RESTful on Controller Layer

Next, is time to create endpoints for clients can consume our service.
Now, for testing, we can incorporate in our project one tool called `swagger`, it is easy and friendly to use.

#### Swegger

See [OpenApi Swegger][link-springdoc-openapi] about how to use `Swegger`

```text
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0'
```
After runned our project, test in browser the next link:
[http://localhost:8080/swagger-ui/index.html][link-swagger-localhost]

### Step 7 | Handler Exceptions

To centralize exceptions, I use the `controller.exception` package, which is used to create all exception handlers related to the RESTful API section.

## Steps PRD

Now, gonna to prepare project for up to cloud, for this test, I use the [Railway][link-railway]. This cloud platform is easy to use, only associate a our github account and get 5u$ per month to use. 

#### Prepare `properties-prd.yml` file

Now, we gonna create a configuration os project for run in PRD (our PRD is the cloud)

```yaml
application:
  title: API Rest Cloud - LAB - PRD
  version: v1.0
  author: Alejandro Fuentes - alefuentes.edu

spring:
  datasource:
    url: jdbc:postgresql://${PGHOST}:${PGPORT}/${PGDATABASE}
    username: ${PGUSER}
    password: ${PGPASSWORD}
  jpa:
    open-in-view: false
    hibernate:
      ddl-auto: validate #create
```

These variables like `${PGHOST}` are created as 'environment var' in the IDE used, the names of these variables are the same that `Railway` shows us after creating a `Postgresql` resource.

> ✒️ OBS. In the first execution the `ddl-auto` needs to set how `create`, because need to create our tables, after the first run, change the configuration to `validate` for the data to have persistence in the next restart system.

#### 1º modification : Prepare `build.gradle`

In this file, add the section `tasks.jar`:

```gradle
tasks.jar {
  manifest {
    attributes["Main-Class"] = "edu.alejandro.ApiRestCloudLab2024Application"
  }
}

tasks.named('test') {
  useJUnitPlatform()
}
```

#### 2º modification : Create file `Procfile`

1. Create the file `Procfile` in root project
2. Build project `gradle->Tasks->build->bootJar`
3. after executing `buildJar` one folder was a crate in the project `build/libs` copy this path and use how part of the configuration

Content `Procfile`:
```procfile
web: java -jar build/libs/api-rest-cloud-lab-2024-0.0.1-SNAPSHOT.jar
```

<!-- links -->
[link-initializr]:https://start.spring.io/
[link-figmaabstration]:https://www.figma.com/file/cimP7PYnrMeFyOkbLaX9TI/My-Prototype-Bank?type=design&node-id=1-5&mode=design
[link-jsoneditoronline]:https://jsoneditoronline.org/
[link-springdoc-openapi]:https://github.com/springdoc/springdoc-openapi
[link-swagger-localhost]:http://localhost:8080/swagger-ui/index.html
[link-railway]:https://railway.app/
