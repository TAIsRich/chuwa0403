# Week 1 Day 2



### 1.demonstrate the three foundmental concepts of OOP

Write up Example code to demonstrate the three foundmental concepts of OOP. (reference **Code Demo**

**repo** as example)

- Encapsulation

  Good Example:

  ```java
  package Q1.Encapsulation;
  
  public class UserAccountGood {
      private String username;
      private double balance;
  
      public UserAccountGood(String username, double balance) {
          this.username = username;
          this.balance = balance;
      }
      public String getUsername() {
          return username;
      }
  
      public double getBalance() {
          return balance;
      }
  
      public void setBalance(double balance) {
          this.balance = balance;
      }
  
      public void setUsername(String username) {
          this.username = username;
      }
  }
  ```

  Bad Example:

  ```java
  package Q1.Encapsulation;
  
  public class UserAccountBad {
      public String username;
      public double balance;
  
      public UserAccountBad(String username, double balance) {
          this.username = username;
          this.balance = balance;
      }
  }
  ```

  Test:

  ```java
  package Q1.Encapsulation;
  
  public class EncTest {
      public static void main(String[] args) {
          UserAccountBad bad = new UserAccountBad("bad", 0.0);
          UserAccountGood good = new UserAccountGood("good", 0.0);
  
          bad.username = "bad2";
          bad.balance = 100.0;
  
          good.setUsername("good2");
          good.setBalance(100.0);
  
          System.out.println(bad.username);
          System.out.println(bad.balance);
  
          System.out.println(good.getUsername());
          System.out.println(good.getBalance());
      }
  }
  ```

  Encapsulation hide the internal details of the object, form the data and behavior into units and provide APIs. But in bad example key attribution are marked as public, which makes this attribute can be modified by code out of the class.

- Polymorphism

  ```java
  package Q1.Polymorphism;
  
  public abstract class Animal {
      public void makeSound() {
          System.out.println("The animal makes a sound.");
      }
  
      public void makeSound(String sound){
          System.out.println("The animal makes a sound: " + sound);
      }
  }
  
  class Dog extends Animal {
      @Override
      public void makeSound() {
          System.out.println("The dog barks.");
      }
  }
  
  class Cat extends Animal {
      @Override
      public void makeSound() {
          System.out.println("The cat meows.");
      }
  }
  ```

  In this example, Override is implementd by building specific method in sub classes ,which is inherited from spuer class. Overloading is realized by building two makeSound methods with different parameter list in one class.

- Inheritance

  ```java
  package Q1.Inheritance;
  
  public class Animal {
      protected String name;
  
      public Animal(String name) {
          this.name = name;
      }
  
      public void eat() {
          System.out.println(name + " is eating.");
      }
  }
  
  class Mammal extends Animal {
      public Mammal(String name) {
          super(name);
      }
  
      public void walk() {
          System.out.println(name + " is walking.");
      }
  }
  
  class Dog extends Mammal {
      public Dog(String name) {
          super(name);
      }
  
      public void bark() {
          System.out.println(name + " is barking.");
      }
  }
  ```

  In this example, Dog extend Mammal, Mammal extends Animal. This is multilayer inheritence.