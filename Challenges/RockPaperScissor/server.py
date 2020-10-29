import random
from flask import Flask, render_template, request, redirect, session, flash

app = Flask(__name__)
app.secret_key = 'secret'


@app.route('/')
def index():
    session.setdefault('wins', 0)
    session.setdefault('losses', 0)
    session.setdefault('ties', 0)
    return render_template("index.html", wins=session['wins'], losses=session['losses'], ties=session['ties'])


@app.route('/', methods=['Post'])
def game():
    # print(request.form['myChoice'])
    player = request.form['myChoice']
    computer = random_Choice()
    winner = ''
    flash(f'You picked {player}')
    flash(f'Computer picked {computer}')
    session.setdefault('winner', player)
    print(computer, player)
    if (computer == 'scissors' and player == 'paper'):
        winner = 'computer'
        session['losses'] += 1
    elif computer == 'paper' and player == 'rock':
        winner = 'computer'
        session['losses'] += 1
    elif computer == 'rock' and player == 'scissors':
        winner = 'computer'
        session['losses'] += 1
    elif computer == player:
        session['ties'] += 1
        winner = 'no one'
    else:
        winner = 'You'
        session['wins'] += 1
    flash(f'{winner} win!!')
    return redirect('/')


def random_Choice():
    choice = round(random.random() * 3)
    # print(choice)
    if choice == 0:
        return "rock"
    elif choice == 1:
        return "paper"
    else:
        return "scissors"


@app.route('/reset')
def reset():
    session['wins'] = 0
    session['losses'] = 0
    session['ties'] = 0
    return redirect('/')


if __name__ == "__main__":
    app.run(debug=True)
