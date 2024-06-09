from rest_framework import serializers

from .models import ConsumedProduct


class ConsumedProductSerializer(serializers.ModelSerializer):
    name = serializers.CharField(source="product.full_name")
    producer = serializers.CharField(source="product.producer")

    class Meta:
        model = ConsumedProduct
        fields = ("id", "user", "product", "date", "amount", "name", "producer")
