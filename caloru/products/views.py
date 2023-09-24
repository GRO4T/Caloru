from datetime import datetime, timedelta

from django.db.models import Sum
from django.http import HttpResponse
from django.template import loader

from .models import ConsumedProduct, Product


def generate_chart_data() -> (list, list):
    """Generates data for dashboard view chart.

    Returns:
        (dates, total_calories): (list, list)
            List of dates (x axis) and corresponding total caloric intakes (y axis).
    """
    dates = []
    total_calories = []

    now = datetime.now() - timedelta(days=6)

    for i in range(7):
        date = now + timedelta(days=i)

        total_energy = ConsumedProduct.objects.filter(date=date).aggregate(
            total_energy=Sum("product__energy")
        )["total_energy"]

        if not total_energy:
            total_energy = 0

        dates.append(date.strftime("%d/%m/%Y"))
        total_calories.append(total_energy)

    return (dates, total_calories)


def dashboard(request):
    """Renders dashboard view.

    View consists of a chart with total caloric intake per day and a table
    with a list of consumed products.
    """
    consumed_list = ConsumedProduct.objects.all().order_by("date")
    dates, total_calories = generate_chart_data()
    template = loader.get_template("dashboard.html")
    context = {
        "consumed_list": consumed_list,
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
