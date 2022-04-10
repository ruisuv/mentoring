#Java Mentoring

##Introduction
A beginner guide and –hopefully– a helpful resource for interacting with Java Basics.
Project written as a Java Backend who wanted to help junior developers to cover some of the most used concepts on OOP.

- Data Structures and Algorithms
  - Recursion
- Java Fundamentals
    - Primitive Types
    - Interfaces and concrete classes
    - Object Modeling, equals, hashCode, toString methods implementations
    - Generics
- Maven as a build tool
- Spring Boot Starter
- Unit Testing and TDD
- Lombok
- CRUD API

Implementing a Binary Search Tree by ourselves is not something common on a daily basis, 
but I found it helpful to talk about recursion, Big O notation and practice OOP principles.

As you may ~~not~~ know, "Tree" is a unidirectional graph where the first node is called "root" 
and each node has zero or more children. Those nodes with 0 children are called "leaves".

A "Binary Tree" is a tree specialization where each node can have 2 children at most, 
being called "left" and "right" nodes. 

At last, "Binary Search Tree" has the particularity of being sorted, 
with left children being less than parent and right ones, greater. 

##Instructions
###First Session: Creating the project
- Create a repo on GitHub where main branch has only a README.md
- Create a Maven project and link it to remote repository 
- Create `Node` class
- Create `Tree` interface with methods
    - `add`
    - `contains`
    - `delete`

###Second Session: Recursion
- Create `BinarySearchTree` Implementation 
  - Implement `add` method  
  - Implement `contains` method
  - Let `delete` method to throw  `java.lang.UnsupportedOperationException`

###Third Session: Unit Testing
- Use assertJ for Unit Testing
  - Test for add method
  - Assert contains
  - Duplicated values are not inserted twice
                                    
###Fourth Session: Test Driven Development
- Add Test for delete method for the following scenarios
  - Delete leaf
  - Delete node with one child
  - Delete node with two children
  - Assert `toString`
- Implement delete method on `BinarySearchTree` class
- Implement `toString` In Order

###Fifth Session: Generics
- Create a class and think about its ordering elements
  - Implements `Comparable`
  - Implements `equals`/`hashCode`
  - Implement `toString` representation
  - Use Lombok
- Refactor existing classes to use generics instead of primitive int
  - Make sure existing tests still passes
  - Add tests for new POJO.

###Sixth Session: Spring Boot Starter
- Add Maven Dependency for Spring Boot Starter
- Create REST API with Spring Boot Starter
  - REST TreeController
  - TreeService 
    - Add inmemory Data
- GET all
- GET by field
- POST
- DELETE
       

###Seventh Session: Connecting with Database
- Create `TreeRepository`
- Add `spring-boot-starter-data-jdbc` dependency to `pom.xml`  
- Use H2 as DBMS
- Load Data from CSV

###Eight Session: External Database and Docker Compose
- TBD

###Nth Session: Serverless
- TBD

                                                             
