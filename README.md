# 🛒 Alfagift Mobile Automation Testing

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Appium](https://img.shields.io/badge/Appium-8.6.0-blueviolet?style=flat-square&logo=appium)
![Cucumber](https://img.shields.io/badge/Cucumber-7.14.0-green?style=flat-square&logo=cucumber)
![Selenium](https://img.shields.io/badge/Selenium-4.13.0-brightgreen?style=flat-square&logo=selenium)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=flat-square&logo=apache-maven)

Automated testing framework untuk aplikasi mobile **Alfagift** menggunakan **Appium**, **Cucumber BDD**, dan **Java**. Framework ini dirancang untuk menguji fungsionalitas utama aplikasi seperti login dan shopping flow dengan pendekatan behavior-driven development.

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [Prerequisites](#-prerequisites)
- [Installation](#-installation)
- [Configuration](#-configuration)
- [Running Tests](#-running-tests)
- [Test Scenarios](#-test-scenarios)
- [Reports](#-reports)
- [Contributing](#-contributing)

---

## ✨ Features

- ✅ **BDD Framework** dengan Cucumber untuk test scenarios yang mudah dibaca
- ✅ **Page Object Model (POM)** untuk maintainability yang lebih baik
- ✅ **Appium Integration** untuk mobile automation testing
- ✅ **Hooks Management** untuk setup dan teardown otomatis
- ✅ **Modular Architecture** dengan separation of concerns
- ✅ **Cross-platform Support** (Android/iOS ready)

---

## 🛠 Tech Stack

| Technology   | Version | Purpose                       |
| ------------ | ------- | ----------------------------- |
| **Java**     | 17      | Programming Language          |
| **Appium**   | 8.6.0   | Mobile Automation Framework   |
| **Selenium** | 4.13.0  | WebDriver Support             |
| **Cucumber** | 7.14.0  | BDD Framework                 |
| **JUnit**    | 4.13.2  | Test Runner                   |
| **Maven**    | -       | Build & Dependency Management |

---

## 📁 Project Structure

```
alfagift/
├── 📂 src/
│   ├── 📂 main/
│   │   ├── 📂 java/
│   │   └── 📂 resources/
│   └── 📂 test/
│       ├── 📂 java/
│       │   └── 📂 alfagift/
│       │       ├── 📄 Main.java
│       │       ├── 📂 pages/
│       │       │   ├── 📄 BerandaPage.java
│       │       │   └── 📄 HomePage.java
│       │       ├── 📂 runners/
│       │       │   └── 📄 TestRunner.java
│       │       └── 📂 steps/
│       │           ├── 📄 Hooks.java
│       │           ├── 📄 LoginSteps.java
│       │           └── 📄 ShoppingSteps.java
│       └── 📂 resources/
│           └── 📂 features/
│               ├── 📄 Login.feature
│               └── 📄 Shoping.feature
├── 📂 target/
├── 📄 pom.xml
├── 📄 .gitignore
└── 📄 README.md
```

### 📌 Directory Explanation

- **`pages/`** - Page Object classes yang merepresentasikan UI elements
- **`steps/`** - Step definitions untuk Cucumber scenarios
- **`runners/`** - Test runner configuration
- **`features/`** - Gherkin feature files dengan test scenarios
- **`Hooks.java`** - Setup dan teardown untuk test execution

---

## 📦 Prerequisites

Sebelum menjalankan project ini, pastikan Anda telah menginstall:

- ☑️ **Java Development Kit (JDK) 17** atau lebih tinggi
- ☑️ **Maven 3.6+** untuk dependency management
- ☑️ **Node.js & npm** untuk Appium
- ☑️ **Appium Server** (v2.x recommended)
- ☑️ **Android Studio** (untuk Android testing)
  - Android SDK
  - Android Emulator atau Physical Device
- ☑️ **Xcode** (untuk iOS testing - macOS only)

### 🔍 Verify Installation

```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Check Node.js version
node -v

# Check Appium installation
appium -v
```

---

## 🚀 Installation

### 1️⃣ Clone Repository

```bash
git clone <repository-url>
cd alfagift
```

### 2️⃣ Install Dependencies

```bash
mvn clean install
```

### 3️⃣ Install Appium

```bash
# Install Appium globally
npm install -g appium

# Install Appium drivers
appium driver install uiautomator2  # For Android
appium driver install xcuitest       # For iOS
```

### 4️⃣ Verify Appium Setup

```bash
# Check Appium doctor for setup verification
npm install -g appium-doctor
appium-doctor --android
```

---

## ⚙️ Configuration

### Appium Server

Start Appium server sebelum menjalankan tests:

```bash
appium
```

Atau dengan custom port:

```bash
appium -p 4723
```

### Device Configuration

Edit konfigurasi device di `Hooks.java` atau buat file konfigurasi terpisah:

```java
// Example Android Configuration
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("deviceName", "emulator-5554");
capabilities.setCapability("app", "/path/to/alfagift.apk");
capabilities.setCapability("automationName", "UiAutomator2");
```

---

## ▶️ Running Tests

### Run All Tests

```bash
mvn clean test
```

### Run Specific Feature

```bash
mvn test -Dcucumber.options="src/test/resources/features/Login.feature"
```

### Run with Tags

```bash
# Run only positive tests
mvn test -Dcucumber.options="--tags @PositiveTest"
```

### Run from IDE

1. Open project di IntelliJ IDEA atau Eclipse
2. Navigate ke `TestRunner.java`
3. Right-click → **Run 'TestRunner'**

---

## 🧪 Test Scenarios

### 🔐 Login Feature

**File:** `Login.feature`

| Scenario      | Tag             | Description                                            |
| ------------- | --------------- | ------------------------------------------------------ |
| Success Login | `@PositiveTest` | Login menggunakan phone number dan password yang valid |

**Steps:**

1. User berada di halaman login
2. User klik tombol "Masuk"
3. User mengisi password
4. User klik "Masuk ke beranda"
5. Verify login berhasil

---

### 🛍️ Shopping Feature

**File:** `Shoping.feature`

| Scenario              | Tag             | Description                              |
| --------------------- | --------------- | ---------------------------------------- |
| Search & View Product | `@PositiveTest` | Mencari produk dan melihat detail produk |

**Steps:**

1. User sudah login
2. User klik field search
3. User mengisi search box dengan "Ultra Milk Coklat"
4. User klik tombol search
5. User memilih produk spesifik
6. Verify halaman detail produk ditampilkan

---

## 📊 Reports

Setelah test execution, reports akan di-generate di:

```
target/
├── cucumber-reports/
│   ├── cucumber.html
│   └── cucumber.json
└── surefire-reports/
```

### View HTML Report

```bash
# Open in browser
start target/cucumber-reports/cucumber.html  # Windows
open target/cucumber-reports/cucumber.html   # macOS
xdg-open target/cucumber-reports/cucumber.html  # Linux
```

---

## 🤝 Contributing

Contributions are welcome! Untuk berkontribusi:

1. Fork repository ini
2. Buat feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push ke branch (`git push origin feature/AmazingFeature`)
5. Buat Pull Request

### 📝 Coding Standards

- Gunakan **Page Object Model** pattern
- Tulis test scenarios dalam **Gherkin** yang jelas dan deskriptif
- Tambahkan **comments** untuk logic yang kompleks
- Follow **Java naming conventions**
- Pastikan semua tests **passing** sebelum commit

---

## 📞 Support

Jika Anda menemukan bug atau memiliki pertanyaan:

- 🐛 **Report Bug:** Buat issue di repository
- 💡 **Feature Request:** Buat issue dengan label `enhancement`
- 📧 **Contact:** [Your Email/Contact]

---

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

---

## 🙏 Acknowledgments

- **Alfagift** - Application under test
- **Appium** - Mobile automation framework
- **Cucumber** - BDD framework
- **Selenium** - WebDriver support

---

<div align="center">

**Made with ❤️ for Quality Assurance**

⭐ Star this repository if you find it helpful!

</div>
