from django import forms

from .models import ConsumedProduct


class ConsumedProductForm(forms.ModelForm):
    class Meta:
        model = ConsumedProduct
        fields = ["user", "product", "date", "amount"]
