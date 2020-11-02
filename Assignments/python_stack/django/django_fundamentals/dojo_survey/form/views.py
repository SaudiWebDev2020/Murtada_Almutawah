from django.http import request
from django.shortcuts import redirect, render

# Create your views here.


def index(request):
    return render(request, 'index.html')


def process_form(request):
    print(request.method)
    if request.POST:
        print(request.POST)
    context = {
        'your_name': request.POST['your_name'],
        'dojo_location': request.POST['dojo_location'],
        'favorite_language': request.POST['favorite_language'],
        'comment': request.POST['comment'],
    }

    return render(request, 'result.html', context)
