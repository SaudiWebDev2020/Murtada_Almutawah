from django.shortcuts import redirect, render
from .models import Users
# Create your views here.


def index(request):
    context = {
        'Users': Users.objects.all()
    }
    return render(request, 'index.html', context)


def create_user(request):
    # users_list = Users.objects.all()
    # print(users_list)
    Users.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'],
                         email=request.POST['email'], age=int(request.POST['age']))
    return redirect('/')
