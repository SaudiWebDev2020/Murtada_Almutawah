import bcrypt
from django.http import request

from django.shortcuts import redirect, render
from django.contrib import messages

from .models import User

# Create your views here.


def index(request):
    request.session.setdefault('userid', False)
    request.session.setdefault('name', '')

    if (request.session['userid']):
        return redirect('/wall')

    return render(request, 'login.html', context={})


def registration(request):
    if (request.session['userid']):
        return render(request, 'index.html', context={})

    return render(request, 'registration.html', context={})


def login(request):
    if request.method == 'POST':
        errors = User.objects.login_validation(request.POST)
        if len(errors) < 1:
            logged_user = User.objects.filter(
                email=request.POST['email'].lower()).first()
            if bcrypt.checkpw(request.POST['password'].encode(), logged_user.password.encode()):
                # if we get True after checking the password, we may put the user id in session
                request.session['userid'] = logged_user.id
                request.session['name'] = f'{logged_user.first_name} {logged_user.last_name}'
                messages.success(request, 'Successfully logged in!')
                # never render on a post, always redirect!
                return redirect('/success')
            else:
                messages.error(request, 'Email or Password are not match')
        else:
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)
    return redirect('/')


def register(request):
    if request.method == 'POST':
        print(request.POST)
        errors = User.objects.register_validation(request.POST)
        if len(errors) < 1:
            password = request.POST['password']
            pw_hash = bcrypt.hashpw(
                password.encode(), bcrypt.gensalt()).decode()  # create the hash
            # print(pw_hash)
            new_user = User.objects.create(first_name=request.POST['first_name'],
                                           last_name=request.POST['last_name'],
                                           email=request.POST['email'].lower(),
                                           birthday=request.POST['birthday'],
                                           password=pw_hash)

            request.session['userid'] = new_user.id
            request.session['name'] = f'{new_user.first_name} {new_user.last_name}'
            messages.success(request, 'Successfully registered!')

            print(new_user)
            return redirect('/success')
            # return redirect(view_show, Show.objects.last().id)
        else:
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)
    return redirect('/registration')


def success(request):
    return redirect('/')


def logout(request):
    request.session.clear()
    return redirect('/')
