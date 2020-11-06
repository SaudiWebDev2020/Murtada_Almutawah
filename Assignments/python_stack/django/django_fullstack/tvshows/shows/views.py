from django.shortcuts import redirect, render
from .models import Show
# Create your views here.


def add_show(request):
    # DONE
    # print('New Show =)')
    return render(request, 'new_show.html', context={})


def create_show(request):
    # DONE
    # print(request.POST)
    Show.objects.create(title=request.POST['title'], network=request.POST['network'],
                        release_date=request.POST['release_date'], description=request.POST['description'])
    return redirect(view_show, Show.objects.last().id)


def view_show(request, show_id):
    # DONE
    context = {
        'show': Show.objects.get(id=show_id)
    }
    return render(request, 'view_show.html', context)


def shows_list(request):
    # DONE
    context = {
        'shows': Show.objects.all()
    }
    return render(request, 'shows_list.html', context)


def edit_show(request, show_id):
    # DONE
    context = {
        'show': Show.objects.get(id=show_id)
    }
    return render(request, 'edit_show.html', context)


def update_show(request, show_id):
    # DONE

    show_to_edit = Show.objects.get(id=show_id)
    show_to_edit.title = request.POST['title']
    show_to_edit.network = request.POST['network']
    show_to_edit.release_date = request.POST['release_date']
    show_to_edit.description = request.POST['description']

    show_to_edit.save()
    return redirect(view_show, show_id)


def delete_show(request, show_id):
    # DONE
    Show.objects.get(id=show_id).delete()
    return redirect(shows_list)
