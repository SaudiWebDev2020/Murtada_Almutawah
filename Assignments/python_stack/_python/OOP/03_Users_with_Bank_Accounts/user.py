from bankaccount import BankAccount


class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
        self.account = BankAccount(int_rate=0.02, balance=0)

    def example_method(self):
        # we can call the BankAccount instance's methods
        # self.account.deposit(100)
        # print(self.account.balance)
        pass

        # adding the deposit method
    def make_deposit(self, amount):  # takes an argument that is the amount of the deposit
        # the specific user's account increases by the amount of the value received
        self.account.deposit(amount)
        return self

    def make_withdrawal(self, amount):
        self.account.withdraw(amount)
        # if (amount < self.account_balance):
        #     self.account_balance -= amount
        # else:
        #     print(
        #         f'Sorry: {self.name}, requested amount is more than your balance.')
        return self

    def display_user_balance(self):
        print(f'User: {self.name}, Balance: ${self.account.balance}')
        return self

    def transfer_money(self, other_user, amount):
        if (amount < self.account.balance):
            self.account.withdraw(amount)
            other_user.make_deposit(amount)
        else:
            self.account.withdraw(amount)
        return self

        # Create 3 instances of the User class
guido = User("Guido van Rossum", "guido@python.com")
monty = User("Monty Python", "monty@python.com")
murtada = User("Murtada Almutawah", "MAMutawah@gmail.com")

# print(guido.account_balance)  # output: 200
# print(monty.account_balance)  # output: 50

print('insufficient_funds', BankAccount.insufficient_funds)

# guido.display_user_balance()
# monty.display_user_balance()
# murtada.display_user_balance()

# Have the first user make 3 deposits and 1 withdrawal and then display their balance
guido.make_deposit(100)
guido.make_deposit(100)
guido.make_deposit(100)
guido.make_withdrawal(50)

guido.display_user_balance()

# Have the second user make 2 deposits and 2 withdrawals and then display their balance
monty.make_deposit(110)
monty.make_deposit(500)
monty.make_withdrawal(300)
monty.make_withdrawal(50)

monty.display_user_balance()

# Have the third user make 1 deposits and 3 withdrawals and then display their balance
murtada.make_deposit(300)
murtada.make_withdrawal(100)
murtada.make_withdrawal(100)
murtada.make_withdrawal(200)

murtada.display_user_balance()

print('-'*90)
print('Transfer 100 from monty to murtada')
murtada.display_user_balance()
monty.display_user_balance()
monty.transfer_money(murtada, 100)
murtada.display_user_balance()
monty.display_user_balance()

print('-' * 90)
print('Transfer 1000 from monty to murtada')
monty.transfer_money(murtada, 1000)
monty.display_user_balance()
print('-'*90)
print('Chaining Methods: ')
# Chaining Methods
murtada.make_deposit(50).make_deposit(
    50).make_deposit(50).display_user_balance()
print('-' * 90)

# murtada.example_method()

print('-'*90)

# Printing all insufficient funds
print('insufficient_funds', BankAccount.insufficient_funds)


# TODO SENSEI BONUS: Allow a user to have multiple accounts; update methods so the user has to specify which account they are withdrawing or depositing to
