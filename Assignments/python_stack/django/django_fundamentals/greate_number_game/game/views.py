from django.shortcuts import redirect, render
from random import randint
# Create your views here.


def index(request):
    request.session.setdefault('guess', 0)
    request.session.setdefault('random_number', randint(1, 100))
    request.session.setdefault('result', '')
    request.session.setdefault('leaderboard', [])
    request.session.setdefault('saved_record', False)

    return render(request, 'index.html', context={})


def guess(request):
    request.session['guess'] += 1
    # print(request.session['guess'], request.session['random_number'])
    randomInt = int(request.session['random_number'])
    if(int(request.POST['number']) > randomInt):
        request.session['result'] = 'too_high'
    elif(int(request.POST['number']) < randomInt):
        # print('Too Low')
        request.session['result'] = 'too_low'
    elif(int(request.POST['number']) == randomInt):
        request.session['result'] = 'equal'
        # print('Equal')

    return redirect('/')


def new(request):
    request.session['guess'] = 0
    request.session['random_number'] = randint(1, 100)
    request.session['result'] = ''
    request.session['saved_record'] = False
    return redirect('/')


def save_record(request):
    winner = {
        'name': request.POST['name'],
        'attempts': request.session['guess'],
    }
    if not request.session['saved_record']:
        request.session['leaderboard'].append(winner)
        request.session['saved_record'] = True
    return redirect('/leaderboard')


def view_leaderboard(request):
    return render(request, 'leaderboard.html', context={})
