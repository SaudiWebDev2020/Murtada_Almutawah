from django.http import request
from django.shortcuts import redirect, render
from .models import Order, Product

def index(request):
    request.session.setdefault('total_quantities',0)
    request.session.setdefault('total_amount',0)
    context = {
        "all_products": Product.objects.all(),
    }
    return render(request, "store/index.html", context)

def checkout(request):
    # quantity_from_form = int(request.POST["quantity"])
    # price_from_form = float(request.POST["price"])
    # # request.session['total_quantities'] += quantity_from_form
    # # request.session['total_amount'] += price_from_form
    # total_charge = quantity_from_form * price_from_form
    print("Charging credit card...")
    # Order.objects.create(quantity_ordered=quantity_from_form, total_price=total_charge)
    context={
        'total_charge': Order.objects.last().total_price
    }
    
    return render(request, "store/checkout.html",context)

def buy(request):
    if request.method == 'POST':
        print(request.POST)
        quantity_from_form = int(request.POST["quantity"])
        # price_from_form = float(request.POST["price"])
        products = Product.objects.filter(id=request.POST["id"])
        if len(products) == 1: 
            print(products.first())
            price_from_form =  float(products.first().price)
            total_charge = quantity_from_form * price_from_form
            request.session['total_quantities'] += quantity_from_form
            request.session['total_amount'] +=  price_from_form
            print(total_charge)
            Order.objects.create(quantity_ordered=quantity_from_form, total_price=total_charge)

    return redirect('/checkout')