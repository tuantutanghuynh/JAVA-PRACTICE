# Java OOP Practice — 70 Exercises

A structured Java OOP practice series covering 70 management-system exercises, from fundamentals to advanced patterns.

## What's Inside

Every exercise enforces the same mandatory checklist:

| Category | Topics |
|---|---|
| OOP Core | Inheritance, polymorphism, abstract class, interface |
| Data Structures | 1D array, `ArrayList`, fixed-size array |
| Control Flow | `if/else`, `switch`, `for`, `while`, `do-while`, ternary |
| Exception Handling | `try-catch`, `finally`, `throw`, `throws`, multi-catch |
| Modern Java | Switch expression, Text Block (Java 14+) |
| Algorithms | Applied LeetCode Easy problems per exercise |

## Tech Stack

- **Java** (JDK 17+), Apache NetBeans
- Pure Java console — no frameworks

## Project Layout

```
Java Practice/
├── README.md               ← you are here
│
├── SchoolSystem/           ← Ex 12: School Management System
├── StudentManager/         ← Ex 03: Student Management
├── VehicleManager/         ← Ex 04: Vehicle Management
├── ProductManager/         ← Ex 05: Store Product Management
├── BankAccountSystem/      ← Ex 07: Banking System
├── BookLibrary/            ← Ex 08: Library Management
├── HospitalSystem/         ← Ex 09: Hospital Management
├── HotelSystem/            ← Ex 10: Hotel Booking
├── Supermarket/            ← Ex 13: Supermarket Management
└── ...
```

---

## Roadmap

Progress is tracked per exercise. Each entry shows: exercise title, algorithm level, and key Java concepts introduced.

**Legend:** ✅ Code + notes done &nbsp;|&nbsp; 🔨 In progress &nbsp;|&nbsp; ⬜ Not started

---

### Group 1 — OOP Foundations · Algorithm Level 1 (find max/min, count)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 01 | Pet Management (Advanced) | Inheritance (3 subclasses), ArrayList, FindByName | ⬜ |
| 02 | Employee Management | Polymorphism, CalcSalary override, TotalSalary | ⬜ |
| 03 | Student Management | Inheritance, GPA sort, FindAboveGPA | ✅ |
| 04 | Vehicle Management | Abstract CalcFuelCost, FilterByFuel | ✅ |
| 05 | Store Product Management | Multi-subclass, TotalValue, SearchByName | ✅ |
| 06 | School Student Grading | scores[] array, CalcAverage, GetRank | ⬜ |

---

### Group 2 — Interface + Abstract · Algorithm Level 2 (grouped max/min, count by type)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 07 | Banking System | `IBankable`, abstract `CalcInterest`, fixed array | ✅ |
| 08 | Library Management | `ILibraryItem`, abstract `GetDescription`, FilterByYear | ✅ |
| 09 | Hospital Management | `IHospitalPerson`, instanceof filter, fixed array | ✅ |
| 10 | Hotel Booking System | `IBookable`, try-catch basics, BookRoom | ✅ |

---

### Group 3 — Exception Handling · Algorithm Level 3 (sort, 2nd max)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 11 | Restaurant Management | Bubble Sort, 2nd max, try-catch crash prevention | ✅ |
| 12 | School Management System | Selection Sort, multi-catch, `IllegalArgumentException` | ✅ |
| 13 | Supermarket Management | Insertion Sort, `InputMismatchException`, scanner buffer | ✅ |
| 14 | Football Team Management | Bubble Sort (descending), `InputMismatchException` vs `NumberFormatException` | ✅ |
| 15 | Gym Management | Selection Sort (ascending), `ArithmeticException`, Fail Fast | ✅ |

---

### Group 4 — while + try-catch Loop · Algorithm Level 4 (linear search, filter, reverse)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 16 | Airline Management | while+try-catch input loop, `RuntimeException`, switch expression intro | ✅ |
| 17 | Car Showroom Management | Linear search multi-result, `IllegalArgumentException`, switch expression | ✅ |
| 18 | Cinema Management | Subarray filter, null return vs throw, switch expression (multi-label) | ✅ |
| 19 | Farm Management | Multi-field validation loop, `FilterBySpecies`, switch expression + `yield` | ⬜ |
| 20 | IT Project Management | `finally` block, reverse order, switch expression in `@Override` | ⬜ |

