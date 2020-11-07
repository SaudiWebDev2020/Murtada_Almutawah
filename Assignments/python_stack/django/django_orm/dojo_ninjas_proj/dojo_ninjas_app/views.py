from django.http import request
from django.shortcuts import redirect, render
from .models import Dojo, Ninja

# Create your views here.


def index(request):
    context = {
        'dojos': Dojo.objects.all()
    }
    return render(request, 'index.html', context)


def add_dojo(request):
    Dojo.objects.create(
        name=request.POST['name'], city=request.POST['city'], state=request.POST['state'])
    return redirect('index_page')


def add_ninja(request):
    # print(request.POST)
    Ninja.objects.create(first_name=request.POST['first_name'], last_name=request.POST['last_name'], dojo=Dojo.objects.get(
        id=request.POST['dojo_id']))
    return redirect('index_page')


def delete_ninja(request, ninja_id):
    # print(ninja_id)
    Ninja.objects.get(id=ninja_id).delete()
    return redirect('index_page')
