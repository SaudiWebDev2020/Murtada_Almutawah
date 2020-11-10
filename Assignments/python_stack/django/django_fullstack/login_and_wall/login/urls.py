from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('login', views.login),
    path('register', views.register),
    path('registration', views.registration),
    path('success', views.success),
    path('logout', views.logout),
]
