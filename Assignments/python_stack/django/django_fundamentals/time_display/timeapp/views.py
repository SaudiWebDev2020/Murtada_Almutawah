from time import time
from django.shortcuts import redirect, render
from datetime import datetime
# Create your views here.


def root(request):
    return redirect('time_display/')


def time_display(request):
    context = {
        "date": datetime.now().strftime("%B %d %Y"),
        "time": datetime.now().strftime("%I:%M:%S %p")
    }
    # print(gmtime())
    return render(request, 'index.html', context)
