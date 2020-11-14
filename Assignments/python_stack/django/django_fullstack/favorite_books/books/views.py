from django.contrib import messages
from django.shortcuts import redirect, render
from .models import Book
from login.models import User

# Create your views here.


def get_myFavList(user_id):
    favorite_booksList = []
    user = User.objects.get(id=user_id)
    for book in user.favorite_books.all():
        favorite_booksList.append(book.id)
    return favorite_booksList

def index(request):
    
    context = {
        'books': Book.objects.all(),
        'my_favorites': get_myFavList(request.session['userid']),
    }
    return render(request, 'index.html', context)


def add_book(request):
    if request.method == 'POST':
        errors = Book.objects.create_validation(request.POST)
        if len(errors) < 1:
            print(request.POST)
            new_book = Book.objects.create(title=request.POST['title'], description=request.POST['description'], uploaded_by=User.objects.get(id=request.POST['userid']))
            new_book.favorite_by.add(
                User.objects.get(id=request.POST['userid']))
        else:
            request.session['message_flag'] = 'add_book'
            print(errors)
            for key, value in errors.items():
                messages.error(request, value)

    return redirect('/books')

def view_book(request,book_id):
    context = {
        'book': Book.objects.get(id=book_id),
        'my_favorites': get_myFavList(request.session['userid']),
    }
    return render(request,'view_book.html',context)

def add_favorite(request,book_id):
    if request.method == 'POST':
        print(request)
        book_var = Book.objects.get(id=book_id)
        User.objects.get(id=request.session['userid']).favorite_books.add(book_var)
        
    return redirect(f'/books/{book_id}')
        

def remove_favorite(request,book_id):
    if request.method == 'POST':
        book_var = Book.objects.get(id=book_id)
        User.objects.get(id=request.session['userid']).favorite_books.remove(book_var)
    return redirect(f'/books/{book_id}')