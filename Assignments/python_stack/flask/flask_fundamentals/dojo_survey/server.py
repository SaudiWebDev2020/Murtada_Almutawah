from flask import Flask, render_template, request, redirect


app = Flask(__name__)


@app.route("/")
def index():
    return render_template("index.html")


@app.route("/result", methods=["POST"])
def result():
    print(request.form)
    return render_template("result.html", name=request.form['your_name'], dojo_location=request.form['dojo_location'], favorite_language=request.form['favorite_language'], comment=request.form['comment'])


if __name__ == "__main__":
    app.run(debug=True)