---

### Group 5 — throw / throws · Algorithm Level 5 (median, mode, group by range)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 21 | Warehouse Management | `finally` for logging, `IllegalStateException`, switch expression + default | ⬜ |
| 22 | Online Course Platform | `throw` Fail Fast pattern, `IllegalArgumentException`, switch in `@Override` | ⬜ |
| 23 | Post Office Management | `throws Exception` (checked), `throw` vs `throws`, switch expression best practice | ⬜ |
| 24 | Agricultural Garden Management | Checked exception flow review, Text Block intro | ⬜ |
| 25 | Pharmacy Management | Mode of array, Text Block table header | ⬜ |

---

### Group 6 — Text Block + String Algorithms · Algorithm Level 6 (palindrome, frequency)

| # | Exercise | Concepts | Status |
|---|---|---|---|
| 26 | Boarding House Management | Palindrome check, char frequency, Text Block JSON-like | ⬜ |
| 27 | Tourist Destination Management | | ⬜ |
| 28 | Publishing House Management | | ⬜ |
| 29 | Programming Contest Management | | ⬜ |
| 30 | Nail Salon Management | | ⬜ |

---

### Group 7 — Exercises 31–40

| # | Exercise | Status |
|---|---|---|
| 31 | Book Club Management | ⬜ |
| 32 | Electrical System Management | ⬜ |
| 33 | Sports Center Management | ⬜ |
| 34 | Conference Management | ⬜ |
| 35 | Coffee Shop Management | ⬜ |
| 36 | Stationery Management | ⬜ |
| 37 | Music Club Management | ⬜ |
| 38 | Gas Station Management | ⬜ |
| 39 | Dental Clinic Management | ⬜ |
| 40 | Golf Course Management | ⬜ |

---

### Group 8 — Exercises 41–50

| # | Exercise | Status |
|---|---|---|
| 41 | Legal System Management | ⬜ |
| 42 | Charity Organization Management | ⬜ |
| 43 | Vocational Training Center | ⬜ |
| 44 | Bus Ticket Booking System | ⬜ |
| 45 | Manufacturing Plant Management | ⬜ |
| 46 | Spa & Beauty Management | ⬜ |
| 47 | Insurance Agency Management | ⬜ |
| 48 | Parking Lot System | ⬜ |
| 49 | Children's Playground Management | ⬜ |
| 50 | Chess Tournament System | ⬜ |

---

### Group 9 — Advanced Exercises 51–60

| # | Exercise | Status |
|---|---|---|
| 51 | ATM Management | ⬜ |
| 52 | Hotel Room Booking System | ⬜ |
| 53 | Food Ordering System | ⬜ |
| 54 | Advanced Hospital Management | ⬜ |
| 55 | Login & Role Authorization System | ⬜ |
| 56 | Student Data File Management | ⬜ |
| 57 | Bank Transfer System | ⬜ |
| 58 | Exam Schedule Management | ⬜ |
| 59 | Delivery System | ⬜ |
| 60 | Restaurant Chain Management | ⬜ |

---

### Group 10 — Advanced Exercises 61–70

| # | Exercise | Status |
|---|---|---|
| 61 | Customer Loyalty Points System | ⬜ |
| 62 | Electronic Invoice Management | ⬜ |
| 63 | Online Classroom Management | ⬜ |
| 64 | Scholarship Management | ⬜ |
| 65 | Inventory Management System | ⬜ |
| 66 | Software Project Management | ⬜ |
| 67 | Online Exam System | ⬜ |
| 68 | Gym Management (Advanced) | ⬜ |
| 69 | Movie Ticket Booking System | ⬜ |
| 70 | Advanced Banking System | ⬜ |

---

**Progress: 13 / 70 completed**
