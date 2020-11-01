from django.shortcuts import render, redirect, HttpResponse
from django.http.response import JsonResponse


# Create your views here.


def root(request):
    return redirect("./blogs")


def index(request):
    return HttpResponse("placeholder to later display a list of all blogs")


def new(request):
    return HttpResponse("placeholder to display a new form to create a new blog")


def create(request):
    return redirect("/blogs")


def show(request, number):
    return HttpResponse(f"placeholder to display blog number: {number}")


def edit(request, number):
    return HttpResponse(f"placeholder to display blog number: {number} with a method named edit")


def destroy(request, number):
    return redirect("/blogs")


def jsonresponse(request):
    json = {
        "title": "My first blog",
        'content': "Lorem, ipsum dolor sit amet consectetur adipisicing elit."
    }
    return JsonResponse(json)
