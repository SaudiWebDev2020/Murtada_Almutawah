from django.shortcuts import redirect, render
from django.contrib import messages

from .models import Message, Comment
from login.models import User

# Create your views here.


def index(request):
    request.session.setdefault('userid', False)
    request.session.setdefault('name', '')

    if (request.session['userid']):
        context = {
            'wall_messages': Message.objects.all().order_by('-created_at')
        }

        return render(request, 'index.html', context)

    return redirect('/')


def post_message(request):
    if request.method == 'POST':
        errors = Message.objects.post_validation(request.POST)
        if len(errors) < 1:
            print(request.POST)
            created_message = Message.objects.create(user=User.objects.get(
                id=request.session['userid']), message=request.POST['message'])
        else:
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)
    return redirect('wall_page')


def post_comment(request):
    if request.method == 'POST':
        errors = Comment.objects.post_validation(request.POST)
        if len(errors) < 1:
            print(request.POST)
            Comment.objects.create(comment=request.POST['comment'], message=Message.objects.get(
                id=request.POST['message_id']), user=User.objects.get(id=request.session['userid']))
        else:
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)

    return redirect('wall_page')


def delete_message(request):
    if request.method == 'POST':
        print(request.POST)
        errors = Message.objects.delete_validation(request.POST)
        if len(errors) < 1:
            message = Message.objects.get(id=request.POST['message_id'])
            message.delete()
            # return redirect(view_show, Show.objects.last().id)
        else:
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)

    return redirect('wall_page')
