# Project - Santa Claus Toy Factory

# Instructions
OH! OH! OH! Santa Claus needs your help, developer!!! For this Christmas, Santa has decided to update his toy management system and leave behind the creation of long scrolls by hand. But WATCH OUT! The system will behave differently depending on whether it's used by Santa or one of his elves, and the data storage system will be different depending on whether the toy is for good children or bad children.

You have been tasked with creating a console application that will allow Santa’s elves to register toys created, list the inventory, and delete toys.

If the application is used by Santa, he will be able to view the list of toys for good children or the list of toys for bad children. He will also have the ability to save the complete list of all toys in .csv format.

## Deliverables:
    - Link to the original GitHub project repository
    - The Readme must be properly worked on (See Sections of the Readme)
    - Link to the project presentation

## Sections of the Readme:
    - Title
    - Description with a synopsis of the project
    - Prerequisites (What needs to be installed to run the project)
    - Installation steps
    - Test execution (Coverage screenshot)
    - Diagrams created
    - Authors

# Objective
Gradually approach the classic architecture of Spring Boot. Apply the MVC (Model-View-Controller) architecture pattern to structure the application. Understand and apply the repository pattern and dependency inversion.

# User Stories
1. AS an Elf I WANT to add a toy for a good child to the inventory by providing the title, brand, recommended age range, and category FOR its storage.

2. AS an Elf I WANT to add a toy for a bad child to the inventory by providing the title and its content FOR its storage.

3. AS an Elf I WANT to view the list of all toys FOR inventory control.

4. AS an Elf I WANT to delete a toy FOR avoiding defective toys in the inventory.

5. AS an Elf I WANT to log out FOR ending my workday.

6. AS Santa I WANT to view the list of toys for good children FOR inventory checking.

7. AS Santa I WANT to view the list of toys for bad children FOR inventory checking.

8. AS Santa I WANT to save the list of all toys in .csv format FOR data verification using an external application.

9. AS Santa I WANT to log out FOR ending my workday.

For each user story, acceptance criteria should be written.

# Example Console Interaction
Use cases for Elves:

    Log in as:
    1. Elf
    2. Santa Claus
    Select an option: 1
    -----------
    Toy Manager (Session Type: Elf)
    1. Add toy
    2. View all toys
    3. Delete toy
    4. Log out
    Select an option: 1
    -----------
    For child ...:
    1. Good
    2. Bad
    Select an option: 1

    Enter the title: LEGO Star Wars - Millennium Falcon - 75375
    Enter the brand: LEGO
    Enter the recommended age: +18
    Enter the category: Construction Toys
    Toy added successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add toy
    2. View all toys
    3. Delete toy
    4. Log out
    Select an option: 1
    -----------
    For child ...:
    1. Good
    2. Bad
    Select an option: 2

    Enter the title: Mystery Box 5x5
    Enter the content: Coal
    Toy added successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add toy
    2. View all toys
    3. Delete toy
    4. Log out
    Select an option: 2

    List of toys:
    B1. Title: LEGO Star Wars - Millennium Falcon - 75375, Brand: LEGO, Recommended Age: +18, Category: Construction Toys
    M1. Title: Mystery Box 5x5, Content: Coal
    -----------
    Toy Manager (Session Type: Elf)
    1. Add toy
    2. View all toys
    3. Delete toy
    4. Log out
    Select an option: 3

    Enter the toy ID to delete: B1
    Toy deleted successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add toy
    2. View all toys
    3. Delete toy
    4. Log out
    Select an option: 4

    Session closed successfully.

Use cases for Santa Claus:

    Log in as:
    1. Elf
    2. Santa Claus
    Select an option: 2
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for bad children
    3. Save list of all toys (.csv)
    4. Log out
    Select an option: 1

    B1. Title: LEGO Star Wars - Millennium Falcon - 75375, Brand: LEGO, Recommended Age: +18, Category: Construction Toys
    B2. Title: LEGO City - Arctic Explorers: Boat - 60368
    , Brand: LEGO, Recommended Age: 5-7, Category: Construction Toys
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for bad children
    3. Save list of all toys (.csv)
    4. Log out
    Select an option: 3

    List of toys saved.
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for bad children
    3. Save list of all toys (.csv)
    4. Log out
    Select an option: 4

    Session closed successfully.

# 🏁 Evaluation Rubric
- **User Interface**
    - The interface allows elves to add toys (5%)
    - The interface allows elves to view all toys (5%)
    - The interface allows elves to delete a toy (5%)
    - The interface allows logging out (5%)
    - The interface allows Santa to view the list of toys for good children (2.5%)
    - The interface allows Santa to view the list of toys for bad children (2.5%)
    - The interface allows Santa to save the list of toys in a .csv file (5%)

- **Data Persistence**
    - Data persistence in memory
    - Repository pattern implementation (20%)

- **Code and Best Practices**
    - Coverage tests with at least 70% (20%)
    - Code is well-structured (10%)
    - MVC architecture implementation (20%)



