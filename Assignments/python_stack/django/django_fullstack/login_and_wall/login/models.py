import re
from django.db import models
from datetime import datetime


# Create your models here.
EMAIL_REGEX = re.compile(
    r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')


class UserManager(models.Manager):
    def validate(self, postData):
        errors = {}
        print(postData)

        '''
        entered_date = datetime.strptime(postData['release_date'], '%Y-%m-%d')
        # Parsing data
        if datetime.now() <= entered_date:
            errors['release_date'] = "Release Date must be in the past"
        '''

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

        # Parsing data
        entered_date = datetime.strptime(
            postData['birthday'], '%Y-%m-%d').date()
        today = datetime.now().date()
        age = today.year - entered_date.year

        if age <= 13:
            errors['age'] = "User have to be at least 13 years old to regester"

        print(age)
        print(today < entered_date)
        print(today - entered_date)
        if today < entered_date:
            errors['birthday'] = "Birthday must be in the past"

        # First name
        if postData['first_name'].isalpha() is False:
            errors['first_name_alpha'] = "First name should be letters only"

        if len(postData['first_name']) < 2:
            errors['first_name'] = "First name should be at least 2 characters"

        # Last name
        if postData['last_name'].isalpha() is False:
            errors['Last_name_alpha'] = "Last name should be letters only"

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

        if postData['password'] != postData['repassword']:
            errors['password'] = "Passwords are not match!"

        return errors


class User(models.Model):
    first_name = models.CharField(max_length=60)
    last_name = models.CharField(max_length=60)
    email = models.EmailField()
    password = models.CharField(max_length=72)

    birthday = models.DateField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = UserManager()
    # def __repr__(self):
