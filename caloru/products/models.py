from django.conf import settings
from django.db import models


class Product(models.Model):
    """Product from the catalog."""

    name = models.CharField(max_length=255)  # e.g. "Milk"
    full_name = models.CharField(max_length=255)  # e.g. "Milk Whole (3.25% fat)"
    producer = models.CharField(max_length=255)
    package_weight = models.FloatField()  # in grams
    energy = models.FloatField()  # in kcal per 100g
    protein = models.FloatField()  # in grams per 100g
    carbs = models.FloatField()  # in grams per 100g
    fat = models.FloatField()  # in grams per 100g


class ConsumedProduct(models.Model):
    """Consumed product added to the tracker."""

    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    date = models.DateField()
    amount = models.IntegerField()  # in grams
