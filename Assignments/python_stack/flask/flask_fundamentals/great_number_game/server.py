import random
from flask import Flask, render_template, request, redirect, session

app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


@app.route('/')
def index():
    session.setdefault('randomNumber', random.randint(
        1, 100))  # Save a rundom number
    return render_template("index.html")


@app.route('/guess', methods=['POST'])
def guess():
    print('I am in guess method', session['randomNumber'])
    print(request.form)
    return redirect("/")  # changed this line!


if __name__ == "__main__":
    app.run(debug=True)
