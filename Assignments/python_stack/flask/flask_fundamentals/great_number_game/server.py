from random import randint
from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


@app.route('/')
def index():
    session.setdefault('guess', 0)
    session.setdefault('random_number', randint(1, 100))
    session.setdefault('result', '')
    session.setdefault('leaderboard', [])
    session.setdefault('saved_record', False)

    return render_template("index.html", result=session['result'])


@app.route('/guess', methods=['POST'])
def guess():
    print('I am in guess method', session['random_number'])
    # print(request.form)

    session['guess'] += 1
    # print(session['guess'], session['random_number'])
    randomInt = int(session['random_number'])
    if(int(request.form['number']) > randomInt):
        session['result'] = 'too_high'
    elif(int(request.form['number']) < randomInt):
        # print('Too Low')
        session['result'] = 'too_low'
    elif(int(request.form['number']) == randomInt):
        session['result'] = 'equal'
        # print('Equal')

    return redirect("/")  # changed this line!


@app.route('/new_game', methods=['POST'])
def new_game():
    session['guess'] = 0
    session['random_number'] = randint(1, 100)
    session['result'] = ''
    session['saved_record'] = False
    return redirect("/")  # changed this line!


@app.route('/leaderboard')
def view_leaderboard():
    print(session['saved_record'])

    return render_template("leaderboard.html")


@app.route('/submit_name', methods=['POST'])
def save_record():
    print(session['saved_record'])
    winner = {
        'name': request.form['name'],
        'attempts': session['guess'],
    }
    if not session['saved_record']:
        session['leaderboard'].append(winner)
        session['saved_record'] = True
    return redirect('/leaderboard')


if __name__ == "__main__":
    app.run(debug=True)
