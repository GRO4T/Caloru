from django.urls import path

from . import views

urlpatterns = [
    path("", views.dashboard, name="root"),
    path("products/", views.products, name="products"),
    path("dashboard/", views.dashboard, name="dashboard"),
]
