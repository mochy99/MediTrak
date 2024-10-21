# MediTrak

**Pharmacy Inventory Tracking and Management System**

**MediTrak** is a pharmacy inventory tracking and management system, developed as part of the coursework for **_CPSC 210 - Software Construction_**. This project applies the principles of **_abstraction_** and **_decomposition_** to create a robust software system that addresses real-world challenges in pharmacy operations.

---


## Course Context: CPSC 210

This repository is part of my work for **_CPSC 210 - Software Construction_**, which builds upon the foundational concepts introduced in **_CPSC 110_**. The course emphasizes two core ideas:
- **Abstraction**: Simplifying complex systems to manageable components.
- **Decomposition**: Breaking down software systems into modular parts to make them easier to construct and maintain.

---

## What will the application do?

**MediTrak** will automate and streamline the pharmacy inventory management process. The application will:
- Provide real-time updates on medication stock levels.
- Track medication expiration dates and flag items nearing expiry.
- Send alerts when stock reaches a predefined low threshold, ensuring timely restocking.
- Offer an intuitive interface for easy navigation and minimal technical learning for pharmacy staff.

---

## Who will use it?

This application is intended for:
- **Pharmacy staff**: Pharmacists, technicians, and assistants who manage and maintain the inventory.
- **Pharmacy managers**: Responsible for stock control, ensuring medications are available and avoiding overstocking or shortages.

---

## Why is this project of interest to you?

As someone with experience working in a community pharmacy, I’ve seen firsthand the challenges associated with inventory management. Medications must be tracked carefully to avoid waste and ensure patient safety. This project allows me to apply my background in pharmacy and software development to solve a practical problem, combining my **_passion for healthcare_** with my **_interest in software engineering_**.

---

## Key Features

- **Inventory Monitoring**: Track real-time stock levels of medications.
- **Expiration Management**: Flag medications nearing expiration.
- **Restock Alerts**: Notifications for low inventory.
- **User-friendly Interface**: Designed for easy use by pharmacy staff with minimal technical knowledge.

---

## Learning Objectives

Through this project, I aim to develop practical skills, including:
- **Understanding and implementing software abstraction and decomposition**.
- **Designing and writing code in Java**.
- **Developing skills in debugging, testing, and refactoring**.
- **Collaborating effectively in a software development team**, using control-flow and data-flow models.

---

## Project Structure

- `src`: Contains the `main` and `test` Java source code for the project.
- `lib`: Includes any library if applicable.
- `docs`: Documentation related to the project, including system design and user guides.

---

## Future Enhancements

While the current version covers core inventory management, future enhancements could include:
- Integration with a point-of-sale system for real-time updates.
- User roles and permissions to ensure data security.
- Generate detailed reports on stock usage and trends.

---

## User Stories for MediTrak

1. **As a user**, I want to add a new drug with details such as DIN/NPN, brand name, main ingredient, strength, formula, manufacturer, lot number, expiration date, price, markup, quantity, and category, so that I can keep track of all the medications in the pharmacy.

2. **As a user**, I want to update the information of an existing drug to ensure that the inventory is accurate and up to date.

3. **As a user**, I want to view all medications by category, name, and Drug Identification Number (DIN), so that I can quickly find specific drugs in the inventory.

4. **As a user**, I want to search for a medication by its name or DIN to locate specific drugs in the inventory efficiently.

5. **As a user**, I want to view a list of all medications in the inventory, including details like brand name, main ingredient, strength, manufacturer, lot number, expiration date, and quantity, so that I can easily monitor stock levels.

6. **As a user**, I want to update the quantity dispensed for a drug to reflect its availability accurately, along with patient information and transaction number, so that I can maintain precise inventory levels and patient records.

7. **As a user**, I want to export a list of medications that have close expiration dates (0, 1, 3, or 6 months), so that I can take timely action on them.

8. **As a user**, I want to receive notifications when a drug's inventory is low based on historical dispensing data, so that I can manage restocking effectively.


