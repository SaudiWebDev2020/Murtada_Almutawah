import base64
from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


def unback():
    # Decode the session cookie
    print(base64.urlsafe_b64decode('eyJjb3VudGVyIjoxLCJ2aXNpdHMiOjJ9'))


@app.route('/')
def index():
    print(session)
    session.setdefault('visits', 0)
    session.setdefault('counter', 0)
    session['visits'] += 1
    print(session['visits'], session['counter'])
    return render_template("index.html", counter=session['visits']+session['counter'])


@app.route('/add_two', methods=['POST'])
def add_one_more():
    session['counter'] += 1
    return redirect("/")  # changed this line!


@app.route('/destroy_session', methods=['POST'])
def create_user():
    session.clear()
    return redirect("/")  # changed this line!


if __name__ == "__main__":
    app.run(debug=True)
