from datetime import datetime, timedelta

from django.shortcuts import render

from .forms import ConsumedProductForm
from .models import ConsumedProduct
from .serializers import ConsumedProductSerializer


def history(request):
    consumed_products = ConsumedProduct.objects.all().order_by("date")
    consumed_products = map(_calculate_total_macros, consumed_products)

    days = 7
    caloric_intake = _get_caloric_intake(days)
    dates = []
    for i in range(len(caloric_intake)):
        date = datetime.now() - timedelta(days=days - 1) + timedelta(days=i)
        dates.append(date.strftime("%d/%m/%Y"))

    context = {
        "consumed_products": consumed_products,
        "dates": dates,
        "total_calories": caloric_intake,
    }
    return render(request, "history.html", context)


def tracker(request):
    if request.method == "POST":
        form = ConsumedProductForm(request.POST)
        if form.is_valid():
            form.save()

    consumed_today = ConsumedProduct.objects.filter(date=datetime.now())
    consumed_today = [_calculate_total_macros(c) for c in consumed_today]

    energy = int(sum((c["energy"] for c in consumed_today)))
    protein = int(sum((c["protein"] for c in consumed_today)))
    carbs = int(sum((c["carbs"] for c in consumed_today)))
    fats = int(sum((c["fat"] for c in consumed_today)))

    context = {
        "consumed_today": consumed_today,
        "energy": {"consumed": energy, "target": 2500},
        "protein": {"consumed": protein, "target": 100},
        "carbs": {"consumed": carbs, "target": 300},
        "fats": {"consumed": fats, "target": 70},
        "form": ConsumedProductForm(),
    }
    return render(request, "tracker.html", context)


def _calculate_total_macros(c: ConsumedProduct) -> dict:
    c_as_dict = ConsumedProductSerializer(c).data
    c_as_dict["energy"] = c.product.energy * c.amount / 100.0
    c_as_dict["protein"] = c.product.protein * c.amount / 100.0
    c_as_dict["carbs"] = c.product.carbs * c.amount / 100.0
    c_as_dict["fat"] = c.product.fat * c.amount / 100.0
    return c_as_dict


def _get_caloric_intake(days: int) -> list[float]:
    caloric_intake = []

    now = datetime.now() - timedelta(days=days - 1)

    for i in range(days):
        consumed = ConsumedProduct.objects.filter(date=now + timedelta(days=i))
        daily_total = sum((c.product.energy * c.amount / 100.0 for c in consumed))
        caloric_intake.append(daily_total)

    return caloric_intake
