DELIcious Sandwiches Ordering System
--
___
Overview
-
The DELIcious Sandwiches Ordering System is a Java application that allows a user to place orders for sandwiches, drinks, and chips. The user can customize their sandwiches by choosing the size, type of bread, toppings, and whether they want it toasted. The application also supports signature sandwiches for quick ordering.

---
Features
--
**Main Menu**
![img.png](src/main/java/com/ps/img.png)

**Starting a new Order**

![img_1.png](src/main/java/com/ps/img_1.png)

**Adding a Signature Sandwich**

![img_2.png](src/main/java/com/ps/img_2.png)

**Adding Chips**

![img_3.png](src/main/java/com/ps/img_3.png)

**Adding a Drink**

![img_4.png](src/main/java/com/ps/img_4.png)

**Checking Out**

![img_5.png](src/main/java/com/ps/img_5.png)

**Adding a Custom Sandwich**

![img_6.png](src/main/java/com/ps/img_6.png)
![img_7.png](src/main/java/com/ps/img_7.png)
![img_8.png](src/main/java/com/ps/img_8.png)
![img_9.png](src/main/java/com/ps/img_9.png)
![img_10.png](src/main/java/com/ps/img_10.png)
---
Interesting Code
--
![img_11.png](src/main/java/com/ps/img_11.png)
Inside the Order class the 'saveReceipt()' and 'generateFileName()' work in tandem to save the Order to a file. The 'generateFileName()' dynamically generates a unique file name based on the current date and time, while the 'saveReceipt()' method writes the order details to the file with formatted prices, and handles any potential IOExceptions. I found thus interesting because it demonstrates how to handle creation of new files in Java. 




