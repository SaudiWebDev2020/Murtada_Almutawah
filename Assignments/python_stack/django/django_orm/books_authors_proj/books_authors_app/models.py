from django.db import models

# Create your models here.


class Author(models.Model):
    first_name = models.CharField(max_length=45)
    last_name = models.CharField(max_length=45)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    notes = models.TextField()
    
    def __repr__(self):
        return f"<Author: Author object ({self.id}): Name={self.first_name} {self.last_name} >"


class Book(models.Model):
    title = models.CharField(max_length=255)
    desc = models.TextField()
    authors = models.ManyToManyField(Author ,related_name="books")
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
        
