from django.db import models

# Create your models here.


class Product(models.Model):
    name = models.CharField(max_length=255)
    weight = models.IntegerField()
    calories = models.FloatField()
    protein = models.FloatField()
    carbs = models.FloatField()
    fat = models.FloatField()


class User(models.Model):
    username = models.CharField(max_length=255)


class ConsumedProduct(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    date = models.DateField()
    quantity = models.IntegerField()
