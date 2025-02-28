**Instructions**
Run main to start the program. 
You have to use the synchronized keyword on the bookTickets() method for the program to be consistent.

**Report**

1) Remove thread synchronisation and only use volatile shared variable “Available tickets” to see if the result is consistent or not?

Changing the availableTickets variable to volatile made no difference. 
This is because if the bookTickets() method is not synchronized, the availableTickets variable is not atomic. 
So, making it volatile does nothing for the consistency of the program if bookTickets() is not synchronized.


2) Explain your observation of using synchronisation with and without a “volatile” shared variable. 
    How would you book tickets with threads to have consistent available tickets?

We would use a synchronized bookTickets() to ensure atomicity, 
which means that updating the variabl is completed without any interference from other threads, ensuring consistency.
