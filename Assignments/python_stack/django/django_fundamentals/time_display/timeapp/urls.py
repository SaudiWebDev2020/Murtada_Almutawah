from django.urls import path
from . import views

urlpatterns = [
    # path('admin/', admin.site.urls),
    path('', views.root),
    path('time_display/', views.time_display),
]
