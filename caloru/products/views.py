from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader

from .models import Product

# Create your views here.


def products(request):
    product_list = Product.objects.all()
    template = loader.get_template("products.html")
    context = {"product_list": product_list}
    return HttpResponse(template.render(context, request))
