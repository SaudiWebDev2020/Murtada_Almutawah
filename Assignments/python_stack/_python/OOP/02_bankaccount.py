
class BankAccount:
    # don't forget to add some default values for these parameters!
    def __init__(self, int_rate, balance=0):
        # your code here! (remember, this is where we specify the attributes for our class)
        # don't worry about user info here; we'll involve the User class soon
        self.int_rate = int_rate
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount
        return self

    def withdraw(self, amount):
        if (amount < self.balance):
            self.balance -= amount
        else:
            print(
                f'Insufficient funds: Charging a $5 fee')
            self.withdraw(5)
        return self

    def display_account_info(self):
        print(f'Balance: ${self.balance}')
        return self

    def yield_interest(self):
        # your code here
        self.balance *= 1 + self.int_rate
        return self


# Create 2 accounts
guido = BankAccount(0.01)
monty = BankAccount(0.05, 100)

guido.deposit(50).deposit(100).deposit(
    200).withdraw(100).display_account_info()

monty.deposit(50).deposit(100).withdraw(
    100).withdraw(100).withdraw(100).withdraw(100).yield_interest().display_account_info()
