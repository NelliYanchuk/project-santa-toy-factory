# Project - Santa Claus Toy Factory

## Instructions
OH! OH! OH! Santa Claus needs your help, developer! This Christmas, Santa has decided to upgrade his toy management system, leaving behind the manually created scrolls. But be careful! The system will behave differently depending on whether Santa or one of his elves is using it, and data storage will vary depending on whether the toy is for a good child or a naughty child.

Your task is to create a console application that allows Santa's elves to register new toys, list the inventory, and delete toys.

If Santa uses the application, he should be able to view the list of toys for good children or the list of toys for naughty children. Additionally, Santa should have the option to save the entire toy list in .csv format.

## Objective
To gradually approach the classic Spring Boot architecture. Apply the MVC (Model-View-Controller) architecture pattern to structure the application. Understand and implement the repository pattern and dependency inversion.

## User Stories
1. **As an Elf, I want** to add a toy for a good child to the inventory by providing the title, brand, recommended age range, and category **so that** it is stored appropriately.

2. **As an Elf, I want** to add a toy for a naughty child to the inventory by providing the title and content **so that** it is stored appropriately.

3. **As an Elf, I want** to view a list of all toys **to** keep track of the inventory.

4. **As an Elf, I want** to delete a toy **to** avoid having defective toys in the inventory.

5. **As an Elf, I want** to log out **to** end my workday.

6. **As Santa, I want** to view the list of toys for good children **to** check the inventory.

7. **As Santa, I want** to view the list of toys for naughty children **to** check the inventory.

8. **As Santa, I want** to save the complete toy list in .csv format **to** review data through an external application.

9. **As Santa, I want** to log out **to** end my workday.

Each user story should include acceptance criteria.

## Console Interaction Example

### Use Cases for Elves:
    Log in as:
    1. Elf
    2. Santa Claus
    Choose an option: 1
    -----------
    Toy Manager (Session Type: Elf)
    1. Add a toy
    2. View all toys
    3. Delete a toy
    4. Log out
    Choose an option: 1
    -----------
    For a child who is ...:
    1. Good
    2. Naughty
    Choose an option: 1

    Enter the title: LEGO Star Wars - Millennium Falcon - 75375
    Enter the brand: LEGO
    Enter the recommended age: +18
    Enter the category: Construction Toys
    Toy added successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add a toy
    2. View all toys
    3. Delete a toy
    4. Log out
    Choose an option: 1
    -----------
    For a child who is ...:
    1. Good
    2. Naughty
    Choose an option: 2

    Enter the title: Mystery Box 5x5
    Enter the content: Coal
    Toy added successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add a toy
    2. View all toys
    3. Delete a toy
    4. Log out
    Choose an option: 2

    Toy List:
    B1. Title: LEGO Star Wars - Millennium Falcon - 75375, Brand: LEGO, Recommended Age: +18, Category: Construction Toys
    M1. Title: Mystery Box 5x5, Content: Coal
    -----------
    Toy Manager (Session Type: Elf)
    1. Add a toy
    2. View all toys
    3. Delete a toy
    4. Log out
    Choose an option: 3

    Enter the ID of the toy to delete: B1
    Toy deleted successfully
    -----------
    Toy Manager (Session Type: Elf)
    1. Add a toy
    2. View all toys
    3. Delete a toy
    4. Log out
    Choose an option: 4

    Session closed successfully.

### Use Cases for Santa Claus:
    Log in as:
    1. Elf
    2. Santa Claus
    Choose an option: 2
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for naughty children
    3. Save the full toy list (.csv)
    4. Log out
    Choose an option: 1

    B1. Title: LEGO Star Wars - Millennium Falcon - 75375, Brand: LEGO, Recommended Age: +18, Category: Construction Toys
    B2. Title: LEGO City - Arctic Explorers: Ship - 60368, Brand: LEGO, Recommended Age: 5-7, Category: Construction Toys
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for naughty children
    3. Save the full toy list (.csv)
    4. Log out
    Choose an option: 3

    Toy list saved successfully.
    -----------
    Toy Manager (Session Type: Santa)
    1. View list of toys for good children
    2. View list of toys for naughty children
    3. Save the full toy list (.csv)
    4. Log out
    Choose an option: 4

    Session closed successfully.

## 🏁 Evaluation Criteria
- **User Interface**
  - The interface allows elves to add toys (5%)
  - The interface allows elves to view all toys (5%)
  - The interface allows elves to delete a toy (5%)
  - The interface allows elves to log out (5%)
  - The interface allows Santa to view the list of toys for good children (2.5%)
  - The interface allows Santa to view the list of toys for naughty children (2.5%)
  - The interface allows Santa to save the toy list in a .csv file (5%)

- **Data Persistence**
  - Data persistence in memory.
  - Implementation of the repository pattern (20%).

- **Code and Best Practices**
  - Minimum of 70% test coverage (20%)
  - Well-structured code (10%)
  - MVC architecture implementation (20%)
