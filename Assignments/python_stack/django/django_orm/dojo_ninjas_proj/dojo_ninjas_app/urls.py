from django.urls import path
from . import views

urlpatterns = [
    path('', views.index, name='index_page'),
    path('add_dojo', views.add_dojo),
    path('add_ninja', views.add_ninja),
    path('delete_ninja/<int:ninja_id>', views.delete_ninja),
]
