from django import forms

from .models import ConsumedProduct


class ConsumedProductForm(forms.ModelForm):
    class Meta:
        model = ConsumedProduct
        fields = ["user", "product", "date", "amount"]

    def clean(self):
        super().clean()

        amount = self.cleaned_data.get("amount")

        if amount <= 0:
            self._errors["amount"] = self.error_class(
                ["Amount must be greater than 0."]
            )

        return self.cleaned_data
