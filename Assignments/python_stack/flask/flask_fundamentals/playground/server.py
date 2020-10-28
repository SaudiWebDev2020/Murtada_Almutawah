from flask import Flask, render_template

app = Flask(__name__)


@app.route('/play')
def reg_play():
    return render_template('index.html', num_box=3)


@app.route('/play/<int:boxes>')
def custom_num_play(boxes):
    return render_template('index.html', num_box=boxes)


@app.route('/play/<int:boxes>/<string:color>')
def custom_num_color_play(boxes, color):
    return render_template('index.html', num_box=boxes, box_color=color)


if __name__ == "__main__":
    app.run(debug=True)
