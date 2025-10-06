from rest_framework import serializers

from .models import FoodItem, TrackedFoodItem


class FoodItemSerializer(serializers.ModelSerializer):
    class Meta:
        model = FoodItem
        fields = "__all__"


class TrackedFoodItemSerializer(serializers.ModelSerializer):
    meal = serializers.ChoiceField(
        choices=[
            "Breakfast",
            "Snack I",
            "Lunch",
            "Snack II",
            "Dinner",
            "Snack III",
        ]
    )
    item_id = serializers.IntegerField()
    item = FoodItemSerializer(read_only=True)

    class Meta:
        model = TrackedFoodItem
        fields = ["id", "user", "item_id", "item", "meal", "amount"]
        read_only_fields = ["user"]
