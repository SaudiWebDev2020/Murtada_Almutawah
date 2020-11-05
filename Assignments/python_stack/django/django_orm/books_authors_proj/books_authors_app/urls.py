from django.urls import path
from . import views

urlpatterns = [
    path('', views.books),
    path('add_book', views.add_book),
    path('books/<int:book_id>', views.view_book),
    path('books/<int:book_id>/add_author', views.add_author_to_a_book),
    path('authors', views.getAuthors),
    path('add_author', views.add_author),
    path('authors/<int:author_id>', views.view_author),
    path('authors/<int:author_id>/add_book', views.add_a_book_to_an_author)
]
