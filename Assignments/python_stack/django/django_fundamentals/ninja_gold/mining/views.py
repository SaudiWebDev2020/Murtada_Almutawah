from django.shortcuts import redirect, render
import random
from datetime import datetime

# If it is DONE change TODO To DONE
# DONE Move the step counter into process_money
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
    # Check if goal set ? 
    request.session.setdefault('set_goal', False)
    request.session.setdefault('reach_goal', False)
    request.session.setdefault('gold_goal', 0)
    request.session.setdefault('times_goal', 0)
    request.session.setdefault('statement_goal', ("",""))
    request.session.setdefault('num_step', 0)
    

    # Set Up Ballance & massages
    request.session.setdefault('balance', 0)
    request.session.setdefault('massages', [])


    context = {
        'gold_balance': request.session['balance'],
        'options': options,
        'massages': request.session['massages'],
        'count': request.session['num_step'],
        'set_goal': request.session['set_goal'],
        'gold_goal': request.session['gold_goal'],
        'times_goal': request.session['times_goal'],
        'statement_goal': request.session['statement_goal'],
    }
    return render(request, 'index.html', context)


def process_money(request):
    # TODO Count the number of clicks
    request.session['num_step'] += 1

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


    if (request.session['reach_goal'] is False):
        if request.session['balance'] >= request.session['gold_goal']:
            print("Goal Achieved")
            request.session['statement_goal'] = (f"You won. Set another goal.","win")
            request.session['reach_goal'] = True
            
        
        if 'num_step' in request.session:
            if request.session['num_step'] >= request.session['times_goal']:
                request.session['statement_goal'] =  (f"You lost. Set another goal.","loss")
                request.session['reach_goal'] = True
            

    # if request.session['balance'] >= request.session['goal']:
    #     if request.session['goal'] == 100:

    
    print(string)
    print(request.session['statement_goal'])
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


def challenge(request):

    request.session.setdefault('statement_goal', ("",""))
    request.session.setdefault('num_step', 0)



    # Set Up for challenge
    request.session['gold_goal'] = int(request.POST['gold_goal_entry'])
    request.session['times_goal'] = int(request.POST['times_goal_entry'])
    request.session['set_goal'] = True
    request.session['reach_goal'] = False
    request.session['statement_goal'] = ("Try to win your goal","")
    
    
    # Reset Counter & balance & massages
    request.session['num_step'] = 0
    request.session['balance'] = 0
    request.session['massages'] = []
    
    
    print(request.POST,request.session['set_goal'])

    return redirect('/')
