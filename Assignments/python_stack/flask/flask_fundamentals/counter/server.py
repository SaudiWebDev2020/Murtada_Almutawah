from flask import Flask, render_template, request, redirect, session
app = Flask(__name__)
app.secret_key = 'keep it secret, keep it safe'


@app.route('/')
def index():
    session.setdefault('visits', 0)
    session['visits'] += 1
    return render_template("index.html", counter=session['visits'])


@app.route('/add_two', methods=['POST'])
def add_one_more():
    session['visits'] += 1
    return redirect("/")  # changed this line!


@app.route('/destroy_session', methods=['POST'])
def create_user():
    session.clear()
    return redirect("/")  # changed this line!


if __name__ == "__main__":
    app.run(debug=True)
