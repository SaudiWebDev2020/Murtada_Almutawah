
class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0

    # adding the deposit method
    def make_deposit(self, amount):  # takes an argument that is the amount of the deposit
        # the specific user's account increases by the amount of the value received
        self.account_balance += amount

    def make_withdrawal(self, amount):
        if (amount < self.account_balance):
            self.account_balance -= amount
            return True
        else:
            print(
                f'Sorry: {self.name}, requested amount is more than your balance.')
            return False

    def display_user_balance(self):
        print(f'User: {self.name}, Balance: ${self.account_balance}')

    def transfer_money(self, other_user, amount):
        transferred = self.make_withdrawal(amount)
        if (transferred):
            other_user.make_deposit(amount)
            return True
        else:
            print(
                f'Sorry: {self.name}, requested amount is more than your balance.')
            return False

            # Create 3 instances of the User class
guido = User("Guido van Rossum", "guido@python.com")
monty = User("Monty Python", "monty@python.com")
murtada = User("Murtada Almutawah", "MAMutawah@gmail.com")

# print(guido.account_balance)  # output: 200
# print(monty.account_balance)  # output: 50

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
murtada.display_user_balance()
monty.display_user_balance()
monty.transfer_money(murtada, 100)
murtada.display_user_balance()
monty.display_user_balance()
