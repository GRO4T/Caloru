from django.conf import settings
from django.db import models


class User(models.Model):
    """User profile."""

    username = models.CharField(max_length=255)


class Product(models.Model):
    """Product from the catalog.

    NOTE: All nutrient contents are expressed per 100g.
    """

    name = models.CharField(max_length=255)
    name_2 = models.CharField(max_length=255)

    water = models.FloatField()
    energy = models.FloatField()
    protein = models.FloatField()
    carbs = models.FloatField()
    fat = models.FloatField()

    vitamin_a = models.FloatField()
    vitamin_b1 = models.FloatField()
    vitamin_b2 = models.FloatField()
    vitamin_b3 = models.FloatField()
    vitamin_b5 = models.FloatField()
    vitamin_b6 = models.FloatField()
    vitamin_b12 = models.FloatField()
    vitamin_c = models.FloatField()
    vitamin_d = models.FloatField()
    vitamin_e = models.FloatField()
    vitamin_k = models.FloatField()

    calcium = models.FloatField()
    copper = models.FloatField()
    iron = models.FloatField()
    magnesium = models.FloatField()
    manganese = models.FloatField()
    phosphorus = models.FloatField()
    potassium = models.FloatField()
    selenium = models.FloatField()
    sodium = models.FloatField()
    zinc = models.FloatField()

    cholesterol = models.FloatField()


class ConsumedProduct(models.Model):
    """Consumed product added to tracker."""

    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    date = models.DateField()
    amount_in_grams = models.IntegerField()
