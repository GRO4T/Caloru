from django.urls import path

from . import views

urlpatterns = [
    path("", views.products, name="products"),
    path("edit/", views.edit_product_form, name="edit_product"),
    path("add/", views.add_product_form, name="add_product"),
]
