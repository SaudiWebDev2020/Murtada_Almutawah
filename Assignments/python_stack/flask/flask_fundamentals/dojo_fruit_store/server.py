import datetime
from flask import Flask, render_template, request, redirect
app = Flask(__name__)


@app.route('/')
def index():
    return render_template("index.html")


@app.route('/checkout', methods=['POST'])
def checkout():
    print(request.form)
    obj = {
        'strawberry': int(request.form['strawberry']),
        'raspberry': int(request.form['raspberry']),
        'apple': int(request.form['apple']),
        'first_name': request.form['first_name'],
        'last_name': request.form['last_name'],
        'student_id': request.form['student_id']
    }
    customerName = f"{obj['first_name']} {obj['last_name']}"
    count = obj['strawberry'] + obj['raspberry'] + obj['apple']
    date = datetime.datetime.now().strftime("%B %d %Y %I:%M:%S %p")
    print(f'Charging {customerName} for {count} fruits"')
    print(date)

    return render_template("checkout.html", checkout_details=obj, ordered_count=count, date_of_charge=date)


@app.route('/fruits')
def fruits():
    # DONE return fruits with pre defined list =).!
    fruits = ['Apple', 'Blackberry', 'Raspberry',
              'Strawberry']
    return render_template("fruits.html", fruitsList=fruits)


if __name__ == "__main__":
    app.run(debug=True)
