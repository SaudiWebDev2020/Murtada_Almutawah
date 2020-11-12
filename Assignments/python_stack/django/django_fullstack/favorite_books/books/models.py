from django.db import models

from login.models import User

# Create your models here.


class BookManager(models.Manager):
    def create_validation(self, postData):
        print(postData)
        errors = {}

        if len(postData['title']) < 1:
            errors['title_required'] = 'Title is required'

        if len(postData['description']) < 5:
            errors['description_length'] = 'Description must be at least 5 characters'

        return errors


class Book(models.Model):
    title = models.CharField(max_length=255)
    description = models.TextField()
    uploaded_by = models.ForeignKey(
        User, related_name='books_uploaded', on_delete=models.CASCADE)
    favorite_by = models.ManyToManyField(
        User, related_name='favorite_books')
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = BookManager()
