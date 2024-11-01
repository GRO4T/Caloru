from django.urls import path

from . import views

urlpatterns = [
    path("tracker/", views.tracker, name="tracker"),
    path("history/", views.history, name="history"),
]
