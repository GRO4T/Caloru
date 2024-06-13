from django.urls import path

from . import views

urlpatterns = [
    path("", views.tracker, name="root"),
    path("tracker/", views.tracker, name="tracker"),
    path("history/", views.history, name="history"),
]
