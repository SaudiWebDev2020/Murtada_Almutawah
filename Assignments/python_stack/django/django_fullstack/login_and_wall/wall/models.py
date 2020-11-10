from django.db import models
from login.models import User
from datetime import datetime, timezone
# Create your models here.


class MessageManager(models.Manager):

    def post_validation(self, postData):
        errors = {}
        print(postData)
        if len(postData['message']) < 10:
            errors['message_length'] = "Message should be at least 10 characters if it was presented"

        return errors

    def delete_validation(self, postData):
        errors = {}
        print(postData)

        # Birth Date
        # Parsing data
        entered_date = self.filter(id=postData['message_id'])
        age = datetime.now(timezone.utc) - entered_date[0].created_at
        # print(dir(age))
        # print(age.min)
        # print(int(age.total_seconds() / 60))
        # print(age.minutes)

        agemenate = int(age.total_seconds() / 60)
        print(agemenate)

        if agemenate > 30:
            errors['age'] = "Written message can be deleted within the last 30 minutes"

        return errors


class CommentManager(models.Manager):

    def post_validation(self, postData):
        errors = {}
        # print(postData)
        if len(postData['comment']) < 10:
            errors['comment_length'] = "Comment should be at least 10 characters if it was presented"

        return errors


class Message(models.Model):
    message = models.TextField()
    user = models.ForeignKey(
        User, related_name='message', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = MessageManager()


class Comment(models.Model):
    comment = models.TextField()
    user = models.ForeignKey(
        User, related_name='comment', on_delete=models.CASCADE)
    message = models.ForeignKey(
        Message, related_name='comment', on_delete=models.CASCADE)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

    objects = CommentManager()
