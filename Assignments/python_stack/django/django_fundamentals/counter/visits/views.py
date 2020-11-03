from django.http import request
from django.shortcuts import render, redirect

# Create your views here.


def index(request):
    request.session.setdefault('count', 0)
    request.session.setdefault('visits', 0)
    request.session.setdefault('counter', 0)

    request.session['visits'] += 1
    # print(request.session['visits'], request.session['counter'])
    context = {
        'visits': request.session['visits'],
        'counter': request.session['counter'],
        'count': request.session['counter']+request.session['visits'],
    }
    return render(request, 'index.html', context)


def add_two(request):
    request.session['counter'] += 1
    return redirect("/")  # changed this line!


def destroy_session(request):
    request.session.clear()
    return redirect("/")  # changed this line!


def add_manully(request):
    # print(request.POST['number_to_add'])
    request.session['counter'] += int(request.POST['number_to_add'])
    return redirect("/")  # changed this line!
