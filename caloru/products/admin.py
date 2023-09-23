from django.contrib import admin

from .models import ConsumedProduct, Product

# Register your models here.
admin.site.register(Product)
admin.site.register(ConsumedProduct)
