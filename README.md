# 1SemesterProject - sale system with a loan system ontop

This was a semester project where I worked together with classmates, in both design and coding.
# Overview

this project was about creating a POS system, where you could sell products to customers and customers could also loan machines from the store, moreover products in store could become loan items. 

# Things Learned
- implementing a 3 layer architecture
- implementing the orderline pattern : customer->order->orderline->product
- implementing a composite pattern
- text based UI interface
- implementing singleton pattern
- implementing unit tests 
- coding with regards to GRASP

# Diagrams
if you like to view the diagrams then look under the folder of UML-Diagrams
- domain model
- interaction diagram for a single use case 
- class design diagram 

# Usage instructions

- download the project 
- open in eclipse 
- run from the MainMenuUI file under src -> view

# Project status

currently no longer maintained but may come back to it if time allows

# Technical details

Programming language: Java
tool: 
- esclipse
- Git for versioncontrol. 

3-Layer architecture:
this project uses the 3-layer architecture which is useful when you want to seperate the code into different section where each have each own responibility. example the controller layer controls the business logic and the data layer have all the models used in the project, these are data holders. 

controllers:
each controller is a use case controller with each respobility, thus a customer controller controls all the busniess logic that have anything to do with customers like Crud operation.

patterns implemented:

composite pattern: interaction with a single object and a collection of those object should be the same way. 
- Item can contain a packageLine 
- packageLine can contain packages and individual items. 

Singleton pattern: only one instance of the object 
- this is done on the controller layer in the 3 layer architecture thus only one controller to control the business logic in the application for that specific area. 


# Testing info

in this project there is used the JUnit testing in Java. 
- there is tested 2 small adding methods. 
- there is a single Boundry test for products
