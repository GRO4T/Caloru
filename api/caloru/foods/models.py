from django.conf import settings
from django.core.validators import BaseValidator
from django.db import models


class _MinValueValidator(BaseValidator):
    message = "Ensure this value is greater than or equal to %(limit_value)s."
    code = "min_value"

    def compare(self, a, b):
        return a < b


class FoodItem(models.Model):
    name = models.CharField(max_length=255)
    portion_weight = models.PositiveIntegerField()
    portion_name = models.CharField(max_length=255)
    energy = models.FloatField(validators=[_MinValueValidator(0)])
    protein = models.FloatField(validators=[_MinValueValidator(0)])
    carbs = models.FloatField(validators=[_MinValueValidator(0)])
    fat = models.FloatField(validators=[_MinValueValidator(0)])


class TrackedFoodItem(models.Model):
    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    item = models.ForeignKey(FoodItem, on_delete=models.PROTECT)
    date = models.DateField()
    meal = models.CharField(max_length=255)
    amount = models.PositiveIntegerField()
