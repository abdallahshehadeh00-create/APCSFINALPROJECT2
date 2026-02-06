# Pharmacy Management System (CS Project 2)

A robust JavaFX application for managing pharmacy inventory with real-time search and JSON-based data persistence.

## 🚀 Features
* **Inventory Management:** Full CRUD (Create, Read, Update, Delete) for medicine records.
* **Real-time Search:** Efficient filtering of medicines by name using `FilteredList`.
* **Data Persistence:** Automatic saving and loading of inventory using Google GSON and JSON.
* **Modern UI:** Built with JavaFX and FXML using the MVC (Model-View-Controller) pattern.

## 🛠 Tech Stack
* **Language:** Java 17+
* **Framework:** JavaFX 17
* **Build Tool:** Maven
* **Libraries:** Google GSON (for JSON serialization)

## 📁 Project Structure
- `src/main/java/com/example/csproject2/`
    - `Medicine.java`: The Data Model (uses JavaFX Properties).
    - `DashboardController.java`: Logic and UI Event Handling.
    - `JsonHandler.java`: Utility for File I/O and GSON integration.
- `inventory.json`: Local database file for persistent storage.

## ⚙️ How to Run
1. Ensure you have **Maven** and **Java 17** installed.
2. Open the project in IntelliJ IDEA or Eclipse.
3. Run `mvn clean install`.
4. Run the `HelloApplication.java` (or your main entry point).

## 📝 Design Decisions (For Grading)
* **JSON over SQL:** Decided on a JSON file structure for portability and lightweight deployment.
* **Transient Properties:** Utilized the `transient` keyword in the `Medicine` model to prevent serialization errors with JavaFX Property objects while maintaining UI binding.
* **MVC Pattern:** Strictly separated the GUI (FXML) from the Business Logic (Controller) to ensure code maintainability.
