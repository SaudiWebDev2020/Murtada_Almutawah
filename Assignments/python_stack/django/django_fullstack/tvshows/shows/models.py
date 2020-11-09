from django.db import models
import re
from datetime import datetime

# Create your models here.


class ShowManager(models.Manager):
    def validate(self, postData):
        errors = {}
        print(postData)
        # Parsing data
        entered_date = datetime.strptime(postData['release_date'], '%Y-%m-%d')

        # Title get
        try:
            show_temp = Show.objects.get(title=postData['title'])
        except Show.DoesNotExist:
            show_temp = None

        if show_temp != None and show_temp.id != postData['id']:
            errors['uniqueTitle'] = "Title must be unique"

        if len(postData['title']) < 2:
            errors['title'] = "Title should be at least 2 characters"
        if len(postData['network']) < 3:
            errors['network'] = "Network should be at least 3 characters"
        if 0 < len(postData['description']) < 10:
            errors['description'] = "Description should be at least 10 characters if it was presented"
        if datetime.now() <= entered_date:
            errors['release_date'] = "Release Date must be in the past"

        # print(datetime.now().date())
        # print(postData['release_date'])
        # print(datetime.now() < entered_date)
        # print(datetime(postData['release_date']))

        # print(postData)
        return errors


class Show(models.Model):
    title = models.CharField(max_length=60)
    network = models.CharField(max_length=30)
    release_date = models.DateField()
    description = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = ShowManager()
