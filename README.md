#    🚀 Selenium Parallel Automation Framework with Extent Reporting 

> A scalable, thread-safe, and production-ready Selenium Automation Framework built using **Java + TestNG + Selenium WebDriver + Extent Reports**

---

## ✨ Highlights

✅ Parallel Test Execution  
✅ Multi-Browser Support  
✅ Thread-Safe WebDriver Management  
✅ Extent Reports Integration  
✅ Screenshot Capture on Failure  
✅ Page Object Model (POM)  
✅ Headless Execution Support  
✅ Centralized Configuration Management  
✅ Reusable Utilities & Logging System  

---

# 🛠️ Tech Stack

| 🔧 Technology | 📌 Purpose |
|---|---|
| ☕ Java | Programming Language |
| 🌐 Selenium WebDriver | Browser Automation |
| 🧪 TestNG | Test Execution Framework |
| 📦 Maven | Dependency Management |
| 📊 Extent Reports | HTML Reporting |
| 🚗 WebDriverManager | Driver Management |

---

# 🏗️ Framework Architecture

```text
src
 ├── main
 │   ├── java
 │   │   ├── base
 │   │   ├── config
 │   │   ├── driver
 │   │   ├── enums
 │   │   ├── exceptions
 │   │   ├── listeners
 │   │   ├── pages
 │   │   ├── reports
 │   │   └── utils
 │   │
 │   └── resources
 │       └── config.properties
 │
 └── test
     └── java
         └── tests
```

---

# ⚡ Core Features

## 🧵 Parallel Execution

✔ Supports parallel execution using TestNG  
✔ Uses `ThreadLocal<WebDriver>` for thread safety  
✔ Safe concurrent browser execution  

---

## 🌍 Multi-Browser Support

Supported browsers:

- 🟢 Chrome
- 🟠 Firefox
- 🔵 Edge

---

## 👻 Headless Execution

Run tests without opening browser UI.

### 🔹 Enable Headless Mode

```properties
headless=true
```

---

# ⚙️ Configuration Management

All framework configurations are managed through:

```text
config.properties
```

## 📄 Example Configuration

```properties
base.url=https://demo.nopcommerce.com
browser=chrome
headless=false
pageLoadTimeout=60
screenshot.dir=screenshots
```

---

# 🧠 Design Patterns Used

| 🏛️ Pattern | 📌 Usage |
|---|---|
| 🧱 Page Object Model | Page separation |
| 🏭 Factory Pattern | Driver creation |
| 🔒 Singleton Pattern | ExtentReports instance |
| 🧵 ThreadLocal Pattern | Parallel execution safety |

---

# 🚗 Driver Management

## 📍 DriverFactory

Responsible for:

- Driver initialization
- Thread-safe browser sessions
- Browser lifecycle management
- Driver configuration

### 🔹 Key Implementation

```java
private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
```

---

# 🌐 Browser Management

## 📍 BrowserManager

Handles:

✔ Browser setup  
✔ Browser options  
✔ Headless configuration  
✔ WebDriverManager integration  

### 🔹 Supported Browser Enums

```java
CHROME
FIREFOX
EDGE
```

---

# 📄 Reporting System

## 📊 Extent Reports Integration

### 📍 Components

- `ExtentManager`
- `ExtentLogger`
- `ExtentTestManager`

### ✨ Capabilities

✅ Detailed execution reports  
✅ Step-level logging  
✅ Failure screenshots  
✅ Parallel-safe reporting  

### 📂 Report Location

```text
reports/index.html
```

---

# 📸 Screenshot Utility

## 📍 ScreenshotManager

Automatically captures screenshots during failures.

### 📂 Screenshot Path Format

```text
screenshots/<TestClass>/<TestName>_<timestamp>.png
```

---

# 🧱 Base Page Utilities

## 📍 BasePage

Provides reusable Selenium operations:

✔ Click actions  
✔ Typing actions  
✔ Explicit waits  
✔ Visibility checks  
✔ Navigation utilities  

### 🔹 Uses

```java
WebDriverWait
ExpectedConditions
```

---

# 🧪 Sample Test Scenario

## 📍 Registration Test

Automates user registration flow.

### ✅ Covered Steps

- Open registration page
- Select gender
- Fill registration form
- Submit registration
- Validate successful registration

---

# 📊 Data-Driven Execution

Uses TestNG DataProvider with parallel execution support.

```java
@DataProvider(parallel = true)
```

---

# 🚀 Running Tests

## ▶ Run All Tests

```bash
mvn clean test
```

---

## ▶ Run Specific Browser

```bash
mvn test -Dbrowser=firefox
```

---

## ▶ Run Headless

```bash
mvn test -Dheadless=true
```

---

# 🧵 Parallel Execution Setup

## 📄 Sample `testng.xml`

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">

<suite name="Parallel Suite" parallel="tests" thread-count="3">

    <listeners>
        <listener class-name="com.amalw.listeners.ExtentTestListener"/>
    </listeners>

    <test name="Chrome Tests">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.amalw.tests.RegistrationTest"/>
        </classes>
    </test>

    <test name="Firefox Tests">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.amalw.tests.RegistrationTest"/>
        </classes>
    </test>

</suite>
```

---

# 📝 Logging System

## 📍 Supported Log Levels

```text
INFO
ACTION
VALIDATION
CONFIG
DRIVER
PASS
FAIL
ERROR
```

---

# 🧩 Framework Components

| 📦 Component | 🎯 Responsibility |
|---|---|
| `ConfigManager` | Configuration handling |
| `BrowserManager` | Browser creation |
| `DriverFactory` | Thread-safe drivers |
| `BasePage` | Common Selenium actions |
| `RegisterPage` | Registration page actions |
| `ExtentLogger` | Framework logging |
| `ExtentManager` | Report initialization |
| `ScreenshotManager` | Screenshot capture |
| `ExtentTestListener` | TestNG listener integration |

---

# ✅ Best Practices Implemented

✔ Clean Architecture  
✔ Reusable Utilities  
✔ Centralized Configurations  
✔ Explicit Waits Only  
✔ Thread-Safe Execution  
✔ Exception Handling  
✔ Separation of Concerns  
✔ Maintainable Code Structure  

---

# 🔮 Future Enhancements

🚀 Selenium Grid Integration  
🚀 Docker Support  
🚀 Jenkins CI/CD Integration  
🚀 Allure Reporting  
🚀 Retry Analyzer  
🚀 API Testing Integration  
🚀 Database Validation  
🚀 Cloud Execution Support  

---

# 📂 Report Output

```text
reports/index.html
```

Open the generated report in a browser after execution.

---

# 👨‍💻 Author

## Amal

---

# ⭐ If You Like This Project

Give it a ⭐ on GitHub and feel free to contribute!

---

# 📜 License

This project is open-source and available for learning, enhancement, and contribution.
