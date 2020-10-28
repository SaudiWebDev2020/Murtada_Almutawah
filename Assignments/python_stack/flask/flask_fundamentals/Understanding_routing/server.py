from flask import Flask

app = Flask(__name__)


@app.route('/')
def hello_world():
    return "Hello World!"


@app.route('/dojo')
def dojo():
    return "Dojo!"


@app.route('/say/<string:something>')
def say_somthing(something):
    return f"Hello {something}!"


@app.route('/repeat/<int:times>/<string:something>')
def repeat_somthing(something, times):
    return f"{something} "*times


@app.errorhandler(404)
def no_response(e):
    return "Sorry! No response. Try again."


if __name__ == "__main__":
    app.run(debug=True)
