# 🚗 Vehicle Information GUI (Java Swing)

A simple Java Swing application for capturing and displaying vehicle information in a clean graphical user interface.

---

## 📋 Features

- **Add Vehicle Information**: Enter details like make, model, VIN, plate number, year, and mileage.
- **View Vehicle Report**: See a list of all captured vehicles in a scrollable report view.
- **Validation**: Ensures all fields are filled and VIN is exactly 17 characters.
- **Prevents Duplicates**: Vehicles with the same VIN cannot be added twice.
- **User-Friendly UI**: Includes buttons to navigate between views and exit the application.

---

## 🧾 What You Can Do

1. **Launch the Application**  
   Run `Main.java` to open the GUI.

2. **Add a Vehicle**  
   Click **Input Vehicle Information**  
   Fill in all fields correctly  
   Click **Save**

3. **View Captured Vehicles**  
   Click **View Vehicle Report**  
   Scroll through all saved vehicles

4. **Return or Exit**  
   Use **Back** to return to the main menu  
   Use **Exit** to close the application

---

## 🛠️ Project Structure
├── Car.java # Data model representing a vehicle
├── Launch.java # Main GUI application with all Swing components
├── Main.java # Entry point that starts the GUI

Created by Kamogelo Thathi
