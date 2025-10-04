from django.urls import path

from . import views

urlpatterns = [
    path("food-items", views.FoodItemList.as_view()),
    path("food-items/<int:pk>/", views.FoodItemDetail.as_view()),
    path("tracked-food-items", views.TrackedFoodItemList.as_view()),
    path("tracked-food-items/<int:pk>/", views.TrackedFoodItemDetail.as_view()),
]
