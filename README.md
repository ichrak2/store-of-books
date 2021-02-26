# book-store

[![CI/CD](https://github.com/hamzachikar/book-store/workflows/book-store-CI/badge.svg)](https://github.com/hamzachikar/book-store/actions)

## General info
this is a project for creating a book-store API 

# Guidelines
#### Before you commit
 - Check build is passing (mvn clean package) locally
 - Unit tests written and passing
 - Code is well formatted
 - SonarLint run against code
 - Findbugs run againt code
 - Integration Tests written and passing

#### workflow
 - always create dedicated branches for new developement
 - to merge with master create a PR and make the other team members as reviewers
   
## Requirements
  For building and running the application you need:
    * JDK 13
    * Maven 4

## Running the application locally
  There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentric.springbootsample.Application class    from your IDE.
Alternatively you can use the Spring Boot Maven plugin like so:
```
mvn spring-boot:run
````
## Technologies used in this project
  In this project we used different type of technologies:  
   * Java 13
   * Spring Boot 2.4
   * In-memory database (H2) to store the data.
   * Swagger 2 for testing API
   * Lombok
   * Maven-checkstyle plugin
   * Maven-javadoc
   * Log4j2
   * AssertJ
   * SonarCloud

## About Book-store project:
  ### Features:
   In this Spring boot application we can manage books in a store by:
    * Add, update,find or delete a book
    * Add comments to a book
    * Update , find and delete a comment
  ### Endpoints:
   API endpoint is the point of entry in a communication channel when two systems are interacting.  It refers to touchpoints of the communication between an API and a      server. The endpoint can be viewed as the means from which the API can access the resources they need from a server to perform their task.
   Our endpoints for storeBookApplication are :
   
   **GET**  
   * /books : get the list of all books
```
             "/books":{
                  "get":{
                   "tags": ["book-controller"],
                     "summary": "getAll",
                    "responses": {
                           "200": {
                             "description": "OK",
                             "schema": {
                               "type": "array",
                               "items": {
                                 "$ref": "#/definitions/Book"
                              }
                            }
                          } 
```
   * /book/id : get a book by a given UUID ID 
```
           "/books/{id}": {
           "get": {
             "tags": [
               "book-controller"
            ],
             "summary": "getById",
             "parameters": [
              {
                 "name": "id",
                 "in": "path",
                 "description": "id",
                 "required": true,
                 "type": "string",
                 "format": "uuid"
              }
            ],
             "responses": {
               "200": {
                 "description": "OK",
                 "schema": {
                   "$ref": "#/definitions/Optional«Book»"
                }
              },
               "404": {
                 "description": "Not Found"
              }
            },
             "deprecated": false
          },
```
   * /comment/id : get a comment by a given UUID id
```
            "/comments/{id}": {
             "get": {
               "tags": [
                 "comment-controller"
               ],
               "summary": "getById",
               "parameters": [
                 {
                   "name": "id",
                   "in": "path",
                   "description": "id",
                   "required": true,
                   "type": "integer",
                   "format": "int32"
                 }
               ],
               "responses": {
                 "200": {
                   "description": "OK",
                   "schema": {
                     "$ref": "#/definitions/Comment"
                   }
                 },
                 "404": {
                   "description": "Not Found"
                 }
               },
               "deprecated": false
             },
             "delete": {
               "tags": [
                 "comment-controller"
               ],
               "summary": "delete",
               "parameters": [
                 {
                   "name": "id",
                   "in": "path",
                   "description": "id",
                   "required": true,
                   "type": "integer",
                   "format": "int32"
                 }
               ],
               "responses": {
                 "200": {
                   "description": "OK"
                 },
                 "204": {
                   "description": "No Content"
                 }
               },
               "deprecated": false
             }
           }
```
   **POST**
   * /books/ : create a new book 
```
                 "post": {
                 "tags": [
                   "book-controller"
                ],
                 "summary": "create",
                 "consumes": [
                   "application/json"
                ],
                 "parameters": [
                  {
                     "in": "body",
                     "name": "newbook",
                     "description": "newbook",
                     "required": true,
                     "schema": {
                       "$ref": "#/definitions/Book"
                    }
                  }
                ],
                 "responses": {
                   "201": {
                     "description": "Created",
                     "schema": {
                       "$ref": "#/definitions/Book"
                    }
                  }
                }
              },
```
   * /comment/idbook : Add this comment to a given book with UUID idbook
```
                "/comments/{idBook}": {
                "post": {
                  "tags": [
                    "comment-controller"
                 ],
                  "summary": "save",
                  "parameters": [
                   {
                      "in": "body",
                      "name": "comment",
                      "description": "comment",
                      "required": true,
                      "schema": {
                        "$ref": "#/definitions/Comment"
                     }
                   },
                   {
                      "name": "idBook",
                      "in": "path",
                      "description": "idBook",
                      "required": true,
                      "type": "string",
                      "format": "uuid"
                   }
                 ],
                  "responses": {
                    "200": {
                      "description": "OK"
                   },
                    "201": {
                      "description": "Created"
                   },
                    "404": {
                      "description": "Not Found"
                   }
                 },
                  "deprecated": false
               }
             }
```
   **PUT**       
   * /books/ : Update a book 
```
                  "put": {
                  "tags": [
                    "book-controller"
                 ],
                  "summary": "update", 
                  "parameters": [
                   {
                      "in": "body",
                      "name": "book",
                      "description": "book",
                      "required": true,
                      "schema": {
                        "$ref": "#/definitions/Book"
                     }
                   }
                 ],
                  "responses": {
                    "200": {
                      "description": "OK",
                      "schema": {
                        "$ref": "#/definitions/Book"
                     }
                   }
                 }
               }
          }
```
   * /comments/ : Update a comment
```
                 "put": {
                 "tags": [
                   "comment-controller"
                ],
                 "summary": "update",
                 "parameters": [
                  {
                     "in": "body",
                     "name": "comment",
                     "description": "comment",
                     "required": true,
                     "schema": {
                       "$ref": "#/definitions/Comment"
                    }
                  }
                ],
                 "responses": {
                   "200": {
                     "description": "OK",
                     "schema": {
                       "$ref": "#/definitions/Comment"
                    }
                  },
                   "201": {
                     "description": "Created"
                  },
                   "404": {
                     "description": "Not Found"
                  }
                },
                 "deprecated": false
              }
            },
```
   **DELETE**       
   * /books/ID : Delete a book by a given UUID id
                 
```
                 "delete": {
                  "tags": [
                    "book-controller"
                 ],
                  "summary": "delete",
                  "parameters": [
                   {
                      "name": "id",
                      "in": "path",
                      "description": "id",
                      "required": true,
                      "type": "string",
                      "format": "uuid"
                   }
                 ],
                  "responses": {
                    "200": {
                      "description": "OK"
                   },
                    "204": {
                      "description": "No Content"
                   },
                    "403": {
                      "description": "Forbidden"
                   }
                 },
                  "deprecated": false
               }
             },
```
  * /comments/id : delete a comment by a given UUID id
```
                "delete": {
                "tags": [
                  "comment-controller"
                ],
                "summary": "delete",
                "parameters": [
                  {
                    "name": "id",
                    "in": "path",
                    "description": "id",
                    "required": true,
                    "type": "integer",
                    "format": "int32"
                  }
                ],
                "responses": {
                  "200": {
                    "description": "OK"
                  },
                  "204": {
                    "description": "No Content"
                  }
                },
                "deprecated": false
              }
            }
```
