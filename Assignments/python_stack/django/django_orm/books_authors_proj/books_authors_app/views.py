from django.http import request
from django.shortcuts import redirect, render
from .models import Book, Author

# Create your views here.


def books(request):
    context = {
        'books': Book.objects.all()}
    return render(request, 'index.html', context)


def add_book(request):
    print(request.POST)
    Book.objects.create(
        title=request.POST['title'], desc=request.POST['description'])
    return redirect('/')


def view_book(request, book_id):
    list_of_book_author = []

    for book_author in Book.objects.get(id=book_id).authors.all():
        list_of_book_author.append(book_author.id)
    print(list_of_book_author)
    context = {
        'book': Book.objects.get(id=book_id),
        'authors': Author.objects.exclude(pk__in=list_of_book_author)
    }
    return render(request, 'book.html', context)


def add_author_to_a_book(request, book_id):
    print(request.POST)
    # Author.objects.all()[2].books.add(Book.objects.all()[0])
    Book.objects.get(id=book_id).authors.add(
        Author.objects.get(id=request.POST['author_id']))
    return redirect(f'/books/{book_id}')


def getAuthors(request):
    context = {
        'authors': Author.objects.all()
    }
    return render(request, 'authors.html', context)


def add_author(request):
    print(request.POST)
    Author.objects.create(
        first_name=request.POST['first_name'], last_name=request.POST['last_name'], notes=request.POST['notes'])
    return redirect('/authors')


def view_author(request, author_id):
    list_of_book_author = []

    for book_author in Author.objects.get(id=author_id).books.all():
        list_of_book_author.append(book_author.id)

    context = {
        'author': Author.objects.get(id=author_id),
        'books': Book.objects.exclude(pk__in=list_of_book_author),
    }
    return render(request, 'author.html', context)


def add_a_book_to_an_author(request, author_id):
    print(request.POST)
    # Author.objects.all()[2].books.add(Book.objects.all()[0])
    Author.objects.get(id=author_id).books.add(
        Book.objects.get(id=request.POST['book_id']))
    return redirect(f'/authors/{author_id}')
