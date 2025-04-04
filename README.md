# Microservices Patterns - Service Discovery & Load Balancing
## Advanced Coding Assignment-10
## Store Management System API

### Problem Statement
You have been provided with a RESTful web service for a **Store Management System** using Spring Boot. The API allow users to manage products, including adding, updating, deleting, and retrieving products. The system store the product data in an in-memory array.

You are tasked with implementing **Service Discovery** and **Load Balancing** in a Spring Boot microservices architecture. The system should dynamically register services and enable inter-service communication without hardcoded URLs. Additionally, it should ensure efficient request distribution across multiple instances of a service to enhance scalability and reliability.

### Objective
To implement a Spring Boot application with the following features:

1. **Service Discovery (Eureka Server & Client):**
   - Set up a **Eureka Server** to act as a service registry.
   - Register multiple microservices (Eureka Clients) dynamically with the Eureka Server.
   - Ensure that services can discover and communicate with each other without hardcoded addresses.

2. **Load Balancing (Spring Cloud Load Balancer):**
   - Implement client-side **Load Balancing** using **Spring Cloud Load Balancer** to distribute traffic among multiple instances of a service.
   - Ensure requests are routed to healthy service instances for fault tolerance.

### Steps to Follow
1. This GitHub repository will be accessible to you once you accept the Assignment.
2. You have to work directly in this GitHub repository. It is like your own copy of the original repository.

3. The folder structure is as given below: (showing major folders only)
   ```
   root
   ├── product-service/
   ├── orders-service/
   └── registry-server/
   ```

4. Review the code/comments present in above files to understand the structure.
5. Implement the Service Discovery and Load Balance the application.
6. To work on the files, you can clone this GitHub repository onto your system and then open it with an IDE like IntelliJ, or Eclipse.
7. Once done, push your changes from your system to this remote GitHub repository.

### Starter Code Files:
Starter code for below microserives have been provided:
1. Product Service: To add and manage products using REST endpoints.
2. Order Service: To make orders using product id and quantity.
3. Registry Server: An empty application to be configured as Eureka Server.


## Requirements:
1. **Service Discovery Implementation (Eureka Server & Clients)**
   - Use the application present inside `registry-server` to set up a Eureka Server to act as a service registry.
   - Configure microservices (`product-service`, and `orders-service`) to register dynamically with the Eureka Server.
   - Check Eureka dashboard at http://localhost:8761 to monitor registered services.
   - Ensure that microservices can discover each other and communicate without hardcoded URLs.
     - Create a POST endpoint `/orders/placeOrder` in `orders-service` application that should take product id and quantity from user and places an order.
     - The ordershould be placed by making a call to `product-service` application to get the product details for the product id given by user.
     - If the product exists, calculate the total price using the product price and quantity ordered.
     - In response, return the order id (created dynamically), and product details such as id, name, quantity, & total price.

2. **Load Balancer Implementation (Spring Cloud Load Balancer)**
   - Implement Spring Cloud Load Balancer for distributing incoming requests among multiple service instances.
   - Enable load balancing for inter-service communication using `RestTemplate`.
   - Run multiple instances of `product-service` and ensure traffic is evenly distributed.


## Submission Requirements:
Implement the required tasks for the provided Spring Boot Microservices. You can use Postman or cURL commands to test your implementation.

Add the required execution screenshots, such as Eureka Dashboard showing the registered services, Postman or cURL commands execution, in the `SubmissionImages` folder.

After completing the assignment and developing the solution code in your system, commit and push the changes to this repository. 
  - Stage your changes and commit the files:
    ```
    git add .
    git commit -m "Completed the assignment"
    ```
  - Push your changes to the GitHub repository:
    ```
    git push
    ```

## Grading Criteria:
- To implement Service Discovery correctly
  - To create Eureka Server [1 Mark]
  - To configure `product-service` and `orders-service` as Eureka clients [2 Marks]
  - Eureka Dashboard showing the registered services [1 Mark]
  - Calling `product-service` from `orders-service` via registery server [3 Marks]
- To implement Load Balancing correctly [3 Marks]

Good luck, and happy coding!
