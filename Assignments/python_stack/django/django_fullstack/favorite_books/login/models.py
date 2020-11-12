from django.db import models
# from datetime import datetime
import re

# Create your models here.
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


class UserManager(models.Manager):
    def validate(self, postData):
        errors = {}
        print(postData)
        return errors

    def login_validation(self, postData):
        errors = {}
        # print(postData)
        # errors['login'] = 'Error'

        # test whether a field matches the pattern
        if not EMAIL_REGEX.match(postData['email']):
            errors['email_format'] = "Invalid email address!"

        # Try if it is regestered or not =).
        try:
            user_temp = User.objects.get(email=postData['email'].lower())
        except User.DoesNotExist:
            user_temp = None

        if user_temp == None:
            errors['email_not_found'] = "The email is not regestered"

        return errors

    def register_validation(self, postData):
        errors = {}
        print(postData)

        # Birth Date

        # First name
        if len(postData['first_name']) < 2:
            errors['first_name'] = "First name should be at least 2 characters"

        # Last name
        if len(postData['last_name']) < 2:
            errors['last_name'] = "Last name should be at least 2 characters"

        # Email

        # test whether a field matches the pattern
        if not EMAIL_REGEX.match(postData['email']):
            errors['email_format'] = "Invalid email address!"

        temp = User.objects.filter(email=postData['email'].lower())
        if len(temp) >= 1:
            errors['email'] = "Email address is already regestered!"

        # Password

        if postData['password'] != postData['confirm_password']:
            errors['password_match'] = "Passwords are not match!"

        if len(postData['password']) < 8:
            errors['password_len'] = "Password should be at least 8 characters"

        return errors


class User(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField()
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()
