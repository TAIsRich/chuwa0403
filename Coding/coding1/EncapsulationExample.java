class BankAccount {

    // The balance instance variable is encapsulated because it is declared as private. This means that the variable can only be accessed within the BankAccount class itself.
    // The getBalance() method is a public method that provides access to the balance variable in a controlled way. This method can be used by other classes to retrieve the value of the balance variable, but they cannot modify it directly.
    // The deposit() and withdraw() methods are also public methods that provide a way to update the balance variable. These methods control how the balance variable is updated and ensure that the account balance is always valid.
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Not enough to withdraw");
        }
    }
}
