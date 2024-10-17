# Equation Solver

This program reads mathematical equations from a file, converts them into Reverse Polish Notation (RPN), 
and calculates the results. It handles multiple variables and allows solving complex equations using standard 
operators like addition, subtraction, multiplication, division, and exponentiation.

## Features

- Reads equations from a text file.
- Supports basic mathematical operators: +, -, *, /, ^.
- Handles negative numbers, parentheses, and variable assignments.
- Converts equations to Reverse Polish Notation (RPN).
- Solves equations step-by-step, replacing variables with their calculated values.

## How to use 

1. Prepare your text file with equations.
Remember to write equation in form {variable} = {equation}

```
a = 2 * x -b
x = 5*(2*(2+1)^2)
b = -3 + (x - 2^3)/2
```

3. Clone repository:

```
git clone https://github.com/AgnieszkaNeu/EquationsSolver.git
```

3. Navigate to directory:

```
cd EquationSolver
```

4. Compile the Java files:
```
javac Main.java
```

5. Run the program: 
```
java Mian.java directory_to.txt
```

