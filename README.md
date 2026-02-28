# 💳 ATM Machine Simulation (Console-Based Java Project)

![Java](https://img.shields.io/badge/Java-19-blue.svg)
![Platform](https://img.shields.io/badge/Platform-Console%20App-lightgrey)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)
![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

This is a **console-based ATM machine simulation system** developed in **Java**. It allows users to perform basic banking operations such as balance check, deposit, withdrawal, fund transfer, and PIN change, all via terminal input.

---

# 🚀 Features

- ✅ PIN-based login with retry limit
- 💵 Deposit money
- 💸 Withdraw money with balance check
- 📃 Mini statement (transaction history)
- 🔁 Fund transfer to another account
- 🔐 PIN change functionality
- 🚪 Exit ATM interface

---

# 🧰 Technologies Used

- Java (JDK 19)
- Java Collections Framework (ArrayList, HashMap)
- Console I/O using `Scanner` class

---

# 📂 How to Run the Program

## 1️⃣ Prerequisites:
- Java JDK 19 or above installed
- Terminal / Command Line / VS Code terminal

## 2️⃣ Compile the code:
```bash
javac ATMmachine.java
```

## 3️⃣ Run the program:
```bash
java ATMmachine
```

---

## 🔍 Sample Console Output

```
Please Enter Your PIN:
1019   // default PIN

Enter Your Choice:

1. Check Balance
2. Deposit Money
3. Withdraw Money
4. Mini Statement
5. PIN Change
6. Transfer Funds
7. Exit

Enter Deposit Amount: 1000
Money Deposited successfully

Enter Your Choice: 4
Mini Statement:
Deposited: 1000.0

Current Balance: 1000.0

Enter Your Choice: 3
Enter Withdrawal Amount: 500
Withdrawal Successful!

Enter Your Choice: 1
Your account Balance is: 500.0

Enter Your Choice: 7
Thank you for using the ATM!
```

---

## 📦 Folder Structure

```
ATM-Machine-Simulation/
│
├── ATMmachine.java       # Main Java program
└── README.md             # Project documentation
```


## 🎯 Future Enhancements

- [ ] Implement GUI using JavaFX or Swing  
- [ ] Store account data in file or database  
- [ ] Add multi-user login system  

---

## 🙋‍♂️ Author

**Roshan Mahade**  
📧 (roshanmahade2004@gmail.com)# Roshan-Mahade-java-project
