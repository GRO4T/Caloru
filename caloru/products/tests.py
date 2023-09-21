from django.test import TestCase

from products.models import Product


class LocalDatabaseTestCase(TestCase):
    def test_local_database_is_working(self):
        Product.objects.create(name="Milk", calories=200, protein=30, carbs=10, fat=10)
        self.assertTrue(Product.objects.filter(name="Milk").exists())
        Product.objects.filter(name="Milk").delete()
        self.assertFalse(Product.objects.filter(name="Milk").exists())
