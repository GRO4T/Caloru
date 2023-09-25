from datetime import datetime, timedelta
from typing import Dict, List

from django.http import HttpResponse
from django.template import loader

from .models import ConsumedProduct, Product


def get_consumed_products() -> List[Dict]:
    """Retrieves a list of consumed products from database."""
    consumed_products = ConsumedProduct.objects.all().order_by("date")

    def mapper(c: ConsumedProduct):
        new_c = {}
        new_c["date"] = c.date
        new_c["amount_in_grams"] = c.amount_in_grams
        new_c["name"] = c.product.name
        new_c["energy"] = c.product.energy * c.amount_in_grams / 100.0
        new_c["protein"] = c.product.protein * c.amount_in_grams / 100.0
        new_c["carbs"] = c.product.carbs * c.amount_in_grams / 100.0
        new_c["fat"] = c.product.fat * c.amount_in_grams / 100.0
        return new_c

    consumed_products = map(mapper, consumed_products)

    return consumed_products


def generate_chart_data() -> (List[datetime], List[float]):
    """Generates data for dashboard view chart.

    Returns:
        (dates, total_calories): (list, list)
            List of dates (x axis) and corresponding total caloric intakes (y axis).
    """
    dates = []
    total_calories = []

    now = datetime.now() - timedelta(days=6)

    for i in range(7):
        total_energy = 0
        date = now + timedelta(days=i)

        consumed = ConsumedProduct.objects.filter(date=date)

        for c in consumed:
            total_energy += c.product.energy * c.amount_in_grams / 100.0

        dates.append(date.strftime("%d/%m/%Y"))
        total_calories.append(total_energy)

    return (dates, total_calories)


def dashboard(request):
    """Renders dashboard view.

    View consists of a chart with total caloric intake per day and a table
    with a list of consumed products.
    """
    consumed_products = get_consumed_products()
    dates, total_calories = generate_chart_data()
    template = loader.get_template("dashboard.html")
    context = {
        "consumed_products": consumed_products,
        "dates": dates,
        "total_calories": total_calories,
    }
    return HttpResponse(template.render(context, request))


def products(request):
    """Renders products view.

    View displays nutrient value of various food products.
    """
    product_list = Product.objects.all()
    template = loader.get_template("products.html")
    context = {"product_list": product_list}
    return HttpResponse(template.render(context, request))
