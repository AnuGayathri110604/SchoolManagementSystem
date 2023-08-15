# School Management System

This is a School Management System project developed in Java using the Swing framework. The project provides functionality for user registration (sign-up) and login for a school management system.

## Features

- User Registration (Sign-up):
  - Users can create an account by providing their name, email, password, and confirm password.
  - Password strength is checked, ensuring it meets security requirements.
  - Users are assigned a random PIN upon registration.

- User Login:
  - Registered users can log in to the system using their credentials.

## Getting Started

### Prerequisites

- Java Development Kit (JDK)
- MySQL Server

### Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/school-management-system.git
Set up the MySQL database:

Create a new database named sms on your MySQL server.
Import the database.sql file in the repository to set up the required table.
Open the project in your preferred Java IDE.

Configure the MySQL database connection:

In the Signup class and Login1 class, update the database connection URL, username, and password as needed.
Build and run the project.

Project Structure
schoolmanagementsystem/:
Contains the main application classes and GUI components.
Schoolmanagementsystem.java: The entry point of the application.
Signup.java: Handles user registration and GUI for sign-up.
Login1.java: Handles user login and GUI for login.
Contributing
Contributions are welcome! If you find a bug or want to enhance the functionality, feel free to create issues or submit pull requests.
