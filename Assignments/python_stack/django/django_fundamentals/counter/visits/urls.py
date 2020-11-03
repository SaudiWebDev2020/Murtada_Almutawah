from django.urls import path
from . import views

urlpatterns = [
    path('', views.index),
    path('add_two', views.add_two),
    path('destroy_session', views.destroy_session),
    path('manual_adding', views.add_manully),

]
