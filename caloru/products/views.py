from django.http import HttpResponse
from django.template import loader

from .models import Product, ConsumedProduct

# Create your views here.


def dashboard(request):
    consumed_list = ConsumedProduct.objects.all()
    template = loader.get_template("dashboard.html")
    context = {"consumed_list": consumed_list}
    return HttpResponse(template.render(context, request))


def products(request):
    product_list = Product.objects.all()
    template = loader.get_template("products.html")
    context = {"product_list": product_list}
    return HttpResponse(template.render(context, request))
