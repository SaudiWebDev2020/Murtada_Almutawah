from django.urls import path
from . import views

urlpatterns = [
    path('new', views.add_show, name='new_show'),
    path('create', views.create_show, name='create_show'),
    path('<int:show_id>', views.view_show, name='view_show'),
    path('', views.shows_list, name='shows_list'),
    path('<int:show_id>/edit', views.edit_show, name='edit_show'),
    path('<int:show_id>/update', views.update_show, name='update_show'),
    path('<int:show_id>/destroy', views.delete_show, name='delete_show'),
]
