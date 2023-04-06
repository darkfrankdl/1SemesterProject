# 1SemesterProject - sale system with a loan system ontop

#Overview

this project was about creating a POS system, where you could sell products to customers and customers could also loan machines from the store, moreover products in store could become loan items. 

# patterns implemented 

composite pattern: interaction with a single object and a collection of those object should be the same way. 
- Item can contain a packageLine 
- packageLine can contain packages and individual items. 

Singleton pattern: only one instance of the object 
- this is done on the controller layer in the 3 layer architecture thus only one controller to control the business logic in the application for that specific area. 

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

#Project status

currently no longer maintained but may come back to it if time allows
