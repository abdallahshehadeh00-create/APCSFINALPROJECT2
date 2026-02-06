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

* ---

## 📄 IEEE Technical Report Summary

### I. Abstract
This project presents a Pharmacy Management Information System (PMIS) designed to streamline inventory tracking. By leveraging the **Model-View-Controller (MVC)** architectural pattern and **JSON-based serialization**, the system provides a lightweight yet robust solution for data persistence and real-time inventory manipulation.

### II. System Architecture
The system is divided into three logical layers:
1. **Presentation Layer (View):** Utilizes FXML for declarative UI design.
2. **Logic Layer (Controller):** Implements event-driven programming to handle user inputs and inventory logic.
3. **Data Layer (Model/Persistence):** Uses `Medicine.java` for data representation and `JsonHandler.java` for asynchronous-style file I/O operations.

### III. Algorithms and Data Handling
* **Serialization:** The system employs the **Google GSON** library. A custom initialization strategy was implemented to bridge the gap between serializable POJOs and non-serializable JavaFX `Property` objects.
* **Search Algorithm:** The search functionality utilizes a **Predicate-based FilteredList**, ensuring $O(n)$ time complexity for real-time string matching across the inventory dataset.

### IV. Conclusion
The application successfully meets the requirements for a modular, user-friendly management system. Future iterations could include integration with a relational database (RDBMS) and multi-user authentication.
