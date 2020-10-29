from flask import Flask, render_template

app = Flask(__name__)


@app.route('/')
def show_board():
    return render_template('index.html', arr_map=createBoard(8, 8), first_color="red", second_color="black")


@app.route('/<int:rows>')
def show_board_with_rows(rows):
    return render_template('index.html', arr_map=createBoard(rows, 8), first_color="lightgreen", second_color="black")


@app.route('/<int:rows>/<int:columns>')
def show_board_with_rows_columns(rows, columns):
    return render_template('index.html', arr_map=createBoard(rows, columns), first_color="lightyellow", second_color="black")


@app.route('/<int:rows>/<int:columns>/<string:color1>/<string:color2>')
def show_board_with_rows_columns_with_colors(rows, columns, color1, color2):
    return render_template('index.html', arr_map=createBoard(rows, columns), first_color=color1, second_color=color2)


def createBoard(rows, columns):
    arr = []
    for i in range(0, rows):
        row = []
        start = i % 2
        for j in range(columns):
            row.append(start)
            start = (start + 1) % 2
        arr.append(row)
    # print(arr)
    return arr


if __name__ == "__main__":
    app.run(debug=True)
