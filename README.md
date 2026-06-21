# 🏥 HealthMate

A personal health companion Android app that brings together meal tracking, calorie monitoring, hydration logging, and workout planning — all in one place.

> Built with Java, Firebase, and Material Design.

---

## 📱 Features

- **Meal Tracking** — Log and monitor your daily meals
- **Calorie Monitoring** — Get calorie recommendations tailored to your needs
- **Water Intake Tracker** — Stay on top of your daily hydration goals
- **Fitness Planning** — Choose from 3, 4, 5, or 6-day workout splits
- **Food & Fruit Calorie Lookup** — Quickly reference calorie info for common foods

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Platform | Android (min SDK 24, target SDK 33) |
| Auth | Firebase Authentication |
| Database | Cloud Firestore |
| UI | Material Design, Navigation Drawer, Fragments |
| Build | Gradle with ViewBinding enabled |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Flamingo or later recommended)
- A Firebase project with **Authentication** and **Firestore** enabled
- Android device or emulator running API 24+

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/YOUR_USERNAME/HealthMate.git
   cd HealthMate
   ```

2. **Connect Firebase**
   - Go to the [Firebase Console](https://console.firebase.google.com/) and create a project
   - Add an Android app with package name `com.example.healthmate`
   - Download `google-services.json` and place it in the `/app` directory
   - Enable **Email/Password** under Authentication → Sign-in methods
   - Create a Firestore database in test mode

3. **Open in Android Studio**
   - Open the project folder in Android Studio
   - Let Gradle sync complete
   - Run on your device or emulator

---

## 📂 Project Structure

```
app/
└── src/main/
    ├── java/com/example/healthmate/
    │   ├── Login.java               # Entry point — Firebase auth
    │   ├── Register.java            # New user registration
    │   ├── MainActivity.java        # Navigation drawer host
    │   ├── MealFragment.java        # Meal tracking
    │   ├── CalorieFragment.java     # Calorie recommendations
    │   ├── WaterFragment.java       # Water intake tracking
    │   ├── FitnessFragment.java     # Fitness hub
    │   ├── FruitFragment.java       # Fruit & food calorie lookup
    │   ├── Splits.java              # Workout split selector
    │   ├── ThreeDaySplit.java
    │   ├── FourDaySplit.java
    │   ├── FiveDaySplit.java
    │   └── SixDaySplit.java
    └── res/
        └── layout/                  # XML layouts
```

---

## 🔐 Authentication Flow

1. App launches into **Login** screen
2. New users can **Register** with email & password via Firebase Auth
3. On successful login, users are redirected to **MainActivity**
4. A navigation drawer provides access to all app sections
5. Logout signs out via `FirebaseAuth.getInstance().signOut()` and returns to Login

---



---

## 🧰 Dependencies

```gradle
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.9.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
implementation 'com.google.firebase:firebase-auth-ktx:22.1.0'
implementation 'com.google.firebase:firebase-firestore-ktx:24.7.0'
```

---

## 🙌 Acknowledgements

- [Firebase](https://firebase.google.com/) for backend services
- [Material Design Components](https://m3.material.io/) for the UI toolkit

---

## 📄 License

yashvi
