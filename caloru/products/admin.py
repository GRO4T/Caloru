from django.contrib import admin

from .models import ConsumedProduct, Product, User

# Register your models here.
admin.site.register(Product)
admin.site.register(User)
admin.site.register(ConsumedProduct)
