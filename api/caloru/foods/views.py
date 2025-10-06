from django_filters.rest_framework import DjangoFilterBackend
from rest_framework import filters, generics

from .models import FoodItem, TrackedFoodItem
from .serializers import FoodItemSerializer, TrackedFoodItemSerializer


class FoodItemList(generics.ListCreateAPIView):
    queryset = FoodItem.objects.all()
    serializer_class = FoodItemSerializer
    filter_backends = [filters.SearchFilter, filters.OrderingFilter]
    search_fields = ["name"]
    ordering_fields = ["name"]


class FoodItemDetail(generics.RetrieveUpdateDestroyAPIView):
    queryset = FoodItem.objects.all()
    serializer_class = FoodItemSerializer


class TrackedFoodItemList(generics.ListCreateAPIView):
    serializer_class = TrackedFoodItemSerializer
    filter_backends = [DjangoFilterBackend]
    filterset_fields = ["user", "date"]

    def perform_create(self, serializer):
        serializer.save(user=self.request.user)

    def get_queryset(self):
        return TrackedFoodItem.objects.filter(user=self.request.user)


class TrackedFoodItemDetail(generics.RetrieveUpdateDestroyAPIView):
    serializer_class = TrackedFoodItemSerializer

    def get_queryset(self):
        return TrackedFoodItem.objects.filter(user=self.request.user)
