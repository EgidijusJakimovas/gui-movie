<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title> </title>
</head>
<body>
    <h1>Movie Database Application</h1>
    <p>This JavaFX application allows users to manage a movie database by performing CRUD (Create, Read, Update, Delete) operations. The application consists of a user authentication system with roles (admin/user) and multiple functionalities for managing movies.</p>
    <h2>Table of Contents</h2>
    <ol>
        <li><a href="#features">Features</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#setup-and-installation">Setup and Installation</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#classes-and-methods">Classes and Methods</a></li>
    </ol>
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
        <li>JavaFX SDK</li>
        <li>MySQL database</li>
    </ul>
    <h2 id="setup-and-installation">Setup and Installation</h2>
    <ol>
        <li>Clone the repository.</li>
<li>Setup MySQL Database:</li>
<ul>
<li>Create a MySQL database named <code>movie</code>.</li>
<li>Import the provided SQL scripts to create the necessary tables and seed data.</li>
</ul>
<li>Configure Database Connection:</li>
<ul>
<li>Update the <code>MovieDAO</code> and <code>UserDAO</code> classes with your MySQL database credentials.</li>
</ul>
<li>Build and Run the Application:</li>
<ul>
<li>Use your preferred IDE to import the project.</li>
<li>Add JavaFX library to your project build path.</li>
<li>Run the <code>MainApplication</code> class to start the application.</li>
</ul>
    <h2 id="usage">Usage</h2>
    <ul>
        <li><strong>Login:</strong></li>
        <ul>
            <li>Enter your username and password.</li>
            <li>Click on the "Login" button.</li>
            <li>If you don't have an account, click on the "Sign Up" button to create one.</li>
        </ul>
        <li><strong>Dashboard:</strong></li>
        <ul>
            <li>Search, create, update, and delete movies.</li>
            <li>Admin users have additional permissions for updating and deleting all movies.</li>
            <li>User can only create and see their movies.</li>
        </ul>
        <li><strong>Logout:</strong></li>
        <ul>
            <li>Click on the "Sign Out" button to log out and return to the login screen.</li>
        </ul>
    </ul>
    <h2 id="classes-and-methods">Classes and Methods</h2>
    <ul>
        <li><strong>DashboardController:</strong></li>
        <ul>
            <li>Responsible for managing the dashboard view, including searching, creating, updating, and deleting movies.</li>
            <li><code>initialize():</code> Initializes the dashboard with necessary data and tooltips.</li>
            <li><code>onSearchButtonClick():</code> Searches for movies based on the input and updates the table view.</li>
            <li><code>onCreateButtonClick():</code> Creates a new movie entry in the database.</li>
            <li><code>onUpdateButtonClick():</code> Updates an existing movie entry in the database.</li>
            <li><code>onDeleteButtonClick():</code> Deletes a movie entry from the database.</li>
        </ul>
        <li><strong>LoginController:</strong></li>
        <ul>
            <li>Controls the login view and handles user authentication.</li>
        </ul>
        <li><strong>RegisterController:</strong></li>
        <ul>
            <li>Controls the registration view and handles user registration.</li>
        </ul>
        <li><strong>MovieDAO:</strong></li>
        <ul>
            <li>Data Access Object for performing database operations related to movies.</li>
        </ul>
        <li><strong>UserDAO:</strong></li>
        <ul>
            <li>Data Access Object for performing database operations related to users.</li>
        </ul>
    </ul>
</ol>
</body>
</html>
