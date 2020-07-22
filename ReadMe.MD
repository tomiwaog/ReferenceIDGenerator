#Reference Number Generator and Tracker

Possible applications:
HelpDesk
Ticketing System Reference ID
Employee ID Management
E-commerce Shopping Cart i.e. OrderNo
Public Service ID 

Application can be used for multiple application at once. Generator can be used to manage multiple services in parallel.


Ticket System - Rest API that generates a ticket based on specified input.

Available/Provided Interfaces:
* Generate Generic Tickets
* Generate Ticket with Prefix;
* Generate Tickets for multiple purposes or Departments in Parallel.
* Retrieve last Ticket
* Retrieve last ticket for a specific department.


**** HOW TO Generate a generic Reference ID ***
Simple TicketSystem.generate(); 
input : none
Output - A String/text which increments at every call.


**** HOW TO Generate a Ticket for multiple properties or departments***

1. Add Property and its prefix


2. Call Simple ReferenceSystem.generate(propertyName); 
where propertyName is a string used to identify previously added properties. 
input: String
Output: property prefix+A String/text which increments at every call. 

E.g.


Generate Reference Number for Multiple Properties for a company called

***
//Add multiple properties.
        ReferenceSystem x = new ReferenceSystem();
        x.addDepartment("IT", "ABCIT");
        x.addDepartment("Legal", "ABCLegal");
        x.addDepartment("Finance", "FIN");
        
//Generate Reference ID for multiple properties.       
        x.generateReference("IT"); //API returns ABCIT1
        x.generateReference("IT"); //API return ABCIT2
        x.generateReference("Legal"); //API return ABCLegal1
        x.generateReference("Finance");//API return FIN1
        x.generateReference("IT"); //API return ABCIT3
        x.generateReference("Legal"); //API return ABCLegal2
        x.generateReference("IT"); //API return ABCIT4


//API to Get last TicketID/Reference for any property.
		x.getLastReference("Legal"); //Returns "ABCLegal2"
***




