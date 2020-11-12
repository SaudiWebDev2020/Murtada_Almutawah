from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_book', views.add_book),
    path('<int:book_id>', views.view_book),
    path('<int:book_id>/add_to_favorite', views.add_favorite),
    path('<int:book_id>/un_favorite', views.remove_favorite),
]
