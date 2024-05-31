<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movie Database Application</title>
</head>
<body>
    <h1>Movie Database Application</h1>
    <p>This JavaFX application allows users to manage a movie database by performing CRUD (Create, Read, Update, Delete) operations. The application consists of a user authentication system with roles (admin/user) and multiple functionalities for managing movies.</p>

    <h2>Table of Contents</h2>
    <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#setup-and-installation">Setup and Installation</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#classes-and-methods">Classes and Methods</a></li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
    </ul>

    <h2 id="features">Features</h2>
    <ul>
        <li>User authentication with role-based access (admin/user).</li>
        <li>CRUD operations on movies.</li>
        <li>Validation for input fields.</li>
        <li>Tooltips for guidance on input requirements.</li>
        <li>Different views for login, registration, and dashboard.</li>
    </ul>

    <h2 id="prerequisites">Prerequisites</h2>
    <ul>
        <li>Java Development Kit (JDK) 8 or higher</li>
        <li>JavaFX SDK</li>
        <li>MySQL database</li>
    </ul>

    <h2 id="setup-and-installation">Setup and Installation</h2>
    <ol>
        <li><strong>Clone the repository:</strong>
            <pre><code>git clone https://github.com/your-repo/movie-database-app.git
cd movie-database-app
            </code></pre>
        </li>
        <li><strong>Setup MySQL Database:</strong>
            <ul>
                <li>Create a MySQL database named <code>movie</code>.</li>
                <li>Import the provided SQL scripts to create the necessary tables and seed data.</li>
            </ul>
        </li>
        <li><strong>Configure Database Connection:</strong>
            <ul>
                <li>Update the <code>MovieDAO</code> and <code>UserDAO</code> classes with your MySQL database credentials.</li>
            </ul>
        </li>
        <li><strong>Build and Run the Application:</strong>
            <ul>
                <li>Use your preferred IDE to import the project.</li>
                <li>Add JavaFX library to your project build path.</li>
                <li>Run the <code>MainApplication</code> class to start the application.</li>
            </ul>
        </li>
    </ol>

    <h2 id="usage">Usage</h2>
    <ol>
        <li><strong>Login:</strong>
            <ul>
                <li>Enter your username and password.</li>
                <li>Click on the "Login" button.</li>
                <li>If you don't have an account, click on the "Sign Up" button to create one.</li>
            </ul>
        </li>
        <li><strong>Dashboard:</strong>
            <ul>
                <li>Search, create, update, and delete movies.</li>
                <li>Admin users have additional permissions for updating and deleting movies.</li>
            </ul>
        </li>
        <li><strong>Logout:</strong>
            <ul>
                <li>Click on the "Sign Out" button to log out and return to the login screen.</li>
            </ul>
        </li>
    </ol>

    <h2 id="classes-and-methods">Classes and Methods</h2>
    <p>Details about classes and methods can be found in the source code.</p>

    <h2 id="contributing">Contributing</h2>
    <p>Contributions are welcome! Fork the repository and submit a pull request with your changes.</p>

    <h2 id="license">License</h2>
    <p>This project is licensed under the MIT License.</p>
</body>
</html>
