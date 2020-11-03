from os import name
from django.db import models

# Create your models here.


class Dojo(models.Model):
    name = models.CharField(max_length=255)
    city = models.CharField(max_length=255)
    state = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)
    desc = models.TextField()

    def __repr__(self):
        return f"<Dojo Object({self.id}): name={self.name}, city={self.city}, state={self.state}, Desc={self.desc}>"


class Ninja(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    dojo = models.ForeignKey(
        Dojo, related_name='Ninjas', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    def __repr__(self):
        return f"<Ninja Object: first_name={self.first_name}, last_name={self.last_name}>"
