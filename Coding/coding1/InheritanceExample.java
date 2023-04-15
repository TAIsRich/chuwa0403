package coding1;

public class InheritanceExample {
    public static void main(String[] args) {
        SavingAccount account1 = new SavingAccount("Tom", 0, 1000, 10);
        CheckingAmount account2 = new CheckingAmount("Tom", 0, 1000, 1000);

        account1.addInterest(10);
        account2.deductFee(50);
    }
}

abstract class BankAccount {
    protected String holderName;
    protected int accountBalance;
    protected int accountNumber;

    public BankAccount(String holderName, int accountBalance, int accountNumber) {
        this.holderName = holderName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(int money) {
        accountBalance -= money;
    }

    public void deposit(int money) {
        accountBalance += money;
    }
}

class SavingAccount extends BankAccount {
    private int interestAmount;

    public SavingAccount(String holderName, int accountBalance, int accountNumber, int interestAmount) {
        super(holderName, accountBalance, accountNumber);
        this.interestAmount = interestAmount;
    }

    public void addInterest(int interest) {
        interestAmount += interest;
    }
}

class CheckingAmount extends BankAccount {
    private int atmCard;
    public CheckingAmount(String holderName, int accountBalance, int accountNumber, int atmCard) {
        super(holderName, accountBalance, accountNumber);
        this.atmCard = atmCard;
    }

    public void deductFee(int fee) {
        accountBalance -= fee;
    }
}