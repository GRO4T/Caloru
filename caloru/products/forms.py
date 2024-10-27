from django import forms
from django.contrib.auth.forms import UserCreationForm
from django.contrib.auth.models import User

from .models import ConsumedProduct


class ConsumedProductForm(forms.ModelForm):
    class Meta:
        model = ConsumedProduct
        fields = ["user", "product", "date", "amount"]


# pylint: disable=R0901
class RegisterForm(UserCreationForm):
    email = forms.EmailField()

    class Meta:
        model = User
        fields = ["username", "email", "password1", "password2"]
