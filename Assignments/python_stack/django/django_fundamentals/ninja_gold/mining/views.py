from django.shortcuts import redirect, render
import random
from datetime import datetime

# If it is DONE change TODO To DONE
# TODO Move the step counter into process_money
# TODO Edit the template to fit the new requirements
# TODO Setup list of challenges
# TODO Set up a way to select challenge.
# TODO Clean up the code.
# TODO Template => Alert the user if he win or loss


options = []
options.append({'op_id': 0, 'name': 'Farm', 'min': 10,
                'max': 20, 'operations': ['earns']})
options.append({'op_id': 1, 'name': 'Cave', 'min': 5,
                'max': 10, 'operations': ['earns']})
options.append({'op_id': 2, 'name': 'House', 'min': 2,
                'max': 5, 'operations': ['earns']})
options.append({'op_id': 3, 'name': 'Casino', 'min': 0,
                'max': 50, 'operations': ['earns', 'takes']})


def index(request):

    # Set Up for challenge
    request.session.setdefault('num_step', 0)
    request.session.setdefault('goal', 100)

    # Set Up Ballance & massages
    request.session.setdefault('balance', 0)
    request.session.setdefault('massages', [])

    if 'num_step' in request.session:
        request.session['num_step'] += 1
        if request.session['num_step'] >= 10:
            print('lose')
            request.session.clear()
            return redirect('/')
        if request.session['balance'] >= request.session['goal']:
            print('win')
            request.session.clear()
            return redirect('/')

    print(
        f"number of steps {request.session['num_step']}, {request.session['balance']}")

    context = {
        'gold_balance': request.session['balance'],
        'options': options,
        'massages': request.session['massages'],
    }
    # 'messages': request.session['massages'],

    # name, min, max, (possible operation)

    return render(request, 'index.html', context)
    # def destroy(request):
    # del request.session['counter']
    # return redirect('/')


def process_money(request):
    # print('process money method')
    # print(request.POST['card_id'])
    operation_id = int(request.POST['card_id'])

    string = f''
    amount = calculateGold(options[operation_id]
                           ['min'], options[operation_id]['max'])

    guessOperation = selectOperation(options[operation_id]['operations'])

    currentTime = datetime.now().strftime('%Y-%m-%d %I:%M %p')
    className = ""
    if guessOperation == 0:
        # operation => Earn
        request.session['balance'] += amount
        string += f"Earned {amount} golds from the {options[operation_id]['name']}! ({currentTime})"
        className = 'win'
    elif guessOperation == 1:
        # operation => Takes
        request.session['balance'] -= amount
        string += f"Entered a {options[operation_id]['name']} and lost {amount} golds... Ouch..({currentTime})"
        className = 'loss'

    print(string)
    request.session['massages'].append((string, className))
    return redirect('/')


def calculateGold(min, max):
    # print(min, max)
    value = round((random.random() * (max-min)) + min)
    return value


def selectOperation(operations):
    random_op = round(random.random() * (len(operations)-1))
    return random_op


'''
(num_step, goal)

=> 5 times, 100

1 => 10
2 => 20
3 => 100
=> SumGoal = 130
----------> Win (Start again)

=> 10 times, 1000

1 => 10
..
..
..
10 => 40
=> SumGoal = 800
------------> Loss (Start again)

'''


win_conditions = []
win_conditions.append({'num_step': 10, 'goal': 500})
#    win_conditions.append({ 'num_step': 10,'goal': 500})


# def conditions(request):
#     # request.session.setdefault('balance', 0)
#     if 'num_step' in request.session:
#         request.session['num_step'] += 1
#         if request.session['num_step'] == 10:
#             print('lose')

#     return redirect('/')
