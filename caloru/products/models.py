from django.conf import settings
from django.core.validators import MaxValueValidator, MinValueValidator
from django.db import models


class Product(models.Model):
    """
    Product from the catalog.

    Attributes
    ----------
    name : str
        Product name, e.g. "Milk".
    full_name : str
        Full product name, e.g. "Milk Whole (3.25% fat)".
    producer : str
        Producer name, e.g. "Milk Factory".
    package_weight : float
        Product weight in grams, e.g. 1000.
    energy : float
        Energy value in kcal per 100g, e.g. 42.0.
    protein : float
        Protein value in grams per 100g, e.g. 3.3.
    carbs : float
        Carbohydrates value in grams per 100g, e.g. 4.8.
    fat : float
        Fat value in grams per 100g, e.g. 3.25.
    """

    name = models.CharField(max_length=255)
    full_name = models.CharField(max_length=255)
    producer = models.CharField(max_length=255)
    package_weight = models.FloatField()
    energy = models.FloatField()
    protein = models.FloatField()
    carbs = models.FloatField()
    fat = models.FloatField()


class ConsumedProduct(models.Model):
    """
    Consumed product added to the tracker.

    Attributes
    ----------
    user : User
        User who consumed the product.
    product : Product
        Product consumed.
    date : datetime.datetime
        Date of consumption.
    amount : int
        Amount of product consumed in grams, e.g. 250.
    """

    user = models.ForeignKey(settings.AUTH_USER_MODEL, on_delete=models.CASCADE)
    product = models.ForeignKey(Product, on_delete=models.CASCADE)
    date = models.DateField()
    amount = models.PositiveSmallIntegerField(
        validators=[MinValueValidator(1), MaxValueValidator(5000)]
    )
