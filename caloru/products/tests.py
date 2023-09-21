from django.test import TestCase

from products.models import Product


class LocalDatabaseTestCase(TestCase):
    def test_local_database_is_working(self):
        Product.objects.create(
            name="Milk",
            name_2="Whole (3.25% fat)",
            water=88.32,
            energy=59.84,
            protein=3.22,
            carbs=4.52,
            fat=3.25,
            vitamin_a=27.87,
            vitamin_b1=0.044,
            vitamin_b2=0.183,
            vitamin_b3=0.107,
            vitamin_b5=0,
            vitamin_b6=0,
            vitamin_b12=0,
            vitamin_c=0,
            vitamin_d=0,
            vitamin_e=0,
            vitamin_k=0,
            calcium=0,
            copper=0,
            iron=0,
            magnesium=0,
            manganese=0,
            phosphorus=0,
            potassium=0,
            selenium=0,
            sodium=0,
            zinc=0,
            cholesterol=0,
        )
        self.assertTrue(Product.objects.filter(name="Milk").exists())
        Product.objects.filter(name="Milk").delete()
        self.assertFalse(Product.objects.filter(name="Milk").exists())
