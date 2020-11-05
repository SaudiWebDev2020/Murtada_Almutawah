from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('guess', views.guess),
    path('new_game', views.new),
    path('submit_name', views.save_record),
    path('leaderboard', views.view_leaderboard)
]
